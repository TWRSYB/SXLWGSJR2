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

    @PostMapping("/addFanhao")
    public String addFanhao(@RequestBody Fanhao fanhhao){
        System.out.println("fanhhao = " + fanhhao);
        fanhaoService.addFanhao(fanhhao);
        return "完成";
    }

    @GetMapping("/queryFanhaoList")
    public List<Fanhao> queryFanhaoList(){
        return fanhaoService.queryFanhaoList();
    }

    @GetMapping("/getTableDesign")
    public ResVo<TableDesign> getTableDesign(){
        return fanhaoService.getTableDesign();
    }

    @PostMapping("/fanhaoSearch")
    public ResVo<List<FanhaoMix>> fanhaoSearch(@RequestBody Map<String, String> map){
        return fanhaoService.fanhaoSearch(map);
    }

}

