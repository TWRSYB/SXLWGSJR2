package com.sxlw.svc;

import com.sxlw.daoVo.Series;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sxlw.vo.ResVo;
import com.sxlw.vo.TableDesign;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wr
 * @since 2023-01-30
 */
public interface SeriesService extends IService<Series> {

    ResVo<TableDesign> getTableDesign();

    ResVo<List<Series>> getSeriesList();

    ResVo<Series> updateSeries(Series series);

    ResVo<Series> gnrtSeries(Series series);
}
