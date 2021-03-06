package com.api.dao;

import com.api.dao.sqlProvider.PwpMerchantTradeSqlProvider;
import com.api.entity.PwpMerchantTrade;
import com.api.entity.PwpMerchantTradeCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PwpMerchantTradeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    @SelectProvider(type= PwpMerchantTradeSqlProvider.class, method="countByExample")
    long countByExample(PwpMerchantTradeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    @DeleteProvider(type= PwpMerchantTradeSqlProvider.class, method="deleteByExample")
    int deleteByExample(PwpMerchantTradeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    @Delete({
        "delete from pwp_merchant_trade",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    @Insert({
        "insert into pwp_merchant_trade (id, merchant_id, ",
        "merchant_trade_no, merchant_trade_type, ",
        "billing_account_id, trade_amount, ",
        "balance, trade_result, ",
        "sync_result, sync_time, ",
        "sync_id, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{merchantId,jdbcType=INTEGER}, ",
        "#{merchantTradeNo,jdbcType=VARCHAR}, #{merchantTradeType,jdbcType=TINYINT}, ",
        "#{billingAccountId,jdbcType=INTEGER}, #{tradeAmount,jdbcType=DECIMAL}, ",
        "#{balance,jdbcType=DECIMAL}, #{tradeResult,jdbcType=TINYINT}, ",
        "#{syncResult,jdbcType=TINYINT}, #{syncTime,jdbcType=TIMESTAMP}, ",
        "#{syncId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(PwpMerchantTrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    @InsertProvider(type= PwpMerchantTradeSqlProvider.class, method="insertSelective")
    int insertSelective(PwpMerchantTrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    @SelectProvider(type= PwpMerchantTradeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_trade_no", property="merchantTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_trade_type", property="merchantTradeType", jdbcType=JdbcType.TINYINT),
        @Result(column="billing_account_id", property="billingAccountId", jdbcType=JdbcType.INTEGER),
        @Result(column="trade_amount", property="tradeAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DECIMAL),
        @Result(column="trade_result", property="tradeResult", jdbcType=JdbcType.TINYINT),
        @Result(column="sync_result", property="syncResult", jdbcType=JdbcType.TINYINT),
        @Result(column="sync_time", property="syncTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sync_id", property="syncId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PwpMerchantTrade> selectByExample(PwpMerchantTradeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, merchant_id, merchant_trade_no, merchant_trade_type, billing_account_id, ",
        "trade_amount, balance, trade_result, sync_result, sync_time, sync_id, create_time, ",
        "update_time",
        "from pwp_merchant_trade",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_trade_no", property="merchantTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_trade_type", property="merchantTradeType", jdbcType=JdbcType.TINYINT),
        @Result(column="billing_account_id", property="billingAccountId", jdbcType=JdbcType.INTEGER),
        @Result(column="trade_amount", property="tradeAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DECIMAL),
        @Result(column="trade_result", property="tradeResult", jdbcType=JdbcType.TINYINT),
        @Result(column="sync_result", property="syncResult", jdbcType=JdbcType.TINYINT),
        @Result(column="sync_time", property="syncTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sync_id", property="syncId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PwpMerchantTrade selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    @UpdateProvider(type= PwpMerchantTradeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PwpMerchantTrade record, @Param("example") PwpMerchantTradeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    @UpdateProvider(type= PwpMerchantTradeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PwpMerchantTrade record, @Param("example") PwpMerchantTradeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    @UpdateProvider(type= PwpMerchantTradeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PwpMerchantTrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    @Update({
        "update pwp_merchant_trade",
        "set merchant_id = #{merchantId,jdbcType=INTEGER},",
          "merchant_trade_no = #{merchantTradeNo,jdbcType=VARCHAR},",
          "merchant_trade_type = #{merchantTradeType,jdbcType=TINYINT},",
          "billing_account_id = #{billingAccountId,jdbcType=INTEGER},",
          "trade_amount = #{tradeAmount,jdbcType=DECIMAL},",
          "balance = #{balance,jdbcType=DECIMAL},",
          "trade_result = #{tradeResult,jdbcType=TINYINT},",
          "sync_result = #{syncResult,jdbcType=TINYINT},",
          "sync_time = #{syncTime,jdbcType=TIMESTAMP},",
          "sync_id = #{syncId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PwpMerchantTrade record);
}