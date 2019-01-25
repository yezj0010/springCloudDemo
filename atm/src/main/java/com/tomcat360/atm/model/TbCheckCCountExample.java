package com.tomcat360.atm.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbCheckCCountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbCheckCCountExample() {
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

        public Criteria andSuccessNumIsNull() {
            addCriterion("success_num is null");
            return (Criteria) this;
        }

        public Criteria andSuccessNumIsNotNull() {
            addCriterion("success_num is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessNumEqualTo(Integer value) {
            addCriterion("success_num =", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumNotEqualTo(Integer value) {
            addCriterion("success_num <>", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumGreaterThan(Integer value) {
            addCriterion("success_num >", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("success_num >=", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumLessThan(Integer value) {
            addCriterion("success_num <", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumLessThanOrEqualTo(Integer value) {
            addCriterion("success_num <=", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumIn(List<Integer> values) {
            addCriterion("success_num in", values, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumNotIn(List<Integer> values) {
            addCriterion("success_num not in", values, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumBetween(Integer value1, Integer value2) {
            addCriterion("success_num between", value1, value2, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumNotBetween(Integer value1, Integer value2) {
            addCriterion("success_num not between", value1, value2, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessAmtIsNull() {
            addCriterion("success_amt is null");
            return (Criteria) this;
        }

        public Criteria andSuccessAmtIsNotNull() {
            addCriterion("success_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessAmtEqualTo(BigDecimal value) {
            addCriterion("success_amt =", value, "successAmt");
            return (Criteria) this;
        }

        public Criteria andSuccessAmtNotEqualTo(BigDecimal value) {
            addCriterion("success_amt <>", value, "successAmt");
            return (Criteria) this;
        }

        public Criteria andSuccessAmtGreaterThan(BigDecimal value) {
            addCriterion("success_amt >", value, "successAmt");
            return (Criteria) this;
        }

        public Criteria andSuccessAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("success_amt >=", value, "successAmt");
            return (Criteria) this;
        }

        public Criteria andSuccessAmtLessThan(BigDecimal value) {
            addCriterion("success_amt <", value, "successAmt");
            return (Criteria) this;
        }

        public Criteria andSuccessAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("success_amt <=", value, "successAmt");
            return (Criteria) this;
        }

        public Criteria andSuccessAmtIn(List<BigDecimal> values) {
            addCriterion("success_amt in", values, "successAmt");
            return (Criteria) this;
        }

        public Criteria andSuccessAmtNotIn(List<BigDecimal> values) {
            addCriterion("success_amt not in", values, "successAmt");
            return (Criteria) this;
        }

        public Criteria andSuccessAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("success_amt between", value1, value2, "successAmt");
            return (Criteria) this;
        }

        public Criteria andSuccessAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("success_amt not between", value1, value2, "successAmt");
            return (Criteria) this;
        }

        public Criteria andErrNumIsNull() {
            addCriterion("err_num is null");
            return (Criteria) this;
        }

        public Criteria andErrNumIsNotNull() {
            addCriterion("err_num is not null");
            return (Criteria) this;
        }

        public Criteria andErrNumEqualTo(Integer value) {
            addCriterion("err_num =", value, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumNotEqualTo(Integer value) {
            addCriterion("err_num <>", value, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumGreaterThan(Integer value) {
            addCriterion("err_num >", value, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("err_num >=", value, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumLessThan(Integer value) {
            addCriterion("err_num <", value, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumLessThanOrEqualTo(Integer value) {
            addCriterion("err_num <=", value, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumIn(List<Integer> values) {
            addCriterion("err_num in", values, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumNotIn(List<Integer> values) {
            addCriterion("err_num not in", values, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumBetween(Integer value1, Integer value2) {
            addCriterion("err_num between", value1, value2, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrNumNotBetween(Integer value1, Integer value2) {
            addCriterion("err_num not between", value1, value2, "errNum");
            return (Criteria) this;
        }

        public Criteria andErrAmtIsNull() {
            addCriterion("err_amt is null");
            return (Criteria) this;
        }

        public Criteria andErrAmtIsNotNull() {
            addCriterion("err_amt is not null");
            return (Criteria) this;
        }

        public Criteria andErrAmtEqualTo(BigDecimal value) {
            addCriterion("err_amt =", value, "errAmt");
            return (Criteria) this;
        }

        public Criteria andErrAmtNotEqualTo(BigDecimal value) {
            addCriterion("err_amt <>", value, "errAmt");
            return (Criteria) this;
        }

        public Criteria andErrAmtGreaterThan(BigDecimal value) {
            addCriterion("err_amt >", value, "errAmt");
            return (Criteria) this;
        }

        public Criteria andErrAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("err_amt >=", value, "errAmt");
            return (Criteria) this;
        }

        public Criteria andErrAmtLessThan(BigDecimal value) {
            addCriterion("err_amt <", value, "errAmt");
            return (Criteria) this;
        }

        public Criteria andErrAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("err_amt <=", value, "errAmt");
            return (Criteria) this;
        }

        public Criteria andErrAmtIn(List<BigDecimal> values) {
            addCriterion("err_amt in", values, "errAmt");
            return (Criteria) this;
        }

        public Criteria andErrAmtNotIn(List<BigDecimal> values) {
            addCriterion("err_amt not in", values, "errAmt");
            return (Criteria) this;
        }

        public Criteria andErrAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("err_amt between", value1, value2, "errAmt");
            return (Criteria) this;
        }

        public Criteria andErrAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("err_amt not between", value1, value2, "errAmt");
            return (Criteria) this;
        }

        public Criteria andCorrectNumIsNull() {
            addCriterion("correct_num is null");
            return (Criteria) this;
        }

        public Criteria andCorrectNumIsNotNull() {
            addCriterion("correct_num is not null");
            return (Criteria) this;
        }

        public Criteria andCorrectNumEqualTo(Integer value) {
            addCriterion("correct_num =", value, "correctNum");
            return (Criteria) this;
        }

        public Criteria andCorrectNumNotEqualTo(Integer value) {
            addCriterion("correct_num <>", value, "correctNum");
            return (Criteria) this;
        }

        public Criteria andCorrectNumGreaterThan(Integer value) {
            addCriterion("correct_num >", value, "correctNum");
            return (Criteria) this;
        }

        public Criteria andCorrectNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("correct_num >=", value, "correctNum");
            return (Criteria) this;
        }

        public Criteria andCorrectNumLessThan(Integer value) {
            addCriterion("correct_num <", value, "correctNum");
            return (Criteria) this;
        }

        public Criteria andCorrectNumLessThanOrEqualTo(Integer value) {
            addCriterion("correct_num <=", value, "correctNum");
            return (Criteria) this;
        }

        public Criteria andCorrectNumIn(List<Integer> values) {
            addCriterion("correct_num in", values, "correctNum");
            return (Criteria) this;
        }

        public Criteria andCorrectNumNotIn(List<Integer> values) {
            addCriterion("correct_num not in", values, "correctNum");
            return (Criteria) this;
        }

        public Criteria andCorrectNumBetween(Integer value1, Integer value2) {
            addCriterion("correct_num between", value1, value2, "correctNum");
            return (Criteria) this;
        }

        public Criteria andCorrectNumNotBetween(Integer value1, Integer value2) {
            addCriterion("correct_num not between", value1, value2, "correctNum");
            return (Criteria) this;
        }

        public Criteria andCorrectAmtIsNull() {
            addCriterion("correct_amt is null");
            return (Criteria) this;
        }

        public Criteria andCorrectAmtIsNotNull() {
            addCriterion("correct_amt is not null");
            return (Criteria) this;
        }

        public Criteria andCorrectAmtEqualTo(BigDecimal value) {
            addCriterion("correct_amt =", value, "correctAmt");
            return (Criteria) this;
        }

        public Criteria andCorrectAmtNotEqualTo(BigDecimal value) {
            addCriterion("correct_amt <>", value, "correctAmt");
            return (Criteria) this;
        }

        public Criteria andCorrectAmtGreaterThan(BigDecimal value) {
            addCriterion("correct_amt >", value, "correctAmt");
            return (Criteria) this;
        }

        public Criteria andCorrectAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("correct_amt >=", value, "correctAmt");
            return (Criteria) this;
        }

        public Criteria andCorrectAmtLessThan(BigDecimal value) {
            addCriterion("correct_amt <", value, "correctAmt");
            return (Criteria) this;
        }

        public Criteria andCorrectAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("correct_amt <=", value, "correctAmt");
            return (Criteria) this;
        }

        public Criteria andCorrectAmtIn(List<BigDecimal> values) {
            addCriterion("correct_amt in", values, "correctAmt");
            return (Criteria) this;
        }

        public Criteria andCorrectAmtNotIn(List<BigDecimal> values) {
            addCriterion("correct_amt not in", values, "correctAmt");
            return (Criteria) this;
        }

        public Criteria andCorrectAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("correct_amt between", value1, value2, "correctAmt");
            return (Criteria) this;
        }

        public Criteria andCorrectAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("correct_amt not between", value1, value2, "correctAmt");
            return (Criteria) this;
        }

        public Criteria andUnknownNumIsNull() {
            addCriterion("unknown_num is null");
            return (Criteria) this;
        }

        public Criteria andUnknownNumIsNotNull() {
            addCriterion("unknown_num is not null");
            return (Criteria) this;
        }

        public Criteria andUnknownNumEqualTo(Integer value) {
            addCriterion("unknown_num =", value, "unknownNum");
            return (Criteria) this;
        }

        public Criteria andUnknownNumNotEqualTo(Integer value) {
            addCriterion("unknown_num <>", value, "unknownNum");
            return (Criteria) this;
        }

        public Criteria andUnknownNumGreaterThan(Integer value) {
            addCriterion("unknown_num >", value, "unknownNum");
            return (Criteria) this;
        }

        public Criteria andUnknownNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("unknown_num >=", value, "unknownNum");
            return (Criteria) this;
        }

        public Criteria andUnknownNumLessThan(Integer value) {
            addCriterion("unknown_num <", value, "unknownNum");
            return (Criteria) this;
        }

        public Criteria andUnknownNumLessThanOrEqualTo(Integer value) {
            addCriterion("unknown_num <=", value, "unknownNum");
            return (Criteria) this;
        }

        public Criteria andUnknownNumIn(List<Integer> values) {
            addCriterion("unknown_num in", values, "unknownNum");
            return (Criteria) this;
        }

        public Criteria andUnknownNumNotIn(List<Integer> values) {
            addCriterion("unknown_num not in", values, "unknownNum");
            return (Criteria) this;
        }

        public Criteria andUnknownNumBetween(Integer value1, Integer value2) {
            addCriterion("unknown_num between", value1, value2, "unknownNum");
            return (Criteria) this;
        }

        public Criteria andUnknownNumNotBetween(Integer value1, Integer value2) {
            addCriterion("unknown_num not between", value1, value2, "unknownNum");
            return (Criteria) this;
        }

        public Criteria andUnknownAmtIsNull() {
            addCriterion("unknown_amt is null");
            return (Criteria) this;
        }

        public Criteria andUnknownAmtIsNotNull() {
            addCriterion("unknown_amt is not null");
            return (Criteria) this;
        }

        public Criteria andUnknownAmtEqualTo(BigDecimal value) {
            addCriterion("unknown_amt =", value, "unknownAmt");
            return (Criteria) this;
        }

        public Criteria andUnknownAmtNotEqualTo(BigDecimal value) {
            addCriterion("unknown_amt <>", value, "unknownAmt");
            return (Criteria) this;
        }

        public Criteria andUnknownAmtGreaterThan(BigDecimal value) {
            addCriterion("unknown_amt >", value, "unknownAmt");
            return (Criteria) this;
        }

        public Criteria andUnknownAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unknown_amt >=", value, "unknownAmt");
            return (Criteria) this;
        }

        public Criteria andUnknownAmtLessThan(BigDecimal value) {
            addCriterion("unknown_amt <", value, "unknownAmt");
            return (Criteria) this;
        }

        public Criteria andUnknownAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unknown_amt <=", value, "unknownAmt");
            return (Criteria) this;
        }

        public Criteria andUnknownAmtIn(List<BigDecimal> values) {
            addCriterion("unknown_amt in", values, "unknownAmt");
            return (Criteria) this;
        }

        public Criteria andUnknownAmtNotIn(List<BigDecimal> values) {
            addCriterion("unknown_amt not in", values, "unknownAmt");
            return (Criteria) this;
        }

        public Criteria andUnknownAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unknown_amt between", value1, value2, "unknownAmt");
            return (Criteria) this;
        }

        public Criteria andUnknownAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unknown_amt not between", value1, value2, "unknownAmt");
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