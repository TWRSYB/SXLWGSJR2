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
     * 系列: 由字典表维护, 系列表(D_SERIES);
     */
    @TableId("SERIES")
    private String series;

    /**
     * 子系列: 由字典表维护, 系列表(D_SERIES);
     */
    @TableField("SUB_SERIES")
    private String subSeries;

    /**
     * 原番号: 官方番号;
     */
    @TableField("PRIMITIVE_FANHAO")
    private String primitiveFanhao;

    /**
     * 系统番号: 系统录入番号, 加勒比和一本道进行了时间的顺序化;
     */
    @TableField("SYS_FANHAO")
    private String sysFanhao;

    /**
     * 影片名称;
     */
    @TableField("FILM_TITLE")
    private String filmTitle;

    /**
     * 发行年月日;
     */
    @TableField("ISSUE_YMD")
    private String issueYmd;

    /**
     * 女优数: 0-没有,1-一个, 2-两个, N-大于两个;
     */
    @TableField("ACTRESS_NUM")
    private Integer actressNum;

    /**
     * 女优编号: 关联表, 女演员表M_ACTRESS;
     */
    @TableField("ACTRESS_NO")
    private String actressNo;

    /**
     * 女优;
     */
    @TableField("ACTRESS")
    private String actress;

    /**
     * 男优数: 0-没有,1-一个, 2-两个, N-大于两个;
     */
    @TableField("ACTOR_NUM")
    private Integer actorNum;

    /**
     * 男优编号: 由字典表维护, 男演员表(D_ACTOR);
     */
    @TableField("ACTOR_NO")
    private String actorNo;

    /**
     * 人妖数: 0-没有,1-一个, 2-两个, N-大于两个;
     */
    @TableField("LADYBOY_NUM")
    private Integer ladyboyNum;

    /**
     * 人妖编号: 由字典表维护, 人妖表(D_LADYBOY);
     */
    @TableField("LADYBOY_NO")
    private String ladyboyNo;

    /**
     * 兽类: 狗,马,泥鳅,猪,蛇,其他;
     */
    @TableField("BEAST_TYPE")
    private String beastType;

    /**
     * 场景: 家庭, 户外, 综艺, 囚禁, 专业A片;
     */
    @TableField("SCENE_TYPE")
    private String sceneType;

    /**
     * 角色: 妻子, 女儿, 老师, 下属, 上司, 性奴, 侦查官, 学生, 主人, 专业A片;
     */
    @TableField("ROLE_TYPE")
    private String roleType;

    /**
     * 剧情: 夫妻性爱, 轮乱, 强奸, 性虐, 兽交, 侦查官, 专业A片;
     */
    @TableField("STORY_TYPE")
    private String storyType;

    /**
     * 肛交级别: 0-无肛交, 1-1人肛交, N多人肛交;
     */
    @TableField("ANAL_SEX_LV")
    private String analSexLv;

    /**
     * 肛门灌肠级别: 0-无灌肠, 1-简单灌肠, 2大量灌肠;
     */
    @TableField("ANAL_ENEMA_LV")
    private String analEnemaLv;

    /**
     * 肛门灌精级别;
     */
    @TableField("ANAL_INJECT_SEMEN_LV")
    private String analInjectSemenLv;

    /**
     * 肛门同时插入鸡巴数;
     */
    @TableField("ANAL_COEXIST_PENIS_NUM")
    private Integer analCoexistPenisNum;

    /**
     * 肛门内窥与否: Y-是, N-否;
     */
    @TableField("ANAL_ENDOSCOPY_YN")
    private String analEndoscopyYn;

    /**
     * 阴道灌精级别: 0-无内射, 1-普通内射, 2-轮番内射, 3-轮番灌精;
     */
    @TableField("INJECT_SEMEN_LV")
    private String injectSemenLv;

    /**
     * 阴道同时插入鸡巴数;
     */
    @TableField("COEXIST_PENIS_NUM")
    private Integer coexistPenisNum;

    /**
     * 内窥阴道与否: Y-是, N-否;
     */
    @TableField("ENDOSCOPY_VAGINA_YN")
    private String endoscopyVaginaYn;

    /**
     * 口交级别: 0-无口交, 1-自愿口交, 2-强制口交, 3-深喉;
     */
    @TableField("ORAL_SEX_LV")
    private String oralSexLv;

    /**
     * 嘴同时插入鸡巴数;
     */
    @TableField("MONTH_COEXIST_PENIS_NUM")
    private Integer monthCoexistPenisNum;

    /**
     * 口爆级别: 0-无口爆, 1-1人口爆, N-多人口爆;
     */
    @TableField("MOUTH_EJACULATE_LV")
    private String mouthEjaculateLv;

    /**
     * 吞精级别: 0-无吞精, 1-吞1人精, N-吞多人精;
     */
    @TableField("SWALLOW_SEMEN_LV")
    private String swallowSemenLv;

    /**
     * 捆绑级别: 0-无捆绑, 1-手脚捆绑, 2-全身捆绑, 3-支架捆绑;
     */
    @TableField("TIE_LV")
    private String tieLv;

    /**
     * 白虎级别: 0-非白虎, 1-人工白虎, 2-天然白虎;
     */
    @TableField("WHITE_TIGER_LV")
    private String whiteTigerLv;

    /**
     * 颜射级别: 0-无颜射, 1-1人颜射, N-多人颜射;
     */
    @TableField("FACE_EJACULATE_LV")
    private String faceEjaculateLv;

    /**
     * 收录时间;
     */
    @TableField("RECORDING_TIME")
    private LocalDateTime recordingTime;

    /**
     * 收录人;
     */
    @TableField("RECORDER")
    private String recorder;

    /**
     * 最后修改时间;
     */
    @TableField("LAST_MODIFIED_TIME")
    private LocalDateTime lastModifiedTime;

    /**
     * 最后修改人;
     */
    @TableField("LAST_MODIFIER")
    private String lastModifier;

    /**
     * 数据状态: 0-未生效, 1-正常, 2-不可用;
     */
    @TableField("DATA_STATUS")
    private String dataStatus;


}
