package com.tasly.yzpt.service.message.impl;


import com.alibaba.fastjson.JSON;
import com.tasly.yzpt.repository.message.*;
import com.tasly.yzpt.repository.message.entity.*;
import com.tasly.yzpt.service.event.OrderToWmsPrepareEvent;
import com.tasly.yzpt.service.message.OrderCreateService;
import com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private TidWidRepository tidWidRepository;
    @Autowired
    private OidHanghaoRepository oidHanghaoRepository;
    @Autowired
    private ApplicationContext applicationContext;

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
        saveWid(tid);
        applicationContext.publishEvent(new OrderToWmsPrepareEvent(this, tid));
    }

    /**
     * tid_wid
     */
    private void saveWid(String tid) {
        TidWid tidWid = new TidWid();
        tidWid.setTid(tid);
        tidWidRepository.insertSelective(tidWid);
    }

    /**
     * 交易基础信息
     *
     * @param orderInfo
     */
    private void saveOrderInfo(YouzanTradeGetResult.StructurizationOrderInfoDetail orderInfo) {
        TradeInfo tradeInfo = new TradeInfo();
        /**
         * status 主订单状态  WAIT_SELLER_SEND_GOODS（等待卖家发货，即：买家已付款）等 orderInfo.getStatus();
         */
        tradeInfo.setStatus(orderInfo.getStatus());
        /**
         * type 主订单类型 0:普通订单; 1:送礼订单; 等 orderInfo.getType();
         */
        tradeInfo.setType(orderInfo.getType().intValue());
        /**
         * tid 订单号
         */
        tradeInfo.setTid(orderInfo.getTid());
        /**
         * status_str 主订单状态描述 orderInfo.getStatusStr();
         */
        tradeInfo.setStatusStr(orderInfo.getStatusStr());
        /**
         * pay_type 支付类型 0:默认值,未支付; 1:微信自有支付; 2:支付宝wap; 3:支付宝wap; 5:财付通;等 orderInfo.getPayType();
         */
        tradeInfo.setPayType(orderInfo.getPayType().intValue());
        /**
         * team_type 店铺类型 0:微商城; 1:微小店; 等 orderInfo.getTeamType();
         */
        tradeInfo.setTeamType(orderInfo.getTeamType().intValue());
        /**
         * close_type 关闭类型 0:未关闭; 1:过期关闭; 2:标记退款; 3:订单取消; 4:买家取消; 5:卖家取消; 6:部分退款; 10:无法联系上买家; 等 orderInfo.getCloseType();
         */
        tradeInfo.setCloseType(orderInfo.getCloseType().intValue());
        /**
         * express_type 物流类型 0:快递发货; 1:到店自提; 2:同城配送; 9:无需发货（虚拟商品订单）
         */
        tradeInfo.setExpressType(orderInfo.getExpressType().intValue());
        /**
         *  order_tags 订单打标 orderInfo.getOrderTags();
         */

        /**
         * order_extra 订单扩展信息 orderInfo.getOrderExtra();
         */

        /**
         * created 订单创建时间
         */
        tradeInfo.setCreatedTime(orderInfo.getCreated());
        /**
         * update_time 订单更新时间 orderInfo.getUpdateTime();
         */
        tradeInfo.setUpdateTime(orderInfo.getUpdateTime());
        /**
         * expired_time 订单过期时间（未付款将自动关单） orderInfo.getExpiredTime();
         */
        tradeInfo.setExpiredTime(orderInfo.getExpiredTime());
        /**
         * pay_time 订单支付时间 orderInfo.getPayTime();
         */
        tradeInfo.setPayTime(orderInfo.getPayTime());
        /**
         * consign_time 订单发货时间（当所有商品发货后才会更新） orderInfo.getConsignTime();
         */
        tradeInfo.setConsignTime(orderInfo.getConsignTime());
        /**
         * confirm_time 订单确认时间（多人拼团成团） orderInfo.getConfirmTime();
         */
        tradeInfo.setConfirmTime(orderInfo.getConfirmTime());
        /**
         * refund_state 退款状态 0:未退款; 1:部分退款中; 2:部分退款成功; 11:全额退款中; 12:全额退款成功 orderInfo.getRefundState();
         */
        tradeInfo.setRefundState(orderInfo.getRefundState().intValue());
        /**
         * is_retail_order 是否零售订单 orderInfo.getIsRetailOrder();
         */
        tradeInfo.setIsRetailOrder(orderInfo.getIsRetailOrder());
        /**
         * success_time 订单成功时间 orderInfo.getSuccessTime();
         */
        tradeInfo.setSuccessTime(orderInfo.getSuccessTime());
        /**
         * offline_id 网点id orderInfo.getOfflineId();
         */
        tradeInfo.setOfflineId(orderInfo.getOfflineId() == null ? 0 : orderInfo.getOfflineId().intValue());
        /**
         * pay_type_str 支付类型。取值范围： WEIXIN (微信自有支付) WEIXIN_DAIXIAO (微信代销支付) ALIPAY (支付宝支付)等 orderInfo.getPayTypeStr();
         */
        tradeInfo.setPayTypeStr(orderInfo.getPayTypeStr());
        tradeInfoRepository.insert(tradeInfo);
    }

    /**
     * 订单支付信息
     *
     * @param payInfo
     */
    private void savePayInfo(YouzanTradeGetResult.StructurizationTradePayInfoDetail payInfo, String tid) {
        TradePay tradePay = new TradePay();

        tradePay.setTid(tid);
        /**
         * total_fee 优惠前商品总价
         */
        tradePay.setTotalFee(new BigDecimal(payInfo.getTotalFee()));
        /**
         * post_fee 邮费
         */
        tradePay.setPostFee(new BigDecimal(payInfo.getPostFee()));
        /**
         * payment 最终支付价格 payment=orders.payment的总和
         */
        tradePay.setPayment(new BigDecimal(payInfo.getPayment()));
        /**
         * transaction 有赞支付流水号 payInfo.getTransaction();
         */
        tradePay.setTransaction(Arrays.stream(payInfo.getTransaction()).map(i -> i.toString() + "/").reduce("", String::concat));
        /**
         * outer_transactions 外部支付单号 payInfo.getOuterTransactions();
         */
        tradePay.setOuterTransactions(Arrays.stream(payInfo.getOuterTransactions()).map(i -> i.toString() + "/").reduce("", String::concat));
        /**
         * 订单级别折扣费用
         */
        tradePayRepository.insert(tradePay);
    }

    private void saveAddressInfo(YouzanTradeGetResult.StructurizationTradeAddressInfoDetail addressInfo, String tid) {
        TradeAddress tradeAddress = new TradeAddress();
        tradeAddress.setTid(tid);

        /**
         * receiver_name 收货人姓名
         */
        tradeAddress.setReceiverName(addressInfo.getReceiverName());
        /**
         * receiver_tel 收货人手机号
         */
        tradeAddress.setReceiverTel(addressInfo.getReceiverTel());
        /**
         * delivery_province 省
         */
        tradeAddress.setDeliveryProvince(addressInfo.getDeliveryProvince());
        /**
         * delivery_city 市
         */
        tradeAddress.setDeliveryCity(addressInfo.getDeliveryCity());
        /**
         * delivery_district 区
         */
        tradeAddress.setDeliveryDistrict(addressInfo.getDeliveryDistrict());
        /**
         * delivery_address 详细地址
         */
        tradeAddress.setDeliveryAddress(addressInfo.getDeliveryAddress());
        /**
         * address_extra 字段为json格式，需要开发者自行解析 lng、lon（经纬度）； checkOutTime（酒店退房时间）； recipients（入住人）； checkInTime（酒店入住时间）； idCardNumber（海淘身份证信息）； areaCode（邮政编码）
         */
        tradeAddress.setAddressExtra(addressInfo.getAddressExtra());
        /**
         * delivery_postal_code 邮政编码
         */
        tradeAddress.setDeliveryPostalCode(addressInfo.getDeliveryPostalCode());
        /**
         * self_fetch_info 到店自提信息 json格式  addressInfo.getSelfFetchInfo();
         */
        tradeAddress.setSelfFetchInfo(addressInfo.getSelfFetchInfo());
        /**
         * delivery_start_time 同城送预计送达时间-开始时间 非同城送以及没有开启定时达的订单不返回addressInfo.getDeliveryStartTime();
         */
        tradeAddress.setDeliveryStartTime(addressInfo.getDeliveryStartTime());
        /**
         * delivery_end_time 同城送预计送达时间-结束时间 非同城送以及没有开启定时达的订单不返回 addressInfo.getDeliveryEndTime();
         */
        tradeAddress.setDeliveryEndTime(addressInfo.getDeliveryEndTime());
        tradeAddressRepository.insert(tradeAddress);
    }

    /**
     * 交易明细
     *
     * @param orders
     */
    private void saveOrderItem(YouzanTradeGetResult.StructurizationTradeItemDetail[] orders, String tid) {
        List<TradeItem> tradeItems = new ArrayList<TradeItem>();
        List<OidHanghao> oidHanghaos = new ArrayList<>();
        int num = 1;
        for (YouzanTradeGetResult.StructurizationTradeItemDetail order : orders) {
            TradeItem tradeItem = new TradeItem();
            item(order, tradeItem);
            tradeItem.setTid(tid);
            tradeItems.add(tradeItem);

            OidHanghao oidHanghao = new OidHanghao();
            oidHanghao.setTid(tid);
            oidHanghao.setOid(order.getOid());
            oidHanghao.setHanghao(String.valueOf(num));
            oidHanghaos.add(oidHanghao);

            num = num + 1;
        }
        for (TradeItem tradeItem : tradeItems) {
            tradeItemRepository.insertSelective(tradeItem);
        }

        for (OidHanghao oidHanghao : oidHanghaos) {
            oidHanghaoRepository.insertSelective(oidHanghao);
        }
    }

    private void item(YouzanTradeGetResult.StructurizationTradeItemDetail source, TradeItem target) {
        /**
         * oid 订单明细id
         */
        target.setOid(source.getOid());
        /**
         * item_type 订单类型 0:普通类型商品
         */
        target.setItemType(source.getItemType().intValue());
        /**
         * title 商品名称
         */
        target.setTitle(source.getTitle());
        /**
         * num 商品数量
         */
        target.setNum(source.getNum().intValue());
        /**
         * outer_sku_id 商家编码
         */
        target.setOuterSkuId(source.getOuterSkuId());
        /**
         * buyer_messages 商品留言
         */
        target.setBuyerMessages(source.getBuyerMessages());
        /**
         * price 单商品原价
         */
        target.setPrice(new BigDecimal(source.getPrice()));
        /**
         * total_fee 商品优惠后总价
         */
        target.setTotalFee(new BigDecimal(source.getTotalFee()));
        /**
         * payment 商品最终均摊价
         */
        target.setPayment(new BigDecimal(source.getPayment()));
        /**
         * item_id 商品id
         */
        target.setItemId(source.getItemId().intValue());
        /**
         * sku_id 规格id（无规格商品为0）
         */
        target.setSkuId(source.getSkuId().intValue());
        /**
         * sku_properties_name 规格信息（无规格商品为空）
         */
        target.setSkuPropertiesName(source.getSkuPropertiesName());
        /**
         * outer_item_id 商品编码
         */
        target.setOuterItemId(source.getOuterItemId());
        /**
         * points_price 商品积分价（非积分商品则为0）
         */
        target.setPointsPrice(source.getPointsPrice());
        /**
         * pic_path 商品图片地址
         */
        target.setPicPath(source.getPicPath());
        /**
         * goods_url 商品详情链接
         */
        target.setGoodsUrl(source.getGoodsUrl());
        /**
         * alias 商品别名
         */
        target.setAlias(source.getAlias());
        /**
         * is_present 是否赠品
         */
        target.setIsPresent(source.getIsPresent());
    }
}
