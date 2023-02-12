package com.sxlw.cont;


import com.sxlw.daoVo.Producer;
import com.sxlw.daoVo.Series;
import com.sxlw.svc.SeriesService;
import com.sxlw.vo.ResVo;
import com.sxlw.vo.TableDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wr
 * @since 2023-01-30
 */
@RestController
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @PostMapping("/getTableDesign")
    public ResVo<TableDesign> getTableDesign(@RequestBody Map map){
        return seriesService.getTableDesign();
    }

    @PostMapping("/getSeriesList")
    public ResVo<List<Series>> getSeriesList(){
        return seriesService.getSeriesList();
    }


    @PostMapping("/updateSeries")
    public ResVo<Series> updateSeries(@RequestBody Series series){
        return seriesService.updateSeries(series);
    }

    @PostMapping("/gnrtSeries")
    public ResVo<Series> gnrtSeries(@RequestBody Series series){
        return seriesService.gnrtSeries(series);
    }

}

