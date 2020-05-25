package com.api.entity;

/**
 * @Author jin
 * @Data 2019/4/27 21:38
 **/
public class BusineCouponGetTicketInfo {
    private Integer companyId;
    private Integer parkId;
    private Integer busineId;
    private Integer ticketId;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Integer getBusineId() {
        return busineId;
    }

    public void setBusineId(Integer busineId) {
        this.busineId = busineId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }
}
