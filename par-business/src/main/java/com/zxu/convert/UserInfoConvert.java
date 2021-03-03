package com.zxu.convert;

import com.zxu.FfileServer;
import com.zxu.common.domain.UserInfo;
import com.zxu.constant.PageConst;
import com.zxu.util.CCommonUtils;
import com.zxu.vo.UserInfoVO;
import com.zxu.vo.UserPassVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class UserInfoConvert {
    @Resource
    private FfileServer ffileServer;

    public UserInfoVO getUserVO(UserInfo userInfo) {
        UserInfoVO vo = new UserInfoVO();
        vo.setBirthday(CCommonUtils.formatDate(new Date()));
        vo.setCreatetime(CCommonUtils.formatDate(new Date()));
        vo.setFollow_num(0);
        vo.setFollowed_num(0);
        vo.setGender(0);
        vo.setGold(0);
        vo.setGrade(0);
        vo.setInvite_userid(0L);
        vo.setIs_auth(0);
        vo.setLasttime(CCommonUtils.formatDate(new Date()));
        vo.setMoney("0.00");
        vo.setNickname(userInfo.getNickName());
        vo.setStatus(10);
        vo.setTelephone(userInfo.getTelePhone());
        vo.setUser_head(PageConst.IMG_PATH + userInfo.getHeadImgUrl());
        vo.setUser_type(1);
        vo.setUserid(userInfo.getId());
        vo.setUsername(userInfo.getNickName());
        return vo;
    }

    public UserPassVO getUserPassVO(UserInfo userInfo) {
        UserPassVO vo = new UserPassVO();
        vo.setGender(0);
        vo.setGold(0);
        vo.setGender(0);
        vo.setMoney("0");
        vo.setNickname(userInfo.getNickName());
        vo.setUser_head(ffileServer.getImgUrl()+ userInfo.getHeadImgUrl());
        vo.setUserid(userInfo.getId());
        vo.setUsername(userInfo.getNickName());
        return vo;
    }
}
