package com.tomcat360.atm.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbEquipmentSettingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEquipmentSettingsExample() {
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

        public Criteria andEquipmentTypeIsNull() {
            addCriterion("equipment_type is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeIsNotNull() {
            addCriterion("equipment_type is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeEqualTo(String value) {
            addCriterion("equipment_type =", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotEqualTo(String value) {
            addCriterion("equipment_type <>", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeGreaterThan(String value) {
            addCriterion("equipment_type >", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_type >=", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLessThan(String value) {
            addCriterion("equipment_type <", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLessThanOrEqualTo(String value) {
            addCriterion("equipment_type <=", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeLike(String value) {
            addCriterion("equipment_type like", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotLike(String value) {
            addCriterion("equipment_type not like", value, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeIn(List<String> values) {
            addCriterion("equipment_type in", values, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotIn(List<String> values) {
            addCriterion("equipment_type not in", values, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeBetween(String value1, String value2) {
            addCriterion("equipment_type between", value1, value2, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentTypeNotBetween(String value1, String value2) {
            addCriterion("equipment_type not between", value1, value2, "equipmentType");
            return (Criteria) this;
        }

        public Criteria andEquipmentSubTypeIsNull() {
            addCriterion("equipment_sub_type is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentSubTypeIsNotNull() {
            addCriterion("equipment_sub_type is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentSubTypeEqualTo(String value) {
            addCriterion("equipment_sub_type =", value, "equipmentSubType");
            return (Criteria) this;
        }

        public Criteria andEquipmentSubTypeNotEqualTo(String value) {
            addCriterion("equipment_sub_type <>", value, "equipmentSubType");
            return (Criteria) this;
        }

        public Criteria andEquipmentSubTypeGreaterThan(String value) {
            addCriterion("equipment_sub_type >", value, "equipmentSubType");
            return (Criteria) this;
        }

        public Criteria andEquipmentSubTypeGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_sub_type >=", value, "equipmentSubType");
            return (Criteria) this;
        }

        public Criteria andEquipmentSubTypeLessThan(String value) {
            addCriterion("equipment_sub_type <", value, "equipmentSubType");
            return (Criteria) this;
        }

        public Criteria andEquipmentSubTypeLessThanOrEqualTo(String value) {
            addCriterion("equipment_sub_type <=", value, "equipmentSubType");
            return (Criteria) this;
        }

        public Criteria andEquipmentSubTypeLike(String value) {
            addCriterion("equipment_sub_type like", value, "equipmentSubType");
            return (Criteria) this;
        }

        public Criteria andEquipmentSubTypeNotLike(String value) {
            addCriterion("equipment_sub_type not like", value, "equipmentSubType");
            return (Criteria) this;
        }

        public Criteria andEquipmentSubTypeIn(List<String> values) {
            addCriterion("equipment_sub_type in", values, "equipmentSubType");
            return (Criteria) this;
        }

        public Criteria andEquipmentSubTypeNotIn(List<String> values) {
            addCriterion("equipment_sub_type not in", values, "equipmentSubType");
            return (Criteria) this;
        }

        public Criteria andEquipmentSubTypeBetween(String value1, String value2) {
            addCriterion("equipment_sub_type between", value1, value2, "equipmentSubType");
            return (Criteria) this;
        }

        public Criteria andEquipmentSubTypeNotBetween(String value1, String value2) {
            addCriterion("equipment_sub_type not between", value1, value2, "equipmentSubType");
            return (Criteria) this;
        }

        public Criteria andEquipmentVersionIsNull() {
            addCriterion("equipment_version is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentVersionIsNotNull() {
            addCriterion("equipment_version is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentVersionEqualTo(String value) {
            addCriterion("equipment_version =", value, "equipmentVersion");
            return (Criteria) this;
        }

        public Criteria andEquipmentVersionNotEqualTo(String value) {
            addCriterion("equipment_version <>", value, "equipmentVersion");
            return (Criteria) this;
        }

        public Criteria andEquipmentVersionGreaterThan(String value) {
            addCriterion("equipment_version >", value, "equipmentVersion");
            return (Criteria) this;
        }

        public Criteria andEquipmentVersionGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_version >=", value, "equipmentVersion");
            return (Criteria) this;
        }

        public Criteria andEquipmentVersionLessThan(String value) {
            addCriterion("equipment_version <", value, "equipmentVersion");
            return (Criteria) this;
        }

        public Criteria andEquipmentVersionLessThanOrEqualTo(String value) {
            addCriterion("equipment_version <=", value, "equipmentVersion");
            return (Criteria) this;
        }

        public Criteria andEquipmentVersionLike(String value) {
            addCriterion("equipment_version like", value, "equipmentVersion");
            return (Criteria) this;
        }

        public Criteria andEquipmentVersionNotLike(String value) {
            addCriterion("equipment_version not like", value, "equipmentVersion");
            return (Criteria) this;
        }

        public Criteria andEquipmentVersionIn(List<String> values) {
            addCriterion("equipment_version in", values, "equipmentVersion");
            return (Criteria) this;
        }

        public Criteria andEquipmentVersionNotIn(List<String> values) {
            addCriterion("equipment_version not in", values, "equipmentVersion");
            return (Criteria) this;
        }

        public Criteria andEquipmentVersionBetween(String value1, String value2) {
            addCriterion("equipment_version between", value1, value2, "equipmentVersion");
            return (Criteria) this;
        }

        public Criteria andEquipmentVersionNotBetween(String value1, String value2) {
            addCriterion("equipment_version not between", value1, value2, "equipmentVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionIsNull() {
            addCriterion("soft_version is null");
            return (Criteria) this;
        }

        public Criteria andSoftVersionIsNotNull() {
            addCriterion("soft_version is not null");
            return (Criteria) this;
        }

        public Criteria andSoftVersionEqualTo(String value) {
            addCriterion("soft_version =", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotEqualTo(String value) {
            addCriterion("soft_version <>", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionGreaterThan(String value) {
            addCriterion("soft_version >", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionGreaterThanOrEqualTo(String value) {
            addCriterion("soft_version >=", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionLessThan(String value) {
            addCriterion("soft_version <", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionLessThanOrEqualTo(String value) {
            addCriterion("soft_version <=", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionLike(String value) {
            addCriterion("soft_version like", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotLike(String value) {
            addCriterion("soft_version not like", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionIn(List<String> values) {
            addCriterion("soft_version in", values, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotIn(List<String> values) {
            addCriterion("soft_version not in", values, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionBetween(String value1, String value2) {
            addCriterion("soft_version between", value1, value2, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotBetween(String value1, String value2) {
            addCriterion("soft_version not between", value1, value2, "softVersion");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andOperateosIsNull() {
            addCriterion("operateos is null");
            return (Criteria) this;
        }

        public Criteria andOperateosIsNotNull() {
            addCriterion("operateos is not null");
            return (Criteria) this;
        }

        public Criteria andOperateosEqualTo(String value) {
            addCriterion("operateos =", value, "operateos");
            return (Criteria) this;
        }

        public Criteria andOperateosNotEqualTo(String value) {
            addCriterion("operateos <>", value, "operateos");
            return (Criteria) this;
        }

        public Criteria andOperateosGreaterThan(String value) {
            addCriterion("operateos >", value, "operateos");
            return (Criteria) this;
        }

        public Criteria andOperateosGreaterThanOrEqualTo(String value) {
            addCriterion("operateos >=", value, "operateos");
            return (Criteria) this;
        }

        public Criteria andOperateosLessThan(String value) {
            addCriterion("operateos <", value, "operateos");
            return (Criteria) this;
        }

        public Criteria andOperateosLessThanOrEqualTo(String value) {
            addCriterion("operateos <=", value, "operateos");
            return (Criteria) this;
        }

        public Criteria andOperateosLike(String value) {
            addCriterion("operateos like", value, "operateos");
            return (Criteria) this;
        }

        public Criteria andOperateosNotLike(String value) {
            addCriterion("operateos not like", value, "operateos");
            return (Criteria) this;
        }

        public Criteria andOperateosIn(List<String> values) {
            addCriterion("operateos in", values, "operateos");
            return (Criteria) this;
        }

        public Criteria andOperateosNotIn(List<String> values) {
            addCriterion("operateos not in", values, "operateos");
            return (Criteria) this;
        }

        public Criteria andOperateosBetween(String value1, String value2) {
            addCriterion("operateos between", value1, value2, "operateos");
            return (Criteria) this;
        }

        public Criteria andOperateosNotBetween(String value1, String value2) {
            addCriterion("operateos not between", value1, value2, "operateos");
            return (Criteria) this;
        }

        public Criteria andBrowserIsNull() {
            addCriterion("browser is null");
            return (Criteria) this;
        }

        public Criteria andBrowserIsNotNull() {
            addCriterion("browser is not null");
            return (Criteria) this;
        }

        public Criteria andBrowserEqualTo(String value) {
            addCriterion("browser =", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotEqualTo(String value) {
            addCriterion("browser <>", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserGreaterThan(String value) {
            addCriterion("browser >", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserGreaterThanOrEqualTo(String value) {
            addCriterion("browser >=", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLessThan(String value) {
            addCriterion("browser <", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLessThanOrEqualTo(String value) {
            addCriterion("browser <=", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLike(String value) {
            addCriterion("browser like", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotLike(String value) {
            addCriterion("browser not like", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserIn(List<String> values) {
            addCriterion("browser in", values, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotIn(List<String> values) {
            addCriterion("browser not in", values, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserBetween(String value1, String value2) {
            addCriterion("browser between", value1, value2, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotBetween(String value1, String value2) {
            addCriterion("browser not between", value1, value2, "browser");
            return (Criteria) this;
        }

        public Criteria andInstallLocationIsNull() {
            addCriterion("install_location is null");
            return (Criteria) this;
        }

        public Criteria andInstallLocationIsNotNull() {
            addCriterion("install_location is not null");
            return (Criteria) this;
        }

        public Criteria andInstallLocationEqualTo(String value) {
            addCriterion("install_location =", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationNotEqualTo(String value) {
            addCriterion("install_location <>", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationGreaterThan(String value) {
            addCriterion("install_location >", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationGreaterThanOrEqualTo(String value) {
            addCriterion("install_location >=", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationLessThan(String value) {
            addCriterion("install_location <", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationLessThanOrEqualTo(String value) {
            addCriterion("install_location <=", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationLike(String value) {
            addCriterion("install_location like", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationNotLike(String value) {
            addCriterion("install_location not like", value, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationIn(List<String> values) {
            addCriterion("install_location in", values, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationNotIn(List<String> values) {
            addCriterion("install_location not in", values, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationBetween(String value1, String value2) {
            addCriterion("install_location between", value1, value2, "installLocation");
            return (Criteria) this;
        }

        public Criteria andInstallLocationNotBetween(String value1, String value2) {
            addCriterion("install_location not between", value1, value2, "installLocation");
            return (Criteria) this;
        }

        public Criteria andPreIpIsNull() {
            addCriterion("pre_ip is null");
            return (Criteria) this;
        }

        public Criteria andPreIpIsNotNull() {
            addCriterion("pre_ip is not null");
            return (Criteria) this;
        }

        public Criteria andPreIpEqualTo(String value) {
            addCriterion("pre_ip =", value, "preIp");
            return (Criteria) this;
        }

        public Criteria andPreIpNotEqualTo(String value) {
            addCriterion("pre_ip <>", value, "preIp");
            return (Criteria) this;
        }

        public Criteria andPreIpGreaterThan(String value) {
            addCriterion("pre_ip >", value, "preIp");
            return (Criteria) this;
        }

        public Criteria andPreIpGreaterThanOrEqualTo(String value) {
            addCriterion("pre_ip >=", value, "preIp");
            return (Criteria) this;
        }

        public Criteria andPreIpLessThan(String value) {
            addCriterion("pre_ip <", value, "preIp");
            return (Criteria) this;
        }

        public Criteria andPreIpLessThanOrEqualTo(String value) {
            addCriterion("pre_ip <=", value, "preIp");
            return (Criteria) this;
        }

        public Criteria andPreIpLike(String value) {
            addCriterion("pre_ip like", value, "preIp");
            return (Criteria) this;
        }

        public Criteria andPreIpNotLike(String value) {
            addCriterion("pre_ip not like", value, "preIp");
            return (Criteria) this;
        }

        public Criteria andPreIpIn(List<String> values) {
            addCriterion("pre_ip in", values, "preIp");
            return (Criteria) this;
        }

        public Criteria andPreIpNotIn(List<String> values) {
            addCriterion("pre_ip not in", values, "preIp");
            return (Criteria) this;
        }

        public Criteria andPreIpBetween(String value1, String value2) {
            addCriterion("pre_ip between", value1, value2, "preIp");
            return (Criteria) this;
        }

        public Criteria andPreIpNotBetween(String value1, String value2) {
            addCriterion("pre_ip not between", value1, value2, "preIp");
            return (Criteria) this;
        }

        public Criteria andPrePortIsNull() {
            addCriterion("pre_port is null");
            return (Criteria) this;
        }

        public Criteria andPrePortIsNotNull() {
            addCriterion("pre_port is not null");
            return (Criteria) this;
        }

        public Criteria andPrePortEqualTo(String value) {
            addCriterion("pre_port =", value, "prePort");
            return (Criteria) this;
        }

        public Criteria andPrePortNotEqualTo(String value) {
            addCriterion("pre_port <>", value, "prePort");
            return (Criteria) this;
        }

        public Criteria andPrePortGreaterThan(String value) {
            addCriterion("pre_port >", value, "prePort");
            return (Criteria) this;
        }

        public Criteria andPrePortGreaterThanOrEqualTo(String value) {
            addCriterion("pre_port >=", value, "prePort");
            return (Criteria) this;
        }

        public Criteria andPrePortLessThan(String value) {
            addCriterion("pre_port <", value, "prePort");
            return (Criteria) this;
        }

        public Criteria andPrePortLessThanOrEqualTo(String value) {
            addCriterion("pre_port <=", value, "prePort");
            return (Criteria) this;
        }

        public Criteria andPrePortLike(String value) {
            addCriterion("pre_port like", value, "prePort");
            return (Criteria) this;
        }

        public Criteria andPrePortNotLike(String value) {
            addCriterion("pre_port not like", value, "prePort");
            return (Criteria) this;
        }

        public Criteria andPrePortIn(List<String> values) {
            addCriterion("pre_port in", values, "prePort");
            return (Criteria) this;
        }

        public Criteria andPrePortNotIn(List<String> values) {
            addCriterion("pre_port not in", values, "prePort");
            return (Criteria) this;
        }

        public Criteria andPrePortBetween(String value1, String value2) {
            addCriterion("pre_port between", value1, value2, "prePort");
            return (Criteria) this;
        }

        public Criteria andPrePortNotBetween(String value1, String value2) {
            addCriterion("pre_port not between", value1, value2, "prePort");
            return (Criteria) this;
        }

        public Criteria andMonitorPortIsNull() {
            addCriterion("monitor_port is null");
            return (Criteria) this;
        }

        public Criteria andMonitorPortIsNotNull() {
            addCriterion("monitor_port is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorPortEqualTo(String value) {
            addCriterion("monitor_port =", value, "monitorPort");
            return (Criteria) this;
        }

        public Criteria andMonitorPortNotEqualTo(String value) {
            addCriterion("monitor_port <>", value, "monitorPort");
            return (Criteria) this;
        }

        public Criteria andMonitorPortGreaterThan(String value) {
            addCriterion("monitor_port >", value, "monitorPort");
            return (Criteria) this;
        }

        public Criteria andMonitorPortGreaterThanOrEqualTo(String value) {
            addCriterion("monitor_port >=", value, "monitorPort");
            return (Criteria) this;
        }

        public Criteria andMonitorPortLessThan(String value) {
            addCriterion("monitor_port <", value, "monitorPort");
            return (Criteria) this;
        }

        public Criteria andMonitorPortLessThanOrEqualTo(String value) {
            addCriterion("monitor_port <=", value, "monitorPort");
            return (Criteria) this;
        }

        public Criteria andMonitorPortLike(String value) {
            addCriterion("monitor_port like", value, "monitorPort");
            return (Criteria) this;
        }

        public Criteria andMonitorPortNotLike(String value) {
            addCriterion("monitor_port not like", value, "monitorPort");
            return (Criteria) this;
        }

        public Criteria andMonitorPortIn(List<String> values) {
            addCriterion("monitor_port in", values, "monitorPort");
            return (Criteria) this;
        }

        public Criteria andMonitorPortNotIn(List<String> values) {
            addCriterion("monitor_port not in", values, "monitorPort");
            return (Criteria) this;
        }

        public Criteria andMonitorPortBetween(String value1, String value2) {
            addCriterion("monitor_port between", value1, value2, "monitorPort");
            return (Criteria) this;
        }

        public Criteria andMonitorPortNotBetween(String value1, String value2) {
            addCriterion("monitor_port not between", value1, value2, "monitorPort");
            return (Criteria) this;
        }

        public Criteria andMonitorFileIsNull() {
            addCriterion("monitor_file is null");
            return (Criteria) this;
        }

        public Criteria andMonitorFileIsNotNull() {
            addCriterion("monitor_file is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorFileEqualTo(String value) {
            addCriterion("monitor_file =", value, "monitorFile");
            return (Criteria) this;
        }

        public Criteria andMonitorFileNotEqualTo(String value) {
            addCriterion("monitor_file <>", value, "monitorFile");
            return (Criteria) this;
        }

        public Criteria andMonitorFileGreaterThan(String value) {
            addCriterion("monitor_file >", value, "monitorFile");
            return (Criteria) this;
        }

        public Criteria andMonitorFileGreaterThanOrEqualTo(String value) {
            addCriterion("monitor_file >=", value, "monitorFile");
            return (Criteria) this;
        }

        public Criteria andMonitorFileLessThan(String value) {
            addCriterion("monitor_file <", value, "monitorFile");
            return (Criteria) this;
        }

        public Criteria andMonitorFileLessThanOrEqualTo(String value) {
            addCriterion("monitor_file <=", value, "monitorFile");
            return (Criteria) this;
        }

        public Criteria andMonitorFileLike(String value) {
            addCriterion("monitor_file like", value, "monitorFile");
            return (Criteria) this;
        }

        public Criteria andMonitorFileNotLike(String value) {
            addCriterion("monitor_file not like", value, "monitorFile");
            return (Criteria) this;
        }

        public Criteria andMonitorFileIn(List<String> values) {
            addCriterion("monitor_file in", values, "monitorFile");
            return (Criteria) this;
        }

        public Criteria andMonitorFileNotIn(List<String> values) {
            addCriterion("monitor_file not in", values, "monitorFile");
            return (Criteria) this;
        }

        public Criteria andMonitorFileBetween(String value1, String value2) {
            addCriterion("monitor_file between", value1, value2, "monitorFile");
            return (Criteria) this;
        }

        public Criteria andMonitorFileNotBetween(String value1, String value2) {
            addCriterion("monitor_file not between", value1, value2, "monitorFile");
            return (Criteria) this;
        }

        public Criteria andVersionServerPortIsNull() {
            addCriterion("version_server_port is null");
            return (Criteria) this;
        }

        public Criteria andVersionServerPortIsNotNull() {
            addCriterion("version_server_port is not null");
            return (Criteria) this;
        }

        public Criteria andVersionServerPortEqualTo(String value) {
            addCriterion("version_server_port =", value, "versionServerPort");
            return (Criteria) this;
        }

        public Criteria andVersionServerPortNotEqualTo(String value) {
            addCriterion("version_server_port <>", value, "versionServerPort");
            return (Criteria) this;
        }

        public Criteria andVersionServerPortGreaterThan(String value) {
            addCriterion("version_server_port >", value, "versionServerPort");
            return (Criteria) this;
        }

        public Criteria andVersionServerPortGreaterThanOrEqualTo(String value) {
            addCriterion("version_server_port >=", value, "versionServerPort");
            return (Criteria) this;
        }

        public Criteria andVersionServerPortLessThan(String value) {
            addCriterion("version_server_port <", value, "versionServerPort");
            return (Criteria) this;
        }

        public Criteria andVersionServerPortLessThanOrEqualTo(String value) {
            addCriterion("version_server_port <=", value, "versionServerPort");
            return (Criteria) this;
        }

        public Criteria andVersionServerPortLike(String value) {
            addCriterion("version_server_port like", value, "versionServerPort");
            return (Criteria) this;
        }

        public Criteria andVersionServerPortNotLike(String value) {
            addCriterion("version_server_port not like", value, "versionServerPort");
            return (Criteria) this;
        }

        public Criteria andVersionServerPortIn(List<String> values) {
            addCriterion("version_server_port in", values, "versionServerPort");
            return (Criteria) this;
        }

        public Criteria andVersionServerPortNotIn(List<String> values) {
            addCriterion("version_server_port not in", values, "versionServerPort");
            return (Criteria) this;
        }

        public Criteria andVersionServerPortBetween(String value1, String value2) {
            addCriterion("version_server_port between", value1, value2, "versionServerPort");
            return (Criteria) this;
        }

        public Criteria andVersionServerPortNotBetween(String value1, String value2) {
            addCriterion("version_server_port not between", value1, value2, "versionServerPort");
            return (Criteria) this;
        }

        public Criteria andVersionServerFilePortIsNull() {
            addCriterion("version_server_file_port is null");
            return (Criteria) this;
        }

        public Criteria andVersionServerFilePortIsNotNull() {
            addCriterion("version_server_file_port is not null");
            return (Criteria) this;
        }

        public Criteria andVersionServerFilePortEqualTo(String value) {
            addCriterion("version_server_file_port =", value, "versionServerFilePort");
            return (Criteria) this;
        }

        public Criteria andVersionServerFilePortNotEqualTo(String value) {
            addCriterion("version_server_file_port <>", value, "versionServerFilePort");
            return (Criteria) this;
        }

        public Criteria andVersionServerFilePortGreaterThan(String value) {
            addCriterion("version_server_file_port >", value, "versionServerFilePort");
            return (Criteria) this;
        }

        public Criteria andVersionServerFilePortGreaterThanOrEqualTo(String value) {
            addCriterion("version_server_file_port >=", value, "versionServerFilePort");
            return (Criteria) this;
        }

        public Criteria andVersionServerFilePortLessThan(String value) {
            addCriterion("version_server_file_port <", value, "versionServerFilePort");
            return (Criteria) this;
        }

        public Criteria andVersionServerFilePortLessThanOrEqualTo(String value) {
            addCriterion("version_server_file_port <=", value, "versionServerFilePort");
            return (Criteria) this;
        }

        public Criteria andVersionServerFilePortLike(String value) {
            addCriterion("version_server_file_port like", value, "versionServerFilePort");
            return (Criteria) this;
        }

        public Criteria andVersionServerFilePortNotLike(String value) {
            addCriterion("version_server_file_port not like", value, "versionServerFilePort");
            return (Criteria) this;
        }

        public Criteria andVersionServerFilePortIn(List<String> values) {
            addCriterion("version_server_file_port in", values, "versionServerFilePort");
            return (Criteria) this;
        }

        public Criteria andVersionServerFilePortNotIn(List<String> values) {
            addCriterion("version_server_file_port not in", values, "versionServerFilePort");
            return (Criteria) this;
        }

        public Criteria andVersionServerFilePortBetween(String value1, String value2) {
            addCriterion("version_server_file_port between", value1, value2, "versionServerFilePort");
            return (Criteria) this;
        }

        public Criteria andVersionServerFilePortNotBetween(String value1, String value2) {
            addCriterion("version_server_file_port not between", value1, value2, "versionServerFilePort");
            return (Criteria) this;
        }

        public Criteria andLocalMonitorPortIsNull() {
            addCriterion("local_monitor_port is null");
            return (Criteria) this;
        }

        public Criteria andLocalMonitorPortIsNotNull() {
            addCriterion("local_monitor_port is not null");
            return (Criteria) this;
        }

        public Criteria andLocalMonitorPortEqualTo(String value) {
            addCriterion("local_monitor_port =", value, "localMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalMonitorPortNotEqualTo(String value) {
            addCriterion("local_monitor_port <>", value, "localMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalMonitorPortGreaterThan(String value) {
            addCriterion("local_monitor_port >", value, "localMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalMonitorPortGreaterThanOrEqualTo(String value) {
            addCriterion("local_monitor_port >=", value, "localMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalMonitorPortLessThan(String value) {
            addCriterion("local_monitor_port <", value, "localMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalMonitorPortLessThanOrEqualTo(String value) {
            addCriterion("local_monitor_port <=", value, "localMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalMonitorPortLike(String value) {
            addCriterion("local_monitor_port like", value, "localMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalMonitorPortNotLike(String value) {
            addCriterion("local_monitor_port not like", value, "localMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalMonitorPortIn(List<String> values) {
            addCriterion("local_monitor_port in", values, "localMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalMonitorPortNotIn(List<String> values) {
            addCriterion("local_monitor_port not in", values, "localMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalMonitorPortBetween(String value1, String value2) {
            addCriterion("local_monitor_port between", value1, value2, "localMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalMonitorPortNotBetween(String value1, String value2) {
            addCriterion("local_monitor_port not between", value1, value2, "localMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalFileMonitorPortIsNull() {
            addCriterion("local_file_monitor_port is null");
            return (Criteria) this;
        }

        public Criteria andLocalFileMonitorPortIsNotNull() {
            addCriterion("local_file_monitor_port is not null");
            return (Criteria) this;
        }

        public Criteria andLocalFileMonitorPortEqualTo(String value) {
            addCriterion("local_file_monitor_port =", value, "localFileMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalFileMonitorPortNotEqualTo(String value) {
            addCriterion("local_file_monitor_port <>", value, "localFileMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalFileMonitorPortGreaterThan(String value) {
            addCriterion("local_file_monitor_port >", value, "localFileMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalFileMonitorPortGreaterThanOrEqualTo(String value) {
            addCriterion("local_file_monitor_port >=", value, "localFileMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalFileMonitorPortLessThan(String value) {
            addCriterion("local_file_monitor_port <", value, "localFileMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalFileMonitorPortLessThanOrEqualTo(String value) {
            addCriterion("local_file_monitor_port <=", value, "localFileMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalFileMonitorPortLike(String value) {
            addCriterion("local_file_monitor_port like", value, "localFileMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalFileMonitorPortNotLike(String value) {
            addCriterion("local_file_monitor_port not like", value, "localFileMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalFileMonitorPortIn(List<String> values) {
            addCriterion("local_file_monitor_port in", values, "localFileMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalFileMonitorPortNotIn(List<String> values) {
            addCriterion("local_file_monitor_port not in", values, "localFileMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalFileMonitorPortBetween(String value1, String value2) {
            addCriterion("local_file_monitor_port between", value1, value2, "localFileMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLocalFileMonitorPortNotBetween(String value1, String value2) {
            addCriterion("local_file_monitor_port not between", value1, value2, "localFileMonitorPort");
            return (Criteria) this;
        }

        public Criteria andLimitPerDayIsNull() {
            addCriterion("limit_per_day is null");
            return (Criteria) this;
        }

        public Criteria andLimitPerDayIsNotNull() {
            addCriterion("limit_per_day is not null");
            return (Criteria) this;
        }

        public Criteria andLimitPerDayEqualTo(BigDecimal value) {
            addCriterion("limit_per_day =", value, "limitPerDay");
            return (Criteria) this;
        }

        public Criteria andLimitPerDayNotEqualTo(BigDecimal value) {
            addCriterion("limit_per_day <>", value, "limitPerDay");
            return (Criteria) this;
        }

        public Criteria andLimitPerDayGreaterThan(BigDecimal value) {
            addCriterion("limit_per_day >", value, "limitPerDay");
            return (Criteria) this;
        }

        public Criteria andLimitPerDayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("limit_per_day >=", value, "limitPerDay");
            return (Criteria) this;
        }

        public Criteria andLimitPerDayLessThan(BigDecimal value) {
            addCriterion("limit_per_day <", value, "limitPerDay");
            return (Criteria) this;
        }

        public Criteria andLimitPerDayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("limit_per_day <=", value, "limitPerDay");
            return (Criteria) this;
        }

        public Criteria andLimitPerDayIn(List<BigDecimal> values) {
            addCriterion("limit_per_day in", values, "limitPerDay");
            return (Criteria) this;
        }

        public Criteria andLimitPerDayNotIn(List<BigDecimal> values) {
            addCriterion("limit_per_day not in", values, "limitPerDay");
            return (Criteria) this;
        }

        public Criteria andLimitPerDayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("limit_per_day between", value1, value2, "limitPerDay");
            return (Criteria) this;
        }

        public Criteria andLimitPerDayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("limit_per_day not between", value1, value2, "limitPerDay");
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

        public Criteria andMasterKeyIsNull() {
            addCriterion("master_key is null");
            return (Criteria) this;
        }

        public Criteria andMasterKeyIsNotNull() {
            addCriterion("master_key is not null");
            return (Criteria) this;
        }

        public Criteria andMasterKeyEqualTo(String value) {
            addCriterion("master_key =", value, "masterKey");
            return (Criteria) this;
        }

        public Criteria andMasterKeyNotEqualTo(String value) {
            addCriterion("master_key <>", value, "masterKey");
            return (Criteria) this;
        }

        public Criteria andMasterKeyGreaterThan(String value) {
            addCriterion("master_key >", value, "masterKey");
            return (Criteria) this;
        }

        public Criteria andMasterKeyGreaterThanOrEqualTo(String value) {
            addCriterion("master_key >=", value, "masterKey");
            return (Criteria) this;
        }

        public Criteria andMasterKeyLessThan(String value) {
            addCriterion("master_key <", value, "masterKey");
            return (Criteria) this;
        }

        public Criteria andMasterKeyLessThanOrEqualTo(String value) {
            addCriterion("master_key <=", value, "masterKey");
            return (Criteria) this;
        }

        public Criteria andMasterKeyLike(String value) {
            addCriterion("master_key like", value, "masterKey");
            return (Criteria) this;
        }

        public Criteria andMasterKeyNotLike(String value) {
            addCriterion("master_key not like", value, "masterKey");
            return (Criteria) this;
        }

        public Criteria andMasterKeyIn(List<String> values) {
            addCriterion("master_key in", values, "masterKey");
            return (Criteria) this;
        }

        public Criteria andMasterKeyNotIn(List<String> values) {
            addCriterion("master_key not in", values, "masterKey");
            return (Criteria) this;
        }

        public Criteria andMasterKeyBetween(String value1, String value2) {
            addCriterion("master_key between", value1, value2, "masterKey");
            return (Criteria) this;
        }

        public Criteria andMasterKeyNotBetween(String value1, String value2) {
            addCriterion("master_key not between", value1, value2, "masterKey");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIsNull() {
            addCriterion("private_key is null");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIsNotNull() {
            addCriterion("private_key is not null");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyEqualTo(String value) {
            addCriterion("private_key =", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotEqualTo(String value) {
            addCriterion("private_key <>", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyGreaterThan(String value) {
            addCriterion("private_key >", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("private_key >=", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLessThan(String value) {
            addCriterion("private_key <", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("private_key <=", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLike(String value) {
            addCriterion("private_key like", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotLike(String value) {
            addCriterion("private_key not like", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIn(List<String> values) {
            addCriterion("private_key in", values, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotIn(List<String> values) {
            addCriterion("private_key not in", values, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyBetween(String value1, String value2) {
            addCriterion("private_key between", value1, value2, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("private_key not between", value1, value2, "privateKey");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeIsNull() {
            addCriterion("online_time is null");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeIsNotNull() {
            addCriterion("online_time is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeEqualTo(Date value) {
            addCriterion("online_time =", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeNotEqualTo(Date value) {
            addCriterion("online_time <>", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeGreaterThan(Date value) {
            addCriterion("online_time >", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("online_time >=", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeLessThan(Date value) {
            addCriterion("online_time <", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeLessThanOrEqualTo(Date value) {
            addCriterion("online_time <=", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeIn(List<Date> values) {
            addCriterion("online_time in", values, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeNotIn(List<Date> values) {
            addCriterion("online_time not in", values, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeBetween(Date value1, Date value2) {
            addCriterion("online_time between", value1, value2, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeNotBetween(Date value1, Date value2) {
            addCriterion("online_time not between", value1, value2, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andUseStateIsNull() {
            addCriterion("use_state is null");
            return (Criteria) this;
        }

        public Criteria andUseStateIsNotNull() {
            addCriterion("use_state is not null");
            return (Criteria) this;
        }

        public Criteria andUseStateEqualTo(String value) {
            addCriterion("use_state =", value, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateNotEqualTo(String value) {
            addCriterion("use_state <>", value, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateGreaterThan(String value) {
            addCriterion("use_state >", value, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateGreaterThanOrEqualTo(String value) {
            addCriterion("use_state >=", value, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateLessThan(String value) {
            addCriterion("use_state <", value, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateLessThanOrEqualTo(String value) {
            addCriterion("use_state <=", value, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateLike(String value) {
            addCriterion("use_state like", value, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateNotLike(String value) {
            addCriterion("use_state not like", value, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateIn(List<String> values) {
            addCriterion("use_state in", values, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateNotIn(List<String> values) {
            addCriterion("use_state not in", values, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateBetween(String value1, String value2) {
            addCriterion("use_state between", value1, value2, "useState");
            return (Criteria) this;
        }

        public Criteria andUseStateNotBetween(String value1, String value2) {
            addCriterion("use_state not between", value1, value2, "useState");
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