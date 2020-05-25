package com.api.dao;

import com.api.dao.sqlProvider.TDicQpasspayTypeSqlProvider;
import com.api.entity.TDicQpasspayType;
import com.api.entity.TDicQpasspayTypeCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TDicQpasspayTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dic_qpasspay_type
     *
     * @mbg.generated
     */
    @SelectProvider(type= TDicQpasspayTypeSqlProvider.class, method="countByExample")
    long countByExample(TDicQpasspayTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dic_qpasspay_type
     *
     * @mbg.generated
     */
    @DeleteProvider(type= TDicQpasspayTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(TDicQpasspayTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dic_qpasspay_type
     *
     * @mbg.generated
     */
    @Delete({
        "delete from t_dic_qpasspay_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dic_qpasspay_type
     *
     * @mbg.generated
     */
    @Insert({
        "insert into t_dic_qpasspay_type (id, paytype_id, ",
        "paytype_name, remarks)",
        "values (#{id,jdbcType=INTEGER}, #{paytypeId,jdbcType=INTEGER}, ",
        "#{paytypeName,jdbcType=VARCHAR}, #{remarks,jdbcType=VARCHAR})"
    })
    int insert(TDicQpasspayType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dic_qpasspay_type
     *
     * @mbg.generated
     */
    @InsertProvider(type= TDicQpasspayTypeSqlProvider.class, method="insertSelective")
    int insertSelective(TDicQpasspayType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dic_qpasspay_type
     *
     * @mbg.generated
     */
    @SelectProvider(type= TDicQpasspayTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="paytype_id", property="paytypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="paytype_name", property="paytypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR)
    })
    List<TDicQpasspayType> selectByExample(TDicQpasspayTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dic_qpasspay_type
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, paytype_id, paytype_name, remarks",
        "from t_dic_qpasspay_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="paytype_id", property="paytypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="paytype_name", property="paytypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR)
    })
    TDicQpasspayType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dic_qpasspay_type
     *
     * @mbg.generated
     */
    @UpdateProvider(type= TDicQpasspayTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TDicQpasspayType record, @Param("example") TDicQpasspayTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dic_qpasspay_type
     *
     * @mbg.generated
     */
    @UpdateProvider(type= TDicQpasspayTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TDicQpasspayType record, @Param("example") TDicQpasspayTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dic_qpasspay_type
     *
     * @mbg.generated
     */
    @UpdateProvider(type= TDicQpasspayTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TDicQpasspayType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dic_qpasspay_type
     *
     * @mbg.generated
     */
    @Update({
        "update t_dic_qpasspay_type",
        "set paytype_id = #{paytypeId,jdbcType=INTEGER},",
          "paytype_name = #{paytypeName,jdbcType=VARCHAR},",
          "remarks = #{remarks,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TDicQpasspayType record);
}