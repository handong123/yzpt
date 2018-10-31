package com.tasly.yzpt.service.message.convert;

import com.tasly.yzpt.repository.message.entity.TradeRefund;
import com.youzan.open.sdk.gen.v3_0_0.model.YouzanTradeRefundGetResult;

import java.math.BigDecimal;

public class TradeRefundConvertor {

    public static TradeRefund toBean(YouzanTradeRefundGetResult result){
        TradeRefund tradeRefund =  new TradeRefund();
        tradeRefund.setTid(result.getTid());
        tradeRefund.setOid(result.getOid());
        tradeRefund.setRefundId(result.getRefundId());
        tradeRefund.setRefundedFee(new BigDecimal(result.getRefundFee()));
        tradeRefund.setRefundType(result.getRefundType());
        tradeRefund.setVersion(String.valueOf(result.getVersion()));
        return tradeRefund;
    }
}
