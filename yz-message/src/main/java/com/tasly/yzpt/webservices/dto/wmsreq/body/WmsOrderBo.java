package com.tasly.yzpt.webservices.dto.wmsreq.body;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Created by Talsy_xiashengxin on 2018/11/1.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JacksonXmlRootElement(localName = "MINGXI")
public class WmsOrderBo {

    @JacksonXmlProperty(localName = "HANGHAO")
    private String HANGHAO;

    @JacksonXmlProperty(localName = "SHANGP_ID")
    private String SHANGP_ID;

    @JacksonXmlProperty(localName = "NUM")
    private String NUM;

    @JacksonXmlProperty(localName = "LOT")
    private String LOT;

    @JacksonXmlProperty(localName = "SHENGCHAN_DATE")
    private String SHENGCHAN_DATE;

    @JacksonXmlProperty(localName = "YOUX_DATE")
    private String YOUX_DATE;

    @JacksonXmlProperty(localName = "KUC_STATE")
    private String KUC_STATE;

    @JacksonXmlProperty(localName = "HANGHAO_YW")
    private String HANGHAO_YW;

    @JacksonXmlProperty(localName = "CARRIER_ID")
    private String CARRIER_ID;

    @JacksonXmlProperty(localName = "YUNDAN_NO")
    private String YUNDAN_NO;

    @JacksonXmlProperty(localName = "FAPIAO_NO")
    private String FAPIAO_NO;

    @JacksonXmlProperty(localName = "YEWDJ_NO")
    private String YEWDJ_NO;

}
