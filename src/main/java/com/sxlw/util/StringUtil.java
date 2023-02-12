package com.sxlw.util;

import com.sxlw.svc.impl.FanhaoServiceImpl;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class StringUtil {

    private static final Logger log = LoggerFactory.getLogger(StringUtil.class);

    public static void main(String[] args) {
        String str = "022905";
        String sdf = "MMddyy";
        boolean mMddyy = strMatchDateFormat(str, sdf);
        System.out.println("mMddyy = " + mMddyy);
    }

    /**
     * 字符串是否匹配时间格式
     * @param str   字符串
     * @param sdf   格式
     * @return  判断结果
     */
    public static boolean strMatchDateFormat(String str, String sdf) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(sdf);
        try {
            Date date = dateFormat.parse(str);
            String reStr = dateFormat.format(date);
            if (reStr.equals(str)){
                log.info("字符串: {} 匹配格式: {} 成功", str, sdf);
                return true;
            } else {
                log.info("字符串: {} 匹配格式: {} 失败", str, sdf);
                return false;
            }
        } catch (ParseException e) {
            log.info("字符串: {} 匹配格式: {} 出错", str, sdf);
            return false;
        }
    }

    /**
     * 字符串为空判断
     * @param str 需要判断的字符串
     * @return 判断结果
     */
    public static boolean isEmpty(String str){
        return str == null || str.trim().equals("");
    }

    /**
     * 字符串非空判断
     * @param str   需要判断的字符串
     * @return  判断结果
     */
    public static boolean isNotEmpty(String str){
        return str != null && !str.trim().equals("");
    }

    /**
     * 字符串是否为数字
     * @param str   需要判断的字符串
     * @return  判断结果
     */
    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException numberFormatException){
            return false;
        }
    }

    /**
     * 获取当前时间的年月日字符串
     * @return yyyyMMdd字符串
     */
    public static String getNowYmd() {
        SimpleDateFormat yyyyMMdd_smf = new SimpleDateFormat("yyyyMMdd");
        Date nowDate = new Date();
        String yyyyMMdd = yyyyMMdd_smf.format(nowDate);
        return yyyyMMdd;
    }



}
