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
     * 单据日期
     */
    private String RIQI_DATE;
    /**
     * 业务员
     */
    private String YEW_STAFF;

    private String DANJ_NO_Y;

    private String YUANYIN;
    /**
     * 原备注为客服备注
     */
    private String NOTE;
    /**
     * 配送备注为客户备注
     */
    private String PEIS_NOTES;

    private String TIAOM_NUM;

    private String ZT;

    private WMSCannelOrderItemList itemList = new WMSCannelOrderItemList();

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

    @JacksonXmlProperty(localName = "RIQI_DATE")
    public String getRIQI_DATE() {
        return RIQI_DATE;
    }

    @JacksonXmlProperty(localName = "YEW_STAFF")
    public String getYEW_STAFF() {
        return YEW_STAFF;
    }

    @JacksonXmlProperty(localName = "DANJ_NO_Y")
    public String getDANJ_NO_Y() { return DANJ_NO_Y;}

    @JacksonXmlProperty(localName = "YUANYIN")
    public String getYUANYIN() { return YUANYIN; }

    @JacksonXmlProperty(localName = "NOTE")
    public String getNOTE() {
        return NOTE;
    }

    @JacksonXmlProperty(localName = "PEIS_NOTES")
    public String getPEIS_NOTES() {
        return PEIS_NOTES;
    }

    @JacksonXmlProperty(localName = "TIAOM_NUM")
    public String getTIAOM_NUM() {
        return TIAOM_NUM;
    }

    @JacksonXmlProperty(localName = "ZT")
    public String getZT() {
        return ZT;
    }

    @JacksonXmlProperty(localName = "DANJ_MX")
    public WMSCannelOrderItemList getItemList() {
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

    public void setRIQI_DATE(String RIQI_DATE) {
        this.RIQI_DATE = RIQI_DATE;
    }

    public void setYEW_STAFF(String YEW_STAFF) {
        this.YEW_STAFF = YEW_STAFF;
    }

    public void setDANJ_NO_Y(String DANJ_NO_Y) { this.DANJ_NO_Y = DANJ_NO_Y;}

    public void setYUANYIN(String YUANYIN) { this.YUANYIN = YUANYIN;}

    public void setNOTE(String NOTE) {
        this.NOTE = NOTE;
    }

    public void setPEIS_NOTES(String PEIS_NOTES) {
        this.PEIS_NOTES = PEIS_NOTES;
    }

    public void setTIAOM_NUM(String TIAOM_NUM) {
        this.TIAOM_NUM = TIAOM_NUM;
    }

    public void setZT(String ZT) {
        this.ZT = ZT;
    }

    public void setItemList(WMSCannelOrderItemList itemList) {
        this.itemList = itemList;
    }


    public class WMSCannelOrderItemList{
        private List<WMSCannelOrderItem> items;

        @JacksonXmlProperty(localName = "MINGXI")
        public List<WMSCannelOrderItem> getItems() {
            return items;
        }

        public void setItems(List<WMSCannelOrderItem> items) {
            this.items = items;
        }
    }


}
