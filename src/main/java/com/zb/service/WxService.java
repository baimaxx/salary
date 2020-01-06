package com.zb.service;

import com.zb.entity.WxAccessToken;
import com.zb.repository.TokenRepository;
import com.zb.service.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class WxService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String GET_ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid={corpid}&corpsecret={corpsecret}";
    private static final int MY_TOKEN_TIME_OUT_SECONDS = 3600;
    private static final String GET_USERID_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token={access_token}&code={code}";
    private static final String GET_USER_INFO_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token={access_token}&userid={userid}";

    @Value("${wx.corpid}")
    private String corpId;

    @Value("${wx.corpsecret}")
    private String corpSecret;

    /**
     * 获取access token
     */
    public String getAccessToken() {
        // 从数据库获取
        WxAccessToken tokenFromDB = tokenRepository.findByCorpIdAndCorpSecret(corpId, corpSecret);

        // 超时重新获取
        if (tokenFromDB == null || isTokenTimeOut(tokenFromDB)) {
            log.info("数据库中的 access token 超时，重新获取");
            Map<String, String> param = new HashMap<>();
            param.put("corpid", corpId);
            param.put("corpsecret", corpSecret);
            Map<String, Object> tokenMap = restTemplate.getForEntity(GET_ACCESS_TOKEN_URL, Map.class, param).getBody();

            if (0 != (int) tokenMap.get("errcode")) {
                throw new RuntimeException((String) tokenMap.get("errmsg"));
            }
            String token = (String) tokenMap.get("access_token");
            saveToken(tokenFromDB, token, (int) tokenMap.get("expires_in"));

            log.debug("AccessToken:" + token);
            return token;
        }

        log.debug("返回数据库中的 AccessToken:" + tokenFromDB.getAccessToken());
        return tokenFromDB.getAccessToken();
    }

    /**
     * 检查token是否超时，上次更新时间 + 1小时即超时
     */
    private boolean isTokenTimeOut(WxAccessToken token) {
        if (token == null) {
            return false;
        }
        LocalDateTime updateTime = DateUtil.strToDateTime(token.getUpdateTime(), DateUtil.yyyyMMdd_HHmmss);
        LocalDateTime expireTime = updateTime.plusSeconds(MY_TOKEN_TIME_OUT_SECONDS);
        return expireTime.isBefore(LocalDateTime.now());
    }

    /**
     * 保存token到数据库
     */
    private void saveToken(WxAccessToken tokenFromDB, String token, int expires) {
        String updateTime = DateUtil.dateToStr(LocalDateTime.now(), DateUtil.yyyyMMdd_HHmmss);
        if (tokenFromDB == null) {
            WxAccessToken entity = new WxAccessToken();
            entity.setId(UUID.randomUUID().toString());
            entity.setCorpId(corpId);
            entity.setCorpSecret(corpSecret);
            entity.setAccessToken(token);
            entity.setExpiresIn(expires);
            entity.setUpdateTime(updateTime);

            tokenRepository.save(entity);
        } else {
            tokenFromDB.setAccessToken(token);
            tokenFromDB.setExpiresIn(expires);
            tokenFromDB.setUpdateTime(updateTime);

            tokenRepository.save(tokenFromDB);
        }
    }

    /**
     * 获取用户信息
     */
    public Map<String, String> findUserInfo(String code) {
        String userid = getUserIdByCode(code);
        return getUserById(userid);
    }

    private String getUserIdByCode(String code) {
        Map<String, String> param = new HashMap<>();
        param.put("access_token", getAccessToken());
        param.put("code", code);
        Map<String, Object> map = restTemplate.getForEntity(GET_USERID_URL, Map.class, param).getBody();

        if (0 != (int) map.get("errcode")) {
            throw new RuntimeException((String) map.get("errmsg"));
        }
        String userid = (String) map.get("UserId");
        return userid;
    }


    private Map<String, String> getUserById(String userid) {
        Map<String, String> param = new HashMap<>();
        param.put("access_token", getAccessToken());
        param.put("userid", userid);
        Map<String, Object> map = restTemplate.getForEntity(GET_USER_INFO_URL, Map.class, param).getBody();

        if (0 != (int) map.get("errcode")) {
            throw new RuntimeException((String) map.get("errmsg"));
        }

        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("userid",userid);
        returnMap.put("name", (String) map.get("name"));
        returnMap.put("avatar", (String) map.get("avatar"));
        log.debug(returnMap.toString());
        return returnMap;
    }
}
