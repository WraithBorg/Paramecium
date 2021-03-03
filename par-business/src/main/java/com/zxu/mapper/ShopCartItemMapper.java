package com.zxu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxu.domain.ShopCartItemDo;
import org.apache.ibatis.annotations.Select;

public interface ShopCartItemMapper extends BaseMapper<ShopCartItemDo> {

    @Select(" select * from shop_cart_item where item_id = #{itemId} and user_id = #{userId}")
    ShopCartItemDo getByUserItem(String itemId, String userId);


}
