package com.tasly.yzpt.service.wms.bo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Created by Talsy_xiashengxin on 2018/10/23.
 */
@JacksonXmlRootElement(localName = "MINGXI")
public class WMSSendOrderItem {
    /**
     * 行号
     */
    private String HANGHAO;
    /**
     * 商品内码
     */
    private String SHANGP_ID;
    /**
     * 数量
     */
    private String NUM;
    /**
     * 批号要求
     */
    private String LOT_REQUEST;
    /**
     * 单价
     */
    private String PRICE;
    private String JIFEN;
    /**
     * 金额
     */
    private String AMOUNT;
    private String TAX_AMOUNT;
    private String JIES_PRICE;
    private String JIES_AMOUNT;
    /**
     * YUNDA 快递公司
     */
    private String CARRIER_ID;
    /**
     * 韵达快递
     */
    private String CARRIER_NAME;
    /**
     * 运费 0.00
     */
    private String ZYUNFEI;

    private String DRUG_HISTORY;

    private String HAVE_ALLERGY;

    private String DRUG_EFFECT;

    private String PRESCRIPTION_DOSAGE;

    private String PRESCRIPTION_USAGE;

    private String BATCH_NUMBER;

    private String DAY_OF_MEDICATION;

    private String BUY_QUANTITY;

    private String ACTUAL_DAY_OF_MEDICATION;

    private String ACTUAL_BOX_OF_MEDICATION;
    /**
     * 非必填 为空
     */
    private String SALEORDER_NUMBER;

    @JacksonXmlProperty(localName = "HANGHAO")
    public String getHANGHAO() {
        return HANGHAO;
    }

    @JacksonXmlProperty(localName = "SHANGP_ID")
    public String getSHANGP_ID() {
        return SHANGP_ID;
    }

    @JacksonXmlProperty(localName = "NUM")
    public String getNUM() {
        return NUM;
    }

    @JacksonXmlProperty(localName = "LOT_REQUEST")
    public String getLOT_REQUEST() {
        return LOT_REQUEST;
    }

    @JacksonXmlProperty(localName = "PRICE")
    public String getPRICE() {
        return PRICE;
    }

    @JacksonXmlProperty(localName = "JIFEN")
    public String getJIFEN() {
        return JIFEN;
    }

    @JacksonXmlProperty(localName = "AMOUNT")
    public String getAMOUNT() {
        return AMOUNT;
    }

    @JacksonXmlProperty(localName = "TAX_AMOUNT")
    public String getTAX_AMOUNT() {
        return TAX_AMOUNT;
    }

    @JacksonXmlProperty(localName = "JIES_PRICE")
    public String getJIES_PRICE() {
        return JIES_PRICE;
    }

    @JacksonXmlProperty(localName = "JIES_AMOUNT")
    public String getJIES_AMOUNT() {
        return JIES_AMOUNT;
    }

    @JacksonXmlProperty(localName = "CARRIER_ID")
    public String getCARRIER_ID() {
        return CARRIER_ID;
    }

    @JacksonXmlProperty(localName = "CARRIER_NAME")
    public String getCARRIER_NAME() {
        return CARRIER_NAME;
    }

    @JacksonXmlProperty(localName = "ZYUNFEI")
    public String getZYUNFEI() {
        return ZYUNFEI;
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

    @JacksonXmlProperty(localName = "PRESCRIPTION_DOSAGE")
    public String getPRESCRIPTION_DOSAGE() {
        return PRESCRIPTION_DOSAGE;
    }

    @JacksonXmlProperty(localName = "PRESCRIPTION_USAGE")
    public String getPRESCRIPTION_USAGE() {
        return PRESCRIPTION_USAGE;
    }

    @JacksonXmlProperty(localName = "BATCH_NUMBER")
    public String getBATCH_NUMBER() {
        return BATCH_NUMBER;
    }

    @JacksonXmlProperty(localName = "DAY_OF_MEDICATION")
    public String getDAY_OF_MEDICATION() {
        return DAY_OF_MEDICATION;
    }

    @JacksonXmlProperty(localName = "BUY_QUANTITY")
    public String getBUY_QUANTITY() {
        return BUY_QUANTITY;
    }

    @JacksonXmlProperty(localName = "ACTUAL_DAY_OF_MEDICATION")
    public String getACTUAL_DAY_OF_MEDICATION() {
        return ACTUAL_DAY_OF_MEDICATION;
    }

    @JacksonXmlProperty(localName = "ACTUAL_BOX_OF_MEDICATION")
    public String getACTUAL_BOX_OF_MEDICATION() {
        return ACTUAL_BOX_OF_MEDICATION;
    }

    @JacksonXmlProperty(localName = "SALEORDER_NUMBER")
    public String getSALEORDER_NUMBER() {
        return SALEORDER_NUMBER;
    }


    public void setHANGHAO(String HANGHAO) {
        this.HANGHAO = HANGHAO;
    }

    public void setSHANGP_ID(String SHANGP_ID) {
        this.SHANGP_ID = SHANGP_ID;
    }

    public void setNUM(String NUM) {
        this.NUM = NUM;
    }

    public void setLOT_REQUEST(String LOT_REQUEST) {
        this.LOT_REQUEST = LOT_REQUEST;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public void setJIFEN(String JIFEN) {
        this.JIFEN = JIFEN;
    }

    public void setAMOUNT(String AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public void setTAX_AMOUNT(String TAX_AMOUNT) {
        this.TAX_AMOUNT = TAX_AMOUNT;
    }

    public void setJIES_PRICE(String JIES_PRICE) {
        this.JIES_PRICE = JIES_PRICE;
    }

    public void setJIES_AMOUNT(String JIES_AMOUNT) {
        this.JIES_AMOUNT = JIES_AMOUNT;
    }


    public void setCARRIER_ID(String CARRIER_ID) {
        this.CARRIER_ID = CARRIER_ID;
    }

    public void setCARRIER_NAME(String CARRIER_NAME) {
        this.CARRIER_NAME = CARRIER_NAME;
    }

    public void setZYUNFEI(String ZYUNFEI) {
        this.ZYUNFEI = ZYUNFEI;
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

    public void setPRESCRIPTION_DOSAGE(String PRESCRIPTION_DOSAGE) {
        this.PRESCRIPTION_DOSAGE = PRESCRIPTION_DOSAGE;
    }

    public void setPRESCRIPTION_USAGE(String PRESCRIPTION_USAGE) {
        this.PRESCRIPTION_USAGE = PRESCRIPTION_USAGE;
    }

    public void setBATCH_NUMBER(String BATCH_NUMBER) {
        this.BATCH_NUMBER = BATCH_NUMBER;
    }

    public void setDAY_OF_MEDICATION(String DAY_OF_MEDICATION) {
        this.DAY_OF_MEDICATION = DAY_OF_MEDICATION;
    }

    public void setBUY_QUANTITY(String BUY_QUANTITY) {
        this.BUY_QUANTITY = BUY_QUANTITY;
    }

    public void setACTUAL_DAY_OF_MEDICATION(String ACTUAL_DAY_OF_MEDICATION) {
        this.ACTUAL_DAY_OF_MEDICATION = ACTUAL_DAY_OF_MEDICATION;
    }

    public void setACTUAL_BOX_OF_MEDICATION(String ACTUAL_BOX_OF_MEDICATION) {
        this.ACTUAL_BOX_OF_MEDICATION = ACTUAL_BOX_OF_MEDICATION;
    }

    public void setSALEORDER_NUMBER(String SALEORDER_NUMBER) {
        this.SALEORDER_NUMBER = SALEORDER_NUMBER;
    }
}
