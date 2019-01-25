package com.tomcat360.admin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbAllCurrencyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAllCurrencyExample() {
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

        public Criteria andAllCurrencyCnIsNull() {
            addCriterion("all_currency_cn is null");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyCnIsNotNull() {
            addCriterion("all_currency_cn is not null");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyCnEqualTo(String value) {
            addCriterion("all_currency_cn =", value, "allCurrencyCn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyCnNotEqualTo(String value) {
            addCriterion("all_currency_cn <>", value, "allCurrencyCn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyCnGreaterThan(String value) {
            addCriterion("all_currency_cn >", value, "allCurrencyCn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyCnGreaterThanOrEqualTo(String value) {
            addCriterion("all_currency_cn >=", value, "allCurrencyCn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyCnLessThan(String value) {
            addCriterion("all_currency_cn <", value, "allCurrencyCn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyCnLessThanOrEqualTo(String value) {
            addCriterion("all_currency_cn <=", value, "allCurrencyCn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyCnLike(String value) {
            addCriterion("all_currency_cn like", value, "allCurrencyCn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyCnNotLike(String value) {
            addCriterion("all_currency_cn not like", value, "allCurrencyCn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyCnIn(List<String> values) {
            addCriterion("all_currency_cn in", values, "allCurrencyCn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyCnNotIn(List<String> values) {
            addCriterion("all_currency_cn not in", values, "allCurrencyCn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyCnBetween(String value1, String value2) {
            addCriterion("all_currency_cn between", value1, value2, "allCurrencyCn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyCnNotBetween(String value1, String value2) {
            addCriterion("all_currency_cn not between", value1, value2, "allCurrencyCn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyEnIsNull() {
            addCriterion("all_currency_en is null");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyEnIsNotNull() {
            addCriterion("all_currency_en is not null");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyEnEqualTo(String value) {
            addCriterion("all_currency_en =", value, "allCurrencyEn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyEnNotEqualTo(String value) {
            addCriterion("all_currency_en <>", value, "allCurrencyEn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyEnGreaterThan(String value) {
            addCriterion("all_currency_en >", value, "allCurrencyEn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyEnGreaterThanOrEqualTo(String value) {
            addCriterion("all_currency_en >=", value, "allCurrencyEn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyEnLessThan(String value) {
            addCriterion("all_currency_en <", value, "allCurrencyEn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyEnLessThanOrEqualTo(String value) {
            addCriterion("all_currency_en <=", value, "allCurrencyEn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyEnLike(String value) {
            addCriterion("all_currency_en like", value, "allCurrencyEn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyEnNotLike(String value) {
            addCriterion("all_currency_en not like", value, "allCurrencyEn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyEnIn(List<String> values) {
            addCriterion("all_currency_en in", values, "allCurrencyEn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyEnNotIn(List<String> values) {
            addCriterion("all_currency_en not in", values, "allCurrencyEn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyEnBetween(String value1, String value2) {
            addCriterion("all_currency_en between", value1, value2, "allCurrencyEn");
            return (Criteria) this;
        }

        public Criteria andAllCurrencyEnNotBetween(String value1, String value2) {
            addCriterion("all_currency_en not between", value1, value2, "allCurrencyEn");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIsNull() {
            addCriterion("currency_code is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIsNotNull() {
            addCriterion("currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeEqualTo(String value) {
            addCriterion("currency_code =", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotEqualTo(String value) {
            addCriterion("currency_code <>", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeGreaterThan(String value) {
            addCriterion("currency_code >", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("currency_code >=", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLessThan(String value) {
            addCriterion("currency_code <", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("currency_code <=", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLike(String value) {
            addCriterion("currency_code like", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotLike(String value) {
            addCriterion("currency_code not like", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIn(List<String> values) {
            addCriterion("currency_code in", values, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotIn(List<String> values) {
            addCriterion("currency_code not in", values, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeBetween(String value1, String value2) {
            addCriterion("currency_code between", value1, value2, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("currency_code not between", value1, value2, "currencyCode");
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