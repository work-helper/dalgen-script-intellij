package cn.mrdear.dao;

import org.apache.ibatis.annotations.Mapper;
import cn.mrdear.dataobject.UserAuthDO;


/**
* @author dalgen
* @since Fri Oct 26 22:12:54 CST 2018
*/
@Mapper
public interface UserAuthDAO {

    /**
    * 创建实体
    * @param insertDO 实体类
    * @return true成功,主键自动设置到实体中
    */
    boolean insert(UserAuthDO insertDO);

}
