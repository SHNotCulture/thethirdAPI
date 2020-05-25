package com.api.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PwpMcardRuleCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    public PwpMcardRuleCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNull() {
            addCriterion("park_id is null");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNotNull() {
            addCriterion("park_id is not null");
            return (Criteria) this;
        }

        public Criteria andParkIdEqualTo(Integer value) {
            addCriterion("park_id =", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotEqualTo(Integer value) {
            addCriterion("park_id <>", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThan(Integer value) {
            addCriterion("park_id >", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("park_id >=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThan(Integer value) {
            addCriterion("park_id <", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThanOrEqualTo(Integer value) {
            addCriterion("park_id <=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdIn(List<Integer> values) {
            addCriterion("park_id in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotIn(List<Integer> values) {
            addCriterion("park_id not in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdBetween(Integer value1, Integer value2) {
            addCriterion("park_id between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("park_id not between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("type_name like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("type_name not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andDayCostIsNull() {
            addCriterion("day_cost is null");
            return (Criteria) this;
        }

        public Criteria andDayCostIsNotNull() {
            addCriterion("day_cost is not null");
            return (Criteria) this;
        }

        public Criteria andDayCostEqualTo(BigDecimal value) {
            addCriterion("day_cost =", value, "dayCost");
            return (Criteria) this;
        }

        public Criteria andDayCostNotEqualTo(BigDecimal value) {
            addCriterion("day_cost <>", value, "dayCost");
            return (Criteria) this;
        }

        public Criteria andDayCostGreaterThan(BigDecimal value) {
            addCriterion("day_cost >", value, "dayCost");
            return (Criteria) this;
        }

        public Criteria andDayCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("day_cost >=", value, "dayCost");
            return (Criteria) this;
        }

        public Criteria andDayCostLessThan(BigDecimal value) {
            addCriterion("day_cost <", value, "dayCost");
            return (Criteria) this;
        }

        public Criteria andDayCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("day_cost <=", value, "dayCost");
            return (Criteria) this;
        }

        public Criteria andDayCostIn(List<BigDecimal> values) {
            addCriterion("day_cost in", values, "dayCost");
            return (Criteria) this;
        }

        public Criteria andDayCostNotIn(List<BigDecimal> values) {
            addCriterion("day_cost not in", values, "dayCost");
            return (Criteria) this;
        }

        public Criteria andDayCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("day_cost between", value1, value2, "dayCost");
            return (Criteria) this;
        }

        public Criteria andDayCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("day_cost not between", value1, value2, "dayCost");
            return (Criteria) this;
        }

        public Criteria andMonthCostIsNull() {
            addCriterion("month_cost is null");
            return (Criteria) this;
        }

        public Criteria andMonthCostIsNotNull() {
            addCriterion("month_cost is not null");
            return (Criteria) this;
        }

        public Criteria andMonthCostEqualTo(BigDecimal value) {
            addCriterion("month_cost =", value, "monthCost");
            return (Criteria) this;
        }

        public Criteria andMonthCostNotEqualTo(BigDecimal value) {
            addCriterion("month_cost <>", value, "monthCost");
            return (Criteria) this;
        }

        public Criteria andMonthCostGreaterThan(BigDecimal value) {
            addCriterion("month_cost >", value, "monthCost");
            return (Criteria) this;
        }

        public Criteria andMonthCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("month_cost >=", value, "monthCost");
            return (Criteria) this;
        }

        public Criteria andMonthCostLessThan(BigDecimal value) {
            addCriterion("month_cost <", value, "monthCost");
            return (Criteria) this;
        }

        public Criteria andMonthCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("month_cost <=", value, "monthCost");
            return (Criteria) this;
        }

        public Criteria andMonthCostIn(List<BigDecimal> values) {
            addCriterion("month_cost in", values, "monthCost");
            return (Criteria) this;
        }

        public Criteria andMonthCostNotIn(List<BigDecimal> values) {
            addCriterion("month_cost not in", values, "monthCost");
            return (Criteria) this;
        }

        public Criteria andMonthCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_cost between", value1, value2, "monthCost");
            return (Criteria) this;
        }

        public Criteria andMonthCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_cost not between", value1, value2, "monthCost");
            return (Criteria) this;
        }

        public Criteria andSeasonCostIsNull() {
            addCriterion("season_cost is null");
            return (Criteria) this;
        }

        public Criteria andSeasonCostIsNotNull() {
            addCriterion("season_cost is not null");
            return (Criteria) this;
        }

        public Criteria andSeasonCostEqualTo(BigDecimal value) {
            addCriterion("season_cost =", value, "seasonCost");
            return (Criteria) this;
        }

        public Criteria andSeasonCostNotEqualTo(BigDecimal value) {
            addCriterion("season_cost <>", value, "seasonCost");
            return (Criteria) this;
        }

        public Criteria andSeasonCostGreaterThan(BigDecimal value) {
            addCriterion("season_cost >", value, "seasonCost");
            return (Criteria) this;
        }

        public Criteria andSeasonCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("season_cost >=", value, "seasonCost");
            return (Criteria) this;
        }

        public Criteria andSeasonCostLessThan(BigDecimal value) {
            addCriterion("season_cost <", value, "seasonCost");
            return (Criteria) this;
        }

        public Criteria andSeasonCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("season_cost <=", value, "seasonCost");
            return (Criteria) this;
        }

        public Criteria andSeasonCostIn(List<BigDecimal> values) {
            addCriterion("season_cost in", values, "seasonCost");
            return (Criteria) this;
        }

        public Criteria andSeasonCostNotIn(List<BigDecimal> values) {
            addCriterion("season_cost not in", values, "seasonCost");
            return (Criteria) this;
        }

        public Criteria andSeasonCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("season_cost between", value1, value2, "seasonCost");
            return (Criteria) this;
        }

        public Criteria andSeasonCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("season_cost not between", value1, value2, "seasonCost");
            return (Criteria) this;
        }

        public Criteria andYearCostIsNull() {
            addCriterion("year_cost is null");
            return (Criteria) this;
        }

        public Criteria andYearCostIsNotNull() {
            addCriterion("year_cost is not null");
            return (Criteria) this;
        }

        public Criteria andYearCostEqualTo(BigDecimal value) {
            addCriterion("year_cost =", value, "yearCost");
            return (Criteria) this;
        }

        public Criteria andYearCostNotEqualTo(BigDecimal value) {
            addCriterion("year_cost <>", value, "yearCost");
            return (Criteria) this;
        }

        public Criteria andYearCostGreaterThan(BigDecimal value) {
            addCriterion("year_cost >", value, "yearCost");
            return (Criteria) this;
        }

        public Criteria andYearCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("year_cost >=", value, "yearCost");
            return (Criteria) this;
        }

        public Criteria andYearCostLessThan(BigDecimal value) {
            addCriterion("year_cost <", value, "yearCost");
            return (Criteria) this;
        }

        public Criteria andYearCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("year_cost <=", value, "yearCost");
            return (Criteria) this;
        }

        public Criteria andYearCostIn(List<BigDecimal> values) {
            addCriterion("year_cost in", values, "yearCost");
            return (Criteria) this;
        }

        public Criteria andYearCostNotIn(List<BigDecimal> values) {
            addCriterion("year_cost not in", values, "yearCost");
            return (Criteria) this;
        }

        public Criteria andYearCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("year_cost between", value1, value2, "yearCost");
            return (Criteria) this;
        }

        public Criteria andYearCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("year_cost not between", value1, value2, "yearCost");
            return (Criteria) this;
        }

        public Criteria andRuleStatusIsNull() {
            addCriterion("rule_status is null");
            return (Criteria) this;
        }

        public Criteria andRuleStatusIsNotNull() {
            addCriterion("rule_status is not null");
            return (Criteria) this;
        }

        public Criteria andRuleStatusEqualTo(Byte value) {
            addCriterion("rule_status =", value, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusNotEqualTo(Byte value) {
            addCriterion("rule_status <>", value, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusGreaterThan(Byte value) {
            addCriterion("rule_status >", value, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("rule_status >=", value, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusLessThan(Byte value) {
            addCriterion("rule_status <", value, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusLessThanOrEqualTo(Byte value) {
            addCriterion("rule_status <=", value, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusIn(List<Byte> values) {
            addCriterion("rule_status in", values, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusNotIn(List<Byte> values) {
            addCriterion("rule_status not in", values, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusBetween(Byte value1, Byte value2) {
            addCriterion("rule_status between", value1, value2, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andRuleStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("rule_status not between", value1, value2, "ruleStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pwp_mcard_rule
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}