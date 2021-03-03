package com.zxu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxu.domain.OrderLogisticsDo;
import org.apache.ibatis.annotations.Select;

public interface OrderLogisticsMapper extends BaseMapper<OrderLogisticsDo> {

    @Select(" select * from order_logistics where order_id = #{orderId} limit 1")
    public OrderLogisticsDo getByOrderId(String orderId);
}
