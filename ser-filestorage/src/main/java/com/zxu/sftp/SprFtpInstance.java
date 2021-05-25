package com.zxu.sftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.zxu.result.DockResult;
import com.zxu.util.FileStorageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * sftp连接实例
 */

@Component
public class SprFtpInstance {
    private static final Logger LOGGER = LoggerFactory.getLogger(SprFtpInstance.class);
    @Resource
    private SprFtpConfig sftpConfig;
    private long count1 = 0;
    private ChannelSftp sftpInstance;
    /**
     * 获取sftp连接对象
     */
    private synchronized ChannelSftp getFtpInstance () {
        if (sftpInstance == null) {
            sftpInstance = connect();
        }
        return sftpInstance;
    }

    /**
     * 创建sftp连接对象
     */
    private ChannelSftp connect () {
        ChannelSftp sftp = null;
        try {
            JSch jsch = new JSch();
            jsch.getSession(sftpConfig.getUsername(), sftpConfig.getHostname(), sftpConfig.getPort());
            Session sshSession = jsch.getSession(sftpConfig.getUsername(), sftpConfig.getHostname(), sftpConfig.getPort());
            LOGGER.info("Session created ... UserName=" + sftpConfig.getUsername() + ";host=" + sftpConfig.getHostname() + ";port=" + sftpConfig.getPort());
            sshSession.setPassword(sftpConfig.getPassword());
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            LOGGER.info("Session connected ...");
            LOGGER.info("Opening Channel ...");
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            LOGGER.info("登录成功");
        } catch (Exception e) {
            try {
                count1 += 1;
                long count = 3;
                if (count == count1) {
                    throw new RuntimeException(e);
                }
                long sleepTime = 6000;
                Thread.sleep(sleepTime);
                LOGGER.info("重新连接....");
                connect();
            } catch (InterruptedException e1) {
                throw new RuntimeException(e1);
            }
        }
        return sftp;
    }

    /**
     * 上传图片
     */
    public void upload4InputStream (InputStream inputStream, String fileName) {
        String directory = SprFileServer.getImgFolderPath();
        try {
            getFtpInstance().cd(directory);
        } catch (SftpException e) {
            try {
                getFtpInstance().mkdir(directory);
                getFtpInstance().cd(directory);
            } catch (SftpException e1) {
                throw new RuntimeException("ftp创建文件路径失败" + directory);
            }
        }
        try {
            getFtpInstance().put(inputStream, fileName);
        } catch (Exception e) {
            throw new RuntimeException("sftp异常" + e);
        } finally {
            closeStream(inputStream, null);
        }
    }

    /**
     * 关闭文件流
     */
    private void closeStream (InputStream inputStream, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除文件
     */
    public DockResult deleteFile (String fileName) {
        try {
            getFtpInstance().rm(SprFileServer.getImgFolderPath() + fileName);
            return DockResult.done();
        } catch (SftpException e) {
            LOGGER.error(e.getMessage(), e);
            return DockResult.fail(e.getMessage());
        }
    }
}
