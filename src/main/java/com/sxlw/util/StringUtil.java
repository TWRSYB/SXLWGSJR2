package com.sxlw.util;

public class StringUtil {

    public static boolean isEmpty(String str){
        return str == null || str.trim().equals("");
    }
    public static boolean isNotEmpty(String str){
        return str != null && !str.trim().equals("");
    }
}
