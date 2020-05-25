package com.api.entity;

public class TBusinePay {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_busine_pay.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_busine_pay.company_id
     *
     * @mbg.generated
     */
    private Integer companyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_busine_pay.busine_id
     *
     * @mbg.generated
     */
    private Integer busineId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_busine_pay.busine_name
     *
     * @mbg.generated
     */
    private String busineName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_busine_pay.park_id
     *
     * @mbg.generated
     */
    private Integer parkId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_busine_pay.need_pay
     *
     * @mbg.generated
     */
    private Double needPay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_busine_pay.actual_pay
     *
     * @mbg.generated
     */
    private Double actualPay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_busine_pay.balance
     *
     * @mbg.generated
     */
    private Double balance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_busine_pay.pay_time
     *
     * @mbg.generated
     */
    private String payTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_busine_pay.order_number
     *
     * @mbg.generated
     */
    private String orderNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_busine_pay.busine_status
     *
     * @mbg.generated
     */
    private Integer busineStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_busine_pay.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_busine_pay.park_name
     *
     * @mbg.generated
     */
    private String parkName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_busine_pay.id
     *
     * @return the value of t_busine_pay.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_busine_pay.id
     *
     * @param id the value for t_busine_pay.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_busine_pay.company_id
     *
     * @return the value of t_busine_pay.company_id
     *
     * @mbg.generated
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_busine_pay.company_id
     *
     * @param companyId the value for t_busine_pay.company_id
     *
     * @mbg.generated
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_busine_pay.busine_id
     *
     * @return the value of t_busine_pay.busine_id
     *
     * @mbg.generated
     */
    public Integer getBusineId() {
        return busineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_busine_pay.busine_id
     *
     * @param busineId the value for t_busine_pay.busine_id
     *
     * @mbg.generated
     */
    public void setBusineId(Integer busineId) {
        this.busineId = busineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_busine_pay.busine_name
     *
     * @return the value of t_busine_pay.busine_name
     *
     * @mbg.generated
     */
    public String getBusineName() {
        return busineName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_busine_pay.busine_name
     *
     * @param busineName the value for t_busine_pay.busine_name
     *
     * @mbg.generated
     */
    public void setBusineName(String busineName) {
        this.busineName = busineName == null ? null : busineName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_busine_pay.park_id
     *
     * @return the value of t_busine_pay.park_id
     *
     * @mbg.generated
     */
    public Integer getParkId() {
        return parkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_busine_pay.park_id
     *
     * @param parkId the value for t_busine_pay.park_id
     *
     * @mbg.generated
     */
    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_busine_pay.need_pay
     *
     * @return the value of t_busine_pay.need_pay
     *
     * @mbg.generated
     */
    public Double getNeedPay() {
        return needPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_busine_pay.need_pay
     *
     * @param needPay the value for t_busine_pay.need_pay
     *
     * @mbg.generated
     */
    public void setNeedPay(Double needPay) {
        this.needPay = needPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_busine_pay.actual_pay
     *
     * @return the value of t_busine_pay.actual_pay
     *
     * @mbg.generated
     */
    public Double getActualPay() {
        return actualPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_busine_pay.actual_pay
     *
     * @param actualPay the value for t_busine_pay.actual_pay
     *
     * @mbg.generated
     */
    public void setActualPay(Double actualPay) {
        this.actualPay = actualPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_busine_pay.balance
     *
     * @return the value of t_busine_pay.balance
     *
     * @mbg.generated
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_busine_pay.balance
     *
     * @param balance the value for t_busine_pay.balance
     *
     * @mbg.generated
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_busine_pay.pay_time
     *
     * @return the value of t_busine_pay.pay_time
     *
     * @mbg.generated
     */
    public String getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_busine_pay.pay_time
     *
     * @param payTime the value for t_busine_pay.pay_time
     *
     * @mbg.generated
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime == null ? null : payTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_busine_pay.order_number
     *
     * @return the value of t_busine_pay.order_number
     *
     * @mbg.generated
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_busine_pay.order_number
     *
     * @param orderNumber the value for t_busine_pay.order_number
     *
     * @mbg.generated
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_busine_pay.busine_status
     *
     * @return the value of t_busine_pay.busine_status
     *
     * @mbg.generated
     */
    public Integer getBusineStatus() {
        return busineStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_busine_pay.busine_status
     *
     * @param busineStatus the value for t_busine_pay.busine_status
     *
     * @mbg.generated
     */
    public void setBusineStatus(Integer busineStatus) {
        this.busineStatus = busineStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_busine_pay.remark
     *
     * @return the value of t_busine_pay.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_busine_pay.remark
     *
     * @param remark the value for t_busine_pay.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_busine_pay.park_name
     *
     * @return the value of t_busine_pay.park_name
     *
     * @mbg.generated
     */
    public String getParkName() {
        return parkName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_busine_pay.park_name
     *
     * @param parkName the value for t_busine_pay.park_name
     *
     * @mbg.generated
     */
    public void setParkName(String parkName) {
        this.parkName = parkName == null ? null : parkName.trim();
    }
}