package com.sxlw.cont;


import com.sxlw.daoVo.Producer;
import com.sxlw.svc.ProducerService;
import com.sxlw.vo.ResVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


    @GetMapping("/getProducerList")
    public ResVo<List<Producer>> getProducerList(){
        return producerService.getProducerList();
    }

}

