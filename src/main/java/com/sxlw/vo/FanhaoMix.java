package com.sxlw.vo;

import com.sxlw.daoVo.Fanhao;
import lombok.Data;

import java.util.List;

@Data
public class FanhaoMix extends Fanhao {

    /**
     * 番号目录
     */
    private String fanhaoHome;

    /**
     * 番号封面图片
     */
    private String coverPic;

    /**
     * 剧照图片列表
     */
    private List<String> jzPicList;

    /**
     * 参演女优列表
     */
    private List<actress> actressList;

    /**
     * 女优
     */
    @Data
    private class actress{
        /**
         * 女优编号
         */
        private String actressNo;
        /**
         * 女优艺名
         */
        private String actressStageName;
    }
}
