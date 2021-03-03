package com.zxu.service;

import com.zxu.common.domain.UserFavItemInfo;
import com.zxu.mapper.UserFavItemMapper;
import com.zxu.service.usb.UserFavItemService;
import com.zxu.util.CustomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserFavItemServiceImpl implements UserFavItemService {

    @Resource
    private UserFavItemMapper userFavItemMapper;

    @Override
    public Integer hasFav(String userId, String itemId) {
        List<UserFavItemInfo> userFavItemInfos = userFavItemMapper.selectByMap(CustomUtils.ofMap(UserFavItemInfo.t.user_id, userId, UserFavItemInfo.t.item_id, itemId));
        if (userFavItemInfos.size() > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public String favItem(String userId, String itemId) {
        List<UserFavItemInfo> userFavItemInfos = userFavItemMapper.selectByMap(CustomUtils.ofMap(UserFavItemInfo.t.user_id, userId, UserFavItemInfo.t.item_id, itemId));
        if (userFavItemInfos.size() == 0) {
            UserFavItemInfo info = new UserFavItemInfo();
            info.setUserId(userId);
            info.setItemId(itemId);
            userFavItemMapper.insert(info);
            return "add";
        }
        userFavItemInfos.forEach(m -> userFavItemMapper.deleteById(m.getId()));
        return "delete";
    }
}
