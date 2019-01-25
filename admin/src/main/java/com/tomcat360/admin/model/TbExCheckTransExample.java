package com.tomcat360.admin.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbExCheckTransExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbExCheckTransExample() {
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

        public Criteria andAtmcSeqIsNull() {
            addCriterion("atmc_seq is null");
            return (Criteria) this;
        }

        public Criteria andAtmcSeqIsNotNull() {
            addCriterion("atmc_seq is not null");
            return (Criteria) this;
        }

        public Criteria andAtmcSeqEqualTo(String value) {
            addCriterion("atmc_seq =", value, "atmcSeq");
            return (Criteria) this;
        }

        public Criteria andAtmcSeqNotEqualTo(String value) {
            addCriterion("atmc_seq <>", value, "atmcSeq");
            return (Criteria) this;
        }

        public Criteria andAtmcSeqGreaterThan(String value) {
            addCriterion("atmc_seq >", value, "atmcSeq");
            return (Criteria) this;
        }

        public Criteria andAtmcSeqGreaterThanOrEqualTo(String value) {
            addCriterion("atmc_seq >=", value, "atmcSeq");
            return (Criteria) this;
        }

        public Criteria andAtmcSeqLessThan(String value) {
            addCriterion("atmc_seq <", value, "atmcSeq");
            return (Criteria) this;
        }

        public Criteria andAtmcSeqLessThanOrEqualTo(String value) {
            addCriterion("atmc_seq <=", value, "atmcSeq");
            return (Criteria) this;
        }

        public Criteria andAtmcSeqLike(String value) {
            addCriterion("atmc_seq like", value, "atmcSeq");
            return (Criteria) this;
        }

        public Criteria andAtmcSeqNotLike(String value) {
            addCriterion("atmc_seq not like", value, "atmcSeq");
            return (Criteria) this;
        }

        public Criteria andAtmcSeqIn(List<String> values) {
            addCriterion("atmc_seq in", values, "atmcSeq");
            return (Criteria) this;
        }

        public Criteria andAtmcSeqNotIn(List<String> values) {
            addCriterion("atmc_seq not in", values, "atmcSeq");
            return (Criteria) this;
        }

        public Criteria andAtmcSeqBetween(String value1, String value2) {
            addCriterion("atmc_seq between", value1, value2, "atmcSeq");
            return (Criteria) this;
        }

        public Criteria andAtmcSeqNotBetween(String value1, String value2) {
            addCriterion("atmc_seq not between", value1, value2, "atmcSeq");
            return (Criteria) this;
        }

        public Criteria andAtmpSeqIsNull() {
            addCriterion("atmp_seq is null");
            return (Criteria) this;
        }

        public Criteria andAtmpSeqIsNotNull() {
            addCriterion("atmp_seq is not null");
            return (Criteria) this;
        }

        public Criteria andAtmpSeqEqualTo(String value) {
            addCriterion("atmp_seq =", value, "atmpSeq");
            return (Criteria) this;
        }

        public Criteria andAtmpSeqNotEqualTo(String value) {
            addCriterion("atmp_seq <>", value, "atmpSeq");
            return (Criteria) this;
        }

        public Criteria andAtmpSeqGreaterThan(String value) {
            addCriterion("atmp_seq >", value, "atmpSeq");
            return (Criteria) this;
        }

        public Criteria andAtmpSeqGreaterThanOrEqualTo(String value) {
            addCriterion("atmp_seq >=", value, "atmpSeq");
            return (Criteria) this;
        }

        public Criteria andAtmpSeqLessThan(String value) {
            addCriterion("atmp_seq <", value, "atmpSeq");
            return (Criteria) this;
        }

        public Criteria andAtmpSeqLessThanOrEqualTo(String value) {
            addCriterion("atmp_seq <=", value, "atmpSeq");
            return (Criteria) this;
        }

        public Criteria andAtmpSeqLike(String value) {
            addCriterion("atmp_seq like", value, "atmpSeq");
            return (Criteria) this;
        }

        public Criteria andAtmpSeqNotLike(String value) {
            addCriterion("atmp_seq not like", value, "atmpSeq");
            return (Criteria) this;
        }

        public Criteria andAtmpSeqIn(List<String> values) {
            addCriterion("atmp_seq in", values, "atmpSeq");
            return (Criteria) this;
        }

        public Criteria andAtmpSeqNotIn(List<String> values) {
            addCriterion("atmp_seq not in", values, "atmpSeq");
            return (Criteria) this;
        }

        public Criteria andAtmpSeqBetween(String value1, String value2) {
            addCriterion("atmp_seq between", value1, value2, "atmpSeq");
            return (Criteria) this;
        }

        public Criteria andAtmpSeqNotBetween(String value1, String value2) {
            addCriterion("atmp_seq not between", value1, value2, "atmpSeq");
            return (Criteria) this;
        }

        public Criteria andExSeqIsNull() {
            addCriterion("ex_seq is null");
            return (Criteria) this;
        }

        public Criteria andExSeqIsNotNull() {
            addCriterion("ex_seq is not null");
            return (Criteria) this;
        }

        public Criteria andExSeqEqualTo(String value) {
            addCriterion("ex_seq =", value, "exSeq");
            return (Criteria) this;
        }

        public Criteria andExSeqNotEqualTo(String value) {
            addCriterion("ex_seq <>", value, "exSeq");
            return (Criteria) this;
        }

        public Criteria andExSeqGreaterThan(String value) {
            addCriterion("ex_seq >", value, "exSeq");
            return (Criteria) this;
        }

        public Criteria andExSeqGreaterThanOrEqualTo(String value) {
            addCriterion("ex_seq >=", value, "exSeq");
            return (Criteria) this;
        }

        public Criteria andExSeqLessThan(String value) {
            addCriterion("ex_seq <", value, "exSeq");
            return (Criteria) this;
        }

        public Criteria andExSeqLessThanOrEqualTo(String value) {
            addCriterion("ex_seq <=", value, "exSeq");
            return (Criteria) this;
        }

        public Criteria andExSeqLike(String value) {
            addCriterion("ex_seq like", value, "exSeq");
            return (Criteria) this;
        }

        public Criteria andExSeqNotLike(String value) {
            addCriterion("ex_seq not like", value, "exSeq");
            return (Criteria) this;
        }

        public Criteria andExSeqIn(List<String> values) {
            addCriterion("ex_seq in", values, "exSeq");
            return (Criteria) this;
        }

        public Criteria andExSeqNotIn(List<String> values) {
            addCriterion("ex_seq not in", values, "exSeq");
            return (Criteria) this;
        }

        public Criteria andExSeqBetween(String value1, String value2) {
            addCriterion("ex_seq between", value1, value2, "exSeq");
            return (Criteria) this;
        }

        public Criteria andExSeqNotBetween(String value1, String value2) {
            addCriterion("ex_seq not between", value1, value2, "exSeq");
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoneyIsNull() {
            addCriterion("withdraw_money is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoneyIsNotNull() {
            addCriterion("withdraw_money is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoneyEqualTo(BigDecimal value) {
            addCriterion("withdraw_money =", value, "withdrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoneyNotEqualTo(BigDecimal value) {
            addCriterion("withdraw_money <>", value, "withdrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoneyGreaterThan(BigDecimal value) {
            addCriterion("withdraw_money >", value, "withdrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("withdraw_money >=", value, "withdrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoneyLessThan(BigDecimal value) {
            addCriterion("withdraw_money <", value, "withdrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("withdraw_money <=", value, "withdrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoneyIn(List<BigDecimal> values) {
            addCriterion("withdraw_money in", values, "withdrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoneyNotIn(List<BigDecimal> values) {
            addCriterion("withdraw_money not in", values, "withdrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdraw_money between", value1, value2, "withdrawMoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdraw_money not between", value1, value2, "withdrawMoney");
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

        public Criteria andDeductCurrencyIsNull() {
            addCriterion("deduct_currency is null");
            return (Criteria) this;
        }

        public Criteria andDeductCurrencyIsNotNull() {
            addCriterion("deduct_currency is not null");
            return (Criteria) this;
        }

        public Criteria andDeductCurrencyEqualTo(String value) {
            addCriterion("deduct_currency =", value, "deductCurrency");
            return (Criteria) this;
        }

        public Criteria andDeductCurrencyNotEqualTo(String value) {
            addCriterion("deduct_currency <>", value, "deductCurrency");
            return (Criteria) this;
        }

        public Criteria andDeductCurrencyGreaterThan(String value) {
            addCriterion("deduct_currency >", value, "deductCurrency");
            return (Criteria) this;
        }

        public Criteria andDeductCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("deduct_currency >=", value, "deductCurrency");
            return (Criteria) this;
        }

        public Criteria andDeductCurrencyLessThan(String value) {
            addCriterion("deduct_currency <", value, "deductCurrency");
            return (Criteria) this;
        }

        public Criteria andDeductCurrencyLessThanOrEqualTo(String value) {
            addCriterion("deduct_currency <=", value, "deductCurrency");
            return (Criteria) this;
        }

        public Criteria andDeductCurrencyLike(String value) {
            addCriterion("deduct_currency like", value, "deductCurrency");
            return (Criteria) this;
        }

        public Criteria andDeductCurrencyNotLike(String value) {
            addCriterion("deduct_currency not like", value, "deductCurrency");
            return (Criteria) this;
        }

        public Criteria andDeductCurrencyIn(List<String> values) {
            addCriterion("deduct_currency in", values, "deductCurrency");
            return (Criteria) this;
        }

        public Criteria andDeductCurrencyNotIn(List<String> values) {
            addCriterion("deduct_currency not in", values, "deductCurrency");
            return (Criteria) this;
        }

        public Criteria andDeductCurrencyBetween(String value1, String value2) {
            addCriterion("deduct_currency between", value1, value2, "deductCurrency");
            return (Criteria) this;
        }

        public Criteria andDeductCurrencyNotBetween(String value1, String value2) {
            addCriterion("deduct_currency not between", value1, value2, "deductCurrency");
            return (Criteria) this;
        }

        public Criteria andDeductMoneyIsNull() {
            addCriterion("deduct_money is null");
            return (Criteria) this;
        }

        public Criteria andDeductMoneyIsNotNull() {
            addCriterion("deduct_money is not null");
            return (Criteria) this;
        }

        public Criteria andDeductMoneyEqualTo(BigDecimal value) {
            addCriterion("deduct_money =", value, "deductMoney");
            return (Criteria) this;
        }

        public Criteria andDeductMoneyNotEqualTo(BigDecimal value) {
            addCriterion("deduct_money <>", value, "deductMoney");
            return (Criteria) this;
        }

        public Criteria andDeductMoneyGreaterThan(BigDecimal value) {
            addCriterion("deduct_money >", value, "deductMoney");
            return (Criteria) this;
        }

        public Criteria andDeductMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deduct_money >=", value, "deductMoney");
            return (Criteria) this;
        }

        public Criteria andDeductMoneyLessThan(BigDecimal value) {
            addCriterion("deduct_money <", value, "deductMoney");
            return (Criteria) this;
        }

        public Criteria andDeductMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deduct_money <=", value, "deductMoney");
            return (Criteria) this;
        }

        public Criteria andDeductMoneyIn(List<BigDecimal> values) {
            addCriterion("deduct_money in", values, "deductMoney");
            return (Criteria) this;
        }

        public Criteria andDeductMoneyNotIn(List<BigDecimal> values) {
            addCriterion("deduct_money not in", values, "deductMoney");
            return (Criteria) this;
        }

        public Criteria andDeductMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduct_money between", value1, value2, "deductMoney");
            return (Criteria) this;
        }

        public Criteria andDeductMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduct_money not between", value1, value2, "deductMoney");
            return (Criteria) this;
        }

        public Criteria andDeductFeeIsNull() {
            addCriterion("deduct_fee is null");
            return (Criteria) this;
        }

        public Criteria andDeductFeeIsNotNull() {
            addCriterion("deduct_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDeductFeeEqualTo(BigDecimal value) {
            addCriterion("deduct_fee =", value, "deductFee");
            return (Criteria) this;
        }

        public Criteria andDeductFeeNotEqualTo(BigDecimal value) {
            addCriterion("deduct_fee <>", value, "deductFee");
            return (Criteria) this;
        }

        public Criteria andDeductFeeGreaterThan(BigDecimal value) {
            addCriterion("deduct_fee >", value, "deductFee");
            return (Criteria) this;
        }

        public Criteria andDeductFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deduct_fee >=", value, "deductFee");
            return (Criteria) this;
        }

        public Criteria andDeductFeeLessThan(BigDecimal value) {
            addCriterion("deduct_fee <", value, "deductFee");
            return (Criteria) this;
        }

        public Criteria andDeductFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deduct_fee <=", value, "deductFee");
            return (Criteria) this;
        }

        public Criteria andDeductFeeIn(List<BigDecimal> values) {
            addCriterion("deduct_fee in", values, "deductFee");
            return (Criteria) this;
        }

        public Criteria andDeductFeeNotIn(List<BigDecimal> values) {
            addCriterion("deduct_fee not in", values, "deductFee");
            return (Criteria) this;
        }

        public Criteria andDeductFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduct_fee between", value1, value2, "deductFee");
            return (Criteria) this;
        }

        public Criteria andDeductFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduct_fee not between", value1, value2, "deductFee");
            return (Criteria) this;
        }

        public Criteria andTransTimeIsNull() {
            addCriterion("trans_time is null");
            return (Criteria) this;
        }

        public Criteria andTransTimeIsNotNull() {
            addCriterion("trans_time is not null");
            return (Criteria) this;
        }

        public Criteria andTransTimeEqualTo(Date value) {
            addCriterion("trans_time =", value, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeNotEqualTo(Date value) {
            addCriterion("trans_time <>", value, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeGreaterThan(Date value) {
            addCriterion("trans_time >", value, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("trans_time >=", value, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeLessThan(Date value) {
            addCriterion("trans_time <", value, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeLessThanOrEqualTo(Date value) {
            addCriterion("trans_time <=", value, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeIn(List<Date> values) {
            addCriterion("trans_time in", values, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeNotIn(List<Date> values) {
            addCriterion("trans_time not in", values, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeBetween(Date value1, Date value2) {
            addCriterion("trans_time between", value1, value2, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransTimeNotBetween(Date value1, Date value2) {
            addCriterion("trans_time not between", value1, value2, "transTime");
            return (Criteria) this;
        }

        public Criteria andTransStatusIsNull() {
            addCriterion("trans_status is null");
            return (Criteria) this;
        }

        public Criteria andTransStatusIsNotNull() {
            addCriterion("trans_status is not null");
            return (Criteria) this;
        }

        public Criteria andTransStatusEqualTo(String value) {
            addCriterion("trans_status =", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusNotEqualTo(String value) {
            addCriterion("trans_status <>", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusGreaterThan(String value) {
            addCriterion("trans_status >", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusGreaterThanOrEqualTo(String value) {
            addCriterion("trans_status >=", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusLessThan(String value) {
            addCriterion("trans_status <", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusLessThanOrEqualTo(String value) {
            addCriterion("trans_status <=", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusLike(String value) {
            addCriterion("trans_status like", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusNotLike(String value) {
            addCriterion("trans_status not like", value, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusIn(List<String> values) {
            addCriterion("trans_status in", values, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusNotIn(List<String> values) {
            addCriterion("trans_status not in", values, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusBetween(String value1, String value2) {
            addCriterion("trans_status between", value1, value2, "transStatus");
            return (Criteria) this;
        }

        public Criteria andTransStatusNotBetween(String value1, String value2) {
            addCriterion("trans_status not between", value1, value2, "transStatus");
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