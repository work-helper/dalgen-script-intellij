package cn.mrdear.dataobject;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import java.util.Date;

/**
* A data object class directly models database table
* table:user
* comment: ${table.comment}
* @author dalgen
* @since Sun Jan 20 15:30:21 CST 2019
*/
public class UserDO {

    //========== properties ==========

    /**
    * column: <tt>id</tt>.
    * comment: <tt>${column.comment}</tt>.
    */
    private Long id;

    /**
    * column: <tt>username</tt>.
    * comment: <tt>用户名</tt>.
    */
    private String username;

    /**
    * column: <tt>email</tt>.
    * comment: <tt>邮箱</tt>.
    */
    private String email;

    /**
    * column: <tt>phone</tt>.
    * comment: <tt>用户手机号</tt>.
    */
    private String phone;

    /**
    * column: <tt>avatar</tt>.
    * comment: <tt>头像</tt>.
    */
    private String avatar;

    /**
    * column: <tt>status</tt>.
    * comment: <tt>状态</tt>.
    */
    private Integer status;

    /**
    * column: <tt>role</tt>.
    * comment: <tt>角色</tt>.
    */
    private String role;

    /**
    * column: <tt>gmt_create</tt>.
    * comment: <tt>${column.comment}</tt>.
    */
    private java.util.Date gmtCreate;

    /**
    * column: <tt>gmt_update</tt>.
    * comment: <tt>${column.comment}</tt>.
    */
    private java.util.Date gmtUpdate;

//========== getters and setters ==========
    /**
    * Getter method for property <tt>id</tt>.
    *
    * @return property value of id
    */
    public Long getId() {
        return id;
    }

    /**
    * Setter method for property <tt>id</tt>.
    *
    * @param id value to be assigned to property id
    */
    public void setId(Long id) {
        this.id = id;
    }
    /**
    * Getter method for property <tt>username</tt>.
    *
    * @return property value of username
    */
    public String getUsername() {
        return username;
    }

    /**
    * Setter method for property <tt>username</tt>.
    *
    * @param username value to be assigned to property username
    */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
    * Getter method for property <tt>email</tt>.
    *
    * @return property value of email
    */
    public String getEmail() {
        return email;
    }

    /**
    * Setter method for property <tt>email</tt>.
    *
    * @param email value to be assigned to property email
    */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
    * Getter method for property <tt>phone</tt>.
    *
    * @return property value of phone
    */
    public String getPhone() {
        return phone;
    }

    /**
    * Setter method for property <tt>phone</tt>.
    *
    * @param phone value to be assigned to property phone
    */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
    * Getter method for property <tt>avatar</tt>.
    *
    * @return property value of avatar
    */
    public String getAvatar() {
        return avatar;
    }

    /**
    * Setter method for property <tt>avatar</tt>.
    *
    * @param avatar value to be assigned to property avatar
    */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    /**
    * Getter method for property <tt>status</tt>.
    *
    * @return property value of status
    */
    public Integer getStatus() {
        return status;
    }

    /**
    * Setter method for property <tt>status</tt>.
    *
    * @param status value to be assigned to property status
    */
    public void setStatus(Integer status) {
        this.status = status;
    }
    /**
    * Getter method for property <tt>role</tt>.
    *
    * @return property value of role
    */
    public String getRole() {
        return role;
    }

    /**
    * Setter method for property <tt>role</tt>.
    *
    * @param role value to be assigned to property role
    */
    public void setRole(String role) {
        this.role = role;
    }
    /**
    * Getter method for property <tt>gmtCreate</tt>.
    *
    * @return property value of gmtCreate
    */
    public java.util.Date getGmtCreate() {
        return gmtCreate;
    }

    /**
    * Setter method for property <tt>gmtCreate</tt>.
    *
    * @param gmtCreate value to be assigned to property gmtCreate
    */
    public void setGmtCreate(java.util.Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    /**
    * Getter method for property <tt>gmtUpdate</tt>.
    *
    * @return property value of gmtUpdate
    */
    public java.util.Date getGmtUpdate() {
        return gmtUpdate;
    }

    /**
    * Setter method for property <tt>gmtUpdate</tt>.
    *
    * @param gmtUpdate value to be assigned to property gmtUpdate
    */
    public void setGmtUpdate(java.util.Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    /**
    * @see java.lang.Object#toString()
    */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

