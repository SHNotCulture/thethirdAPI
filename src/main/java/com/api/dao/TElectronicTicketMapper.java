package com.api.dao;

import com.api.dao.sqlProvider.TElectronicTicketSqlProvider;
import com.api.entity.TElectronicTicket;
import com.api.entity.TElectronicTicketCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TElectronicTicketMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    @SelectProvider(type= TElectronicTicketSqlProvider.class, method="countByExample")
    long countByExample(TElectronicTicketCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    @DeleteProvider(type=TElectronicTicketSqlProvider.class, method="deleteByExample")
    int deleteByExample(TElectronicTicketCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    @Delete({
        "delete from t_electronic_ticket",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    @Insert({
        "insert into t_electronic_ticket (id, ticket_name, ",
        "ticket_type, ticket_value, ",
        "ticket_pay, permission_day, ",
        "company_id, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{ticketName,jdbcType=VARCHAR}, ",
        "#{ticketType,jdbcType=INTEGER}, #{ticketValue,jdbcType=DOUBLE}, ",
        "#{ticketPay,jdbcType=DOUBLE}, #{permissionDay,jdbcType=VARCHAR}, ",
        "#{companyId,jdbcType=INTEGER}, #{updateTime,jdbcType=VARCHAR})"
    })
    int insert(TElectronicTicket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    @InsertProvider(type=TElectronicTicketSqlProvider.class, method="insertSelective")
    int insertSelective(TElectronicTicket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    @SelectProvider(type=TElectronicTicketSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ticket_name", property="ticketName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ticket_type", property="ticketType", jdbcType=JdbcType.INTEGER),
        @Result(column="ticket_value", property="ticketValue", jdbcType=JdbcType.DOUBLE),
        @Result(column="ticket_pay", property="ticketPay", jdbcType=JdbcType.DOUBLE),
        @Result(column="permission_day", property="permissionDay", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR)
    })
    List<TElectronicTicket> selectByExample(TElectronicTicketCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, ticket_name, ticket_type, ticket_value, ticket_pay, permission_day, company_id, ",
        "update_time",
        "from t_electronic_ticket",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ticket_name", property="ticketName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ticket_type", property="ticketType", jdbcType=JdbcType.INTEGER),
        @Result(column="ticket_value", property="ticketValue", jdbcType=JdbcType.DOUBLE),
        @Result(column="ticket_pay", property="ticketPay", jdbcType=JdbcType.DOUBLE),
        @Result(column="permission_day", property="permissionDay", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR)
    })
    TElectronicTicket selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TElectronicTicketSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TElectronicTicket record, @Param("example") TElectronicTicketCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TElectronicTicketSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TElectronicTicket record, @Param("example") TElectronicTicketCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TElectronicTicketSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TElectronicTicket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_electronic_ticket
     *
     * @mbg.generated
     */
    @Update({
        "update t_electronic_ticket",
        "set ticket_name = #{ticketName,jdbcType=VARCHAR},",
          "ticket_type = #{ticketType,jdbcType=INTEGER},",
          "ticket_value = #{ticketValue,jdbcType=DOUBLE},",
          "ticket_pay = #{ticketPay,jdbcType=DOUBLE},",
          "permission_day = #{permissionDay,jdbcType=VARCHAR},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TElectronicTicket record);
}