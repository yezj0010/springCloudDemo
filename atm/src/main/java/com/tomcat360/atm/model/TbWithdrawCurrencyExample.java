package com.tomcat360.atm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbWithdrawCurrencyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWithdrawCurrencyExample() {
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

        public Criteria andWithdrawMoney1IsNull() {
            addCriterion("withdraw_money1 is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney1IsNotNull() {
            addCriterion("withdraw_money1 is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney1EqualTo(Integer value) {
            addCriterion("withdraw_money1 =", value, "withdrawMoney1");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney1NotEqualTo(Integer value) {
            addCriterion("withdraw_money1 <>", value, "withdrawMoney1");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney1GreaterThan(Integer value) {
            addCriterion("withdraw_money1 >", value, "withdrawMoney1");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney1GreaterThanOrEqualTo(Integer value) {
            addCriterion("withdraw_money1 >=", value, "withdrawMoney1");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney1LessThan(Integer value) {
            addCriterion("withdraw_money1 <", value, "withdrawMoney1");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney1LessThanOrEqualTo(Integer value) {
            addCriterion("withdraw_money1 <=", value, "withdrawMoney1");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney1In(List<Integer> values) {
            addCriterion("withdraw_money1 in", values, "withdrawMoney1");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney1NotIn(List<Integer> values) {
            addCriterion("withdraw_money1 not in", values, "withdrawMoney1");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney1Between(Integer value1, Integer value2) {
            addCriterion("withdraw_money1 between", value1, value2, "withdrawMoney1");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney1NotBetween(Integer value1, Integer value2) {
            addCriterion("withdraw_money1 not between", value1, value2, "withdrawMoney1");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney2IsNull() {
            addCriterion("withdraw_money2 is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney2IsNotNull() {
            addCriterion("withdraw_money2 is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney2EqualTo(Integer value) {
            addCriterion("withdraw_money2 =", value, "withdrawMoney2");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney2NotEqualTo(Integer value) {
            addCriterion("withdraw_money2 <>", value, "withdrawMoney2");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney2GreaterThan(Integer value) {
            addCriterion("withdraw_money2 >", value, "withdrawMoney2");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney2GreaterThanOrEqualTo(Integer value) {
            addCriterion("withdraw_money2 >=", value, "withdrawMoney2");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney2LessThan(Integer value) {
            addCriterion("withdraw_money2 <", value, "withdrawMoney2");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney2LessThanOrEqualTo(Integer value) {
            addCriterion("withdraw_money2 <=", value, "withdrawMoney2");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney2In(List<Integer> values) {
            addCriterion("withdraw_money2 in", values, "withdrawMoney2");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney2NotIn(List<Integer> values) {
            addCriterion("withdraw_money2 not in", values, "withdrawMoney2");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney2Between(Integer value1, Integer value2) {
            addCriterion("withdraw_money2 between", value1, value2, "withdrawMoney2");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney2NotBetween(Integer value1, Integer value2) {
            addCriterion("withdraw_money2 not between", value1, value2, "withdrawMoney2");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney3IsNull() {
            addCriterion("withdraw_money3 is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney3IsNotNull() {
            addCriterion("withdraw_money3 is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney3EqualTo(Integer value) {
            addCriterion("withdraw_money3 =", value, "withdrawMoney3");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney3NotEqualTo(Integer value) {
            addCriterion("withdraw_money3 <>", value, "withdrawMoney3");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney3GreaterThan(Integer value) {
            addCriterion("withdraw_money3 >", value, "withdrawMoney3");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney3GreaterThanOrEqualTo(Integer value) {
            addCriterion("withdraw_money3 >=", value, "withdrawMoney3");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney3LessThan(Integer value) {
            addCriterion("withdraw_money3 <", value, "withdrawMoney3");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney3LessThanOrEqualTo(Integer value) {
            addCriterion("withdraw_money3 <=", value, "withdrawMoney3");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney3In(List<Integer> values) {
            addCriterion("withdraw_money3 in", values, "withdrawMoney3");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney3NotIn(List<Integer> values) {
            addCriterion("withdraw_money3 not in", values, "withdrawMoney3");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney3Between(Integer value1, Integer value2) {
            addCriterion("withdraw_money3 between", value1, value2, "withdrawMoney3");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney3NotBetween(Integer value1, Integer value2) {
            addCriterion("withdraw_money3 not between", value1, value2, "withdrawMoney3");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney4IsNull() {
            addCriterion("withdraw_money4 is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney4IsNotNull() {
            addCriterion("withdraw_money4 is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney4EqualTo(Integer value) {
            addCriterion("withdraw_money4 =", value, "withdrawMoney4");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney4NotEqualTo(Integer value) {
            addCriterion("withdraw_money4 <>", value, "withdrawMoney4");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney4GreaterThan(Integer value) {
            addCriterion("withdraw_money4 >", value, "withdrawMoney4");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney4GreaterThanOrEqualTo(Integer value) {
            addCriterion("withdraw_money4 >=", value, "withdrawMoney4");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney4LessThan(Integer value) {
            addCriterion("withdraw_money4 <", value, "withdrawMoney4");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney4LessThanOrEqualTo(Integer value) {
            addCriterion("withdraw_money4 <=", value, "withdrawMoney4");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney4In(List<Integer> values) {
            addCriterion("withdraw_money4 in", values, "withdrawMoney4");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney4NotIn(List<Integer> values) {
            addCriterion("withdraw_money4 not in", values, "withdrawMoney4");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney4Between(Integer value1, Integer value2) {
            addCriterion("withdraw_money4 between", value1, value2, "withdrawMoney4");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney4NotBetween(Integer value1, Integer value2) {
            addCriterion("withdraw_money4 not between", value1, value2, "withdrawMoney4");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney5IsNull() {
            addCriterion("withdraw_money5 is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney5IsNotNull() {
            addCriterion("withdraw_money5 is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney5EqualTo(Integer value) {
            addCriterion("withdraw_money5 =", value, "withdrawMoney5");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney5NotEqualTo(Integer value) {
            addCriterion("withdraw_money5 <>", value, "withdrawMoney5");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney5GreaterThan(Integer value) {
            addCriterion("withdraw_money5 >", value, "withdrawMoney5");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney5GreaterThanOrEqualTo(Integer value) {
            addCriterion("withdraw_money5 >=", value, "withdrawMoney5");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney5LessThan(Integer value) {
            addCriterion("withdraw_money5 <", value, "withdrawMoney5");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney5LessThanOrEqualTo(Integer value) {
            addCriterion("withdraw_money5 <=", value, "withdrawMoney5");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney5In(List<Integer> values) {
            addCriterion("withdraw_money5 in", values, "withdrawMoney5");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney5NotIn(List<Integer> values) {
            addCriterion("withdraw_money5 not in", values, "withdrawMoney5");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney5Between(Integer value1, Integer value2) {
            addCriterion("withdraw_money5 between", value1, value2, "withdrawMoney5");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney5NotBetween(Integer value1, Integer value2) {
            addCriterion("withdraw_money5 not between", value1, value2, "withdrawMoney5");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney6IsNull() {
            addCriterion("withdraw_money6 is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney6IsNotNull() {
            addCriterion("withdraw_money6 is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney6EqualTo(Integer value) {
            addCriterion("withdraw_money6 =", value, "withdrawMoney6");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney6NotEqualTo(Integer value) {
            addCriterion("withdraw_money6 <>", value, "withdrawMoney6");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney6GreaterThan(Integer value) {
            addCriterion("withdraw_money6 >", value, "withdrawMoney6");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney6GreaterThanOrEqualTo(Integer value) {
            addCriterion("withdraw_money6 >=", value, "withdrawMoney6");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney6LessThan(Integer value) {
            addCriterion("withdraw_money6 <", value, "withdrawMoney6");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney6LessThanOrEqualTo(Integer value) {
            addCriterion("withdraw_money6 <=", value, "withdrawMoney6");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney6In(List<Integer> values) {
            addCriterion("withdraw_money6 in", values, "withdrawMoney6");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney6NotIn(List<Integer> values) {
            addCriterion("withdraw_money6 not in", values, "withdrawMoney6");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney6Between(Integer value1, Integer value2) {
            addCriterion("withdraw_money6 between", value1, value2, "withdrawMoney6");
            return (Criteria) this;
        }

        public Criteria andWithdrawMoney6NotBetween(Integer value1, Integer value2) {
            addCriterion("withdraw_money6 not between", value1, value2, "withdrawMoney6");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameIsNull() {
            addCriterion("currency_name is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameIsNotNull() {
            addCriterion("currency_name is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameEqualTo(String value) {
            addCriterion("currency_name =", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameNotEqualTo(String value) {
            addCriterion("currency_name <>", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameGreaterThan(String value) {
            addCriterion("currency_name >", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameGreaterThanOrEqualTo(String value) {
            addCriterion("currency_name >=", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameLessThan(String value) {
            addCriterion("currency_name <", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameLessThanOrEqualTo(String value) {
            addCriterion("currency_name <=", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameLike(String value) {
            addCriterion("currency_name like", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameNotLike(String value) {
            addCriterion("currency_name not like", value, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameIn(List<String> values) {
            addCriterion("currency_name in", values, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameNotIn(List<String> values) {
            addCriterion("currency_name not in", values, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameBetween(String value1, String value2) {
            addCriterion("currency_name between", value1, value2, "currencyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyNameNotBetween(String value1, String value2) {
            addCriterion("currency_name not between", value1, value2, "currencyName");
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

        public Criteria andDescCnyIsNull() {
            addCriterion("desc_cny is null");
            return (Criteria) this;
        }

        public Criteria andDescCnyIsNotNull() {
            addCriterion("desc_cny is not null");
            return (Criteria) this;
        }

        public Criteria andDescCnyEqualTo(String value) {
            addCriterion("desc_cny =", value, "descCny");
            return (Criteria) this;
        }

        public Criteria andDescCnyNotEqualTo(String value) {
            addCriterion("desc_cny <>", value, "descCny");
            return (Criteria) this;
        }

        public Criteria andDescCnyGreaterThan(String value) {
            addCriterion("desc_cny >", value, "descCny");
            return (Criteria) this;
        }

        public Criteria andDescCnyGreaterThanOrEqualTo(String value) {
            addCriterion("desc_cny >=", value, "descCny");
            return (Criteria) this;
        }

        public Criteria andDescCnyLessThan(String value) {
            addCriterion("desc_cny <", value, "descCny");
            return (Criteria) this;
        }

        public Criteria andDescCnyLessThanOrEqualTo(String value) {
            addCriterion("desc_cny <=", value, "descCny");
            return (Criteria) this;
        }

        public Criteria andDescCnyLike(String value) {
            addCriterion("desc_cny like", value, "descCny");
            return (Criteria) this;
        }

        public Criteria andDescCnyNotLike(String value) {
            addCriterion("desc_cny not like", value, "descCny");
            return (Criteria) this;
        }

        public Criteria andDescCnyIn(List<String> values) {
            addCriterion("desc_cny in", values, "descCny");
            return (Criteria) this;
        }

        public Criteria andDescCnyNotIn(List<String> values) {
            addCriterion("desc_cny not in", values, "descCny");
            return (Criteria) this;
        }

        public Criteria andDescCnyBetween(String value1, String value2) {
            addCriterion("desc_cny between", value1, value2, "descCny");
            return (Criteria) this;
        }

        public Criteria andDescCnyNotBetween(String value1, String value2) {
            addCriterion("desc_cny not between", value1, value2, "descCny");
            return (Criteria) this;
        }

        public Criteria andDescEnIsNull() {
            addCriterion("desc_en is null");
            return (Criteria) this;
        }

        public Criteria andDescEnIsNotNull() {
            addCriterion("desc_en is not null");
            return (Criteria) this;
        }

        public Criteria andDescEnEqualTo(String value) {
            addCriterion("desc_en =", value, "descEn");
            return (Criteria) this;
        }

        public Criteria andDescEnNotEqualTo(String value) {
            addCriterion("desc_en <>", value, "descEn");
            return (Criteria) this;
        }

        public Criteria andDescEnGreaterThan(String value) {
            addCriterion("desc_en >", value, "descEn");
            return (Criteria) this;
        }

        public Criteria andDescEnGreaterThanOrEqualTo(String value) {
            addCriterion("desc_en >=", value, "descEn");
            return (Criteria) this;
        }

        public Criteria andDescEnLessThan(String value) {
            addCriterion("desc_en <", value, "descEn");
            return (Criteria) this;
        }

        public Criteria andDescEnLessThanOrEqualTo(String value) {
            addCriterion("desc_en <=", value, "descEn");
            return (Criteria) this;
        }

        public Criteria andDescEnLike(String value) {
            addCriterion("desc_en like", value, "descEn");
            return (Criteria) this;
        }

        public Criteria andDescEnNotLike(String value) {
            addCriterion("desc_en not like", value, "descEn");
            return (Criteria) this;
        }

        public Criteria andDescEnIn(List<String> values) {
            addCriterion("desc_en in", values, "descEn");
            return (Criteria) this;
        }

        public Criteria andDescEnNotIn(List<String> values) {
            addCriterion("desc_en not in", values, "descEn");
            return (Criteria) this;
        }

        public Criteria andDescEnBetween(String value1, String value2) {
            addCriterion("desc_en between", value1, value2, "descEn");
            return (Criteria) this;
        }

        public Criteria andDescEnNotBetween(String value1, String value2) {
            addCriterion("desc_en not between", value1, value2, "descEn");
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