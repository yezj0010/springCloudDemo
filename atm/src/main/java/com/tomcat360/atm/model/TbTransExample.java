package com.tomcat360.atm.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbTransExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbTransExample() {
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

        public Criteria andEquipmentLogSeqIsNull() {
            addCriterion("equipment_log_seq is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentLogSeqIsNotNull() {
            addCriterion("equipment_log_seq is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentLogSeqEqualTo(String value) {
            addCriterion("equipment_log_seq =", value, "equipmentLogSeq");
            return (Criteria) this;
        }

        public Criteria andEquipmentLogSeqNotEqualTo(String value) {
            addCriterion("equipment_log_seq <>", value, "equipmentLogSeq");
            return (Criteria) this;
        }

        public Criteria andEquipmentLogSeqGreaterThan(String value) {
            addCriterion("equipment_log_seq >", value, "equipmentLogSeq");
            return (Criteria) this;
        }

        public Criteria andEquipmentLogSeqGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_log_seq >=", value, "equipmentLogSeq");
            return (Criteria) this;
        }

        public Criteria andEquipmentLogSeqLessThan(String value) {
            addCriterion("equipment_log_seq <", value, "equipmentLogSeq");
            return (Criteria) this;
        }

        public Criteria andEquipmentLogSeqLessThanOrEqualTo(String value) {
            addCriterion("equipment_log_seq <=", value, "equipmentLogSeq");
            return (Criteria) this;
        }

        public Criteria andEquipmentLogSeqLike(String value) {
            addCriterion("equipment_log_seq like", value, "equipmentLogSeq");
            return (Criteria) this;
        }

        public Criteria andEquipmentLogSeqNotLike(String value) {
            addCriterion("equipment_log_seq not like", value, "equipmentLogSeq");
            return (Criteria) this;
        }

        public Criteria andEquipmentLogSeqIn(List<String> values) {
            addCriterion("equipment_log_seq in", values, "equipmentLogSeq");
            return (Criteria) this;
        }

        public Criteria andEquipmentLogSeqNotIn(List<String> values) {
            addCriterion("equipment_log_seq not in", values, "equipmentLogSeq");
            return (Criteria) this;
        }

        public Criteria andEquipmentLogSeqBetween(String value1, String value2) {
            addCriterion("equipment_log_seq between", value1, value2, "equipmentLogSeq");
            return (Criteria) this;
        }

        public Criteria andEquipmentLogSeqNotBetween(String value1, String value2) {
            addCriterion("equipment_log_seq not between", value1, value2, "equipmentLogSeq");
            return (Criteria) this;
        }

        public Criteria andOriIdIsNull() {
            addCriterion("ori_id is null");
            return (Criteria) this;
        }

        public Criteria andOriIdIsNotNull() {
            addCriterion("ori_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriIdEqualTo(String value) {
            addCriterion("ori_id =", value, "oriId");
            return (Criteria) this;
        }

        public Criteria andOriIdNotEqualTo(String value) {
            addCriterion("ori_id <>", value, "oriId");
            return (Criteria) this;
        }

        public Criteria andOriIdGreaterThan(String value) {
            addCriterion("ori_id >", value, "oriId");
            return (Criteria) this;
        }

        public Criteria andOriIdGreaterThanOrEqualTo(String value) {
            addCriterion("ori_id >=", value, "oriId");
            return (Criteria) this;
        }

        public Criteria andOriIdLessThan(String value) {
            addCriterion("ori_id <", value, "oriId");
            return (Criteria) this;
        }

        public Criteria andOriIdLessThanOrEqualTo(String value) {
            addCriterion("ori_id <=", value, "oriId");
            return (Criteria) this;
        }

        public Criteria andOriIdLike(String value) {
            addCriterion("ori_id like", value, "oriId");
            return (Criteria) this;
        }

        public Criteria andOriIdNotLike(String value) {
            addCriterion("ori_id not like", value, "oriId");
            return (Criteria) this;
        }

        public Criteria andOriIdIn(List<String> values) {
            addCriterion("ori_id in", values, "oriId");
            return (Criteria) this;
        }

        public Criteria andOriIdNotIn(List<String> values) {
            addCriterion("ori_id not in", values, "oriId");
            return (Criteria) this;
        }

        public Criteria andOriIdBetween(String value1, String value2) {
            addCriterion("ori_id between", value1, value2, "oriId");
            return (Criteria) this;
        }

        public Criteria andOriIdNotBetween(String value1, String value2) {
            addCriterion("ori_id not between", value1, value2, "oriId");
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

        public Criteria andUserTokenIsNull() {
            addCriterion("user_token is null");
            return (Criteria) this;
        }

        public Criteria andUserTokenIsNotNull() {
            addCriterion("user_token is not null");
            return (Criteria) this;
        }

        public Criteria andUserTokenEqualTo(String value) {
            addCriterion("user_token =", value, "userToken");
            return (Criteria) this;
        }

        public Criteria andUserTokenNotEqualTo(String value) {
            addCriterion("user_token <>", value, "userToken");
            return (Criteria) this;
        }

        public Criteria andUserTokenGreaterThan(String value) {
            addCriterion("user_token >", value, "userToken");
            return (Criteria) this;
        }

        public Criteria andUserTokenGreaterThanOrEqualTo(String value) {
            addCriterion("user_token >=", value, "userToken");
            return (Criteria) this;
        }

        public Criteria andUserTokenLessThan(String value) {
            addCriterion("user_token <", value, "userToken");
            return (Criteria) this;
        }

        public Criteria andUserTokenLessThanOrEqualTo(String value) {
            addCriterion("user_token <=", value, "userToken");
            return (Criteria) this;
        }

        public Criteria andUserTokenLike(String value) {
            addCriterion("user_token like", value, "userToken");
            return (Criteria) this;
        }

        public Criteria andUserTokenNotLike(String value) {
            addCriterion("user_token not like", value, "userToken");
            return (Criteria) this;
        }

        public Criteria andUserTokenIn(List<String> values) {
            addCriterion("user_token in", values, "userToken");
            return (Criteria) this;
        }

        public Criteria andUserTokenNotIn(List<String> values) {
            addCriterion("user_token not in", values, "userToken");
            return (Criteria) this;
        }

        public Criteria andUserTokenBetween(String value1, String value2) {
            addCriterion("user_token between", value1, value2, "userToken");
            return (Criteria) this;
        }

        public Criteria andUserTokenNotBetween(String value1, String value2) {
            addCriterion("user_token not between", value1, value2, "userToken");
            return (Criteria) this;
        }

        public Criteria andUserLocalTokenIsNull() {
            addCriterion("user_local_token is null");
            return (Criteria) this;
        }

        public Criteria andUserLocalTokenIsNotNull() {
            addCriterion("user_local_token is not null");
            return (Criteria) this;
        }

        public Criteria andUserLocalTokenEqualTo(String value) {
            addCriterion("user_local_token =", value, "userLocalToken");
            return (Criteria) this;
        }

        public Criteria andUserLocalTokenNotEqualTo(String value) {
            addCriterion("user_local_token <>", value, "userLocalToken");
            return (Criteria) this;
        }

        public Criteria andUserLocalTokenGreaterThan(String value) {
            addCriterion("user_local_token >", value, "userLocalToken");
            return (Criteria) this;
        }

        public Criteria andUserLocalTokenGreaterThanOrEqualTo(String value) {
            addCriterion("user_local_token >=", value, "userLocalToken");
            return (Criteria) this;
        }

        public Criteria andUserLocalTokenLessThan(String value) {
            addCriterion("user_local_token <", value, "userLocalToken");
            return (Criteria) this;
        }

        public Criteria andUserLocalTokenLessThanOrEqualTo(String value) {
            addCriterion("user_local_token <=", value, "userLocalToken");
            return (Criteria) this;
        }

        public Criteria andUserLocalTokenLike(String value) {
            addCriterion("user_local_token like", value, "userLocalToken");
            return (Criteria) this;
        }

        public Criteria andUserLocalTokenNotLike(String value) {
            addCriterion("user_local_token not like", value, "userLocalToken");
            return (Criteria) this;
        }

        public Criteria andUserLocalTokenIn(List<String> values) {
            addCriterion("user_local_token in", values, "userLocalToken");
            return (Criteria) this;
        }

        public Criteria andUserLocalTokenNotIn(List<String> values) {
            addCriterion("user_local_token not in", values, "userLocalToken");
            return (Criteria) this;
        }

        public Criteria andUserLocalTokenBetween(String value1, String value2) {
            addCriterion("user_local_token between", value1, value2, "userLocalToken");
            return (Criteria) this;
        }

        public Criteria andUserLocalTokenNotBetween(String value1, String value2) {
            addCriterion("user_local_token not between", value1, value2, "userLocalToken");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeIsNull() {
            addCriterion("interface_code is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeIsNotNull() {
            addCriterion("interface_code is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeEqualTo(String value) {
            addCriterion("interface_code =", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeNotEqualTo(String value) {
            addCriterion("interface_code <>", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeGreaterThan(String value) {
            addCriterion("interface_code >", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("interface_code >=", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeLessThan(String value) {
            addCriterion("interface_code <", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeLessThanOrEqualTo(String value) {
            addCriterion("interface_code <=", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeLike(String value) {
            addCriterion("interface_code like", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeNotLike(String value) {
            addCriterion("interface_code not like", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeIn(List<String> values) {
            addCriterion("interface_code in", values, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeNotIn(List<String> values) {
            addCriterion("interface_code not in", values, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeBetween(String value1, String value2) {
            addCriterion("interface_code between", value1, value2, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeNotBetween(String value1, String value2) {
            addCriterion("interface_code not between", value1, value2, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeIsNull() {
            addCriterion("interface_type is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeIsNotNull() {
            addCriterion("interface_type is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeEqualTo(String value) {
            addCriterion("interface_type =", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeNotEqualTo(String value) {
            addCriterion("interface_type <>", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeGreaterThan(String value) {
            addCriterion("interface_type >", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("interface_type >=", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeLessThan(String value) {
            addCriterion("interface_type <", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeLessThanOrEqualTo(String value) {
            addCriterion("interface_type <=", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeLike(String value) {
            addCriterion("interface_type like", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeNotLike(String value) {
            addCriterion("interface_type not like", value, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeIn(List<String> values) {
            addCriterion("interface_type in", values, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeNotIn(List<String> values) {
            addCriterion("interface_type not in", values, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeBetween(String value1, String value2) {
            addCriterion("interface_type between", value1, value2, "interfaceType");
            return (Criteria) this;
        }

        public Criteria andInterfaceTypeNotBetween(String value1, String value2) {
            addCriterion("interface_type not between", value1, value2, "interfaceType");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRespCodeIsNull() {
            addCriterion("resp_code is null");
            return (Criteria) this;
        }

        public Criteria andRespCodeIsNotNull() {
            addCriterion("resp_code is not null");
            return (Criteria) this;
        }

        public Criteria andRespCodeEqualTo(String value) {
            addCriterion("resp_code =", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeNotEqualTo(String value) {
            addCriterion("resp_code <>", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeGreaterThan(String value) {
            addCriterion("resp_code >", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeGreaterThanOrEqualTo(String value) {
            addCriterion("resp_code >=", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeLessThan(String value) {
            addCriterion("resp_code <", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeLessThanOrEqualTo(String value) {
            addCriterion("resp_code <=", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeLike(String value) {
            addCriterion("resp_code like", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeNotLike(String value) {
            addCriterion("resp_code not like", value, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeIn(List<String> values) {
            addCriterion("resp_code in", values, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeNotIn(List<String> values) {
            addCriterion("resp_code not in", values, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeBetween(String value1, String value2) {
            addCriterion("resp_code between", value1, value2, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespCodeNotBetween(String value1, String value2) {
            addCriterion("resp_code not between", value1, value2, "respCode");
            return (Criteria) this;
        }

        public Criteria andRespMsgIsNull() {
            addCriterion("resp_msg is null");
            return (Criteria) this;
        }

        public Criteria andRespMsgIsNotNull() {
            addCriterion("resp_msg is not null");
            return (Criteria) this;
        }

        public Criteria andRespMsgEqualTo(String value) {
            addCriterion("resp_msg =", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgNotEqualTo(String value) {
            addCriterion("resp_msg <>", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgGreaterThan(String value) {
            addCriterion("resp_msg >", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgGreaterThanOrEqualTo(String value) {
            addCriterion("resp_msg >=", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgLessThan(String value) {
            addCriterion("resp_msg <", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgLessThanOrEqualTo(String value) {
            addCriterion("resp_msg <=", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgLike(String value) {
            addCriterion("resp_msg like", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgNotLike(String value) {
            addCriterion("resp_msg not like", value, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgIn(List<String> values) {
            addCriterion("resp_msg in", values, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgNotIn(List<String> values) {
            addCriterion("resp_msg not in", values, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgBetween(String value1, String value2) {
            addCriterion("resp_msg between", value1, value2, "respMsg");
            return (Criteria) this;
        }

        public Criteria andRespMsgNotBetween(String value1, String value2) {
            addCriterion("resp_msg not between", value1, value2, "respMsg");
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

        public Criteria andExTransSeqIsNull() {
            addCriterion("ex_trans_seq is null");
            return (Criteria) this;
        }

        public Criteria andExTransSeqIsNotNull() {
            addCriterion("ex_trans_seq is not null");
            return (Criteria) this;
        }

        public Criteria andExTransSeqEqualTo(String value) {
            addCriterion("ex_trans_seq =", value, "exTransSeq");
            return (Criteria) this;
        }

        public Criteria andExTransSeqNotEqualTo(String value) {
            addCriterion("ex_trans_seq <>", value, "exTransSeq");
            return (Criteria) this;
        }

        public Criteria andExTransSeqGreaterThan(String value) {
            addCriterion("ex_trans_seq >", value, "exTransSeq");
            return (Criteria) this;
        }

        public Criteria andExTransSeqGreaterThanOrEqualTo(String value) {
            addCriterion("ex_trans_seq >=", value, "exTransSeq");
            return (Criteria) this;
        }

        public Criteria andExTransSeqLessThan(String value) {
            addCriterion("ex_trans_seq <", value, "exTransSeq");
            return (Criteria) this;
        }

        public Criteria andExTransSeqLessThanOrEqualTo(String value) {
            addCriterion("ex_trans_seq <=", value, "exTransSeq");
            return (Criteria) this;
        }

        public Criteria andExTransSeqLike(String value) {
            addCriterion("ex_trans_seq like", value, "exTransSeq");
            return (Criteria) this;
        }

        public Criteria andExTransSeqNotLike(String value) {
            addCriterion("ex_trans_seq not like", value, "exTransSeq");
            return (Criteria) this;
        }

        public Criteria andExTransSeqIn(List<String> values) {
            addCriterion("ex_trans_seq in", values, "exTransSeq");
            return (Criteria) this;
        }

        public Criteria andExTransSeqNotIn(List<String> values) {
            addCriterion("ex_trans_seq not in", values, "exTransSeq");
            return (Criteria) this;
        }

        public Criteria andExTransSeqBetween(String value1, String value2) {
            addCriterion("ex_trans_seq between", value1, value2, "exTransSeq");
            return (Criteria) this;
        }

        public Criteria andExTransSeqNotBetween(String value1, String value2) {
            addCriterion("ex_trans_seq not between", value1, value2, "exTransSeq");
            return (Criteria) this;
        }

        public Criteria andExTransTimeIsNull() {
            addCriterion("ex_trans_time is null");
            return (Criteria) this;
        }

        public Criteria andExTransTimeIsNotNull() {
            addCriterion("ex_trans_time is not null");
            return (Criteria) this;
        }

        public Criteria andExTransTimeEqualTo(Long value) {
            addCriterion("ex_trans_time =", value, "exTransTime");
            return (Criteria) this;
        }

        public Criteria andExTransTimeNotEqualTo(Long value) {
            addCriterion("ex_trans_time <>", value, "exTransTime");
            return (Criteria) this;
        }

        public Criteria andExTransTimeGreaterThan(Long value) {
            addCriterion("ex_trans_time >", value, "exTransTime");
            return (Criteria) this;
        }

        public Criteria andExTransTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("ex_trans_time >=", value, "exTransTime");
            return (Criteria) this;
        }

        public Criteria andExTransTimeLessThan(Long value) {
            addCriterion("ex_trans_time <", value, "exTransTime");
            return (Criteria) this;
        }

        public Criteria andExTransTimeLessThanOrEqualTo(Long value) {
            addCriterion("ex_trans_time <=", value, "exTransTime");
            return (Criteria) this;
        }

        public Criteria andExTransTimeIn(List<Long> values) {
            addCriterion("ex_trans_time in", values, "exTransTime");
            return (Criteria) this;
        }

        public Criteria andExTransTimeNotIn(List<Long> values) {
            addCriterion("ex_trans_time not in", values, "exTransTime");
            return (Criteria) this;
        }

        public Criteria andExTransTimeBetween(Long value1, Long value2) {
            addCriterion("ex_trans_time between", value1, value2, "exTransTime");
            return (Criteria) this;
        }

        public Criteria andExTransTimeNotBetween(Long value1, Long value2) {
            addCriterion("ex_trans_time not between", value1, value2, "exTransTime");
            return (Criteria) this;
        }

        public Criteria andTermDateIsNull() {
            addCriterion("term_date is null");
            return (Criteria) this;
        }

        public Criteria andTermDateIsNotNull() {
            addCriterion("term_date is not null");
            return (Criteria) this;
        }

        public Criteria andTermDateEqualTo(Date value) {
            addCriterion("term_date =", value, "termDate");
            return (Criteria) this;
        }

        public Criteria andTermDateNotEqualTo(Date value) {
            addCriterion("term_date <>", value, "termDate");
            return (Criteria) this;
        }

        public Criteria andTermDateGreaterThan(Date value) {
            addCriterion("term_date >", value, "termDate");
            return (Criteria) this;
        }

        public Criteria andTermDateGreaterThanOrEqualTo(Date value) {
            addCriterion("term_date >=", value, "termDate");
            return (Criteria) this;
        }

        public Criteria andTermDateLessThan(Date value) {
            addCriterion("term_date <", value, "termDate");
            return (Criteria) this;
        }

        public Criteria andTermDateLessThanOrEqualTo(Date value) {
            addCriterion("term_date <=", value, "termDate");
            return (Criteria) this;
        }

        public Criteria andTermDateIn(List<Date> values) {
            addCriterion("term_date in", values, "termDate");
            return (Criteria) this;
        }

        public Criteria andTermDateNotIn(List<Date> values) {
            addCriterion("term_date not in", values, "termDate");
            return (Criteria) this;
        }

        public Criteria andTermDateBetween(Date value1, Date value2) {
            addCriterion("term_date between", value1, value2, "termDate");
            return (Criteria) this;
        }

        public Criteria andTermDateNotBetween(Date value1, Date value2) {
            addCriterion("term_date not between", value1, value2, "termDate");
            return (Criteria) this;
        }

        public Criteria andTransFeeIsNull() {
            addCriterion("trans_fee is null");
            return (Criteria) this;
        }

        public Criteria andTransFeeIsNotNull() {
            addCriterion("trans_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTransFeeEqualTo(BigDecimal value) {
            addCriterion("trans_fee =", value, "transFee");
            return (Criteria) this;
        }

        public Criteria andTransFeeNotEqualTo(BigDecimal value) {
            addCriterion("trans_fee <>", value, "transFee");
            return (Criteria) this;
        }

        public Criteria andTransFeeGreaterThan(BigDecimal value) {
            addCriterion("trans_fee >", value, "transFee");
            return (Criteria) this;
        }

        public Criteria andTransFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("trans_fee >=", value, "transFee");
            return (Criteria) this;
        }

        public Criteria andTransFeeLessThan(BigDecimal value) {
            addCriterion("trans_fee <", value, "transFee");
            return (Criteria) this;
        }

        public Criteria andTransFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("trans_fee <=", value, "transFee");
            return (Criteria) this;
        }

        public Criteria andTransFeeIn(List<BigDecimal> values) {
            addCriterion("trans_fee in", values, "transFee");
            return (Criteria) this;
        }

        public Criteria andTransFeeNotIn(List<BigDecimal> values) {
            addCriterion("trans_fee not in", values, "transFee");
            return (Criteria) this;
        }

        public Criteria andTransFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trans_fee between", value1, value2, "transFee");
            return (Criteria) this;
        }

        public Criteria andTransFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trans_fee not between", value1, value2, "transFee");
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

        public Criteria andExCheckStatusIsNull() {
            addCriterion("ex_check_status is null");
            return (Criteria) this;
        }

        public Criteria andExCheckStatusIsNotNull() {
            addCriterion("ex_check_status is not null");
            return (Criteria) this;
        }

        public Criteria andExCheckStatusEqualTo(String value) {
            addCriterion("ex_check_status =", value, "exCheckStatus");
            return (Criteria) this;
        }

        public Criteria andExCheckStatusNotEqualTo(String value) {
            addCriterion("ex_check_status <>", value, "exCheckStatus");
            return (Criteria) this;
        }

        public Criteria andExCheckStatusGreaterThan(String value) {
            addCriterion("ex_check_status >", value, "exCheckStatus");
            return (Criteria) this;
        }

        public Criteria andExCheckStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ex_check_status >=", value, "exCheckStatus");
            return (Criteria) this;
        }

        public Criteria andExCheckStatusLessThan(String value) {
            addCriterion("ex_check_status <", value, "exCheckStatus");
            return (Criteria) this;
        }

        public Criteria andExCheckStatusLessThanOrEqualTo(String value) {
            addCriterion("ex_check_status <=", value, "exCheckStatus");
            return (Criteria) this;
        }

        public Criteria andExCheckStatusLike(String value) {
            addCriterion("ex_check_status like", value, "exCheckStatus");
            return (Criteria) this;
        }

        public Criteria andExCheckStatusNotLike(String value) {
            addCriterion("ex_check_status not like", value, "exCheckStatus");
            return (Criteria) this;
        }

        public Criteria andExCheckStatusIn(List<String> values) {
            addCriterion("ex_check_status in", values, "exCheckStatus");
            return (Criteria) this;
        }

        public Criteria andExCheckStatusNotIn(List<String> values) {
            addCriterion("ex_check_status not in", values, "exCheckStatus");
            return (Criteria) this;
        }

        public Criteria andExCheckStatusBetween(String value1, String value2) {
            addCriterion("ex_check_status between", value1, value2, "exCheckStatus");
            return (Criteria) this;
        }

        public Criteria andExCheckStatusNotBetween(String value1, String value2) {
            addCriterion("ex_check_status not between", value1, value2, "exCheckStatus");
            return (Criteria) this;
        }

        public Criteria andCCheckStatusIsNull() {
            addCriterion("c_check_status is null");
            return (Criteria) this;
        }

        public Criteria andCCheckStatusIsNotNull() {
            addCriterion("c_check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCCheckStatusEqualTo(String value) {
            addCriterion("c_check_status =", value, "cCheckStatus");
            return (Criteria) this;
        }

        public Criteria andCCheckStatusNotEqualTo(String value) {
            addCriterion("c_check_status <>", value, "cCheckStatus");
            return (Criteria) this;
        }

        public Criteria andCCheckStatusGreaterThan(String value) {
            addCriterion("c_check_status >", value, "cCheckStatus");
            return (Criteria) this;
        }

        public Criteria andCCheckStatusGreaterThanOrEqualTo(String value) {
            addCriterion("c_check_status >=", value, "cCheckStatus");
            return (Criteria) this;
        }

        public Criteria andCCheckStatusLessThan(String value) {
            addCriterion("c_check_status <", value, "cCheckStatus");
            return (Criteria) this;
        }

        public Criteria andCCheckStatusLessThanOrEqualTo(String value) {
            addCriterion("c_check_status <=", value, "cCheckStatus");
            return (Criteria) this;
        }

        public Criteria andCCheckStatusLike(String value) {
            addCriterion("c_check_status like", value, "cCheckStatus");
            return (Criteria) this;
        }

        public Criteria andCCheckStatusNotLike(String value) {
            addCriterion("c_check_status not like", value, "cCheckStatus");
            return (Criteria) this;
        }

        public Criteria andCCheckStatusIn(List<String> values) {
            addCriterion("c_check_status in", values, "cCheckStatus");
            return (Criteria) this;
        }

        public Criteria andCCheckStatusNotIn(List<String> values) {
            addCriterion("c_check_status not in", values, "cCheckStatus");
            return (Criteria) this;
        }

        public Criteria andCCheckStatusBetween(String value1, String value2) {
            addCriterion("c_check_status between", value1, value2, "cCheckStatus");
            return (Criteria) this;
        }

        public Criteria andCCheckStatusNotBetween(String value1, String value2) {
            addCriterion("c_check_status not between", value1, value2, "cCheckStatus");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
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