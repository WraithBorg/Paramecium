package com.zxu.service;

 
import com.zxu.domain.KeFuLogInfo;
import com.zxu.domain.UserInfo;
import com.zxu.mapper.KeFuLogMapper;
import com.zxu.mapper.UserInfoMapper;
import com.zxu.service.usb.KeFuLogService;
import com.zxu.util.CustomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KeFuLogServiceImpl implements KeFuLogService {
    @Resource
    private KeFuLogMapper keFuLogMapper;
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<KeFuLogInfo> getMyLog(UserInfo currentUser) {
        List<KeFuLogInfo> keFuLogInfos = keFuLogMapper.selectByMap(CustomUtils.ofMap(KeFuLogInfo.t.user_id, currentUser.getId()));
        return keFuLogInfos;
    }
}
