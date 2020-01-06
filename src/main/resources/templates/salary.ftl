<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>工资条</title>

    <link rel="stylesheet" type="text/css" href="salary/static/css/mui.min.css"/>
    <link rel="stylesheet" type="text/css" href="salary/static/css/mui.picker.min.css"/>
    <link rel="stylesheet" type="text/css" href="salary/static/css/main.css"/>
    <!--扩展字体图标-->
    <link rel="stylesheet" href="salary/static/css/icon-extend/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="salary/static/css/animate.min.css"/>
</head>
<body id="body">

<!-- 顶部实发工资区域 -->
<div class="panel-top-container">
    <p class="panel-top-username" id="username">
        ${(salary.xm)!} ${(salary.nd)!}年${(salary.qj)!}月实发
        <lable class="eye">
            <input type="checkbox" id="cb_eye"/>
            <i class="iconfont  icon-faxian-yanjing"></i>
        </lable>
        <input type="hidden" id="salary.bm" value="${(salary.bm)!} "/>
    </p>

    <p class="panel-top-salary salary-value" id="top-salary">
        ${(salary.sfgz)!}
    </p>
    <p class="panel-top-salary salary-value-hidden none">
        ****
    </p>
    <p class="panel-top-thanks">感谢您为公司的付出，辛苦了...
        <i class="iconfont icon-aixin animated flash"></i>
    </p>
</div>
<!-- 三小项区域 -->
<div class="mui-content panel-bottom-container">
    <div class="mui-row panel-bottom-row">
        <div class="mui-col-sm-4 mui-col-xs-4 panel-bottom-son">
            <p class="panel-bottom-txt">应发工资</p>
            <p class="panel-bottom-txt salary-value">${(salary.yfgz)!}</p>
            <p class="panel-bottom-txt salary-value-hidden none">****</p>
        </div>
        <div class="mui-col-sm-4 mui-col-xs-4 panel-bottom-son">
            <p class="panel-bottom-txt">个人保险</p>
            <p class="panel-bottom-txt salary-value">${(salary.grbx)!}</p>
            <p class="panel-bottom-txt salary-value-hidden none">****</p>
        </div>
        <div class="mui-col-sm-4 mui-col-xs-4 panel-bottom-son">
            <p class="panel-bottom-txt">点值</p>
            <p class="panel-bottom-txt salary-value">${(salary.dz)!}</p>
            <p class="panel-bottom-txt salary-value-hidden none">****</p>
        </div>
    </div>
</div>
<!-- 详情区域 -->
<div class="detail-container">
    <!-- 出勤情况 -->
    <ul class="mui-table-view">
        <li class="mui-table-view-cell mui-collapse mui-active">
            <a class="mui-navigate-right detail-salary-container">
						<span>
							出勤情况
						</span>
                <span class="detail-salary" id="detail_salary1"></span>
            </a>
            <div class="mui-collapse-content">
                <ul class="mui-table-view animated fadeInUp">
                    <li class="mui-table-view-cell">
								<span>
									应出勤
								</span>
                        <span class="detail-salary  salary-value">${(salary.ycq)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									上班天数
								</span>
                        <span class="detail-salary  salary-value">${(salary.sbts)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                </ul>
            </div>
        </li>
    </ul>
    <!-- 基本工资 -->
    <div class="large-cut"></div>
    <ul class="mui-table-view">
        <li class="mui-table-view-cell mui-collapse mui-active">
            <a class="mui-navigate-right detail-salary-container">
						<span>
							基本工资
						</span>
                <span class="detail-salary" id="detail_salary2"></span>
            </a>
            <div class="mui-collapse-content">
                <ul class="mui-table-view animated fadeInUp">
                    <li class="mui-table-view-cell">
								<span>
									基本工资
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary2_1">${(salary.jbgz)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									扣减/奖励金额
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary2_2">${(salary.kjjlje)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									实际基本工资
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary2_3">${(salary.sjjbgz)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                </ul>
            </div>
        </li>
    </ul>
    <!-- 绩效工资 -->
    <div class="large-cut"></div>
    <ul class="mui-table-view">
        <li class="mui-table-view-cell mui-collapse mui-active">
            <a class="mui-navigate-right detail-salary-container">
						<span>
							绩效工资
						</span>
                <span class="detail-salary" id="detail_salary3"></span>
            </a>
            <div class="mui-collapse-content ">
                <ul class="mui-table-view animated fadeInUp">
                    <li class="mui-table-view-cell">
								<span>
									绩效工资
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary3_1">${(salary.jxgz)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									点值
								</span>
                        <span class="detail-salary salary-value " id="Span52">${(salary.dz)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									扣减/奖励薪点
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary3_2">${(salary.kjjlxd)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									实际绩效工资
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary3_3">${(salary.sjjxgz)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                </ul>
            </div>
        </li>
    </ul>
    <!-- 提取/奖励工资 -->
    <div class="large-cut"></div>
    <ul class="mui-table-view">
        <li class="mui-table-view-cell mui-collapse mui-active">
            <a class="mui-navigate-right detail-salary-container">
						<span>
							提取/奖励工资
						</span>
                <span class="detail-salary" id="detail_salary4"></span>
            </a>
            <div class="mui-collapse-content ">
                <ul class="mui-table-view animated fadeInUp">
                    <li class="mui-table-view-cell">
								<span>
									提取/奖励工资
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary4_1">${(salary.tqjlgz)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                </ul>
            </div>
        </li>
    </ul>
    <!-- 各项津贴 -->
    <div class="large-cut"></div>
    <ul class="mui-table-view">
        <li class="mui-table-view-cell mui-collapse mui-active">
            <a class="mui-navigate-right detail-salary-container">
						<span>
							各项津贴
						</span>
                <span class="detail-salary" id="detail_salary5"></span>
            </a>
            <div class="mui-collapse-content ">
                <ul class="mui-table-view animated fadeInUp">
                    <li class="mui-table-view-cell">
								<span>
									中/夜班补
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary5_1">${(salary.zybb)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									值班补
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary5_2">${(salary.zbb)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									司龄津贴
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary5_3">${(salary.sljt)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									学历津贴
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary5_4">${(salary.xljt)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									资质津贴
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary5_5">${(salary.zzjt)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									班长补助
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary5_6">${(salary.bzbt)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									效益补助
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary5_7">${(salary.xybz)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									卫生费
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary5_8">${(salary.wsf)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                </ul>
            </div>
        </li>
    </ul>
    <!-- 代扣款 -->
    <div class="large-cut"></div>
    <ul class="mui-table-view">
        <li class="mui-table-view-cell mui-collapse mui-active">
            <a class="mui-navigate-right detail-salary-container">
						<span>
							代扣款
						</span>
                <span class="detail-salary" id="detail_salary6"></span>
            </a>
            <div class="mui-collapse-content ">
                <ul class="mui-table-view animated fadeInUp">
                    <li class="mui-table-view-cell">
								<span>
									扣款
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary6_1">${(salary.kk)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									本次扣税
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary6_2">${(salary.bcks)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                    <li class="mui-table-view-cell">
								<span>
									部门代扣
								</span>
                        <span class="detail-salary  salary-value" id="detail_salary6_3">${(salary.bmdk)!}</span>
                        <span class="detail-salary  salary-value-hidden none">****</span>
                    </li>
                </ul>
            </div>
        </li>
    </ul>

    <!-- 月份悬浮按钮 -->
    <button class="mui-btn-primary detail-hover-month animated bounceInUp" id="btn_month">${(salary.qj)!}月</button>

</div>


<p style="margin:6px auto;width:90%;color:#686868">备注：<br/>1)
    数据来源：每月16日至次月1日定时从NC系统抓取,一天两次:12:00和18:00; <br/>2)
    显示范围：从2019年1月至最新造发工资月份,默认显示最新月份工资; <br/>3)
    若数据前后有差异：存在弃审重新造发的情况,以最新数据为准; <br/>4)
    技术支持：信息化管理部（内线6329，6358）</p>
<script src="salary/static/js/mui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="salary/static/js/jquery.min.js" type="text/javascript"></script>
<script src="salary/static/js/jquery.cookie.js" type="text/javascript"></script>
<script src="salary/static/js/main.js" type="text/javascript" charset="utf-8"></script>
<script src="salary/static/js/mui.picker.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">

    var now = new Date();
    mui("div").on('tap', '#btn_month', function () {
        var dtPicker = new mui.DtPicker({
            type: "month",
            beginDate: new Date(2018, 12), //设置开始日期
            endDate: addMonth(now, -1), //设置结束日期
        });
        dtPicker.setSelectedValue('${(salary.rq)!}');
        dtPicker.show(function (selectItems) {
            location.replace("/salary?period=" + selectItems.y.value + "-" + selectItems.m.value);
        });
    });

    mui.ready(function () {
        if (${isNull?c}) {
            mui.alert('该月工资未造发,请耐心等待...', '', '确定', function (e) {
            }, 'div');
        }
        // 页面加载时使用cookie判断数据是否显示
        if ($.cookie('show') == 0) {
            hide();
            $('#cb_eye').prop('checked', true);
        }
        // 设置用户编码和名称
        setCookie();
    });
    $(document).on("click", "#cb_eye", function () {
        if ($('#cb_eye').is(':checked')) {
            hide();
        } else {
            show();
        }
    });

    function hide() {
        $.cookie('show', 0, {expires: 10, path: '/'});
        $(".salary-value").addClass("none");
        $(".salary-value-hidden").removeClass("none");
    }

    function show() {
        $.cookie('show', 1, {expires: 10, path: '/'});
        $(".salary-value-hidden").addClass("none");
        $(".salary-value").removeClass("none");
    }

    function setCookie() {
        if ($.cookie('userid') == null) {
            $.cookie('userid', "${(salary.bm)!}", {expires: 10, path: '/'});
            $.cookie('username', "${(salary.xm)!}", {expires: 10, path: '/'});
        }
    }
</script>

</body>
</html>