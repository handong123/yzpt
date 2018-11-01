package com.tasly.yzpt.service.wms;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.tasly.yzpt.service.message.entity.CancelOrderEntity;
import com.tasly.yzpt.service.message.entity.CancelOrderItemEntity;
import com.tasly.yzpt.service.wms.bo.WMSCannelOrder;
import com.tasly.yzpt.service.wms.bo.WMSCannelOrderItem;
import com.tasly.yzpt.service.wms.cannel.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
public class WMSCannelWebserviceUtil {

    public static <T> T getWebserviceClient(String url, Class<T> clientClass) {
        JaxWsProxyFactoryBean soapFactoryBean = new JaxWsProxyFactoryBean();
        // 输入报文拦截器
        soapFactoryBean.getInInterceptors().add(new LoggingInInterceptor());
        // 输出报文拦截器
        soapFactoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
        soapFactoryBean.setAddress(url);
        soapFactoryBean.setServiceClass(clientClass);
        Object o = soapFactoryBean.create();
        return (T) o;
    }

    public static INFDATA packageSoapRequest(String data) {
        INFDATA infdata = new INFDATA();
        infdata.setBASEINFO(getBaseInfo());
        infdata.setMESSAGE(getMessage(data));
        return infdata;
    }

    private static GERPBASEINFO getBaseInfo() {
        GERPBASEINFO baseInfo = new GERPBASEINFO();
        baseInfo.setMSGID(UUID.randomUUID().toString());
        baseInfo.setPMSGID("");
        baseInfo.setSENDTIME(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        baseInfo.setSERVICENAME("receiveRkxtd");
        baseInfo.setSPROVINCE("天津");
        baseInfo.setSSYSYEM("ypzpt");
        baseInfo.setTPROVINCE("");
        baseInfo.setTSYSTEM("LMIS");
        return baseInfo;
    }

    private static GERPMESSAGE getMessage(String data) {
        GERPMESSAGE message = new GERPMESSAGE();
        GERPARRAYSTRING arrayString = new GERPARRAYSTRING();
        arrayString.setInfmsg(data);
        message.setARRAYSTRING(arrayString);
        return message;
    }

    /**
     * WMS销售出库订单下传方法出库
     *
     * @param url
     * @param data
     */
    public static void receiveCkkpd(String url, String data) {
        WmsRkxtdSoap soap = getWebserviceClient(url, WmsRkxtdSoap.class);
        INFDATA infdata = packageSoapRequest(data);
        log.info("发送wms参数INFDATA[{}]", infdata);
        soap.receiveRkxtd(infdata);
    }

    /**
     * 对象转换成发送WMS的方法
     *
     * @return
     */
    static public String packageWMSXmlString(CancelOrderEntity cancelOrderEntity) throws JsonProcessingException {
        log.info("------接收OrderEntity对象内容------" + cancelOrderEntity.toString());

        WMSCannelOrder wmsCannelOrder = new WMSCannelOrder();
        //单据编号
        wmsCannelOrder.setDANJ_NO(cancelOrderEntity.getDanjNo());
        //物流中心编码 固定值1201 天津
        wmsCannelOrder.setWLZX_CODE(cancelOrderEntity.getWlzxCode());
        //货主内码  固定值 1017
        wmsCannelOrder.setHUOZ_ID(cancelOrderEntity.getHuozId());
        //单据日期 订单创建日期
        wmsCannelOrder.setRIQI_DATE(cancelOrderEntity.getRiqiDate());
        wmsCannelOrder.setDANJ_NO_Y(cancelOrderEntity.getDanjNoY());

        List<WMSCannelOrderItem> items = new ArrayList<WMSCannelOrderItem>();
        for (CancelOrderItemEntity  cancelOrderItemEntity : cancelOrderEntity.getCancelOrderItemEntityList()) {
            WMSCannelOrderItem wmsCannelOrderItem = new WMSCannelOrderItem();
            wmsCannelOrderItem.setHANGHAO_Y(cancelOrderItemEntity.getHanghaoY());
            wmsCannelOrderItem.setNUM(cancelOrderItemEntity.getNum());
            items.add(wmsCannelOrderItem);
        }
        wmsCannelOrder.getItemList().setItems(items);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setDefaultUseWrapper(false);
        xmlMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        xmlMapper.enable(MapperFeature.USE_STD_BEAN_NAMING);
        String orderXmlString = xmlMapper.writeValueAsString(wmsCannelOrder);
        orderXmlString = orderXmlString.replace("<root>", "");
        orderXmlString = orderXmlString.replace("</root>", "");
        StringBuilder stringBuilder = new StringBuilder("<ARRAYOFT_CK_KPD_DEL><T_CK_KPD_DEL>");
        stringBuilder.append(orderXmlString)
                .append("</T_CK_KPD_DEL></ARRAYOFT_CK_KPD_DEL>");
        String str = stringBuilder.toString();
        log.info("------发送WMS拼接报文------" + str);
        return str;
    }

}
