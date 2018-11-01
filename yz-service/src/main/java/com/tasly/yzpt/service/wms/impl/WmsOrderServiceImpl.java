package com.tasly.yzpt.service.wms.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tasly.yzpt.common.yzEnum.SendWmsEnum;
import com.tasly.yzpt.repository.message.TradeWmsRepository;
import com.tasly.yzpt.repository.message.entity.TradeWms;
import com.tasly.yzpt.service.message.TradeWmsService;
import com.tasly.yzpt.service.message.entity.CancelOrderEntity;
import com.tasly.yzpt.service.message.entity.OrderEntity;
import com.tasly.yzpt.service.wms.WMSCannelWebserviceUtil;
import com.tasly.yzpt.service.wms.WMSSendWebserviceUtil;
import com.tasly.yzpt.service.wms.WmsOrderService;
import com.tasly.yzpt.service.wms.cannel.WmsRkxtdSoap;
import com.tasly.yzpt.service.wms.send.INFDATA;
import com.tasly.yzpt.service.wms.send.WmsCkkpdSoap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Talsy_xiashengxin on 2018/10/25.
 */

@Slf4j
@Service
public class WmsOrderServiceImpl implements WmsOrderService {

    @Autowired
    TradeWmsRepository tradeWmsRepository;
    @Autowired
    TradeWmsService tradeWmsService;

    @Override
    public void sendToWmsOrder(OrderEntity orderEntity) {
        //下发WMS
        //创建数据trade-wms 默认0 等到wms返回信息更新为1
        WmsCkkpdSoap soap = WMSSendWebserviceUtil.getWebserviceClient("http://10.9.7.31:7001/WmsCkkpd.asmx", WmsCkkpdSoap.class);
        //下发wms传输参数
        try {
            String infdatastr = WMSSendWebserviceUtil.packageWMSXmlString(orderEntity);
            log.info("下发WMS参数[{}]",infdatastr);
            soap.receiveCkkpd(WMSSendWebserviceUtil.packageSoapRequest(infdatastr));
            log.info("保存WMS参数[{}]",infdatastr);
            TradeWms tradeWms = new TradeWms();
            tradeWms.setTid(orderEntity.getDanjNo());
            tradeWms.setStatus(SendWmsEnum.SEND_WMS.getStatus());
            tradeWms.setSendTime(new Date());
            tradeWmsService.insert(tradeWms);
        }catch (Exception e){
            log.error("订单下发wms失败", e);
        }
    }

    @Override
    public void cancelToWmsOrder(CancelOrderEntity cancelOrderEntity) {
        //下发WMS 取消订单
        WmsRkxtdSoap soap = WMSSendWebserviceUtil.getWebserviceClient("http://10.9.7.31:7001/WmsCkdel.asmx", WmsRkxtdSoap.class);
        try {
            String infdatastr = WMSCannelWebserviceUtil.packageWMSXmlString(cancelOrderEntity);
            log.info("下发WMS参数[{}]",infdatastr);
            soap.receiveRkxtd(WMSCannelWebserviceUtil.packageSoapRequest(infdatastr));
        } catch (JsonProcessingException e) {
            log.error("下发WMS取消订单失败", e);
        }

    }

    @Override
    public void sendCancelToWmsOrder(Object object) {

    }
}
