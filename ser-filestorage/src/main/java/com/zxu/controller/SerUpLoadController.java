package com.zxu.controller;

import com.zxu.constant.Uri4Upload;
import com.zxu.result.DockResult;
import com.zxu.sftp.SprFtpInstance;
import com.zxu.util.CustomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.UUID;

@Controller
public class SerUpLoadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SerUpLoadController.class);
    @Resource
    private SprFtpInstance sprFtpInstance;

    /**
     * 上传文件
     */
    @ResponseBody
    @PostMapping(Uri4Upload.UPLOAD)
    public DockResult serve4Upload (@PathVariable("filePath") String filePath, @RequestParam("file") MultipartFile file) {
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        try {
            sprFtpInstance.upload4InputStream(file.getInputStream(), filePath, fileName);
            return DockResult.done(CustomUtils.ofMap("url", fileName));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return DockResult.fail(e.getMessage());
        }
    }

    /**
     * 替换文件
     */
    @ResponseBody
    @PostMapping(Uri4Upload.REPLACE)
    public DockResult serve4Replace (@PathVariable("filePath") String filePath, @PathVariable("originalName") String originalName,
                                     @RequestParam("file") MultipartFile file) {
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        try {
            sprFtpInstance.deleteFile(filePath,originalName);
            sprFtpInstance.upload4InputStream(file.getInputStream(), filePath, fileName);
            return DockResult.done(CustomUtils.ofMap("url", fileName));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return DockResult.fail(e.getMessage());
        }
    }
}
