package com.api.dao;

import com.api.dao.sqlProvider.TDatavRequestSqlProvider;
import com.api.entity.TDatavRequest;
import com.api.entity.TDatavRequestCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TDatavRequestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_datav_request
     *
     * @mbg.generated
     */
    @SelectProvider(type= TDatavRequestSqlProvider.class, method="countByExample")
    long countByExample(TDatavRequestCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_datav_request
     *
     * @mbg.generated
     */
    @DeleteProvider(type=TDatavRequestSqlProvider.class, method="deleteByExample")
    int deleteByExample(TDatavRequestCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_datav_request
     *
     * @mbg.generated
     */
    @Delete({
        "delete from t_datav_request",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_datav_request
     *
     * @mbg.generated
     */
    @Insert({
        "insert into t_datav_request (id, park_id, ",
        "create_time)",
        "values (#{id,jdbcType=INTEGER}, #{parkId,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=VARCHAR})"
    })
    int insert(TDatavRequest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_datav_request
     *
     * @mbg.generated
     */
    @InsertProvider(type=TDatavRequestSqlProvider.class, method="insertSelective")
    int insertSelective(TDatavRequest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_datav_request
     *
     * @mbg.generated
     */
    @SelectProvider(type=TDatavRequestSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.VARCHAR)
    })
    List<TDatavRequest> selectByExample(TDatavRequestCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_datav_request
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, park_id, create_time",
        "from t_datav_request",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.VARCHAR)
    })
    TDatavRequest selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_datav_request
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TDatavRequestSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TDatavRequest record, @Param("example") TDatavRequestCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_datav_request
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TDatavRequestSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TDatavRequest record, @Param("example") TDatavRequestCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_datav_request
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TDatavRequestSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TDatavRequest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_datav_request
     *
     * @mbg.generated
     */
    @Update({
        "update t_datav_request",
        "set park_id = #{parkId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TDatavRequest record);
}