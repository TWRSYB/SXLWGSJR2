package com.sxlw.svc.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxlw.daoVo.Producer;
import com.sxlw.mapper.ProducerMapper;
import com.sxlw.mapper.TableMapper;
import com.sxlw.svc.ProducerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxlw.util.FieldUtil;
import com.sxlw.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wr
 * @since 2023-01-15
 */
@Service
public class ProducerServiceImpl extends ServiceImpl<ProducerMapper, Producer> implements ProducerService {

    private static final Logger log = LoggerFactory.getLogger(ActressServiceImpl.class);
    @Autowired
    private TableMapper tableMapper;

    @Autowired
    private ProducerMapper producerMapper;


    @Override
    public ResVo<List<Producer>> getProducerList() {
        ResVo<List<Producer>> resVo = new ResVo<>();

        List<Producer> producerList = producerMapper.selectList(new QueryWrapper<>());

        resVo.setCode("200");
        resVo.setMsg("获取厂商列表成功");
        resVo.setObj(producerList);
        return resVo;

    }

    @Override
    public ResVo<TableDesign> getTableDesign() {

//    "csProducer": "厂商",
//    "csInvestor": "投资者",

//    "nmJp": "日文名",
//    "nmCn": "中文名",

//    "wzGw": "官网",


//    "imgLogo": "图标",

//    "yyStartYmd": "运营开始年月日",
//    "yyStopYmd": "运营停止年月日",

//    "xlSeries": "系列"

//    "msDetail": "详细",
//    "msResume": "简述",

//    "rcDataStatus": "数据状态",
//    "rcLastModifiedTime": "最后修改时间",
//    "rcLastModifier": "最后修改人",
//    "rcRecorder": "收录人",
//    "rcRecordTime": "收录时间",

        /* 创建数据结构 Start */
        String[] csSelected = {"csProducer"};
        String[] nmSelected = {"nmJp", "nmCn"};
        String[] wzSelected = {};
        String[] imgSelected = {"imgLogo"};
        String[] yySelected = {"yyStartYmd", "yyStopYmd"};
        String[] xlSelected = {};
        String[] msSelected = {};
        String[] rcSelected = {};

        ArrayList<Field> csFields = new ArrayList<>();
        FieldPackage csPackage = new FieldPackage("cs", "厂商", csFields, Arrays.asList(csSelected));
        ArrayList<Field> nmFields = new ArrayList<>();
        FieldPackage nmPackage = new FieldPackage("nm", "名称", nmFields, Arrays.asList(nmSelected));
        ArrayList<Field> imgFields = new ArrayList<>();
        FieldPackage imgPackage = new FieldPackage("img", "图标", imgFields, Arrays.asList(imgSelected));
        ArrayList<Field> wzFields = new ArrayList<>();
        FieldPackage wzPackage = new FieldPackage("wz", "网址", wzFields, Arrays.asList(wzSelected));
        ArrayList<Field> yyFields = new ArrayList<>();
        FieldPackage yyPackage = new FieldPackage("yy", "运营", yyFields, Arrays.asList(yySelected));
        ArrayList<Field> xlFields = new ArrayList<>();
        FieldPackage xlPackage = new FieldPackage("xl", "系列", xlFields, Arrays.asList(xlSelected));

        ArrayList<Field> msFields = new ArrayList<>();
        FieldPackage msPackage = new FieldPackage("ms", "描述", msFields, Arrays.asList(msSelected));
        ArrayList<Field> rcFields = new ArrayList<>();
        FieldPackage rcPackage = new FieldPackage("rc", "收录", rcFields, Arrays.asList(rcSelected));


        ArrayList<FieldPackage> fieldPackages = new ArrayList<>();
        fieldPackages.add(csPackage);
        fieldPackages.add(nmPackage);
        fieldPackages.add(wzPackage);
        fieldPackages.add(imgPackage);
        fieldPackages.add(yyPackage);
        fieldPackages.add(xlPackage);
        fieldPackages.add(msPackage);
        fieldPackages.add(rcPackage);

        TableDesign tableDesign = new TableDesign();
        tableDesign.setFieldPackages(fieldPackages);
        /* 创建数据结构 End */

        List<SimpleTableDesign> simpleTableDesigns = tableMapper.getTableDesign("D_PRODUCER");    // 查询表结构

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
            } else if (columnName.startsWith("img")) {
                type = "img";
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
            if (columnName.startsWith("cs")) {
                csFields.add(field);
            } else if (columnName.startsWith("nm")) {
                nmFields.add(field);
            } else if (columnName.startsWith("img")) {
                imgFields.add(field);
            } else if (columnName.startsWith("wz")) {
                wzFields.add(field);
            } else if (columnName.startsWith("yy")) {
                yyFields.add(field);
            } else if (columnName.startsWith("xl")) {
                xlFields.add(field);

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
     * 更新厂商
     * @param producer
     * @return
     */
    @Override
    public ResVo<Producer> updateProducer(Producer producer) {

        producerMapper.updateById(producer);
        ResVo<Producer> resVo = new ResVo<>();
        resVo.setCode("200");
        resVo.setMsg("更新厂商成功");
        resVo.setObj(producer);
        return resVo;
    }
}
