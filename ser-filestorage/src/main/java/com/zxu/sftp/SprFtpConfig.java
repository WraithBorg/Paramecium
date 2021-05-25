package com.zxu.sftp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * sftp默认配置
 */
@Component
@PropertySource("classpath:ssftp.properties")
public class SprFtpConfig {
    @Value("${sftp.hostname}")
    private String hostname;
    @Value("${sftp.port}")
    private Integer port;
    @Value("${sftp.username}")
    private String username;
    @Value("${sftp.password}")
    private String password;
    @Value("${sftp.timeout}")
    private Integer timeout;
    @Value("${sftp.remoteRootPath}")
    private String remoteRootPath;
    @Value("${sftp.fileSuffix}")
    private String fileSuffix;

    public String getHostname () {
        return hostname;
    }

    public void setHostname (String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort () {
        return port;
    }

    public void setPort (Integer port) {
        this.port = port;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public Integer getTimeout () {
        return timeout;
    }

    public void setTimeout (Integer timeout) {
        this.timeout = timeout;
    }

    public String getRemoteRootPath () {
        return remoteRootPath;
    }

    public void setRemoteRootPath (String remoteRootPath) {
        this.remoteRootPath = remoteRootPath;
    }

    public String getFileSuffix () {
        return fileSuffix;
    }

    public void setFileSuffix (String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public SprFtpConfig (String hostname, Integer port, String username, String password, Integer timeout, String remoteRootPath, String fileSuffix) {
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
        this.timeout = timeout;
        this.remoteRootPath = remoteRootPath;
        this.fileSuffix = fileSuffix;
    }

    public SprFtpConfig (String hostname, Integer port, String username, String password, Integer timeout, String remoteRootPath) {
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
        this.timeout = timeout;
        this.remoteRootPath = remoteRootPath;
    }

    public SprFtpConfig () {
    }

    @Override
    public String toString () {
        return "SftpConfig{" +
                "hostname='" + hostname + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", timeout=" + timeout +
                ", remoteRootPath='" + remoteRootPath + '\'' +
                ", fileSuffix='" + fileSuffix + '\'' +
                '}';
    }
}
