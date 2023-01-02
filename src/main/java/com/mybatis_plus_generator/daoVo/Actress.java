package com.mybatis_plus_generator.daoVo;

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
 * @since 2023-01-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("m_actress")
public class Actress extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 女优编号: 收录日期拼接2位数字
     */
    @TableId("KEY_ACTRESS_NO")
    private String keyActressNo;

    /**
     * 艺名
     */
    @TableField("NAME_STAGE")
    private String nameStage;

    /**
     * 日文真名
     */
    @TableField("NAME_JP_TRUE")
    private String nameJpTrue;

    /**
     * 中文名
     */
    @TableField("NAME_CN")
    private String nameCn;

    /**
     * 英文名
     */
    @TableField("NAME_EN")
    private String nameEn;

    /**
     * 别名
     */
    @TableField("NAME_OTHER")
    private String nameOther;

    /**
     * 出生年月日
     */
    @TableField("BIRTH_YMD")
    private String birthYmd;

    /**
     * 国家: 由字典表维护
     */
    @TableField("BIRTH_COUNTRY")
    private String birthCountry;

    /**
     * 出生地
     */
    @TableField("BIRTH_PLACE")
    private String birthPlace;

    /**
     * 颜值: 未收录, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, F, E, S
     */
    @TableField("XM_APPEARANCE_INDEX")
    private String xmAppearanceIndex;

    /**
     * 相貌类型: 童颜, 御女, 熟妇
     */
    @TableField("XM_APPEARANCE_TYPE")
    private String xmAppearanceType;

    /**
     * 脸型
     */
    @TableField("XM_FACE_TYPE")
    private String xmFaceType;

    /**
     * 肤色: 未收录, 黑, 黄, 白, 粉
     */
    @TableField("XM_SKIN_COLOR")
    private String xmSkinColor;

    /**
     * 印象
     */
    @TableField("XM_LIKE")
    private String xmLike;

    /**
     * 性格: 未收录, 冷淡, 活泼
     */
    @TableField("QZ_CHARACTER")
    private String qzCharacter;

    /**
     * 高低: 未收录, 很矮, 较矮, 中等, 较高, 很高
     */
    @TableField("TX_TALL_OR_SHORT")
    private String txTallOrShort;

    /**
     * 胖瘦: 未收录, 很瘦, 较瘦, 中等, 较胖, 很胖
     */
    @TableField("TX_FAT_OR_THIN")
    private String txFatOrThin;

    /**
     * 奶子大小: 未收录, 极小, 小, 正常, 大, 巨大
     */
    @TableField("TX_TIT_SIZE")
    private String txTitSize;

    /**
     * 腿型: 未收录, X型, 微X型, 筷子型, 微O型, O型
     */
    @TableField("TX_LEGS_TYPE")
    private String txLegsType;

    /**
     * 腿粗细: 未收录, 极细, 较细, 正常, 较粗, 极粗
     */
    @TableField("TX_LEGS_THICKNESS")
    private String txLegsThickness;

    /**
     * 臀型: 未收录, 极囵, 较囵, 正常, 丰满, 肥
     */
    @TableField("TX_HIP_TYPE")
    private String txHipType;

    /**
     * 胯距: 拳数
     */
    @TableField("TX_HIP_DISTANCE")
    private String txHipDistance;

    /**
     * 颜色: 未收录, 黑色, 肤色, 粉色
     */
    @TableField("HX_COLOR")
    private String hxColor;

    /**
     * 户型: 未收录, 一线天, 蝴蝶屄, 馒头屄
     */
    @TableField("HX_TYPE")
    private String hxType;

    /**
     * 白虎: 未收录, 是, 否
     */
    @TableField("HX_WHITE_TIGER")
    private String hxWhiteTiger;

    /**
     * 身高: cm
     */
    @TableField("SC_HEIGHT")
    private String scHeight;

    /**
     * 体重: kg
     */
    @TableField("SC_WEIGHT")
    private String scWeight;

    /**
     * 杯罩: 未收录,A,B,C,D,E,F,G,H
     */
    @TableField("SC_CUP")
    private String scCup;

    /**
     * 三围
     */
    @TableField("SC_BUST")
    private String scBust;

    /**
     * 出道年月日
     */
    @TableField("CD_DEBUT_YMD")
    private String cdDebutYmd;

    /**
     * 出道年龄
     */
    @TableField("CD_DEBUT_AGE")
    private String cdDebutAge;

    /**
     * 隐退年月日
     */
    @TableField("CD_RETIRE_YMD")
    private String cdRetireYmd;

    /**
     * 隐退年龄
     */
    @TableField("CD_RETIRE_AGE")
    private String cdRetireAge;

    /**
     * 出道期间
     */
    @TableField("CD_PERIODS")
    private String cdPeriods;

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


}
