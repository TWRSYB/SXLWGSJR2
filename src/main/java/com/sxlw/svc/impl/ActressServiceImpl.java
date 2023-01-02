package com.sxlw.svc.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxlw.daoVo.Actress;
import com.sxlw.mapper.ActressMapper;
import com.sxlw.svc.ActressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxlw.util.BeanUtil;
import com.sxlw.util.DateUtil;


import com.sxlw.util.FieldUtil;
import com.sxlw.util.StringUtil;
import com.sxlw.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wr
 * @since 2022-12-17
 */
@Service
public class ActressServiceImpl extends ServiceImpl<ActressMapper, Actress> implements ActressService {

    private static final Logger log = LoggerFactory.getLogger(ActressServiceImpl.class);

    @Value("${fileDir.actressHomePath}")
    private String actressHomePath;

    @Autowired
    private ActressMapper actressMapper;
    private HashMap<String, String> lvs;

    /**
     * 添加女优
     *
     * @param actress
     */
    @Override
    public void addActress(Actress actress) {
        actress.setKeyActressNo(nextkey());
        actressMapper.insert(actress);
    }

    /**
     * 根据最新女优编号生成下一个女优编号
     *
     * @param
     * @return
     */
    private String nextkey() {
        String nowDateStr = DateUtil.dateToDateStr(new Date());
        String lastKey = actressMapper.generateKey(nowDateStr);
        if (lastKey == null) {
            return nowDateStr + "01";
        } else if (lastKey.length() != 10) {
            log.error("数据库存在异常数据");
            throw new RuntimeException("数据库存在异常数据");
        }
        String tail = lastKey.substring(8);
        log.info("tail = " + tail);
        int tailNum = Integer.parseInt(tail);
        if (tailNum >= 99) {
            log.error("今天收录的女优数量达到99了");
            throw new RuntimeException("今天收录的女优数量达到99了");
        } else if (tailNum <= 0) {
            log.error("尾号不对");
            throw new RuntimeException("尾号不对");
        } else {
            String s = "0" + (tailNum + 1);
            return nowDateStr + s.substring(s.length() - 2);
        }
    }

    @Override
    public List<Actress> queryActressList() {
        List<Actress> actresses = actressMapper.selectList(new QueryWrapper<>());
        return actresses;
    }

    /**
     * 获取表结构
     *
     * @return
     */
    @Override
    public ResVo<TableDesign> getTableDesign() {

//    "keyActressNo": "女优编号",
//    "nameStage": "艺名",

//    "birthCountry": "国家",
//    "birthPlace": "出生地",
//    "birthYmd": "出生年月日",

//    "nameCn": "中文名",
//    "nameEn": "英文名",
//    "nameJpTrue": "日文真名",
//    "nameOther": "别名",

//    "xmAppearanceIndex": "颜值",
//    "xmAppearanceType": "相貌类型",
//    "xmFaceType": "脸型",
//    "xmLike": "印象",
//    "xmSkinColor": "肤色"

//    "qzCharacter": "性格",

//    "txFatOrThin": "胖瘦",
//    "txHipDistance": "胯距",
//    "txHipType": "臀型",
//    "txLegsThickness": "腿粗细",
//    "txLegsType": "腿型",
//    "txTallOrShort": "高低",
//    "txTitSize": "奶子大小",

//    "hxColor": "颜色",
//    "hxType": "户型",
//    "hxWhiteTiger": "白虎",

//    "scBust": "三围",
//    "scCup": "杯罩",
//    "scHeight": "身高",
//    "scWeight": "体重",

//    "cdDebutAge": "出道年龄",
//    "cdDebutYmd": "出道年月日",
//    "cdPeriods": "出道期间",
//    "cdRetireAge": "隐退年龄",
//    "cdRetireYmd": "隐退年月日",

//    "msDetail": "详细",
//    "msResume": "简述",

//    "rcDataStatus": "数据状态",
//    "rcLastModifiedTime": "最后修改时间",
//    "rcLastModifier": "最后修改人",
//    "rcRecorder": "收录人",
//    "rcRecordTime": "收录时间",

        /* 创建数据结构 Start */
        String[] mainSelected = {"keyActressNo", "nameStage"};
        String[] birthSelected = {"birthCountry"};
        String[] nameSelected = {"nameCn"};
        String[] xmSelected = {"xmAppearanceIndex"};
        String[] qzSelected = {};
        String[] txSelected = {"txFatOrThin"};
        String[] hxSelected = {"hxType"};
        String[] scSelected = {};
        String[] cdSelected = {"cdDebutYmd", "cdDebutAge"};
        String[] msSelected = {};
        String[] rcSelected = {};

        ArrayList<Field> mainFields = new ArrayList<>();
        FieldPackage mainPackage = new FieldPackage("main", "主信息", mainFields, Arrays.asList(mainSelected));
        ArrayList<Field> nameFields = new ArrayList<>();
        FieldPackage namePackage = new FieldPackage("name", "名字", nameFields, Arrays.asList(nameSelected));
        ArrayList<Field> birthFields = new ArrayList<>();
        FieldPackage birthPackage = new FieldPackage("birth", "出生", birthFields, Arrays.asList(birthSelected));
        ArrayList<Field> xmFields = new ArrayList<>();
        FieldPackage xmPackage = new FieldPackage("xm", "相貌", xmFields, Arrays.asList(xmSelected));
        ArrayList<Field> qzFields = new ArrayList<>();
        FieldPackage qzPackage = new FieldPackage("qz", "气质", qzFields, Arrays.asList(qzSelected));
        ArrayList<Field> txFields = new ArrayList<>();
        FieldPackage txPackage = new FieldPackage("tx", "体型", txFields, Arrays.asList(txSelected));
        ArrayList<Field> hxFields = new ArrayList<>();
        FieldPackage hxPackage = new FieldPackage("hx", "户型", hxFields, Arrays.asList(hxSelected));
        ArrayList<Field> scFields = new ArrayList<>();
        FieldPackage scPackage = new FieldPackage("sc", "身材", scFields, Arrays.asList(scSelected));
        ArrayList<Field> cdFields = new ArrayList<>();
        FieldPackage cdPackage = new FieldPackage("cd", "出道", cdFields, Arrays.asList(cdSelected));
        ArrayList<Field> msFields = new ArrayList<>();
        FieldPackage msPackage = new FieldPackage("ms", "描述", msFields, Arrays.asList(msSelected));
        ArrayList<Field> rcFields = new ArrayList<>();
        FieldPackage rcPackage = new FieldPackage("rc", "收录", rcFields, Arrays.asList(rcSelected));


        ArrayList<FieldPackage> fieldPackages = new ArrayList<>();
        fieldPackages.add(mainPackage);
        fieldPackages.add(namePackage);
        fieldPackages.add(birthPackage);
        fieldPackages.add(xmPackage);
        fieldPackages.add(qzPackage);
        fieldPackages.add(txPackage);
        fieldPackages.add(hxPackage);
        fieldPackages.add(scPackage);
        fieldPackages.add(cdPackage);
        fieldPackages.add(msPackage);
        fieldPackages.add(rcPackage);

        TableDesign tableDesign = new TableDesign();
        tableDesign.setFieldPackages(fieldPackages);
        /* 创建数据结构 End */

        List<SimpleTableDesign> simpleTableDesigns = actressMapper.getTableDesign();    // 查询表结构

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
            if (columnName.startsWith("key") || columnName.startsWith("nameStage")) {
                mainFields.add(field);
            } else if (columnName.startsWith("name")) {
                nameFields.add(field);
            } else if (columnName.startsWith("birth")) {
                birthFields.add(field);
            } else if (columnName.startsWith("xm")) {
                xmFields.add(field);
            } else if (columnName.startsWith("qz")) {
                qzFields.add(field);
            } else if (columnName.startsWith("tx")) {
                txFields.add(field);
            } else if (columnName.startsWith("hx")) {
                hxFields.add(field);
            } else if (columnName.startsWith("sc")) {
                scFields.add(field);
            } else if (columnName.startsWith("cd")) {
                cdFields.add(field);
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

    /**
     * 通过艺名搜索女优
     *
     * @param searchMap
     * @return
     */
    @Override
    public ResVo<Map<String, Object>> nameSearch(Map<String, Object> searchMap) {

        ResVo<Map<String, Object>> resVo = new ResVo<>();

        String name = (String) searchMap.get("name");
        String model = (String) searchMap.get("model");

        if (StringUtil.isEmpty(name)) {
            log.info("搜索关键字为空");
            resVo.setCode("200");
            resVo.setMsg("搜索关键字为空");
            resVo.setObj(null);
            return resVo;
        }
        String[] imgExtensions = new String[]{"jpg", "png", "gif", "jpeg", "bmp", "tiff"};
        List<Actress> actresseList;
        if ("match".equals(model)) {
            log.info("艺名全匹配搜索");
            Actress actress = new Actress();
            actress.setNameStage(name);
            actresseList = actressMapper.selectList(new QueryWrapper<>(actress));
        } else {
            log.info("模糊搜索模式");
            actresseList = actressMapper.nameLikeSearch(name);
        }
        List<ActressNamePicture> actressNamePictureList = new ArrayList<>();
        for (Actress actress : actresseList) {
            ActressNamePicture actressNamePicture = BeanUtil.copy(actress, ActressNamePicture.class);
            File headPicPath = new File(actressHomePath + "/" + actress.getKeyActressNo() + "/headPic/");

            log.info("\r\n================================================================ 遍历头像 Start ================================================================");
            ArrayList<String> headPicList = new ArrayList<>();
            File[] headPics = headPicPath.listFiles();
            if (headPics != null) {
                for (File pic : headPics) {
                    String fileName = pic.getName();
                    log.info("名称: {}", fileName);
                    if (pic.isFile()) {
                        String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
                        log.info("扩展名为: {}", extensionName);
                        if (Arrays.asList(imgExtensions).contains(extensionName.toLowerCase())) {
                            log.info("是图片 {}", fileName);
                            headPicList.add("actressHomePath/" + actress.getKeyActressNo() + "/headPic/" + fileName);
                        } else {
                            log.info("不是图片 {}", fileName);
                        }
                    } else {
                        log.info("不是文件: {}", fileName);
                    }
                }
            }
            actressNamePicture.setHeadPicList(headPicList);
            log.info("\r\n================================================================ 遍历头像 End ================================================================");

            log.info("\r\n================================================================ 遍历全身照 Start ================================================================");
            ArrayList<String> fullBodyPicList = new ArrayList<>();
            File fullBodyPicPath = new File(actressHomePath + "/" + actress.getKeyActressNo() + "/fullBodyPic/");
            File[] fullBodyPics = fullBodyPicPath.listFiles();
            if (fullBodyPics != null) {
                for (File pic : fullBodyPics) {
                    String fileName = pic.getName();
                    log.info("名称: {}", fileName);
                    if (pic.isFile()) {
                        String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
                        log.info("扩展名为: {}", extensionName);
                        if (Arrays.asList(imgExtensions).contains(extensionName.toLowerCase())) {
                            log.info("是图片 {}", fileName);
                            fullBodyPicList.add("actressHomePath/" + actress.getKeyActressNo() + "/fullBodyPic/" + fileName);
                        } else {
                            log.info("不是图片 {}", fileName);
                        }
                    } else {
                        log.info("不是文件: {}", fileName);
                    }
                }
            }
            actressNamePicture.setFullBodyPicList(fullBodyPicList);
            log.info("\r\n================================================================ 遍历全身照 End ================================================================");

            log.info("\r\n================================================================ 遍历全部图片 Start ================================================================");
            ArrayList<String> allPicList = new ArrayList<>();
            File allPicPath = new File(actressHomePath + "/" + actress.getKeyActressNo());
            File[] allPics = allPicPath.listFiles();
            if (allPics != null) {
                for (File pic : allPics) {
                    String fileName = pic.getName();
                    log.info("名称: {}", fileName);
                    if (pic.isFile()) {
                        String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
                        log.info("扩展名为: {}", extensionName);
                        if (Arrays.asList(imgExtensions).contains(extensionName.toLowerCase())) {
                            log.info("是图片 {}", fileName);
                            fullBodyPicList.add("actressHomePath/" + actress.getKeyActressNo() + "/" + fileName);
                        } else {
                            log.info("不是图片 {}", fileName);
                        }
                    } else {
                        log.info("不是文件: {}", fileName);
                    }
                }
            }
            actressNamePicture.setAllPicList(allPicList);
            log.info("\r\n================================================================ 遍历全部图片 End ================================================================");

            actressNamePicture.setActressHome(actressHomePath + "/" + actress.getKeyActressNo() + "/");
            actressNamePictureList.add(actressNamePicture);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("actressList", actressNamePictureList);
        map.put("actressHomePath", actressHomePath);
        resVo.setCode("200");
        resVo.setObj(map);
        return resVo;
    }


    /**
     * 生成女优
     *
     * @param map
     * @return
     */
    @Override
    public ResVo<Actress> gnrtActressNo(Map<String, Object> map) {
        ResVo<Actress> resVo = new ResVo<>();
        boolean force = (boolean) map.get("force");
        LinkedHashMap actress_map = (LinkedHashMap) map.get("actress");
        Actress actress = JSON.parseObject(JSON.toJSONString(actress_map), Actress.class);

        if (StringUtil.isEmpty(actress.getNameStage())) {
            log.info("女优艺名为空");
            resVo.setCode("500");
            resVo.setMsg("女优艺名不可为空");
            resVo.setObj(null);
            return resVo;
        }


        Actress query = new Actress();
        query.setNameStage(actress.getNameStage());
        QueryWrapper<Actress> queryWrapper = new QueryWrapper<>(query);
        List<Actress> actresses = actressMapper.selectList(queryWrapper);
        log.info("actresses: {}", actresses);
        if (!force && actresses.size() > 0) {
            log.info("已经存在相同艺名的女优, 数量: {}", actresses.size());
            // 不是强制生成, 且已经存在相同艺名的女优
            resVo.setCode("501");
            resVo.setMsg("已经存在相同艺名的女优");
            resVo.setObj(null);
            return resVo;
        }

        actress.setKeyActressNo(nextkey());
        actress.setRcDataStatus("0");
        int insert = actressMapper.insert(actress);

        log.info("完成女优的插入: {}", actress);

        String actressHome = actressHomePath + "/" + actress.getKeyActressNo();
        File actressHome_path = new File(actressHome);
        if (actressHome_path.mkdir()) {
            log.info("创建女优目录成功: {}", actressHome);
            File actressName_Path = new File(actressHome_path, actress.getNameStage());
            if (actressName_Path.mkdir()) {
                log.info("创建女优艺名目录成功: {}", actress.getNameStage());
            }
            File headPic_Path = new File(actressHome_path, "headPid");
            if (headPic_Path.mkdir()) {
                log.info("头像目录创建成功: {}", "headPic");
            }
            File fullBodyPic_Path = new File(actressHome_path, "fullBodyPic");
            if (fullBodyPic_Path.mkdir()) {
                log.info("全身照目录创建成功: {}", "fullBodyPic");
            }
        }

        resVo.setCode("200");
        resVo.setMsg("成功插入了女优");
        resVo.setObj(actress);
        return resVo;
    }

    /**
     * 更新女优
     *
     * @param map
     * @return
     */
    @Override
    public ResVo<Actress> updateActress(Map<String, Object> map) {
        ResVo<Actress> resVo = new ResVo<>();
        Object actress_map = map.get("actress");

        Actress actress = JSON.parseObject(JSON.toJSONString(actress_map), Actress.class);
        // 年龄计算
        String birthYmd = actress.getBirthYmd();
        String cdDebutYmd = actress.getCdDebutYmd();
        String cdRetireYmd = actress.getCdRetireYmd();
        // 出道年龄
        try {
            int birthYear_int = Integer.parseInt(birthYmd.substring(0, 4));
            int debutYear_int = Integer.parseInt(cdDebutYmd.substring(0, 4));
            if (birthYear_int > 1950 && debutYear_int > 1950 && birthYear_int < 2050 && debutYear_int < 2050 && birthYear_int < debutYear_int) {
                actress.setCdDebutAge(debutYear_int - birthYear_int + "");
            }

        } catch (Exception e) {
            log.error("出道年龄计算失败");
        }
        // 隐退年龄
        try {
            int birthYear_int = Integer.parseInt(birthYmd.substring(0, 4));
            int retireYear_int = Integer.parseInt(cdRetireYmd.substring(0, 4));
            if (birthYear_int > 1950 && retireYear_int > 1950 && birthYear_int < 2050 && retireYear_int < 2050 && birthYear_int < retireYear_int) {
                actress.setCdRetireAge(retireYear_int - birthYear_int + "");
            }
        } catch (Exception e) {
            log.error("隐退年龄计算失败");
        }

        int i = actressMapper.updateById(actress);
        if (i == 1) {
            log.info("更新成功");
            resVo.setCode("200");
            resVo.setMsg("更新成功");
            resVo.setObj(null);
        } else {
            log.info("更新失败");
            resVo.setCode("500");
            resVo.setMsg("更新失败");
            resVo.setObj(null);
        }

        return resVo;
    }
}
