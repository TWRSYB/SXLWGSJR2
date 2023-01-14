package com.sxlw.svc.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxlw.daoVo.Actress;
import com.sxlw.daoVo.Fanhao;
import com.sxlw.mapper.TableMapper;
import com.sxlw.util.StringUtil;
import com.sxlw.vo.*;
import com.sxlw.mapper.FanhaoMapper;
import com.sxlw.svc.FanhaoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxlw.util.FieldUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wr
 * @since 2022-12-14
 */
@Service
public class FanhaoServiceImpl extends ServiceImpl<FanhaoMapper, Fanhao> implements FanhaoService {

    private static final Logger log = LoggerFactory.getLogger(FanhaoServiceImpl.class);

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
        String[] ypSelected = {"ypFilmTitle", "ypIssueYmd"};                                                // 番号信息默认选中
        String[] yySelected = {"yyCoexistActressNum", "yyActressNo", "yyActress", "yyCoexistActorNum"};     // 演员信息默认选中
        String[] analSelected = {"analSexLv","analEnemaLv"};                                                // 肛交情况默认选中
        String[] kjSelected = {};                                                                           // 口交情况默认选中
        String[] tsSelected = {"tsWhiteTigerLv","tsWhiteTigerLv"};                                          // 特色信息默认选中
        String[] xjSelected = {"xjInjectSemenLv"};                                                          // 性交情况默认选中
        String[] jqSelected = {};                                                                           // 剧情信息默认选中
        String[] msSelected = {};                                                                           // 描述信息默认选中
        String[] rcSelected = {};                                                                           // 收录信息默认选中


        ArrayList<Field> fhFields = new ArrayList<>();
        FieldPackage fhPackage = new FieldPackage("fh", "番号信息", fhFields, Arrays.asList(fhSelected));
        ArrayList<Field> ypFields = new ArrayList<>();
        FieldPackage ypPackage = new FieldPackage("yp", "影片信息", ypFields, Arrays.asList(ypSelected));
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
            if (absFanhaoHome.exists() && absFanhaoHome.isDirectory()){
                File[] files = absFanhaoHome.listFiles();
                for (File file : files) {
                    String fileName = file.getName();
                    log.info("名称: {}", fileName);
                    if (file.isFile()) {
                        String fileNameWithOutExtensionName = fileName.substring(0,fileName.lastIndexOf("."));
                        String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
                        log.info("文件名为: {}", fileNameWithOutExtensionName);
                        log.info("扩展名为: {}", extensionName);
                        if (Arrays.asList(imgExtensions).contains(extensionName.toLowerCase())) {
                            log.info("是图片 {}", fileName);
                            if (fileNameWithOutExtensionName.equals("cover")){ // 封面
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


}
