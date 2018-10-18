package com.tasly.yzpt.common.yzEnum;

public enum TradeEnum {

    trade_TradePaid("交易支付"), trade_TradeCreate("交易创建"), trade_TradeClose("交易关闭"), trade_TradeSuccess("交易成功"), trade_TradePartlySellerShip("卖家部分发货"), trade_TradeSellerShip("卖家发货"),
    trade_TradeBuyerPay("买家付款"), trade_TradeMemoModified("卖家修改交易备注");
    private final String content;

    private TradeEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
