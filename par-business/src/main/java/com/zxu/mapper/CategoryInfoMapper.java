package com.zxu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxu.domain.CategoryDo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryInfoMapper extends BaseMapper<CategoryDo> {

    @Select(" select * from category_info limit 5 ")
    List<CategoryDo> getCats4Index();
}
