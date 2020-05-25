package com.api.dao;

import com.api.dao.sqlProvider.TCarPayRuleSqlProvider;
import com.api.entity.TCarPayRule;
import com.api.entity.TCarPayRuleCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TCarPayRuleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_pay_rule
     *
     * @mbg.generated
     */
    @SelectProvider(type=TCarPayRuleSqlProvider.class, method="countByExample")
    long countByExample(TCarPayRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_pay_rule
     *
     * @mbg.generated
     */
    @DeleteProvider(type=TCarPayRuleSqlProvider.class, method="deleteByExample")
    int deleteByExample(TCarPayRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_pay_rule
     *
     * @mbg.generated
     */
    @Delete({
        "delete from t_car_pay_rule",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_pay_rule
     *
     * @mbg.generated
     */
    @Insert({
        "insert into t_car_pay_rule (id, day_fee, ",
        "month_fee, park_id, ",
        "remark, rule_name, ",
        "season_fee, year_fee, ",
        "company_id, daily_start_time, ",
        "daily_end_time)",
        "values (#{id,jdbcType=INTEGER}, #{dayFee,jdbcType=DOUBLE}, ",
        "#{monthFee,jdbcType=DOUBLE}, #{parkId,jdbcType=INTEGER}, ",
        "#{remark,jdbcType=VARCHAR}, #{ruleName,jdbcType=VARCHAR}, ",
        "#{seasonFee,jdbcType=BIGINT}, #{yearFee,jdbcType=DOUBLE}, ",
        "#{companyId,jdbcType=INTEGER}, #{dailyStartTime,jdbcType=VARCHAR}, ",
        "#{dailyEndTime,jdbcType=VARCHAR})"
    })
    int insert(TCarPayRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_pay_rule
     *
     * @mbg.generated
     */
    @InsertProvider(type=TCarPayRuleSqlProvider.class, method="insertSelective")
    int insertSelective(TCarPayRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_pay_rule
     *
     * @mbg.generated
     */
    @SelectProvider(type=TCarPayRuleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="day_fee", property="dayFee", jdbcType=JdbcType.DOUBLE),
        @Result(column="month_fee", property="monthFee", jdbcType=JdbcType.DOUBLE),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_name", property="ruleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="season_fee", property="seasonFee", jdbcType=JdbcType.BIGINT),
        @Result(column="year_fee", property="yearFee", jdbcType=JdbcType.DOUBLE),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="daily_start_time", property="dailyStartTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="daily_end_time", property="dailyEndTime", jdbcType=JdbcType.VARCHAR)
    })
    List<TCarPayRule> selectByExample(TCarPayRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_pay_rule
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, day_fee, month_fee, park_id, remark, rule_name, season_fee, year_fee, company_id, ",
        "daily_start_time, daily_end_time",
        "from t_car_pay_rule",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="day_fee", property="dayFee", jdbcType=JdbcType.DOUBLE),
        @Result(column="month_fee", property="monthFee", jdbcType=JdbcType.DOUBLE),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_name", property="ruleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="season_fee", property="seasonFee", jdbcType=JdbcType.BIGINT),
        @Result(column="year_fee", property="yearFee", jdbcType=JdbcType.DOUBLE),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="daily_start_time", property="dailyStartTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="daily_end_time", property="dailyEndTime", jdbcType=JdbcType.VARCHAR)
    })
    TCarPayRule selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_pay_rule
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TCarPayRuleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TCarPayRule record, @Param("example") TCarPayRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_pay_rule
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TCarPayRuleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TCarPayRule record, @Param("example") TCarPayRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_pay_rule
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TCarPayRuleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TCarPayRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_pay_rule
     *
     * @mbg.generated
     */
    @Update({
        "update t_car_pay_rule",
        "set day_fee = #{dayFee,jdbcType=DOUBLE},",
          "month_fee = #{monthFee,jdbcType=DOUBLE},",
          "park_id = #{parkId,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "rule_name = #{ruleName,jdbcType=VARCHAR},",
          "season_fee = #{seasonFee,jdbcType=BIGINT},",
          "year_fee = #{yearFee,jdbcType=DOUBLE},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "daily_start_time = #{dailyStartTime,jdbcType=VARCHAR},",
          "daily_end_time = #{dailyEndTime,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TCarPayRule record);
}