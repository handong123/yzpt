package com.tasly.yzpt.webservices.dto.wmsreq.body;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * @author Liu.Ping
 * @time 2018-9-27 下午 2:59
 * @description erp推送的产品体信息
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JacksonXmlRootElement(localName = "T_CK_SC")
public class WmsBodyWrapper {

    @JacksonXmlProperty(localName = "DANJ_NO")
    private String DANJ_NO;

    @JacksonXmlProperty(localName = "HUOZ_ID")
    private String HUOZ_ID;

    @JacksonXmlProperty(localName = "WLZX_CODE")
    private String WLZX_CODE;

    @JacksonXmlProperty(localName = "RIQI_DATE")
    private String RIQI_DATE;

    @JacksonXmlProperty(localName = "DANW_ID")
    private String DANW_ID;

    @JacksonXmlProperty(localName = "CAOZ_STAFF")
    private String CAOZ_STAFF;

    @JacksonXmlProperty(localName = "YEWDJ_NO")
    private String YEWDJ_NO;

    @JacksonXmlProperty(localName = "TIAOM_NUM")
    private String TIAOM_NUM;

    @JacksonXmlProperty(localName = "ZT")
    private String ZT;

    @JacksonXmlProperty(localName = "DANJ_MX")
    private List<WmsOrderBo> list;

}

