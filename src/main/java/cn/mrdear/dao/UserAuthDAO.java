package cn.mrdear.dao;

import org.apache.ibatis.annotations.Mapper;
import cn.mrdear.dataobject.UserAuthDO;
import java.util.Collection;
import java.util.List;


/**
* @author dalgen
* @since Sun Jan 20 15:30:21 CST 2019
*/
@Mapper
public interface UserAuthDAO {

    /**
    * 创建实体
    * @param doEntity 实体类
    * @return 影响行数,主键自动设置到实体中
    */
    int insertNotNull(UserAuthDO doEntity);

    /**
    * 更新实体
    * @param doEntity 实体类
    * @return 影响行数
    */
    int updateNotNull(UserAuthDO doEntity);

    /**
    * 根据id查找对应的实体
    * @param id 实体标识
    * @return 查找结果
    */
    UserAuthDO findById(Long id);

    /**
    * 根据id集合批量查找对应的实体
    * @param ids 实体id集合
    * @return 查找结果
    */
    List<UserAuthDO> queryByIds(Collection<Long> ids);

}
