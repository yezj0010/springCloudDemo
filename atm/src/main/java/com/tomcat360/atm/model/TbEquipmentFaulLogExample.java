package com.tomcat360.atm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbEquipmentFaulLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipmentFaulLogExample() {
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

        public Criteria andIfDownIsNull() {
            addCriterion("if_down is null");
            return (Criteria) this;
        }

        public Criteria andIfDownIsNotNull() {
            addCriterion("if_down is not null");
            return (Criteria) this;
        }

        public Criteria andIfDownEqualTo(String value) {
            addCriterion("if_down =", value, "ifDown");
            return (Criteria) this;
        }

        public Criteria andIfDownNotEqualTo(String value) {
            addCriterion("if_down <>", value, "ifDown");
            return (Criteria) this;
        }

        public Criteria andIfDownGreaterThan(String value) {
            addCriterion("if_down >", value, "ifDown");
            return (Criteria) this;
        }

        public Criteria andIfDownGreaterThanOrEqualTo(String value) {
            addCriterion("if_down >=", value, "ifDown");
            return (Criteria) this;
        }

        public Criteria andIfDownLessThan(String value) {
            addCriterion("if_down <", value, "ifDown");
            return (Criteria) this;
        }

        public Criteria andIfDownLessThanOrEqualTo(String value) {
            addCriterion("if_down <=", value, "ifDown");
            return (Criteria) this;
        }

        public Criteria andIfDownLike(String value) {
            addCriterion("if_down like", value, "ifDown");
            return (Criteria) this;
        }

        public Criteria andIfDownNotLike(String value) {
            addCriterion("if_down not like", value, "ifDown");
            return (Criteria) this;
        }

        public Criteria andIfDownIn(List<String> values) {
            addCriterion("if_down in", values, "ifDown");
            return (Criteria) this;
        }

        public Criteria andIfDownNotIn(List<String> values) {
            addCriterion("if_down not in", values, "ifDown");
            return (Criteria) this;
        }

        public Criteria andIfDownBetween(String value1, String value2) {
            addCriterion("if_down between", value1, value2, "ifDown");
            return (Criteria) this;
        }

        public Criteria andIfDownNotBetween(String value1, String value2) {
            addCriterion("if_down not between", value1, value2, "ifDown");
            return (Criteria) this;
        }

        public Criteria andDownReasonIsNull() {
            addCriterion("down_reason is null");
            return (Criteria) this;
        }

        public Criteria andDownReasonIsNotNull() {
            addCriterion("down_reason is not null");
            return (Criteria) this;
        }

        public Criteria andDownReasonEqualTo(String value) {
            addCriterion("down_reason =", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonNotEqualTo(String value) {
            addCriterion("down_reason <>", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonGreaterThan(String value) {
            addCriterion("down_reason >", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonGreaterThanOrEqualTo(String value) {
            addCriterion("down_reason >=", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonLessThan(String value) {
            addCriterion("down_reason <", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonLessThanOrEqualTo(String value) {
            addCriterion("down_reason <=", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonLike(String value) {
            addCriterion("down_reason like", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonNotLike(String value) {
            addCriterion("down_reason not like", value, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonIn(List<String> values) {
            addCriterion("down_reason in", values, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonNotIn(List<String> values) {
            addCriterion("down_reason not in", values, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonBetween(String value1, String value2) {
            addCriterion("down_reason between", value1, value2, "downReason");
            return (Criteria) this;
        }

        public Criteria andDownReasonNotBetween(String value1, String value2) {
            addCriterion("down_reason not between", value1, value2, "downReason");
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

        public Criteria andRecoveryTimeIsNull() {
            addCriterion("recovery_time is null");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeIsNotNull() {
            addCriterion("recovery_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeEqualTo(Date value) {
            addCriterion("recovery_time =", value, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeNotEqualTo(Date value) {
            addCriterion("recovery_time <>", value, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeGreaterThan(Date value) {
            addCriterion("recovery_time >", value, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recovery_time >=", value, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeLessThan(Date value) {
            addCriterion("recovery_time <", value, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeLessThanOrEqualTo(Date value) {
            addCriterion("recovery_time <=", value, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeIn(List<Date> values) {
            addCriterion("recovery_time in", values, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeNotIn(List<Date> values) {
            addCriterion("recovery_time not in", values, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeBetween(Date value1, Date value2) {
            addCriterion("recovery_time between", value1, value2, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andRecoveryTimeNotBetween(Date value1, Date value2) {
            addCriterion("recovery_time not between", value1, value2, "recoveryTime");
            return (Criteria) this;
        }

        public Criteria andKeyBordIsNull() {
            addCriterion("key_bord is null");
            return (Criteria) this;
        }

        public Criteria andKeyBordIsNotNull() {
            addCriterion("key_bord is not null");
            return (Criteria) this;
        }

        public Criteria andKeyBordEqualTo(String value) {
            addCriterion("key_bord =", value, "keyBord");
            return (Criteria) this;
        }

        public Criteria andKeyBordNotEqualTo(String value) {
            addCriterion("key_bord <>", value, "keyBord");
            return (Criteria) this;
        }

        public Criteria andKeyBordGreaterThan(String value) {
            addCriterion("key_bord >", value, "keyBord");
            return (Criteria) this;
        }

        public Criteria andKeyBordGreaterThanOrEqualTo(String value) {
            addCriterion("key_bord >=", value, "keyBord");
            return (Criteria) this;
        }

        public Criteria andKeyBordLessThan(String value) {
            addCriterion("key_bord <", value, "keyBord");
            return (Criteria) this;
        }

        public Criteria andKeyBordLessThanOrEqualTo(String value) {
            addCriterion("key_bord <=", value, "keyBord");
            return (Criteria) this;
        }

        public Criteria andKeyBordLike(String value) {
            addCriterion("key_bord like", value, "keyBord");
            return (Criteria) this;
        }

        public Criteria andKeyBordNotLike(String value) {
            addCriterion("key_bord not like", value, "keyBord");
            return (Criteria) this;
        }

        public Criteria andKeyBordIn(List<String> values) {
            addCriterion("key_bord in", values, "keyBord");
            return (Criteria) this;
        }

        public Criteria andKeyBordNotIn(List<String> values) {
            addCriterion("key_bord not in", values, "keyBord");
            return (Criteria) this;
        }

        public Criteria andKeyBordBetween(String value1, String value2) {
            addCriterion("key_bord between", value1, value2, "keyBord");
            return (Criteria) this;
        }

        public Criteria andKeyBordNotBetween(String value1, String value2) {
            addCriterion("key_bord not between", value1, value2, "keyBord");
            return (Criteria) this;
        }

        public Criteria andTellerIsNull() {
            addCriterion("teller is null");
            return (Criteria) this;
        }

        public Criteria andTellerIsNotNull() {
            addCriterion("teller is not null");
            return (Criteria) this;
        }

        public Criteria andTellerEqualTo(String value) {
            addCriterion("teller =", value, "teller");
            return (Criteria) this;
        }

        public Criteria andTellerNotEqualTo(String value) {
            addCriterion("teller <>", value, "teller");
            return (Criteria) this;
        }

        public Criteria andTellerGreaterThan(String value) {
            addCriterion("teller >", value, "teller");
            return (Criteria) this;
        }

        public Criteria andTellerGreaterThanOrEqualTo(String value) {
            addCriterion("teller >=", value, "teller");
            return (Criteria) this;
        }

        public Criteria andTellerLessThan(String value) {
            addCriterion("teller <", value, "teller");
            return (Criteria) this;
        }

        public Criteria andTellerLessThanOrEqualTo(String value) {
            addCriterion("teller <=", value, "teller");
            return (Criteria) this;
        }

        public Criteria andTellerLike(String value) {
            addCriterion("teller like", value, "teller");
            return (Criteria) this;
        }

        public Criteria andTellerNotLike(String value) {
            addCriterion("teller not like", value, "teller");
            return (Criteria) this;
        }

        public Criteria andTellerIn(List<String> values) {
            addCriterion("teller in", values, "teller");
            return (Criteria) this;
        }

        public Criteria andTellerNotIn(List<String> values) {
            addCriterion("teller not in", values, "teller");
            return (Criteria) this;
        }

        public Criteria andTellerBetween(String value1, String value2) {
            addCriterion("teller between", value1, value2, "teller");
            return (Criteria) this;
        }

        public Criteria andTellerNotBetween(String value1, String value2) {
            addCriterion("teller not between", value1, value2, "teller");
            return (Criteria) this;
        }

        public Criteria andPrinterIsNull() {
            addCriterion("printer is null");
            return (Criteria) this;
        }

        public Criteria andPrinterIsNotNull() {
            addCriterion("printer is not null");
            return (Criteria) this;
        }

        public Criteria andPrinterEqualTo(String value) {
            addCriterion("printer =", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterNotEqualTo(String value) {
            addCriterion("printer <>", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterGreaterThan(String value) {
            addCriterion("printer >", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterGreaterThanOrEqualTo(String value) {
            addCriterion("printer >=", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterLessThan(String value) {
            addCriterion("printer <", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterLessThanOrEqualTo(String value) {
            addCriterion("printer <=", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterLike(String value) {
            addCriterion("printer like", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterNotLike(String value) {
            addCriterion("printer not like", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterIn(List<String> values) {
            addCriterion("printer in", values, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterNotIn(List<String> values) {
            addCriterion("printer not in", values, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterBetween(String value1, String value2) {
            addCriterion("printer between", value1, value2, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterNotBetween(String value1, String value2) {
            addCriterion("printer not between", value1, value2, "printer");
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

        public Criteria andBanknoteBoxStatusIsNull() {
            addCriterion("banknote_box_status is null");
            return (Criteria) this;
        }

        public Criteria andBanknoteBoxStatusIsNotNull() {
            addCriterion("banknote_box_status is not null");
            return (Criteria) this;
        }

        public Criteria andBanknoteBoxStatusEqualTo(String value) {
            addCriterion("banknote_box_status =", value, "banknoteBoxStatus");
            return (Criteria) this;
        }

        public Criteria andBanknoteBoxStatusNotEqualTo(String value) {
            addCriterion("banknote_box_status <>", value, "banknoteBoxStatus");
            return (Criteria) this;
        }

        public Criteria andBanknoteBoxStatusGreaterThan(String value) {
            addCriterion("banknote_box_status >", value, "banknoteBoxStatus");
            return (Criteria) this;
        }

        public Criteria andBanknoteBoxStatusGreaterThanOrEqualTo(String value) {
            addCriterion("banknote_box_status >=", value, "banknoteBoxStatus");
            return (Criteria) this;
        }

        public Criteria andBanknoteBoxStatusLessThan(String value) {
            addCriterion("banknote_box_status <", value, "banknoteBoxStatus");
            return (Criteria) this;
        }

        public Criteria andBanknoteBoxStatusLessThanOrEqualTo(String value) {
            addCriterion("banknote_box_status <=", value, "banknoteBoxStatus");
            return (Criteria) this;
        }

        public Criteria andBanknoteBoxStatusLike(String value) {
            addCriterion("banknote_box_status like", value, "banknoteBoxStatus");
            return (Criteria) this;
        }

        public Criteria andBanknoteBoxStatusNotLike(String value) {
            addCriterion("banknote_box_status not like", value, "banknoteBoxStatus");
            return (Criteria) this;
        }

        public Criteria andBanknoteBoxStatusIn(List<String> values) {
            addCriterion("banknote_box_status in", values, "banknoteBoxStatus");
            return (Criteria) this;
        }

        public Criteria andBanknoteBoxStatusNotIn(List<String> values) {
            addCriterion("banknote_box_status not in", values, "banknoteBoxStatus");
            return (Criteria) this;
        }

        public Criteria andBanknoteBoxStatusBetween(String value1, String value2) {
            addCriterion("banknote_box_status between", value1, value2, "banknoteBoxStatus");
            return (Criteria) this;
        }

        public Criteria andBanknoteBoxStatusNotBetween(String value1, String value2) {
            addCriterion("banknote_box_status not between", value1, value2, "banknoteBoxStatus");
            return (Criteria) this;
        }

        public Criteria andNetworkStatusIsNull() {
            addCriterion("network_status is null");
            return (Criteria) this;
        }

        public Criteria andNetworkStatusIsNotNull() {
            addCriterion("network_status is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkStatusEqualTo(String value) {
            addCriterion("network_status =", value, "networkStatus");
            return (Criteria) this;
        }

        public Criteria andNetworkStatusNotEqualTo(String value) {
            addCriterion("network_status <>", value, "networkStatus");
            return (Criteria) this;
        }

        public Criteria andNetworkStatusGreaterThan(String value) {
            addCriterion("network_status >", value, "networkStatus");
            return (Criteria) this;
        }

        public Criteria andNetworkStatusGreaterThanOrEqualTo(String value) {
            addCriterion("network_status >=", value, "networkStatus");
            return (Criteria) this;
        }

        public Criteria andNetworkStatusLessThan(String value) {
            addCriterion("network_status <", value, "networkStatus");
            return (Criteria) this;
        }

        public Criteria andNetworkStatusLessThanOrEqualTo(String value) {
            addCriterion("network_status <=", value, "networkStatus");
            return (Criteria) this;
        }

        public Criteria andNetworkStatusLike(String value) {
            addCriterion("network_status like", value, "networkStatus");
            return (Criteria) this;
        }

        public Criteria andNetworkStatusNotLike(String value) {
            addCriterion("network_status not like", value, "networkStatus");
            return (Criteria) this;
        }

        public Criteria andNetworkStatusIn(List<String> values) {
            addCriterion("network_status in", values, "networkStatus");
            return (Criteria) this;
        }

        public Criteria andNetworkStatusNotIn(List<String> values) {
            addCriterion("network_status not in", values, "networkStatus");
            return (Criteria) this;
        }

        public Criteria andNetworkStatusBetween(String value1, String value2) {
            addCriterion("network_status between", value1, value2, "networkStatus");
            return (Criteria) this;
        }

        public Criteria andNetworkStatusNotBetween(String value1, String value2) {
            addCriterion("network_status not between", value1, value2, "networkStatus");
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

        public Criteria andRunningStatusIsNull() {
            addCriterion("running_status is null");
            return (Criteria) this;
        }

        public Criteria andRunningStatusIsNotNull() {
            addCriterion("running_status is not null");
            return (Criteria) this;
        }

        public Criteria andRunningStatusEqualTo(String value) {
            addCriterion("running_status =", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusNotEqualTo(String value) {
            addCriterion("running_status <>", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusGreaterThan(String value) {
            addCriterion("running_status >", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusGreaterThanOrEqualTo(String value) {
            addCriterion("running_status >=", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusLessThan(String value) {
            addCriterion("running_status <", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusLessThanOrEqualTo(String value) {
            addCriterion("running_status <=", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusLike(String value) {
            addCriterion("running_status like", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusNotLike(String value) {
            addCriterion("running_status not like", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusIn(List<String> values) {
            addCriterion("running_status in", values, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusNotIn(List<String> values) {
            addCriterion("running_status not in", values, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusBetween(String value1, String value2) {
            addCriterion("running_status between", value1, value2, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusNotBetween(String value1, String value2) {
            addCriterion("running_status not between", value1, value2, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andModuleStatusIsNull() {
            addCriterion("module_status is null");
            return (Criteria) this;
        }

        public Criteria andModuleStatusIsNotNull() {
            addCriterion("module_status is not null");
            return (Criteria) this;
        }

        public Criteria andModuleStatusEqualTo(String value) {
            addCriterion("module_status =", value, "moduleStatus");
            return (Criteria) this;
        }

        public Criteria andModuleStatusNotEqualTo(String value) {
            addCriterion("module_status <>", value, "moduleStatus");
            return (Criteria) this;
        }

        public Criteria andModuleStatusGreaterThan(String value) {
            addCriterion("module_status >", value, "moduleStatus");
            return (Criteria) this;
        }

        public Criteria andModuleStatusGreaterThanOrEqualTo(String value) {
            addCriterion("module_status >=", value, "moduleStatus");
            return (Criteria) this;
        }

        public Criteria andModuleStatusLessThan(String value) {
            addCriterion("module_status <", value, "moduleStatus");
            return (Criteria) this;
        }

        public Criteria andModuleStatusLessThanOrEqualTo(String value) {
            addCriterion("module_status <=", value, "moduleStatus");
            return (Criteria) this;
        }

        public Criteria andModuleStatusLike(String value) {
            addCriterion("module_status like", value, "moduleStatus");
            return (Criteria) this;
        }

        public Criteria andModuleStatusNotLike(String value) {
            addCriterion("module_status not like", value, "moduleStatus");
            return (Criteria) this;
        }

        public Criteria andModuleStatusIn(List<String> values) {
            addCriterion("module_status in", values, "moduleStatus");
            return (Criteria) this;
        }

        public Criteria andModuleStatusNotIn(List<String> values) {
            addCriterion("module_status not in", values, "moduleStatus");
            return (Criteria) this;
        }

        public Criteria andModuleStatusBetween(String value1, String value2) {
            addCriterion("module_status between", value1, value2, "moduleStatus");
            return (Criteria) this;
        }

        public Criteria andModuleStatusNotBetween(String value1, String value2) {
            addCriterion("module_status not between", value1, value2, "moduleStatus");
            return (Criteria) this;
        }

        public Criteria andPrrStatusIsNull() {
            addCriterion("prr_status is null");
            return (Criteria) this;
        }

        public Criteria andPrrStatusIsNotNull() {
            addCriterion("prr_status is not null");
            return (Criteria) this;
        }

        public Criteria andPrrStatusEqualTo(String value) {
            addCriterion("prr_status =", value, "prrStatus");
            return (Criteria) this;
        }

        public Criteria andPrrStatusNotEqualTo(String value) {
            addCriterion("prr_status <>", value, "prrStatus");
            return (Criteria) this;
        }

        public Criteria andPrrStatusGreaterThan(String value) {
            addCriterion("prr_status >", value, "prrStatus");
            return (Criteria) this;
        }

        public Criteria andPrrStatusGreaterThanOrEqualTo(String value) {
            addCriterion("prr_status >=", value, "prrStatus");
            return (Criteria) this;
        }

        public Criteria andPrrStatusLessThan(String value) {
            addCriterion("prr_status <", value, "prrStatus");
            return (Criteria) this;
        }

        public Criteria andPrrStatusLessThanOrEqualTo(String value) {
            addCriterion("prr_status <=", value, "prrStatus");
            return (Criteria) this;
        }

        public Criteria andPrrStatusLike(String value) {
            addCriterion("prr_status like", value, "prrStatus");
            return (Criteria) this;
        }

        public Criteria andPrrStatusNotLike(String value) {
            addCriterion("prr_status not like", value, "prrStatus");
            return (Criteria) this;
        }

        public Criteria andPrrStatusIn(List<String> values) {
            addCriterion("prr_status in", values, "prrStatus");
            return (Criteria) this;
        }

        public Criteria andPrrStatusNotIn(List<String> values) {
            addCriterion("prr_status not in", values, "prrStatus");
            return (Criteria) this;
        }

        public Criteria andPrrStatusBetween(String value1, String value2) {
            addCriterion("prr_status between", value1, value2, "prrStatus");
            return (Criteria) this;
        }

        public Criteria andPrrStatusNotBetween(String value1, String value2) {
            addCriterion("prr_status not between", value1, value2, "prrStatus");
            return (Criteria) this;
        }

        public Criteria andCimStatusIsNull() {
            addCriterion("cim_status is null");
            return (Criteria) this;
        }

        public Criteria andCimStatusIsNotNull() {
            addCriterion("cim_status is not null");
            return (Criteria) this;
        }

        public Criteria andCimStatusEqualTo(String value) {
            addCriterion("cim_status =", value, "cimStatus");
            return (Criteria) this;
        }

        public Criteria andCimStatusNotEqualTo(String value) {
            addCriterion("cim_status <>", value, "cimStatus");
            return (Criteria) this;
        }

        public Criteria andCimStatusGreaterThan(String value) {
            addCriterion("cim_status >", value, "cimStatus");
            return (Criteria) this;
        }

        public Criteria andCimStatusGreaterThanOrEqualTo(String value) {
            addCriterion("cim_status >=", value, "cimStatus");
            return (Criteria) this;
        }

        public Criteria andCimStatusLessThan(String value) {
            addCriterion("cim_status <", value, "cimStatus");
            return (Criteria) this;
        }

        public Criteria andCimStatusLessThanOrEqualTo(String value) {
            addCriterion("cim_status <=", value, "cimStatus");
            return (Criteria) this;
        }

        public Criteria andCimStatusLike(String value) {
            addCriterion("cim_status like", value, "cimStatus");
            return (Criteria) this;
        }

        public Criteria andCimStatusNotLike(String value) {
            addCriterion("cim_status not like", value, "cimStatus");
            return (Criteria) this;
        }

        public Criteria andCimStatusIn(List<String> values) {
            addCriterion("cim_status in", values, "cimStatus");
            return (Criteria) this;
        }

        public Criteria andCimStatusNotIn(List<String> values) {
            addCriterion("cim_status not in", values, "cimStatus");
            return (Criteria) this;
        }

        public Criteria andCimStatusBetween(String value1, String value2) {
            addCriterion("cim_status between", value1, value2, "cimStatus");
            return (Criteria) this;
        }

        public Criteria andCimStatusNotBetween(String value1, String value2) {
            addCriterion("cim_status not between", value1, value2, "cimStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusIsNull() {
            addCriterion("connect_status is null");
            return (Criteria) this;
        }

        public Criteria andConnectStatusIsNotNull() {
            addCriterion("connect_status is not null");
            return (Criteria) this;
        }

        public Criteria andConnectStatusEqualTo(String value) {
            addCriterion("connect_status =", value, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusNotEqualTo(String value) {
            addCriterion("connect_status <>", value, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusGreaterThan(String value) {
            addCriterion("connect_status >", value, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusGreaterThanOrEqualTo(String value) {
            addCriterion("connect_status >=", value, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusLessThan(String value) {
            addCriterion("connect_status <", value, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusLessThanOrEqualTo(String value) {
            addCriterion("connect_status <=", value, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusLike(String value) {
            addCriterion("connect_status like", value, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusNotLike(String value) {
            addCriterion("connect_status not like", value, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusIn(List<String> values) {
            addCriterion("connect_status in", values, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusNotIn(List<String> values) {
            addCriterion("connect_status not in", values, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusBetween(String value1, String value2) {
            addCriterion("connect_status between", value1, value2, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusNotBetween(String value1, String value2) {
            addCriterion("connect_status not between", value1, value2, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andMaintainStatusIsNull() {
            addCriterion("maintain_status is null");
            return (Criteria) this;
        }

        public Criteria andMaintainStatusIsNotNull() {
            addCriterion("maintain_status is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainStatusEqualTo(String value) {
            addCriterion("maintain_status =", value, "maintainStatus");
            return (Criteria) this;
        }

        public Criteria andMaintainStatusNotEqualTo(String value) {
            addCriterion("maintain_status <>", value, "maintainStatus");
            return (Criteria) this;
        }

        public Criteria andMaintainStatusGreaterThan(String value) {
            addCriterion("maintain_status >", value, "maintainStatus");
            return (Criteria) this;
        }

        public Criteria andMaintainStatusGreaterThanOrEqualTo(String value) {
            addCriterion("maintain_status >=", value, "maintainStatus");
            return (Criteria) this;
        }

        public Criteria andMaintainStatusLessThan(String value) {
            addCriterion("maintain_status <", value, "maintainStatus");
            return (Criteria) this;
        }

        public Criteria andMaintainStatusLessThanOrEqualTo(String value) {
            addCriterion("maintain_status <=", value, "maintainStatus");
            return (Criteria) this;
        }

        public Criteria andMaintainStatusLike(String value) {
            addCriterion("maintain_status like", value, "maintainStatus");
            return (Criteria) this;
        }

        public Criteria andMaintainStatusNotLike(String value) {
            addCriterion("maintain_status not like", value, "maintainStatus");
            return (Criteria) this;
        }

        public Criteria andMaintainStatusIn(List<String> values) {
            addCriterion("maintain_status in", values, "maintainStatus");
            return (Criteria) this;
        }

        public Criteria andMaintainStatusNotIn(List<String> values) {
            addCriterion("maintain_status not in", values, "maintainStatus");
            return (Criteria) this;
        }

        public Criteria andMaintainStatusBetween(String value1, String value2) {
            addCriterion("maintain_status between", value1, value2, "maintainStatus");
            return (Criteria) this;
        }

        public Criteria andMaintainStatusNotBetween(String value1, String value2) {
            addCriterion("maintain_status not between", value1, value2, "maintainStatus");
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