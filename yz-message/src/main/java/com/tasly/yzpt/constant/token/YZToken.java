package com.tasly.yzpt.constant.token;

import com.tasly.yzpt.config.KeystoneConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by ancheng598 on 2018/9/21.
 */
@Component
@Slf4j
public class YZToken {

    final static String ACCESS_TOKEN = "access_token";

    public static YZToken yzToken;

    @Autowired
    private KeystoneConfig keystoneConfig;


    @PostConstruct
    public void init() {
        yzToken = this;
        yzToken.keystoneConfig = this.keystoneConfig;
    }

    public static String getToken() {
//    String token = yzToken.redisTemplate.opsForValue().get(ACCESS_TOKEN);
//    if (token != null){
//      return token;
//    }
//    YZKeystone yzKeystone = yzToken.keystoneConfig.yzKeystone();
//    HttpClient httpClient = new DefaultHttpClient();
//    HttpClient.Params params = HttpClient.Params.custom()
//        .add("client_id", yzKeystone.getClientId())
//        .add("client_secret", yzKeystone.getClientSecret())
//        .add("grant_type", "silent")
//        .add("kdt_id",yzKeystone.getKdtId())
//        .setContentType(ContentType.APPLICATION_FORM_URLENCODED).build();
//    String resp = httpClient.post("https://open.youzan.com/oauth/token", params);
//    log.info("OAuthToken=="+resp);
//    if (StringUtils.isBlank(resp) || !resp.contains(ACCESS_TOKEN)) {
//      throw new RuntimeException(resp);
//    }
//    ObjectMapper mapper = new ObjectMapper();
//    mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
//    try {
//      OAuthToken oAuthToken = mapper.readValue(resp, OAuthToken.class);
//      yzToken.redisTemplate.opsForValue().set(ACCESS_TOKEN, oAuthToken.getAccessToken(), oAuthToken.getExpiresIn(), TimeUnit.SECONDS);
//      return oAuthToken.getAccessToken();
//    } catch (IOException e) {
//      e.printStackTrace();
//      return null;
//    }
        return null;
    }
}
