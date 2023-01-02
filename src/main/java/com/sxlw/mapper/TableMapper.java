package com.sxlw.mapper;

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
public interface TableMapper {

    List<SimpleTableDesign> getTableDesign(String tableName);
}
