package com.zxu.service.usb;

import com.zxu.domain.ItemDo;

import java.util.List;

public interface ItemInfoService {
    ItemDo getItemWithImg(String id);

    List<ItemDo> selectListWithImg();

    public List<ItemDo> selectListWithImg(List<ItemDo> itemInfos);
}
