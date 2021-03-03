package com.zxu.service;

import com.zxu.common.domain.ReceiptInfo;
import com.zxu.common.domain.UserInfo;
import com.zxu.mapper.ReceiptInfoMapper;
import com.zxu.service.usb.ReceiptInfoService;
import com.zxu.service.usb.UserInfoService;
import com.zxu.util.CustomUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ReceiptInfoServiceImpl implements ReceiptInfoService {
    @Resource
    private ReceiptInfoMapper receiptInfoMapper;
    @Resource
    private UserInfoService userInfoService;

    @Override
    public ReceiptInfo selectById(String id) {
        ReceiptInfo receiptInfo = receiptInfoMapper.selectById(id);
        return receiptInfo;
    }

    @Override
    public void insert(UserInfo currentUser, ReceiptInfo receiptInfo) {
        receiptInfo.setUserId(currentUser.getId());
        receiptInfoMapper.insert(receiptInfo);
    }

    @Override
    public void deleteById(String id) {
        receiptInfoMapper.deleteById(id);
    }

    @Override
    public void updateById(ReceiptInfo receiptInfo) {
        receiptInfoMapper.updateById(receiptInfo);
    }

    @Override
    public List<ReceiptInfo> selectList(String userId) {
        List<ReceiptInfo> receiptInfoList = receiptInfoMapper.selectByMap(CustomUtils.ofMap(ReceiptInfo.t.user_id, userId));
        return receiptInfoList;
    }
}
