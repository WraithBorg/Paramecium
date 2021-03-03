package com.zxu.service;

import com.zxu.domain.ItemDo;
import com.zxu.domain.ItemImgDo;
import com.zxu.mapper.ItemInfoImgMapper;
import com.zxu.mapper.ItemInfoMapper;
import com.zxu.service.usb.ItemInfoService;
import com.zxu.util.CustomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemInfoServiceImpl implements ItemInfoService {
    @Resource
    private ItemInfoMapper itemInfoMapper;
    @Resource
    private ItemInfoImgMapper itemInfoImgMapper;

    /**
     * 查询品项和默认图片
     *
     * @param id
     * @return
     */
    @Override
    public ItemDo getItemWithImg(String id) {
        ItemDo itemInfo = itemInfoMapper.selectById(id);
        List<ItemImgDo> itemInfoImgs = itemInfoImgMapper.selectByMap(CustomUtils.ofMap(ItemImgDo.t.item_id, id));
        if (itemInfoImgs.size() > 0) {
            itemInfo.setDefaultImg(itemInfoImgs.get(0).getUrl());
        }
        return itemInfo;
    }

    /**
     * 获取商品信息以及图片
     */
    @Override
    public List<ItemDo> selectListWithImg() {
        List<ItemDo> itemInfos = itemInfoMapper.selectList(null);
        itemInfos.forEach(m -> {
            List<ItemImgDo> itemInfoImgs = itemInfoImgMapper.selectByMap(CustomUtils.ofMap(ItemImgDo.t.item_id, m.getId(), ItemImgDo.t.default_flag, "1"));
            if (itemInfoImgs.size() > 0) {
                m.setDefaultImg(itemInfoImgs.get(0).getUrl());
            }
        });
        return itemInfos;
    }

    @Override
    public List<ItemDo> selectListWithImg(List<ItemDo> itemInfos) {

        itemInfos.forEach(m -> {
            List<ItemImgDo> itemInfoImgs = itemInfoImgMapper.selectByMap(CustomUtils.ofMap(ItemImgDo.t.item_id, m.getId(), ItemImgDo.t.default_flag, "1"));
            if (itemInfoImgs.size() > 0) {
                m.setDefaultImg(itemInfoImgs.get(0).getUrl());
            }
        });
        return itemInfos;
    }
}
