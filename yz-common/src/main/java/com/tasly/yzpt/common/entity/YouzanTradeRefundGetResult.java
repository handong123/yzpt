package com.tasly.yzpt.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class YouzanTradeRefundGetResult {
    @JsonProperty("tid")
    private String tid;
    @JsonProperty("refund_id")
    private String refundId;
    @JsonProperty("oids")
    private String oids;
}
