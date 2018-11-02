package com.tasly.yzpt.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class WmsSoapConfig {
    @Value("${wms.wmsCkkpd}")
    private String wmsCkkpd;

}
