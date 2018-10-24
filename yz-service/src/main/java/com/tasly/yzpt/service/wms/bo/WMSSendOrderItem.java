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
}
