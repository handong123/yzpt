package com.tasly.yzpt.common.entity.LogisticsOnline;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorResponse {
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("code")
    private String code;
}
