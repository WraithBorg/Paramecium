package com.zxu.service.usb;

import com.zxu.common.domain.UserInfo;

public interface UserInfoService {

    UserInfo getUserByTelephone(String telePhone);
}
