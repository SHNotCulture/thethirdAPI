package com.api.entity;

public class TDicPrepayType {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dic_prepay_type.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dic_prepay_type.paytype_id
     *
     * @mbg.generated
     */
    private Integer paytypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dic_prepay_type.payname
     *
     * @mbg.generated
     */
    private String payname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dic_prepay_type.remarks
     *
     * @mbg.generated
     */
    private String remarks;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dic_prepay_type.id
     *
     * @return the value of t_dic_prepay_type.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dic_prepay_type.id
     *
     * @param id the value for t_dic_prepay_type.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dic_prepay_type.paytype_id
     *
     * @return the value of t_dic_prepay_type.paytype_id
     *
     * @mbg.generated
     */
    public Integer getPaytypeId() {
        return paytypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dic_prepay_type.paytype_id
     *
     * @param paytypeId the value for t_dic_prepay_type.paytype_id
     *
     * @mbg.generated
     */
    public void setPaytypeId(Integer paytypeId) {
        this.paytypeId = paytypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dic_prepay_type.payname
     *
     * @return the value of t_dic_prepay_type.payname
     *
     * @mbg.generated
     */
    public String getPayname() {
        return payname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dic_prepay_type.payname
     *
     * @param payname the value for t_dic_prepay_type.payname
     *
     * @mbg.generated
     */
    public void setPayname(String payname) {
        this.payname = payname == null ? null : payname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dic_prepay_type.remarks
     *
     * @return the value of t_dic_prepay_type.remarks
     *
     * @mbg.generated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dic_prepay_type.remarks
     *
     * @param remarks the value for t_dic_prepay_type.remarks
     *
     * @mbg.generated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}