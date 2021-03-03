package com.zxu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxu.common.domain.ItemInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemInfoMapper extends BaseMapper<ItemInfo> {
    @Select(" select * from item_info order by buy_num limit 2 ")
    List<ItemInfo> selectBiMaiList();

    @Select(" select * from item_info order by buy_num limit 2,10 ")
    List<ItemInfo> selectHotSaleList();
}
