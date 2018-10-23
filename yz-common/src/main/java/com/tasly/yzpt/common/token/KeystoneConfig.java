package com.tasly.yzpt.common.token;

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
    @Value("${yz.kdtId}")
    private String kdtId;

    @Bean
    public YZKeystone yzKeystone() {
        YZKeystone yzKeystone = new YZKeystone();
        yzKeystone.setClientId(clientId);
        yzKeystone.setClientSecret(clientSecret);
        yzKeystone.setKdtId(kdtId);
        return yzKeystone;
    }
}
