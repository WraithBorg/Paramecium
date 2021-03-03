package com.zxu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxu.common.domain.OrderLogistics;
import org.apache.ibatis.annotations.Select;

public interface OrderLogisticsMapper extends BaseMapper<OrderLogistics> {

    @Select(" select * from order_logistics where order_id = #{orderId} limit 1")
    public OrderLogistics getByOrderId(String orderId);
}
