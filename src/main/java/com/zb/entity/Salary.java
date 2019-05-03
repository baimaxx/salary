package com.zb.entity;

import com.zb.annos.Display;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

    @Column(name = "GZBZ")
    private BigDecimal gzbz = BigDecimal.ZERO;

    @Column(name = "SYBX")
    private BigDecimal sybx = BigDecimal.ZERO;

    @Column(name = "SFGZ")
    private BigDecimal sfgz = BigDecimal.ZERO;

    @Column(name = "YFGZ")
    private BigDecimal yfgz = BigDecimal.ZERO;

    @Column(name = "GRBX")
    private BigDecimal grbx = BigDecimal.ZERO;

    @Column(name = "YCQ")
    @Display(order = 1, group = "出勤情况", value = "应出勤")
    private BigDecimal ycq = BigDecimal.ZERO;

    @Column(name = "SBTS")
    @Display(order = 1, group = "出勤情况", value = "上班天数")
    private BigDecimal sbts = BigDecimal.ZERO;

    @Column(name = "JBGZ")
    @Display(order = 2, group = "基本工资", value = "基本工资")
    private BigDecimal jbgz = BigDecimal.ZERO;

    @Column(name = "KJJLJE")
    @Display(order = 2, group = "基本工资", value = "扣减/奖励金额")
    private BigDecimal kjjlje = BigDecimal.ZERO;

    @Column(name = "SJJBGZ")
    @Display(order = 2, group = "基本工资", value = "实际基本工资")
    private BigDecimal sjjbgz = BigDecimal.ZERO;

    @Column(name = "JXGZ")
    @Display(order = 3, group = "绩效工资", value = "绩效工资")
    private BigDecimal jxgz = BigDecimal.ZERO;

    @Column(name = "DZ")
    @Display(order = 3, group = "绩效工资", value = "点值")
    private BigDecimal dz = BigDecimal.ZERO;

    @Column(name = "KJJLXD")
    @Display(order = 3, group = "绩效工资", value = "扣减/奖励薪点")
    private BigDecimal kjjlxd = BigDecimal.ZERO;

    @Column(name = "SJJXGZ")
    @Display(order = 3, group = "绩效工资", value = "实际绩效工资")
    private BigDecimal sjjxgz = BigDecimal.ZERO;

    @Column(name = "TQJLGZ")
    @Display(order = 4, group = "提取/奖励工资", value = "提取/奖励工资")
    private BigDecimal tqjlgz = BigDecimal.ZERO;

    @Column(name = "ZYBB")
    @Display(order = 5, group = "各项津贴", value = "中/夜班补")
    private BigDecimal zybb = BigDecimal.ZERO;

    @Column(name = "ZBB")
    @Display(order = 5, group = "各项津贴", value = "值班补")
    private BigDecimal zbb = BigDecimal.ZERO;

    @Column(name = "SLJT")
    @Display(order = 5, group = "各项津贴", value = "司龄津贴")
    private BigDecimal sljt = BigDecimal.ZERO;

    @Column(name = "XLJT")
    @Display(order = 5, group = "各项津贴", value = "学历津贴")
    private BigDecimal xljt = BigDecimal.ZERO;

    @Column(name = "ZZJT")
    @Display(order = 5, group = "各项津贴", value = "资质津贴")
    private BigDecimal zzjt = BigDecimal.ZERO;

    @Column(name = "BZBT")
    @Display(order = 5, group = "各项津贴", value = "班长补助")
    private BigDecimal bzbt = BigDecimal.ZERO;

    @Column(name = "XYBZ")
    @Display(order = 5, group = "各项津贴", value = "效益补助")
    private BigDecimal xybz = BigDecimal.ZERO;

    @Column(name = "WSF")
    @Display(order = 5, group = "各项津贴", value = "卫生费")
    private BigDecimal wsf = BigDecimal.ZERO;

    @Column(name = "KK")
    @Display(order = 6, group = "代扣款", value = "扣款")
    private BigDecimal kk = BigDecimal.ZERO;

    @Column(name = "BCKS")
    @Display(order = 6, group = "代扣款", value = "本次扣税")
    private BigDecimal bcks = BigDecimal.ZERO;

    @Column(name = "BMDK")
    @Display(order = 6, group = "代扣款", value = "部门代扣")
    private BigDecimal bmdk = BigDecimal.ZERO;

    @Column(name = "BZZE")
    private BigDecimal bzze = BigDecimal.ZERO;

    @Column(name = "GJJ")
    private BigDecimal gjj = BigDecimal.ZERO;

    @Column(name = "YLBX")
    private BigDecimal ylbx = BigDecimal.ZERO;

    @Column(name = "YLBX2")
    private BigDecimal ylbx2 = BigDecimal.ZERO;

}