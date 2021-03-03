package com.zxu.service.usb;

import com.zxu.common.domain.ItemInfo;

import java.util.List;

public interface ItemInfoService {
    ItemInfo getItemWithImg(String id);

    List<ItemInfo> selectListWithImg();

    public List<ItemInfo> selectListWithImg(List<ItemInfo> itemInfos);
}
