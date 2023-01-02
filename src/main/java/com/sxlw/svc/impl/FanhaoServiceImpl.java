package com.sxlw.svc.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxlw.daoVo.Fanhao;
import com.sxlw.vo.SimpleTableDesign;
import com.sxlw.mapper.FanhaoMapper;
import com.sxlw.svc.FanhaoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxlw.util.FieldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private FanhaoMapper fanhaoMapper;

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

    @Override
    public Map getTableDesign() {
        List<SimpleTableDesign> tableDesignList = fanhaoMapper.getTableDesign();
        HashMap<String, String> map = new HashMap<>();
        for (SimpleTableDesign tableDesign : tableDesignList) {
            String columnComment = tableDesign.getColumnComment();
            String[] split = columnComment.split(":");
            System.out.println("split = " + split);
            map.put(FieldUtil.underLineToCamel(tableDesign.getColumnName()), split[0]);
        }
        return map;
    }


}
