package com.zxu.service;

import com.zxu.domain.ReceiptDo;
import com.zxu.domain.UserDo;
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
    public ReceiptDo selectById(String id) {
        ReceiptDo receiptInfo = receiptInfoMapper.selectById(id);
        return receiptInfo;
    }

    @Override
    public void insert(UserDo currentUser, ReceiptDo receiptInfo) {
        receiptInfo.setUserId(currentUser.getId());
        receiptInfoMapper.insert(receiptInfo);
    }

    @Override
    public void deleteById(String id) {
        receiptInfoMapper.deleteById(id);
    }

    @Override
    public void updateById(ReceiptDo receiptInfo) {
        receiptInfoMapper.updateById(receiptInfo);
    }

    @Override
    public List<ReceiptDo> selectList(String userId) {
        List<ReceiptDo> receiptInfoList = receiptInfoMapper.selectByMap(CustomUtils.ofMap(ReceiptDo.t.user_id, userId));
        return receiptInfoList;
    }
}
