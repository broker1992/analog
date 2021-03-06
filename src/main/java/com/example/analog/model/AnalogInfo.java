package com.example.analog.model;

import com.alibaba.fastjson.annotation.JSONField;

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
    @JSONField(format = "yyyy-MM-dd")
    private Date createDate;
    //create_user
    private String createUser;
    //update_date
    @JSONField(format = "yyyy-MM-dd")
    private Date updateDate;
    //update_user
    private String updateUser;
    //status
    private Integer status;
    //error1
    private String error1;
    //error2
    private String error2;
    //error3
    private String error3;



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

    public AnalogInfo(BigInteger id, String nameChina, String nameEnglish, String path, String returnCode, Date createDate, String createUser, Date updateDate, String updateUser, Integer status, String error1, String error2, String error3) {
        this.id = id;
        this.nameChina = nameChina;
        this.nameEnglish = nameEnglish;
        this.path = path;
        this.returnCode = returnCode;
        this.createDate = createDate;
        this.createUser = createUser;
        this.updateDate = updateDate;
        this.updateUser = updateUser;
        this.status = status;
        this.error1 = error1;
        this.error2 = error2;
        this.error3 = error3;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError1() {
        return error1;
    }

    public void setError1(String error1) {
        this.error1 = error1;
    }

    public String getError2() {
        return error2;
    }

    public void setError2(String error2) {
        this.error2 = error2;
    }

    public String getError3() {
        return error3;
    }

    public void setError3(String error3) {
        this.error3 = error3;
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
