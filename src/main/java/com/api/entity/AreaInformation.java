package com.api.entity;

import java.util.Date;

public class AreaInformation {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area_information.Area_ID
     *
     * @mbg.generated
     */
    private Integer areaId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area_information.Area_Name
     *
     * @mbg.generated
     */
    private String areaName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area_information.CreateTime
     *
     * @mbg.generated
     */
    private Date createtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area_information.City_ID
     *
     * @mbg.generated
     */
    private Integer cityId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area_information.Area_ID
     *
     * @return the value of area_information.Area_ID
     *
     * @mbg.generated
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area_information.Area_ID
     *
     * @param areaId the value for area_information.Area_ID
     *
     * @mbg.generated
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area_information.Area_Name
     *
     * @return the value of area_information.Area_Name
     *
     * @mbg.generated
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area_information.Area_Name
     *
     * @param areaName the value for area_information.Area_Name
     *
     * @mbg.generated
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area_information.CreateTime
     *
     * @return the value of area_information.CreateTime
     *
     * @mbg.generated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area_information.CreateTime
     *
     * @param createtime the value for area_information.CreateTime
     *
     * @mbg.generated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area_information.City_ID
     *
     * @return the value of area_information.City_ID
     *
     * @mbg.generated
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area_information.City_ID
     *
     * @param cityId the value for area_information.City_ID
     *
     * @mbg.generated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}