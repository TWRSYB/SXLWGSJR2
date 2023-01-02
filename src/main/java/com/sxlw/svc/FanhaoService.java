package com.sxlw.svc;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxlw.daoVo.Fanhao;

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
public interface FanhaoService extends IService<Fanhao> {

    void addFanhao(Fanhao fanhhao);

    List<Fanhao> queryFanhaoList();

    Map getTableDesign();
}
