import com.alibaba.fastjson.JSON;
import com.zxu.dto.OrderBill4kfk;

import java.util.Date;

public class Test {
    public static void main (String[] args) {
        OrderBill4kfk order = new OrderBill4kfk();
        order.setBillNo("BN0001");
        order.setCreateDate(new Date());
        order.setNote("beizhu");
        System.out.println(JSON.toJSONString(order));
        // {"billNo":"BN0001","createDate":1622794174748,"note":"beizhu"}
    }
}

