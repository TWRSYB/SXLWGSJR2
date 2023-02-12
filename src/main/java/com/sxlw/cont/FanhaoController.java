package com.sxlw.cont;


import com.sxlw.daoVo.Fanhao;
import com.sxlw.svc.FanhaoService;
import com.sxlw.vo.FanhaoMix;
import com.sxlw.vo.ResVo;
import com.sxlw.vo.TableDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wr
 * @since 2022-12-14
 */
@RestController
@RequestMapping("/fanhao")
public class FanhaoController {

    @Autowired
    private FanhaoService fanhaoService;

    /**
     * 添加番号
     * @param fanhhao
     * @return
     */
    @PostMapping("/addFanhao")
    public String addFanhao(@RequestBody Fanhao fanhhao){
        System.out.println("fanhhao = " + fanhhao);
        fanhaoService.addFanhao(fanhhao);
        return "完成";
    }

    /**
     * 查询番号列表
     * @return
     */
    @GetMapping("/queryFanhaoList")
    public List<Fanhao> queryFanhaoList(){
        return fanhaoService.queryFanhaoList();
    }

    /**
     * 获取表设计
     * @return
     */
    @GetMapping("/getTableDesign")
    public ResVo<TableDesign> getTableDesign(){
        return fanhaoService.getTableDesign();
    }


    /**
     * 搜索番号
     * @param map
     * @return
     */
    @PostMapping("/fanhaoSearch")
    public ResVo<List<FanhaoMix>> fanhaoSearch(@RequestBody Map<String, String> map){
        return fanhaoService.fanhaoSearch(map);
    }


    /**
     * 生成番号
     * @param fanhao
     * @return
     */
    @PostMapping("/gnrtFanhao")
    public ResVo<Fanhao> gnrtFanhao(@RequestBody Fanhao fanhao){
        return fanhaoService.gnrtFanhao(fanhao);
    }

    /**
     * 更新番号
     * @param fanhao
     * @return
     */
    @PostMapping("/updateFanhao")
    public ResVo<Fanhao> updateFanhao(@RequestBody Fanhao fanhao){
        return fanhaoService.updateFanhao(fanhao);
    }




}

