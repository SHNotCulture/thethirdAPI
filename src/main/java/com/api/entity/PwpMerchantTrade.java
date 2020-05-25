package com.api.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PwpMerchantTrade {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_merchant_trade.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_merchant_trade.merchant_id
     *
     * @mbg.generated
     */
    private Integer merchantId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_merchant_trade.merchant_trade_no
     *
     * @mbg.generated
     */
    private String merchantTradeNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_merchant_trade.merchant_trade_type
     *
     * @mbg.generated
     */
    private Byte merchantTradeType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_merchant_trade.billing_account_id
     *
     * @mbg.generated
     */
    private Integer billingAccountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_merchant_trade.trade_amount
     *
     * @mbg.generated
     */
    private BigDecimal tradeAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_merchant_trade.balance
     *
     * @mbg.generated
     */
    private BigDecimal balance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_merchant_trade.trade_result
     *
     * @mbg.generated
     */
    private Byte tradeResult;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_merchant_trade.sync_result
     *
     * @mbg.generated
     */
    private Byte syncResult;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_merchant_trade.sync_time
     *
     * @mbg.generated
     */
    private Date syncTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_merchant_trade.sync_id
     *
     * @mbg.generated
     */
    private Integer syncId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_merchant_trade.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pwp_merchant_trade.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_merchant_trade.id
     *
     * @return the value of pwp_merchant_trade.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_merchant_trade.id
     *
     * @param id the value for pwp_merchant_trade.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_merchant_trade.merchant_id
     *
     * @return the value of pwp_merchant_trade.merchant_id
     *
     * @mbg.generated
     */
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_merchant_trade.merchant_id
     *
     * @param merchantId the value for pwp_merchant_trade.merchant_id
     *
     * @mbg.generated
     */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_merchant_trade.merchant_trade_no
     *
     * @return the value of pwp_merchant_trade.merchant_trade_no
     *
     * @mbg.generated
     */
    public String getMerchantTradeNo() {
        return merchantTradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_merchant_trade.merchant_trade_no
     *
     * @param merchantTradeNo the value for pwp_merchant_trade.merchant_trade_no
     *
     * @mbg.generated
     */
    public void setMerchantTradeNo(String merchantTradeNo) {
        this.merchantTradeNo = merchantTradeNo == null ? null : merchantTradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_merchant_trade.merchant_trade_type
     *
     * @return the value of pwp_merchant_trade.merchant_trade_type
     *
     * @mbg.generated
     */
    public Byte getMerchantTradeType() {
        return merchantTradeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_merchant_trade.merchant_trade_type
     *
     * @param merchantTradeType the value for pwp_merchant_trade.merchant_trade_type
     *
     * @mbg.generated
     */
    public void setMerchantTradeType(Byte merchantTradeType) {
        this.merchantTradeType = merchantTradeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_merchant_trade.billing_account_id
     *
     * @return the value of pwp_merchant_trade.billing_account_id
     *
     * @mbg.generated
     */
    public Integer getBillingAccountId() {
        return billingAccountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_merchant_trade.billing_account_id
     *
     * @param billingAccountId the value for pwp_merchant_trade.billing_account_id
     *
     * @mbg.generated
     */
    public void setBillingAccountId(Integer billingAccountId) {
        this.billingAccountId = billingAccountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_merchant_trade.trade_amount
     *
     * @return the value of pwp_merchant_trade.trade_amount
     *
     * @mbg.generated
     */
    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_merchant_trade.trade_amount
     *
     * @param tradeAmount the value for pwp_merchant_trade.trade_amount
     *
     * @mbg.generated
     */
    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_merchant_trade.balance
     *
     * @return the value of pwp_merchant_trade.balance
     *
     * @mbg.generated
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_merchant_trade.balance
     *
     * @param balance the value for pwp_merchant_trade.balance
     *
     * @mbg.generated
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_merchant_trade.trade_result
     *
     * @return the value of pwp_merchant_trade.trade_result
     *
     * @mbg.generated
     */
    public Byte getTradeResult() {
        return tradeResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_merchant_trade.trade_result
     *
     * @param tradeResult the value for pwp_merchant_trade.trade_result
     *
     * @mbg.generated
     */
    public void setTradeResult(Byte tradeResult) {
        this.tradeResult = tradeResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_merchant_trade.sync_result
     *
     * @return the value of pwp_merchant_trade.sync_result
     *
     * @mbg.generated
     */
    public Byte getSyncResult() {
        return syncResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_merchant_trade.sync_result
     *
     * @param syncResult the value for pwp_merchant_trade.sync_result
     *
     * @mbg.generated
     */
    public void setSyncResult(Byte syncResult) {
        this.syncResult = syncResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_merchant_trade.sync_time
     *
     * @return the value of pwp_merchant_trade.sync_time
     *
     * @mbg.generated
     */
    public Date getSyncTime() {
        return syncTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_merchant_trade.sync_time
     *
     * @param syncTime the value for pwp_merchant_trade.sync_time
     *
     * @mbg.generated
     */
    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_merchant_trade.sync_id
     *
     * @return the value of pwp_merchant_trade.sync_id
     *
     * @mbg.generated
     */
    public Integer getSyncId() {
        return syncId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_merchant_trade.sync_id
     *
     * @param syncId the value for pwp_merchant_trade.sync_id
     *
     * @mbg.generated
     */
    public void setSyncId(Integer syncId) {
        this.syncId = syncId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_merchant_trade.create_time
     *
     * @return the value of pwp_merchant_trade.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_merchant_trade.create_time
     *
     * @param createTime the value for pwp_merchant_trade.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pwp_merchant_trade.update_time
     *
     * @return the value of pwp_merchant_trade.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pwp_merchant_trade.update_time
     *
     * @param updateTime the value for pwp_merchant_trade.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}