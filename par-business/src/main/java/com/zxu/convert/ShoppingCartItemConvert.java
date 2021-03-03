package com.zxu.convert;

import com.zxu.common.domain.ShopCartItemInfo;
import com.zxu.constant.PageConst;
import com.zxu.util.DDateUtil;
import com.zxu.util.DDecimalUtil;
import com.zxu.vo.ShopCartItemVO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShoppingCartItemConvert {


    public ShopCartItemVO getShoppingCartItemVO(ShopCartItemInfo info) {
        ShopCartItemVO vo = new ShopCartItemVO();
        vo.setAmount(DDecimalUtil.toInt(info.getAmount()));
        vo.setCreatetime(DDateUtil.format(info.getCreateTime()));
        vo.setEtime(0);
        vo.setId(info.getId());
        vo.setImgurl(PageConst.IMG_PATH + "index_flash_01.png");
        vo.setKs_title("");
        vo.setKsid(0L);
        vo.setOtype("");
        vo.setPrice(DDecimalUtil.format(info.getPrice()));
        vo.setProductid(info.getItemId());
        vo.setPt_price("0");
        vo.setStime(0);
        vo.setTitle(info.getItemName());
        vo.setTotal_num(1000);//库存量
        vo.setUserid(info.getUserId());
        vo.setWeight(null);
        return vo;
    }

    public List<ShopCartItemVO> getShoppingCartItemVOS(List<ShopCartItemInfo> cartItemInfos) {
        List<ShopCartItemVO> shopCartItemVOS = cartItemInfos.stream().map(m -> getShoppingCartItemVO(m)).collect(Collectors.toList());
        return shopCartItemVOS;
    }
}
