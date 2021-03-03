package com.zxu.service.usb;

import com.zxu.domain.ReceiptDo;
import com.zxu.domain.UserDo;

import java.util.List;

public interface ReceiptInfoService {
    public ReceiptDo selectById(String id);

    void insert(UserDo currentUser, ReceiptDo receiptInfo);

    List<ReceiptDo> selectList(String userId);

    public void updateById(ReceiptDo receiptInfo);

    public void deleteById(String id);
}
