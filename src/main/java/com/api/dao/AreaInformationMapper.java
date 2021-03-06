package com.api.dao;

import com.api.dao.sqlProvider.AreaInformationSqlProvider;
import com.api.entity.AreaInformation;
import com.api.entity.AreaInformationCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface AreaInformationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_information
     *
     * @mbg.generated
     */
    @SelectProvider(type=AreaInformationSqlProvider.class, method="countByExample")
    long countByExample(AreaInformationCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_information
     *
     * @mbg.generated
     */
    @DeleteProvider(type=AreaInformationSqlProvider.class, method="deleteByExample")
    int deleteByExample(AreaInformationCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_information
     *
     * @mbg.generated
     */
    @Delete({
        "delete from area_information",
        "where Area_ID = #{areaId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer areaId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_information
     *
     * @mbg.generated
     */
    @Insert({
        "insert into area_information (Area_ID, Area_Name, ",
        "CreateTime, City_ID)",
        "values (#{areaId,jdbcType=INTEGER}, #{areaName,jdbcType=VARCHAR}, ",
        "#{createtime,jdbcType=TIMESTAMP}, #{cityId,jdbcType=INTEGER})"
    })
    int insert(AreaInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_information
     *
     * @mbg.generated
     */
    @InsertProvider(type=AreaInformationSqlProvider.class, method="insertSelective")
    int insertSelective(AreaInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_information
     *
     * @mbg.generated
     */
    @SelectProvider(type=AreaInformationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="Area_ID", property="areaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Area_Name", property="areaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="City_ID", property="cityId", jdbcType=JdbcType.INTEGER)
    })
    List<AreaInformation> selectByExample(AreaInformationCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_information
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "Area_ID, Area_Name, CreateTime, City_ID",
        "from area_information",
        "where Area_ID = #{areaId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Area_ID", property="areaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Area_Name", property="areaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="City_ID", property="cityId", jdbcType=JdbcType.INTEGER)
    })
    AreaInformation selectByPrimaryKey(Integer areaId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_information
     *
     * @mbg.generated
     */
    @UpdateProvider(type=AreaInformationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AreaInformation record, @Param("example") AreaInformationCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_information
     *
     * @mbg.generated
     */
    @UpdateProvider(type=AreaInformationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AreaInformation record, @Param("example") AreaInformationCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_information
     *
     * @mbg.generated
     */
    @UpdateProvider(type=AreaInformationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AreaInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table area_information
     *
     * @mbg.generated
     */
    @Update({
        "update area_information",
        "set Area_Name = #{areaName,jdbcType=VARCHAR},",
          "CreateTime = #{createtime,jdbcType=TIMESTAMP},",
          "City_ID = #{cityId,jdbcType=INTEGER}",
        "where Area_ID = #{areaId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AreaInformation record);
}