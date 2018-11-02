package com.tasly.yzpt.service.message.impl;

import com.alibaba.fastjson.JSON;
import com.tasly.yzpt.common.entity.LogisticsOnline.Response;
import com.tasly.yzpt.common.token.YZToken;
import com.tasly.yzpt.repository.message.entity.TradeLogistics;
import com.tasly.yzpt.service.message.LogisticsOnlineConfirmService;
import com.tasly.yzpt.service.message.entity.LogisticsInfoEntity;
import com.tasly.yzpt.service.message.entity.LogisticsOnlineConfirmEntity;
import com.youzan.open.sdk.client.auth.Token;
import com.youzan.open.sdk.client.core.DefaultYZClient;
import com.youzan.open.sdk.client.core.YZClient;
import com.youzan.open.sdk.gen.v3_0_0.api.YouzanLogisticsOnlineConfirm;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanLogisticsOnlineConfirmParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 物流信息回传
 */
@Service
@Slf4j
public class LogisticsOnlineConfirmServiceImpl implements LogisticsOnlineConfirmService {

    @Override
    @Transactional
    public void confirm(LogisticsOnlineConfirmEntity entity) {
        log.info("----上传物流信息----" + entity.toString());

        List<YouzanLogisticsOnlineConfirmParams> paramList = new ArrayList<>();
        for(LogisticsInfoEntity logisticsInfoEntity:entity.getLogisticsInfoEntityList()){
            YouzanLogisticsOnlineConfirmParams youzanLogisticsOnlineConfirmParams = new YouzanLogisticsOnlineConfirmParams();
            // 交易订单号
            youzanLogisticsOnlineConfirmParams.setTid(entity.getTid());
            // 物流公司编号，可以通过请求 youzan.logistics.express.get 该接口获得  默认韵达
            youzanLogisticsOnlineConfirmParams.setOutStype(logisticsInfoEntity.getOutStype());
            // 快递单号（具体一个物流公司的真实快递单号）
            youzanLogisticsOnlineConfirmParams.setOutSid(logisticsInfoEntity.getOutSid());
            youzanLogisticsOnlineConfirmParams.setOids(logisticsInfoEntity.getOid());
            paramList.add(youzanLogisticsOnlineConfirmParams);
        }


        YZClient client = new DefaultYZClient(new Token(YZToken.getToken()));
        for(YouzanLogisticsOnlineConfirmParams youzanLogisticsOnlineConfirmParams:paramList){
            YouzanLogisticsOnlineConfirm youzanLogisticsOnlineConfirm = new YouzanLogisticsOnlineConfirm();
            youzanLogisticsOnlineConfirm.setAPIParams(youzanLogisticsOnlineConfirmParams);
            String result = client.execute(youzanLogisticsOnlineConfirm);

            Response response = JSON.parseObject(result, Response.class);
            if (response.getErrorResponse() == null) {
                log.info("----上传物流信息成功----" + entity + "------" + response.getIsSuccess());
            } else {
                log.info("----上传物流信息失败：-----" + entity + "------" + response.getErrorResponse());
            }
        }

    }

    @Override
    public void confirm(List<TradeLogistics> TradeLogisticsList) {
        log.info("----上传物流信息----");

        List<YouzanLogisticsOnlineConfirmParams> paramList = new ArrayList<>();
        for(TradeLogistics tradeLogistics:TradeLogisticsList){
            YouzanLogisticsOnlineConfirmParams youzanLogisticsOnlineConfirmParams = new YouzanLogisticsOnlineConfirmParams();
            // 交易订单号
            youzanLogisticsOnlineConfirmParams.setTid(tradeLogistics.getTid());
            // 物流公司编号，可以通过请求 youzan.logistics.express.get 该接口获得  默认韵达
            youzanLogisticsOnlineConfirmParams.setOutStype(tradeLogistics.getLogisticsCode());
            // 快递单号（具体一个物流公司的真实快递单号）
            youzanLogisticsOnlineConfirmParams.setOutSid(tradeLogistics.getLogisticsNumber());
            youzanLogisticsOnlineConfirmParams.setOids(tradeLogistics.getOid());
            paramList.add(youzanLogisticsOnlineConfirmParams);
        }


        YZClient client = new DefaultYZClient(new Token(YZToken.getToken()));
        for(YouzanLogisticsOnlineConfirmParams youzanLogisticsOnlineConfirmParams:paramList){
            YouzanLogisticsOnlineConfirm youzanLogisticsOnlineConfirm = new YouzanLogisticsOnlineConfirm();
            youzanLogisticsOnlineConfirm.setAPIParams(youzanLogisticsOnlineConfirmParams);
            String result = client.execute(youzanLogisticsOnlineConfirm);

            Response response = JSON.parseObject(result, Response.class);
            if (response.getErrorResponse() == null) {
                log.info("----上传物流信息成功----" + "------" + response.getIsSuccess());
            } else {
                log.info("----上传物流信息失败：-----" + "------" + response.getErrorResponse());
            }
        }
    }
}
