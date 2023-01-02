package com.sxlw.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    public static String dateToDateStr(Date date){
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
        String format = yyyyMMdd.format(date);
        return format;
    }
}
