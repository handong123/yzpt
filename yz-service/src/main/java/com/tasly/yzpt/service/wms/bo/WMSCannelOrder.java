package com.tasly.yzpt.service.wms.bo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Created by Talsy_xiashengxin on 2018/10/23.
 */

@JacksonXmlRootElement(localName = "root")
public class WMSCannelOrder {

    /**
     * 单据编号
     */
    private String DANJ_NO;
    /**
     *物流中心编码
     */
    private String WLZX_CODE;
    /**
     * 货主内码
     */
    private String HUOZ_ID;
    /**
     * 单位内码
     */
    private String DANW_ID;
    /**
     * 单据日期
     */
    private String RIQI_DATE;
    /**
     * 业务员
     */
    private String YEW_STAFF;
    /**
     * 提货方式
     */
    private String TIH_WAY;
    /**
     * 销售类型
     */
    private String XIAOS_TYPE;
    /**
     * 发货类型
     */
    private String FAH_TYPE;
    /**
     * 原备注为客服备注
     */
    private String NOTE;
    /**
     * 出库复核单打印要求
     */
    private String CKD_TYPE;
    private String ADDRESS_NO;
    /**
     * 省(北京)
     */
    private String ECC_SHIPTO_REGION;

    /**
     * 市(北京)
     */
    private String ECC_SHIPTO_CITY;
    /**
     * 区
     */
    private String ECC_SHIPTO_DISTRICT;
    /**
     * 地址
     */
    private String ADDRESS;
    private String GUKE_NAME;
    private String GUKE_NO;
    /**
     * 收货电话
     */
    private String SHOUH_PHONE;
    /**
     * 收货人
     */
    private String SHOUH_STAFF;
    /**
     * 邮编
     */
    private String POSTCODE;
    /**
     * 配送备注为客户备注
     */
    private String PEIS_NOTES;
    private String DAOH_TIME;
    private String JIAJ_FLG;
    private String TIAOM_NUM;
    private String ZT;
    /**
     * 承运商ID
     */
    private String CARRIER_ID;
    /**
     * 承运商名称
     */
    private String CARRIER_NAME;
    /**
     * 发票类型（00普票 01 增票 空：不开票）
     */
    private String SHUIP_TYPE;

    private String INVOICE_TITLE;
    /**
     * 渠道平台订单编号ID （淘宝订单号100 位）
     */
    private String DANJ_NO_WSDD;
    /**
     * 渠道平台用户名 （昵称名50位）
     */
    private String PLATFORM_USERNAME;

    private String PAYER_ID;

    private String PAYER_NAME;

    private String DANJ_NO_SAP;

    private String BILL_NUMBER;

    private String SUB_ORDER_NUMBER;

    private String INVOICE_NUMBER;

    private String INVOICE_CONTENT;

    private String SHAD_CITY;

    private String SHAD_CITY_DISTRICT;

    private String POSTAL_ZONE;

    private String SHAD_TOWN;

    private String SHAD_TOWN_NUMBER;

    private String SHAD_RESIDENTIAL;

    private String SHAD_RESIDENTIAL_NUMBER;

    private String SOCIAL_SECURITY_NUMBER;

    private String SEX;

    private String AGE;

    private String PAYMENT_INFO_TYPE;

    private String DELIVERY_SERVICE;

    private String SHIPPING_PRICE;

    private String DRUG_HISTORY;

    private String HAVE_ALLERGY;

    private String DRUG_EFFECT;

    private String PAYMENT;

    private String PHARMACISTS_OPINIONS;

    private String IS_NEED_SECOND_REIMURSEMENT;

    private String IS_PRESCRIBE;

    private String DELIVERY_DATE;

    private String SETTLEMENT_DATE;

    private String BILLS_TYPE;

    private String CONSIGNEE_ID;


    private WMSSendOrderItemList itemList = new WMSSendOrderItemList();

    @JacksonXmlProperty(localName = "DANJ_NO")
    public String getDANJ_NO() {
        return DANJ_NO;
    }

    @JacksonXmlProperty(localName = "WLZX_CODE")
    public String getWLZX_CODE() {
        return WLZX_CODE;
    }

    @JacksonXmlProperty(localName = "HUOZ_ID")
    public String getHUOZ_ID() {
        return HUOZ_ID;
    }

    @JacksonXmlProperty(localName = "DANW_ID")
    public String getDANW_ID() {
        return DANW_ID;
    }

    @JacksonXmlProperty(localName = "RIQI_DATE")
    public String getRIQI_DATE() {
        return RIQI_DATE;
    }

    @JacksonXmlProperty(localName = "YEW_STAFF")
    public String getYEW_STAFF() {
        return YEW_STAFF;
    }

    @JacksonXmlProperty(localName = "TIH_WAY")
    public String getTIH_WAY() {
        return TIH_WAY;
    }

    @JacksonXmlProperty(localName = "XIAOS_TYPE")
    public String getXIAOS_TYPE() {
        return XIAOS_TYPE;
    }

    @JacksonXmlProperty(localName = "FAH_TYPE")
    public String getFAH_TYPE() {
        return FAH_TYPE;
    }

    @JacksonXmlProperty(localName = "NOTE")
    public String getNOTE() {
        return NOTE;
    }

    @JacksonXmlProperty(localName = "CKD_TYPE")
    public String getCKD_TYPE() {
        return CKD_TYPE;
    }

    @JacksonXmlProperty(localName = "ADDRESS_NO")
    public String getADDRESS_NO() {
        return ADDRESS_NO;
    }

    @JacksonXmlProperty(localName = "ECC_SHIPTO_REGION")
    public String getECC_SHIPTO_REGION() { return ECC_SHIPTO_REGION; }

    @JacksonXmlProperty(localName = "ECC_SHIPTO_CITY")
    public String getECC_SHIPTO_CITY() { return ECC_SHIPTO_CITY; }

    @JacksonXmlProperty(localName = "ECC_SHIPTO_DISTRICT")
    public String getECC_SHIPTO_DISTRICT() {return ECC_SHIPTO_DISTRICT;}

    @JacksonXmlProperty(localName = "ADDRESS")
    public String getADDRESS() {
        return ADDRESS;
    }

    @JacksonXmlProperty(localName = "GUKE_NAME")
    public String getGUKE_NAME() {
        return GUKE_NAME;
    }

    @JacksonXmlProperty(localName = "GUKE_NO")
    public String getGUKE_NO() {
        return GUKE_NO;
    }

    @JacksonXmlProperty(localName = "SHOUH_PHONE")
    public String getSHOUH_PHONE() {
        return SHOUH_PHONE;
    }

    @JacksonXmlProperty(localName = "SHOUH_STAFF")
    public String getSHOUH_STAFF() {
        return SHOUH_STAFF;
    }

    @JacksonXmlProperty(localName = "POSTCODE")
    public String getPOSTCODE() {
        return POSTCODE;
    }

    @JacksonXmlProperty(localName = "PEIS_NOTES")
    public String getPEIS_NOTES() {
        return PEIS_NOTES;
    }

    @JacksonXmlProperty(localName = "DAOH_TIME")
    public String getDAOH_TIME() {
        return DAOH_TIME;
    }

    @JacksonXmlProperty(localName = "JIAJ_FLG")
    public String getJIAJ_FLG() {
        return JIAJ_FLG;
    }

    @JacksonXmlProperty(localName = "TIAOM_NUM")
    public String getTIAOM_NUM() {
        return TIAOM_NUM;
    }

    @JacksonXmlProperty(localName = "ZT")
    public String getZT() {
        return ZT;
    }

    @JacksonXmlProperty(localName = "CARRIER_ID")
    public String getCARRIER_ID() {
        return CARRIER_ID;
    }

    @JacksonXmlProperty(localName = "CARRIER_NAME")
    public String getCARRIER_NAME() {
        return CARRIER_NAME;
    }

    @JacksonXmlProperty(localName = "SHUIP_TYPE")
    public String getSHUIP_TYPE() {
        return SHUIP_TYPE;
    }

    @JacksonXmlProperty(localName = "INVOICE_TITLE")
    public String getINVOICE_TITLE() {return INVOICE_TITLE;}

    @JacksonXmlProperty(localName = "DANJ_NO_WSDD")
    public String getDANJ_NO_WSDD() {
        return DANJ_NO_WSDD;
    }

    @JacksonXmlProperty(localName = "PLATFORM_USERNAME")
    public String getPLATFORM_USERNAME() {
        return PLATFORM_USERNAME;
    }

    @JacksonXmlProperty(localName = "PAYER_ID")
    public String getPAYER_ID() {
        return PAYER_ID;
    }

    @JacksonXmlProperty(localName = "PAYER_NAME")
    public String getPAYER_NAME() {
        return PAYER_NAME;
    }

    @JacksonXmlProperty(localName = "DANJ_NO_SAP")
    public String getDANJ_NO_SAP() {
        return DANJ_NO_SAP;
    }

    @JacksonXmlProperty(localName = "BILL_NUMBER")
    public String getBILL_NUMBER() {
        return BILL_NUMBER;
    }

    @JacksonXmlProperty(localName = "SUB_ORDER_NUMBER")
    public String getSUB_ORDER_NUMBER() {
        return SUB_ORDER_NUMBER;
    }

    @JacksonXmlProperty(localName = "INVOICE_NUMBER")
    public String getINVOICE_NUMBER() {
        return INVOICE_NUMBER;
    }

    @JacksonXmlProperty(localName = "INVOICE_CONTENT")
    public String getINVOICE_CONTENT() {
        return INVOICE_CONTENT;
    }

    @JacksonXmlProperty(localName = "SHAD_CITY")
    public String getSHAD_CITY() {
        return SHAD_CITY;
    }

    @JacksonXmlProperty(localName = "SHAD_CITY_DISTRICT")
    public String getSHAD_CITY_DISTRICT() {
        return SHAD_CITY_DISTRICT;
    }

    @JacksonXmlProperty(localName = "POSTAL_ZONE")
    public String getPOSTAL_ZONE() {
        return POSTAL_ZONE;
    }

    @JacksonXmlProperty(localName = "SHAD_TOWN")
    public String getSHAD_TOWN() {
        return SHAD_TOWN;
    }

    @JacksonXmlProperty(localName = "SHAD_TOWN_NUMBER")
    public String getSHAD_TOWN_NUMBER() {
        return SHAD_TOWN_NUMBER;
    }

    @JacksonXmlProperty(localName = "SHAD_RESIDENTIAL")
    public String getSHAD_RESIDENTIAL() {
        return SHAD_RESIDENTIAL;
    }

    @JacksonXmlProperty(localName = "SHAD_RESIDENTIAL_NUMBER")
    public String getSHAD_RESIDENTIAL_NUMBER() {
        return SHAD_RESIDENTIAL_NUMBER;
    }

    @JacksonXmlProperty(localName = "SOCIAL_SECURITY_NUMBER")
    public String getSOCIAL_SECURITY_NUMBER() {
        return SOCIAL_SECURITY_NUMBER;
    }

    @JacksonXmlProperty(localName = "SEX")
    public String getSEX() {
        return SEX;
    }

    @JacksonXmlProperty(localName = "AGE")
    public String getAGE() {
        return AGE;
    }

    @JacksonXmlProperty(localName = "PAYMENT_INFO_TYPE")
    public String getPAYMENT_INFO_TYPE() {
        return PAYMENT_INFO_TYPE;
    }

    @JacksonXmlProperty(localName = "DELIVERY_SERVICE")
    public String getDELIVERY_SERVICE() {
        return DELIVERY_SERVICE;
    }

    @JacksonXmlProperty(localName = "SHIPPING_PRICE")
    public String getSHIPPING_PRICE() {
        return SHIPPING_PRICE;
    }

    @JacksonXmlProperty(localName = "DRUG_HISTORY")
    public String getDRUG_HISTORY() {
        return DRUG_HISTORY;
    }

    @JacksonXmlProperty(localName = "HAVE_ALLERGY")
    public String getHAVE_ALLERGY() {
        return HAVE_ALLERGY;
    }

    @JacksonXmlProperty(localName = "DRUG_EFFECT")
    public String getDRUG_EFFECT() {
        return DRUG_EFFECT;
    }

    @JacksonXmlProperty(localName = "PAYMENT")
    public String getPAYMENT() {
        return PAYMENT;
    }

    @JacksonXmlProperty(localName = "PHARMACISTS_OPINIONS")
    public String getPHARMACISTS_OPINIONS() {
        return PHARMACISTS_OPINIONS;
    }

    @JacksonXmlProperty(localName = "IS_NEED_SECOND_REIMURSEMENT")
    public String getIS_NEED_SECOND_REIMURSEMENT() {
        return IS_NEED_SECOND_REIMURSEMENT;
    }

    @JacksonXmlProperty(localName = "IS_PRESCRIBE")
    public String getIS_PRESCRIBE() {
        return IS_PRESCRIBE;
    }

    @JacksonXmlProperty(localName = "DELIVERY_DATE")
    public String getDELIVERY_DATE() {
        return DELIVERY_DATE;
    }

    @JacksonXmlProperty(localName = "SETTLEMENT_DATE")
    public String getSETTLEMENT_DATE() {
        return SETTLEMENT_DATE;
    }

    @JacksonXmlProperty(localName = "BILLS_TYPE")
    public String getBILLS_TYPE() {
        return BILLS_TYPE;
    }

    @JacksonXmlProperty(localName = "CONSIGNEE_ID")
    public String getCONSIGNEE_ID() {
        return CONSIGNEE_ID;
    }

    @JacksonXmlProperty(localName = "DANJ_MX")
    public WMSSendOrderItemList getItemList() {
        return itemList;
    }




    public void setDANJ_NO(String DANJ_NO) {
        this.DANJ_NO = DANJ_NO;
    }

    public void setWLZX_CODE(String WLZX_CODE) {
        this.WLZX_CODE = WLZX_CODE;
    }

    public void setHUOZ_ID(String HUOZ_ID) {
        this.HUOZ_ID = HUOZ_ID;
    }

    public void setDANW_ID(String DANW_ID) {
        this.DANW_ID = DANW_ID;
    }

    public void setRIQI_DATE(String RIQI_DATE) {
        this.RIQI_DATE = RIQI_DATE;
    }

    public void setYEW_STAFF(String YEW_STAFF) {
        this.YEW_STAFF = YEW_STAFF;
    }

    public void setTIH_WAY(String TIH_WAY) {
        this.TIH_WAY = TIH_WAY;
    }

    public void setXIAOS_TYPE(String XIAOS_TYPE) {
        this.XIAOS_TYPE = XIAOS_TYPE;
    }

    public void setFAH_TYPE(String FAH_TYPE) {
        this.FAH_TYPE = FAH_TYPE;
    }

    public void setNOTE(String NOTE) {
        this.NOTE = NOTE;
    }

    public void setCKD_TYPE(String CKD_TYPE) {
        this.CKD_TYPE = CKD_TYPE;
    }

    public void setADDRESS_NO(String ADDRESS_NO) {
        this.ADDRESS_NO = ADDRESS_NO;
    }

    public void setECC_SHIPTO_REGION(String ECC_SHIPTO_REGION) {this.ECC_SHIPTO_REGION = ECC_SHIPTO_REGION;}

    public void setECC_SHIPTO_CITY(String ECC_SHIPTO_CITY) {this.ECC_SHIPTO_CITY = ECC_SHIPTO_CITY;}

    public void setECC_SHIPTO_DISTRICT(String ECC_SHIPTO_DISTRICT) {this.ECC_SHIPTO_DISTRICT = ECC_SHIPTO_DISTRICT;}

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public void setGUKE_NAME(String GUKE_NAME) {
        this.GUKE_NAME = GUKE_NAME;
    }

    public void setGUKE_NO(String GUKE_NO) {
        this.GUKE_NO = GUKE_NO;
    }

    public void setSHOUH_PHONE(String SHOUH_PHONE) {
        this.SHOUH_PHONE = SHOUH_PHONE;
    }

    public void setSHOUH_STAFF(String SHOUH_STAFF) {
        this.SHOUH_STAFF = SHOUH_STAFF;
    }

    public void setPOSTCODE(String POSTCODE) {
        this.POSTCODE = POSTCODE;
    }

    public void setPEIS_NOTES(String PEIS_NOTES) {
        this.PEIS_NOTES = PEIS_NOTES;
    }

    public void setDAOH_TIME(String DAOH_TIME) {
        this.DAOH_TIME = DAOH_TIME;
    }

    public void setJIAJ_FLG(String JIAJ_FLG) {
        this.JIAJ_FLG = JIAJ_FLG;
    }

    public void setTIAOM_NUM(String TIAOM_NUM) {
        this.TIAOM_NUM = TIAOM_NUM;
    }

    public void setZT(String ZT) {
        this.ZT = ZT;
    }

    public void setCARRIER_ID(String CARRIER_ID) {
        this.CARRIER_ID = CARRIER_ID;
    }

    public void setCARRIER_NAME(String CARRIER_NAME) {
        this.CARRIER_NAME = CARRIER_NAME;
    }

    public void setSHUIP_TYPE(String SHUIP_TYPE) {
        this.SHUIP_TYPE = SHUIP_TYPE;
    }

    public void setINVOICE_TITLE(String INVOICE_TITLE) {this.INVOICE_TITLE = INVOICE_TITLE;}

    public void setDANJ_NO_WSDD(String DANJ_NO_WSDD) {
        this.DANJ_NO_WSDD = DANJ_NO_WSDD;
    }

    public void setPLATFORM_USERNAME(String PLATFORM_USERNAME) {
        this.PLATFORM_USERNAME = PLATFORM_USERNAME;
    }

    public void setPAYER_ID(String PAYER_ID) {
        this.PAYER_ID = PAYER_ID;
    }

    public void setPAYER_NAME(String PAYER_NAME) {
        this.PAYER_NAME = PAYER_NAME;
    }

    public void setDANJ_NO_SAP(String DANJ_NO_SAP) {
        this.DANJ_NO_SAP = DANJ_NO_SAP;
    }

    public void setBILL_NUMBER(String BILL_NUMBER) {
        this.BILL_NUMBER = BILL_NUMBER;
    }

    public void setSUB_ORDER_NUMBER(String SUB_ORDER_NUMBER) {
        this.SUB_ORDER_NUMBER = SUB_ORDER_NUMBER;
    }

    public void setINVOICE_NUMBER(String INVOICE_NUMBER) {
        this.INVOICE_NUMBER = INVOICE_NUMBER;
    }

    public void setINVOICE_CONTENT(String INVOICE_CONTENT) {
        this.INVOICE_CONTENT = INVOICE_CONTENT;
    }

    public void setSHAD_CITY(String SHAD_CITY) {
        this.SHAD_CITY = SHAD_CITY;
    }

    public void setSHAD_CITY_DISTRICT(String SHAD_CITY_DISTRICT) {
        this.SHAD_CITY_DISTRICT = SHAD_CITY_DISTRICT;
    }

    public void setPOSTAL_ZONE(String POSTAL_ZONE) {
        this.POSTAL_ZONE = POSTAL_ZONE;
    }

    public void setSHAD_TOWN(String SHAD_TOWN) {
        this.SHAD_TOWN = SHAD_TOWN;
    }

    public void setSHAD_TOWN_NUMBER(String SHAD_TOWN_NUMBER) {
        this.SHAD_TOWN_NUMBER = SHAD_TOWN_NUMBER;
    }

    public void setSHAD_RESIDENTIAL(String SHAD_RESIDENTIAL) {
        this.SHAD_RESIDENTIAL = SHAD_RESIDENTIAL;
    }

    public void setSHAD_RESIDENTIAL_NUMBER(String SHAD_RESIDENTIAL_NUMBER) {
        this.SHAD_RESIDENTIAL_NUMBER = SHAD_RESIDENTIAL_NUMBER;
    }

    public void setSOCIAL_SECURITY_NUMBER(String SOCIAL_SECURITY_NUMBER) {
        this.SOCIAL_SECURITY_NUMBER = SOCIAL_SECURITY_NUMBER;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public void setAGE(String AGE) {
        this.AGE = AGE;
    }

    public void setPAYMENT_INFO_TYPE(String PAYMENT_INFO_TYPE) {
        this.PAYMENT_INFO_TYPE = PAYMENT_INFO_TYPE;
    }

    public void setDELIVERY_SERVICE(String DELIVERY_SERVICE) {
        this.DELIVERY_SERVICE = DELIVERY_SERVICE;
    }

    public void setSHIPPING_PRICE(String SHIPPING_PRICE) {
        this.SHIPPING_PRICE = SHIPPING_PRICE;
    }

    public void setDRUG_HISTORY(String DRUG_HISTORY) {
        this.DRUG_HISTORY = DRUG_HISTORY;
    }

    public void setHAVE_ALLERGY(String HAVE_ALLERGY) {
        this.HAVE_ALLERGY = HAVE_ALLERGY;
    }

    public void setDRUG_EFFECT(String DRUG_EFFECT) {
        this.DRUG_EFFECT = DRUG_EFFECT;
    }

    public void setPAYMENT(String PAYMENT) {
        this.PAYMENT = PAYMENT;
    }

    public void setPHARMACISTS_OPINIONS(String PHARMACISTS_OPINIONS) {
        this.PHARMACISTS_OPINIONS = PHARMACISTS_OPINIONS;
    }

    public void setIS_NEED_SECOND_REIMURSEMENT(String IS_NEED_SECOND_REIMURSEMENT) {
        this.IS_NEED_SECOND_REIMURSEMENT = IS_NEED_SECOND_REIMURSEMENT;
    }

    public void setIS_PRESCRIBE(String IS_PRESCRIBE) {
        this.IS_PRESCRIBE = IS_PRESCRIBE;
    }

    public void setDELIVERY_DATE(String DELIVERY_DATE) {
        this.DELIVERY_DATE = DELIVERY_DATE;
    }

    public void setSETTLEMENT_DATE(String SETTLEMENT_DATE) {
        this.SETTLEMENT_DATE = SETTLEMENT_DATE;
    }

    public void setBILLS_TYPE(String BILLS_TYPE) {
        this.BILLS_TYPE = BILLS_TYPE;
    }

    public void setCONSIGNEE_ID(String CONSIGNEE_ID) {
        this.CONSIGNEE_ID = CONSIGNEE_ID;
    }

    public void setItemList(WMSSendOrderItemList itemList) {
        this.itemList = itemList;
    }




    public class WMSSendOrderItemList{
        private List<WMSSendOrderItem> items;

        @JacksonXmlProperty(localName = "MINGXI")
        public List<WMSSendOrderItem> getItems() {
            return items;
        }

        public void setItems(List<WMSSendOrderItem> items) {
            this.items = items;
        }
    }


}
