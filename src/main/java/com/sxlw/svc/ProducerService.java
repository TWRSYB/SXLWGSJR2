package com.sxlw.svc;

import com.sxlw.daoVo.Producer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sxlw.vo.ResVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wr
 * @since 2023-01-15
 */
public interface ProducerService extends IService<Producer> {

    ResVo<List<Producer>> getProducerList();
}
