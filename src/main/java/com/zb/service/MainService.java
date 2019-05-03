package com.zb.service;

import com.alibaba.fastjson.JSONObject;
import com.zb.annos.Display;
import com.zb.entity.Salary;
import com.zb.repository.MainRepository;
import com.zb.service.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.*;

@Service
public class MainService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MainRepository repository;

    @Autowired
    private WxService wxService;

    /**
     * 工资数据开始日期，请求参数不得早于该日期
     */
    private static final LocalDate BEGIN_DATE = LocalDate.of(2019, 1, 1);
    private String userId;
    private String userName;

    /**
     * @param userId   员工编码
     * @param userName 姓名
     * @param code     oauth2返回链接中的一次性code
     * @param period   薪资期间 如：2019-02
     * @return 根据员工编码和期间查询工资信息
     */
    public Map<String, Object> getSalary(String userId, String userName, String code, String period) {
        Salary salary = this.getSalaryEntity(userId,userName,code,period);
        Map<String, Object> groupMap = buildMap(salary);

        LinkedHashMap<String, Object> retMap = new LinkedHashMap<>();
        retMap.put("salary", salary);
        retMap.put("detail", groupMap);
        retMap.put("isNull", salary.getId() == null);

        return retMap;
    }

    /**
     * @param userId   员工编码
     * @param userName 姓名
     * @param code     oauth2返回链接中的一次性code
     * @param period   薪资期间 如：2019-02
     * @return 根据员工编码和期间查询工资信息
     */
    public Salary getSalaryEntity(String userId, String userName, String code, String period) {
        checkCookies(userId, userName, code);

        // 第一次请求，不带期间参数，默认上月
        if (StringUtils.isEmpty(period)) {
            period = DateUtil.dateToStr(LocalDate.now().minusMonths(1), DateUtil.yyyyMM);
        }

        Salary salary = null;
        if (isValid(period)) {
            salary = repository.findByBmAndRq(this.userId, period);
        }

        if (salary == null) {
            salary = new Salary();
            salary.setRq(period);
            salary.setBm(this.userId);
            salary.setNd(period.substring(0, 4));
            salary.setQj(period.substring(5, 7));
            salary.setXm(this.userName);
        }

        return salary;
    }

    /**
     * 使用反射构建结果集，后期添加字段只需写好注解，无需修改ftl
     */
    private Map<String, Object> buildMap(Salary salary){
        Map<String, Object> groupMap = new LinkedHashMap<>();
        Class cls = salary.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            try {
                Display d = f.getAnnotation(Display.class);
                if (d == null) {
                    continue;
                }

                f.setAccessible(true);
                Map<String, Object> fieldMap = new HashMap<>();
                fieldMap.put(d.value(),f.get(salary));

                List<Object> fieldList = (List<Object>) groupMap.get(d.group());
                if (null == fieldList) {
                    fieldList = new LinkedList<>();
                }
                fieldList.add(fieldMap);
                groupMap.put(d.group(), fieldList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        log.info("groupMap:" + new JSONObject(groupMap));

        return groupMap;
    }

    /**
     * 检查cookie中的用户信息是否为空，若空则通过企业微信接口重新获取
     */
    private void checkCookies(String userId, String userName, String code) {
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(userName)) {
            if (StringUtils.isEmpty(code)) {
                throw new RuntimeException("请在微信客户端打开");
            }
            log.info("cookie为空，通过企业微信接口重新获取登陆人信息");
            Map<String, String> userMap = wxService.findUserInfo(code);
            this.userId = userMap.get("userid");
            this.userName = userMap.get("name");
        } else {
            this.userId = userId;
            this.userName = userName;
        }
        log.info("this.userid:" + this.userId + ", this.username:" + this.userName);
    }

    /**
     * 校验期间是否合规
     */
    protected boolean isValid(String period) {
        String lastMonthStr = LocalDate.now().minusMonths(1).toString().substring(0, 7);
        LocalDate lastSalaryDay = LocalDate.now().minusMonths(1).withDayOfMonth(16); // 上个工资日
        int nowDay = LocalDate.now().getDayOfMonth(); // 当前几号
        LocalDate periodDate = DateUtil.strToDate(period + "-" + String.format("%02d", nowDay), DateUtil.yyyyMMdd); // date格式的期间
        String lastPeriod = periodDate.minusMonths(1).toString().substring(0, 7);

        // 早于数据开始日期
        if (periodDate.isBefore(BEGIN_DATE)) {
            return false;
        }
        // 晚于当前月（压一个月工资时，当前月只能查询上个月）
        if (periodDate.isAfter(LocalDate.now().withDayOfMonth(1))) {
            return false;
        }
        // 等于上月 且 小于上个工资日
        if (period.equals(lastMonthStr) && periodDate.isBefore(lastSalaryDay)) {
            return false;
        }
        return true;
    }
}
