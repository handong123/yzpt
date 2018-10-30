package com.tasly.yzpt.service.wms;

import com.tasly.yzpt.service.message.entity.OrderEntity;
import com.tasly.yzpt.service.wms.cannel.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    static public String packageWMSXmlString(OrderEntity orderEntity){
        log.info("------接收OrderEntity对象内容------" + orderEntity.toString());
        return "";
    }

}
