package com.api.entity;

public class CloudData {
    private String billNo;
    private String orderId;
    private String carNo;
    private String parkName;
    private String parkId;
    private String parkingId;
    private String exitWayName;
    private String exitTime;
    private String totalPrice;
    private String rightsType;
    private String payType;
    private String rightsPrice;
    private String balance;
    private String settleDate;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public String getExitWayName() {
        return exitWayName;
    }

    public void setExitWayName(String exitWayName) {
        this.exitWayName = exitWayName;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRightsType() {
        return rightsType;
    }

    public void setRightsType(String rightsType) {
        this.rightsType = rightsType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getRightsPrice() {
        return rightsPrice;
    }

    public void setRightsPrice(String rightsPrice) {
        this.rightsPrice = rightsPrice;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    @Override
    public String toString() {
        return "CloudData{" +
                "billNo='" + billNo + '\'' +
                ", orderId='" + orderId + '\'' +
                ", carNo='" + carNo + '\'' +
                ", parkName='" + parkName + '\'' +
                ", parkId='" + parkId + '\'' +
                ", parkingId='" + parkingId + '\'' +
                ", exitWayName='" + exitWayName + '\'' +
                ", exitTime='" + exitTime + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", rightsType='" + rightsType + '\'' +
                ", payType='" + payType + '\'' +
                ", rightsPrice='" + rightsPrice + '\'' +
                ", balance='" + balance + '\'' +
                ", settleDate='" + settleDate + '\'' +
                '}';
    }
}
