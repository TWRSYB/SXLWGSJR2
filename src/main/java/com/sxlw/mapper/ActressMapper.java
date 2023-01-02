package com.sxlw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxlw.daoVo.Actress;
import com.sxlw.vo.SimpleTableDesign;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wr
 * @since 2022-12-17
 */
@Repository
public interface ActressMapper extends BaseMapper<Actress> {

    String generateKey(String nowDate);


    List<SimpleTableDesign> getTableDesign();


    List<Actress> nameLikeSearch(String name);
}
