package com.sxlw.daoVo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wr
 * @since 2023-01-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("d_series")
public class Series extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 简称
     */
    @TableId("XL_SIMPLE")
    private String xlSimple;

    /**
     * 全称
     */
    @TableField("XL_FULL")
    private String xlFull;

    /**
     * 日文名
     */
    @TableField("NM_JP")
    private String nmJp;

    /**
     * 中文名
     */
    @TableField("NM_CN")
    private String nmCn;

    /**
     * 官网
     */
    @TableField("WZ_GW")
    private String wzGw;

    /**
     * 番号样式
     */
    @TableField("FH_PATTERN")
    private String fhPattern;

    /**
     * 番号规则
     */
    @TableField("FH_RULER")
    private String fhRuler;

    /**
     * 厂商
     */
    @TableField("GD_PRODUCER")
    private String gdProducer;

    /**
     * 马赛克: 骑兵, 步兵
     */
    @TableField("GD_MOSAIC")
    private String gdMosaic;

    /**
     * 子系列
     */
    @TableField("GD_SUB_SERIES")
    private String gdSubSeries;

    /**
     * 图标
     */
    @TableField("IMG_LOGO")
    private Blob imgLogo;

    /**
     * 简述
     */
    @TableField("MS_RESUME")
    private String msResume;

    /**
     * 详细
     */
    @TableField("MS_DETAIL")
    private String msDetail;

    /**
     * 收录时间
     */
    @TableField("RC_RECORD_TIME")
    private LocalDateTime rcRecordTime;

    /**
     * 收录人
     */
    @TableField("RC_RECORDER")
    private String rcRecorder;

    /**
     * 最后修改时间
     */
    @TableField("RC_LAST_MODIFIED_TIME")
    private LocalDateTime rcLastModifiedTime;

    /**
     * 最后修改人
     */
    @TableField("RC_LAST_MODIFIER")
    private String rcLastModifier;

    /**
     * 数据状态: 0-未生效, 1-正常, 2-不可用,9-废弃
     */
    @TableField("RC_DATA_STATUS")
    private String rcDataStatus;

}
