package com.sxlw.cont;


import com.sxlw.daoVo.Fanhao;
import com.sxlw.svc.FanhaoService;
import com.sxlw.svc.TableService;
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
@RequestMapping("/table")
public class TableController {

    @Autowired
    private TableService tableService;



    @GetMapping("/getTableDesign")
    public Map getTableDesign(String tableName){
        System.out.println("tableName = " + tableName);
        return tableService.getTableDesign(tableName);
    }

}

