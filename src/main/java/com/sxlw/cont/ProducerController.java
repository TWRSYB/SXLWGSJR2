package com.sxlw.cont;


import com.sxlw.daoVo.Producer;
import com.sxlw.svc.ProducerService;
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
 * @since 2023-01-15
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;


    @PostMapping("/getProducerList")
    public ResVo<List<Producer>> getProducerList(){
        return producerService.getProducerList();
    }

    @PostMapping("/getTableDesign")
    public ResVo<TableDesign> getTableDesign(@RequestBody Map map){
        return producerService.getTableDesign();
    }


    @PostMapping("/updateProducer")
    public ResVo<Producer> updateProducer(@RequestBody Producer producer){
        return producerService.updateProducer(producer);
    }

}

