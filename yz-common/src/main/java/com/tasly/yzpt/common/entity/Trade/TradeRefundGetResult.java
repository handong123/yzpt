package com.tasly.yzpt.common.entity.Trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TradeRefundGetResult {
    @JsonProperty("tid")
    private String tid;
    @JsonProperty("refund_id")
    private String refundId;
    @JsonProperty("oids")
    private String oids;
    @JsonProperty("update_time")
    private Date updateTime;
    @JsonProperty("refund_type")
    private String refundType;
    @JsonProperty("refunded_fee")
    private String refundedFee;
    @JsonProperty("refund_reason")
    private String refundReason;
    @JsonProperty("version")
    private String version;
}
