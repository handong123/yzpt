package com.tasly.yzpt.service.message.impl;


import com.alibaba.fastjson.JSON;
import com.galaxy.pop.api.client.model.Trade;
import com.tasly.oms.common.util.StringUtil;
import com.tasly.oms.domain.order.*;
import com.tasly.oms.domain.types.Amount;
import com.tasly.oms.domain.types.Quantity;
import com.tasly.oms.order.rest.OrderResourceImpl;
import com.tasly.oms.order.rest.ResponseDTO;
import com.tasly.oms.order.service.TaslyOrderService;
import com.tasly.oms.thirdparty.order.OrderConstants;
import com.tasly.oms.youzan.service.OrderCreateService;
import com.tasly.yzpt.service.message.OrderCreateService;
import com.youzan.open.sdk.gen.v4_0_0.model.YouzanTradeGetResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderCreateServiceImpl implements OrderCreateService {

    @Autowired
    private OrderResourceImpl orderResource;

    @Resource(name = "taslyOrderServiceImpl")
    TaslyOrderService<Trade> taslyOrderTmallServiceImpl;

    @Override
    @Transactional
    public void createOMSOrder(String msg) {
        log.info("youzan--->oms  create order param:" + msg);
        YouzanTradeGetResult youzanTradeGetResult = JSON.parseObject(msg, YouzanTradeGetResult.class);
        YouzanTradeGetResult.StructurizationTradeOrderInfo tradeOrderInfo = youzanTradeGetResult.getFullOrderInfo();
        TaslyOrder taslyOrderByOrgOrderId = taslyOrderTmallServiceImpl.getTaslyOrderByOrgOrderId(tradeOrderInfo.getOrderInfo().getTid());
        if (taslyOrderByOrgOrderId == null) {
            List<TaslyOrder> taslyOrderList = convert(tradeOrderInfo);
            ResponseDTO<String> responseDTO = orderResource.createOMSOrder(taslyOrderList);
            log.info(responseDTO.getMessage());
        }
    }

    private List<TaslyOrder> convert(YouzanTradeGetResult.StructurizationTradeOrderInfo tradeOrderInfo) {
        List<TaslyOrder> taslyOrderList = new ArrayList<>();
        TaslyOrder taslyOrder = new TaslyOrder();

        //------order_info 交易基础信息------
        YouzanTradeGetResult.StructurizationOrderInfoDetail orderInfo = tradeOrderInfo.getOrderInfo();
        orderInfo(orderInfo, taslyOrder);

        //------source_info 交易来源信息------
        //YouzanTradeGetResult.StructurizationTradeSourceInfo sourceInfo = tradeOrderInfo.getSourceInfo();
        //sourceInfo(sourceInfo, taslyOrder);

        //------buyer_info 订单买家信息------
        YouzanTradeGetResult.StructurizationTradeBuyerInfoDetail buyerInfo = tradeOrderInfo.getBuyerInfo();
        buyerInfo(buyerInfo, taslyOrder);

        //------pay_info 订单支付信息------
        YouzanTradeGetResult.StructurizationTradePayInfoDetail payInfo = tradeOrderInfo.getPayInfo();
        payInfo(payInfo, taslyOrder);

        //------remark_info 标记信息------
        YouzanTradeGetResult.StructurizationTradeRemarkInfoDetail remarkInfo = tradeOrderInfo.getRemarkInfo();
        remarkInfo(remarkInfo, taslyOrder);

        //------address_info 收货地址信息------
        YouzanTradeGetResult.StructurizationTradeAddressInfoDetail addressInfo = tradeOrderInfo.getAddressInfo();
        addressInfo(addressInfo, taslyOrder);

        //------orders 交易明细结------
        YouzanTradeGetResult.StructurizationTradeItemDetail[] orders = tradeOrderInfo.getOrders();
        orders(orders, taslyOrder);

        //------child_info 送礼订单子单------
        //YouzanTradeGetResult.StructurizationTradeChildOrderInfo childInfo = tradeOrderInfo.getChildInfo();
        //childInfo(childInfo, taslyOrder);

        //------youzan 信息补充------
        addOther(taslyOrder);
        taslyOrderList.add(taslyOrder);
        return taslyOrderList;
    }

    private void orderInfo(YouzanTradeGetResult.StructurizationOrderInfoDetail orderInfo, TaslyOrder taslyOrder) {
        /**
         * status 主订单状态  WAIT_SELLER_SEND_GOODS（等待卖家发货，即：买家已付款）等 orderInfo.getStatus();
         */

        /**
         * type 主订单类型 0:普通订单; 1:送礼订单; 等 orderInfo.getType();
         */

        /**
         * tid 订单号
         */
        taslyOrder.setOriginalOrderId(orderInfo.getTid());
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
        orderInfo.getExpressType();
        taslyOrder.setDeliveryService(DeliveryServiceType.EXPRESS);
        /**
         *  order_tags 订单打标 orderInfo.getOrderTags();
         */

        /**
         * order_extra 订单扩展信息 orderInfo.getOrderExtra();
         */

        /**
         * created 订单创建时间
         */
        taslyOrder.setOriginalOrderCreatedTime(orderInfo.getCreated());
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

    private void sourceInfo(YouzanTradeGetResult.StructurizationTradeSourceInfo sourceInfo, TaslyOrder taslyOrder) {
        /**
         * 平台 wx:微信; merchant_3rd:商家自有app; buyer_v:买家版; browser:系统浏览器; alipay:支付宝;qq:腾讯QQ; wb:微博; other:其他 sourceInfo.getSource().getPlatform();
         */

        /**
         * 微信平台细分 wx_gzh:微信公众号; yzdh:有赞大号; merchant_xcx:商家小程序; yzdh_xcx:有赞大号小程序; direct_buy:直接购买 sourceInfo.getSource().getWxEntrance();
         */

    }

    private void buyerInfo(YouzanTradeGetResult.StructurizationTradeBuyerInfoDetail buyerInfo, TaslyOrder taslyOrder) {
        /**
         * buyer_id 买家id buyerInfo.getBuyerId();
         */

        /**
         * buyer_phone 买家手机号 buyerInfo.getBuyerPhone();
         */

        /**
         * fans_type 粉丝类型 1:自有粉丝; 9:代销粉丝 buyerInfo.getFansType();
         */

        /**
         * fans_id 粉丝id buyerInfo.getFansId();
         */

        /**
         * fans_nickname 粉丝昵称
         */
        String fansNickName = buyerInfo.getFansNickname();
        taslyOrder.setNickName(StringUtil.isEmpty(fansNickName)?buyerInfo.getBuyerPhone():fansNickName);
    }

    private void payInfo(YouzanTradeGetResult.StructurizationTradePayInfoDetail payInfo, TaslyOrder taslyOrder) {
        /**
         * total_fee 优惠前商品总价
         */
        taslyOrder.setTotalPrice(new BigDecimal(payInfo.getTotalFee().toString()).doubleValue());
        /**
         * post_fee 邮费
         */
        taslyOrder.setPostFee(payInfo.getPostFee());
        /**
         * payment 最终支付价格 payment=orders.payment的总和
         */
        taslyOrder.setPayment(new BigDecimal(payInfo.getPayment().toString()).doubleValue());
        /**
         * transaction 有赞支付流水号 payInfo.getTransaction();
         */

        /**
         * outer_transactions 外部支付单号 payInfo.getOuterTransactions();
         */
        /**
         * 订单级别折扣费用
         */
        taslyOrder.setDiscountFee(new BigDecimal(payInfo.getTotalFee().toString()).subtract(new BigDecimal(payInfo.getPayment().toString())).doubleValue());
    }

    private void remarkInfo(YouzanTradeGetResult.StructurizationTradeRemarkInfoDetail remarkInfo, TaslyOrder taslyOrder) {
        /**
         * buyer_message 订单买家留言
         */
        taslyOrder.setBuyerMessage(remarkInfo.getBuyerMessage());
        /**
         * star 订单标星等级 0-5 remarkInfo.getStar();
         */
        /**
         * trade_memo 订单商家备注
         */
        taslyOrder.setSellerMessage(remarkInfo.getTradeMemo());
    }

    private void addressInfo(YouzanTradeGetResult.StructurizationTradeAddressInfoDetail addressInfo, TaslyOrder taslyOrder) {
        /**
         * receiver_name 收货人姓名
         */
        taslyOrder.setReceiverName(addressInfo.getReceiverName());
        /**
         * receiver_tel 收货人手机号
         */
        taslyOrder.setReceiverMobile(addressInfo.getReceiverTel());
        /**
         * delivery_province 省
         */
        taslyOrder.setReceiverState(addressInfo.getDeliveryProvince());
        /**
         * delivery_city 市
         */
        taslyOrder.setReceiverCity(addressInfo.getDeliveryCity());
        /**
         * delivery_district 区
         */
        taslyOrder.setReceiverDistrict(addressInfo.getDeliveryDistrict());
        /**
         * delivery_address 详细地址
         */
        taslyOrder.setReceiverAddress(addressInfo.getDeliveryAddress());
        /**
         * address_extra 字段为json格式，需要开发者自行解析 lng、lon（经纬度）； checkOutTime（酒店退房时间）； recipients（入住人）； checkInTime（酒店入住时间）； idCardNumber（海淘身份证信息）； areaCode（邮政编码）
         */
        addressInfo.getAddressExtra();
        /**
         * delivery_postal_code 邮政编码
         */
        taslyOrder.setReceiverZip(addressInfo.getDeliveryPostalCode());
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

    private void orders(YouzanTradeGetResult.StructurizationTradeItemDetail[] orders, TaslyOrder taslyOrder) {
        int length = orders.length;

        if (length < 0) {
            return;
        }
        List<TaslyOrderLine> orderLines = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            TaslyOrderLine taslyOrderLine = new TaslyOrderLine();
            YouzanTradeGetResult.StructurizationTradeItemDetail detail = orders[i];
            /**
             * oid 订单明细id
             */
            taslyOrderLine.setThirdPartyOrderlineId(detail.getOid());
            /**
             * item_type 订单类型 0:普通类型商品; 1:拍卖商品; 5:餐饮商品; 10:分销商品; 等 detail.getItemType();
             */

            /**
             * title 商品名称
             */
            taslyOrderLine.setItem_name(detail.getTitle());
            /**
             * num 商品数量
             */
            Quantity quantity = new Quantity();
            quantity.setValue(new Long(detail.getNum()).intValue());
            taslyOrderLine.setQuantity(quantity);
            /**
             * outer_sku_id  商家编码  detail.getOuterSkuId();
             */

            /**
             * buyer_messages 商品留言 detail.getBuyerMessages();
             */

            /**
             * price 单商品原价  detail.getPrice();
             */

            /**
             * total_fee 商品优惠后总价
             */
            Amount totalFeeAmount = new Amount();
            totalFeeAmount.setValue(new BigDecimal(detail.getTotalFee().toString()).doubleValue());
            taslyOrderLine.setUnitPrice(totalFeeAmount);

            Double discountFee = new BigDecimal(detail.getPrice().toString()).multiply(new BigDecimal(detail.getNum().toString())).subtract(new BigDecimal(detail.getTotalFee().toString())).doubleValue();
            taslyOrderLine.setUnitDiscountFee(discountFee);

            /**
             * payment 商品最终均摊价  detail.getPayment();
             */
            taslyOrderLine.setOrderlinePayment(new BigDecimal(detail.getPayment().toString()).doubleValue());
            /**
             * item_id 商品id  detail.getItemId();
             */

            /**
             * sku_id 规格id（无规格商品为0） detail.getSkuId();
             */

            /**
             * sku_properties_name 规格信息（无规格商品为空） detail.getSkuPropertiesName();
             */

            /**
             * outer_item_id 商品编码 60xxxxx
             */
            String outerItemId = detail.getOuterItemId();
            taslyOrderLine.setSkuId(StringUtils.substringBefore(outerItemId, "\t"));
            /**
             * points_price 商品积分价（非积分商品则为0） detail.getPointsPrice();
             */

            /**
             * pic_path 商品图片地址 detail.getPicPath();
             */

            /**
             * goods_url 商品详情链接 detail.getGoodsUrl();
             */

            /**
             * alias 商品别名  detail.getAlias();
             */

            /**
             * is_present 是否赠品
             */
            if (detail.getIsPresent()) {
                taslyOrderLine.setGiftItemFlag("X");
            }
            orderLines.add(taslyOrderLine);
        }
        taslyOrder.setTaslyOrderLines(orderLines);
    }

    private void childInfo(YouzanTradeGetResult.StructurizationTradeChildOrderInfo childInfo, TaslyOrder taslyOrder) {
        /**
         * gift_no 送礼编号
         */
        childInfo.getGiftNo();
        /**
         * gift_sign 送礼标记
         */
        childInfo.getGiftSign();
        /**
         * child_orders 子单详情
         */
        YouzanTradeGetResult.StructurizationTradeChildOrderDetail[] ChildOrderDetail = childInfo.getChildOrders();
    }

    private void addOther(TaslyOrder taslyOrder) {
        taslyOrder.setChannelSource(ChannelSource.B2B);
        taslyOrder.setInnerSource(InnerSource.JSC);
        taslyOrder.setStoreCode(StoreCode.B2B_2);
        taslyOrder.setExt_1("有赞订单");
        taslyOrder.setExt_6("2");
        taslyOrder.setExt_8("1017");
        taslyOrder.setExt_9("2");
        taslyOrder.setMerchantTag(OrderConstants.SELF_RUN);
    }
}
