package com.zb.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "gzt")
public class Salary implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "BM")
    private String bm;

    @Column(name = "XM")
    private String xm;

    @Column(name = "ND")
    private String nd;

    @Column(name = "QJ")
    private String qj;

    @Column(name = "RQ")
    private String rq;

    @Column(name = "XZFA")
    private String xzfa;

    @Column(name = "SHBZ")
    private String shbz;

    @Column(name = "BCKS")
    private BigDecimal bcks = BigDecimal.ZERO;


    @Column(name = "BMDK")
    private BigDecimal bmdk = BigDecimal.ZERO;

    @Column(name = "BZBT")
    private BigDecimal bzbt = BigDecimal.ZERO;

    @Column(name = "BZZE")
    private BigDecimal bzze = BigDecimal.ZERO;

    @Column(name = "DZ")
    private BigDecimal dz = BigDecimal.ZERO;

    @Column(name = "GJJ")
    private BigDecimal gjj = BigDecimal.ZERO;

    @Column(name = "GRBX")
    private BigDecimal grbx = BigDecimal.ZERO;

    @Column(name = "GZBZ")
    private BigDecimal gzbz = BigDecimal.ZERO;

    @Column(name = "JBGZ")
    private BigDecimal jbgz = BigDecimal.ZERO;

    @Column(name = "JXGZ")
    private BigDecimal jxgz = BigDecimal.ZERO;

    @Column(name = "KJJLJE")
    private BigDecimal kjjlje = BigDecimal.ZERO;

    @Column(name = "KJJLXD")
    private BigDecimal kjjlxd = BigDecimal.ZERO;

    @Column(name = "KK")
    private BigDecimal kk = BigDecimal.ZERO;

    @Column(name = "SBTS")
    private BigDecimal sbts = BigDecimal.ZERO;

    @Column(name = "SFGZ")
    private BigDecimal sfgz = BigDecimal.ZERO;

    @Column(name = "SJJBGZ")
    private BigDecimal sjjbgz = BigDecimal.ZERO;

    @Column(name = "SJJXGZ")
    private BigDecimal sjjxgz = BigDecimal.ZERO;

    @Column(name = "SLJT")
    private BigDecimal sljt = BigDecimal.ZERO;

    @Column(name = "SYBX")
    private BigDecimal sybx = BigDecimal.ZERO;

    @Column(name = "TQJLGZ")
    private BigDecimal tqjlgz = BigDecimal.ZERO;

    @Column(name = "WSF")
    private BigDecimal wsf = BigDecimal.ZERO;

    @Column(name = "XLJT")
    private BigDecimal xljt = BigDecimal.ZERO;


    @Column(name = "XYBZ")
    private BigDecimal xybz = BigDecimal.ZERO;


    @Column(name = "YCQ")
    private BigDecimal ycq = BigDecimal.ZERO;

    @Column(name = "YFGZ")
    private BigDecimal yfgz = BigDecimal.ZERO;

    @Column(name = "YLBX")
    private BigDecimal ylbx = BigDecimal.ZERO;

    @Column(name = "YLBX2")
    private BigDecimal ylbx2 = BigDecimal.ZERO;

    @Column(name = "ZBB")
    private BigDecimal zbb = BigDecimal.ZERO;

    @Column(name = "ZYBB")
    private BigDecimal zybb = BigDecimal.ZERO;

    @Column(name = "ZZJT")
    private BigDecimal zzjt = BigDecimal.ZERO;

}