package com.api.entity;

public class TDicQpasspayType {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dic_qpasspay_type.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dic_qpasspay_type.paytype_id
     *
     * @mbg.generated
     */
    private Integer paytypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dic_qpasspay_type.paytype_name
     *
     * @mbg.generated
     */
    private String paytypeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dic_qpasspay_type.remarks
     *
     * @mbg.generated
     */
    private String remarks;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dic_qpasspay_type.id
     *
     * @return the value of t_dic_qpasspay_type.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dic_qpasspay_type.id
     *
     * @param id the value for t_dic_qpasspay_type.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dic_qpasspay_type.paytype_id
     *
     * @return the value of t_dic_qpasspay_type.paytype_id
     *
     * @mbg.generated
     */
    public Integer getPaytypeId() {
        return paytypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dic_qpasspay_type.paytype_id
     *
     * @param paytypeId the value for t_dic_qpasspay_type.paytype_id
     *
     * @mbg.generated
     */
    public void setPaytypeId(Integer paytypeId) {
        this.paytypeId = paytypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dic_qpasspay_type.paytype_name
     *
     * @return the value of t_dic_qpasspay_type.paytype_name
     *
     * @mbg.generated
     */
    public String getPaytypeName() {
        return paytypeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dic_qpasspay_type.paytype_name
     *
     * @param paytypeName the value for t_dic_qpasspay_type.paytype_name
     *
     * @mbg.generated
     */
    public void setPaytypeName(String paytypeName) {
        this.paytypeName = paytypeName == null ? null : paytypeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dic_qpasspay_type.remarks
     *
     * @return the value of t_dic_qpasspay_type.remarks
     *
     * @mbg.generated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dic_qpasspay_type.remarks
     *
     * @param remarks the value for t_dic_qpasspay_type.remarks
     *
     * @mbg.generated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}