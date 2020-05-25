package com.api.entity;

import java.util.ArrayList;
import java.util.List;

public class TUserRoleCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    public TUserRoleCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
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
     * This method corresponds to the database table t_user_role
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
     * This method corresponds to the database table t_user_role
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
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
     * This class corresponds to the database table t_user_role
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

        public Criteria andCompanyUserIdIsNull() {
            addCriterion("company_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdIsNotNull() {
            addCriterion("company_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdEqualTo(Integer value) {
            addCriterion("company_user_id =", value, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdNotEqualTo(Integer value) {
            addCriterion("company_user_id <>", value, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdGreaterThan(Integer value) {
            addCriterion("company_user_id >", value, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_user_id >=", value, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdLessThan(Integer value) {
            addCriterion("company_user_id <", value, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_user_id <=", value, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdIn(List<Integer> values) {
            addCriterion("company_user_id in", values, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdNotIn(List<Integer> values) {
            addCriterion("company_user_id not in", values, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdBetween(Integer value1, Integer value2) {
            addCriterion("company_user_id between", value1, value2, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andCompanyUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_user_id not between", value1, value2, "companyUserId");
            return (Criteria) this;
        }

        public Criteria andRolePowerIdIsNull() {
            addCriterion("role_power_id is null");
            return (Criteria) this;
        }

        public Criteria andRolePowerIdIsNotNull() {
            addCriterion("role_power_id is not null");
            return (Criteria) this;
        }

        public Criteria andRolePowerIdEqualTo(Integer value) {
            addCriterion("role_power_id =", value, "rolePowerId");
            return (Criteria) this;
        }

        public Criteria andRolePowerIdNotEqualTo(Integer value) {
            addCriterion("role_power_id <>", value, "rolePowerId");
            return (Criteria) this;
        }

        public Criteria andRolePowerIdGreaterThan(Integer value) {
            addCriterion("role_power_id >", value, "rolePowerId");
            return (Criteria) this;
        }

        public Criteria andRolePowerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_power_id >=", value, "rolePowerId");
            return (Criteria) this;
        }

        public Criteria andRolePowerIdLessThan(Integer value) {
            addCriterion("role_power_id <", value, "rolePowerId");
            return (Criteria) this;
        }

        public Criteria andRolePowerIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_power_id <=", value, "rolePowerId");
            return (Criteria) this;
        }

        public Criteria andRolePowerIdIn(List<Integer> values) {
            addCriterion("role_power_id in", values, "rolePowerId");
            return (Criteria) this;
        }

        public Criteria andRolePowerIdNotIn(List<Integer> values) {
            addCriterion("role_power_id not in", values, "rolePowerId");
            return (Criteria) this;
        }

        public Criteria andRolePowerIdBetween(Integer value1, Integer value2) {
            addCriterion("role_power_id between", value1, value2, "rolePowerId");
            return (Criteria) this;
        }

        public Criteria andRolePowerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_power_id not between", value1, value2, "rolePowerId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_user_role
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
     * This class corresponds to the database table t_user_role
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