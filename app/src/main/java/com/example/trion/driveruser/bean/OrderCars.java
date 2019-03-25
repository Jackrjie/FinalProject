package com.example.trion.driveruser.bean;

/**
 * Created by trion on 12/15/2017.
 */

public class OrderCars {

    private String myOrderID;
    private String myStatus;
    private String myDate;
    private String mySAdd;
    private String myEAdd;

    public OrderCars(String myOrderID, String myStatus, String myDate, String mySAdd, String myEAdd)
    {
        this.setMyOrderID(myOrderID);
        this.setMyStatus(myStatus);
        this.setMyDate(myDate);
        this.setMySAdd(mySAdd);
        this.setMyEAdd(myEAdd);
    }

    public String getMyOrderID(){
        return myOrderID;
    }

    public String getMyStatus(){
        return myStatus;
    }

    public String getMyDate(){
        return myDate;
    }

    public String getMySAdd(){
        return mySAdd;
    }

    public String getMyEAdd(){
        return myEAdd;
    }

    public void setMyOrderID(String myOrderID){
        this.myOrderID = myOrderID;
    }

    public void setMyStatus(String myStatus){
        this.myStatus = myStatus;
    }

    public void setMyDate(String myDate){
        this.myDate = myDate;
    }

    public void setMySAdd(String mySAdd){
        this.mySAdd = mySAdd;
    }

    public void setMyEAdd(String myEAdd){
        this.myEAdd = myEAdd;
    }



}
