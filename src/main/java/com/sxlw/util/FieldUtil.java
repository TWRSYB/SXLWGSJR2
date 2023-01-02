package com.sxlw.util;

public class FieldUtil {
    public static String underLineToCamel(String field){
        String[] s = field.split("_");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s[0].toLowerCase());
        for (int i = 1; i < s.length; i++) {
            stringBuilder.append(s[i].substring(0,1)).append(s[i].substring(1).toLowerCase());
        }
        System.out.println("ToCamelCase: " + field + " => " + stringBuilder);
        return stringBuilder.toString();
    }
}
