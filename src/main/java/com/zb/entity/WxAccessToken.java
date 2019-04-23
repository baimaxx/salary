package com.zb.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "wx_access_token")
public class WxAccessToken implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "corpid")
    private String corpId;

    @Column(name = "corpsecret")
    private String corpSecret;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "expires_in")
    private Integer expiresIn;

    @Column(name = "update_time")
    private String updateTime;


}
