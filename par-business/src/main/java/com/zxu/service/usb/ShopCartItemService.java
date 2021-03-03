package com.zxu.service.usb;

import com.zxu.domain.ShopCartItemDo;

import java.util.List;

public interface ShopCartItemService {
    List<ShopCartItemDo> getShopCartInfo(String userId);

    void addItem(String userId, String productid, String amount);
}
