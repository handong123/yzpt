package com.tasly.yzpt.repository.message.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeAddressExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
    public TradeAddressExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(String value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(String value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(String value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(String value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(String value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(String value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLike(String value) {
            addCriterion("tid like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotLike(String value) {
            addCriterion("tid not like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<String> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<String> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(String value1, String value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(String value1, String value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverTelIsNull() {
            addCriterion("receiver_tel is null");
            return (Criteria) this;
        }

        public Criteria andReceiverTelIsNotNull() {
            addCriterion("receiver_tel is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverTelEqualTo(String value) {
            addCriterion("receiver_tel =", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotEqualTo(String value) {
            addCriterion("receiver_tel <>", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelGreaterThan(String value) {
            addCriterion("receiver_tel >", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_tel >=", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelLessThan(String value) {
            addCriterion("receiver_tel <", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelLessThanOrEqualTo(String value) {
            addCriterion("receiver_tel <=", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelLike(String value) {
            addCriterion("receiver_tel like", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotLike(String value) {
            addCriterion("receiver_tel not like", value, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelIn(List<String> values) {
            addCriterion("receiver_tel in", values, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotIn(List<String> values) {
            addCriterion("receiver_tel not in", values, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelBetween(String value1, String value2) {
            addCriterion("receiver_tel between", value1, value2, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andReceiverTelNotBetween(String value1, String value2) {
            addCriterion("receiver_tel not between", value1, value2, "receiverTel");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceIsNull() {
            addCriterion("delivery_province is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceIsNotNull() {
            addCriterion("delivery_province is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceEqualTo(String value) {
            addCriterion("delivery_province =", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceNotEqualTo(String value) {
            addCriterion("delivery_province <>", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceGreaterThan(String value) {
            addCriterion("delivery_province >", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_province >=", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceLessThan(String value) {
            addCriterion("delivery_province <", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceLessThanOrEqualTo(String value) {
            addCriterion("delivery_province <=", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceLike(String value) {
            addCriterion("delivery_province like", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceNotLike(String value) {
            addCriterion("delivery_province not like", value, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceIn(List<String> values) {
            addCriterion("delivery_province in", values, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceNotIn(List<String> values) {
            addCriterion("delivery_province not in", values, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceBetween(String value1, String value2) {
            addCriterion("delivery_province between", value1, value2, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryProvinceNotBetween(String value1, String value2) {
            addCriterion("delivery_province not between", value1, value2, "deliveryProvince");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityIsNull() {
            addCriterion("delivery_city is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityIsNotNull() {
            addCriterion("delivery_city is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityEqualTo(String value) {
            addCriterion("delivery_city =", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityNotEqualTo(String value) {
            addCriterion("delivery_city <>", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityGreaterThan(String value) {
            addCriterion("delivery_city >", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_city >=", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityLessThan(String value) {
            addCriterion("delivery_city <", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityLessThanOrEqualTo(String value) {
            addCriterion("delivery_city <=", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityLike(String value) {
            addCriterion("delivery_city like", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityNotLike(String value) {
            addCriterion("delivery_city not like", value, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityIn(List<String> values) {
            addCriterion("delivery_city in", values, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityNotIn(List<String> values) {
            addCriterion("delivery_city not in", values, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityBetween(String value1, String value2) {
            addCriterion("delivery_city between", value1, value2, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryCityNotBetween(String value1, String value2) {
            addCriterion("delivery_city not between", value1, value2, "deliveryCity");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictIsNull() {
            addCriterion("delivery_district is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictIsNotNull() {
            addCriterion("delivery_district is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictEqualTo(String value) {
            addCriterion("delivery_district =", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictNotEqualTo(String value) {
            addCriterion("delivery_district <>", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictGreaterThan(String value) {
            addCriterion("delivery_district >", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_district >=", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictLessThan(String value) {
            addCriterion("delivery_district <", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictLessThanOrEqualTo(String value) {
            addCriterion("delivery_district <=", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictLike(String value) {
            addCriterion("delivery_district like", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictNotLike(String value) {
            addCriterion("delivery_district not like", value, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictIn(List<String> values) {
            addCriterion("delivery_district in", values, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictNotIn(List<String> values) {
            addCriterion("delivery_district not in", values, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictBetween(String value1, String value2) {
            addCriterion("delivery_district between", value1, value2, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryDistrictNotBetween(String value1, String value2) {
            addCriterion("delivery_district not between", value1, value2, "deliveryDistrict");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIsNull() {
            addCriterion("delivery_address is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIsNotNull() {
            addCriterion("delivery_address is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressEqualTo(String value) {
            addCriterion("delivery_address =", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotEqualTo(String value) {
            addCriterion("delivery_address <>", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressGreaterThan(String value) {
            addCriterion("delivery_address >", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_address >=", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLessThan(String value) {
            addCriterion("delivery_address <", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLessThanOrEqualTo(String value) {
            addCriterion("delivery_address <=", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLike(String value) {
            addCriterion("delivery_address like", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotLike(String value) {
            addCriterion("delivery_address not like", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIn(List<String> values) {
            addCriterion("delivery_address in", values, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotIn(List<String> values) {
            addCriterion("delivery_address not in", values, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressBetween(String value1, String value2) {
            addCriterion("delivery_address between", value1, value2, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotBetween(String value1, String value2) {
            addCriterion("delivery_address not between", value1, value2, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andAddressExtraIsNull() {
            addCriterion("address_extra is null");
            return (Criteria) this;
        }

        public Criteria andAddressExtraIsNotNull() {
            addCriterion("address_extra is not null");
            return (Criteria) this;
        }

        public Criteria andAddressExtraEqualTo(String value) {
            addCriterion("address_extra =", value, "addressExtra");
            return (Criteria) this;
        }

        public Criteria andAddressExtraNotEqualTo(String value) {
            addCriterion("address_extra <>", value, "addressExtra");
            return (Criteria) this;
        }

        public Criteria andAddressExtraGreaterThan(String value) {
            addCriterion("address_extra >", value, "addressExtra");
            return (Criteria) this;
        }

        public Criteria andAddressExtraGreaterThanOrEqualTo(String value) {
            addCriterion("address_extra >=", value, "addressExtra");
            return (Criteria) this;
        }

        public Criteria andAddressExtraLessThan(String value) {
            addCriterion("address_extra <", value, "addressExtra");
            return (Criteria) this;
        }

        public Criteria andAddressExtraLessThanOrEqualTo(String value) {
            addCriterion("address_extra <=", value, "addressExtra");
            return (Criteria) this;
        }

        public Criteria andAddressExtraLike(String value) {
            addCriterion("address_extra like", value, "addressExtra");
            return (Criteria) this;
        }

        public Criteria andAddressExtraNotLike(String value) {
            addCriterion("address_extra not like", value, "addressExtra");
            return (Criteria) this;
        }

        public Criteria andAddressExtraIn(List<String> values) {
            addCriterion("address_extra in", values, "addressExtra");
            return (Criteria) this;
        }

        public Criteria andAddressExtraNotIn(List<String> values) {
            addCriterion("address_extra not in", values, "addressExtra");
            return (Criteria) this;
        }

        public Criteria andAddressExtraBetween(String value1, String value2) {
            addCriterion("address_extra between", value1, value2, "addressExtra");
            return (Criteria) this;
        }

        public Criteria andAddressExtraNotBetween(String value1, String value2) {
            addCriterion("address_extra not between", value1, value2, "addressExtra");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeIsNull() {
            addCriterion("delivery_postal_code is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeIsNotNull() {
            addCriterion("delivery_postal_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeEqualTo(String value) {
            addCriterion("delivery_postal_code =", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeNotEqualTo(String value) {
            addCriterion("delivery_postal_code <>", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeGreaterThan(String value) {
            addCriterion("delivery_postal_code >", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_postal_code >=", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeLessThan(String value) {
            addCriterion("delivery_postal_code <", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeLessThanOrEqualTo(String value) {
            addCriterion("delivery_postal_code <=", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeLike(String value) {
            addCriterion("delivery_postal_code like", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeNotLike(String value) {
            addCriterion("delivery_postal_code not like", value, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeIn(List<String> values) {
            addCriterion("delivery_postal_code in", values, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeNotIn(List<String> values) {
            addCriterion("delivery_postal_code not in", values, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeBetween(String value1, String value2) {
            addCriterion("delivery_postal_code between", value1, value2, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryPostalCodeNotBetween(String value1, String value2) {
            addCriterion("delivery_postal_code not between", value1, value2, "deliveryPostalCode");
            return (Criteria) this;
        }

        public Criteria andSelfFetchInfoIsNull() {
            addCriterion("self_fetch_info is null");
            return (Criteria) this;
        }

        public Criteria andSelfFetchInfoIsNotNull() {
            addCriterion("self_fetch_info is not null");
            return (Criteria) this;
        }

        public Criteria andSelfFetchInfoEqualTo(String value) {
            addCriterion("self_fetch_info =", value, "selfFetchInfo");
            return (Criteria) this;
        }

        public Criteria andSelfFetchInfoNotEqualTo(String value) {
            addCriterion("self_fetch_info <>", value, "selfFetchInfo");
            return (Criteria) this;
        }

        public Criteria andSelfFetchInfoGreaterThan(String value) {
            addCriterion("self_fetch_info >", value, "selfFetchInfo");
            return (Criteria) this;
        }

        public Criteria andSelfFetchInfoGreaterThanOrEqualTo(String value) {
            addCriterion("self_fetch_info >=", value, "selfFetchInfo");
            return (Criteria) this;
        }

        public Criteria andSelfFetchInfoLessThan(String value) {
            addCriterion("self_fetch_info <", value, "selfFetchInfo");
            return (Criteria) this;
        }

        public Criteria andSelfFetchInfoLessThanOrEqualTo(String value) {
            addCriterion("self_fetch_info <=", value, "selfFetchInfo");
            return (Criteria) this;
        }

        public Criteria andSelfFetchInfoLike(String value) {
            addCriterion("self_fetch_info like", value, "selfFetchInfo");
            return (Criteria) this;
        }

        public Criteria andSelfFetchInfoNotLike(String value) {
            addCriterion("self_fetch_info not like", value, "selfFetchInfo");
            return (Criteria) this;
        }

        public Criteria andSelfFetchInfoIn(List<String> values) {
            addCriterion("self_fetch_info in", values, "selfFetchInfo");
            return (Criteria) this;
        }

        public Criteria andSelfFetchInfoNotIn(List<String> values) {
            addCriterion("self_fetch_info not in", values, "selfFetchInfo");
            return (Criteria) this;
        }

        public Criteria andSelfFetchInfoBetween(String value1, String value2) {
            addCriterion("self_fetch_info between", value1, value2, "selfFetchInfo");
            return (Criteria) this;
        }

        public Criteria andSelfFetchInfoNotBetween(String value1, String value2) {
            addCriterion("self_fetch_info not between", value1, value2, "selfFetchInfo");
            return (Criteria) this;
        }

        public Criteria andDeliveryStartTimeIsNull() {
            addCriterion("delivery_start_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryStartTimeIsNotNull() {
            addCriterion("delivery_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryStartTimeEqualTo(Date value) {
            addCriterion("delivery_start_time =", value, "deliveryStartTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryStartTimeNotEqualTo(Date value) {
            addCriterion("delivery_start_time <>", value, "deliveryStartTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryStartTimeGreaterThan(Date value) {
            addCriterion("delivery_start_time >", value, "deliveryStartTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_start_time >=", value, "deliveryStartTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryStartTimeLessThan(Date value) {
            addCriterion("delivery_start_time <", value, "deliveryStartTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("delivery_start_time <=", value, "deliveryStartTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryStartTimeIn(List<Date> values) {
            addCriterion("delivery_start_time in", values, "deliveryStartTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryStartTimeNotIn(List<Date> values) {
            addCriterion("delivery_start_time not in", values, "deliveryStartTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryStartTimeBetween(Date value1, Date value2) {
            addCriterion("delivery_start_time between", value1, value2, "deliveryStartTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("delivery_start_time not between", value1, value2, "deliveryStartTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeIsNull() {
            addCriterion("delivery_end_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeIsNotNull() {
            addCriterion("delivery_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeEqualTo(Date value) {
            addCriterion("delivery_end_time =", value, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeNotEqualTo(Date value) {
            addCriterion("delivery_end_time <>", value, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeGreaterThan(Date value) {
            addCriterion("delivery_end_time >", value, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_end_time >=", value, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeLessThan(Date value) {
            addCriterion("delivery_end_time <", value, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("delivery_end_time <=", value, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeIn(List<Date> values) {
            addCriterion("delivery_end_time in", values, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeNotIn(List<Date> values) {
            addCriterion("delivery_end_time not in", values, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeBetween(Date value1, Date value2) {
            addCriterion("delivery_end_time between", value1, value2, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("delivery_end_time not between", value1, value2, "deliveryEndTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table trade_address
     *
     * @mbg.generated do_not_delete_during_merge Thu Oct 25 11:07:48 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table trade_address
     *
     * @mbg.generated Thu Oct 25 11:07:48 CST 2018
     */
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