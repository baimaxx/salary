package com.zb.repository;

import com.zb.entity.WxAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<WxAccessToken, String> {
    WxAccessToken findByCorpIdAndCorpSecret(String corpId ,String corpSecret);
}
