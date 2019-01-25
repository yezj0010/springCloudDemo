package com.tomcat360.admin.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbMerchantAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbMerchantAccountExample() {
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

        public Criteria andMerchantNoIsNull() {
            addCriterion("merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNotNull() {
            addCriterion("merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoEqualTo(String value) {
            addCriterion("merchant_no =", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotEqualTo(String value) {
            addCriterion("merchant_no <>", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThan(String value) {
            addCriterion("merchant_no >", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_no >=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThan(String value) {
            addCriterion("merchant_no <", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("merchant_no <=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLike(String value) {
            addCriterion("merchant_no like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotLike(String value) {
            addCriterion("merchant_no not like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIn(List<String> values) {
            addCriterion("merchant_no in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotIn(List<String> values) {
            addCriterion("merchant_no not in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoBetween(String value1, String value2) {
            addCriterion("merchant_no between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotBetween(String value1, String value2) {
            addCriterion("merchant_no not between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andAccountAdressIsNull() {
            addCriterion("account_adress is null");
            return (Criteria) this;
        }

        public Criteria andAccountAdressIsNotNull() {
            addCriterion("account_adress is not null");
            return (Criteria) this;
        }

        public Criteria andAccountAdressEqualTo(String value) {
            addCriterion("account_adress =", value, "accountAdress");
            return (Criteria) this;
        }

        public Criteria andAccountAdressNotEqualTo(String value) {
            addCriterion("account_adress <>", value, "accountAdress");
            return (Criteria) this;
        }

        public Criteria andAccountAdressGreaterThan(String value) {
            addCriterion("account_adress >", value, "accountAdress");
            return (Criteria) this;
        }

        public Criteria andAccountAdressGreaterThanOrEqualTo(String value) {
            addCriterion("account_adress >=", value, "accountAdress");
            return (Criteria) this;
        }

        public Criteria andAccountAdressLessThan(String value) {
            addCriterion("account_adress <", value, "accountAdress");
            return (Criteria) this;
        }

        public Criteria andAccountAdressLessThanOrEqualTo(String value) {
            addCriterion("account_adress <=", value, "accountAdress");
            return (Criteria) this;
        }

        public Criteria andAccountAdressLike(String value) {
            addCriterion("account_adress like", value, "accountAdress");
            return (Criteria) this;
        }

        public Criteria andAccountAdressNotLike(String value) {
            addCriterion("account_adress not like", value, "accountAdress");
            return (Criteria) this;
        }

        public Criteria andAccountAdressIn(List<String> values) {
            addCriterion("account_adress in", values, "accountAdress");
            return (Criteria) this;
        }

        public Criteria andAccountAdressNotIn(List<String> values) {
            addCriterion("account_adress not in", values, "accountAdress");
            return (Criteria) this;
        }

        public Criteria andAccountAdressBetween(String value1, String value2) {
            addCriterion("account_adress between", value1, value2, "accountAdress");
            return (Criteria) this;
        }

        public Criteria andAccountAdressNotBetween(String value1, String value2) {
            addCriterion("account_adress not between", value1, value2, "accountAdress");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalIsNull() {
            addCriterion("total_withdrawal is null");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalIsNotNull() {
            addCriterion("total_withdrawal is not null");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalEqualTo(BigDecimal value) {
            addCriterion("total_withdrawal =", value, "totalWithdrawal");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalNotEqualTo(BigDecimal value) {
            addCriterion("total_withdrawal <>", value, "totalWithdrawal");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalGreaterThan(BigDecimal value) {
            addCriterion("total_withdrawal >", value, "totalWithdrawal");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_withdrawal >=", value, "totalWithdrawal");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalLessThan(BigDecimal value) {
            addCriterion("total_withdrawal <", value, "totalWithdrawal");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_withdrawal <=", value, "totalWithdrawal");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalIn(List<BigDecimal> values) {
            addCriterion("total_withdrawal in", values, "totalWithdrawal");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalNotIn(List<BigDecimal> values) {
            addCriterion("total_withdrawal not in", values, "totalWithdrawal");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_withdrawal between", value1, value2, "totalWithdrawal");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_withdrawal not between", value1, value2, "totalWithdrawal");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalFeeIsNull() {
            addCriterion("total_withdrawal_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalFeeIsNotNull() {
            addCriterion("total_withdrawal_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalFeeEqualTo(BigDecimal value) {
            addCriterion("total_withdrawal_fee =", value, "totalWithdrawalFee");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalFeeNotEqualTo(BigDecimal value) {
            addCriterion("total_withdrawal_fee <>", value, "totalWithdrawalFee");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalFeeGreaterThan(BigDecimal value) {
            addCriterion("total_withdrawal_fee >", value, "totalWithdrawalFee");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_withdrawal_fee >=", value, "totalWithdrawalFee");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalFeeLessThan(BigDecimal value) {
            addCriterion("total_withdrawal_fee <", value, "totalWithdrawalFee");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_withdrawal_fee <=", value, "totalWithdrawalFee");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalFeeIn(List<BigDecimal> values) {
            addCriterion("total_withdrawal_fee in", values, "totalWithdrawalFee");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalFeeNotIn(List<BigDecimal> values) {
            addCriterion("total_withdrawal_fee not in", values, "totalWithdrawalFee");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_withdrawal_fee between", value1, value2, "totalWithdrawalFee");
            return (Criteria) this;
        }

        public Criteria andTotalWithdrawalFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_withdrawal_fee not between", value1, value2, "totalWithdrawalFee");
            return (Criteria) this;
        }

        public Criteria andTotalDepositIsNull() {
            addCriterion("total_deposit is null");
            return (Criteria) this;
        }

        public Criteria andTotalDepositIsNotNull() {
            addCriterion("total_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDepositEqualTo(BigDecimal value) {
            addCriterion("total_deposit =", value, "totalDeposit");
            return (Criteria) this;
        }

        public Criteria andTotalDepositNotEqualTo(BigDecimal value) {
            addCriterion("total_deposit <>", value, "totalDeposit");
            return (Criteria) this;
        }

        public Criteria andTotalDepositGreaterThan(BigDecimal value) {
            addCriterion("total_deposit >", value, "totalDeposit");
            return (Criteria) this;
        }

        public Criteria andTotalDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_deposit >=", value, "totalDeposit");
            return (Criteria) this;
        }

        public Criteria andTotalDepositLessThan(BigDecimal value) {
            addCriterion("total_deposit <", value, "totalDeposit");
            return (Criteria) this;
        }

        public Criteria andTotalDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_deposit <=", value, "totalDeposit");
            return (Criteria) this;
        }

        public Criteria andTotalDepositIn(List<BigDecimal> values) {
            addCriterion("total_deposit in", values, "totalDeposit");
            return (Criteria) this;
        }

        public Criteria andTotalDepositNotIn(List<BigDecimal> values) {
            addCriterion("total_deposit not in", values, "totalDeposit");
            return (Criteria) this;
        }

        public Criteria andTotalDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_deposit between", value1, value2, "totalDeposit");
            return (Criteria) this;
        }

        public Criteria andTotalDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_deposit not between", value1, value2, "totalDeposit");
            return (Criteria) this;
        }

        public Criteria andTotalDepositFeeIsNull() {
            addCriterion("total_deposit_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalDepositFeeIsNotNull() {
            addCriterion("total_deposit_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDepositFeeEqualTo(BigDecimal value) {
            addCriterion("total_deposit_fee =", value, "totalDepositFee");
            return (Criteria) this;
        }

        public Criteria andTotalDepositFeeNotEqualTo(BigDecimal value) {
            addCriterion("total_deposit_fee <>", value, "totalDepositFee");
            return (Criteria) this;
        }

        public Criteria andTotalDepositFeeGreaterThan(BigDecimal value) {
            addCriterion("total_deposit_fee >", value, "totalDepositFee");
            return (Criteria) this;
        }

        public Criteria andTotalDepositFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_deposit_fee >=", value, "totalDepositFee");
            return (Criteria) this;
        }

        public Criteria andTotalDepositFeeLessThan(BigDecimal value) {
            addCriterion("total_deposit_fee <", value, "totalDepositFee");
            return (Criteria) this;
        }

        public Criteria andTotalDepositFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_deposit_fee <=", value, "totalDepositFee");
            return (Criteria) this;
        }

        public Criteria andTotalDepositFeeIn(List<BigDecimal> values) {
            addCriterion("total_deposit_fee in", values, "totalDepositFee");
            return (Criteria) this;
        }

        public Criteria andTotalDepositFeeNotIn(List<BigDecimal> values) {
            addCriterion("total_deposit_fee not in", values, "totalDepositFee");
            return (Criteria) this;
        }

        public Criteria andTotalDepositFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_deposit_fee between", value1, value2, "totalDepositFee");
            return (Criteria) this;
        }

        public Criteria andTotalDepositFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_deposit_fee not between", value1, value2, "totalDepositFee");
            return (Criteria) this;
        }

        public Criteria andTotalChargeIsNull() {
            addCriterion("total_charge is null");
            return (Criteria) this;
        }

        public Criteria andTotalChargeIsNotNull() {
            addCriterion("total_charge is not null");
            return (Criteria) this;
        }

        public Criteria andTotalChargeEqualTo(BigDecimal value) {
            addCriterion("total_charge =", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeNotEqualTo(BigDecimal value) {
            addCriterion("total_charge <>", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeGreaterThan(BigDecimal value) {
            addCriterion("total_charge >", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_charge >=", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeLessThan(BigDecimal value) {
            addCriterion("total_charge <", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_charge <=", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeIn(List<BigDecimal> values) {
            addCriterion("total_charge in", values, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeNotIn(List<BigDecimal> values) {
            addCriterion("total_charge not in", values, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_charge between", value1, value2, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_charge not between", value1, value2, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalCashOutIsNull() {
            addCriterion("total_cash_out is null");
            return (Criteria) this;
        }

        public Criteria andTotalCashOutIsNotNull() {
            addCriterion("total_cash_out is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCashOutEqualTo(BigDecimal value) {
            addCriterion("total_cash_out =", value, "totalCashOut");
            return (Criteria) this;
        }

        public Criteria andTotalCashOutNotEqualTo(BigDecimal value) {
            addCriterion("total_cash_out <>", value, "totalCashOut");
            return (Criteria) this;
        }

        public Criteria andTotalCashOutGreaterThan(BigDecimal value) {
            addCriterion("total_cash_out >", value, "totalCashOut");
            return (Criteria) this;
        }

        public Criteria andTotalCashOutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_cash_out >=", value, "totalCashOut");
            return (Criteria) this;
        }

        public Criteria andTotalCashOutLessThan(BigDecimal value) {
            addCriterion("total_cash_out <", value, "totalCashOut");
            return (Criteria) this;
        }

        public Criteria andTotalCashOutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_cash_out <=", value, "totalCashOut");
            return (Criteria) this;
        }

        public Criteria andTotalCashOutIn(List<BigDecimal> values) {
            addCriterion("total_cash_out in", values, "totalCashOut");
            return (Criteria) this;
        }

        public Criteria andTotalCashOutNotIn(List<BigDecimal> values) {
            addCriterion("total_cash_out not in", values, "totalCashOut");
            return (Criteria) this;
        }

        public Criteria andTotalCashOutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_cash_out between", value1, value2, "totalCashOut");
            return (Criteria) this;
        }

        public Criteria andTotalCashOutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_cash_out not between", value1, value2, "totalCashOut");
            return (Criteria) this;
        }

        public Criteria andTotalOtherInIsNull() {
            addCriterion("total_other_in is null");
            return (Criteria) this;
        }

        public Criteria andTotalOtherInIsNotNull() {
            addCriterion("total_other_in is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOtherInEqualTo(BigDecimal value) {
            addCriterion("total_other_in =", value, "totalOtherIn");
            return (Criteria) this;
        }

        public Criteria andTotalOtherInNotEqualTo(BigDecimal value) {
            addCriterion("total_other_in <>", value, "totalOtherIn");
            return (Criteria) this;
        }

        public Criteria andTotalOtherInGreaterThan(BigDecimal value) {
            addCriterion("total_other_in >", value, "totalOtherIn");
            return (Criteria) this;
        }

        public Criteria andTotalOtherInGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_other_in >=", value, "totalOtherIn");
            return (Criteria) this;
        }

        public Criteria andTotalOtherInLessThan(BigDecimal value) {
            addCriterion("total_other_in <", value, "totalOtherIn");
            return (Criteria) this;
        }

        public Criteria andTotalOtherInLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_other_in <=", value, "totalOtherIn");
            return (Criteria) this;
        }

        public Criteria andTotalOtherInIn(List<BigDecimal> values) {
            addCriterion("total_other_in in", values, "totalOtherIn");
            return (Criteria) this;
        }

        public Criteria andTotalOtherInNotIn(List<BigDecimal> values) {
            addCriterion("total_other_in not in", values, "totalOtherIn");
            return (Criteria) this;
        }

        public Criteria andTotalOtherInBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_other_in between", value1, value2, "totalOtherIn");
            return (Criteria) this;
        }

        public Criteria andTotalOtherInNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_other_in not between", value1, value2, "totalOtherIn");
            return (Criteria) this;
        }

        public Criteria andTotalOtherOutIsNull() {
            addCriterion("total_other_out is null");
            return (Criteria) this;
        }

        public Criteria andTotalOtherOutIsNotNull() {
            addCriterion("total_other_out is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOtherOutEqualTo(BigDecimal value) {
            addCriterion("total_other_out =", value, "totalOtherOut");
            return (Criteria) this;
        }

        public Criteria andTotalOtherOutNotEqualTo(BigDecimal value) {
            addCriterion("total_other_out <>", value, "totalOtherOut");
            return (Criteria) this;
        }

        public Criteria andTotalOtherOutGreaterThan(BigDecimal value) {
            addCriterion("total_other_out >", value, "totalOtherOut");
            return (Criteria) this;
        }

        public Criteria andTotalOtherOutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_other_out >=", value, "totalOtherOut");
            return (Criteria) this;
        }

        public Criteria andTotalOtherOutLessThan(BigDecimal value) {
            addCriterion("total_other_out <", value, "totalOtherOut");
            return (Criteria) this;
        }

        public Criteria andTotalOtherOutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_other_out <=", value, "totalOtherOut");
            return (Criteria) this;
        }

        public Criteria andTotalOtherOutIn(List<BigDecimal> values) {
            addCriterion("total_other_out in", values, "totalOtherOut");
            return (Criteria) this;
        }

        public Criteria andTotalOtherOutNotIn(List<BigDecimal> values) {
            addCriterion("total_other_out not in", values, "totalOtherOut");
            return (Criteria) this;
        }

        public Criteria andTotalOtherOutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_other_out between", value1, value2, "totalOtherOut");
            return (Criteria) this;
        }

        public Criteria andTotalOtherOutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_other_out not between", value1, value2, "totalOtherOut");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIsNull() {
            addCriterion("account_balance is null");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIsNotNull() {
            addCriterion("account_balance is not null");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceEqualTo(BigDecimal value) {
            addCriterion("account_balance =", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotEqualTo(BigDecimal value) {
            addCriterion("account_balance <>", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceGreaterThan(BigDecimal value) {
            addCriterion("account_balance >", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("account_balance >=", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceLessThan(BigDecimal value) {
            addCriterion("account_balance <", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("account_balance <=", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIn(List<BigDecimal> values) {
            addCriterion("account_balance in", values, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotIn(List<BigDecimal> values) {
            addCriterion("account_balance not in", values, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("account_balance between", value1, value2, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("account_balance not between", value1, value2, "accountBalance");
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