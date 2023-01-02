package com.sxlw.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Field {
    private String columnName;
    private String columnComment;
    private String type; //text, lv, type, ymd
    private HashMap<String, String> lvs;
    private ArrayList<String> types;
    private String columnDefault;

}
