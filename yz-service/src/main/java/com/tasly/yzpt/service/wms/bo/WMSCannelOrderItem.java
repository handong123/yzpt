package com.tasly.yzpt.service.wms.bo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Created by Talsy_xiashengxin on 2018/10/23.
 */
@JacksonXmlRootElement(localName = "MINGXI")
public class WMSCannelOrderItem {
    /**
     * 行号
     */
    private String HANGHAO_Y;
    /**
     * 数量
     */
    private String NUM;

    @JacksonXmlProperty(localName = "HANGHAO_Y")
    public String getHANGHAO() {
        return HANGHAO_Y;
    }

    @JacksonXmlProperty(localName = "NUM")
    public String getNUM() {
        return NUM;
    }

    public void setNUM(String NUM) {
        this.NUM = NUM;
    }

    public void setHANGHAO_Y(String HANGHAO_Y) {
        this.HANGHAO_Y = HANGHAO_Y;
    }

}
