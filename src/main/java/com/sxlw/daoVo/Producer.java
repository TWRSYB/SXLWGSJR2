package com.sxlw.daoVo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wr
 * @since 2023-01-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("d_producer")
public class Producer extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 投资者
     */
    @TableField("CS_INVESTOR")
    private String csInvestor;

    /**
     * 厂商
     */
    @TableId("CS_PRODUCER")
    private String csProducer;

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
     * 运营开始年月日
     */
    @TableField("YY_START_YMD")
    private String yyStartYmd;

    /**
     * 运营停止年月日
     */
    @TableField("YY_STOP_YMD")
    private String yyStopYmd;

    /**
     * 系列
     */
    @TableField("XL_SERIES")
    private String xlSeries;

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
