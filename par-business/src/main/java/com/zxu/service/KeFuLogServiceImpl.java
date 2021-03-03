package com.zxu.service;

 
import com.zxu.domain.KeFuLogDo;
import com.zxu.domain.UserDo;
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
    public List<KeFuLogDo> getMyLog(UserDo currentUser) {
        List<KeFuLogDo> keFuLogInfos = keFuLogMapper.selectByMap(CustomUtils.ofMap(KeFuLogDo.t.user_id, currentUser.getId()));
        return keFuLogInfos;
    }
}
