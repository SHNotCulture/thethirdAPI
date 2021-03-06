package com.api.dao.sqlProvider;

import com.api.entity.TGlobalInfo;
import com.api.entity.TGlobalInfoCriteria;
import com.api.entity.TGlobalInfoCriteria.Criteria;
import com.api.entity.TGlobalInfoCriteria.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class TGlobalInfoSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_global_info
     *
     * @mbg.generated
     */
    public String countByExample(TGlobalInfoCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_global_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_global_info
     *
     * @mbg.generated
     */
    public String deleteByExample(TGlobalInfoCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_global_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_global_info
     *
     * @mbg.generated
     */
    public String insertSelective(TGlobalInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_global_info");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            sql.VALUES("park_id", "#{parkId,jdbcType=INTEGER}");
        }
        
        if (record.getParamContext() != null) {
            sql.VALUES("param_context", "#{paramContext,jdbcType=VARCHAR}");
        }
        
        if (record.getParamValue() != null) {
            sql.VALUES("param_value", "#{paramValue,jdbcType=VARCHAR}");
        }
        
        if (record.getParamDesc() != null) {
            sql.VALUES("param_desc", "#{paramDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupName() != null) {
            sql.VALUES("group_name", "#{groupName,jdbcType=VARCHAR}");
        }
        
        if (record.getParamNumber() != null) {
            sql.VALUES("param_number", "#{paramNumber,jdbcType=INTEGER}");
        }
        
        if (record.getParamType() != null) {
            sql.VALUES("param_type", "#{paramType,jdbcType=VARCHAR}");
        }
        
        if (record.getParamDefine() != null) {
            sql.VALUES("param_define", "#{paramDefine,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_global_info
     *
     * @mbg.generated
     */
    public String selectByExampleWithBLOBs(TGlobalInfoCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("park_id");
        sql.SELECT("param_context");
        sql.SELECT("param_value");
        sql.SELECT("param_desc");
        sql.SELECT("group_name");
        sql.SELECT("param_number");
        sql.SELECT("param_type");
        sql.SELECT("param_define");
        sql.FROM("t_global_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_global_info
     *
     * @mbg.generated
     */
    public String selectByExample(TGlobalInfoCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("park_id");
        sql.SELECT("param_context");
        sql.SELECT("param_value");
        sql.SELECT("param_desc");
        sql.SELECT("group_name");
        sql.SELECT("param_number");
        sql.SELECT("param_type");
        sql.FROM("t_global_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_global_info
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TGlobalInfo record = (TGlobalInfo) parameter.get("record");
        TGlobalInfoCriteria example = (TGlobalInfoCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_global_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getParkId() != null) {
            sql.SET("park_id = #{record.parkId,jdbcType=INTEGER}");
        }
        
        if (record.getParamContext() != null) {
            sql.SET("param_context = #{record.paramContext,jdbcType=VARCHAR}");
        }
        
        if (record.getParamValue() != null) {
            sql.SET("param_value = #{record.paramValue,jdbcType=VARCHAR}");
        }
        
        if (record.getParamDesc() != null) {
            sql.SET("param_desc = #{record.paramDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupName() != null) {
            sql.SET("group_name = #{record.groupName,jdbcType=VARCHAR}");
        }
        
        if (record.getParamNumber() != null) {
            sql.SET("param_number = #{record.paramNumber,jdbcType=INTEGER}");
        }
        
        if (record.getParamType() != null) {
            sql.SET("param_type = #{record.paramType,jdbcType=VARCHAR}");
        }
        
        if (record.getParamDefine() != null) {
            sql.SET("param_define = #{record.paramDefine,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_global_info
     *
     * @mbg.generated
     */
    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_global_info");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("park_id = #{record.parkId,jdbcType=INTEGER}");
        sql.SET("param_context = #{record.paramContext,jdbcType=VARCHAR}");
        sql.SET("param_value = #{record.paramValue,jdbcType=VARCHAR}");
        sql.SET("param_desc = #{record.paramDesc,jdbcType=VARCHAR}");
        sql.SET("group_name = #{record.groupName,jdbcType=VARCHAR}");
        sql.SET("param_number = #{record.paramNumber,jdbcType=INTEGER}");
        sql.SET("param_type = #{record.paramType,jdbcType=VARCHAR}");
        sql.SET("param_define = #{record.paramDefine,jdbcType=LONGVARCHAR}");
        
        TGlobalInfoCriteria example = (TGlobalInfoCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_global_info
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_global_info");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("park_id = #{record.parkId,jdbcType=INTEGER}");
        sql.SET("param_context = #{record.paramContext,jdbcType=VARCHAR}");
        sql.SET("param_value = #{record.paramValue,jdbcType=VARCHAR}");
        sql.SET("param_desc = #{record.paramDesc,jdbcType=VARCHAR}");
        sql.SET("group_name = #{record.groupName,jdbcType=VARCHAR}");
        sql.SET("param_number = #{record.paramNumber,jdbcType=INTEGER}");
        sql.SET("param_type = #{record.paramType,jdbcType=VARCHAR}");
        
        TGlobalInfoCriteria example = (TGlobalInfoCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_global_info
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(TGlobalInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("t_global_info");
        
        if (record.getParkId() != null) {
            sql.SET("park_id = #{parkId,jdbcType=INTEGER}");
        }
        
        if (record.getParamContext() != null) {
            sql.SET("param_context = #{paramContext,jdbcType=VARCHAR}");
        }
        
        if (record.getParamValue() != null) {
            sql.SET("param_value = #{paramValue,jdbcType=VARCHAR}");
        }
        
        if (record.getParamDesc() != null) {
            sql.SET("param_desc = #{paramDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupName() != null) {
            sql.SET("group_name = #{groupName,jdbcType=VARCHAR}");
        }
        
        if (record.getParamNumber() != null) {
            sql.SET("param_number = #{paramNumber,jdbcType=INTEGER}");
        }
        
        if (record.getParamType() != null) {
            sql.SET("param_type = #{paramType,jdbcType=VARCHAR}");
        }
        
        if (record.getParamDefine() != null) {
            sql.SET("param_define = #{paramDefine,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_global_info
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, TGlobalInfoCriteria example, boolean includeExamplePhrase) {
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