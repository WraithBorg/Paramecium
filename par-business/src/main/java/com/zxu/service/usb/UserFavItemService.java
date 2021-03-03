package com.zxu.service.usb;

public interface UserFavItemService {
    /**
     * 查看是否该商品是否在收藏夹里
     */
    Integer hasFav(String userId, String itemId);
    /**
     * 收藏商品
     */
    String favItem(String userId, String objectid);
}
