package com.tasly.yzpt.webservices.impl;

import com.tasly.yzpt.common.util.JsonUtil;
import com.tasly.yzpt.repository.message.entity.TidWid;
import com.tasly.yzpt.service.message.LogisticsOnlineConfirmService;
import com.tasly.yzpt.service.message.TidWidService;
import com.tasly.yzpt.service.message.TradeWmsService;
import com.tasly.yzpt.service.message.entity.LogisticsOnlineConfirmParams;
import com.tasly.yzpt.service.wms.send.INFDATA;
import com.tasly.yzpt.webservices.ProductService;
import com.tasly.yzpt.webservices.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Talsy_xiashengxin on 2018/10/29.
 */
@WebService(serviceName = "ProductService", // 与接口中指定的name一致
        targetNamespace = "http://webservice.yzpt.tasly.com/"// 与接口中的命名空间一致,一般是接口的包名倒
)

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    TidWidService tidWidService;

    @Autowired
    TradeWmsService tradeWmsService;

    @Autowired
    LogisticsOnlineConfirmService logisticsOnlineConfirmService;

    @Override
    /**
     * 出库和入库回传
     */
    public void acceptProductInfoFromWMS(@WebParam(name = "INFDATA") INFDATA infoData) {
        log.info("WMS推送商品主数据:" + JsonUtil.bean2Json(infoData));
//        DATA result = new DATA();
//        List<RETDATA> retdataList = Lists.newArrayList();
//        RETDATA retdata = new RETDATA();
//        retdataList.add(retdata);
//        result.setRetdata(retdataList);
//        INFDATA infoData
        //出库回传出库
        if("WMS24".equals(infoData.getBASEINFO().getSERVICENAME())){
            System.out.printf("出库回传出库"+infoData.getMESSAGE().getARRAYSTRING().getInfmsg());
        }
        //出库取消的
        if("WMS32".equals(infoData.getBASEINFO().getSERVICENAME())){
            System.out.printf("出库取消的"+infoData.getMESSAGE().getARRAYSTRING().getInfmsg());
        }
    }




    /**
     * 订单下传回调物流信息
     * @param senddata
     */
    @Override
    public void sendBackFromWMS(@WebParam(name = "SENDDATA") SENDDATA senddata) {
        log.info("WMS推送发货商品主数据:" + JsonUtil.bean2Json(senddata));
        List<SENDRETDATA> sendretdataList = senddata.getSendRetdata();
        if(!CollectionUtils.isEmpty(sendretdataList)){
            for (SENDRETDATA sendretdata :sendretdataList){
                Integer wid = Integer.valueOf(sendretdata.getCARRIER_ID().substring(2));
                //发送成功
                tradeWmsService.updateTradeWmsStatus(sendretdata.getCARRIER_ID());
                //wid转化tid
                TidWid tidWid = tidWidService.selectTidWid(wid);
                //物流给有赞
                LogisticsOnlineConfirmParams logisticsOnlineConfirmParams = new LogisticsOnlineConfirmParams();
                logisticsOnlineConfirmParams.setTid(tidWid.getTid());
                logisticsOnlineConfirmParams.setOutSid(sendretdata.getLOGISTICS_CODE());
                logisticsOnlineConfirmParams.setOutStype(sendretdata.getCARRIER_NAME());
                logisticsOnlineConfirmService.confirm(logisticsOnlineConfirmParams);
            }
        }
    }

    /**
     * 取消订单 回调信息
     * @param canneldata
     */
    @Override
    public void cannelBackFromWMS(@WebParam(name = "CANNELDATA") CANNELDATA canneldata) {
        log.info("WMS推送取消商品主数据:" + JsonUtil.bean2Json(canneldata));
        List<CANNELRETDATA> cannelretdataList = canneldata.getCannelRetdata();
        if(!CollectionUtils.isEmpty(cannelretdataList)){
            for(CANNELRETDATA cannelretdata : cannelretdataList){

            }
        }

    }

}
