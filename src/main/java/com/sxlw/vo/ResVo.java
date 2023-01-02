package com.sxlw.vo;

import lombok.Data;

@Data
public class ResVo<T> {
    /**
     * 相应码
     */
    private String code; // 200 成功, 500 失败
    /**
     * 响应对象
     */
    private T obj;

    /**
     * 提示消息
     */
    private String msg;

}
