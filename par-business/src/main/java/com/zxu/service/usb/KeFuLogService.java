package com.zxu.service.usb;

import com.zxu.common.domain.KeFuLogInfo;
import com.zxu.common.domain.UserInfo;

import java.util.List;

public interface KeFuLogService {
    /**
     * 获取用户客服记录列表
     */
    List<KeFuLogInfo> getMyLog(UserInfo currentUser);

}