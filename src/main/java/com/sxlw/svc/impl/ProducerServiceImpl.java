package com.sxlw.svc.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxlw.daoVo.Producer;
import com.sxlw.mapper.ProducerMapper;
import com.sxlw.svc.ProducerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxlw.vo.ResVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wr
 * @since 2023-01-15
 */
@Service
public class ProducerServiceImpl extends ServiceImpl<ProducerMapper, Producer> implements ProducerService {

    @Autowired
    private ProducerMapper producerMapper;


    @Override
    public ResVo<List<Producer>> getProducerList() {
        ResVo<List<Producer>> resVo = new ResVo<>();

        List<Producer> producerList = producerMapper.selectList(new QueryWrapper<>());

        resVo.setCode("200");
        resVo.setMsg("获取厂商列表成功");
        resVo.setObj(producerList);
        return resVo;

    }
}
