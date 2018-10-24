package com.tasly.yzpt.service.wms.bo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;

/**
 * Created by Talsy_xiashengxin on 2018/10/23.
 */

@JacksonXmlRootElement(localName = "root")
public class WMSSendOrder {

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
    /**
     * 渠道平台订单编号ID （淘宝订单号100 位）
     */
    private String DANJ_NO_WSDD;
    /**
     * 渠道平台用户名 （昵称名50位）
     */
    private String PLATFORM_USERNAME;

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

    @JacksonXmlProperty(localName = "DANJ_NO_WSDD")
    public String getDANJ_NO_WSDD() {
        return DANJ_NO_WSDD;
    }

    @JacksonXmlProperty(localName = "PLATFORM_USERNAME")
    public String getPLATFORM_USERNAME() {
        return PLATFORM_USERNAME;
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

    public void setDANJ_NO_WSDD(String DANJ_NO_WSDD) {
        this.DANJ_NO_WSDD = DANJ_NO_WSDD;
    }

    public void setPLATFORM_USERNAME(String PLATFORM_USERNAME) {
        this.PLATFORM_USERNAME = PLATFORM_USERNAME;
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
