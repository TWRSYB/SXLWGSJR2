package com.sxlw.svc;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxlw.daoVo.Actress;
import com.sxlw.vo.TableDesign;
import com.sxlw.vo.ResVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wr
 * @since 2022-12-17
 */
public interface ActressService extends IService<Actress> {

    void addActress(Actress actress);

    List<Actress> queryActressList();

    ResVo<TableDesign> getTableDesign();

    ResVo<Map<String, Object>> nameSearch(Map<String, Object> map);


    ResVo<Actress> gnrtActressNo(Map<String, Object> map);

    ResVo<Actress> updateActress(Map<String, Object>  map);
}
