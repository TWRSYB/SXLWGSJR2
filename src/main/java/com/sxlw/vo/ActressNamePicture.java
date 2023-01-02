package com.sxlw.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sxlw.daoVo.Actress;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class ActressNamePicture extends Actress {

    /**
     * 头像列表
     */
    private List<String> headPicList;

    /**
     * 全身照列表
     */
    private List<String> fullBodyPicList;

    /**
     * 全身照列表
     */
    private List<String> allPicList;

    /**
     * 女优目录
     */
    private String actressHome;



}
