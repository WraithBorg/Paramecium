package com.zxu.convert;

import com.zxu.common.domain.ItemInfo;
import com.zxu.common.domain.ShopCartItemInfo;
import com.zxu.common.domain.UserInfo;
import com.zxu.constant.PageConst;
import com.zxu.mapper.ShopCartItemMapper;
import com.zxu.service.usb.UserInfoService;
import com.zxu.util.CCommonUtils;
import com.zxu.util.DDateUtil;
import com.zxu.util.DDecimalUtil;
import com.zxu.vo.ItemInfo4IndexVO;
import com.zxu.vo.ItemInfoVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品信息
 */
@Component
public class ItemInfoConvert {
    @Resource
    private ShopCartItemMapper shopCartItemMapper;
    @Resource
    private UserInfoService userInfoService;

    public List<ItemInfoVO> getItemInfoVOS(UserInfo currentUser, List<ItemInfo> itemInfos) {
        List<ItemInfoVO> itemInfoVOS = itemInfos.stream().map(m -> getItemInfoVO(currentUser,m)).collect(Collectors.toList());
        return itemInfoVOS;
    }

    public ItemInfoVO getItemInfoVO(UserInfo currentUser,ItemInfo itemInfo) {
        Integer cartAmount;
        if (currentUser == null){
            cartAmount = 0;
        }else {
            ShopCartItemInfo cartItemInfo = shopCartItemMapper.getByUserItem(itemInfo.getId(), currentUser.getId());
            if(cartItemInfo == null){
                cartAmount = 0;
            }else {
                cartAmount = DDecimalUtil.toInt(cartItemInfo.getAmount());
            }
        }

        //
        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setBuy_num(itemInfo.getBuyNum());
        itemInfoVO.setCart_amount(cartAmount);
        itemInfoVO.setCatid(itemInfo.getCategoryId());
        itemInfoVO.setCreatetime(DDateUtil.format(new Date()));
        itemInfoVO.setDescription(itemInfo.getName());
        itemInfoVO.setId(itemInfo.getId());
        itemInfoVO.setImgsdata(itemInfo.getDefaultImg());
        if (CCommonUtils.isNotBlank(itemInfo.getDefaultImg())) {
            itemInfoVO.setImgurl(PageConst.IMG_PATH + "hot_book.png");
        }else {
            itemInfoVO.setImgurl(PageConst.IMG_PATH + "hot_book.png");
        }

        itemInfoVO.setIncart(cartAmount > 0 ? 1 : 0);
        itemInfoVO.setPrice(DDecimalUtil.format(itemInfo.getPrice()));
        itemInfoVO.setTitle(itemInfo.getName());
        itemInfoVO.setWeight(DDecimalUtil.format(itemInfo.getWeight()));
        itemInfoVO.setContent(itemInfo.getContent());
        // DEFAULT
        itemInfoVO.setEtime(0);
        itemInfoVO.setEx_table_data_id(0);
        itemInfoVO.setEx_table_id(0);
        itemInfoVO.setIshot(1);
        itemInfoVO.setIsksid(0);
        itemInfoVO.setFav_num(1);
        itemInfoVO.setIsnew(1);
        itemInfoVO.setIsrecommend(1);
        itemInfoVO.setKs_label_name("");
        itemInfoVO.setKs_label_size("");
        itemInfoVO.setLower_price("0");
        itemInfoVO.setMarket_price("0");
        itemInfoVO.setMonth_buy_num(0);
        itemInfoVO.setOtype("");
        itemInfoVO.setPt_min(0);
        itemInfoVO.setPt_open(0);
        itemInfoVO.setPt_price("0");
        itemInfoVO.setStatus(1);
        itemInfoVO.setStime(0);
        itemInfoVO.setTotal_num(99);
        itemInfoVO.setUpdatetime(DDateUtil.format(new Date()));
        itemInfoVO.setVideourl("");
        itemInfoVO.setView_num(550);

        return itemInfoVO;
    }

    public List<ItemInfo4IndexVO> getItemInfo4IndexVOS(List<ItemInfo> itemInfos) {
        List<ItemInfo4IndexVO> itemInfoVOS = itemInfos.stream().map(this :: getItemInfo4IndexVO).collect(Collectors.toList());
        return itemInfoVOS;
    }

    public ItemInfo4IndexVO getItemInfo4IndexVO(ItemInfo itemInfo) {
        ItemInfo4IndexVO itemInfoVO = new ItemInfo4IndexVO();
        itemInfoVO.setBuy_num(itemInfo.getBuyNum());
        itemInfoVO.setId(itemInfo.getId());
        if (CCommonUtils.isNotBlank(itemInfo.getDefaultImg())) {
            itemInfoVO.setImgurl( PageConst.IMG_PATH + "index_flash_01.png");
        }else{
            itemInfoVO.setImgurl( PageConst.IMG_PATH + "index_flash_01.png");
        }

        itemInfoVO.setPrice(DDecimalUtil.format(itemInfo.getPrice()));
        itemInfoVO.setTitle(itemInfo.getName());
        // DEFAULT
        itemInfoVO.setEtime(0);
        itemInfoVO.setLower_price("0");
        itemInfoVO.setMarket_price("0");
        itemInfoVO.setMonth_buy_num(0);
        itemInfoVO.setOtype("");
        itemInfoVO.setPt_open(0);
        itemInfoVO.setPt_price("0");
        itemInfoVO.setStime(0);
        itemInfoVO.setTotal_num(99);
        itemInfoVO.setOrderindex(99);
        itemInfoVO.setProductid(itemInfo.getId());
        return itemInfoVO;
    }
}
