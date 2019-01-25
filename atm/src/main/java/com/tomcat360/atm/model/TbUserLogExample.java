package com.tomcat360.atm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbUserLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUserLogExample() {
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

        public Criteria andOperateInterfaceIsNull() {
            addCriterion("operate_interface is null");
            return (Criteria) this;
        }

        public Criteria andOperateInterfaceIsNotNull() {
            addCriterion("operate_interface is not null");
            return (Criteria) this;
        }

        public Criteria andOperateInterfaceEqualTo(String value) {
            addCriterion("operate_interface =", value, "operateInterface");
            return (Criteria) this;
        }

        public Criteria andOperateInterfaceNotEqualTo(String value) {
            addCriterion("operate_interface <>", value, "operateInterface");
            return (Criteria) this;
        }

        public Criteria andOperateInterfaceGreaterThan(String value) {
            addCriterion("operate_interface >", value, "operateInterface");
            return (Criteria) this;
        }

        public Criteria andOperateInterfaceGreaterThanOrEqualTo(String value) {
            addCriterion("operate_interface >=", value, "operateInterface");
            return (Criteria) this;
        }

        public Criteria andOperateInterfaceLessThan(String value) {
            addCriterion("operate_interface <", value, "operateInterface");
            return (Criteria) this;
        }

        public Criteria andOperateInterfaceLessThanOrEqualTo(String value) {
            addCriterion("operate_interface <=", value, "operateInterface");
            return (Criteria) this;
        }

        public Criteria andOperateInterfaceLike(String value) {
            addCriterion("operate_interface like", value, "operateInterface");
            return (Criteria) this;
        }

        public Criteria andOperateInterfaceNotLike(String value) {
            addCriterion("operate_interface not like", value, "operateInterface");
            return (Criteria) this;
        }

        public Criteria andOperateInterfaceIn(List<String> values) {
            addCriterion("operate_interface in", values, "operateInterface");
            return (Criteria) this;
        }

        public Criteria andOperateInterfaceNotIn(List<String> values) {
            addCriterion("operate_interface not in", values, "operateInterface");
            return (Criteria) this;
        }

        public Criteria andOperateInterfaceBetween(String value1, String value2) {
            addCriterion("operate_interface between", value1, value2, "operateInterface");
            return (Criteria) this;
        }

        public Criteria andOperateInterfaceNotBetween(String value1, String value2) {
            addCriterion("operate_interface not between", value1, value2, "operateInterface");
            return (Criteria) this;
        }

        public Criteria andOperateDescIsNull() {
            addCriterion("operate_desc is null");
            return (Criteria) this;
        }

        public Criteria andOperateDescIsNotNull() {
            addCriterion("operate_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOperateDescEqualTo(String value) {
            addCriterion("operate_desc =", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescNotEqualTo(String value) {
            addCriterion("operate_desc <>", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescGreaterThan(String value) {
            addCriterion("operate_desc >", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescGreaterThanOrEqualTo(String value) {
            addCriterion("operate_desc >=", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescLessThan(String value) {
            addCriterion("operate_desc <", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescLessThanOrEqualTo(String value) {
            addCriterion("operate_desc <=", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescLike(String value) {
            addCriterion("operate_desc like", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescNotLike(String value) {
            addCriterion("operate_desc not like", value, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescIn(List<String> values) {
            addCriterion("operate_desc in", values, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescNotIn(List<String> values) {
            addCriterion("operate_desc not in", values, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescBetween(String value1, String value2) {
            addCriterion("operate_desc between", value1, value2, "operateDesc");
            return (Criteria) this;
        }

        public Criteria andOperateDescNotBetween(String value1, String value2) {
            addCriterion("operate_desc not between", value1, value2, "operateDesc");
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