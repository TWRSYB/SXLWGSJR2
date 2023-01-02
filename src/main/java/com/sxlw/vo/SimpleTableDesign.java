package com.sxlw.vo;

import lombok.Data;

@Data
public class SimpleTableDesign {
    /**
     * 字段名
     */
    private String columnName;
    /**
     * 字段注释
     */
    private String columnComment;

    private String columnDefault;
}
