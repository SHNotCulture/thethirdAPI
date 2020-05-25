package com.api.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PwpMemberDetailTradeCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pwp_member_detail_trade
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pwp_member_detail_trade
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pwp_member_detail_trade
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_member_detail_trade
     *
     * @mbg.generated
     */
    public PwpMemberDetailTradeCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_member_detail_trade
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_member_detail_trade
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_member_detail_trade
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_member_detail_trade
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_member_detail_trade
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_member_detail_trade
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_member_detail_trade
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
     * This method corresponds to the database table pwp_member_detail_trade
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
     * This method corresponds to the database table pwp_member_detail_trade
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pwp_member_detail_trade
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
     * This class corresponds to the database table pwp_member_detail_trade
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

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andMemberDetailIdIsNull() {
            addCriterion("member_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberDetailIdIsNotNull() {
            addCriterion("member_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberDetailIdEqualTo(Integer value) {
            addCriterion("member_detail_id =", value, "memberDetailId");
            return (Criteria) this;
        }

        public Criteria andMemberDetailIdNotEqualTo(Integer value) {
            addCriterion("member_detail_id <>", value, "memberDetailId");
            return (Criteria) this;
        }

        public Criteria andMemberDetailIdGreaterThan(Integer value) {
            addCriterion("member_detail_id >", value, "memberDetailId");
            return (Criteria) this;
        }

        public Criteria andMemberDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_detail_id >=", value, "memberDetailId");
            return (Criteria) this;
        }

        public Criteria andMemberDetailIdLessThan(Integer value) {
            addCriterion("member_detail_id <", value, "memberDetailId");
            return (Criteria) this;
        }

        public Criteria andMemberDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_detail_id <=", value, "memberDetailId");
            return (Criteria) this;
        }

        public Criteria andMemberDetailIdIn(List<Integer> values) {
            addCriterion("member_detail_id in", values, "memberDetailId");
            return (Criteria) this;
        }

        public Criteria andMemberDetailIdNotIn(List<Integer> values) {
            addCriterion("member_detail_id not in", values, "memberDetailId");
            return (Criteria) this;
        }

        public Criteria andMemberDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("member_detail_id between", value1, value2, "memberDetailId");
            return (Criteria) this;
        }

        public Criteria andMemberDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_detail_id not between", value1, value2, "memberDetailId");
            return (Criteria) this;
        }

        public Criteria andCarNumIsNull() {
            addCriterion("car_num is null");
            return (Criteria) this;
        }

        public Criteria andCarNumIsNotNull() {
            addCriterion("car_num is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumEqualTo(String value) {
            addCriterion("car_num =", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotEqualTo(String value) {
            addCriterion("car_num <>", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumGreaterThan(String value) {
            addCriterion("car_num >", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumGreaterThanOrEqualTo(String value) {
            addCriterion("car_num >=", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumLessThan(String value) {
            addCriterion("car_num <", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumLessThanOrEqualTo(String value) {
            addCriterion("car_num <=", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumLike(String value) {
            addCriterion("car_num like", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotLike(String value) {
            addCriterion("car_num not like", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumIn(List<String> values) {
            addCriterion("car_num in", values, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotIn(List<String> values) {
            addCriterion("car_num not in", values, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumBetween(String value1, String value2) {
            addCriterion("car_num between", value1, value2, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotBetween(String value1, String value2) {
            addCriterion("car_num not between", value1, value2, "carNum");
            return (Criteria) this;
        }

        public Criteria andPCardCodeIsNull() {
            addCriterion("p_card_code is null");
            return (Criteria) this;
        }

        public Criteria andPCardCodeIsNotNull() {
            addCriterion("p_card_code is not null");
            return (Criteria) this;
        }

        public Criteria andPCardCodeEqualTo(String value) {
            addCriterion("p_card_code =", value, "pCardCode");
            return (Criteria) this;
        }

        public Criteria andPCardCodeNotEqualTo(String value) {
            addCriterion("p_card_code <>", value, "pCardCode");
            return (Criteria) this;
        }

        public Criteria andPCardCodeGreaterThan(String value) {
            addCriterion("p_card_code >", value, "pCardCode");
            return (Criteria) this;
        }

        public Criteria andPCardCodeGreaterThanOrEqualTo(String value) {
            addCriterion("p_card_code >=", value, "pCardCode");
            return (Criteria) this;
        }

        public Criteria andPCardCodeLessThan(String value) {
            addCriterion("p_card_code <", value, "pCardCode");
            return (Criteria) this;
        }

        public Criteria andPCardCodeLessThanOrEqualTo(String value) {
            addCriterion("p_card_code <=", value, "pCardCode");
            return (Criteria) this;
        }

        public Criteria andPCardCodeLike(String value) {
            addCriterion("p_card_code like", value, "pCardCode");
            return (Criteria) this;
        }

        public Criteria andPCardCodeNotLike(String value) {
            addCriterion("p_card_code not like", value, "pCardCode");
            return (Criteria) this;
        }

        public Criteria andPCardCodeIn(List<String> values) {
            addCriterion("p_card_code in", values, "pCardCode");
            return (Criteria) this;
        }

        public Criteria andPCardCodeNotIn(List<String> values) {
            addCriterion("p_card_code not in", values, "pCardCode");
            return (Criteria) this;
        }

        public Criteria andPCardCodeBetween(String value1, String value2) {
            addCriterion("p_card_code between", value1, value2, "pCardCode");
            return (Criteria) this;
        }

        public Criteria andPCardCodeNotBetween(String value1, String value2) {
            addCriterion("p_card_code not between", value1, value2, "pCardCode");
            return (Criteria) this;
        }

        public Criteria andPCardIdIsNull() {
            addCriterion("p_card_id is null");
            return (Criteria) this;
        }

        public Criteria andPCardIdIsNotNull() {
            addCriterion("p_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andPCardIdEqualTo(String value) {
            addCriterion("p_card_id =", value, "pCardId");
            return (Criteria) this;
        }

        public Criteria andPCardIdNotEqualTo(String value) {
            addCriterion("p_card_id <>", value, "pCardId");
            return (Criteria) this;
        }

        public Criteria andPCardIdGreaterThan(String value) {
            addCriterion("p_card_id >", value, "pCardId");
            return (Criteria) this;
        }

        public Criteria andPCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("p_card_id >=", value, "pCardId");
            return (Criteria) this;
        }

        public Criteria andPCardIdLessThan(String value) {
            addCriterion("p_card_id <", value, "pCardId");
            return (Criteria) this;
        }

        public Criteria andPCardIdLessThanOrEqualTo(String value) {
            addCriterion("p_card_id <=", value, "pCardId");
            return (Criteria) this;
        }

        public Criteria andPCardIdLike(String value) {
            addCriterion("p_card_id like", value, "pCardId");
            return (Criteria) this;
        }

        public Criteria andPCardIdNotLike(String value) {
            addCriterion("p_card_id not like", value, "pCardId");
            return (Criteria) this;
        }

        public Criteria andPCardIdIn(List<String> values) {
            addCriterion("p_card_id in", values, "pCardId");
            return (Criteria) this;
        }

        public Criteria andPCardIdNotIn(List<String> values) {
            addCriterion("p_card_id not in", values, "pCardId");
            return (Criteria) this;
        }

        public Criteria andPCardIdBetween(String value1, String value2) {
            addCriterion("p_card_id between", value1, value2, "pCardId");
            return (Criteria) this;
        }

        public Criteria andPCardIdNotBetween(String value1, String value2) {
            addCriterion("p_card_id not between", value1, value2, "pCardId");
            return (Criteria) this;
        }

        public Criteria andPCardPwdIsNull() {
            addCriterion("p_card_pwd is null");
            return (Criteria) this;
        }

        public Criteria andPCardPwdIsNotNull() {
            addCriterion("p_card_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPCardPwdEqualTo(String value) {
            addCriterion("p_card_pwd =", value, "pCardPwd");
            return (Criteria) this;
        }

        public Criteria andPCardPwdNotEqualTo(String value) {
            addCriterion("p_card_pwd <>", value, "pCardPwd");
            return (Criteria) this;
        }

        public Criteria andPCardPwdGreaterThan(String value) {
            addCriterion("p_card_pwd >", value, "pCardPwd");
            return (Criteria) this;
        }

        public Criteria andPCardPwdGreaterThanOrEqualTo(String value) {
            addCriterion("p_card_pwd >=", value, "pCardPwd");
            return (Criteria) this;
        }

        public Criteria andPCardPwdLessThan(String value) {
            addCriterion("p_card_pwd <", value, "pCardPwd");
            return (Criteria) this;
        }

        public Criteria andPCardPwdLessThanOrEqualTo(String value) {
            addCriterion("p_card_pwd <=", value, "pCardPwd");
            return (Criteria) this;
        }

        public Criteria andPCardPwdLike(String value) {
            addCriterion("p_card_pwd like", value, "pCardPwd");
            return (Criteria) this;
        }

        public Criteria andPCardPwdNotLike(String value) {
            addCriterion("p_card_pwd not like", value, "pCardPwd");
            return (Criteria) this;
        }

        public Criteria andPCardPwdIn(List<String> values) {
            addCriterion("p_card_pwd in", values, "pCardPwd");
            return (Criteria) this;
        }

        public Criteria andPCardPwdNotIn(List<String> values) {
            addCriterion("p_card_pwd not in", values, "pCardPwd");
            return (Criteria) this;
        }

        public Criteria andPCardPwdBetween(String value1, String value2) {
            addCriterion("p_card_pwd between", value1, value2, "pCardPwd");
            return (Criteria) this;
        }

        public Criteria andPCardPwdNotBetween(String value1, String value2) {
            addCriterion("p_card_pwd not between", value1, value2, "pCardPwd");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNull() {
            addCriterion("trade_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNotNull() {
            addCriterion("trade_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountEqualTo(BigDecimal value) {
            addCriterion("trade_amount =", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotEqualTo(BigDecimal value) {
            addCriterion("trade_amount <>", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThan(BigDecimal value) {
            addCriterion("trade_amount >", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("trade_amount >=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThan(BigDecimal value) {
            addCriterion("trade_amount <", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("trade_amount <=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIn(List<BigDecimal> values) {
            addCriterion("trade_amount in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotIn(List<BigDecimal> values) {
            addCriterion("trade_amount not in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trade_amount between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trade_amount not between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance not between", value1, value2, "balance");
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

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(Short value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(Short value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(Short value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(Short value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(Short value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<Short> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<Short> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(Short value1, Short value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(Short value1, Short value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeResultIsNull() {
            addCriterion("trade_result is null");
            return (Criteria) this;
        }

        public Criteria andTradeResultIsNotNull() {
            addCriterion("trade_result is not null");
            return (Criteria) this;
        }

        public Criteria andTradeResultEqualTo(Byte value) {
            addCriterion("trade_result =", value, "tradeResult");
            return (Criteria) this;
        }

        public Criteria andTradeResultNotEqualTo(Byte value) {
            addCriterion("trade_result <>", value, "tradeResult");
            return (Criteria) this;
        }

        public Criteria andTradeResultGreaterThan(Byte value) {
            addCriterion("trade_result >", value, "tradeResult");
            return (Criteria) this;
        }

        public Criteria andTradeResultGreaterThanOrEqualTo(Byte value) {
            addCriterion("trade_result >=", value, "tradeResult");
            return (Criteria) this;
        }

        public Criteria andTradeResultLessThan(Byte value) {
            addCriterion("trade_result <", value, "tradeResult");
            return (Criteria) this;
        }

        public Criteria andTradeResultLessThanOrEqualTo(Byte value) {
            addCriterion("trade_result <=", value, "tradeResult");
            return (Criteria) this;
        }

        public Criteria andTradeResultIn(List<Byte> values) {
            addCriterion("trade_result in", values, "tradeResult");
            return (Criteria) this;
        }

        public Criteria andTradeResultNotIn(List<Byte> values) {
            addCriterion("trade_result not in", values, "tradeResult");
            return (Criteria) this;
        }

        public Criteria andTradeResultBetween(Byte value1, Byte value2) {
            addCriterion("trade_result between", value1, value2, "tradeResult");
            return (Criteria) this;
        }

        public Criteria andTradeResultNotBetween(Byte value1, Byte value2) {
            addCriterion("trade_result not between", value1, value2, "tradeResult");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
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

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pwp_member_detail_trade
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
     * This class corresponds to the database table pwp_member_detail_trade
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