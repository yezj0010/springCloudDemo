package com.tomcat360.admin.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbCheckResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbCheckResultExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoIsNull() {
            addCriterion("check_batch_no is null");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoIsNotNull() {
            addCriterion("check_batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoEqualTo(String value) {
            addCriterion("check_batch_no =", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoNotEqualTo(String value) {
            addCriterion("check_batch_no <>", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoGreaterThan(String value) {
            addCriterion("check_batch_no >", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("check_batch_no >=", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoLessThan(String value) {
            addCriterion("check_batch_no <", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoLessThanOrEqualTo(String value) {
            addCriterion("check_batch_no <=", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoLike(String value) {
            addCriterion("check_batch_no like", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoNotLike(String value) {
            addCriterion("check_batch_no not like", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoIn(List<String> values) {
            addCriterion("check_batch_no in", values, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoNotIn(List<String> values) {
            addCriterion("check_batch_no not in", values, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoBetween(String value1, String value2) {
            addCriterion("check_batch_no between", value1, value2, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoNotBetween(String value1, String value2) {
            addCriterion("check_batch_no not between", value1, value2, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNull() {
            addCriterion("equipment_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNotNull() {
            addCriterion("equipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdEqualTo(String value) {
            addCriterion("equipment_id =", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotEqualTo(String value) {
            addCriterion("equipment_id <>", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThan(String value) {
            addCriterion("equipment_id >", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_id >=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThan(String value) {
            addCriterion("equipment_id <", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThanOrEqualTo(String value) {
            addCriterion("equipment_id <=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLike(String value) {
            addCriterion("equipment_id like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotLike(String value) {
            addCriterion("equipment_id not like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIn(List<String> values) {
            addCriterion("equipment_id in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotIn(List<String> values) {
            addCriterion("equipment_id not in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdBetween(String value1, String value2) {
            addCriterion("equipment_id between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotBetween(String value1, String value2) {
            addCriterion("equipment_id not between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountIsNull() {
            addCriterion("success_amount is null");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountIsNotNull() {
            addCriterion("success_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountEqualTo(BigDecimal value) {
            addCriterion("success_amount =", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNotEqualTo(BigDecimal value) {
            addCriterion("success_amount <>", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountGreaterThan(BigDecimal value) {
            addCriterion("success_amount >", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("success_amount >=", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountLessThan(BigDecimal value) {
            addCriterion("success_amount <", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("success_amount <=", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountIn(List<BigDecimal> values) {
            addCriterion("success_amount in", values, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNotIn(List<BigDecimal> values) {
            addCriterion("success_amount not in", values, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("success_amount between", value1, value2, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("success_amount not between", value1, value2, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessNumIsNull() {
            addCriterion("success_num is null");
            return (Criteria) this;
        }

        public Criteria andSuccessNumIsNotNull() {
            addCriterion("success_num is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessNumEqualTo(Long value) {
            addCriterion("success_num =", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumNotEqualTo(Long value) {
            addCriterion("success_num <>", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumGreaterThan(Long value) {
            addCriterion("success_num >", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumGreaterThanOrEqualTo(Long value) {
            addCriterion("success_num >=", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumLessThan(Long value) {
            addCriterion("success_num <", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumLessThanOrEqualTo(Long value) {
            addCriterion("success_num <=", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumIn(List<Long> values) {
            addCriterion("success_num in", values, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumNotIn(List<Long> values) {
            addCriterion("success_num not in", values, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumBetween(Long value1, Long value2) {
            addCriterion("success_num between", value1, value2, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumNotBetween(Long value1, Long value2) {
            addCriterion("success_num not between", value1, value2, "successNum");
            return (Criteria) this;
        }

        public Criteria andErrorAmountIsNull() {
            addCriterion("error_amount is null");
            return (Criteria) this;
        }

        public Criteria andErrorAmountIsNotNull() {
            addCriterion("error_amount is not null");
            return (Criteria) this;
        }

        public Criteria andErrorAmountEqualTo(BigDecimal value) {
            addCriterion("error_amount =", value, "errorAmount");
            return (Criteria) this;
        }

        public Criteria andErrorAmountNotEqualTo(BigDecimal value) {
            addCriterion("error_amount <>", value, "errorAmount");
            return (Criteria) this;
        }

        public Criteria andErrorAmountGreaterThan(BigDecimal value) {
            addCriterion("error_amount >", value, "errorAmount");
            return (Criteria) this;
        }

        public Criteria andErrorAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("error_amount >=", value, "errorAmount");
            return (Criteria) this;
        }

        public Criteria andErrorAmountLessThan(BigDecimal value) {
            addCriterion("error_amount <", value, "errorAmount");
            return (Criteria) this;
        }

        public Criteria andErrorAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("error_amount <=", value, "errorAmount");
            return (Criteria) this;
        }

        public Criteria andErrorAmountIn(List<BigDecimal> values) {
            addCriterion("error_amount in", values, "errorAmount");
            return (Criteria) this;
        }

        public Criteria andErrorAmountNotIn(List<BigDecimal> values) {
            addCriterion("error_amount not in", values, "errorAmount");
            return (Criteria) this;
        }

        public Criteria andErrorAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("error_amount between", value1, value2, "errorAmount");
            return (Criteria) this;
        }

        public Criteria andErrorAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("error_amount not between", value1, value2, "errorAmount");
            return (Criteria) this;
        }

        public Criteria andErrorNumIsNull() {
            addCriterion("error_num is null");
            return (Criteria) this;
        }

        public Criteria andErrorNumIsNotNull() {
            addCriterion("error_num is not null");
            return (Criteria) this;
        }

        public Criteria andErrorNumEqualTo(Long value) {
            addCriterion("error_num =", value, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumNotEqualTo(Long value) {
            addCriterion("error_num <>", value, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumGreaterThan(Long value) {
            addCriterion("error_num >", value, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumGreaterThanOrEqualTo(Long value) {
            addCriterion("error_num >=", value, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumLessThan(Long value) {
            addCriterion("error_num <", value, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumLessThanOrEqualTo(Long value) {
            addCriterion("error_num <=", value, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumIn(List<Long> values) {
            addCriterion("error_num in", values, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumNotIn(List<Long> values) {
            addCriterion("error_num not in", values, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumBetween(Long value1, Long value2) {
            addCriterion("error_num between", value1, value2, "errorNum");
            return (Criteria) this;
        }

        public Criteria andErrorNumNotBetween(Long value1, Long value2) {
            addCriterion("error_num not between", value1, value2, "errorNum");
            return (Criteria) this;
        }

        public Criteria andWithdrawCurrencyIsNull() {
            addCriterion("withdraw_currency is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawCurrencyIsNotNull() {
            addCriterion("withdraw_currency is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawCurrencyEqualTo(String value) {
            addCriterion("withdraw_currency =", value, "withdrawCurrency");
            return (Criteria) this;
        }

        public Criteria andWithdrawCurrencyNotEqualTo(String value) {
            addCriterion("withdraw_currency <>", value, "withdrawCurrency");
            return (Criteria) this;
        }

        public Criteria andWithdrawCurrencyGreaterThan(String value) {
            addCriterion("withdraw_currency >", value, "withdrawCurrency");
            return (Criteria) this;
        }

        public Criteria andWithdrawCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_currency >=", value, "withdrawCurrency");
            return (Criteria) this;
        }

        public Criteria andWithdrawCurrencyLessThan(String value) {
            addCriterion("withdraw_currency <", value, "withdrawCurrency");
            return (Criteria) this;
        }

        public Criteria andWithdrawCurrencyLessThanOrEqualTo(String value) {
            addCriterion("withdraw_currency <=", value, "withdrawCurrency");
            return (Criteria) this;
        }

        public Criteria andWithdrawCurrencyLike(String value) {
            addCriterion("withdraw_currency like", value, "withdrawCurrency");
            return (Criteria) this;
        }

        public Criteria andWithdrawCurrencyNotLike(String value) {
            addCriterion("withdraw_currency not like", value, "withdrawCurrency");
            return (Criteria) this;
        }

        public Criteria andWithdrawCurrencyIn(List<String> values) {
            addCriterion("withdraw_currency in", values, "withdrawCurrency");
            return (Criteria) this;
        }

        public Criteria andWithdrawCurrencyNotIn(List<String> values) {
            addCriterion("withdraw_currency not in", values, "withdrawCurrency");
            return (Criteria) this;
        }

        public Criteria andWithdrawCurrencyBetween(String value1, String value2) {
            addCriterion("withdraw_currency between", value1, value2, "withdrawCurrency");
            return (Criteria) this;
        }

        public Criteria andWithdrawCurrencyNotBetween(String value1, String value2) {
            addCriterion("withdraw_currency not between", value1, value2, "withdrawCurrency");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Date value) {
            addCriterion("check_time =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Date value) {
            addCriterion("check_time <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Date value) {
            addCriterion("check_time >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_time >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Date value) {
            addCriterion("check_time <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_time <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Date> values) {
            addCriterion("check_time in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Date> values) {
            addCriterion("check_time not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Date value1, Date value2) {
            addCriterion("check_time between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_time not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(String value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(String value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(String value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(String value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(String value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(String value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLike(String value) {
            addCriterion("check_status like", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotLike(String value) {
            addCriterion("check_status not like", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<String> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<String> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(String value1, String value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(String value1, String value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusIsNull() {
            addCriterion("operate_status is null");
            return (Criteria) this;
        }

        public Criteria andOperateStatusIsNotNull() {
            addCriterion("operate_status is not null");
            return (Criteria) this;
        }

        public Criteria andOperateStatusEqualTo(String value) {
            addCriterion("operate_status =", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusNotEqualTo(String value) {
            addCriterion("operate_status <>", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusGreaterThan(String value) {
            addCriterion("operate_status >", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusGreaterThanOrEqualTo(String value) {
            addCriterion("operate_status >=", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusLessThan(String value) {
            addCriterion("operate_status <", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusLessThanOrEqualTo(String value) {
            addCriterion("operate_status <=", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusLike(String value) {
            addCriterion("operate_status like", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusNotLike(String value) {
            addCriterion("operate_status not like", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusIn(List<String> values) {
            addCriterion("operate_status in", values, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusNotIn(List<String> values) {
            addCriterion("operate_status not in", values, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusBetween(String value1, String value2) {
            addCriterion("operate_status between", value1, value2, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusNotBetween(String value1, String value2) {
            addCriterion("operate_status not between", value1, value2, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIsNull() {
            addCriterion("operate_admin is null");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIsNotNull() {
            addCriterion("operate_admin is not null");
            return (Criteria) this;
        }

        public Criteria andOperateAdminEqualTo(String value) {
            addCriterion("operate_admin =", value, "operateAdmin");
            return (Criteria) this;
        }

        public Criteria andOperateAdminNotEqualTo(String value) {
            addCriterion("operate_admin <>", value, "operateAdmin");
            return (Criteria) this;
        }

        public Criteria andOperateAdminGreaterThan(String value) {
            addCriterion("operate_admin >", value, "operateAdmin");
            return (Criteria) this;
        }

        public Criteria andOperateAdminGreaterThanOrEqualTo(String value) {
            addCriterion("operate_admin >=", value, "operateAdmin");
            return (Criteria) this;
        }

        public Criteria andOperateAdminLessThan(String value) {
            addCriterion("operate_admin <", value, "operateAdmin");
            return (Criteria) this;
        }

        public Criteria andOperateAdminLessThanOrEqualTo(String value) {
            addCriterion("operate_admin <=", value, "operateAdmin");
            return (Criteria) this;
        }

        public Criteria andOperateAdminLike(String value) {
            addCriterion("operate_admin like", value, "operateAdmin");
            return (Criteria) this;
        }

        public Criteria andOperateAdminNotLike(String value) {
            addCriterion("operate_admin not like", value, "operateAdmin");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIn(List<String> values) {
            addCriterion("operate_admin in", values, "operateAdmin");
            return (Criteria) this;
        }

        public Criteria andOperateAdminNotIn(List<String> values) {
            addCriterion("operate_admin not in", values, "operateAdmin");
            return (Criteria) this;
        }

        public Criteria andOperateAdminBetween(String value1, String value2) {
            addCriterion("operate_admin between", value1, value2, "operateAdmin");
            return (Criteria) this;
        }

        public Criteria andOperateAdminNotBetween(String value1, String value2) {
            addCriterion("operate_admin not between", value1, value2, "operateAdmin");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIdIsNull() {
            addCriterion("operate_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIdIsNotNull() {
            addCriterion("operate_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIdEqualTo(Long value) {
            addCriterion("operate_admin_id =", value, "operateAdminId");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIdNotEqualTo(Long value) {
            addCriterion("operate_admin_id <>", value, "operateAdminId");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIdGreaterThan(Long value) {
            addCriterion("operate_admin_id >", value, "operateAdminId");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("operate_admin_id >=", value, "operateAdminId");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIdLessThan(Long value) {
            addCriterion("operate_admin_id <", value, "operateAdminId");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("operate_admin_id <=", value, "operateAdminId");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIdIn(List<Long> values) {
            addCriterion("operate_admin_id in", values, "operateAdminId");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIdNotIn(List<Long> values) {
            addCriterion("operate_admin_id not in", values, "operateAdminId");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIdBetween(Long value1, Long value2) {
            addCriterion("operate_admin_id between", value1, value2, "operateAdminId");
            return (Criteria) this;
        }

        public Criteria andOperateAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("operate_admin_id not between", value1, value2, "operateAdminId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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