package com.api.entity;

import java.util.ArrayList;
import java.util.List;

public class PwpPowerRuleCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pwp_power_rule
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pwp_power_rule
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pwp_power_rule
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_power_rule
     *
     * @mbg.generated
     */
    public PwpPowerRuleCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_power_rule
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_power_rule
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_power_rule
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_power_rule
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_power_rule
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_power_rule
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_power_rule
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
     * This method corresponds to the database table pwp_power_rule
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
     * This method corresponds to the database table pwp_power_rule
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_power_rule
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
     * This class corresponds to the database table pwp_power_rule
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

        public Criteria andPowerRuleGroupIdIsNull() {
            addCriterion("power_rule_group_id is null");
            return (Criteria) this;
        }

        public Criteria andPowerRuleGroupIdIsNotNull() {
            addCriterion("power_rule_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andPowerRuleGroupIdEqualTo(String value) {
            addCriterion("power_rule_group_id =", value, "powerRuleGroupId");
            return (Criteria) this;
        }

        public Criteria andPowerRuleGroupIdNotEqualTo(String value) {
            addCriterion("power_rule_group_id <>", value, "powerRuleGroupId");
            return (Criteria) this;
        }

        public Criteria andPowerRuleGroupIdGreaterThan(String value) {
            addCriterion("power_rule_group_id >", value, "powerRuleGroupId");
            return (Criteria) this;
        }

        public Criteria andPowerRuleGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("power_rule_group_id >=", value, "powerRuleGroupId");
            return (Criteria) this;
        }

        public Criteria andPowerRuleGroupIdLessThan(String value) {
            addCriterion("power_rule_group_id <", value, "powerRuleGroupId");
            return (Criteria) this;
        }

        public Criteria andPowerRuleGroupIdLessThanOrEqualTo(String value) {
            addCriterion("power_rule_group_id <=", value, "powerRuleGroupId");
            return (Criteria) this;
        }

        public Criteria andPowerRuleGroupIdLike(String value) {
            addCriterion("power_rule_group_id like", value, "powerRuleGroupId");
            return (Criteria) this;
        }

        public Criteria andPowerRuleGroupIdNotLike(String value) {
            addCriterion("power_rule_group_id not like", value, "powerRuleGroupId");
            return (Criteria) this;
        }

        public Criteria andPowerRuleGroupIdIn(List<String> values) {
            addCriterion("power_rule_group_id in", values, "powerRuleGroupId");
            return (Criteria) this;
        }

        public Criteria andPowerRuleGroupIdNotIn(List<String> values) {
            addCriterion("power_rule_group_id not in", values, "powerRuleGroupId");
            return (Criteria) this;
        }

        public Criteria andPowerRuleGroupIdBetween(String value1, String value2) {
            addCriterion("power_rule_group_id between", value1, value2, "powerRuleGroupId");
            return (Criteria) this;
        }

        public Criteria andPowerRuleGroupIdNotBetween(String value1, String value2) {
            addCriterion("power_rule_group_id not between", value1, value2, "powerRuleGroupId");
            return (Criteria) this;
        }

        public Criteria andBelongIsNull() {
            addCriterion("belong is null");
            return (Criteria) this;
        }

        public Criteria andBelongIsNotNull() {
            addCriterion("belong is not null");
            return (Criteria) this;
        }

        public Criteria andBelongEqualTo(String value) {
            addCriterion("belong =", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotEqualTo(String value) {
            addCriterion("belong <>", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongGreaterThan(String value) {
            addCriterion("belong >", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongGreaterThanOrEqualTo(String value) {
            addCriterion("belong >=", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongLessThan(String value) {
            addCriterion("belong <", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongLessThanOrEqualTo(String value) {
            addCriterion("belong <=", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongLike(String value) {
            addCriterion("belong like", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotLike(String value) {
            addCriterion("belong not like", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongIn(List<String> values) {
            addCriterion("belong in", values, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotIn(List<String> values) {
            addCriterion("belong not in", values, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongBetween(String value1, String value2) {
            addCriterion("belong between", value1, value2, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotBetween(String value1, String value2) {
            addCriterion("belong not between", value1, value2, "belong");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pwp_power_rule
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
     * This class corresponds to the database table pwp_power_rule
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