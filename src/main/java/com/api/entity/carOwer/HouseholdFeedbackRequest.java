package com.api.entity.carOwer;

public class HouseholdFeedbackRequest {
    private Integer companyId;
    private Integer parkId;
    private Integer memberId;
    private String name;
    private String content;

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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HouseholdFeedbackRequest{" +
                "companyId=" + companyId +
                ", parkId=" + parkId +
                ", memberId=" + memberId +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
