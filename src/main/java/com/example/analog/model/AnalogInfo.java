package com.example.analog.model;

import java.math.BigInteger;
import java.sql.Date;

public class AnalogInfo {

    //id
    private BigInteger id;
    //name_china
    private String nameChina;
    //name_english
    private String nameEnglish;
    //path
    private String path;
    //RETURN
    private String returnCode;
    //create_date
    private Date createDate;
    //create_user
    private String createUser;
    //update_date
    private Date updateDate;
    //update_user
    private String updateUser;

    public AnalogInfo() {
    }

    public AnalogInfo(BigInteger id, String nameChina, String nameEnglish, String path, String returnCode, Date createDate, String createUser, Date updateDate, String updateUser) {
        this.id = id;
        this.nameChina = nameChina;
        this.nameEnglish = nameEnglish;
        this.path = path;
        this.returnCode = returnCode;
        this.createDate = createDate;
        this.createUser = createUser;
        this.updateDate = updateDate;
        this.updateUser = updateUser;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNameChina() {
        return nameChina;
    }

    public void setNameChina(String nameChina) {
        this.nameChina = nameChina;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "AnalogInfo{" +
                "id=" + id +
                ", nameChina='" + nameChina + '\'' +
                ", nameEnglish='" + nameEnglish + '\'' +
                ", path='" + path + '\'' +
                ", returnCode='" + returnCode + '\'' +
                ", createDate=" + createDate +
                ", createUser='" + createUser + '\'' +
                ", updateDate=" + updateDate +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }
}
