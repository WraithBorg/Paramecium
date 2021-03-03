package com.zxu.service;

import com.zxu.domain.UserFavItemDo;
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
        List<UserFavItemDo> userFavItemInfos = userFavItemMapper.selectByMap(CustomUtils.ofMap(UserFavItemDo.t.user_id, userId, UserFavItemDo.t.item_id, itemId));
        if (userFavItemInfos.size() > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public String favItem(String userId, String itemId) {
        List<UserFavItemDo> userFavItemInfos = userFavItemMapper.selectByMap(CustomUtils.ofMap(UserFavItemDo.t.user_id, userId, UserFavItemDo.t.item_id, itemId));
        if (userFavItemInfos.size() == 0) {
            UserFavItemDo info = new UserFavItemDo();
            info.setUserId(userId);
            info.setItemId(itemId);
            userFavItemMapper.insert(info);
            return "add";
        }
        userFavItemInfos.forEach(m -> userFavItemMapper.deleteById(m.getId()));
        return "delete";
    }
}
