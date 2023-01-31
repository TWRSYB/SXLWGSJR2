package com.sxlw.svc;

import com.sxlw.vo.ResVo;
import com.sxlw.vo.SimpleTableDesign;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wr
 * @since 2022-12-14
 */
public interface TableService {
    Map getTableDesign(String tableName);
    ResVo<List<SimpleTableDesign>> getTableDesign(Map map);
}
