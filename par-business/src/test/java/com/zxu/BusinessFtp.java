package com.zxu;

import com.zxu.sftp.SsFtpConfig;
import com.zxu.sftp.SsFtpServe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BusinessFtp {
    @Resource
    SsFtpServe ssFtpServe;
    @Resource
    SsFtpConfig sftpConfig;
    @Test
    public void testSave() {
        ssFtpServe.upload("yearbalance","C:\\Users\\Administrator\\Pictures\\abc.png",sftpConfig);
    }
}
