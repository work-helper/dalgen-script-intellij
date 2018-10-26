## dalgen

依托于IDEA database所提供的`Scripted Extensions`功能,所写的代码生成脚本.
总体逻辑很简单,获取IDEA提供的表结构,然后填充一些模板需要的信息,定位到具体的velocity模板,渲染,写回文件.

## 使用介绍

使用前建议先看看脚本代码,groovy不是很熟,所以还是用Java风格来写的,很容易看懂

1. copy脚本到IDEA执行的位置`Scratches and Consoles -> Extensions -> Database Tools and SQL -> schema`中.

![](http://imgblog.mrdear.cn/1540563274.png?imageMogr2/thumbnail/!100p)


2. 在database tools中选择对应的表,右键执行该脚本

![](http://imgblog.mrdear.cn/1540563321.png?imageMogr2/thumbnail/!100p)


3. 在弹出来的文件选择框中选择目标地址(文件生成地址)即可生成.

![](http://imgblog.mrdear.cn/1540563345.png?imageMogr2/thumbnail/!100p)

整个流程简单又不失灵活,脚本自定义,模板自定义,根据项目的不同可以很容易的产出各种模板.


## 备注
由于脚本的限制,该方案只能一次生成,第二次生成就会被覆盖掉,目前没有特别好的方案,可以手动与IntelliJ的history来进行比较,然后合并.
目前有个想法是提供IntelliJ的插件来完成脚本执行,生成临时文件,调用IntelliJ的API进行merge,遇到冲突再弹出Diff窗口进行比较,手工合并,这样的话整个流程就比较流畅了,
希望以后能实现.