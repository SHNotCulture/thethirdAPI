package com.api.dao.sqlProvider;

import com.api.entity.PwpMerchantTrade;
import com.api.entity.PwpMerchantTradeCriteria;
import com.api.entity.PwpMerchantTradeCriteria.Criteria;
import com.api.entity.PwpMerchantTradeCriteria.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PwpMerchantTradeSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    public String countByExample(PwpMerchantTradeCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("pwp_merchant_trade");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    public String deleteByExample(PwpMerchantTradeCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("pwp_merchant_trade");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    public String insertSelective(PwpMerchantTrade record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("pwp_merchant_trade");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantId() != null) {
            sql.VALUES("merchant_id", "#{merchantId,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantTradeNo() != null) {
            sql.VALUES("merchant_trade_no", "#{merchantTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantTradeType() != null) {
            sql.VALUES("merchant_trade_type", "#{merchantTradeType,jdbcType=TINYINT}");
        }
        
        if (record.getBillingAccountId() != null) {
            sql.VALUES("billing_account_id", "#{billingAccountId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeAmount() != null) {
            sql.VALUES("trade_amount", "#{tradeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getBalance() != null) {
            sql.VALUES("balance", "#{balance,jdbcType=DECIMAL}");
        }
        
        if (record.getTradeResult() != null) {
            sql.VALUES("trade_result", "#{tradeResult,jdbcType=TINYINT}");
        }
        
        if (record.getSyncResult() != null) {
            sql.VALUES("sync_result", "#{syncResult,jdbcType=TINYINT}");
        }
        
        if (record.getSyncTime() != null) {
            sql.VALUES("sync_time", "#{syncTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSyncId() != null) {
            sql.VALUES("sync_id", "#{syncId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    public String selectByExample(PwpMerchantTradeCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("merchant_id");
        sql.SELECT("merchant_trade_no");
        sql.SELECT("merchant_trade_type");
        sql.SELECT("billing_account_id");
        sql.SELECT("trade_amount");
        sql.SELECT("balance");
        sql.SELECT("trade_result");
        sql.SELECT("sync_result");
        sql.SELECT("sync_time");
        sql.SELECT("sync_id");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("pwp_merchant_trade");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        PwpMerchantTrade record = (PwpMerchantTrade) parameter.get("record");
        PwpMerchantTradeCriteria example = (PwpMerchantTradeCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("pwp_merchant_trade");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{record.merchantId,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantTradeNo() != null) {
            sql.SET("merchant_trade_no = #{record.merchantTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantTradeType() != null) {
            sql.SET("merchant_trade_type = #{record.merchantTradeType,jdbcType=TINYINT}");
        }
        
        if (record.getBillingAccountId() != null) {
            sql.SET("billing_account_id = #{record.billingAccountId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeAmount() != null) {
            sql.SET("trade_amount = #{record.tradeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getBalance() != null) {
            sql.SET("balance = #{record.balance,jdbcType=DECIMAL}");
        }
        
        if (record.getTradeResult() != null) {
            sql.SET("trade_result = #{record.tradeResult,jdbcType=TINYINT}");
        }
        
        if (record.getSyncResult() != null) {
            sql.SET("sync_result = #{record.syncResult,jdbcType=TINYINT}");
        }
        
        if (record.getSyncTime() != null) {
            sql.SET("sync_time = #{record.syncTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSyncId() != null) {
            sql.SET("sync_id = #{record.syncId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("pwp_merchant_trade");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("merchant_id = #{record.merchantId,jdbcType=INTEGER}");
        sql.SET("merchant_trade_no = #{record.merchantTradeNo,jdbcType=VARCHAR}");
        sql.SET("merchant_trade_type = #{record.merchantTradeType,jdbcType=TINYINT}");
        sql.SET("billing_account_id = #{record.billingAccountId,jdbcType=INTEGER}");
        sql.SET("trade_amount = #{record.tradeAmount,jdbcType=DECIMAL}");
        sql.SET("balance = #{record.balance,jdbcType=DECIMAL}");
        sql.SET("trade_result = #{record.tradeResult,jdbcType=TINYINT}");
        sql.SET("sync_result = #{record.syncResult,jdbcType=TINYINT}");
        sql.SET("sync_time = #{record.syncTime,jdbcType=TIMESTAMP}");
        sql.SET("sync_id = #{record.syncId,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        PwpMerchantTradeCriteria example = (PwpMerchantTradeCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(PwpMerchantTrade record) {
        SQL sql = new SQL();
        sql.UPDATE("pwp_merchant_trade");
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{merchantId,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantTradeNo() != null) {
            sql.SET("merchant_trade_no = #{merchantTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantTradeType() != null) {
            sql.SET("merchant_trade_type = #{merchantTradeType,jdbcType=TINYINT}");
        }
        
        if (record.getBillingAccountId() != null) {
            sql.SET("billing_account_id = #{billingAccountId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeAmount() != null) {
            sql.SET("trade_amount = #{tradeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getBalance() != null) {
            sql.SET("balance = #{balance,jdbcType=DECIMAL}");
        }
        
        if (record.getTradeResult() != null) {
            sql.SET("trade_result = #{tradeResult,jdbcType=TINYINT}");
        }
        
        if (record.getSyncResult() != null) {
            sql.SET("sync_result = #{syncResult,jdbcType=TINYINT}");
        }
        
        if (record.getSyncTime() != null) {
            sql.SET("sync_time = #{syncTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSyncId() != null) {
            sql.SET("sync_id = #{syncId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_merchant_trade
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, PwpMerchantTradeCriteria example, boolean includeExamplePhrase) {
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