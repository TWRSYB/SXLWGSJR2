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
 * @since 2022-12-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("m_fanhao")
public class Fanhao extends Model {
    private static final long serialVersionUID = 1L;

    /**
     * 系列: 字典表(系列表D_SERIES)
     */
    @TableId("FH_SERIES")
    private String fhSeries;

    /**
     * 系统番号: 系统录入番号加勒比和一本道进行了时间的顺序化
     */
    @TableField("FH_SYS_FANHAO")
    private String fhSysFanhao;

    /**
     * 原番号: 官方番号
     */
    @TableField("FH_PRIMITIVE_FANHAO")
    private String fhPrimitiveFanhao;

    /**
     * 子系列: 字典表(系列表D_SERIES)
     */
    @TableField("YP_SUB_SERIES")
    private String ypSubSeries;

    /**
     * 影片名称
     */
    @TableField("YP_FILM_TITLE")
    private String ypFilmTitle;

    /**
     * 发行年月日
     */
    @TableField("YP_ISSUE_YMD")
    private String ypIssueYmd;

    /**
     * 时长
     */
    @TableField("YP_DURATION")
    private String ypDuration;

    /**
     * 中文名
     */
    @TableField("NM_CN")
    private String nmCn;

    /**
     * 日文名
     */
    @TableField("NM_JP")
    private String nmJp;

    /**
     * 英文名
     */
    @TableField("NM_EN")
    private String nmEn;

    /**
     * 同时女优数: 0,1,2,N
     */
    @TableField("YY_COEXIST_ACTRESS_NUM")
    private String yyCoexistActressNum;

    /**
     * 女优列表: 关联表(女演员表M_ACTRESS)
     */
    @TableField("YY_ACTRESS_NO")
    private String yyActressNo;

    /**
     * 女优
     */
    @TableField("YY_ACTRESS")
    private String yyActress;

    /**
     * 同时男优数: 0,1,2,N
     */
    @TableField("YY_COEXIST_ACTOR_NUM")
    private String yyCoexistActorNum;

    /**
     * 男优编号
     */
    @TableField("YY_ACTOR_NO")
    private String yyActorNo;

    /**
     * 人妖数: 0,1,2,N
     */
    @TableField("YY_LADYBOY_NUM")
    private Integer yyLadyboyNum;

    /**
     * 人妖编号
     */
    @TableField("YY_LADYBOY_NO")
    private String yyLadyboyNo;

    /**
     * 兽类: 无,狗,马,泥鳅,猪,蛇,其他
     */
    @TableField("YY_BEAST_TYPE")
    private String yyBeastType;

    /**
     * 服饰: 普通,开裆裤,模特制服,OL制服,女仆装,和服
     */
    @TableField("JQ_DRESS")
    private String jqDress;

    /**
     * 场景: 家庭,户外,综艺,囚禁,男厕,教室,办公室
     */
    @TableField("JQ_SCENE_TYPE")
    private String jqSceneType;

    /**
     * 角色: 妻子, 女儿, 老师, 下属, 上司, 性奴, 侦查官, 学生, 主人, AV演员
     */
    @TableField("JQ_ROLE_TYPE")
    private String jqRoleType;

    /**
     * 剧情: 夫妻性爱, 轮乱, 强奸, 性虐, 兽交, 侦查官, AV拍摄,综艺节目
     */
    @TableField("JQ_STORY_TYPE")
    private String jqStoryType;

    /**
     * 肛交级别: 无, 1人肛交, 多人肛交
     */
    @TableField("ANAL_SEX_LV")
    private String analSexLv;

    /**
     * 肛门灌肠级别: 无, 简单灌肠, 大量灌肠
     */
    @TableField("ANAL_ENEMA_LV")
    private String analEnemaLv;

    /**
     * 肛门灌精级别: 无, 内射, 轮射
     */
    @TableField("ANAL_INJECT_SEMEN_LV")
    private String analInjectSemenLv;

    /**
     * 肛门同时插入鸡巴数: 0,1,2,3,4
     */
    @TableField("ANAL_COEXIST_PENIS_NUM")
    private Integer analCoexistPenisNum;

    /**
     * 肛门内窥与否: 是, 否
     */
    @TableField("ANAL_ENDOSCOPY_YN")
    private String analEndoscopyYn;

    /**
     * 阴道灌精级别: 无, 内射, 轮射
     */
    @TableField("XJ_INJECT_SEMEN_LV")
    private String xjInjectSemenLv;

    /**
     * 阴道同时插入鸡巴数: 0,1,2,3,4
     */
    @TableField("XJ_COEXIST_PENIS_NUM")
    private Integer xjCoexistPenisNum;

    /**
     * 内窥阴道与否: 是, 否
     */
    @TableField("XJ_ENDOSCOPY_VAGINA_YN")
    private String xjEndoscopyVaginaYn;

    /**
     * 口交级别: 无,自愿口交,强制口交,深喉
     */
    @TableField("KJ_ORAL_SEX_LV")
    private String kjOralSexLv;

    /**
     * 嘴同时插入鸡巴数: 0,1,2,3,4
     */
    @TableField("KJ_MONTH_COEXIST_PENIS_NUM")
    private Integer kjMonthCoexistPenisNum;

    /**
     * 口爆级别: 无,1人口爆,多人口爆
     */
    @TableField("KJ_MOUTH_EJACULATE_LV")
    private String kjMouthEjaculateLv;

    /**
     * 吞精级别: 无,吞1人精,吞多人精
     */
    @TableField("KJ_SWALLOW_SEMEN_LV")
    private String kjSwallowSemenLv;

    /**
     * 捆绑级别: 无捆绑, 手脚捆绑, 全身捆绑, 支架捆绑
     */
    @TableField("TS_TIE_LV")
    private String tsTieLv;

    /**
     * 白虎级别: 非白虎, 人工白虎, 天然白虎
     */
    @TableField("TS_WHITE_TIGER_LV")
    private String tsWhiteTigerLv;

    /**
     * 颜射级别: 无,1人颜射, 多人颜射
     */
    @TableField("TS_FACE_EJACULATE_LV")
    private String tsFaceEjaculateLv;

    /**
     * 潮吹与否: 是,否
     */
    @TableField("TS_FEMALE_EJACULA_YN")
    private String tsFemaleEjaculaYn;

    /**
     * 饮男尿: 是,否
     */
    @TableField("TS_DRIND_MAN_URINE_YN")
    private String tsDrindManUrineYn;

    /**
     * 面骑与否: 是, 否
     */
    @TableField("TS_FACE_RIDING_YN")
    private String tsFaceRidingYn;

    /**
     * 饮女尿: 是,否
     */
    @TableField("TS_DRIND_WOMAN_URINE_YN")
    private String tsDrindWomanUrineYn;

    /**
     * 接吻与否: 是, 否
     */
    @TableField("TS_KISS_YN")
    private String tsKissYn;

    /**
     * 鸡巴大小: 0-未收录, 1-极小, 2-小, 3-正常, 4-大, 5-巨大
     */
    @TableField("TS_PENIS_SIZE_LV")
    private String tsPenisSizeLv;

    /**
     * 大龟头: 是, 否
     */
    @TableField("TS_BIG_BALANUS_YN")
    private String tsBigBalanusYn;

    /**
     * 奶子大小: 0-未收录, 1-极小, 2-小, 3-正常, 4-大, 5-巨大
     */
    @TableField("TS_TIT_SIZE_LV")
    private String tsTitSizeLv;

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
