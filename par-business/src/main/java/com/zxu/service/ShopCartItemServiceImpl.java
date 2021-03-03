package com.zxu.service;

import com.zxu.domain.ItemDo;
import com.zxu.domain.ItemImgDo;
import com.zxu.domain.ShopCartItemDo;
import com.zxu.mapper.ItemInfoImgMapper;
import com.zxu.mapper.ItemInfoMapper;
import com.zxu.mapper.ShopCartItemMapper;
import com.zxu.service.usb.ShopCartItemService;
import com.zxu.util.CustomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ShopCartItemServiceImpl implements ShopCartItemService {
    @Resource
    private ShopCartItemMapper shopCartItemMapper;
    @Resource
    private ItemInfoMapper itemInfoMapper;
    @Resource
    private ItemInfoImgMapper itemInfoImgMapper;

    /**
     * 查询购物车信息
     */
    @Override
    public List<ShopCartItemDo> getShopCartInfo(String userId) {
        List<ShopCartItemDo> itemInfoList = shopCartItemMapper.selectByMap(CustomUtils.ofMap(ShopCartItemDo.t.user_id, userId));
        return itemInfoList;
    }

    /**
     * 添加品项
     */
    @Override
    public void addItem(String userId, String itemId, String amount) {
        List<ShopCartItemDo> cartItemInfos = shopCartItemMapper.selectByMap(CustomUtils.ofMap(ShopCartItemDo.t.user_id, userId, ShopCartItemDo.t.item_id, itemId));
        BigDecimal itemAmount = new BigDecimal(amount);
        ShopCartItemDo cartItemInfo = null;
        if (cartItemInfos.size() > 0) {
            cartItemInfo = cartItemInfos.get(0);
        }

        // 删除
        if (cartItemInfo != null && itemAmount.compareTo(BigDecimal.ZERO) <= 0) {
            shopCartItemMapper.deleteById(cartItemInfo.getId());
            return;
        }
        if (cartItemInfo != null) {
            // 修改
            cartItemInfo.setAmount(itemAmount);
            shopCartItemMapper.updateById(cartItemInfo);
            return;
        }
        // 新增
        if (itemAmount.compareTo(BigDecimal.ZERO) == 0) {
            return;
        }
        ItemDo itemInfo = itemInfoMapper.selectById(itemId);
        List<ItemImgDo> itemInfoImgs = itemInfoImgMapper.selectByMap(CustomUtils.ofMap(ItemImgDo.t.item_id, itemId));
        String itemImgUrl = null;
        if (itemInfoImgs.size() > 0) {
            itemImgUrl = itemInfoImgs.get(0).getUrl();
        }
        ShopCartItemDo newCartItemInfo = new ShopCartItemDo();
        newCartItemInfo.setAmount(itemAmount);
        newCartItemInfo.setCreateTime(new Date());
        newCartItemInfo.setItemId(itemId);
        newCartItemInfo.setItemName(itemInfo.getName());
        newCartItemInfo.setItemImgUrl(itemImgUrl);
        newCartItemInfo.setPrice(itemInfo.getPrice());
        newCartItemInfo.setUserId(userId);
        shopCartItemMapper.insert(newCartItemInfo);

    }
}
