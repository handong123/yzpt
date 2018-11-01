package com.tasly.yzpt.common.entity.LogisticsOnline;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response {
    @JsonProperty("is_success")
    private Boolean isSuccess;

    @JsonProperty("error_response")
    private ErrorResponse errorResponse;
}
