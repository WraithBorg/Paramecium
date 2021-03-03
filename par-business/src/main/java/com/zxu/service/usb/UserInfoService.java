package com.zxu.service.usb;

import com.zxu.domain.UserInfo;

public interface UserInfoService {

    UserInfo getUserByTelephone(String telePhone);
}
