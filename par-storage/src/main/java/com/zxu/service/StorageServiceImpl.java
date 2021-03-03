package com.zxu.service;

import com.zxu.domain.StorageDo;
import com.zxu.mapper.StorageMapper;
import com.zxu.service.usb.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;
    @Override
    public StorageDo get(){
        return storageMapper.selectList(null).get(0);
    }
}
