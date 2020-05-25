package com.api.entity.carOwer;

public class HouseholdBillRequest {
    private  Integer billitemId;
    private  String billitemName;
    private  String billSn;
    private  Integer companyId;
    private  String companyName;
    private  Integer parkId;
    private  String parkName;
    private  Integer memberId;
    private  String householdName;
    private  String phoneNumber;
    private  Double needPay;
    private  Double actualPay;
    private  String orderId;
    private  Integer payType;
    private  String updateTime;

    public Integer getBillitemId() {
        return billitemId;
    }

    public void setBillitemId(Integer billitemId) {
        this.billitemId = billitemId;
    }

    public String getBillitemName() {
        return billitemName;
    }

    public void setBillitemName(String billitemName) {
        this.billitemName = billitemName;
    }

    public String getBillSn() {
        return billSn;
    }

    public void setBillSn(String billSn) {
        this.billSn = billSn;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getNeedPay() {
        return needPay;
    }

    public void setNeedPay(Double needPay) {
        this.needPay = needPay;
    }

    public Double getActualPay() {
        return actualPay;
    }

    public void setActualPay(Double actualPay) {
        this.actualPay = actualPay;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "HouseholdBillRequest{" +
                "billitemId=" + billitemId +
                ", billitemName='" + billitemName + '\'' +
                ", billSn='" + billSn + '\'' +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", parkId=" + parkId +
                ", parkName='" + parkName + '\'' +
                ", memberId=" + memberId +
                ", householdName='" + householdName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", needPay=" + needPay +
                ", actualPay=" + actualPay +
                ", orderId='" + orderId + '\'' +
                ", payType=" + payType +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
