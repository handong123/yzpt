package com.tasly.yzpt.config;

import com.tasly.yzpt.common.keystone.YZKeystone;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeystoneConfig {
    @Value("${yz.clientId}")
    private String clientId;
    @Value("${yz.clientSecret}")
    private String clientSecret;

    @Bean
    public YZKeystone yzKeystone() {
        YZKeystone yzKeystone = new YZKeystone();
        yzKeystone.setClientId(clientId);
        yzKeystone.setClientSecret(clientSecret);
        return yzKeystone;
    }
}
