package com.tasly.yzpt.service.message.impl;


import com.alibaba.fastjson.JSON;
import com.tasly.yzpt.common.util.CglibBeanUtil;
import com.tasly.yzpt.repository.message.TradeAddressRepository;
import com.tasly.yzpt.repository.message.TradeInfoRepository;
import com.tasly.yzpt.repository.message.TradeItemRepository;
import com.tasly.yzpt.repository.message.TradePayRepository;
import com.tasly.yzpt.repository.message.entity.TradeAddress;
import com.tasly.yzpt.repository.message.entity.TradeInfo;
import com.tasly.yzpt.repository.message.entity.TradeItem;
import com.tasly.yzpt.repository.message.entity.TradePay;
import com.tasly.yzpt.service.message.OrderCreateService;
import com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Slf4j
public class OrderCreateServiceImpl implements OrderCreateService {

    @Autowired
    private TradeInfoRepository tradeInfoRepository;
    @Autowired
    private TradePayRepository tradePayRepository;
    @Autowired
    private TradeAddressRepository tradeAddressRepository;
    @Autowired
    private TradeItemRepository tradeItemRepository;
    @Autowired
    private LogisticsServiceImpl logisticsService;

    @Override
    @Transactional
    public void createOMSOrder(String msg) {
        log.info("youzan--->oms  create order param:" + msg);
        YouzanTradeGetResult youzanTradeGetResult = JSON.parseObject(msg, YouzanTradeGetResult.class);
        YouzanTradeGetResult.StructurizationTradeOrderInfo tradeOrderInfo = youzanTradeGetResult.getFullOrderInfo();
        String tid = tradeOrderInfo.getOrderInfo().getTid();
        saveOrderInfo(tradeOrderInfo.getOrderInfo());
        saveOrderItem(tradeOrderInfo.getOrders(), tid);
        savePayInfo(tradeOrderInfo.getPayInfo(), tid);
        saveAddressInfo(tradeOrderInfo.getAddressInfo(), tid);
        logisticsService.sendOrderInfo(tid);
    }

    /**
     * 交易基础信息
     * @param orderInfo
     */
    private void saveOrderInfo(YouzanTradeGetResult.StructurizationOrderInfoDetail orderInfo) {
        TradeInfo tradeInfo = new TradeInfo();
        CglibBeanUtil.copyProperties(orderInfo, tradeInfo);
        tradeInfoRepository.insert(tradeInfo);
        /**
         * status 主订单状态  WAIT_SELLER_SEND_GOODS（等待卖家发货，即：买家已付款）等 orderInfo.getStatus();
         */

        /**
         * type 主订单类型 0:普通订单; 1:送礼订单; 等 orderInfo.getType();
         */

        /**
         * tid 订单号
         */
        /**
         * status_str 主订单状态描述 orderInfo.getStatusStr();
         */

        /**
         * pay_type 支付类型 0:默认值,未支付; 1:微信自有支付; 2:支付宝wap; 3:支付宝wap; 5:财付通;等 orderInfo.getPayType();
         */

        /**
         * team_type 店铺类型 0:微商城; 1:微小店; 等 orderInfo.getTeamType();
         */

        /**
         * close_type 关闭类型 0:未关闭; 1:过期关闭; 2:标记退款; 3:订单取消; 4:买家取消; 5:卖家取消; 6:部分退款; 10:无法联系上买家; 等 orderInfo.getCloseType();
         */

        /**
         * express_type 物流类型 0:快递发货; 1:到店自提; 2:同城配送; 9:无需发货（虚拟商品订单）
         */
        /**
         *  order_tags 订单打标 orderInfo.getOrderTags();
         */

        /**
         * order_extra 订单扩展信息 orderInfo.getOrderExtra();
         */

        /**
         * created 订单创建时间
         */
        /**
         * update_time 订单更新时间 orderInfo.getUpdateTime();
         */

        /**
         * expired_time 订单过期时间（未付款将自动关单） orderInfo.getExpiredTime();
         */

        /**
         * pay_time 订单支付时间 orderInfo.getPayTime();
         */

        /**
         * consign_time 订单发货时间（当所有商品发货后才会更新） orderInfo.getConsignTime();
         */

        /**
         * confirm_time 订单确认时间（多人拼团成团） orderInfo.getConfirmTime();
         */

        /**
         * refund_state 退款状态 0:未退款; 1:部分退款中; 2:部分退款成功; 11:全额退款中; 12:全额退款成功 orderInfo.getRefundState();
         */

        /**
         * is_retail_order 是否零售订单 orderInfo.getIsRetailOrder();
         */

        /**
         * success_time 订单成功时间 orderInfo.getSuccessTime();
         */

        /**
         * offline_id 网点id orderInfo.getOfflineId();
         */

        /**
         * pay_type_str 支付类型。取值范围： WEIXIN (微信自有支付) WEIXIN_DAIXIAO (微信代销支付) ALIPAY (支付宝支付)等 orderInfo.getPayTypeStr();
         */

    }

    /**
     * 订单支付信息
     * @param payInfo
     */
    private void savePayInfo(YouzanTradeGetResult.StructurizationTradePayInfoDetail payInfo, String tid) {
        TradePay tradePay = new TradePay();
        CglibBeanUtil.copyProperties(payInfo, tradePay);
        tradePay.setTid(tid);
        tradePayRepository.insert(tradePay);
        /**
         * total_fee 优惠前商品总价
         */
        /**
         * post_fee 邮费
         */
        /**
         * payment 最终支付价格 payment=orders.payment的总和
         */
        /**
         * transaction 有赞支付流水号 payInfo.getTransaction();
         */

        /**
         * outer_transactions 外部支付单号 payInfo.getOuterTransactions();
         */
        /**
         * 订单级别折扣费用
         */
    }

    private void saveAddressInfo(YouzanTradeGetResult.StructurizationTradeAddressInfoDetail addressInfo, String tid) {
        TradeAddress tradeAddress = new TradeAddress();
        CglibBeanUtil.copyProperties(addressInfo, tradeAddress);
        tradeAddress.setTid(tid);
        tradeAddressRepository.insert(tradeAddress);
        /**
         * receiver_name 收货人姓名
         */
        /**
         * receiver_tel 收货人手机号
         */
        /**
         * delivery_province 省
         */
        /**
         * delivery_city 市
         */
        /**
         * delivery_district 区
         */
        /**
         * delivery_address 详细地址
         */
        /**
         * address_extra 字段为json格式，需要开发者自行解析 lng、lon（经纬度）； checkOutTime（酒店退房时间）； recipients（入住人）； checkInTime（酒店入住时间）； idCardNumber（海淘身份证信息）； areaCode（邮政编码）
         */
        /**
         * delivery_postal_code 邮政编码
         */
        /**
         * self_fetch_info 到店自提信息 json格式  addressInfo.getSelfFetchInfo();
         */

        /**
         * delivery_start_time 同城送预计送达时间-开始时间 非同城送以及没有开启定时达的订单不返回addressInfo.getDeliveryStartTime();
         */

        /**
         * delivery_end_time 同城送预计送达时间-结束时间 非同城送以及没有开启定时达的订单不返回 addressInfo.getDeliveryEndTime();
         */

    }

    /**
     * 交易明细
     * @param orders
     */
    private void saveOrderItem(YouzanTradeGetResult.StructurizationTradeItemDetail[] orders, String tid) {
        List<TradeItem> tradeItems = new ArrayList<TradeItem>();
        for(YouzanTradeGetResult.StructurizationTradeItemDetail order : orders) {
            TradeItem tradeItem = new TradeItem();
            CglibBeanUtil.copyProperties(order, tradeItem);
            tradeItem.setTid(tid);
            tradeItems.add(tradeItem);
        }
        for (TradeItem tradeItem : tradeItems){
            tradeItemRepository.insert(tradeItem);
        }
    }

}
