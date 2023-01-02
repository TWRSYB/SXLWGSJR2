package com.sxlw.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class BeanUtil {

    public static<T> T copy(Object poObj, final Class<T> voClass){
        T voObj = null;
        try {
            voObj = voClass.newInstance();
            BeanUtils.copyProperties(poObj, voObj);
            return voObj;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> copyList(List<? extends Object> poList, final Class<T> voClass){
        List<T> voList = new ArrayList<T>();
        T voObj = null;
        for (Object poObj : poList) {
            try {
                voObj = voClass.newInstance();
                BeanUtils.copyProperties(poList, voObj);
                voList.add(voObj);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return voList;
    }
}
