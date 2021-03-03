package com.zxu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxu.domain.OrderBillDo;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface OrderBillMapper extends BaseMapper<OrderBillDo> {
    @Select(" select * from order_bill where user_id = #{userId}")
    List<OrderBillDo> getMyOrder(String userId);
}
