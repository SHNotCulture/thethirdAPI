package com.api.dao.sqlProvider;

import com.api.entity.TBindingParkingRecharge;
import com.api.entity.TBindingParkingRechargeCriteria;
import com.api.entity.TBindingParkingRechargeCriteria.Criteria;
import com.api.entity.TBindingParkingRechargeCriteria.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class TBindingParkingRechargeSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking_recharge
     *
     * @mbg.generated
     */
    public String countByExample(TBindingParkingRechargeCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_binding_parking_recharge");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking_recharge
     *
     * @mbg.generated
     */
    public String deleteByExample(TBindingParkingRechargeCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_binding_parking_recharge");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking_recharge
     *
     * @mbg.generated
     */
    public String insertSelective(TBindingParkingRecharge record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_binding_parking_recharge");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getActualPay() != null) {
            sql.VALUES("actual_pay", "#{actualPay,jdbcType=DOUBLE}");
        }
        
        if (record.getBeginDate() != null) {
            sql.VALUES("begin_date", "#{beginDate,jdbcType=VARCHAR}");
        }
        
        if (record.getBindingParkingId() != null) {
            sql.VALUES("binding_parking_id", "#{bindingParkingId,jdbcType=INTEGER}");
        }
        
        if (record.getCarPlate() != null) {
            sql.VALUES("car_plate", "#{carPlate,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.VALUES("company_id", "#{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getEndDate() != null) {
            sql.VALUES("end_date", "#{endDate,jdbcType=VARCHAR}");
        }
        
        if (record.getNeedPay() != null) {
            sql.VALUES("need_pay", "#{needPay,jdbcType=DOUBLE}");
        }
        
        if (record.getOperType() != null) {
            sql.VALUES("oper_type", "#{operType,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            sql.VALUES("park_id", "#{parkId,jdbcType=INTEGER}");
        }
        
        if (record.getPayCount() != null) {
            sql.VALUES("pay_count", "#{payCount,jdbcType=INTEGER}");
        }
        
        if (record.getPayRule() != null) {
            sql.VALUES("pay_rule", "#{payRule,jdbcType=INTEGER}");
        }
        
        if (record.getPayStandard() != null) {
            sql.VALUES("pay_standard", "#{payStandard,jdbcType=INTEGER}");
        }
        
        if (record.getPayTime() != null) {
            sql.VALUES("pay_time", "#{payTime,jdbcType=VARCHAR}");
        }
        
        if (record.getPayType() != null) {
            sql.VALUES("pay_type", "#{payType,jdbcType=INTEGER}");
        }
        
        if (record.getRechargeNo() != null) {
            sql.VALUES("recharge_no", "#{rechargeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking_recharge
     *
     * @mbg.generated
     */
    public String selectByExample(TBindingParkingRechargeCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("actual_pay");
        sql.SELECT("begin_date");
        sql.SELECT("binding_parking_id");
        sql.SELECT("car_plate");
        sql.SELECT("company_id");
        sql.SELECT("end_date");
        sql.SELECT("need_pay");
        sql.SELECT("oper_type");
        sql.SELECT("park_id");
        sql.SELECT("pay_count");
        sql.SELECT("pay_rule");
        sql.SELECT("pay_standard");
        sql.SELECT("pay_time");
        sql.SELECT("pay_type");
        sql.SELECT("recharge_no");
        sql.SELECT("remark");
        sql.FROM("t_binding_parking_recharge");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking_recharge
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TBindingParkingRecharge record = (TBindingParkingRecharge) parameter.get("record");
        TBindingParkingRechargeCriteria example = (TBindingParkingRechargeCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_binding_parking_recharge");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getActualPay() != null) {
            sql.SET("actual_pay = #{record.actualPay,jdbcType=DOUBLE}");
        }
        
        if (record.getBeginDate() != null) {
            sql.SET("begin_date = #{record.beginDate,jdbcType=VARCHAR}");
        }
        
        if (record.getBindingParkingId() != null) {
            sql.SET("binding_parking_id = #{record.bindingParkingId,jdbcType=INTEGER}");
        }
        
        if (record.getCarPlate() != null) {
            sql.SET("car_plate = #{record.carPlate,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("company_id = #{record.companyId,jdbcType=INTEGER}");
        }
        
        if (record.getEndDate() != null) {
            sql.SET("end_date = #{record.endDate,jdbcType=VARCHAR}");
        }
        
        if (record.getNeedPay() != null) {
            sql.SET("need_pay = #{record.needPay,jdbcType=DOUBLE}");
        }
        
        if (record.getOperType() != null) {
            sql.SET("oper_type = #{record.operType,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            sql.SET("park_id = #{record.parkId,jdbcType=INTEGER}");
        }
        
        if (record.getPayCount() != null) {
            sql.SET("pay_count = #{record.payCount,jdbcType=INTEGER}");
        }
        
        if (record.getPayRule() != null) {
            sql.SET("pay_rule = #{record.payRule,jdbcType=INTEGER}");
        }
        
        if (record.getPayStandard() != null) {
            sql.SET("pay_standard = #{record.payStandard,jdbcType=INTEGER}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{record.payTime,jdbcType=VARCHAR}");
        }
        
        if (record.getPayType() != null) {
            sql.SET("pay_type = #{record.payType,jdbcType=INTEGER}");
        }
        
        if (record.getRechargeNo() != null) {
            sql.SET("recharge_no = #{record.rechargeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking_recharge
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_binding_parking_recharge");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("actual_pay = #{record.actualPay,jdbcType=DOUBLE}");
        sql.SET("begin_date = #{record.beginDate,jdbcType=VARCHAR}");
        sql.SET("binding_parking_id = #{record.bindingParkingId,jdbcType=INTEGER}");
        sql.SET("car_plate = #{record.carPlate,jdbcType=VARCHAR}");
        sql.SET("company_id = #{record.companyId,jdbcType=INTEGER}");
        sql.SET("end_date = #{record.endDate,jdbcType=VARCHAR}");
        sql.SET("need_pay = #{record.needPay,jdbcType=DOUBLE}");
        sql.SET("oper_type = #{record.operType,jdbcType=INTEGER}");
        sql.SET("park_id = #{record.parkId,jdbcType=INTEGER}");
        sql.SET("pay_count = #{record.payCount,jdbcType=INTEGER}");
        sql.SET("pay_rule = #{record.payRule,jdbcType=INTEGER}");
        sql.SET("pay_standard = #{record.payStandard,jdbcType=INTEGER}");
        sql.SET("pay_time = #{record.payTime,jdbcType=VARCHAR}");
        sql.SET("pay_type = #{record.payType,jdbcType=INTEGER}");
        sql.SET("recharge_no = #{record.rechargeNo,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        
        TBindingParkingRechargeCriteria example = (TBindingParkingRechargeCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking_recharge
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(TBindingParkingRecharge record) {
        SQL sql = new SQL();
        sql.UPDATE("t_binding_parking_recharge");
        
        if (record.getActualPay() != null) {
            sql.SET("actual_pay = #{actualPay,jdbcType=DOUBLE}");
        }
        
        if (record.getBeginDate() != null) {
            sql.SET("begin_date = #{beginDate,jdbcType=VARCHAR}");
        }
        
        if (record.getBindingParkingId() != null) {
            sql.SET("binding_parking_id = #{bindingParkingId,jdbcType=INTEGER}");
        }
        
        if (record.getCarPlate() != null) {
            sql.SET("car_plate = #{carPlate,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("company_id = #{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getEndDate() != null) {
            sql.SET("end_date = #{endDate,jdbcType=VARCHAR}");
        }
        
        if (record.getNeedPay() != null) {
            sql.SET("need_pay = #{needPay,jdbcType=DOUBLE}");
        }
        
        if (record.getOperType() != null) {
            sql.SET("oper_type = #{operType,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            sql.SET("park_id = #{parkId,jdbcType=INTEGER}");
        }
        
        if (record.getPayCount() != null) {
            sql.SET("pay_count = #{payCount,jdbcType=INTEGER}");
        }
        
        if (record.getPayRule() != null) {
            sql.SET("pay_rule = #{payRule,jdbcType=INTEGER}");
        }
        
        if (record.getPayStandard() != null) {
            sql.SET("pay_standard = #{payStandard,jdbcType=INTEGER}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{payTime,jdbcType=VARCHAR}");
        }
        
        if (record.getPayType() != null) {
            sql.SET("pay_type = #{payType,jdbcType=INTEGER}");
        }
        
        if (record.getRechargeNo() != null) {
            sql.SET("recharge_no = #{rechargeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking_recharge
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, TBindingParkingRechargeCriteria example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}