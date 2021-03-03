package com.zxu.controller;

import com.zxu.util.SessionUtil;
import com.zxu.common.domain.KeFuLogInfo;
import com.zxu.common.domain.UserInfo;
import com.zxu.constant.PageConst;
import com.zxu.convert.KeFuLogConvert;
import com.zxu.dto.KeFuLogDTO;
import com.zxu.mapper.KeFuLogMapper;
import com.zxu.mapper.UserInfoMapper;
import com.zxu.result.MsgResult;
import com.zxu.service.usb.KeFuLogService;
import com.zxu.util.CustomUtils;
import com.zxu.vo.KeFuLogVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 客服
 */

@RestController
public class KeFuController {
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private KeFuLogConvert keFuLogConvert;
    @Resource
    private KeFuLogMapper keFuLogMapper;
    @Resource
    private KeFuLogService keFuLogService;
    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 获取客服记录
     */
    @GetMapping("/kefu/mykefu")
    public MsgResult mykefu() {
        UserInfo currentUser = SessionUtil.getCurrentUser(httpServletRequest);
        List<KeFuLogInfo> list = keFuLogService.getMyLog(currentUser);
        List<KeFuLogVO> vos = keFuLogConvert.getKeFuLogVOS(list);
        Map data = CustomUtils.ofMap("list", vos);
        return MsgResult.doneUrl(data, PageConst.KEFU_INDEX);
    }

    /**
     * 保存客服记录
     */
    @PostMapping("/kefu/savelog")
    public Object MsgResult(KeFuLogDTO keFuLogDTO) {
        UserInfo currentUser = SessionUtil.getCurrentUser(httpServletRequest);
        KeFuLogInfo info = new KeFuLogInfo();
        info.setUserId(currentUser.getId());
        info.setCreateTime(new Date());
        info.setStatus(1);
        info.setContent(keFuLogDTO.getContent());
        keFuLogMapper.insert(info);
        return MsgResult.doneUrl(new ArrayList<>(), PageConst.KEFU_INDEX);
    }

}

