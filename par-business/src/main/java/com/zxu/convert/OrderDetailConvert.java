package com.zxu.convert;

import com.zxu.constant.PageConst;
import com.zxu.constant.UploadConst;
import com.zxu.domain.OrderDetailDo;
import com.zxu.util.DDateUtil;
import com.zxu.util.DDecimalUtil;
import com.zxu.vo.OrderDetailVO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDetailConvert {

    OrderDetailVO getOrderDetailVO (OrderDetailDo info) {

        OrderDetailVO vo = new OrderDetailVO();
        vo.setAmount(info.getAmount());
        vo.setCreatetime(DDateUtil.format(info.getCreateTime()));
        vo.setId(info.getId());
        vo.setImgurl(PageConst.IMG_PATH + UploadConst.ITEM_IMAGE + "index_flash_01.png");
        vo.setPrice(DDecimalUtil.format(info.getItemPrice()));
        vo.setProductid(info.getItemId());
        vo.setTitle(info.getItemName());
        vo.setTotal_num(new BigDecimal(99999));//库存数量
        vo.setUserid(info.getUserId());
        //
        vo.setWeight(null);
        vo.setPt_price("0");
        vo.setStime(0);
        vo.setOtype("");
        vo.setKs_title("");
        vo.setEtime(0);
        return vo;
    }

    List<OrderDetailVO> getOrderDetailVOS (List<OrderDetailDo> infos) {
        List<OrderDetailVO> collect = infos.stream().map(this::getOrderDetailVO).collect(Collectors.toList());
        return collect;
    }
}
