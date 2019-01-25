package com.tomcat360.admin.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbEquipmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipmentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoIsNull() {
            addCriterion("equipment_no is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoIsNotNull() {
            addCriterion("equipment_no is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoEqualTo(Long value) {
            addCriterion("equipment_no =", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotEqualTo(Long value) {
            addCriterion("equipment_no <>", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoGreaterThan(Long value) {
            addCriterion("equipment_no >", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoGreaterThanOrEqualTo(Long value) {
            addCriterion("equipment_no >=", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoLessThan(Long value) {
            addCriterion("equipment_no <", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoLessThanOrEqualTo(Long value) {
            addCriterion("equipment_no <=", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoIn(List<Long> values) {
            addCriterion("equipment_no in", values, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotIn(List<Long> values) {
            addCriterion("equipment_no not in", values, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoBetween(Long value1, Long value2) {
            addCriterion("equipment_no between", value1, value2, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotBetween(Long value1, Long value2) {
            addCriterion("equipment_no not between", value1, value2, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIsNull() {
            addCriterion("detail_address is null");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIsNotNull() {
            addCriterion("detail_address is not null");
            return (Criteria) this;
        }

        public Criteria andDetailAddressEqualTo(String value) {
            addCriterion("detail_address =", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotEqualTo(String value) {
            addCriterion("detail_address <>", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThan(String value) {
            addCriterion("detail_address >", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detail_address >=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThan(String value) {
            addCriterion("detail_address <", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThanOrEqualTo(String value) {
            addCriterion("detail_address <=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLike(String value) {
            addCriterion("detail_address like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotLike(String value) {
            addCriterion("detail_address not like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIn(List<String> values) {
            addCriterion("detail_address in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotIn(List<String> values) {
            addCriterion("detail_address not in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressBetween(String value1, String value2) {
            addCriterion("detail_address between", value1, value2, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotBetween(String value1, String value2) {
            addCriterion("detail_address not between", value1, value2, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeIsNull() {
            addCriterion("online_time is null");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeIsNotNull() {
            addCriterion("online_time is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeEqualTo(Date value) {
            addCriterion("online_time =", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeNotEqualTo(Date value) {
            addCriterion("online_time <>", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeGreaterThan(Date value) {
            addCriterion("online_time >", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("online_time >=", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeLessThan(Date value) {
            addCriterion("online_time <", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeLessThanOrEqualTo(Date value) {
            addCriterion("online_time <=", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeIn(List<Date> values) {
            addCriterion("online_time in", values, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeNotIn(List<Date> values) {
            addCriterion("online_time not in", values, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeBetween(Date value1, Date value2) {
            addCriterion("online_time between", value1, value2, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeNotBetween(Date value1, Date value2) {
            addCriterion("online_time not between", value1, value2, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusIsNull() {
            addCriterion("equipment_status is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusIsNotNull() {
            addCriterion("equipment_status is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusEqualTo(String value) {
            addCriterion("equipment_status =", value, "equipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusNotEqualTo(String value) {
            addCriterion("equipment_status <>", value, "equipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusGreaterThan(String value) {
            addCriterion("equipment_status >", value, "equipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_status >=", value, "equipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusLessThan(String value) {
            addCriterion("equipment_status <", value, "equipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusLessThanOrEqualTo(String value) {
            addCriterion("equipment_status <=", value, "equipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusLike(String value) {
            addCriterion("equipment_status like", value, "equipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusNotLike(String value) {
            addCriterion("equipment_status not like", value, "equipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusIn(List<String> values) {
            addCriterion("equipment_status in", values, "equipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusNotIn(List<String> values) {
            addCriterion("equipment_status not in", values, "equipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusBetween(String value1, String value2) {
            addCriterion("equipment_status between", value1, value2, "equipmentStatus");
            return (Criteria) this;
        }

        public Criteria andEquipmentStatusNotBetween(String value1, String value2) {
            addCriterion("equipment_status not between", value1, value2, "equipmentStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusIsNull() {
            addCriterion("use_status is null");
            return (Criteria) this;
        }

        public Criteria andUseStatusIsNotNull() {
            addCriterion("use_status is not null");
            return (Criteria) this;
        }

        public Criteria andUseStatusEqualTo(String value) {
            addCriterion("use_status =", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotEqualTo(String value) {
            addCriterion("use_status <>", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusGreaterThan(String value) {
            addCriterion("use_status >", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("use_status >=", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusLessThan(String value) {
            addCriterion("use_status <", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusLessThanOrEqualTo(String value) {
            addCriterion("use_status <=", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusLike(String value) {
            addCriterion("use_status like", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotLike(String value) {
            addCriterion("use_status not like", value, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusIn(List<String> values) {
            addCriterion("use_status in", values, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotIn(List<String> values) {
            addCriterion("use_status not in", values, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusBetween(String value1, String value2) {
            addCriterion("use_status between", value1, value2, "useStatus");
            return (Criteria) this;
        }

        public Criteria andUseStatusNotBetween(String value1, String value2) {
            addCriterion("use_status not between", value1, value2, "useStatus");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeIsNull() {
            addCriterion("last_trans_time is null");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeIsNotNull() {
            addCriterion("last_trans_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeEqualTo(Date value) {
            addCriterion("last_trans_time =", value, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeNotEqualTo(Date value) {
            addCriterion("last_trans_time <>", value, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeGreaterThan(Date value) {
            addCriterion("last_trans_time >", value, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_trans_time >=", value, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeLessThan(Date value) {
            addCriterion("last_trans_time <", value, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_trans_time <=", value, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeIn(List<Date> values) {
            addCriterion("last_trans_time in", values, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeNotIn(List<Date> values) {
            addCriterion("last_trans_time not in", values, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeBetween(Date value1, Date value2) {
            addCriterion("last_trans_time between", value1, value2, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andLastTransTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_trans_time not between", value1, value2, "lastTransTime");
            return (Criteria) this;
        }

        public Criteria andTransNumIsNull() {
            addCriterion("trans_num is null");
            return (Criteria) this;
        }

        public Criteria andTransNumIsNotNull() {
            addCriterion("trans_num is not null");
            return (Criteria) this;
        }

        public Criteria andTransNumEqualTo(Integer value) {
            addCriterion("trans_num =", value, "transNum");
            return (Criteria) this;
        }

        public Criteria andTransNumNotEqualTo(Integer value) {
            addCriterion("trans_num <>", value, "transNum");
            return (Criteria) this;
        }

        public Criteria andTransNumGreaterThan(Integer value) {
            addCriterion("trans_num >", value, "transNum");
            return (Criteria) this;
        }

        public Criteria andTransNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("trans_num >=", value, "transNum");
            return (Criteria) this;
        }

        public Criteria andTransNumLessThan(Integer value) {
            addCriterion("trans_num <", value, "transNum");
            return (Criteria) this;
        }

        public Criteria andTransNumLessThanOrEqualTo(Integer value) {
            addCriterion("trans_num <=", value, "transNum");
            return (Criteria) this;
        }

        public Criteria andTransNumIn(List<Integer> values) {
            addCriterion("trans_num in", values, "transNum");
            return (Criteria) this;
        }

        public Criteria andTransNumNotIn(List<Integer> values) {
            addCriterion("trans_num not in", values, "transNum");
            return (Criteria) this;
        }

        public Criteria andTransNumBetween(Integer value1, Integer value2) {
            addCriterion("trans_num between", value1, value2, "transNum");
            return (Criteria) this;
        }

        public Criteria andTransNumNotBetween(Integer value1, Integer value2) {
            addCriterion("trans_num not between", value1, value2, "transNum");
            return (Criteria) this;
        }

        public Criteria andTransAmountIsNull() {
            addCriterion("trans_amount is null");
            return (Criteria) this;
        }

        public Criteria andTransAmountIsNotNull() {
            addCriterion("trans_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTransAmountEqualTo(BigDecimal value) {
            addCriterion("trans_amount =", value, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountNotEqualTo(BigDecimal value) {
            addCriterion("trans_amount <>", value, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountGreaterThan(BigDecimal value) {
            addCriterion("trans_amount >", value, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("trans_amount >=", value, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountLessThan(BigDecimal value) {
            addCriterion("trans_amount <", value, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("trans_amount <=", value, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountIn(List<BigDecimal> values) {
            addCriterion("trans_amount in", values, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountNotIn(List<BigDecimal> values) {
            addCriterion("trans_amount not in", values, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trans_amount between", value1, value2, "transAmount");
            return (Criteria) this;
        }

        public Criteria andTransAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trans_amount not between", value1, value2, "transAmount");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIsNull() {
            addCriterion("verify_status is null");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIsNotNull() {
            addCriterion("verify_status is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusEqualTo(String value) {
            addCriterion("verify_status =", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotEqualTo(String value) {
            addCriterion("verify_status <>", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusGreaterThan(String value) {
            addCriterion("verify_status >", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("verify_status >=", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLessThan(String value) {
            addCriterion("verify_status <", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLessThanOrEqualTo(String value) {
            addCriterion("verify_status <=", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLike(String value) {
            addCriterion("verify_status like", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotLike(String value) {
            addCriterion("verify_status not like", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIn(List<String> values) {
            addCriterion("verify_status in", values, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotIn(List<String> values) {
            addCriterion("verify_status not in", values, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusBetween(String value1, String value2) {
            addCriterion("verify_status between", value1, value2, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotBetween(String value1, String value2) {
            addCriterion("verify_status not between", value1, value2, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIsNull() {
            addCriterion("second_region is null");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIsNotNull() {
            addCriterion("second_region is not null");
            return (Criteria) this;
        }

        public Criteria andSecondRegionEqualTo(String value) {
            addCriterion("second_region =", value, "secondRegion");
            return (Criteria) this;
        }

        public Criteria andSecondRegionNotEqualTo(String value) {
            addCriterion("second_region <>", value, "secondRegion");
            return (Criteria) this;
        }

        public Criteria andSecondRegionGreaterThan(String value) {
            addCriterion("second_region >", value, "secondRegion");
            return (Criteria) this;
        }

        public Criteria andSecondRegionGreaterThanOrEqualTo(String value) {
            addCriterion("second_region >=", value, "secondRegion");
            return (Criteria) this;
        }

        public Criteria andSecondRegionLessThan(String value) {
            addCriterion("second_region <", value, "secondRegion");
            return (Criteria) this;
        }

        public Criteria andSecondRegionLessThanOrEqualTo(String value) {
            addCriterion("second_region <=", value, "secondRegion");
            return (Criteria) this;
        }

        public Criteria andSecondRegionLike(String value) {
            addCriterion("second_region like", value, "secondRegion");
            return (Criteria) this;
        }

        public Criteria andSecondRegionNotLike(String value) {
            addCriterion("second_region not like", value, "secondRegion");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIn(List<String> values) {
            addCriterion("second_region in", values, "secondRegion");
            return (Criteria) this;
        }

        public Criteria andSecondRegionNotIn(List<String> values) {
            addCriterion("second_region not in", values, "secondRegion");
            return (Criteria) this;
        }

        public Criteria andSecondRegionBetween(String value1, String value2) {
            addCriterion("second_region between", value1, value2, "secondRegion");
            return (Criteria) this;
        }

        public Criteria andSecondRegionNotBetween(String value1, String value2) {
            addCriterion("second_region not between", value1, value2, "secondRegion");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIsNull() {
            addCriterion("third_region is null");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIsNotNull() {
            addCriterion("third_region is not null");
            return (Criteria) this;
        }

        public Criteria andThirdRegionEqualTo(String value) {
            addCriterion("third_region =", value, "thirdRegion");
            return (Criteria) this;
        }

        public Criteria andThirdRegionNotEqualTo(String value) {
            addCriterion("third_region <>", value, "thirdRegion");
            return (Criteria) this;
        }

        public Criteria andThirdRegionGreaterThan(String value) {
            addCriterion("third_region >", value, "thirdRegion");
            return (Criteria) this;
        }

        public Criteria andThirdRegionGreaterThanOrEqualTo(String value) {
            addCriterion("third_region >=", value, "thirdRegion");
            return (Criteria) this;
        }

        public Criteria andThirdRegionLessThan(String value) {
            addCriterion("third_region <", value, "thirdRegion");
            return (Criteria) this;
        }

        public Criteria andThirdRegionLessThanOrEqualTo(String value) {
            addCriterion("third_region <=", value, "thirdRegion");
            return (Criteria) this;
        }

        public Criteria andThirdRegionLike(String value) {
            addCriterion("third_region like", value, "thirdRegion");
            return (Criteria) this;
        }

        public Criteria andThirdRegionNotLike(String value) {
            addCriterion("third_region not like", value, "thirdRegion");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIn(List<String> values) {
            addCriterion("third_region in", values, "thirdRegion");
            return (Criteria) this;
        }

        public Criteria andThirdRegionNotIn(List<String> values) {
            addCriterion("third_region not in", values, "thirdRegion");
            return (Criteria) this;
        }

        public Criteria andThirdRegionBetween(String value1, String value2) {
            addCriterion("third_region between", value1, value2, "thirdRegion");
            return (Criteria) this;
        }

        public Criteria andThirdRegionNotBetween(String value1, String value2) {
            addCriterion("third_region not between", value1, value2, "thirdRegion");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIsNull() {
            addCriterion("fourth_region is null");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIsNotNull() {
            addCriterion("fourth_region is not null");
            return (Criteria) this;
        }

        public Criteria andFourthRegionEqualTo(String value) {
            addCriterion("fourth_region =", value, "fourthRegion");
            return (Criteria) this;
        }

        public Criteria andFourthRegionNotEqualTo(String value) {
            addCriterion("fourth_region <>", value, "fourthRegion");
            return (Criteria) this;
        }

        public Criteria andFourthRegionGreaterThan(String value) {
            addCriterion("fourth_region >", value, "fourthRegion");
            return (Criteria) this;
        }

        public Criteria andFourthRegionGreaterThanOrEqualTo(String value) {
            addCriterion("fourth_region >=", value, "fourthRegion");
            return (Criteria) this;
        }

        public Criteria andFourthRegionLessThan(String value) {
            addCriterion("fourth_region <", value, "fourthRegion");
            return (Criteria) this;
        }

        public Criteria andFourthRegionLessThanOrEqualTo(String value) {
            addCriterion("fourth_region <=", value, "fourthRegion");
            return (Criteria) this;
        }

        public Criteria andFourthRegionLike(String value) {
            addCriterion("fourth_region like", value, "fourthRegion");
            return (Criteria) this;
        }

        public Criteria andFourthRegionNotLike(String value) {
            addCriterion("fourth_region not like", value, "fourthRegion");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIn(List<String> values) {
            addCriterion("fourth_region in", values, "fourthRegion");
            return (Criteria) this;
        }

        public Criteria andFourthRegionNotIn(List<String> values) {
            addCriterion("fourth_region not in", values, "fourthRegion");
            return (Criteria) this;
        }

        public Criteria andFourthRegionBetween(String value1, String value2) {
            addCriterion("fourth_region between", value1, value2, "fourthRegion");
            return (Criteria) this;
        }

        public Criteria andFourthRegionNotBetween(String value1, String value2) {
            addCriterion("fourth_region not between", value1, value2, "fourthRegion");
            return (Criteria) this;
        }

        public Criteria andCountryIdIsNull() {
            addCriterion("country_id is null");
            return (Criteria) this;
        }

        public Criteria andCountryIdIsNotNull() {
            addCriterion("country_id is not null");
            return (Criteria) this;
        }

        public Criteria andCountryIdEqualTo(Long value) {
            addCriterion("country_id =", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotEqualTo(Long value) {
            addCriterion("country_id <>", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdGreaterThan(Long value) {
            addCriterion("country_id >", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("country_id >=", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLessThan(Long value) {
            addCriterion("country_id <", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLessThanOrEqualTo(Long value) {
            addCriterion("country_id <=", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdIn(List<Long> values) {
            addCriterion("country_id in", values, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotIn(List<Long> values) {
            addCriterion("country_id not in", values, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdBetween(Long value1, Long value2) {
            addCriterion("country_id between", value1, value2, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotBetween(Long value1, Long value2) {
            addCriterion("country_id not between", value1, value2, "countryId");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIdIsNull() {
            addCriterion("second_region_id is null");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIdIsNotNull() {
            addCriterion("second_region_id is not null");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIdEqualTo(Long value) {
            addCriterion("second_region_id =", value, "secondRegionId");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIdNotEqualTo(Long value) {
            addCriterion("second_region_id <>", value, "secondRegionId");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIdGreaterThan(Long value) {
            addCriterion("second_region_id >", value, "secondRegionId");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("second_region_id >=", value, "secondRegionId");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIdLessThan(Long value) {
            addCriterion("second_region_id <", value, "secondRegionId");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIdLessThanOrEqualTo(Long value) {
            addCriterion("second_region_id <=", value, "secondRegionId");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIdIn(List<Long> values) {
            addCriterion("second_region_id in", values, "secondRegionId");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIdNotIn(List<Long> values) {
            addCriterion("second_region_id not in", values, "secondRegionId");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIdBetween(Long value1, Long value2) {
            addCriterion("second_region_id between", value1, value2, "secondRegionId");
            return (Criteria) this;
        }

        public Criteria andSecondRegionIdNotBetween(Long value1, Long value2) {
            addCriterion("second_region_id not between", value1, value2, "secondRegionId");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIdIsNull() {
            addCriterion("third_region_id is null");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIdIsNotNull() {
            addCriterion("third_region_id is not null");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIdEqualTo(Long value) {
            addCriterion("third_region_id =", value, "thirdRegionId");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIdNotEqualTo(Long value) {
            addCriterion("third_region_id <>", value, "thirdRegionId");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIdGreaterThan(Long value) {
            addCriterion("third_region_id >", value, "thirdRegionId");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("third_region_id >=", value, "thirdRegionId");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIdLessThan(Long value) {
            addCriterion("third_region_id <", value, "thirdRegionId");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIdLessThanOrEqualTo(Long value) {
            addCriterion("third_region_id <=", value, "thirdRegionId");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIdIn(List<Long> values) {
            addCriterion("third_region_id in", values, "thirdRegionId");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIdNotIn(List<Long> values) {
            addCriterion("third_region_id not in", values, "thirdRegionId");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIdBetween(Long value1, Long value2) {
            addCriterion("third_region_id between", value1, value2, "thirdRegionId");
            return (Criteria) this;
        }

        public Criteria andThirdRegionIdNotBetween(Long value1, Long value2) {
            addCriterion("third_region_id not between", value1, value2, "thirdRegionId");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIdIsNull() {
            addCriterion("fourth_region_id is null");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIdIsNotNull() {
            addCriterion("fourth_region_id is not null");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIdEqualTo(Long value) {
            addCriterion("fourth_region_id =", value, "fourthRegionId");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIdNotEqualTo(Long value) {
            addCriterion("fourth_region_id <>", value, "fourthRegionId");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIdGreaterThan(Long value) {
            addCriterion("fourth_region_id >", value, "fourthRegionId");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fourth_region_id >=", value, "fourthRegionId");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIdLessThan(Long value) {
            addCriterion("fourth_region_id <", value, "fourthRegionId");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIdLessThanOrEqualTo(Long value) {
            addCriterion("fourth_region_id <=", value, "fourthRegionId");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIdIn(List<Long> values) {
            addCriterion("fourth_region_id in", values, "fourthRegionId");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIdNotIn(List<Long> values) {
            addCriterion("fourth_region_id not in", values, "fourthRegionId");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIdBetween(Long value1, Long value2) {
            addCriterion("fourth_region_id between", value1, value2, "fourthRegionId");
            return (Criteria) this;
        }

        public Criteria andFourthRegionIdNotBetween(Long value1, Long value2) {
            addCriterion("fourth_region_id not between", value1, value2, "fourthRegionId");
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

        public Criteria andDownTimeIsNull() {
            addCriterion("down_time is null");
            return (Criteria) this;
        }

        public Criteria andDownTimeIsNotNull() {
            addCriterion("down_time is not null");
            return (Criteria) this;
        }

        public Criteria andDownTimeEqualTo(Date value) {
            addCriterion("down_time =", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeNotEqualTo(Date value) {
            addCriterion("down_time <>", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeGreaterThan(Date value) {
            addCriterion("down_time >", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("down_time >=", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeLessThan(Date value) {
            addCriterion("down_time <", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeLessThanOrEqualTo(Date value) {
            addCriterion("down_time <=", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeIn(List<Date> values) {
            addCriterion("down_time in", values, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeNotIn(List<Date> values) {
            addCriterion("down_time not in", values, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeBetween(Date value1, Date value2) {
            addCriterion("down_time between", value1, value2, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeNotBetween(Date value1, Date value2) {
            addCriterion("down_time not between", value1, value2, "downTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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