package com.api.entity;

public class TDatavRequest {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_datav_request.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_datav_request.park_id
     *
     * @mbg.generated
     */
    private String parkId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_datav_request.create_time
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_datav_request.id
     *
     * @return the value of t_datav_request.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_datav_request.id
     *
     * @param id the value for t_datav_request.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_datav_request.park_id
     *
     * @return the value of t_datav_request.park_id
     *
     * @mbg.generated
     */
    public String getParkId() {
        return parkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_datav_request.park_id
     *
     * @param parkId the value for t_datav_request.park_id
     *
     * @mbg.generated
     */
    public void setParkId(String parkId) {
        this.parkId = parkId == null ? null : parkId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_datav_request.create_time
     *
     * @return the value of t_datav_request.create_time
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_datav_request.create_time
     *
     * @param createTime the value for t_datav_request.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}