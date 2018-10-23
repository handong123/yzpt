package com.tasly.yzpt.service.message.impl;

import com.tasly.yzpt.common.token.YZToken;
import com.tasly.yzpt.service.message.LogisticsOnlineConfirmService;
import com.youzan.open.sdk.client.auth.Token;
import com.youzan.open.sdk.client.core.DefaultYZClient;
import com.youzan.open.sdk.client.core.YZClient;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanLogisticsOnlineConfirmParams;
import com.youzan.open.sdk.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 物流信息回传
 */
@Service
@Slf4j
public class LogisticsOnlineConfirmServiceImpl implements LogisticsOnlineConfirmService {

    @Override
    @Transactional
    public void confirm() {

        log.info("");

        YZClient client = new DefaultYZClient(new Token(YZToken.getToken()));
        YouzanLogisticsOnlineConfirmParams youzanLogisticsOnlineConfirmParams = new YouzanLogisticsOnlineConfirmParams();

        // 交易订单号
        youzanLogisticsOnlineConfirmParams.setTid(taslyOrder.getOriginalOrderId());
        // 物流公司编号，可以通过请求 youzan.logistics.express.get 该接口获得
        youzanLogisticsOnlineConfirmParams.setOutStype(expressService.getExpressByCode(
                expressCode).getB2B2_code());
        // 快递单号（具体一个物流公司的真实快递单号）
        youzanLogisticsOnlineConfirmParams.setOutSid(expressNumber);

        YouzanLogisticsOnlineConfirm youzanLogisticsOnlineConfirm = new YouzanLogisticsOnlineConfirm();
        youzanLogisticsOnlineConfirm.setAPIParams(youzanLogisticsOnlineConfirmParams);
        String result = client.execute(youzanLogisticsOnlineConfirm);
        Response response = JSON.parseObject(result, Response.class);
        if (response.getErrorResponse() == null) {
            YouzanLogisticsOnlineConfirmResult confirmResult = JSON.parseObject(response.getResponse().toString(),
                    YouzanLogisticsOnlineConfirmResult.class);
            isSuccess = confirmResult.getIsSuccess();
            LOG.info("----上传 B2B_2 物流信息成功----");
        } else {
            LOG.info("----上传 B2B_2 物流信息失败：-----" + response.getErrorResponse());
        }

        log.info("结束上传 B2B_2 平台物流信息,店铺=" + taslyOrder.getStoreCode());
    }
}
