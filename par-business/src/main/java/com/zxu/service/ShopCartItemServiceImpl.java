package com.zxu.service;

import com.zxu.common.domain.ItemInfo;
import com.zxu.common.domain.ItemInfoImg;
import com.zxu.common.domain.ShopCartItemInfo;
import com.zxu.mapper.ItemInfoImgMapper;
import com.zxu.mapper.ItemInfoMapper;
import com.zxu.mapper.ShopCartItemMapper;
import com.zxu.service.usb.ShopCartItemService;
import com.zxu.util.CCommonUtils;
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
    public List<ShopCartItemInfo> getShopCartInfo(String userId) {
        List<ShopCartItemInfo> itemInfoList = shopCartItemMapper.selectByMap(CCommonUtils.ofMap(ShopCartItemInfo.t.user_id, userId));
        return itemInfoList;
    }

    /**
     * 添加品项
     */
    @Override
    public void addItem(String userId, String itemId, String amount) {
        List<ShopCartItemInfo> cartItemInfos = shopCartItemMapper.selectByMap(CCommonUtils.ofMap(ShopCartItemInfo.t.user_id, userId, ShopCartItemInfo.t.item_id, itemId));
        BigDecimal itemAmount = new BigDecimal(amount);
        ShopCartItemInfo cartItemInfo = null;
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
        ItemInfo itemInfo = itemInfoMapper.selectById(itemId);
        List<ItemInfoImg> itemInfoImgs = itemInfoImgMapper.selectByMap(CCommonUtils.ofMap(ItemInfoImg.t.item_id, itemId));
        String itemImgUrl = null;
        if (itemInfoImgs.size() > 0) {
            itemImgUrl = itemInfoImgs.get(0).getUrl();
        }
        ShopCartItemInfo newCartItemInfo = new ShopCartItemInfo();
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
