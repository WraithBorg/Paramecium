package com.zxu.convert;

//import com.zxu.FfileServer;

import com.zxu.constant.PageConst;
import com.zxu.constant.UploadConst;
import com.zxu.domain.UserDo;
import com.zxu.util.CustomUtils;
import com.zxu.vo.UserInfoVO;
import com.zxu.vo.UserPassVO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserInfoConvert {
//    @Resource
//    private FfileServer ffileServer;

    public UserInfoVO getUserVO (UserDo userInfo) {
        UserInfoVO vo = new UserInfoVO();
        vo.setBirthday(CustomUtils.formatDate(new Date()));
        vo.setCreatetime(CustomUtils.formatDate(new Date()));
        vo.setFollow_num(0);
        vo.setFollowed_num(0);
        vo.setGender(0);
        vo.setGold(0);
        vo.setGrade(0);
        vo.setInvite_userid(0L);
        vo.setIs_auth(0);
        vo.setLasttime(CustomUtils.formatDate(new Date()));
        vo.setMoney("0.00");
        vo.setNickname(userInfo.getNickName());
        vo.setStatus(10);
        vo.setTelephone(userInfo.getTelePhone());
        vo.setUser_head(PageConst.IMG_PATH + UploadConst.HEAD_IMAGE + userInfo.getHeadImgUrl());
        vo.setUser_type(1);
        vo.setUserid(userInfo.getId());
        vo.setUsername(userInfo.getNickName());
        return vo;
    }

    public UserPassVO getUserPassVO (UserDo userInfo) {
        UserPassVO vo = new UserPassVO();
        vo.setGender(0);
        vo.setGold(0);
        vo.setGender(0);
        vo.setMoney("0");
        vo.setNickname(userInfo.getNickName());
        vo.setUser_head(PageConst.IMG_PATH + UploadConst.HEAD_IMAGE + userInfo.getHeadImgUrl());
        vo.setUserid(userInfo.getId());
        vo.setUsername(userInfo.getNickName());
        return vo;
    }
}
