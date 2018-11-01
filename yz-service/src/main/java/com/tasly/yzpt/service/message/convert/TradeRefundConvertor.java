package com.tasly.yzpt.service.message.convert;

import com.tasly.yzpt.common.entity.Trade.TradeRefundGetResult;
import com.tasly.yzpt.repository.message.entity.TradeRefund;

import java.math.BigDecimal;

public class TradeRefundConvertor {

    public static TradeRefund toBean(TradeRefundGetResult result) {
        TradeRefund tradeRefund = new TradeRefund();
        tradeRefund.setTid(result.getTid());
        tradeRefund.setOid(result.getOids());
        tradeRefund.setRefundId(result.getRefundId());
        tradeRefund.setRefundedFee(new BigDecimal(result.getRefundedFee()));
        tradeRefund.setRefundType(result.getRefundType());
        tradeRefund.setVersion(result.getVersion());
        tradeRefund.setUpdateTime(result.getUpdateTime());
        tradeRefund.setRefundReason(result.getRefundReason());
        return tradeRefund;
    }
}
