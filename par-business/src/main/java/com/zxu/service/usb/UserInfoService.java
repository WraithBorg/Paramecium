package com.zxu.service.usb;

import com.zxu.domain.UserDo;

public interface UserInfoService {

    UserDo getUserByTelephone(String telePhone);
}
