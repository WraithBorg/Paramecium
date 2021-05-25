package com.zxu.controller;

import com.zxu.chip.MultipartContext;
import com.zxu.client.UploadClient;
import com.zxu.constant.PageConst;
import com.zxu.convert.UserInfoConvert;
import com.zxu.domain.UserDo;
import com.zxu.mapper.UserInfoMapper;
import com.zxu.result.DockResult;
import com.zxu.result.MsgResult;
import com.zxu.util.CustomUtils;
import com.zxu.util.SessionUtil;
import com.zxu.vo.UserPassVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 上传附件
 */
@RestController
public class UploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private UserInfoConvert userInfoConvert;

    @Resource
    private UploadClient uploadClient;

    /**
     * 上传用户头像
     */
    @PostMapping("/upload/img/user_head")
    public MsgResult uploadUserHead (@RequestParam("upimg") MultipartFile uploadFile) {
        UserDo currentUser = SessionUtil.getCurrentUser(httpServletRequest);
        try {
            DockResult dockResult = uploadClient.uploadFile(uploadFile);
            if (dockResult.error()) return MsgResult.fail(dockResult.getMessage());
            currentUser = userInfoMapper.selectById(currentUser.getId());
            currentUser.setHeadImgUrl((String) ((HashMap)dockResult.getData()).get("url"));
            userInfoMapper.updateById(currentUser);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return MsgResult.fail("获取文件流失败！");
        }
        UserPassVO userPassVO = userInfoConvert.getUserPassVO(currentUser);
        Map data = CustomUtils.ofMap("data", userPassVO);
        return MsgResult.doneUrl(data, PageConst.USER_PWD_SHOW);
    }

    /**
     * 上传用户头像
     */
    @PostMapping("/upload/img/user_head_save")
    public MsgResult user_head_save (@RequestParam("upimg") MultipartFile file) {
        return uploadUserHead(file);
    }

    /**
     * 上出图片
     */
    private void uploadHeadImg (@RequestParam("upimg") MultipartFile file) {
        try {
            UserDo currentUser = SessionUtil.getCurrentUser(httpServletRequest);
            String headFileName = UUID.randomUUID().toString() + file.getOriginalFilename();
            File newFiel = new File(headFileName);
            file.transferTo(newFiel);
            copyFilex100(MultipartContext.multipartLocation + File.separator + headFileName);
            deleteOldFile(currentUser.getHeadImgUrl());
            currentUser.setHeadImgUrl("upload/" + headFileName);
            userInfoMapper.updateById(currentUser);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * 删除旧头像
     */
    private void deleteOldFile (String imgUrl) {
        String oldImgPath = MultipartContext.resourceLocation + imgUrl;
        File oldImg = new File(oldImgPath);
        if (oldImg.exists() && oldImg.isFile()) {
            oldImg.delete();
        }

        String oldImgPathx100 = oldImgPath + ".100x100.jpg";
        File oldImgx100 = new File(oldImgPathx100);
        if (oldImgx100.exists() && oldImgx100.isFile()) {
            oldImgx100.delete();
        }
    }

    /**
     * 复制压缩100*100图片
     */
    private void copyFilex100 (String filePathName) {
        File file = new File(filePathName);
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            byte[] bit = new byte[fis.available()];
            fis.read(bit);
            File file2 = new File(filePathName + ".100x100.jpg");
            FileOutputStream fos = new FileOutputStream(file2);
            fos.write(bit);
            fis.close();
            fos.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }
}
