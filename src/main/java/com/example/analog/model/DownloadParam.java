package com.example.analog.model;

import java.sql.Date;
import java.util.ArrayList;

public class DownloadParam {

    //商品id
    private ArrayList<Integer> ids;
    //月份
    private Date pUpdate;
    //出入库
    private String pState;

    public DownloadParam() {

    }

    public DownloadParam(ArrayList<Integer> ids, Date pUpdate, String pState) {
        this.ids = ids;
        this.pUpdate = pUpdate;
        this.pState = pState;
    }

    public ArrayList<Integer> getIds() {
        return ids;
    }

    public void setIds(ArrayList<Integer> ids) {
        this.ids = ids;
    }

    public Date getpUpdate() {
        return pUpdate;
    }

    public void setpUpdate(Date pUpdate) {
        this.pUpdate = pUpdate;
    }

    public String getpState() {
        return pState;
    }

    public void setpState(String pState) {
        this.pState = pState;
    }

    @Override
    public String toString() {
        return "DownloadParam{" +
                "ids=" + ids +
                ", pUpdate=" + pUpdate +
                ", pState='" + pState + '\'' +
                '}';
    }
}
