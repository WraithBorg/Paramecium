package com.zxu.service;

import com.zxu.domain.UserDo;
import com.zxu.mapper.UserInfoMapper;
import com.zxu.service.usb.UserInfoService;
import com.zxu.util.CustomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

//    @Override
//    public UserInfo getDefaultUser() {
//        return userInfoMapper.getDefaultUser();
//    }

    @Override
    public UserDo getUserByTelephone(String telePhone) {
        List<UserDo> userInfos = userInfoMapper.selectByMap(CustomUtils.ofMap(UserDo.t.telephone, telePhone));
        if (userInfos.size() == 0) {
            return null;
        }
        return userInfos.get(0);
    }
}
