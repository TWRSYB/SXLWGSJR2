package com.sxlw.cont;


import com.alibaba.fastjson2.JSON;
import com.sxlw.daoVo.Actress;
import com.sxlw.svc.ActressService;
import com.sxlw.vo.TableDesign;
import com.sxlw.vo.ResVo;
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
 * @since 2022-12-17
 */
@RestController
@RequestMapping("/actress")
public class ActressController {

    @Autowired
    private ActressService actressService;

    @PostMapping("/addActress")
    public String addActress(@RequestBody Actress actress){
        System.out.println("actress = " + actress);
        //actressService.addActress(actress);
        return "完成";
    }

    @PostMapping("/nameSearch")
    public ResVo<Map<String, Object>> nameSearch(@RequestBody Map<String, Object> map){
        return actressService.nameSearch(map);
    }

    @GetMapping("/queryActressList")
    public List<Actress> queryActressList(){
        return actressService.queryActressList();
    }

    @GetMapping("/getTableDesign")
    public ResVo<TableDesign> getTableDesign(){
        return actressService.getTableDesign();
    }

    @PostMapping("/gnrtActressNo")
    public ResVo<Actress> gnrtActressNo(@RequestBody Map<String, Object> map){
        return actressService.gnrtActressNo(map);
    }

    @PostMapping("/updateActress")
    public ResVo<Actress> updateActress(@RequestBody Map<String, Object> map){
        return actressService.updateActress(map);
    }

}

