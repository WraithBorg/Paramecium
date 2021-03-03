package com.zxu.service.usb;

import com.zxu.common.domain.ShopCartItemInfo;

import java.util.List;

public interface ShopCartItemService {
    List<ShopCartItemInfo> getShopCartInfo(String userId);

    void addItem(String userId, String productid, String amount);
}
