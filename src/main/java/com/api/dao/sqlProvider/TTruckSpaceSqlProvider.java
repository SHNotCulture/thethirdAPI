package com.api.dao.sqlProvider;

import com.api.entity.TTruckSpace;
import com.api.entity.TTruckSpaceCriteria;
import com.api.entity.TTruckSpaceCriteria.Criteria;
import com.api.entity.TTruckSpaceCriteria.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class TTruckSpaceSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_truck_space
     *
     * @mbg.generated
     */
    public String countByExample(TTruckSpaceCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_truck_space");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_truck_space
     *
     * @mbg.generated
     */
    public String deleteByExample(TTruckSpaceCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_truck_space");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_truck_space
     *
     * @mbg.generated
     */
    public String insertSelective(TTruckSpace record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_truck_space");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getParkCode() != null) {
            sql.VALUES("park_code", "#{parkCode,jdbcType=VARCHAR}");
        }
        
        if (record.getParkingSpace() != null) {
            sql.VALUES("parking_space", "#{parkingSpace,jdbcType=INTEGER}");
        }
        
        if (record.getParkingState() != null) {
            sql.VALUES("parking_state", "#{parkingState,jdbcType=INTEGER}");
        }
        
        if (record.getTheirCarPlate() != null) {
            sql.VALUES("their_car_plate", "#{theirCarPlate,jdbcType=VARCHAR}");
        }
        
        if (record.getUseCarPlate() != null) {
            sql.VALUES("use_car_plate", "#{useCarPlate,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.VALUES("company_id", "#{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            sql.VALUES("park_id", "#{parkId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_truck_space
     *
     * @mbg.generated
     */
    public String selectByExample(TTruckSpaceCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("park_code");
        sql.SELECT("parking_space");
        sql.SELECT("parking_state");
        sql.SELECT("their_car_plate");
        sql.SELECT("use_car_plate");
        sql.SELECT("company_id");
        sql.SELECT("park_id");
        sql.FROM("t_truck_space");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_truck_space
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TTruckSpace record = (TTruckSpace) parameter.get("record");
        TTruckSpaceCriteria example = (TTruckSpaceCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_truck_space");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getParkCode() != null) {
            sql.SET("park_code = #{record.parkCode,jdbcType=VARCHAR}");
        }
        
        if (record.getParkingSpace() != null) {
            sql.SET("parking_space = #{record.parkingSpace,jdbcType=INTEGER}");
        }
        
        if (record.getParkingState() != null) {
            sql.SET("parking_state = #{record.parkingState,jdbcType=INTEGER}");
        }
        
        if (record.getTheirCarPlate() != null) {
            sql.SET("their_car_plate = #{record.theirCarPlate,jdbcType=VARCHAR}");
        }
        
        if (record.getUseCarPlate() != null) {
            sql.SET("use_car_plate = #{record.useCarPlate,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("company_id = #{record.companyId,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            sql.SET("park_id = #{record.parkId,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_truck_space
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_truck_space");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("park_code = #{record.parkCode,jdbcType=VARCHAR}");
        sql.SET("parking_space = #{record.parkingSpace,jdbcType=INTEGER}");
        sql.SET("parking_state = #{record.parkingState,jdbcType=INTEGER}");
        sql.SET("their_car_plate = #{record.theirCarPlate,jdbcType=VARCHAR}");
        sql.SET("use_car_plate = #{record.useCarPlate,jdbcType=VARCHAR}");
        sql.SET("company_id = #{record.companyId,jdbcType=INTEGER}");
        sql.SET("park_id = #{record.parkId,jdbcType=INTEGER}");
        
        TTruckSpaceCriteria example = (TTruckSpaceCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_truck_space
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(TTruckSpace record) {
        SQL sql = new SQL();
        sql.UPDATE("t_truck_space");
        
        if (record.getParkCode() != null) {
            sql.SET("park_code = #{parkCode,jdbcType=VARCHAR}");
        }
        
        if (record.getParkingSpace() != null) {
            sql.SET("parking_space = #{parkingSpace,jdbcType=INTEGER}");
        }
        
        if (record.getParkingState() != null) {
            sql.SET("parking_state = #{parkingState,jdbcType=INTEGER}");
        }
        
        if (record.getTheirCarPlate() != null) {
            sql.SET("their_car_plate = #{theirCarPlate,jdbcType=VARCHAR}");
        }
        
        if (record.getUseCarPlate() != null) {
            sql.SET("use_car_plate = #{useCarPlate,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyId() != null) {
            sql.SET("company_id = #{companyId,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            sql.SET("park_id = #{parkId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_truck_space
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, TTruckSpaceCriteria example, boolean includeExamplePhrase) {
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