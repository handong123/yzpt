package com.tasly.yzpt.service.message.impl;


import com.tasly.yzpt.common.entity.MsgPushEntity;
import com.tasly.yzpt.common.keystone.MD5;
import com.tasly.yzpt.common.keystone.YZKeystone;
import com.tasly.yzpt.common.yzEnum.TradeEnum;
import com.tasly.yzpt.common.yzEnum.TradeRefundEnum;
import com.tasly.yzpt.service.message.AsyncParserService;
import com.tasly.yzpt.service.message.CancelOrderService;
import com.tasly.yzpt.service.message.OrderCreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


@Slf4j
@Service
public class AsyncParserServiceImpl implements AsyncParserService {

    @Autowired
    private YZKeystone yzKeystone;

    @Autowired
    private OrderCreateService orderCreateService;

    @Autowired
    private CancelOrderService cancelOrderService;

    @Override
    @Async(value = "asyncServiceExecutor")
    public void asyncParserMessage(MsgPushEntity entity) {
        log.info("------begin invok asyncParserMessage()------" + Thread.currentThread().getId() + "   " + Thread.currentThread().getName());
        /**
         * 判断消息是否合法
         * 解析sign
         * MD5 工具类开发者可以自行引入
         */
        String sign = MD5.digest(yzKeystone.getClientId() + entity.getMsg() + yzKeystone.getClientSecret());
        if (!sign.equals(entity.getSign())) {
            log.error("非法消息" + entity.toString());
        }

        /**
         * 对于msg 先进行URI解码
         */
        String msg = "";
        try {
            msg = URLDecoder.decode(entity.getMsg(), "utf-8");
            log.info("------解码后信息------" + msg);
        } catch (UnsupportedEncodingException e) {
            log.error("------解码异常------" + e);
            e.printStackTrace();
        }

        /**
         *  ..........
         *  接下来是一些业务处理
         *  判断当前消息的类型 比如交易
         *
         */
        log.info("------交易类型------" + entity.getType());
        if (TradeEnum.trade_TradeBuyerPay.name().equals(entity.getType())) {
            orderCreateService.createOMSOrder(msg);
        } else if (TradeRefundEnum.trade_refund_RefundSellerAgree.name().equals(entity.getType())) {
            cancelOrderService.cancelOMSOrder(msg);
        } else if (TradeRefundEnum.trade_refund_RefundSellerAgreeReturnGoods.name().equals(entity.getType())) {
            cancelOrderService.goodsReturn(msg);
        }

        log.info("------end invok asyncParserMessage()------" + Thread.currentThread().getId() + "   " + Thread.currentThread().getName());

    }
}
