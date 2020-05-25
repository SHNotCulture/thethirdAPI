package com.api.entity;

public class GovCompanyPark {
    private Integer id;
    private String address;
    private String parkName;
    private String positionX;
    private String positionY;
    private Integer totalParkingSpace;//总车位数
    private Integer inTempcars;//在场临时车
    private Integer inFixlotsCars;//在场车场固定车数
    private Integer inFixprivateCars;//在场个人固定车数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getPositionX() {
        return positionX;
    }

    public void setPositionX(String positionX) {
        this.positionX = positionX;
    }

    public String getPositionY() {
        return positionY;
    }

    public void setPositionY(String positionY) {
        this.positionY = positionY;
    }

    public Integer getTotalParkingSpace() {
        return totalParkingSpace;
    }

    public void setTotalParkingSpace(Integer totalParkingSpace) {
        this.totalParkingSpace = totalParkingSpace;
    }

    public Integer getInTempcars() {
        return inTempcars;
    }

    public void setInTempcars(Integer inTempcars) {
        this.inTempcars = inTempcars;
    }

    public Integer getInFixlotsCars() {
        return inFixlotsCars;
    }

    public void setInFixlotsCars(Integer inFixlotsCars) {
        this.inFixlotsCars = inFixlotsCars;
    }

    public Integer getInFixprivateCars() {
        return inFixprivateCars;
    }

    public void setInFixprivateCars(Integer inFixprivateCars) {
        this.inFixprivateCars = inFixprivateCars;
    }
}
