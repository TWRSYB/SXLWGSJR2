package com.sxlw.svc.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxlw.daoVo.Fanhao;
import com.sxlw.mapper.TableMapper;
import com.sxlw.util.ResVoUtil;
import com.sxlw.util.StringUtil;
import com.sxlw.vo.*;
import com.sxlw.mapper.FanhaoMapper;
import com.sxlw.svc.FanhaoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxlw.util.FieldUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wr
 * @since 2022-12-14
 */
@Slf4j
@Service
@Transactional
public class FanhaoServiceImpl extends ServiceImpl<FanhaoMapper, Fanhao> implements FanhaoService {

//    private static final Logger log = LoggerFactory.getLogger(FanhaoServiceImpl.class);

    @Value("${fileDir.fanhaoHomePath}")
    private String fanhaoHomePath;

    @Autowired
    private FanhaoMapper fanhaoMapper;

    @Autowired
    private TableMapper tableMapper;

    @Override
    public void addFanhao(Fanhao fanhhao) {
        int insert = fanhaoMapper.insert(fanhhao);
        System.out.println("insert = " + insert);
    }

    @Override
    public List<Fanhao> queryFanhaoList() {
        List<Fanhao> fanhaos = fanhaoMapper.selectList(new QueryWrapper<>());
        return fanhaos;
    }


    /**
     * 获取表设计
     *
     * @return
     */
    @Override
    public ResVo<TableDesign> getTableDesign() {

//    "fhSeries": "系列",
//    "fhSysFanhao": "系统番号",
//    "fhPrimitiveFanhao": "原番号",

//    "ypFilmTitle": "影片名称",
//    "ypIssueYmd": "发行年月日",
//    "ypSubSeries": "子系列",

//    "yyCoexistActressNum": "同时女优数",
//    "yyActressNo": "女优列表",
//    "yyActress": "女优",
//    "yyCoexistActorNum": "同时男优数",
//    "yyActorNo": "男优编号",
//    "yyLadyboyNum": "人妖数",
//    "yyLadyboyNo": "人妖编号",
//    "yyBeastType": "兽类",

//    "analSexLv": "肛交级别",
//    "analEnemaLv": "肛门灌肠级别",
//    "analCoexistPenisNum": "肛门同时插入鸡巴数",
//    "analEndoscopyYn": "肛门内窥与否",
//    "analInjectSemenLv": "肛门灌精级别",

//    "kjMonthCoexistPenisNum": "嘴同时插入鸡巴数",
//    "kjMouthEjaculateLv": "口爆级别",
//    "kjOralSexLv": "口交级别",
//    "kjSwallowSemenLv": "吞精级别",


//    "tsTieLv": "捆绑级别",
//    "tsWhiteTigerLv": "白虎级别",
//    "tsFaceEjaculateLv": "颜射级别",
//    "tsDrindManUrineYn": "饮男尿"
//    "tsDrindWomanUrineYn": "饮女尿",
//    "tsFemaleEjaculaYn": "潮吹与否",

//    "xjInjectSemenLv": "阴道灌精级别",
//    "xjCoexistPenisNum": "阴道同时插入鸡巴数",
//    "xjEndoscopyVaginaYn": "内窥阴道与否",

//    "jqRoleType": "角色",
//    "jqSceneType": "场景",
//    "jqStoryType": "剧情",

//    "msDetail": "详细",
//    "msResume": "简述",

//    "rcDataStatus": "数据状态",
//    "rcLastModifiedTime": "最后修改时间",
//    "rcLastModifier": "最后修改人",
//    "rcRecorder": "收录人",
//    "rcRecordTime": "收录时间",


        /* 创建数据结构 Start */
        String[] fhSelected = {"fhSeries", "fhPrimitiveFanhao", "fhSysFanhao"};                             // 番号信息默认选中
        String[] ypSelected = {"ypFilmTitle", "ypIssueYmd"};                                                // 影片信息默认选中
        String[] nmSelected = {};                                                                           // 名称信息默认选中
        String[] yySelected = {"yyCoexistActressNum", "yyActressNo", "yyActress", "yyCoexistActorNum"};     // 演员信息默认选中
        String[] analSelected = {"analSexLv", "analEnemaLv"};                                                // 肛交情况默认选中
        String[] kjSelected = {};                                                                           // 口交情况默认选中
        String[] tsSelected = {"tsWhiteTigerLv", "tsWhiteTigerLv"};                                          // 特色信息默认选中
        String[] xjSelected = {"xjInjectSemenLv"};                                                          // 性交情况默认选中
        String[] jqSelected = {};                                                                           // 剧情信息默认选中
        String[] msSelected = {};                                                                           // 描述信息默认选中
        String[] rcSelected = {};                                                                           // 收录信息默认选中


        ArrayList<Field> fhFields = new ArrayList<>();
        FieldPackage fhPackage = new FieldPackage("fh", "番号信息", fhFields, Arrays.asList(fhSelected));
        ArrayList<Field> ypFields = new ArrayList<>();
        FieldPackage ypPackage = new FieldPackage("yp", "影片信息", ypFields, Arrays.asList(ypSelected));
        ArrayList<Field> nmFields = new ArrayList<>();
        FieldPackage nmPackage = new FieldPackage("nm", "名称信息", nmFields, Arrays.asList(nmSelected));
        ArrayList<Field> yyFields = new ArrayList<>();
        FieldPackage yyPackage = new FieldPackage("yy", "演员情况", yyFields, Arrays.asList(yySelected));
        ArrayList<Field> analFields = new ArrayList<>();
        FieldPackage analPackage = new FieldPackage("anal", "肛交情况", analFields, Arrays.asList(analSelected));
        ArrayList<Field> kjFields = new ArrayList<>();
        FieldPackage kjPackage = new FieldPackage("kj", "口交情况", kjFields, Arrays.asList(kjSelected));
        ArrayList<Field> tsFields = new ArrayList<>();
        FieldPackage tsPackage = new FieldPackage("ts", "特色信息", tsFields, Arrays.asList(tsSelected));
        ArrayList<Field> xjFields = new ArrayList<>();
        FieldPackage xjPackage = new FieldPackage("xj", "性交情况", xjFields, Arrays.asList(xjSelected));
        ArrayList<Field> jqFields = new ArrayList<>();
        FieldPackage jqPackage = new FieldPackage("jq", "剧情", jqFields, Arrays.asList(jqSelected));
        ArrayList<Field> msFields = new ArrayList<>();
        FieldPackage msPackage = new FieldPackage("ms", "描述", msFields, Arrays.asList(msSelected));
        ArrayList<Field> rcFields = new ArrayList<>();
        FieldPackage rcPackage = new FieldPackage("rc", "收录", rcFields, Arrays.asList(rcSelected));


        ArrayList<FieldPackage> fieldPackages = new ArrayList<>();
        fieldPackages.add(fhPackage);
        fieldPackages.add(ypPackage);
        fieldPackages.add(nmPackage);
        fieldPackages.add(yyPackage);
        fieldPackages.add(analPackage);
        fieldPackages.add(kjPackage);
        fieldPackages.add(tsPackage);
        fieldPackages.add(xjPackage);
        fieldPackages.add(jqPackage);
        fieldPackages.add(msPackage);
        fieldPackages.add(rcPackage);


        TableDesign tableDesign = new TableDesign();
        tableDesign.setFieldPackages(fieldPackages);
        /* 创建数据结构 End */

        List<SimpleTableDesign> simpleTableDesigns = tableMapper.getTableDesign("m_fanhao");    // 查询表结构

        // 遍历字段
        for (SimpleTableDesign simpleTableDesign : simpleTableDesigns) {
            String columnName = FieldUtil.underLineToCamel(simpleTableDesign.getColumnName());
            String columnComment = simpleTableDesign.getColumnComment();
            String type = "";   //"text" input; "lv" 页面铺数字 [0-未收录,1-xx,2-xx,3-xx,4-xx,5-xx];  "type" selection [未收录, xx, xx, xx, xx]; "YMD" dataPicker;
            ArrayList<String> types = new ArrayList<>();
            HashMap<String, String> lvs = new HashMap<>();
            String columnDefault = simpleTableDesign.getColumnDefault();


            String[] split = columnComment.split(":");
            columnComment = split[0];

            if (columnName.endsWith("Ymd")) {
                type = "ymd";
            } else if (columnName.startsWith("ms")) {
                type = "textarea";
            } else if (columnName.endsWith("Time")) {
                type = "null";
            } else if (split.length > 1 && split[1].contains(",")) {
                String[] split1 = split[1].split(",");
                if (split[1].contains("-")) {
                    type = "lv";
                    for (String s : split1) {
                        String[] split2 = s.split("-");
                        lvs.put(split2[0].trim(), split2[1].trim());
                    }
                } else {
                    type = "type";
                    for (String s : split1) {
                        types.add(s.trim());
                    }
                }

            } else {
                type = "text";
            }
            Field field = new Field(columnName, columnComment, type, lvs, types, columnDefault);
            if (columnName.startsWith("fh")) {
                fhFields.add(field);
            } else if (columnName.startsWith("yp")) {
                ypFields.add(field);
            } else if (columnName.startsWith("yy")) {
                yyFields.add(field);
            } else if (columnName.startsWith("nm")) {
                nmFields.add(field);
            } else if (columnName.startsWith("anal")) {
                analFields.add(field);
            } else if (columnName.startsWith("kj")) {
                kjFields.add(field);
            } else if (columnName.startsWith("ts")) {
                tsFields.add(field);
            } else if (columnName.startsWith("xj")) {
                xjFields.add(field);
            } else if (columnName.startsWith("jq")) {
                jqFields.add(field);
            } else if (columnName.startsWith("ms")) {
                msFields.add(field);
            } else if (columnName.startsWith("rc")) {
                rcFields.add(field);
            }

        }
        log.info("tableDesign: {}", JSON.toJSONString(tableDesign));
        ResVo<TableDesign> resVo = new ResVo<>();
        resVo.setCode("200");
        resVo.setMsg("获取表设计成功");
        resVo.setObj(tableDesign);
        return resVo;
    }

    @Override
    public ResVo<List<FanhaoMix>> fanhaoSearch(Map<String, String> searchMap) {
        ResVo<List<FanhaoMix>> resVo = new ResVo<>();

        String keyWord = searchMap.get("keyWord");
        String model = searchMap.get("model");

        if (StringUtil.isEmpty(keyWord)) {
            log.info("搜索关键字为空");
            resVo.setCode("200");
            resVo.setMsg("搜索关键字为空");
            resVo.setObj(null);
            return resVo;
        }
        List<Fanhao> fanhaoList;
        if ("fanhao".equals(model)) {
            log.info("原番号全匹配搜索");
            Fanhao fanhao = new Fanhao();
            fanhao.setFhPrimitiveFanhao(keyWord);
            fanhaoList = fanhaoMapper.selectList(new QueryWrapper<>(fanhao));
        } else {
            log.info("模糊搜索模式");
            fanhaoList = fanhaoMapper.likeSearch(keyWord);
        }
        String[] imgExtensions = new String[]{"jpg", "png", "gif", "jpeg", "bmp", "tiff"};
        List<FanhaoMix> fanhaoMixList = new ArrayList<>();
        for (Fanhao fanhao : fanhaoList) {
            FanhaoMix fanhaoMix = new FanhaoMix();
            ArrayList<String> jzPicList = new ArrayList<>();
            BeanUtils.copyProperties(fanhao, fanhaoMix);
            String absFanhaoHome_str = fanhaoHomePath + "/" + fanhao.getFhSeries() + "/" + fanhao.getFhSysFanhao();
            File absFanhaoHome = new File(absFanhaoHome_str);
            if (absFanhaoHome.exists() && absFanhaoHome.isDirectory()) {
                File[] files = absFanhaoHome.listFiles();
                for (File file : files) {
                    String fileName = file.getName();
                    log.info("名称: {}", fileName);
                    if (file.isFile()) {
                        String fileNameWithOutExtensionName = fileName.substring(0, fileName.lastIndexOf("."));
                        String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
                        log.info("文件名为: {}", fileNameWithOutExtensionName);
                        log.info("扩展名为: {}", extensionName);
                        if (Arrays.asList(imgExtensions).contains(extensionName.toLowerCase())) {
                            log.info("是图片 {}", fileName);
                            if (fileNameWithOutExtensionName.equals("cover")) { // 封面
                                fanhaoMix.setCoverPic("/fanhaoHomePath/" + fanhao.getFhSeries() + "/" + fanhao.getFhSysFanhao() + "/" + fileName);
                            } else {    // 剧照
                                jzPicList.add("/fanhaoHomePath/" + fanhao.getFhSeries() + "/" + fanhao.getFhSysFanhao() + "/" + fileName);
                            }
                        } else {
                            log.info("不是图片 {}", fileName);
                        }
                    } else {
                        log.info("不是文件: {}", fileName);
                    }
                }
            }
            fanhaoMix.setJzPicList(jzPicList);
            fanhaoMix.setFanhaoHome(absFanhaoHome_str);
            fanhaoMixList.add(fanhaoMix);
        }

        resVo.setCode("200");
        resVo.setMsg("搜索成功");
        resVo.setObj(fanhaoMixList);

        return resVo;

    }

    @Override
    public ResVo<Fanhao> gnrtFanhao(Fanhao fanhao) {

//    "fhSeries": "系列",
//    "fhSysFanhao": "系统番号",
//    "fhPrimitiveFanhao": "原番号",

//    "ypFilmTitle": "影片名称",
//    "ypIssueYmd": "发行年月日",
//    "ypSubSeries": "子系列",

//    "yyCoexistActressNum": "同时女优数",
//    "yyActressNo": "女优列表",
//    "yyActress": "女优",
//    "yyCoexistActorNum": "同时男优数",
//    "yyActorNo": "男优编号",
//    "yyLadyboyNum": "人妖数",
//    "yyLadyboyNo": "人妖编号",
//    "yyBeastType": "兽类",

//    "analSexLv": "肛交级别",
//    "analEnemaLv": "肛门灌肠级别",
//    "analCoexistPenisNum": "肛门同时插入鸡巴数",
//    "analEndoscopyYn": "肛门内窥与否",
//    "analInjectSemenLv": "肛门灌精级别",

//    "kjMonthCoexistPenisNum": "嘴同时插入鸡巴数",
//    "kjMouthEjaculateLv": "口爆级别",
//    "kjOralSexLv": "口交级别",
//    "kjSwallowSemenLv": "吞精级别",


//    "tsTieLv": "捆绑级别",
//    "tsWhiteTigerLv": "白虎级别",
//    "tsFaceEjaculateLv": "颜射级别",
//    "tsDrindManUrineYn": "饮男尿"
//    "tsDrindWomanUrineYn": "饮女尿",
//    "tsFemaleEjaculaYn": "潮吹与否",

//    "xjInjectSemenLv": "阴道灌精级别",
//    "xjCoexistPenisNum": "阴道同时插入鸡巴数",
//    "xjEndoscopyVaginaYn": "内窥阴道与否",

//    "jqRoleType": "角色",
//    "jqSceneType": "场景",
//    "jqStoryType": "剧情",

//    "msDetail": "详细",
//    "msResume": "简述",

//    "rcDataStatus": "数据状态",
//    "rcLastModifiedTime": "最后修改时间",
//    "rcLastModifier": "最后修改人",
//    "rcRecorder": "收录人",
//    "rcRecordTime": "收录时间",

        log.info("上送的番号为: {}", fanhao);

        ResVo<Fanhao> resVo = new ResVo<>();
        String fhSeries = fanhao.getFhSeries();     // 系列
        String fhPrimitiveFanhao = fanhao.getFhPrimitiveFanhao();   // 原番号
        log.info("系列为: {}", fhSeries);
        log.info("原番号为: {}", fhPrimitiveFanhao);

        String[] rule1 = {"CWP"};               // 规则: 系列简写-x(CWP-63)
        String[] rule2 = {"MKDV"};              // 规则: 系列简写-0x(MKDV-05)
        String[] rule3 = {"pacopacomama"};      // 规则: 系列简写 MMddyy_xxx(pacopacomama 010120_232)
        String[] rule4 = {"carib"};             // 规则: 系列全称-MMddyy-xxx(Caribbean-110119-001)


        if (StringUtil.isEmpty(fhSeries) || StringUtil.isEmpty(fhPrimitiveFanhao)) {    // 系列为空
            resVo.setCode("500");
            resVo.setMsg("系列和原番号不能为空");
            resVo.setObj(fanhao);
            return resVo;
        }

        //  根据系列生成 系统番号
        if (matchRuler(rule1, fhSeries)) {   // 规则 1 系列简写-x(CWP-63)
            log.info("规则 1 系列");
            if (fhPrimitiveFanhao.length() > fhSeries.length() && matchRuler(rule1, fhPrimitiveFanhao.substring(0, fhSeries.length()))) {
                String number = fhPrimitiveFanhao.substring(fhSeries.length()).replace("-", "");
                if (StringUtil.isNumber(number)) {
                    log.info("原番号 {}, 符合系列 {} 的规则", fhPrimitiveFanhao, fhSeries);
                    fhPrimitiveFanhao = fhSeries + "-" + number;  // 规范化原番号命名
                    fanhao.setFhPrimitiveFanhao(fhPrimitiveFanhao);
                    String fhSysFanhao = fhPrimitiveFanhao;     // 系统番号
                    fanhao.setFhSysFanhao(fhSysFanhao);

                } else {
                    log.error("原番号数字规则不匹配: {} --> {}", fhPrimitiveFanhao, fhSeries);
                    return ResVoUtil.fail("原番号数字规则不匹配");
                }

            } else {
                log.error("原番号系列名称不匹配: {} --> {}", fhPrimitiveFanhao, fhSeries);
                return ResVoUtil.fail("原番号系列名称不匹配");
            }
        } else if (matchRuler(rule2, fhSeries)) {
            log.info("规则 2 系列");
            if (fhPrimitiveFanhao.length() > fhSeries.length() && matchRuler(rule2, fhPrimitiveFanhao.substring(0, fhSeries.length()))) {
                String number = fhPrimitiveFanhao.substring(fhSeries.length()).replace("-", "");
                log.info("number: {}", number);
                if (StringUtil.isNumber(number)) {
                    log.info("原番号 {}, 符合系列 {} 的规则", fhPrimitiveFanhao, fhSeries);

                    fhPrimitiveFanhao = fhSeries + "-0" + Integer.parseInt(number);  // 规范化原番号命名
                    String fhSysFanhao = fhPrimitiveFanhao;     // 系统番号
                    log.info("规范后的原番号为: {}, 生成的系统番号为: {}.", fhPrimitiveFanhao, fhSysFanhao);
                    fanhao.setFhPrimitiveFanhao(fhPrimitiveFanhao);
                    fanhao.setFhSysFanhao(fhSysFanhao);

                } else {
                    log.error("原番号数字规则不匹配: {} --> {}", fhPrimitiveFanhao, fhSeries);
                    return ResVoUtil.fail("原番号数字规则不匹配");
                }

            } else {
                log.error("原番号系列名称不匹配: {} --> {}", fhPrimitiveFanhao, fhSeries);
                return ResVoUtil.fail("原番号系列名称不匹配");
            }
        } else if (matchRuler(rule3, fhSeries)) {    // 规则: 系列简写 MMddyy_xxx(pacopacomama 010120_232)
            log.info("规则 3 系列");
            String MMddyy_xxx = fhPrimitiveFanhao.toUpperCase().replace(fhSeries.toUpperCase(), "").replace(" ", "").replace("-", "");
            String[] strings = MMddyy_xxx.split("_");
            if (strings.length == 2 && strings[0].length() == 6 && strings[1].length() == 3) {
                if (StringUtil.strMatchDateFormat(strings[0], "MMddyy") && StringUtil.isNumber(strings[1])) {
                    fhPrimitiveFanhao = fhSeries + " " + strings[0] + "_" + strings[1];  // 规范化原番号命名
                    String fhSysFanhao = fhSeries + " " + strings[0].substring(4) + strings[0].substring(0, 4) + "_" + strings[1];     // 系统番号
                    log.info("规范后的原番号为: {}, 生成的系统番号为: {}.", fhPrimitiveFanhao, fhSysFanhao);
                    fanhao.setFhPrimitiveFanhao(fhPrimitiveFanhao);
                    fanhao.setFhSysFanhao(fhSysFanhao);


                } else {
                    log.error("原番号规则不匹配: {} --> {}", fhPrimitiveFanhao, fhSeries);
                    return ResVoUtil.fail("原番号规则不匹配");
                }
            } else {
                log.error("原番号规则不匹配: {} --> {}", fhPrimitiveFanhao, fhSeries);
                return ResVoUtil.fail("原番号规则不匹配");
            }

        } else if (matchRuler(rule4, fhSeries)) {    // 规则: 系列全称-MMddyy-xxx(Caribbean-110119-001)
            log.info("规则 4 系列");

            String xlFull = "";
            if (fhSeries.equals("carib")) {
                xlFull = "Caribbean";
            }
            String MMddyyxxx = fhPrimitiveFanhao.toUpperCase().replace(xlFull.toUpperCase(), "").replace(fhSeries.toUpperCase(), "").replace(" ", "").replace("-", "");
            String MMddyy = MMddyyxxx.substring(0, 6);
            String xxx = MMddyyxxx.substring(6);
            log.info(MMddyyxxx);
            log.info(MMddyy);
            log.info(xxx);
            if (xxx.length() == 3) {
                if (StringUtil.strMatchDateFormat(MMddyy, "MMddyy") && StringUtil.isNumber(xxx)) {
                    fhPrimitiveFanhao = xlFull + "-" + MMddyy + "-" + xxx;  // 规范化原番号命名
                    String fhSysFanhao = fhSeries + "-" + MMddyy.substring(4) + MMddyy.substring(0, 4) + "-" + xxx;     // 系统番号
                    log.info("规范后的原番号为: {}, 生成的系统番号为: {}.", fhPrimitiveFanhao, fhSysFanhao);

                    fanhao.setFhPrimitiveFanhao(fhPrimitiveFanhao);
                    fanhao.setFhSysFanhao(fhSysFanhao);
                } else {
                    log.error("原番号规则不匹配2: {} --> {}", fhPrimitiveFanhao, fhSeries);
                    return ResVoUtil.fail("原番号规则不匹配");
                }
            } else {
                log.error("原番号规则不匹配1: {} --> {}", fhPrimitiveFanhao, fhSeries);
                return ResVoUtil.fail("原番号规则不匹配");
            }

        } else {
            log.error("这个系列尚未匹配规则, 请先设置规则: {}", fhSeries);
            return ResVoUtil.fail("这个系列尚未匹配规则, 请先设置规则");
        }


        String fanhaoHome = fanhaoHomePath + "/" + fhSeries + "/" + fanhao.getFhSysFanhao();
        File fanhaoHome_path = new File(fanhaoHome);
        if (fanhaoHome_path.exists() || fanhaoHome_path.mkdir()) {
            log.info("已存在或生成番号目录: {}", fanhaoHome);
            File CoverPic_Path = new File(fanhaoHome_path, "CoverPic");
            if (CoverPic_Path.exists() || CoverPic_Path.mkdir()) {
                log.info("已存在或生成封面图片目录: {}", CoverPic_Path.getAbsolutePath());
            }
            File StagePhoto_Path = new File(fanhaoHome_path, "StagePhoto");
            if (StagePhoto_Path.exists() || StagePhoto_Path.mkdir()) {
                log.info("已存在或生成剧照目录: {}", StagePhoto_Path.getAbsolutePath());
            }
        }

        fanhaoMapper.insert(fanhao);

        return ResVoUtil.success("生成番号成功", fanhao);

    }

    /**
     * 根据主键更新番号
     *
     * @param fanhao
     * @return
     */
    @Override
    public ResVo<Fanhao> updateFanhao(Fanhao fanhao) {
        QueryWrapper<Fanhao> wrapper = new QueryWrapper<>();
        wrapper.eq("FH_SERIES", fanhao.getFhSeries()).eq("FH_SYS_FANHAO", fanhao.getFhSysFanhao());
        int update = fanhaoMapper.update(fanhao, wrapper);
        if (update != 1) throw new RuntimeException("更新失败, 更新数量不是1: "+update);
        return ResVoUtil.success("更新番号成功", fanhao);
    }

    /**
     * 匹配番号规则
     *
     * @param rule
     * @param fhSeries
     * @return
     */
    private boolean matchRuler(String[] rule, String fhSeries) {
        return Arrays.asList(rule).contains(fhSeries.toLowerCase()) || Arrays.asList(rule).contains(fhSeries.toUpperCase());
    }


}
