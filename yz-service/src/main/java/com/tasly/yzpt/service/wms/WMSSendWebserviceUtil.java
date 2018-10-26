package com.tasly.yzpt.service.wms;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.tasly.yzpt.service.message.entity.OrderEntity;
import com.tasly.yzpt.service.message.entity.OrderItemEntity;
import com.tasly.yzpt.service.wms.bo.WMSSendOrder;
import com.tasly.yzpt.service.wms.bo.WMSSendOrderItem;
import com.tasly.yzpt.service.wms.send.*;
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
public class WMSSendWebserviceUtil {

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

    public static INFDATA packageSoapRequest(String data){
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
        baseInfo.setSERVICENAME("receiveCkkpd");
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
     * @param url
     * @param data
     */
    public static void receiveCkkpd(String url,String data){
        WmsCkkpdSoap soap = getWebserviceClient(url, WmsCkkpdSoap.class);
        INFDATA infdata = packageSoapRequest(data);
        log.info("发送wms参数INFDATA[{}]",infdata);
        soap.receiveCkkpd(infdata);
    }

    /**
     * WMS销售出库订单取消下传方法
     * @param url
     * @param data
     */
    public static void receiveCkdel(String url,String data){
        WmsCkkpdSoap soap = getWebserviceClient(url, WmsCkkpdSoap.class);
        INFDATA infdata = packageSoapRequest(data);
        log.info("发送wms参数INFDATA[{}]",infdata);
        soap.receiveCkkpd(infdata);
    }

    /**
     * 对象转换成发送WMS的方法
     * @return
     */
    static public String packageWMSXmlString(OrderEntity orderEntity) throws JsonProcessingException {
        WMSSendOrder wmsSendOrder = new WMSSendOrder();
        wmsSendOrder.setDANJ_NO(orderEntity.getDanjNo());
        wmsSendOrder.setWLZX_CODE(orderEntity.getWlzxCode());
        wmsSendOrder.setHUOZ_ID(orderEntity.getHuozId());
        wmsSendOrder.setDANW_ID(orderEntity.getDanwId());
        wmsSendOrder.setRIQI_DATE(orderEntity.getRiqiDate());
        wmsSendOrder.setTIH_WAY(orderEntity.getTihWay());
        wmsSendOrder.setXIAOS_TYPE(orderEntity.getXiaosType());
        wmsSendOrder.setFAH_TYPE(orderEntity.getFahType());
        wmsSendOrder.setNOTE(orderEntity.getNote());
        wmsSendOrder.setCKD_TYPE(orderEntity.getCkdType());
        wmsSendOrder.setTIAOM_NUM(orderEntity.getTiaomNum());
        wmsSendOrder.setECC_SHIPTO_REGION(orderEntity.getEccShiptoRegion());
        wmsSendOrder.setECC_SHIPTO_CITY(orderEntity.getEccShiptoCity());
        wmsSendOrder.setECC_SHIPTO_DISTRICT(orderEntity.getEccShiptoDistrict());
        wmsSendOrder.setADDRESS(orderEntity.getAddress());
        wmsSendOrder.setSHOUH_PHONE(orderEntity.getShouh_phone());
        wmsSendOrder.setSHOUH_STAFF(orderEntity.getShouhStaff());
        wmsSendOrder.setPOSTCODE(orderEntity.getPostcode());
        List<WMSSendOrderItem> items = new ArrayList<WMSSendOrderItem>();
        for(OrderItemEntity orderItemEntity: orderEntity.getOrderItemEntities()){
            WMSSendOrderItem wmsSendOrderItem = new WMSSendOrderItem();
            wmsSendOrderItem.setHANGHAO(orderItemEntity.getHanghao());
            wmsSendOrderItem.setNUM(orderItemEntity.getNum());
            wmsSendOrderItem.setCARRIER_ID(orderItemEntity.getCarrierId());
            wmsSendOrderItem.setCARRIER_NAME(orderItemEntity.getCarrierName());
            wmsSendOrderItem.setSALEORDER_NUMBER(orderItemEntity.getSaleorderNumber());
            wmsSendOrderItem.setSHANGP_ID(orderItemEntity.getShangpId());
            items.add(wmsSendOrderItem);
        }
        wmsSendOrder.getItemList().setItems(items);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setDefaultUseWrapper(false);
        xmlMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        xmlMapper.enable(MapperFeature.USE_STD_BEAN_NAMING);
        String orderXmlString = xmlMapper.writeValueAsString(wmsSendOrder);
        orderXmlString = orderXmlString.replace("<root>", "");
        orderXmlString = orderXmlString.replace("</root>", "");
        StringBuilder stringBuilder = new StringBuilder("<ARRAYOFT_CK_KPD><T_CK_KPD>");
        stringBuilder.append(orderXmlString)
                .append("</T_CK_KPD></ARRAYOFT_CK_KPD>");
        return stringBuilder.toString();
    }

}
