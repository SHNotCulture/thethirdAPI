package com.api.entity;

import javax.validation.constraints.NotNull;

/**
 * @Author jin
 * @Data 2019/3/25 10:46
 **/
public class DataVActionReq {
    @NotNull(message = "方法必填")
    private String service;
    private String parkId;
    private String key;
    private String ID;
    private Integer type;//0 为全国 1为贵州

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }
}
