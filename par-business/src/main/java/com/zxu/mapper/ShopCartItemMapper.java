package com.zxu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxu.common.domain.ShopCartItemInfo;
import org.apache.ibatis.annotations.Select;

public interface ShopCartItemMapper extends BaseMapper<ShopCartItemInfo> {

    @Select(" select * from shop_cart_item where item_id = #{itemId} and user_id = #{userId}")
    ShopCartItemInfo getByUserItem(String itemId, String userId);


}
