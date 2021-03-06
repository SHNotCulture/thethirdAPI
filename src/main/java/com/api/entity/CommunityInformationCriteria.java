package com.api.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunityInformationCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table community_information
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table community_information
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table community_information
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community_information
     *
     * @mbg.generated
     */
    public CommunityInformationCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community_information
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community_information
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community_information
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community_information
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community_information
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community_information
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community_information
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
     * This method corresponds to the database table community_information
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
     * This method corresponds to the database table community_information
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community_information
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
     * This class corresponds to the database table community_information
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNull() {
            addCriterion("Community_ID is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNotNull() {
            addCriterion("Community_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdEqualTo(String value) {
            addCriterion("Community_ID =", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotEqualTo(String value) {
            addCriterion("Community_ID <>", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThan(String value) {
            addCriterion("Community_ID >", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThanOrEqualTo(String value) {
            addCriterion("Community_ID >=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThan(String value) {
            addCriterion("Community_ID <", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThanOrEqualTo(String value) {
            addCriterion("Community_ID <=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLike(String value) {
            addCriterion("Community_ID like", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotLike(String value) {
            addCriterion("Community_ID not like", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIn(List<String> values) {
            addCriterion("Community_ID in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotIn(List<String> values) {
            addCriterion("Community_ID not in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdBetween(String value1, String value2) {
            addCriterion("Community_ID between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotBetween(String value1, String value2) {
            addCriterion("Community_ID not between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("Area_ID is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("Area_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("Area_ID =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("Area_ID <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("Area_ID >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Area_ID >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("Area_ID <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("Area_ID <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("Area_ID in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("Area_ID not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("Area_ID between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Area_ID not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIsNull() {
            addCriterion("Community_Name is null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIsNotNull() {
            addCriterion("Community_Name is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameEqualTo(String value) {
            addCriterion("Community_Name =", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotEqualTo(String value) {
            addCriterion("Community_Name <>", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThan(String value) {
            addCriterion("Community_Name >", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThanOrEqualTo(String value) {
            addCriterion("Community_Name >=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThan(String value) {
            addCriterion("Community_Name <", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThanOrEqualTo(String value) {
            addCriterion("Community_Name <=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLike(String value) {
            addCriterion("Community_Name like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotLike(String value) {
            addCriterion("Community_Name not like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIn(List<String> values) {
            addCriterion("Community_Name in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotIn(List<String> values) {
            addCriterion("Community_Name not in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameBetween(String value1, String value2) {
            addCriterion("Community_Name between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotBetween(String value1, String value2) {
            addCriterion("Community_Name not between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table community_information
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
     * This class corresponds to the database table community_information
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