package com.tomcat360.admin.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbUserAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUserAccountExample() {
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

        public Criteria andCurrencyMoneyIsNull() {
            addCriterion("currency_money is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyMoneyIsNotNull() {
            addCriterion("currency_money is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyMoneyEqualTo(BigDecimal value) {
            addCriterion("currency_money =", value, "currencyMoney");
            return (Criteria) this;
        }

        public Criteria andCurrencyMoneyNotEqualTo(BigDecimal value) {
            addCriterion("currency_money <>", value, "currencyMoney");
            return (Criteria) this;
        }

        public Criteria andCurrencyMoneyGreaterThan(BigDecimal value) {
            addCriterion("currency_money >", value, "currencyMoney");
            return (Criteria) this;
        }

        public Criteria andCurrencyMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("currency_money >=", value, "currencyMoney");
            return (Criteria) this;
        }

        public Criteria andCurrencyMoneyLessThan(BigDecimal value) {
            addCriterion("currency_money <", value, "currencyMoney");
            return (Criteria) this;
        }

        public Criteria andCurrencyMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("currency_money <=", value, "currencyMoney");
            return (Criteria) this;
        }

        public Criteria andCurrencyMoneyIn(List<BigDecimal> values) {
            addCriterion("currency_money in", values, "currencyMoney");
            return (Criteria) this;
        }

        public Criteria andCurrencyMoneyNotIn(List<BigDecimal> values) {
            addCriterion("currency_money not in", values, "currencyMoney");
            return (Criteria) this;
        }

        public Criteria andCurrencyMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("currency_money between", value1, value2, "currencyMoney");
            return (Criteria) this;
        }

        public Criteria andCurrencyMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("currency_money not between", value1, value2, "currencyMoney");
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