package com.example.trion.driveruser.bean;

/**
 * Created by trion on 12/17/2017.
 */

public class Goods {

    private String gID;
    private String gNum;
    private String gSAdd;

    public Goods (String gID,String gNum,String gSAdd)
    {
        this.setgID(gID);
        this.setgNum(gNum);
        this.setgSAdd(gSAdd);
    }

    public String getgID() {
        return gID;
    }

    public void setgID(String gID) {
        this.gID = gID;
    }

    public String getgNum() {
        return gNum;
    }

    public void setgNum(String gNum) {
        this.gNum = gNum;
    }

    public String getgSAdd() {
        return gSAdd;
    }

    public void setgSAdd(String gSAdd) {
        this.gSAdd = gSAdd;
    }
}
