package com.zxu.service.usb;

import com.zxu.domain.ShopCartItemInfo;

import java.util.List;

public interface ShopCartItemService {
    List<ShopCartItemInfo> getShopCartInfo(String userId);

    void addItem(String userId, String productid, String amount);
}
