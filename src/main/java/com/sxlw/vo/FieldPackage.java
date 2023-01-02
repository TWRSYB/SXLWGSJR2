package com.sxlw.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class FieldPackage {
    private String type;
    private String typeName;
    private ArrayList<Field> fields;

    private List<String> selectedFields;
}
