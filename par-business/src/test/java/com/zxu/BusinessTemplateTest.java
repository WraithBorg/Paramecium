package com.zxu;

import com.alibaba.fastjson.JSON;
import com.zxu.client.AccountClient;
import com.zxu.client.OrderClient;
import com.zxu.client.StorageClient;
import com.zxu.constant.CConstant;
import com.zxu.result.DockResult;
import com.zxu.util.CustomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BusinessTemplateTest {
    @Resource
    private AccountClient accountClient;
    @Resource
    private OrderClient orderClient;
    @Resource
    private StorageClient storageClient;

    @Test
    public void testStorage() {
        String commodityCode = "2001";
        Map<String, String> map = CustomUtils.ofMap(CConstant.COMMODITY_CODE, commodityCode);
        storageClient.queryInventory(JSON.toJSONString(map));

        Map map2 = CustomUtils.ofMap(CConstant.COMMODITY_CODE, commodityCode, CConstant.AMOUNT, 10);
        storageClient.plusInventory(JSON.toJSONString(map2));

        Map map3 = CustomUtils.ofMap(CConstant.COMMODITY_CODE, commodityCode, CConstant.AMOUNT, 7);
        storageClient.minusInventory(JSON.toJSONString(map3));
    }

    @Test
    public void testAccount() {
        String userId = "anc1";
        Map<String, String> map = CustomUtils.ofMap(CConstant.USER_ID, userId);
        DockResult account = accountClient.getAccount(JSON.toJSONString(map));

        Map map2 = CustomUtils.ofMap(CConstant.USER_ID, userId, CConstant.AMOUNT, new BigDecimal(12));
        accountClient.charge(JSON.toJSONString(map2));

        Map map3 = CustomUtils.ofMap(CConstant.USER_ID, userId, CConstant.AMOUNT, new BigDecimal(10));
        accountClient.deduct(JSON.toJSONString(map3));

    }
}
