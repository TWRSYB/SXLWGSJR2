package com.sxlw.svc.impl;

import com.sxlw.vo.SimpleTableDesign;
import com.sxlw.mapper.TableMapper;
import com.sxlw.svc.TableService;
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
public class TableServiceImpl implements TableService {

    @Autowired
    private TableMapper tableMapper;



    @Override
    public Map getTableDesign(String tableName) {
        List<SimpleTableDesign> tableDesignList = tableMapper.getTableDesign(tableName);
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
