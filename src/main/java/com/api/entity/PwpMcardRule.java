package com.api.entity;

import java.math.BigDecimal;

public class PwpMcardRule {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_mcard_rule.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_mcard_rule.park_id
     *
     * @mbg.generated
     */
    private Integer parkId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_mcard_rule.type_name
     *
     * @mbg.generated
     */
    private String typeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_mcard_rule.day_cost
     *
     * @mbg.generated
     */
    private BigDecimal dayCost;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_mcard_rule.month_cost
     *
     * @mbg.generated
     */
    private BigDecimal monthCost;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_mcard_rule.season_cost
     *
     * @mbg.generated
     */
    private BigDecimal seasonCost;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_mcard_rule.year_cost
     *
     * @mbg.generated
     */
    private BigDecimal yearCost;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_mcard_rule.rule_status
     *
     * @mbg.generated
     */
    private Byte ruleStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_mcard_rule.create_time
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_mcard_rule.update_time
     *
     * @mbg.generated
     */
    private String updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_mcard_rule.id
     *
     * @return the value of pwp_mcard_rule.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_mcard_rule.id
     *
     * @param id the value for pwp_mcard_rule.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_mcard_rule.park_id
     *
     * @return the value of pwp_mcard_rule.park_id
     *
     * @mbg.generated
     */
    public Integer getParkId() {
        return parkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_mcard_rule.park_id
     *
     * @param parkId the value for pwp_mcard_rule.park_id
     *
     * @mbg.generated
     */
    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_mcard_rule.type_name
     *
     * @return the value of pwp_mcard_rule.type_name
     *
     * @mbg.generated
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_mcard_rule.type_name
     *
     * @param typeName the value for pwp_mcard_rule.type_name
     *
     * @mbg.generated
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_mcard_rule.day_cost
     *
     * @return the value of pwp_mcard_rule.day_cost
     *
     * @mbg.generated
     */
    public BigDecimal getDayCost() {
        return dayCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_mcard_rule.day_cost
     *
     * @param dayCost the value for pwp_mcard_rule.day_cost
     *
     * @mbg.generated
     */
    public void setDayCost(BigDecimal dayCost) {
        this.dayCost = dayCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_mcard_rule.month_cost
     *
     * @return the value of pwp_mcard_rule.month_cost
     *
     * @mbg.generated
     */
    public BigDecimal getMonthCost() {
        return monthCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_mcard_rule.month_cost
     *
     * @param monthCost the value for pwp_mcard_rule.month_cost
     *
     * @mbg.generated
     */
    public void setMonthCost(BigDecimal monthCost) {
        this.monthCost = monthCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_mcard_rule.season_cost
     *
     * @return the value of pwp_mcard_rule.season_cost
     *
     * @mbg.generated
     */
    public BigDecimal getSeasonCost() {
        return seasonCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_mcard_rule.season_cost
     *
     * @param seasonCost the value for pwp_mcard_rule.season_cost
     *
     * @mbg.generated
     */
    public void setSeasonCost(BigDecimal seasonCost) {
        this.seasonCost = seasonCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_mcard_rule.year_cost
     *
     * @return the value of pwp_mcard_rule.year_cost
     *
     * @mbg.generated
     */
    public BigDecimal getYearCost() {
        return yearCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_mcard_rule.year_cost
     *
     * @param yearCost the value for pwp_mcard_rule.year_cost
     *
     * @mbg.generated
     */
    public void setYearCost(BigDecimal yearCost) {
        this.yearCost = yearCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_mcard_rule.rule_status
     *
     * @return the value of pwp_mcard_rule.rule_status
     *
     * @mbg.generated
     */
    public Byte getRuleStatus() {
        return ruleStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_mcard_rule.rule_status
     *
     * @param ruleStatus the value for pwp_mcard_rule.rule_status
     *
     * @mbg.generated
     */
    public void setRuleStatus(Byte ruleStatus) {
        this.ruleStatus = ruleStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_mcard_rule.create_time
     *
     * @return the value of pwp_mcard_rule.create_time
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_mcard_rule.create_time
     *
     * @param createTime the value for pwp_mcard_rule.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_mcard_rule.update_time
     *
     * @return the value of pwp_mcard_rule.update_time
     *
     * @mbg.generated
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_mcard_rule.update_time
     *
     * @param updateTime the value for pwp_mcard_rule.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}