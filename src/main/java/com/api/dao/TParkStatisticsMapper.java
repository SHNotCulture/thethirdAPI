package com.api.dao;

import com.api.dao.sqlProvider.TParkStatisticsSqlProvider;
import com.api.entity.TParkStatistics;
import com.api.entity.TParkStatisticsCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TParkStatisticsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_park_statistics
     *
     * @mbg.generated
     */
    @SelectProvider(type= TParkStatisticsSqlProvider.class, method="countByExample")
    long countByExample(TParkStatisticsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_park_statistics
     *
     * @mbg.generated
     */
    @DeleteProvider(type= TParkStatisticsSqlProvider.class, method="deleteByExample")
    int deleteByExample(TParkStatisticsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_park_statistics
     *
     * @mbg.generated
     */
    @Delete({
        "delete from t_park_statistics",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_park_statistics
     *
     * @mbg.generated
     */
    @Insert({
        "insert into t_park_statistics (id, park_id, ",
        "park_name, entrance_flow, ",
        "outbound_flow, totalPayFee, ",
        "totalPayNum, unionPayFee, ",
        "unionPayNum, unionPayQRFee, ",
        "unionPayQRNum, unionPayPassFee, ",
        "unionPayPassNum, cloudFee, ",
        "cloudNum, annual_goals, ",
        "park_spaces_total, park_spaces_free, ",
        "park_spaces_occ, price_ave, ",
        "entrance_flow_ave, outbound_flow_ave, ",
        "turnover_ave, usage_rate, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{parkId,jdbcType=INTEGER}, ",
        "#{parkName,jdbcType=VARCHAR}, #{entranceFlow,jdbcType=INTEGER}, ",
        "#{outboundFlow,jdbcType=INTEGER}, #{totalpayfee,jdbcType=DOUBLE}, ",
        "#{totalpaynum,jdbcType=INTEGER}, #{unionpayfee,jdbcType=DOUBLE}, ",
        "#{unionpaynum,jdbcType=INTEGER}, #{unionpayqrfee,jdbcType=DOUBLE}, ",
        "#{unionpayqrnum,jdbcType=INTEGER}, #{unionpaypassfee,jdbcType=DOUBLE}, ",
        "#{unionpaypassnum,jdbcType=INTEGER}, #{cloudfee,jdbcType=DOUBLE}, ",
        "#{cloudnum,jdbcType=INTEGER}, #{annualGoals,jdbcType=INTEGER}, ",
        "#{parkSpacesTotal,jdbcType=INTEGER}, #{parkSpacesFree,jdbcType=INTEGER}, ",
        "#{parkSpacesOcc,jdbcType=INTEGER}, #{priceAve,jdbcType=DOUBLE}, ",
        "#{entranceFlowAve,jdbcType=DOUBLE}, #{outboundFlowAve,jdbcType=DOUBLE}, ",
        "#{turnoverAve,jdbcType=DOUBLE}, #{usageRate,jdbcType=DOUBLE}, ",
        "#{updateTime,jdbcType=VARCHAR})"
    })
    int insert(TParkStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_park_statistics
     *
     * @mbg.generated
     */
    @InsertProvider(type= TParkStatisticsSqlProvider.class, method="insertSelective")
    int insertSelective(TParkStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_park_statistics
     *
     * @mbg.generated
     */
    @SelectProvider(type= TParkStatisticsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="park_name", property="parkName", jdbcType=JdbcType.VARCHAR),
        @Result(column="entrance_flow", property="entranceFlow", jdbcType=JdbcType.INTEGER),
        @Result(column="outbound_flow", property="outboundFlow", jdbcType=JdbcType.INTEGER),
        @Result(column="totalPayFee", property="totalpayfee", jdbcType=JdbcType.DOUBLE),
        @Result(column="totalPayNum", property="totalpaynum", jdbcType=JdbcType.INTEGER),
        @Result(column="unionPayFee", property="unionpayfee", jdbcType=JdbcType.DOUBLE),
        @Result(column="unionPayNum", property="unionpaynum", jdbcType=JdbcType.INTEGER),
        @Result(column="unionPayQRFee", property="unionpayqrfee", jdbcType=JdbcType.DOUBLE),
        @Result(column="unionPayQRNum", property="unionpayqrnum", jdbcType=JdbcType.INTEGER),
        @Result(column="unionPayPassFee", property="unionpaypassfee", jdbcType=JdbcType.DOUBLE),
        @Result(column="unionPayPassNum", property="unionpaypassnum", jdbcType=JdbcType.INTEGER),
        @Result(column="cloudFee", property="cloudfee", jdbcType=JdbcType.DOUBLE),
        @Result(column="cloudNum", property="cloudnum", jdbcType=JdbcType.INTEGER),
        @Result(column="annual_goals", property="annualGoals", jdbcType=JdbcType.INTEGER),
        @Result(column="park_spaces_total", property="parkSpacesTotal", jdbcType=JdbcType.INTEGER),
        @Result(column="park_spaces_free", property="parkSpacesFree", jdbcType=JdbcType.INTEGER),
        @Result(column="park_spaces_occ", property="parkSpacesOcc", jdbcType=JdbcType.INTEGER),
        @Result(column="price_ave", property="priceAve", jdbcType=JdbcType.DOUBLE),
        @Result(column="entrance_flow_ave", property="entranceFlowAve", jdbcType=JdbcType.DOUBLE),
        @Result(column="outbound_flow_ave", property="outboundFlowAve", jdbcType=JdbcType.DOUBLE),
        @Result(column="turnover_ave", property="turnoverAve", jdbcType=JdbcType.DOUBLE),
        @Result(column="usage_rate", property="usageRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR)
    })
    List<TParkStatistics> selectByExample(TParkStatisticsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_park_statistics
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, park_id, park_name, entrance_flow, outbound_flow, totalPayFee, totalPayNum, ",
        "unionPayFee, unionPayNum, unionPayQRFee, unionPayQRNum, unionPayPassFee, unionPayPassNum, ",
        "cloudFee, cloudNum, annual_goals, park_spaces_total, park_spaces_free, park_spaces_occ, ",
        "price_ave, entrance_flow_ave, outbound_flow_ave, turnover_ave, usage_rate, update_time",
        "from t_park_statistics",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="park_name", property="parkName", jdbcType=JdbcType.VARCHAR),
        @Result(column="entrance_flow", property="entranceFlow", jdbcType=JdbcType.INTEGER),
        @Result(column="outbound_flow", property="outboundFlow", jdbcType=JdbcType.INTEGER),
        @Result(column="totalPayFee", property="totalpayfee", jdbcType=JdbcType.DOUBLE),
        @Result(column="totalPayNum", property="totalpaynum", jdbcType=JdbcType.INTEGER),
        @Result(column="unionPayFee", property="unionpayfee", jdbcType=JdbcType.DOUBLE),
        @Result(column="unionPayNum", property="unionpaynum", jdbcType=JdbcType.INTEGER),
        @Result(column="unionPayQRFee", property="unionpayqrfee", jdbcType=JdbcType.DOUBLE),
        @Result(column="unionPayQRNum", property="unionpayqrnum", jdbcType=JdbcType.INTEGER),
        @Result(column="unionPayPassFee", property="unionpaypassfee", jdbcType=JdbcType.DOUBLE),
        @Result(column="unionPayPassNum", property="unionpaypassnum", jdbcType=JdbcType.INTEGER),
        @Result(column="cloudFee", property="cloudfee", jdbcType=JdbcType.DOUBLE),
        @Result(column="cloudNum", property="cloudnum", jdbcType=JdbcType.INTEGER),
        @Result(column="annual_goals", property="annualGoals", jdbcType=JdbcType.INTEGER),
        @Result(column="park_spaces_total", property="parkSpacesTotal", jdbcType=JdbcType.INTEGER),
        @Result(column="park_spaces_free", property="parkSpacesFree", jdbcType=JdbcType.INTEGER),
        @Result(column="park_spaces_occ", property="parkSpacesOcc", jdbcType=JdbcType.INTEGER),
        @Result(column="price_ave", property="priceAve", jdbcType=JdbcType.DOUBLE),
        @Result(column="entrance_flow_ave", property="entranceFlowAve", jdbcType=JdbcType.DOUBLE),
        @Result(column="outbound_flow_ave", property="outboundFlowAve", jdbcType=JdbcType.DOUBLE),
        @Result(column="turnover_ave", property="turnoverAve", jdbcType=JdbcType.DOUBLE),
        @Result(column="usage_rate", property="usageRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR)
    })
    TParkStatistics selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_park_statistics
     *
     * @mbg.generated
     */
    @UpdateProvider(type= TParkStatisticsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TParkStatistics record, @Param("example") TParkStatisticsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_park_statistics
     *
     * @mbg.generated
     */
    @UpdateProvider(type= TParkStatisticsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TParkStatistics record, @Param("example") TParkStatisticsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_park_statistics
     *
     * @mbg.generated
     */
    @UpdateProvider(type= TParkStatisticsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TParkStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_park_statistics
     *
     * @mbg.generated
     */
    @Update({
        "update t_park_statistics",
        "set park_id = #{parkId,jdbcType=INTEGER},",
          "park_name = #{parkName,jdbcType=VARCHAR},",
          "entrance_flow = #{entranceFlow,jdbcType=INTEGER},",
          "outbound_flow = #{outboundFlow,jdbcType=INTEGER},",
          "totalPayFee = #{totalpayfee,jdbcType=DOUBLE},",
          "totalPayNum = #{totalpaynum,jdbcType=INTEGER},",
          "unionPayFee = #{unionpayfee,jdbcType=DOUBLE},",
          "unionPayNum = #{unionpaynum,jdbcType=INTEGER},",
          "unionPayQRFee = #{unionpayqrfee,jdbcType=DOUBLE},",
          "unionPayQRNum = #{unionpayqrnum,jdbcType=INTEGER},",
          "unionPayPassFee = #{unionpaypassfee,jdbcType=DOUBLE},",
          "unionPayPassNum = #{unionpaypassnum,jdbcType=INTEGER},",
          "cloudFee = #{cloudfee,jdbcType=DOUBLE},",
          "cloudNum = #{cloudnum,jdbcType=INTEGER},",
          "annual_goals = #{annualGoals,jdbcType=INTEGER},",
          "park_spaces_total = #{parkSpacesTotal,jdbcType=INTEGER},",
          "park_spaces_free = #{parkSpacesFree,jdbcType=INTEGER},",
          "park_spaces_occ = #{parkSpacesOcc,jdbcType=INTEGER},",
          "price_ave = #{priceAve,jdbcType=DOUBLE},",
          "entrance_flow_ave = #{entranceFlowAve,jdbcType=DOUBLE},",
          "outbound_flow_ave = #{outboundFlowAve,jdbcType=DOUBLE},",
          "turnover_ave = #{turnoverAve,jdbcType=DOUBLE},",
          "usage_rate = #{usageRate,jdbcType=DOUBLE},",
          "update_time = #{updateTime,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TParkStatistics record);
}