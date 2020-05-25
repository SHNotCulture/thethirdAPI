package com.api.dao;

import com.api.dao.sqlProvider.PwpParkPortSqlProvider;
import com.api.entity.PwpParkPort;
import com.api.entity.PwpParkPortCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PwpParkPortMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_park_port
     *
     * @mbg.generated
     */
    @SelectProvider(type= PwpParkPortSqlProvider.class, method="countByExample")
    long countByExample(PwpParkPortCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_park_port
     *
     * @mbg.generated
     */
    @DeleteProvider(type= PwpParkPortSqlProvider.class, method="deleteByExample")
    int deleteByExample(PwpParkPortCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_park_port
     *
     * @mbg.generated
     */
    @Delete({
        "delete from pwp_park_port",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_park_port
     *
     * @mbg.generated
     */
    @Insert({
        "insert into pwp_park_port (id, park_id, ",
        "port_name, local_port_id, ",
        "port_status)",
        "values (#{id,jdbcType=INTEGER}, #{parkId,jdbcType=INTEGER}, ",
        "#{portName,jdbcType=VARCHAR}, #{localPortId,jdbcType=INTEGER}, ",
        "#{portStatus,jdbcType=TINYINT})"
    })
    int insert(PwpParkPort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_park_port
     *
     * @mbg.generated
     */
    @InsertProvider(type= PwpParkPortSqlProvider.class, method="insertSelective")
    int insertSelective(PwpParkPort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_park_port
     *
     * @mbg.generated
     */
    @SelectProvider(type= PwpParkPortSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="port_name", property="portName", jdbcType=JdbcType.VARCHAR),
        @Result(column="local_port_id", property="localPortId", jdbcType=JdbcType.INTEGER),
        @Result(column="port_status", property="portStatus", jdbcType=JdbcType.TINYINT)
    })
    List<PwpParkPort> selectByExample(PwpParkPortCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_park_port
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, park_id, port_name, local_port_id, port_status",
        "from pwp_park_port",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="port_name", property="portName", jdbcType=JdbcType.VARCHAR),
        @Result(column="local_port_id", property="localPortId", jdbcType=JdbcType.INTEGER),
        @Result(column="port_status", property="portStatus", jdbcType=JdbcType.TINYINT)
    })
    PwpParkPort selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_park_port
     *
     * @mbg.generated
     */
    @UpdateProvider(type= PwpParkPortSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PwpParkPort record, @Param("example") PwpParkPortCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_park_port
     *
     * @mbg.generated
     */
    @UpdateProvider(type= PwpParkPortSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PwpParkPort record, @Param("example") PwpParkPortCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_park_port
     *
     * @mbg.generated
     */
    @UpdateProvider(type= PwpParkPortSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PwpParkPort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_park_port
     *
     * @mbg.generated
     */
    @Update({
        "update pwp_park_port",
        "set park_id = #{parkId,jdbcType=INTEGER},",
          "port_name = #{portName,jdbcType=VARCHAR},",
          "local_port_id = #{localPortId,jdbcType=INTEGER},",
          "port_status = #{portStatus,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PwpParkPort record);
}