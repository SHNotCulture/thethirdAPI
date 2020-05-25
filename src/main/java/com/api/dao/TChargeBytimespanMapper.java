package com.api.dao;

import com.api.dao.sqlProvider.TChargeBytimespanSqlProvider;
import com.api.entity.TChargeBytimespan;
import com.api.entity.TChargeBytimespanCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TChargeBytimespanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_bytimespan
     *
     * @mbg.generated
     */
    @SelectProvider(type=TChargeBytimespanSqlProvider.class, method="countByExample")
    long countByExample(TChargeBytimespanCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_bytimespan
     *
     * @mbg.generated
     */
    @DeleteProvider(type=TChargeBytimespanSqlProvider.class, method="deleteByExample")
    int deleteByExample(TChargeBytimespanCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_bytimespan
     *
     * @mbg.generated
     */
    @Delete({
        "delete from t_charge_bytimespan",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_bytimespan
     *
     * @mbg.generated
     */
    @Insert({
        "insert into t_charge_bytimespan (id, begin_time_hour, ",
        "begin_time_minute, end_time_hour, ",
        "end_time_minute, type, ",
        "sta_flag, cascade_flag, ",
        "cascade_id, type_name, ",
        "fee, free_time, park_id, ",
        "loc_id, max_fee, comp_index)",
        "values (#{id,jdbcType=BIGINT}, #{beginTimeHour,jdbcType=INTEGER}, ",
        "#{beginTimeMinute,jdbcType=INTEGER}, #{endTimeHour,jdbcType=INTEGER}, ",
        "#{endTimeMinute,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{staFlag,jdbcType=INTEGER}, #{cascadeFlag,jdbcType=INTEGER}, ",
        "#{cascadeId,jdbcType=INTEGER}, #{typeName,jdbcType=VARCHAR}, ",
        "#{fee,jdbcType=REAL}, #{freeTime,jdbcType=INTEGER}, #{parkId,jdbcType=INTEGER}, ",
        "#{locId,jdbcType=INTEGER}, #{maxFee,jdbcType=REAL}, #{compIndex,jdbcType=VARCHAR})"
    })
    int insert(TChargeBytimespan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_bytimespan
     *
     * @mbg.generated
     */
    @InsertProvider(type=TChargeBytimespanSqlProvider.class, method="insertSelective")
    int insertSelective(TChargeBytimespan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_bytimespan
     *
     * @mbg.generated
     */
    @SelectProvider(type=TChargeBytimespanSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="begin_time_hour", property="beginTimeHour", jdbcType=JdbcType.INTEGER),
        @Result(column="begin_time_minute", property="beginTimeMinute", jdbcType=JdbcType.INTEGER),
        @Result(column="end_time_hour", property="endTimeHour", jdbcType=JdbcType.INTEGER),
        @Result(column="end_time_minute", property="endTimeMinute", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="sta_flag", property="staFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="cascade_flag", property="cascadeFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="cascade_id", property="cascadeId", jdbcType=JdbcType.INTEGER),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fee", property="fee", jdbcType=JdbcType.REAL),
        @Result(column="free_time", property="freeTime", jdbcType=JdbcType.INTEGER),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="loc_id", property="locId", jdbcType=JdbcType.INTEGER),
        @Result(column="max_fee", property="maxFee", jdbcType=JdbcType.REAL),
        @Result(column="comp_index", property="compIndex", jdbcType=JdbcType.VARCHAR)
    })
    List<TChargeBytimespan> selectByExample(TChargeBytimespanCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_bytimespan
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, begin_time_hour, begin_time_minute, end_time_hour, end_time_minute, type, ",
        "sta_flag, cascade_flag, cascade_id, type_name, fee, free_time, park_id, loc_id, ",
        "max_fee, comp_index",
        "from t_charge_bytimespan",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="begin_time_hour", property="beginTimeHour", jdbcType=JdbcType.INTEGER),
        @Result(column="begin_time_minute", property="beginTimeMinute", jdbcType=JdbcType.INTEGER),
        @Result(column="end_time_hour", property="endTimeHour", jdbcType=JdbcType.INTEGER),
        @Result(column="end_time_minute", property="endTimeMinute", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="sta_flag", property="staFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="cascade_flag", property="cascadeFlag", jdbcType=JdbcType.INTEGER),
        @Result(column="cascade_id", property="cascadeId", jdbcType=JdbcType.INTEGER),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fee", property="fee", jdbcType=JdbcType.REAL),
        @Result(column="free_time", property="freeTime", jdbcType=JdbcType.INTEGER),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="loc_id", property="locId", jdbcType=JdbcType.INTEGER),
        @Result(column="max_fee", property="maxFee", jdbcType=JdbcType.REAL),
        @Result(column="comp_index", property="compIndex", jdbcType=JdbcType.VARCHAR)
    })
    TChargeBytimespan selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_bytimespan
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TChargeBytimespanSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TChargeBytimespan record, @Param("example") TChargeBytimespanCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_bytimespan
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TChargeBytimespanSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TChargeBytimespan record, @Param("example") TChargeBytimespanCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_bytimespan
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TChargeBytimespanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TChargeBytimespan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_charge_bytimespan
     *
     * @mbg.generated
     */
    @Update({
        "update t_charge_bytimespan",
        "set begin_time_hour = #{beginTimeHour,jdbcType=INTEGER},",
          "begin_time_minute = #{beginTimeMinute,jdbcType=INTEGER},",
          "end_time_hour = #{endTimeHour,jdbcType=INTEGER},",
          "end_time_minute = #{endTimeMinute,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "sta_flag = #{staFlag,jdbcType=INTEGER},",
          "cascade_flag = #{cascadeFlag,jdbcType=INTEGER},",
          "cascade_id = #{cascadeId,jdbcType=INTEGER},",
          "type_name = #{typeName,jdbcType=VARCHAR},",
          "fee = #{fee,jdbcType=REAL},",
          "free_time = #{freeTime,jdbcType=INTEGER},",
          "park_id = #{parkId,jdbcType=INTEGER},",
          "loc_id = #{locId,jdbcType=INTEGER},",
          "max_fee = #{maxFee,jdbcType=REAL},",
          "comp_index = #{compIndex,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TChargeBytimespan record);
}