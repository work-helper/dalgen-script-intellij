import com.intellij.database.model.DasTable
import com.intellij.database.util.Case
import com.intellij.database.util.DasUtil
import org.apache.commons.io.FileUtils
import org.apache.velocity.VelocityContext
import org.apache.velocity.app.Velocity

/*
 * Available context bindings:
 *   SELECTION   Iterable<DasObject>
 *   PROJECT     project
 *   FILES       files helper
 */
// 对应模板的位置
templateDir = PROJECT.basePath + "/dalgen/templates/"

// 所选择的目录
dir = null

/**
 * 选择对应的目标文件夹
 */
FILES.chooseDirectoryAndSave("Choose directory", "Choose where to store generated files") { dir ->
    this.dir = dir
    SELECTION.filter { it instanceof DasTable }.each { generate(it, dir) }
}


def generate(table, dir) {
    context = buildCommonContext(table)

    // 生成pojo
    def pojoParams = POJO(table, context)
    context.put("POJO", pojoParams)

    // 生成dao
    def daoParams = DAO(table, context)
    context.put("DAO", daoParams)

    // 生成mapper.xml
    MAPXML(table, context)

}

// ------------- 生成方法
/**
 * 生成POJO
 */
def POJO(table, commonContext) {
    localPackage = "dataobject"
    templateName = "POJO.vm"

    // 设置参数
    context = new VelocityContext(commonContext as VelocityContext)
    context.put("simpleClassName", javaName(table.name, true) + 'DO')
    context.put("package", context.rootPackage + '.' + localPackage)
    context.put("fileName", context.simpleClassName + ".java")

    // 生成文件
    generateFile(localPackage, templateName)

    // 返回信息
    [
            "fullClassName"  : context.package + '.' + context.simpleClassName,
            "simpleClassName": context.simpleClassName,
            "package"        : context.package
    ]
}

/**
 * 生成DAO
 */
def DAO(table, commonContext) {
    localPackage = "dao"
    templateName = "DAO.vm"

    context = new VelocityContext(commonContext as VelocityContext)
    context.put("simpleClassName", javaName(table.name, true) + 'DAO')
    context.put("package", context.rootPackage + '.' + localPackage)
    context.put("fileName", context.simpleClassName + '.java')

    // 生成文件
    generateFile(localPackage, templateName)

    // 返回信息
    [
            "fullClassName"  : context.package + '.' + context.simpleClassName,
            "simpleClassName": context.simpleClassName,
            "package"        : context.package
    ]
}

/**
 * 生成mapper.xml
 */
def MAPXML(table, commonContext) {
    localPackage = "dataobject"
    templateName = "MAPPER.vm"

    context = new VelocityContext(commonContext as VelocityContext)
    context.put("fileName", context.POJO.simpleClassName + '.xml')

    // 生成文件
    generateFile(localPackage, templateName)
}


def generateFile(localPackage, templateName) {
    template = FileUtils.readFileToString(new File(templateDir + templateName))

    StringWriter writer = new StringWriter()
    Velocity.evaluate(context as VelocityContext, writer, "", template.replaceAll("[ ]*" +
            "(#if|#else|#elseif|#end|#set|#foreach)", "\$1"))

    def pojoDir = new File(dir.toString() + File.separator + localPackage)
    if (!pojoDir.exists()) {
        pojoDir.mkdir()
    }
    new File(pojoDir, context.fileName)
            .withPrintWriter { out -> out.println(writer.toString()) }
}

// ------------- 工具方法

/**
 * 构造公共context
 * @param table
 * @param dir
 * @return
 */
def buildCommonContext(table) {
    map = [
            "author"     : "dalgen",
            "now"        : new Date(),
            "rootPackage": mappingDirToPackageRoot(dir),
            "table"      : [
                    "name"   : table.name,
                    "comment": table.comment,
                    "columns": calcFields(table)
            ]
    ]

    return new VelocityContext(map)
}

/**
 * 获取包名称
 * @param dir 实体类所在目录
 * @return
 */
static def mappingDirToPackageRoot(dir) {
    def target = dir.toString().replaceAll("/", ".")
            .replaceAll("^.*src(\\.main\\.java\\.)?", "")
    return target.charAt(0) != (char) '.' ? target : target.substring(1)
}

/**
 * 拿到一张表对应的所有的字段,并且扩充模型
 * @param table 数据库表
 * @return 字段Object
 */
static def calcFields(table) {
    DasUtil.getColumns(table).reduce([]) { fields, col ->
        fields += [
                jdbcName              : col.getName(),
                jdbcType              : Case.LOWER.apply(col.getDataType().getSpecification()),
                variableName          : javaName(col.getName(), false),
                capitalizeVariableName: javaName(col.getName(), true),
                javaType              : javaType(col.getDataType()),
                mybatisType           : mybatisType(col.getDataType()),
                comment               : col.getComment()
        ]
    }
}

/**
 * 获取字段对应Java变量名称
 */
static def javaName(str, capitalize) {
    def s = str.split(/(?<=[^\p{IsLetter}])/).collect { Case.LOWER.apply(it).capitalize() }
            .join("").replaceAll("_", "")
    capitalize || s.length() == 1 ? s : Case.LOWER.apply(s[0]) + s[1..-1]
}


static def mybatisType(dataType) {
    switch (dataType.typeName) {
        case "int":
            return "INTEGER"
        case "text":
            return "LONGVARBINARY"
        case "datetime":
            return "TIMESTAMP"
        default:
            return Case.UPPER.apply(dataType.typeName)

    }
}

static def javaType(dataType) {
    switch (dataType.typeName) {
        case "tinyint":
        case "smallint":
            return "Integer"

        case "bigint":
            return "Long"

        case "int":
            return dataType.getLength() > 10 ? "Long" : "Integer"

        case "float":
        case "double":
        case "decimal":
        case "real":
            return "Double"

        case "date":
        case "datetime":
        case "timestamp":
            return "java.util.Date"

        case "time":
            return "java.sql.Time"

        default:
            return "String"

    }

}
