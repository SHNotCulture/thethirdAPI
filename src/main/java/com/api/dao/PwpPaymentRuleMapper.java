package com.api.dao;

import com.api.dao.sqlProvider.PwpPaymentRuleSqlProvider;
import com.api.entity.PwpPaymentRule;
import com.api.entity.PwpPaymentRuleCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PwpPaymentRuleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_payment_rule
     *
     * @mbg.generated
     */
    @SelectProvider(type=PwpPaymentRuleSqlProvider.class, method="countByExample")
    long countByExample(PwpPaymentRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_payment_rule
     *
     * @mbg.generated
     */
    @DeleteProvider(type=PwpPaymentRuleSqlProvider.class, method="deleteByExample")
    int deleteByExample(PwpPaymentRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_payment_rule
     *
     * @mbg.generated
     */
    @Delete({
        "delete from pwp_payment_rule",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_payment_rule
     *
     * @mbg.generated
     */
    @Insert({
        "insert into pwp_payment_rule (id, league_id, ",
        "name, free_time, ",
        "toplimit, park_year, ",
        "park_month, park_byway, ",
        "park_week, park_date, ",
        "park_time, car_types, ",
        "start_time, end_time, create_time, ",
        "is_status)",
        "values (#{id,jdbcType=INTEGER}, #{leagueId,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{freeTime,jdbcType=INTEGER}, ",
        "#{toplimit,jdbcType=INTEGER}, #{parkYear,jdbcType=VARCHAR}, ",
        "#{parkMonth,jdbcType=VARCHAR}, #{parkByway,jdbcType=BIT}, ",
        "#{parkWeek,jdbcType=VARCHAR}, #{parkDate,jdbcType=VARCHAR}, ",
        "#{parkTime,jdbcType=VARCHAR}, #{carTypes,jdbcType=VARCHAR}, ",
        "#{startTime,jdbcType=TIME}, #{endTime,jdbcType=TIME}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{isStatus,jdbcType=INTEGER})"
    })
    int insert(PwpPaymentRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_payment_rule
     *
     * @mbg.generated
     */
    @InsertProvider(type=PwpPaymentRuleSqlProvider.class, method="insertSelective")
    int insertSelective(PwpPaymentRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_payment_rule
     *
     * @mbg.generated
     */
    @SelectProvider(type=PwpPaymentRuleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="league_id", property="leagueId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="free_time", property="freeTime", jdbcType=JdbcType.INTEGER),
        @Result(column="toplimit", property="toplimit", jdbcType=JdbcType.INTEGER),
        @Result(column="park_year", property="parkYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="park_month", property="parkMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="park_byway", property="parkByway", jdbcType=JdbcType.BIT),
        @Result(column="park_week", property="parkWeek", jdbcType=JdbcType.VARCHAR),
        @Result(column="park_date", property="parkDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="park_time", property="parkTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_types", property="carTypes", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIME),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIME),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_status", property="isStatus", jdbcType=JdbcType.INTEGER)
    })
    List<PwpPaymentRule> selectByExample(PwpPaymentRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_payment_rule
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, league_id, name, free_time, toplimit, park_year, park_month, park_byway, ",
        "park_week, park_date, park_time, car_types, start_time, end_time, create_time, ",
        "is_status",
        "from pwp_payment_rule",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="league_id", property="leagueId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="free_time", property="freeTime", jdbcType=JdbcType.INTEGER),
        @Result(column="toplimit", property="toplimit", jdbcType=JdbcType.INTEGER),
        @Result(column="park_year", property="parkYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="park_month", property="parkMonth", jdbcType=JdbcType.VARCHAR),
        @Result(column="park_byway", property="parkByway", jdbcType=JdbcType.BIT),
        @Result(column="park_week", property="parkWeek", jdbcType=JdbcType.VARCHAR),
        @Result(column="park_date", property="parkDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="park_time", property="parkTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_types", property="carTypes", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIME),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIME),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_status", property="isStatus", jdbcType=JdbcType.INTEGER)
    })
    PwpPaymentRule selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_payment_rule
     *
     * @mbg.generated
     */
    @UpdateProvider(type=PwpPaymentRuleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PwpPaymentRule record, @Param("example") PwpPaymentRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_payment_rule
     *
     * @mbg.generated
     */
    @UpdateProvider(type=PwpPaymentRuleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PwpPaymentRule record, @Param("example") PwpPaymentRuleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_payment_rule
     *
     * @mbg.generated
     */
    @UpdateProvider(type=PwpPaymentRuleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PwpPaymentRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_payment_rule
     *
     * @mbg.generated
     */
    @Update({
        "update pwp_payment_rule",
        "set league_id = #{leagueId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "free_time = #{freeTime,jdbcType=INTEGER},",
          "toplimit = #{toplimit,jdbcType=INTEGER},",
          "park_year = #{parkYear,jdbcType=VARCHAR},",
          "park_month = #{parkMonth,jdbcType=VARCHAR},",
          "park_byway = #{parkByway,jdbcType=BIT},",
          "park_week = #{parkWeek,jdbcType=VARCHAR},",
          "park_date = #{parkDate,jdbcType=VARCHAR},",
          "park_time = #{parkTime,jdbcType=VARCHAR},",
          "car_types = #{carTypes,jdbcType=VARCHAR},",
          "start_time = #{startTime,jdbcType=TIME},",
          "end_time = #{endTime,jdbcType=TIME},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "is_status = #{isStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PwpPaymentRule record);
}