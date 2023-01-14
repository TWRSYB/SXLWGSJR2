package com.sxlw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxlw.daoVo.Fanhao;
import com.sxlw.vo.SimpleTableDesign;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wr
 * @since 2022-12-14
 */
@Repository
public interface FanhaoMapper extends BaseMapper<Fanhao> {

    List<SimpleTableDesign> getTableDesign();

    List<Fanhao> likeSearch(String keyWord);
}
