package cn.mrdear.dataobject;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import java.util.Date;

/**
* A data object class directly models database table
* table:user_auth
* comment: 用户授权表
* @author dalgen
* @since Sun Jan 20 15:30:21 CST 2019
*/
public class UserAuthDO {

    //========== properties ==========

    /**
    * column: <tt>id</tt>.
    * comment: <tt>${column.comment}</tt>.
    */
    private Long id;

    /**
    * column: <tt>uid</tt>.
    * comment: <tt>用户id</tt>.
    */
    private Long uid;

    /**
    * column: <tt>identity_type</tt>.
    * comment: <tt>授权类型</tt>.
    */
    private Integer identityType;

    /**
    * column: <tt>identifier</tt>.
    * comment: <tt>授权标识id</tt>.
    */
    private String identifier;

    /**
    * column: <tt>credential</tt>.
    * comment: <tt>授权秘钥或token</tt>.
    */
    private String credential;

    /**
    * column: <tt>credential_expire</tt>.
    * comment: <tt>token过期时间</tt>.
    */
    private java.util.Date credentialExpire;

    /**
    * column: <tt>status</tt>.
    * comment: <tt>状态字段</tt>.
    */
    private Integer status;

    /**
    * column: <tt>gmt_create</tt>.
    * comment: <tt>创建时间</tt>.
    */
    private java.util.Date gmtCreate;

    /**
    * column: <tt>gmt_update</tt>.
    * comment: <tt>更新时间</tt>.
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
    * Getter method for property <tt>uid</tt>.
    *
    * @return property value of uid
    */
    public Long getUid() {
        return uid;
    }

    /**
    * Setter method for property <tt>uid</tt>.
    *
    * @param uid value to be assigned to property uid
    */
    public void setUid(Long uid) {
        this.uid = uid;
    }
    /**
    * Getter method for property <tt>identityType</tt>.
    *
    * @return property value of identityType
    */
    public Integer getIdentityType() {
        return identityType;
    }

    /**
    * Setter method for property <tt>identityType</tt>.
    *
    * @param identityType value to be assigned to property identityType
    */
    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }
    /**
    * Getter method for property <tt>identifier</tt>.
    *
    * @return property value of identifier
    */
    public String getIdentifier() {
        return identifier;
    }

    /**
    * Setter method for property <tt>identifier</tt>.
    *
    * @param identifier value to be assigned to property identifier
    */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    /**
    * Getter method for property <tt>credential</tt>.
    *
    * @return property value of credential
    */
    public String getCredential() {
        return credential;
    }

    /**
    * Setter method for property <tt>credential</tt>.
    *
    * @param credential value to be assigned to property credential
    */
    public void setCredential(String credential) {
        this.credential = credential;
    }
    /**
    * Getter method for property <tt>credentialExpire</tt>.
    *
    * @return property value of credentialExpire
    */
    public java.util.Date getCredentialExpire() {
        return credentialExpire;
    }

    /**
    * Setter method for property <tt>credentialExpire</tt>.
    *
    * @param credentialExpire value to be assigned to property credentialExpire
    */
    public void setCredentialExpire(java.util.Date credentialExpire) {
        this.credentialExpire = credentialExpire;
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

