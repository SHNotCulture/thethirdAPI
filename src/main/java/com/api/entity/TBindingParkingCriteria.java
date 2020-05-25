package com.api.entity;

import java.util.ArrayList;
import java.util.List;

public class TBindingParkingCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    public TBindingParkingCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
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
     * This method corresponds to the database table t_binding_parking
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
     * This method corresponds to the database table t_binding_parking
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_binding_parking
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
     * This class corresponds to the database table t_binding_parking
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

        public Criteria andParkingNoIsNull() {
            addCriterion("parking_no is null");
            return (Criteria) this;
        }

        public Criteria andParkingNoIsNotNull() {
            addCriterion("parking_no is not null");
            return (Criteria) this;
        }

        public Criteria andParkingNoEqualTo(Integer value) {
            addCriterion("parking_no =", value, "parkingNo");
            return (Criteria) this;
        }

        public Criteria andParkingNoNotEqualTo(Integer value) {
            addCriterion("parking_no <>", value, "parkingNo");
            return (Criteria) this;
        }

        public Criteria andParkingNoGreaterThan(Integer value) {
            addCriterion("parking_no >", value, "parkingNo");
            return (Criteria) this;
        }

        public Criteria andParkingNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("parking_no >=", value, "parkingNo");
            return (Criteria) this;
        }

        public Criteria andParkingNoLessThan(Integer value) {
            addCriterion("parking_no <", value, "parkingNo");
            return (Criteria) this;
        }

        public Criteria andParkingNoLessThanOrEqualTo(Integer value) {
            addCriterion("parking_no <=", value, "parkingNo");
            return (Criteria) this;
        }

        public Criteria andParkingNoIn(List<Integer> values) {
            addCriterion("parking_no in", values, "parkingNo");
            return (Criteria) this;
        }

        public Criteria andParkingNoNotIn(List<Integer> values) {
            addCriterion("parking_no not in", values, "parkingNo");
            return (Criteria) this;
        }

        public Criteria andParkingNoBetween(Integer value1, Integer value2) {
            addCriterion("parking_no between", value1, value2, "parkingNo");
            return (Criteria) this;
        }

        public Criteria andParkingNoNotBetween(Integer value1, Integer value2) {
            addCriterion("parking_no not between", value1, value2, "parkingNo");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNull() {
            addCriterion("car_type is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNotNull() {
            addCriterion("car_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeEqualTo(Integer value) {
            addCriterion("car_type =", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotEqualTo(Integer value) {
            addCriterion("car_type <>", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThan(Integer value) {
            addCriterion("car_type >", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_type >=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThan(Integer value) {
            addCriterion("car_type <", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThanOrEqualTo(Integer value) {
            addCriterion("car_type <=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeIn(List<Integer> values) {
            addCriterion("car_type in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotIn(List<Integer> values) {
            addCriterion("car_type not in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeBetween(Integer value1, Integer value2) {
            addCriterion("car_type between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("car_type not between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andIsSyncIsNull() {
            addCriterion("is_sync is null");
            return (Criteria) this;
        }

        public Criteria andIsSyncIsNotNull() {
            addCriterion("is_sync is not null");
            return (Criteria) this;
        }

        public Criteria andIsSyncEqualTo(Integer value) {
            addCriterion("is_sync =", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncNotEqualTo(Integer value) {
            addCriterion("is_sync <>", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncGreaterThan(Integer value) {
            addCriterion("is_sync >", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_sync >=", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncLessThan(Integer value) {
            addCriterion("is_sync <", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncLessThanOrEqualTo(Integer value) {
            addCriterion("is_sync <=", value, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncIn(List<Integer> values) {
            addCriterion("is_sync in", values, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncNotIn(List<Integer> values) {
            addCriterion("is_sync not in", values, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncBetween(Integer value1, Integer value2) {
            addCriterion("is_sync between", value1, value2, "isSync");
            return (Criteria) this;
        }

        public Criteria andIsSyncNotBetween(Integer value1, Integer value2) {
            addCriterion("is_sync not between", value1, value2, "isSync");
            return (Criteria) this;
        }

        public Criteria andParkCarNameIsNull() {
            addCriterion("park_car_name is null");
            return (Criteria) this;
        }

        public Criteria andParkCarNameIsNotNull() {
            addCriterion("park_car_name is not null");
            return (Criteria) this;
        }

        public Criteria andParkCarNameEqualTo(String value) {
            addCriterion("park_car_name =", value, "parkCarName");
            return (Criteria) this;
        }

        public Criteria andParkCarNameNotEqualTo(String value) {
            addCriterion("park_car_name <>", value, "parkCarName");
            return (Criteria) this;
        }

        public Criteria andParkCarNameGreaterThan(String value) {
            addCriterion("park_car_name >", value, "parkCarName");
            return (Criteria) this;
        }

        public Criteria andParkCarNameGreaterThanOrEqualTo(String value) {
            addCriterion("park_car_name >=", value, "parkCarName");
            return (Criteria) this;
        }

        public Criteria andParkCarNameLessThan(String value) {
            addCriterion("park_car_name <", value, "parkCarName");
            return (Criteria) this;
        }

        public Criteria andParkCarNameLessThanOrEqualTo(String value) {
            addCriterion("park_car_name <=", value, "parkCarName");
            return (Criteria) this;
        }

        public Criteria andParkCarNameLike(String value) {
            addCriterion("park_car_name like", value, "parkCarName");
            return (Criteria) this;
        }

        public Criteria andParkCarNameNotLike(String value) {
            addCriterion("park_car_name not like", value, "parkCarName");
            return (Criteria) this;
        }

        public Criteria andParkCarNameIn(List<String> values) {
            addCriterion("park_car_name in", values, "parkCarName");
            return (Criteria) this;
        }

        public Criteria andParkCarNameNotIn(List<String> values) {
            addCriterion("park_car_name not in", values, "parkCarName");
            return (Criteria) this;
        }

        public Criteria andParkCarNameBetween(String value1, String value2) {
            addCriterion("park_car_name between", value1, value2, "parkCarName");
            return (Criteria) this;
        }

        public Criteria andParkCarNameNotBetween(String value1, String value2) {
            addCriterion("park_car_name not between", value1, value2, "parkCarName");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("begin_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(String value) {
            addCriterion("begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(String value) {
            addCriterion("begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(String value) {
            addCriterion("begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(String value) {
            addCriterion("begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(String value) {
            addCriterion("begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(String value) {
            addCriterion("begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLike(String value) {
            addCriterion("begin_date like", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotLike(String value) {
            addCriterion("begin_date not like", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<String> values) {
            addCriterion("begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<String> values) {
            addCriterion("begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(String value1, String value2) {
            addCriterion("begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(String value1, String value2) {
            addCriterion("begin_date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBindingNameIsNull() {
            addCriterion("binding_name is null");
            return (Criteria) this;
        }

        public Criteria andBindingNameIsNotNull() {
            addCriterion("binding_name is not null");
            return (Criteria) this;
        }

        public Criteria andBindingNameEqualTo(String value) {
            addCriterion("binding_name =", value, "bindingName");
            return (Criteria) this;
        }

        public Criteria andBindingNameNotEqualTo(String value) {
            addCriterion("binding_name <>", value, "bindingName");
            return (Criteria) this;
        }

        public Criteria andBindingNameGreaterThan(String value) {
            addCriterion("binding_name >", value, "bindingName");
            return (Criteria) this;
        }

        public Criteria andBindingNameGreaterThanOrEqualTo(String value) {
            addCriterion("binding_name >=", value, "bindingName");
            return (Criteria) this;
        }

        public Criteria andBindingNameLessThan(String value) {
            addCriterion("binding_name <", value, "bindingName");
            return (Criteria) this;
        }

        public Criteria andBindingNameLessThanOrEqualTo(String value) {
            addCriterion("binding_name <=", value, "bindingName");
            return (Criteria) this;
        }

        public Criteria andBindingNameLike(String value) {
            addCriterion("binding_name like", value, "bindingName");
            return (Criteria) this;
        }

        public Criteria andBindingNameNotLike(String value) {
            addCriterion("binding_name not like", value, "bindingName");
            return (Criteria) this;
        }

        public Criteria andBindingNameIn(List<String> values) {
            addCriterion("binding_name in", values, "bindingName");
            return (Criteria) this;
        }

        public Criteria andBindingNameNotIn(List<String> values) {
            addCriterion("binding_name not in", values, "bindingName");
            return (Criteria) this;
        }

        public Criteria andBindingNameBetween(String value1, String value2) {
            addCriterion("binding_name between", value1, value2, "bindingName");
            return (Criteria) this;
        }

        public Criteria andBindingNameNotBetween(String value1, String value2) {
            addCriterion("binding_name not between", value1, value2, "bindingName");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(String value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(String value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(String value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(String value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(String value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLike(String value) {
            addCriterion("end_date like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotLike(String value) {
            addCriterion("end_date not like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<String> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<String> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(String value1, String value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(String value1, String value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andPayRuleIsNull() {
            addCriterion("pay_rule is null");
            return (Criteria) this;
        }

        public Criteria andPayRuleIsNotNull() {
            addCriterion("pay_rule is not null");
            return (Criteria) this;
        }

        public Criteria andPayRuleEqualTo(Integer value) {
            addCriterion("pay_rule =", value, "payRule");
            return (Criteria) this;
        }

        public Criteria andPayRuleNotEqualTo(Integer value) {
            addCriterion("pay_rule <>", value, "payRule");
            return (Criteria) this;
        }

        public Criteria andPayRuleGreaterThan(Integer value) {
            addCriterion("pay_rule >", value, "payRule");
            return (Criteria) this;
        }

        public Criteria andPayRuleGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_rule >=", value, "payRule");
            return (Criteria) this;
        }

        public Criteria andPayRuleLessThan(Integer value) {
            addCriterion("pay_rule <", value, "payRule");
            return (Criteria) this;
        }

        public Criteria andPayRuleLessThanOrEqualTo(Integer value) {
            addCriterion("pay_rule <=", value, "payRule");
            return (Criteria) this;
        }

        public Criteria andPayRuleIn(List<Integer> values) {
            addCriterion("pay_rule in", values, "payRule");
            return (Criteria) this;
        }

        public Criteria andPayRuleNotIn(List<Integer> values) {
            addCriterion("pay_rule not in", values, "payRule");
            return (Criteria) this;
        }

        public Criteria andPayRuleBetween(Integer value1, Integer value2) {
            addCriterion("pay_rule between", value1, value2, "payRule");
            return (Criteria) this;
        }

        public Criteria andPayRuleNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_rule not between", value1, value2, "payRule");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNull() {
            addCriterion("is_use is null");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNotNull() {
            addCriterion("is_use is not null");
            return (Criteria) this;
        }

        public Criteria andIsUseEqualTo(Integer value) {
            addCriterion("is_use =", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotEqualTo(Integer value) {
            addCriterion("is_use <>", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThan(Integer value) {
            addCriterion("is_use >", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_use >=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThan(Integer value) {
            addCriterion("is_use <", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThanOrEqualTo(Integer value) {
            addCriterion("is_use <=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseIn(List<Integer> values) {
            addCriterion("is_use in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotIn(List<Integer> values) {
            addCriterion("is_use not in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseBetween(Integer value1, Integer value2) {
            addCriterion("is_use between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotBetween(Integer value1, Integer value2) {
            addCriterion("is_use not between", value1, value2, "isUse");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_binding_parking
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
     * This class corresponds to the database table t_binding_parking
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