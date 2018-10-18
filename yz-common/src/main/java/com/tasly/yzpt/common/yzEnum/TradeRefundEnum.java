package com.tasly.yzpt.common.yzEnum;

public enum TradeRefundEnum {
    trade_refund_RefundSellerCreated("卖家主动退款"), trade_refund_YouzanInterApplied("买家申请客服介入"),

    trade_refund_RefundSellerAgree("卖家同意退款（终态）"), trade_refund_RefundSellerAgreeReturnGoods("卖家同意退款退货"),

    trade_refund_RefundBuyerReturnGoods("买家退货给卖家"), trade_refund_RefundSellerRefuseBuyerReturnGoods("卖家拒绝退货"),

    trade_refund_RefundClosed("买家取消退款"), trade_TradeMemoModified("买家退货成功（终态）"),

    trade_refund_SysRefund("一键退款/系统退款"), trade_refund_BuyerCreated("买家发起退款");

    private final String content;

    private TradeRefundEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
