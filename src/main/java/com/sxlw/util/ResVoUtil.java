package com.sxlw.util;

import com.sxlw.vo.ResVo;

public class ResVoUtil {
    public static ResVo fail(String msg, Object obj){
        ResVo<Object> resVo = new ResVo<>();
        resVo.setCode("500");
        resVo.setMsg(msg);
        resVo.setObj(obj);
        return resVo;
    }

    public static ResVo fail(String msg){
        ResVo<Object> resVo = new ResVo<>();
        resVo.setCode("500");
        resVo.setMsg(msg);
        return resVo;
    }

    public static ResVo success(String msg, Object obj){
        ResVo<Object> resVo = new ResVo<>();
        resVo.setCode("200");
        resVo.setMsg(msg);
        resVo.setObj(obj);
        return resVo;
    }

    public static ResVo test(String msg, Object obj){
        ResVo<Object> resVo = new ResVo<>();
        resVo.setCode("300");
        resVo.setMsg(msg);
        resVo.setObj(obj);
        return resVo;
    }
}
