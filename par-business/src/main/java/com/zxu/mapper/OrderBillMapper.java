package com.zxu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxu.domain.OrderBill;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface OrderBillMapper extends BaseMapper<OrderBill> {
    @Select(" select * from order_bill where user_id = #{userId}")
    List<OrderBill> getMyOrder(String userId);
}
