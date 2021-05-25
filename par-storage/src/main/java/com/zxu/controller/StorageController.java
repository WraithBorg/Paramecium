package com.zxu.controller;

import com.zxu.constant.Uri4Storage;
import com.zxu.constant.CConstant;
import com.zxu.domain.StorageDo;
import com.zxu.result.DockResult;
import com.zxu.service.usb.StorageService;
import com.zxu.util.CustomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class StorageController {
    @Resource
    private StorageService storageService;

    /**
     * 查询库存数
     */
    @ResponseBody
    @RequestMapping(Uri4Storage.QUERY_INVENTORY)
    public DockResult<StorageDo> queryInventory(@RequestBody Map map) {
        Object reqBody = map.get(CConstant.COMMODITY_CODE);
        if (reqBody == null || CustomUtils.isBlank((String) reqBody)) {
            return DockResult.fail("ID无法识别");
        }
        String commodityCode = (String) reqBody;
        StorageDo storageDo = storageService.queryInventory(commodityCode);
        return DockResult.done(storageDo);
    }

    /**
     * 加库存
     */
    @ResponseBody
    @RequestMapping(Uri4Storage.PLUS_INVENTORY)
    public DockResult plusInventory(@RequestBody Map map) {
        String commodityCode = (String) map.get(CConstant.COMMODITY_CODE);
        Integer amount = (Integer) map.get(CConstant.AMOUNT);
        storageService.plusInventory(commodityCode,amount);
        return DockResult.done();
    }

    /**
     * 减库存
     */
    @ResponseBody
    @RequestMapping(Uri4Storage.MINUS_INVENTORY)
    public DockResult minusInventory(@RequestBody Map map) {
        String commodityCode = (String) map.get(CConstant.COMMODITY_CODE);
        Integer amount = (Integer) map.get(CConstant.AMOUNT);
        storageService.minusInventory(commodityCode,amount);
        return DockResult.done();
    }
}
