package com.api.entity;

public class UidPhone {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uid_phone.Id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uid_phone.uid
     *
     * @mbg.generated
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column uid_phone.phone
     *
     * @mbg.generated
     */
    private String phone;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uid_phone.Id
     *
     * @return the value of uid_phone.Id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uid_phone.Id
     *
     * @param id the value for uid_phone.Id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uid_phone.uid
     *
     * @return the value of uid_phone.uid
     *
     * @mbg.generated
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uid_phone.uid
     *
     * @param uid the value for uid_phone.uid
     *
     * @mbg.generated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column uid_phone.phone
     *
     * @return the value of uid_phone.phone
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column uid_phone.phone
     *
     * @param phone the value for uid_phone.phone
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}