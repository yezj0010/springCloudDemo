package com.tomcat360.timer.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbEquipmentStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipmentStatusExample() {
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

        public Criteria andEquipmentNoIsNull() {
            addCriterion("equipment_no is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoIsNotNull() {
            addCriterion("equipment_no is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoEqualTo(String value) {
            addCriterion("equipment_no =", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotEqualTo(String value) {
            addCriterion("equipment_no <>", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoGreaterThan(String value) {
            addCriterion("equipment_no >", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_no >=", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoLessThan(String value) {
            addCriterion("equipment_no <", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoLessThanOrEqualTo(String value) {
            addCriterion("equipment_no <=", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoLike(String value) {
            addCriterion("equipment_no like", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotLike(String value) {
            addCriterion("equipment_no not like", value, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoIn(List<String> values) {
            addCriterion("equipment_no in", values, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotIn(List<String> values) {
            addCriterion("equipment_no not in", values, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoBetween(String value1, String value2) {
            addCriterion("equipment_no between", value1, value2, "equipmentNo");
            return (Criteria) this;
        }

        public Criteria andEquipmentNoNotBetween(String value1, String value2) {
            addCriterion("equipment_no not between", value1, value2, "equipmentNo");
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