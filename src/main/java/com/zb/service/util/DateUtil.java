package com.zb.service.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static final String yyyyMM = "yyyy-MM";
    public static final String yyyyMMdd = "yyyy-MM-dd";
    public static final String yyyyMMdd_HHmmss = "yyyy-MM-dd HH:mm:ss";

    /**
     * 字符串转日期
     */
    public static LocalDate strToDate(String strDate, String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(strDate, dtf);
    }

    /**
     * 日期转字符串
     */
    public static String dateToStr(LocalDate date, String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return date.format(dtf);
    }

    /**
     * 字符串转日期时间
     */
    public static LocalDateTime strToDateTime(String strDateTime, String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(strDateTime, dtf);
    }

    /**
     * 日期时间转字符串
     */
    public static String dateToStr(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(dtf);
    }
}
