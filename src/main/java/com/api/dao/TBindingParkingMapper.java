package com.api.dao;

import com.api.dao.sqlProvider.TBindingParkingSqlProvider;
import com.api.entity.TBindingParking;
import com.api.entity.TBindingParkingCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TBindingParkingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    @SelectProvider(type=TBindingParkingSqlProvider.class, method="countByExample")
    long countByExample(TBindingParkingCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    @DeleteProvider(type=TBindingParkingSqlProvider.class, method="deleteByExample")
    int deleteByExample(TBindingParkingCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    @Delete({
        "delete from t_binding_parking",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    @Insert({
        "insert into t_binding_parking (id, park_id, ",
        "parking_no, car_type, ",
        "is_sync, park_car_name, ",
        "company_id, status, ",
        "begin_date, binding_name, ",
        "end_date, pay_rule, ",
        "is_use, car_plate, ",
        "park_code, remark)",
        "values (#{id,jdbcType=INTEGER}, #{parkId,jdbcType=INTEGER}, ",
        "#{parkingNo,jdbcType=INTEGER}, #{carType,jdbcType=INTEGER}, ",
        "#{isSync,jdbcType=INTEGER}, #{parkCarName,jdbcType=VARCHAR}, ",
        "#{companyId,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{beginDate,jdbcType=VARCHAR}, #{bindingName,jdbcType=VARCHAR}, ",
        "#{endDate,jdbcType=VARCHAR}, #{payRule,jdbcType=INTEGER}, ",
        "#{isUse,jdbcType=INTEGER}, #{carPlate,jdbcType=LONGVARCHAR}, ",
        "#{parkCode,jdbcType=LONGVARCHAR}, #{remark,jdbcType=LONGVARCHAR})"
    })
    int insert(TBindingParking record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    @InsertProvider(type=TBindingParkingSqlProvider.class, method="insertSelective")
    int insertSelective(TBindingParking record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    @SelectProvider(type=TBindingParkingSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="parking_no", property="parkingNo", jdbcType=JdbcType.INTEGER),
        @Result(column="car_type", property="carType", jdbcType=JdbcType.INTEGER),
        @Result(column="is_sync", property="isSync", jdbcType=JdbcType.INTEGER),
        @Result(column="park_car_name", property="parkCarName", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="begin_date", property="beginDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="binding_name", property="bindingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_rule", property="payRule", jdbcType=JdbcType.INTEGER),
        @Result(column="is_use", property="isUse", jdbcType=JdbcType.INTEGER),
        @Result(column="car_plate", property="carPlate", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="park_code", property="parkCode", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TBindingParking> selectByExampleWithBLOBs(TBindingParkingCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    @SelectProvider(type=TBindingParkingSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="parking_no", property="parkingNo", jdbcType=JdbcType.INTEGER),
        @Result(column="car_type", property="carType", jdbcType=JdbcType.INTEGER),
        @Result(column="is_sync", property="isSync", jdbcType=JdbcType.INTEGER),
        @Result(column="park_car_name", property="parkCarName", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="begin_date", property="beginDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="binding_name", property="bindingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_rule", property="payRule", jdbcType=JdbcType.INTEGER),
        @Result(column="is_use", property="isUse", jdbcType=JdbcType.INTEGER)
    })
    List<TBindingParking> selectByExample(TBindingParkingCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, park_id, parking_no, car_type, is_sync, park_car_name, company_id, status, ",
        "begin_date, binding_name, end_date, pay_rule, is_use, car_plate, park_code, ",
        "remark",
        "from t_binding_parking",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="parking_no", property="parkingNo", jdbcType=JdbcType.INTEGER),
        @Result(column="car_type", property="carType", jdbcType=JdbcType.INTEGER),
        @Result(column="is_sync", property="isSync", jdbcType=JdbcType.INTEGER),
        @Result(column="park_car_name", property="parkCarName", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="begin_date", property="beginDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="binding_name", property="bindingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_rule", property="payRule", jdbcType=JdbcType.INTEGER),
        @Result(column="is_use", property="isUse", jdbcType=JdbcType.INTEGER),
        @Result(column="car_plate", property="carPlate", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="park_code", property="parkCode", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.LONGVARCHAR)
    })
    TBindingParking selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TBindingParkingSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TBindingParking record, @Param("example") TBindingParkingCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TBindingParkingSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") TBindingParking record, @Param("example") TBindingParkingCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TBindingParkingSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TBindingParking record, @Param("example") TBindingParkingCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TBindingParkingSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBindingParking record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    @Update({
        "update t_binding_parking",
        "set park_id = #{parkId,jdbcType=INTEGER},",
          "parking_no = #{parkingNo,jdbcType=INTEGER},",
          "car_type = #{carType,jdbcType=INTEGER},",
          "is_sync = #{isSync,jdbcType=INTEGER},",
          "park_car_name = #{parkCarName,jdbcType=VARCHAR},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "begin_date = #{beginDate,jdbcType=VARCHAR},",
          "binding_name = #{bindingName,jdbcType=VARCHAR},",
          "end_date = #{endDate,jdbcType=VARCHAR},",
          "pay_rule = #{payRule,jdbcType=INTEGER},",
          "is_use = #{isUse,jdbcType=INTEGER},",
          "car_plate = #{carPlate,jdbcType=LONGVARCHAR},",
          "park_code = #{parkCode,jdbcType=LONGVARCHAR},",
          "remark = #{remark,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(TBindingParking record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    @Update({
        "update t_binding_parking",
        "set park_id = #{parkId,jdbcType=INTEGER},",
          "parking_no = #{parkingNo,jdbcType=INTEGER},",
          "car_type = #{carType,jdbcType=INTEGER},",
          "is_sync = #{isSync,jdbcType=INTEGER},",
          "park_car_name = #{parkCarName,jdbcType=VARCHAR},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "begin_date = #{beginDate,jdbcType=VARCHAR},",
          "binding_name = #{bindingName,jdbcType=VARCHAR},",
          "end_date = #{endDate,jdbcType=VARCHAR},",
          "pay_rule = #{payRule,jdbcType=INTEGER},",
          "is_use = #{isUse,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBindingParking record);
}