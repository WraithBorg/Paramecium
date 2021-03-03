package com.zxu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/***
 * 文件存储服务
 */
@Component
@PropertySource("classpath:extra-prod.properties")
public class FfileServer {
    @Value("${image.base.url}")
    private String imgUrl;//图片URL
    @Value("${image.folder.path}")
    private String imgFolderPath;//文件存放屋里路径

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgFolderPath() {
        return imgFolderPath;
    }

    public void setImgFolderPath(String imgFolderPath) {
        this.imgFolderPath = imgFolderPath;
    }
}
