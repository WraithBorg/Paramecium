package com.zxu.service.usb;

import com.zxu.domain.KeFuLogDo;
import com.zxu.domain.UserDo;

import java.util.List;

public interface KeFuLogService {
    /**
     * 获取用户客服记录列表
     */
    List<KeFuLogDo> getMyLog(UserDo currentUser);

}
