package com.zxu.service;

import com.zxu.domain.StorageDo;
import com.zxu.mapper.StorageMapper;
import com.zxu.service.usb.StorageService;
import com.zxu.util.CustomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    /**
     * 查询品项库存数
     */
    @Override
    public StorageDo queryInventory(String commodityCode) {
        List<StorageDo> storageDos = storageMapper.selectByMap(CustomUtils.ofMap(StorageDo.t.commodityCode, commodityCode));
        if (storageDos.size() == 0) {
            StorageDo accountDo = new StorageDo();
            accountDo.setCommodityCode(commodityCode);
            accountDo.setCount(0);
            storageMapper.insert(accountDo);
            return accountDo;
        }
        return storageDos.get(0);
    }

    /**
     * 加库存
     */
    @Override
    public void plusInventory(String commodityCode, Integer amount) {
        StorageDo inventory = queryInventory(commodityCode);
        inventory.setCount(inventory.getCount() + amount);
        storageMapper.updateById(inventory);
    }

    /**
     * 减库存
     */
    @Override
    public void minusInventory(String commodityCode, Integer amount) {
        StorageDo inventory = queryInventory(commodityCode);
        inventory.setCount(inventory.getCount() - amount);
        storageMapper.updateById(inventory);
    }


}
