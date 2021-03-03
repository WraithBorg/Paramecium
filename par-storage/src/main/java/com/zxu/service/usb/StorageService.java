package com.zxu.service.usb;

import com.zxu.domain.StorageDo;

public interface StorageService {
    StorageDo queryInventory(String commodityCode);

    void plusInventory(String commodityCode, Integer amount);

    void minusInventory(String commodityCode, Integer amount);
    
}
