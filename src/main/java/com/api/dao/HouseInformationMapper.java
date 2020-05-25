package com.api.dao;

import com.api.dao.sqlProvider.HouseInformationSqlProvider;
import com.api.entity.HouseInformation;
import com.api.entity.HouseInformationCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface HouseInformationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_information
     *
     * @mbg.generated
     */
    @SelectProvider(type= HouseInformationSqlProvider.class, method="countByExample")
    long countByExample(HouseInformationCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_information
     *
     * @mbg.generated
     */
    @DeleteProvider(type= HouseInformationSqlProvider.class, method="deleteByExample")
    int deleteByExample(HouseInformationCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_information
     *
     * @mbg.generated
     */
    @Delete({
        "delete from house_information",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_information
     *
     * @mbg.generated
     */
    @Insert({
        "insert into house_information (ID, Member_ID, ",
        "Community_ID, BuildingId, ",
        "Building, Untiid, ",
        "CreateTime)",
        "values (#{id,jdbcType=INTEGER}, #{memberId,jdbcType=INTEGER}, ",
        "#{communityId,jdbcType=VARCHAR}, #{buildingid,jdbcType=VARCHAR}, ",
        "#{building,jdbcType=VARCHAR}, #{untiid,jdbcType=VARCHAR}, ",
        "#{createtime,jdbcType=TIMESTAMP})"
    })
    int insert(HouseInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_information
     *
     * @mbg.generated
     */
    @InsertProvider(type= HouseInformationSqlProvider.class, method="insertSelective")
    int insertSelective(HouseInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_information
     *
     * @mbg.generated
     */
    @SelectProvider(type= HouseInformationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Member_ID", property="memberId", jdbcType=JdbcType.INTEGER),
        @Result(column="Community_ID", property="communityId", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingId", property="buildingid", jdbcType=JdbcType.VARCHAR),
        @Result(column="Building", property="building", jdbcType=JdbcType.VARCHAR),
        @Result(column="Untiid", property="untiid", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateTime", property="createtime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<HouseInformation> selectByExample(HouseInformationCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_information
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "ID, Member_ID, Community_ID, BuildingId, Building, Untiid, CreateTime",
        "from house_information",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Member_ID", property="memberId", jdbcType=JdbcType.INTEGER),
        @Result(column="Community_ID", property="communityId", jdbcType=JdbcType.VARCHAR),
        @Result(column="BuildingId", property="buildingid", jdbcType=JdbcType.VARCHAR),
        @Result(column="Building", property="building", jdbcType=JdbcType.VARCHAR),
        @Result(column="Untiid", property="untiid", jdbcType=JdbcType.VARCHAR),
        @Result(column="CreateTime", property="createtime", jdbcType=JdbcType.TIMESTAMP)
    })
    HouseInformation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_information
     *
     * @mbg.generated
     */
    @UpdateProvider(type= HouseInformationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HouseInformation record, @Param("example") HouseInformationCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_information
     *
     * @mbg.generated
     */
    @UpdateProvider(type= HouseInformationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HouseInformation record, @Param("example") HouseInformationCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_information
     *
     * @mbg.generated
     */
    @UpdateProvider(type= HouseInformationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HouseInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table house_information
     *
     * @mbg.generated
     */
    @Update({
        "update house_information",
        "set Member_ID = #{memberId,jdbcType=INTEGER},",
          "Community_ID = #{communityId,jdbcType=VARCHAR},",
          "BuildingId = #{buildingid,jdbcType=VARCHAR},",
          "Building = #{building,jdbcType=VARCHAR},",
          "Untiid = #{untiid,jdbcType=VARCHAR},",
          "CreateTime = #{createtime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HouseInformation record);
}