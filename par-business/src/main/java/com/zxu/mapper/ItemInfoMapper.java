package com.zxu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxu.domain.ItemDo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemInfoMapper extends BaseMapper<ItemDo> {
    @Select(" select * from item_info order by buy_num limit 2 ")
    List<ItemDo> selectBiMaiList();

    @Select(" select * from item_info order by buy_num limit 2,10 ")
    List<ItemDo> selectHotSaleList();
}
