package com.api.dao;

import com.api.dao.sqlProvider.TChargeRuleSqlProvider;
import com.api.entity.TChargeRule;
import com.api.entity.TChargeRuleCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TChargeRuleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_rule
     *
     * @mbg.generated
     */
    @SelectProvider(type=TChargeRuleSqlProvider.class, method="countByExample")
    long countByExample(TChargeRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_rule
     *
     * @mbg.generated
     */
    @DeleteProvider(type=TChargeRuleSqlProvider.class, method="deleteByExample")
    int deleteByExample(TChargeRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_rule
     *
     * @mbg.generated
     */
    @Delete({
        "delete from t_charge_rule",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_rule
     *
     * @mbg.generated
     */
    @Insert({
        "insert into t_charge_rule (id, base_time1, ",
        "base_time1_fee, base_time2, ",
        "base_time2_fee, car_type_id, ",
        "free_time, free_time_fee, ",
        "h24_rule, h24_unit_time, ",
        "h24_unit_time_fee, is_Holiday_Use, ",
        "is_max_sectime_fee_by_add, max_day1_fee, ",
        "max_dayn_fee, max_sectime_fee, ",
        "park_id, surpass_time, ",
        "timesec_end, timesec_start, ",
        "unit_time, unit_time_fee, ",
        "is_max_24_fee_by_add)",
        "values (#{id,jdbcType=INTEGER}, #{baseTime1,jdbcType=INTEGER}, ",
        "#{baseTime1Fee,jdbcType=VARCHAR}, #{baseTime2,jdbcType=INTEGER}, ",
        "#{baseTime2Fee,jdbcType=VARCHAR}, #{carTypeId,jdbcType=INTEGER}, ",
        "#{freeTime,jdbcType=INTEGER}, #{freeTimeFee,jdbcType=VARCHAR}, ",
        "#{h24Rule,jdbcType=INTEGER}, #{h24UnitTime,jdbcType=INTEGER}, ",
        "#{h24UnitTimeFee,jdbcType=VARCHAR}, #{isHolidayUse,jdbcType=INTEGER}, ",
        "#{isMaxSectimeFeeByAdd,jdbcType=INTEGER}, #{maxDay1Fee,jdbcType=VARCHAR}, ",
        "#{maxDaynFee,jdbcType=VARCHAR}, #{maxSectimeFee,jdbcType=VARCHAR}, ",
        "#{parkId,jdbcType=INTEGER}, #{surpassTime,jdbcType=INTEGER}, ",
        "#{timesecEnd,jdbcType=VARCHAR}, #{timesecStart,jdbcType=VARCHAR}, ",
        "#{unitTime,jdbcType=INTEGER}, #{unitTimeFee,jdbcType=VARCHAR}, ",
        "#{isMax24FeeByAdd,jdbcType=INTEGER})"
    })
    int insert(TChargeRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_rule
     *
     * @mbg.generated
     */
    @InsertProvider(type=TChargeRuleSqlProvider.class, method="insertSelective")
    int insertSelective(TChargeRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_rule
     *
     * @mbg.generated
     */
    @SelectProvider(type=TChargeRuleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="base_time1", property="baseTime1", jdbcType=JdbcType.INTEGER),
        @Result(column="base_time1_fee", property="baseTime1Fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="base_time2", property="baseTime2", jdbcType=JdbcType.INTEGER),
        @Result(column="base_time2_fee", property="baseTime2Fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_id", property="carTypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="free_time", property="freeTime", jdbcType=JdbcType.INTEGER),
        @Result(column="free_time_fee", property="freeTimeFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="h24_rule", property="h24Rule", jdbcType=JdbcType.INTEGER),
        @Result(column="h24_unit_time", property="h24UnitTime", jdbcType=JdbcType.INTEGER),
        @Result(column="h24_unit_time_fee", property="h24UnitTimeFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_Holiday_Use", property="isHolidayUse", jdbcType=JdbcType.INTEGER),
        @Result(column="is_max_sectime_fee_by_add", property="isMaxSectimeFeeByAdd", jdbcType=JdbcType.INTEGER),
        @Result(column="max_day1_fee", property="maxDay1Fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="max_dayn_fee", property="maxDaynFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="max_sectime_fee", property="maxSectimeFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="surpass_time", property="surpassTime", jdbcType=JdbcType.INTEGER),
        @Result(column="timesec_end", property="timesecEnd", jdbcType=JdbcType.VARCHAR),
        @Result(column="timesec_start", property="timesecStart", jdbcType=JdbcType.VARCHAR),
        @Result(column="unit_time", property="unitTime", jdbcType=JdbcType.INTEGER),
        @Result(column="unit_time_fee", property="unitTimeFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_max_24_fee_by_add", property="isMax24FeeByAdd", jdbcType=JdbcType.INTEGER)
    })
    List<TChargeRule> selectByExample(TChargeRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_rule
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, base_time1, base_time1_fee, base_time2, base_time2_fee, car_type_id, free_time, ",
        "free_time_fee, h24_rule, h24_unit_time, h24_unit_time_fee, is_Holiday_Use, is_max_sectime_fee_by_add, ",
        "max_day1_fee, max_dayn_fee, max_sectime_fee, park_id, surpass_time, timesec_end, ",
        "timesec_start, unit_time, unit_time_fee, is_max_24_fee_by_add",
        "from t_charge_rule",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="base_time1", property="baseTime1", jdbcType=JdbcType.INTEGER),
        @Result(column="base_time1_fee", property="baseTime1Fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="base_time2", property="baseTime2", jdbcType=JdbcType.INTEGER),
        @Result(column="base_time2_fee", property="baseTime2Fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_id", property="carTypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="free_time", property="freeTime", jdbcType=JdbcType.INTEGER),
        @Result(column="free_time_fee", property="freeTimeFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="h24_rule", property="h24Rule", jdbcType=JdbcType.INTEGER),
        @Result(column="h24_unit_time", property="h24UnitTime", jdbcType=JdbcType.INTEGER),
        @Result(column="h24_unit_time_fee", property="h24UnitTimeFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_Holiday_Use", property="isHolidayUse", jdbcType=JdbcType.INTEGER),
        @Result(column="is_max_sectime_fee_by_add", property="isMaxSectimeFeeByAdd", jdbcType=JdbcType.INTEGER),
        @Result(column="max_day1_fee", property="maxDay1Fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="max_dayn_fee", property="maxDaynFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="max_sectime_fee", property="maxSectimeFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="surpass_time", property="surpassTime", jdbcType=JdbcType.INTEGER),
        @Result(column="timesec_end", property="timesecEnd", jdbcType=JdbcType.VARCHAR),
        @Result(column="timesec_start", property="timesecStart", jdbcType=JdbcType.VARCHAR),
        @Result(column="unit_time", property="unitTime", jdbcType=JdbcType.INTEGER),
        @Result(column="unit_time_fee", property="unitTimeFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_max_24_fee_by_add", property="isMax24FeeByAdd", jdbcType=JdbcType.INTEGER)
    })
    TChargeRule selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_rule
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TChargeRuleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TChargeRule record, @Param("example") TChargeRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_rule
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TChargeRuleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TChargeRule record, @Param("example") TChargeRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_rule
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TChargeRuleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TChargeRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_rule
     *
     * @mbg.generated
     */
    @Update({
        "update t_charge_rule",
        "set base_time1 = #{baseTime1,jdbcType=INTEGER},",
          "base_time1_fee = #{baseTime1Fee,jdbcType=VARCHAR},",
          "base_time2 = #{baseTime2,jdbcType=INTEGER},",
          "base_time2_fee = #{baseTime2Fee,jdbcType=VARCHAR},",
          "car_type_id = #{carTypeId,jdbcType=INTEGER},",
          "free_time = #{freeTime,jdbcType=INTEGER},",
          "free_time_fee = #{freeTimeFee,jdbcType=VARCHAR},",
          "h24_rule = #{h24Rule,jdbcType=INTEGER},",
          "h24_unit_time = #{h24UnitTime,jdbcType=INTEGER},",
          "h24_unit_time_fee = #{h24UnitTimeFee,jdbcType=VARCHAR},",
          "is_Holiday_Use = #{isHolidayUse,jdbcType=INTEGER},",
          "is_max_sectime_fee_by_add = #{isMaxSectimeFeeByAdd,jdbcType=INTEGER},",
          "max_day1_fee = #{maxDay1Fee,jdbcType=VARCHAR},",
          "max_dayn_fee = #{maxDaynFee,jdbcType=VARCHAR},",
          "max_sectime_fee = #{maxSectimeFee,jdbcType=VARCHAR},",
          "park_id = #{parkId,jdbcType=INTEGER},",
          "surpass_time = #{surpassTime,jdbcType=INTEGER},",
          "timesec_end = #{timesecEnd,jdbcType=VARCHAR},",
          "timesec_start = #{timesecStart,jdbcType=VARCHAR},",
          "unit_time = #{unitTime,jdbcType=INTEGER},",
          "unit_time_fee = #{unitTimeFee,jdbcType=VARCHAR},",
          "is_max_24_fee_by_add = #{isMax24FeeByAdd,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TChargeRule record);
}