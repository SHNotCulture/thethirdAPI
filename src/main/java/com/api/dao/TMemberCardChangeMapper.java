package com.api.dao;

import com.api.dao.sqlProvider.TMemberCardChangeSqlProvider;
import com.api.entity.TMemberCardChange;
import com.api.entity.TMemberCardChangeCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TMemberCardChangeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member_card_change
     *
     * @mbg.generated
     */
    @SelectProvider(type= TMemberCardChangeSqlProvider.class, method="countByExample")
    long countByExample(TMemberCardChangeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member_card_change
     *
     * @mbg.generated
     */
    @DeleteProvider(type= TMemberCardChangeSqlProvider.class, method="deleteByExample")
    int deleteByExample(TMemberCardChangeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member_card_change
     *
     * @mbg.generated
     */
    @Delete({
        "delete from t_member_card_change",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member_card_change
     *
     * @mbg.generated
     */
    @Insert({
        "insert into t_member_card_change (id, member_detail_id, ",
        "car_num, ori_p_card_id, ",
        "ori_p_card_code, ori_p_card_pwd, ",
        "new_p_card_id, new_p_card_code, ",
        "new_p_card_pwd, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{memberDetailId,jdbcType=INTEGER}, ",
        "#{carNum,jdbcType=VARCHAR}, #{oriPCardId,jdbcType=VARCHAR}, ",
        "#{oriPCardCode,jdbcType=VARCHAR}, #{oriPCardPwd,jdbcType=VARCHAR}, ",
        "#{newPCardId,jdbcType=VARCHAR}, #{newPCardCode,jdbcType=VARCHAR}, ",
        "#{newPCardPwd,jdbcType=VARCHAR}, #{createTime,jdbcType=VARCHAR})"
    })
    int insert(TMemberCardChange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member_card_change
     *
     * @mbg.generated
     */
    @InsertProvider(type= TMemberCardChangeSqlProvider.class, method="insertSelective")
    int insertSelective(TMemberCardChange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member_card_change
     *
     * @mbg.generated
     */
    @SelectProvider(type= TMemberCardChangeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="member_detail_id", property="memberDetailId", jdbcType=JdbcType.INTEGER),
        @Result(column="car_num", property="carNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="ori_p_card_id", property="oriPCardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ori_p_card_code", property="oriPCardCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ori_p_card_pwd", property="oriPCardPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="new_p_card_id", property="newPCardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="new_p_card_code", property="newPCardCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="new_p_card_pwd", property="newPCardPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.VARCHAR)
    })
    List<TMemberCardChange> selectByExample(TMemberCardChangeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member_card_change
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, member_detail_id, car_num, ori_p_card_id, ori_p_card_code, ori_p_card_pwd, ",
        "new_p_card_id, new_p_card_code, new_p_card_pwd, create_time",
        "from t_member_card_change",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="member_detail_id", property="memberDetailId", jdbcType=JdbcType.INTEGER),
        @Result(column="car_num", property="carNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="ori_p_card_id", property="oriPCardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ori_p_card_code", property="oriPCardCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ori_p_card_pwd", property="oriPCardPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="new_p_card_id", property="newPCardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="new_p_card_code", property="newPCardCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="new_p_card_pwd", property="newPCardPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.VARCHAR)
    })
    TMemberCardChange selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member_card_change
     *
     * @mbg.generated
     */
    @UpdateProvider(type= TMemberCardChangeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TMemberCardChange record, @Param("example") TMemberCardChangeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member_card_change
     *
     * @mbg.generated
     */
    @UpdateProvider(type= TMemberCardChangeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TMemberCardChange record, @Param("example") TMemberCardChangeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member_card_change
     *
     * @mbg.generated
     */
    @UpdateProvider(type= TMemberCardChangeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TMemberCardChange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_member_card_change
     *
     * @mbg.generated
     */
    @Update({
        "update t_member_card_change",
        "set member_detail_id = #{memberDetailId,jdbcType=INTEGER},",
          "car_num = #{carNum,jdbcType=VARCHAR},",
          "ori_p_card_id = #{oriPCardId,jdbcType=VARCHAR},",
          "ori_p_card_code = #{oriPCardCode,jdbcType=VARCHAR},",
          "ori_p_card_pwd = #{oriPCardPwd,jdbcType=VARCHAR},",
          "new_p_card_id = #{newPCardId,jdbcType=VARCHAR},",
          "new_p_card_code = #{newPCardCode,jdbcType=VARCHAR},",
          "new_p_card_pwd = #{newPCardPwd,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TMemberCardChange record);
}