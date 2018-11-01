package com.tasly.yzpt.service.message.impl;

import com.tasly.yzpt.common.token.YZToken;
import com.tasly.yzpt.repository.message.TradeRefundRepository;
import com.tasly.yzpt.repository.message.entity.TradeRefund;
import com.tasly.yzpt.service.message.TradeRefundService;
import com.tasly.yzpt.service.message.entity.CancelOrderEntity;
import com.tasly.yzpt.service.message.entity.TradeRefundEntity;
import com.youzan.open.sdk.client.auth.Token;
import com.youzan.open.sdk.client.core.DefaultYZClient;
import com.youzan.open.sdk.client.core.YZClient;
import com.youzan.open.sdk.gen.v3_0_0.api.YouzanTradeRefundAgree;
import com.youzan.open.sdk.gen.v3_0_0.api.YouzanTradeRefundRefuse;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradeRefundAgreeParams;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradeRefundAgreeResult;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradeRefundRefuseParams;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradeRefundRefuseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class TradeRefundServiceImpl implements TradeRefundService {
    @Autowired
    private TradeRefundRepository tradeRefundRepository;

    /**
     * 商家拒绝退款
     */
    @Override
    @Transactional
    public void refuse(TradeRefundEntity entity) {
        TradeRefund tradeRefund = tradeRefundRepository.selectByPrimaryKey(entity.getRefundId());

        YZClient client = new DefaultYZClient(new Token(YZToken.getToken())); //new Sign(appKey, appSecret)
        YouzanTradeRefundRefuseParams youzanTradeRefundRefuseParams = new YouzanTradeRefundRefuseParams();

        youzanTradeRefundRefuseParams.setRemark(entity.getMessage());
        youzanTradeRefundRefuseParams.setRefundId(tradeRefund.getRefundId());
        youzanTradeRefundRefuseParams.setVersion(Long.getLong(tradeRefund.getVersion()));

        YouzanTradeRefundRefuse youzanTradeRefundRefuse = new YouzanTradeRefundRefuse();
        youzanTradeRefundRefuse.setAPIParams(youzanTradeRefundRefuseParams);
        YouzanTradeRefundRefuseResult result = client.invoke(youzanTradeRefundRefuse);


    }

    /**
     * 商家同意退款
     */
    @Override
    @Transactional
    public void agree(TradeRefundEntity entity) {
        TradeRefund tradeRefund = tradeRefundRepository.selectByPrimaryKey(entity.getRefundId());

        YZClient client = new DefaultYZClient(new Token(YZToken.getToken())); //new Sign(appKey, appSecret)
        YouzanTradeRefundAgreeParams youzanTradeRefundAgreeParams = new YouzanTradeRefundAgreeParams();

        youzanTradeRefundAgreeParams.setRefundId(tradeRefund.getRefundId());
        youzanTradeRefundAgreeParams.setVersion(Long.getLong(tradeRefund.getVersion()));

        YouzanTradeRefundAgree youzanTradeRefundAgree = new YouzanTradeRefundAgree();
        youzanTradeRefundAgree.setAPIParams(youzanTradeRefundAgreeParams);
        YouzanTradeRefundAgreeResult result = client.invoke(youzanTradeRefundAgree);

    }
}
