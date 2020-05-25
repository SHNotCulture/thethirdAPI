package com.api.entity;

import java.util.Date;

public class CarEntry {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_entry.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_entry.member_id
     *
     * @mbg.generated
     */
    private String memberId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_entry.park_id
     *
     * @mbg.generated
     */
    private Integer parkId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_entry.company_id
     *
     * @mbg.generated
     */
    private Integer companyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_entry.car_plate
     *
     * @mbg.generated
     */
    private String carPlate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_entry.driver_card_img
     *
     * @mbg.generated
     */
    private String driverCardImg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_entry.car_card_img
     *
     * @mbg.generated
     */
    private String carCardImg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_entry.entry_time
     *
     * @mbg.generated
     */
    private Date entryTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_entry.check_flog
     *
     * @mbg.generated
     */
    private Integer checkFlog;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_entry.dismiss
     *
     * @mbg.generated
     */
    private String dismiss;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_entry.level
     *
     * @mbg.generated
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_entry.check_userid
     *
     * @mbg.generated
     */
    private Integer checkUserid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car_entry.checktime
     *
     * @mbg.generated
     */
    private Date checktime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_entry.id
     *
     * @return the value of car_entry.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_entry.id
     *
     * @param id the value for car_entry.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_entry.member_id
     *
     * @return the value of car_entry.member_id
     *
     * @mbg.generated
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_entry.member_id
     *
     * @param memberId the value for car_entry.member_id
     *
     * @mbg.generated
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_entry.park_id
     *
     * @return the value of car_entry.park_id
     *
     * @mbg.generated
     */
    public Integer getParkId() {
        return parkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_entry.park_id
     *
     * @param parkId the value for car_entry.park_id
     *
     * @mbg.generated
     */
    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_entry.company_id
     *
     * @return the value of car_entry.company_id
     *
     * @mbg.generated
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_entry.company_id
     *
     * @param companyId the value for car_entry.company_id
     *
     * @mbg.generated
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_entry.car_plate
     *
     * @return the value of car_entry.car_plate
     *
     * @mbg.generated
     */
    public String getCarPlate() {
        return carPlate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_entry.car_plate
     *
     * @param carPlate the value for car_entry.car_plate
     *
     * @mbg.generated
     */
    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate == null ? null : carPlate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_entry.driver_card_img
     *
     * @return the value of car_entry.driver_card_img
     *
     * @mbg.generated
     */
    public String getDriverCardImg() {
        return driverCardImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_entry.driver_card_img
     *
     * @param driverCardImg the value for car_entry.driver_card_img
     *
     * @mbg.generated
     */
    public void setDriverCardImg(String driverCardImg) {
        this.driverCardImg = driverCardImg == null ? null : driverCardImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_entry.car_card_img
     *
     * @return the value of car_entry.car_card_img
     *
     * @mbg.generated
     */
    public String getCarCardImg() {
        return carCardImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_entry.car_card_img
     *
     * @param carCardImg the value for car_entry.car_card_img
     *
     * @mbg.generated
     */
    public void setCarCardImg(String carCardImg) {
        this.carCardImg = carCardImg == null ? null : carCardImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_entry.entry_time
     *
     * @return the value of car_entry.entry_time
     *
     * @mbg.generated
     */
    public Date getEntryTime() {
        return entryTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_entry.entry_time
     *
     * @param entryTime the value for car_entry.entry_time
     *
     * @mbg.generated
     */
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_entry.check_flog
     *
     * @return the value of car_entry.check_flog
     *
     * @mbg.generated
     */
    public Integer getCheckFlog() {
        return checkFlog;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_entry.check_flog
     *
     * @param checkFlog the value for car_entry.check_flog
     *
     * @mbg.generated
     */
    public void setCheckFlog(Integer checkFlog) {
        this.checkFlog = checkFlog;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_entry.dismiss
     *
     * @return the value of car_entry.dismiss
     *
     * @mbg.generated
     */
    public String getDismiss() {
        return dismiss;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_entry.dismiss
     *
     * @param dismiss the value for car_entry.dismiss
     *
     * @mbg.generated
     */
    public void setDismiss(String dismiss) {
        this.dismiss = dismiss == null ? null : dismiss.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_entry.level
     *
     * @return the value of car_entry.level
     *
     * @mbg.generated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_entry.level
     *
     * @param level the value for car_entry.level
     *
     * @mbg.generated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_entry.check_userid
     *
     * @return the value of car_entry.check_userid
     *
     * @mbg.generated
     */
    public Integer getCheckUserid() {
        return checkUserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_entry.check_userid
     *
     * @param checkUserid the value for car_entry.check_userid
     *
     * @mbg.generated
     */
    public void setCheckUserid(Integer checkUserid) {
        this.checkUserid = checkUserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car_entry.checktime
     *
     * @return the value of car_entry.checktime
     *
     * @mbg.generated
     */
    public Date getChecktime() {
        return checktime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car_entry.checktime
     *
     * @param checktime the value for car_entry.checktime
     *
     * @mbg.generated
     */
    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }
}