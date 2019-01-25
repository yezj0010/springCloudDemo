package com.tomcat360.timer.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSettingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSettingsExample() {
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

        public Criteria andSettingsCodeIsNull() {
            addCriterion("settings_code is null");
            return (Criteria) this;
        }

        public Criteria andSettingsCodeIsNotNull() {
            addCriterion("settings_code is not null");
            return (Criteria) this;
        }

        public Criteria andSettingsCodeEqualTo(String value) {
            addCriterion("settings_code =", value, "settingsCode");
            return (Criteria) this;
        }

        public Criteria andSettingsCodeNotEqualTo(String value) {
            addCriterion("settings_code <>", value, "settingsCode");
            return (Criteria) this;
        }

        public Criteria andSettingsCodeGreaterThan(String value) {
            addCriterion("settings_code >", value, "settingsCode");
            return (Criteria) this;
        }

        public Criteria andSettingsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("settings_code >=", value, "settingsCode");
            return (Criteria) this;
        }

        public Criteria andSettingsCodeLessThan(String value) {
            addCriterion("settings_code <", value, "settingsCode");
            return (Criteria) this;
        }

        public Criteria andSettingsCodeLessThanOrEqualTo(String value) {
            addCriterion("settings_code <=", value, "settingsCode");
            return (Criteria) this;
        }

        public Criteria andSettingsCodeLike(String value) {
            addCriterion("settings_code like", value, "settingsCode");
            return (Criteria) this;
        }

        public Criteria andSettingsCodeNotLike(String value) {
            addCriterion("settings_code not like", value, "settingsCode");
            return (Criteria) this;
        }

        public Criteria andSettingsCodeIn(List<String> values) {
            addCriterion("settings_code in", values, "settingsCode");
            return (Criteria) this;
        }

        public Criteria andSettingsCodeNotIn(List<String> values) {
            addCriterion("settings_code not in", values, "settingsCode");
            return (Criteria) this;
        }

        public Criteria andSettingsCodeBetween(String value1, String value2) {
            addCriterion("settings_code between", value1, value2, "settingsCode");
            return (Criteria) this;
        }

        public Criteria andSettingsCodeNotBetween(String value1, String value2) {
            addCriterion("settings_code not between", value1, value2, "settingsCode");
            return (Criteria) this;
        }

        public Criteria andSettingsNameCnIsNull() {
            addCriterion("settings_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andSettingsNameCnIsNotNull() {
            addCriterion("settings_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andSettingsNameCnEqualTo(String value) {
            addCriterion("settings_name_cn =", value, "settingsNameCn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameCnNotEqualTo(String value) {
            addCriterion("settings_name_cn <>", value, "settingsNameCn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameCnGreaterThan(String value) {
            addCriterion("settings_name_cn >", value, "settingsNameCn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("settings_name_cn >=", value, "settingsNameCn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameCnLessThan(String value) {
            addCriterion("settings_name_cn <", value, "settingsNameCn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameCnLessThanOrEqualTo(String value) {
            addCriterion("settings_name_cn <=", value, "settingsNameCn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameCnLike(String value) {
            addCriterion("settings_name_cn like", value, "settingsNameCn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameCnNotLike(String value) {
            addCriterion("settings_name_cn not like", value, "settingsNameCn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameCnIn(List<String> values) {
            addCriterion("settings_name_cn in", values, "settingsNameCn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameCnNotIn(List<String> values) {
            addCriterion("settings_name_cn not in", values, "settingsNameCn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameCnBetween(String value1, String value2) {
            addCriterion("settings_name_cn between", value1, value2, "settingsNameCn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameCnNotBetween(String value1, String value2) {
            addCriterion("settings_name_cn not between", value1, value2, "settingsNameCn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameEnIsNull() {
            addCriterion("settings_name_en is null");
            return (Criteria) this;
        }

        public Criteria andSettingsNameEnIsNotNull() {
            addCriterion("settings_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andSettingsNameEnEqualTo(String value) {
            addCriterion("settings_name_en =", value, "settingsNameEn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameEnNotEqualTo(String value) {
            addCriterion("settings_name_en <>", value, "settingsNameEn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameEnGreaterThan(String value) {
            addCriterion("settings_name_en >", value, "settingsNameEn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("settings_name_en >=", value, "settingsNameEn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameEnLessThan(String value) {
            addCriterion("settings_name_en <", value, "settingsNameEn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameEnLessThanOrEqualTo(String value) {
            addCriterion("settings_name_en <=", value, "settingsNameEn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameEnLike(String value) {
            addCriterion("settings_name_en like", value, "settingsNameEn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameEnNotLike(String value) {
            addCriterion("settings_name_en not like", value, "settingsNameEn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameEnIn(List<String> values) {
            addCriterion("settings_name_en in", values, "settingsNameEn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameEnNotIn(List<String> values) {
            addCriterion("settings_name_en not in", values, "settingsNameEn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameEnBetween(String value1, String value2) {
            addCriterion("settings_name_en between", value1, value2, "settingsNameEn");
            return (Criteria) this;
        }

        public Criteria andSettingsNameEnNotBetween(String value1, String value2) {
            addCriterion("settings_name_en not between", value1, value2, "settingsNameEn");
            return (Criteria) this;
        }

        public Criteria andSettingsTypeIsNull() {
            addCriterion("settings_type is null");
            return (Criteria) this;
        }

        public Criteria andSettingsTypeIsNotNull() {
            addCriterion("settings_type is not null");
            return (Criteria) this;
        }

        public Criteria andSettingsTypeEqualTo(String value) {
            addCriterion("settings_type =", value, "settingsType");
            return (Criteria) this;
        }

        public Criteria andSettingsTypeNotEqualTo(String value) {
            addCriterion("settings_type <>", value, "settingsType");
            return (Criteria) this;
        }

        public Criteria andSettingsTypeGreaterThan(String value) {
            addCriterion("settings_type >", value, "settingsType");
            return (Criteria) this;
        }

        public Criteria andSettingsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("settings_type >=", value, "settingsType");
            return (Criteria) this;
        }

        public Criteria andSettingsTypeLessThan(String value) {
            addCriterion("settings_type <", value, "settingsType");
            return (Criteria) this;
        }

        public Criteria andSettingsTypeLessThanOrEqualTo(String value) {
            addCriterion("settings_type <=", value, "settingsType");
            return (Criteria) this;
        }

        public Criteria andSettingsTypeLike(String value) {
            addCriterion("settings_type like", value, "settingsType");
            return (Criteria) this;
        }

        public Criteria andSettingsTypeNotLike(String value) {
            addCriterion("settings_type not like", value, "settingsType");
            return (Criteria) this;
        }

        public Criteria andSettingsTypeIn(List<String> values) {
            addCriterion("settings_type in", values, "settingsType");
            return (Criteria) this;
        }

        public Criteria andSettingsTypeNotIn(List<String> values) {
            addCriterion("settings_type not in", values, "settingsType");
            return (Criteria) this;
        }

        public Criteria andSettingsTypeBetween(String value1, String value2) {
            addCriterion("settings_type between", value1, value2, "settingsType");
            return (Criteria) this;
        }

        public Criteria andSettingsTypeNotBetween(String value1, String value2) {
            addCriterion("settings_type not between", value1, value2, "settingsType");
            return (Criteria) this;
        }

        public Criteria andSettingsValueIsNull() {
            addCriterion("settings_value is null");
            return (Criteria) this;
        }

        public Criteria andSettingsValueIsNotNull() {
            addCriterion("settings_value is not null");
            return (Criteria) this;
        }

        public Criteria andSettingsValueEqualTo(String value) {
            addCriterion("settings_value =", value, "settingsValue");
            return (Criteria) this;
        }

        public Criteria andSettingsValueNotEqualTo(String value) {
            addCriterion("settings_value <>", value, "settingsValue");
            return (Criteria) this;
        }

        public Criteria andSettingsValueGreaterThan(String value) {
            addCriterion("settings_value >", value, "settingsValue");
            return (Criteria) this;
        }

        public Criteria andSettingsValueGreaterThanOrEqualTo(String value) {
            addCriterion("settings_value >=", value, "settingsValue");
            return (Criteria) this;
        }

        public Criteria andSettingsValueLessThan(String value) {
            addCriterion("settings_value <", value, "settingsValue");
            return (Criteria) this;
        }

        public Criteria andSettingsValueLessThanOrEqualTo(String value) {
            addCriterion("settings_value <=", value, "settingsValue");
            return (Criteria) this;
        }

        public Criteria andSettingsValueLike(String value) {
            addCriterion("settings_value like", value, "settingsValue");
            return (Criteria) this;
        }

        public Criteria andSettingsValueNotLike(String value) {
            addCriterion("settings_value not like", value, "settingsValue");
            return (Criteria) this;
        }

        public Criteria andSettingsValueIn(List<String> values) {
            addCriterion("settings_value in", values, "settingsValue");
            return (Criteria) this;
        }

        public Criteria andSettingsValueNotIn(List<String> values) {
            addCriterion("settings_value not in", values, "settingsValue");
            return (Criteria) this;
        }

        public Criteria andSettingsValueBetween(String value1, String value2) {
            addCriterion("settings_value between", value1, value2, "settingsValue");
            return (Criteria) this;
        }

        public Criteria andSettingsValueNotBetween(String value1, String value2) {
            addCriterion("settings_value not between", value1, value2, "settingsValue");
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

        public Criteria andSettingsValueTypeIsNull() {
            addCriterion("settings_value_type is null");
            return (Criteria) this;
        }

        public Criteria andSettingsValueTypeIsNotNull() {
            addCriterion("settings_value_type is not null");
            return (Criteria) this;
        }

        public Criteria andSettingsValueTypeEqualTo(String value) {
            addCriterion("settings_value_type =", value, "settingsValueType");
            return (Criteria) this;
        }

        public Criteria andSettingsValueTypeNotEqualTo(String value) {
            addCriterion("settings_value_type <>", value, "settingsValueType");
            return (Criteria) this;
        }

        public Criteria andSettingsValueTypeGreaterThan(String value) {
            addCriterion("settings_value_type >", value, "settingsValueType");
            return (Criteria) this;
        }

        public Criteria andSettingsValueTypeGreaterThanOrEqualTo(String value) {
            addCriterion("settings_value_type >=", value, "settingsValueType");
            return (Criteria) this;
        }

        public Criteria andSettingsValueTypeLessThan(String value) {
            addCriterion("settings_value_type <", value, "settingsValueType");
            return (Criteria) this;
        }

        public Criteria andSettingsValueTypeLessThanOrEqualTo(String value) {
            addCriterion("settings_value_type <=", value, "settingsValueType");
            return (Criteria) this;
        }

        public Criteria andSettingsValueTypeLike(String value) {
            addCriterion("settings_value_type like", value, "settingsValueType");
            return (Criteria) this;
        }

        public Criteria andSettingsValueTypeNotLike(String value) {
            addCriterion("settings_value_type not like", value, "settingsValueType");
            return (Criteria) this;
        }

        public Criteria andSettingsValueTypeIn(List<String> values) {
            addCriterion("settings_value_type in", values, "settingsValueType");
            return (Criteria) this;
        }

        public Criteria andSettingsValueTypeNotIn(List<String> values) {
            addCriterion("settings_value_type not in", values, "settingsValueType");
            return (Criteria) this;
        }

        public Criteria andSettingsValueTypeBetween(String value1, String value2) {
            addCriterion("settings_value_type between", value1, value2, "settingsValueType");
            return (Criteria) this;
        }

        public Criteria andSettingsValueTypeNotBetween(String value1, String value2) {
            addCriterion("settings_value_type not between", value1, value2, "settingsValueType");
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

        public Criteria andExt1IsNull() {
            addCriterion("ext1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("ext1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("ext1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("ext1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("ext1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("ext1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("ext1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("ext1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("ext1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("ext1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("ext1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("ext1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("ext1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("ext1 not between", value1, value2, "ext1");
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