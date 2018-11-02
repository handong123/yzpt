package com.tasly.yzpt.webservices.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.collect.Lists;
import com.tasly.yzpt.common.util.JsonUtil;
import com.tasly.yzpt.common.yzEnum.ExpressEnum;
import com.tasly.yzpt.repository.message.entity.OidHanghao;
import com.tasly.yzpt.repository.message.entity.TidWid;
import com.tasly.yzpt.repository.message.entity.TradeLogistics;
import com.tasly.yzpt.service.message.*;
import com.tasly.yzpt.service.message.entity.LogisticsInfoEntity;
import com.tasly.yzpt.service.message.entity.LogisticsOnlineConfirmEntity;
import com.tasly.yzpt.service.wms.send.INFDATA;
import com.tasly.yzpt.webservices.ProductService;
import com.tasly.yzpt.webservices.dto.wmsreq.body.WmsBodyWrapper;
import com.tasly.yzpt.webservices.dto.wmsreq.body.WmsOrderBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.IOException;
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

    @Autowired
    TradeLogisticsService tradeLogisticsService;

    @Autowired
    OidHangHaoService oidHangHaoService;

    /**
     * 出库和出库取消回传
     */
    @Override
    public void acceptProductInfoFromWMS(@WebParam(name = "INFDATA") INFDATA infoData) {
        log.info("WMS回调主数据:" + JsonUtil.bean2Json(infoData));
        //出库回传出库 WMS24
        //出库取消的 WMS32
//        //出库回传出库
//        String type = infoData.getBASEINFO().getSERVICENAME();
//        if("WMS24".equals(infoData.getBASEINFO().getSERVICENAME())){
//            System.out.printf("出库回传出库"+infoData.getMESSAGE().getARRAYSTRING().getInfmsg());
//        }
//        //出库取消的
//        if("WMS32".equals(infoData.getBASEINFO().getSERVICENAME())){
//            System.out.printf("出库取消的"+infoData.getMESSAGE().getARRAYSTRING().getInfmsg());
//        }
        String infoMsg;
        try {
            infoMsg = infoData.getMESSAGE().getARRAYSTRING().getInfmsg().replace("<ARRAYOFT_CK_SC>", "").replace("</ARRAYOFT_CK_SC>", "");
            XmlMapper mapper = new XmlMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            WmsBodyWrapper bodyWrapper = mapper.readValue(infoMsg, WmsBodyWrapper.class);
            List<WmsOrderBo> cannelretdataList = bodyWrapper.getList();
            //去掉前面2个YZ字符串
            Integer wid = Integer.valueOf(bodyWrapper.getDANJ_NO().substring(2));
            //wid转化tid
            TidWid tidWid = tidWidService.selectTidWid(wid);
            List<TradeLogistics> tradeLogisticss = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(cannelretdataList)){
                for(WmsOrderBo wmsOrderBo:cannelretdataList){
                    //查询通过TID和行号查询oidhanghao对象
                    OidHanghao oidHanghao =oidHangHaoService.SelectOidHanghaoByTidAndHanghao(tidWid.getTid(),wmsOrderBo.getHANGHAO());
                    //保存到本地物流信息
                    TradeLogistics tradeLogistics = new TradeLogistics();
                    tradeLogistics.setTid(tidWid.getTid());
                    tradeLogistics.setLogisticsNumber(wmsOrderBo.getYUNDAN_NO());
                    tradeLogistics.setLogisticsCode(ExpressEnum.getYzExpressCode(wmsOrderBo.getCARRIER_ID()));
                    tradeLogistics.setOid(oidHanghao.getOid());
                    tradeLogisticss.add(tradeLogistics);
                    tradeLogisticsService.saveLogistics(tradeLogistics);
                }
            }
            //发送有赞物流
            logisticsOnlineConfirmService.confirm(tradeLogisticss);
        } catch (NullPointerException e) {
            log.error("WMS推送信息错误");
        } catch (IOException e) {
            log.error("解析出现错误");
        }

    }

    public static void main(String[] args) {
        String infoMsgt = "<ARRAYOFT_CK_KPD_DEL_SC><T_CK_KPD_DEL_SC><DANJ_NO>00000000000003</DANJ_NO><WLZX_CODE>1201</WLZX_CODE><HUOZ_ID>1017</HUOZ_ID><RIQI_DATE>20180822</RIQI_DATE><YEW_STAFF>自动生成</YEW_STAFF><STATUS>N</STATUS><DANJ_NO_Y>YZ0000000016</DANJ_NO_Y><DANJ_MX><MINGXI><HANGHAO>10</HANGHAO><HANGHAO_Y>10</HANGHAO_Y><NUM>0</NUM></MINGXI><MINGXI><HANGHAO>900001</HANGHAO><HANGHAO_Y>900001</HANGHAO_Y><NUM>4500</NUM></MINGXI></DANJ_MX><NOTE></NOTE><TIAOM_NUM>2</TIAOM_NUM><ZT>N</ZT><DANJ_NO_NC></DANJ_NO_NC></T_CK_KPD_DEL_SC></ARRAYOFT_CK_KPD_DEL_SC>";
        try {
            String infoMsg = infoMsgt.replace("<ARRAYOFT_CK_SC>", "").replace("</ARRAYOFT_CK_SC>", "");
            XmlMapper mapper = new XmlMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            WmsBodyWrapper bodyWrapper = mapper.readValue(infoMsg, WmsBodyWrapper.class);
            List<WmsOrderBo> cannelretdataList = bodyWrapper.getList();
            System.out.println(bodyWrapper.getDANJ_NO());
            System.out.println(bodyWrapper.getWLZX_CODE());
            if(!CollectionUtils.isEmpty(cannelretdataList)){
                for(WmsOrderBo wmsOrderBo:cannelretdataList){
                    System.out.println(wmsOrderBo.getHANGHAO());
                    System.out.println(wmsOrderBo.getNUM());
                }
            }
        } catch (NullPointerException e) {
            log.error("WMS推送信息错误");
        } catch (IOException e) {
            log.error("解析出现错误");
        }
    }
}
