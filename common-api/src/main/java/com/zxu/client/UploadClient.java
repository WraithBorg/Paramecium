package com.zxu.client;

import com.zxu.constant.Hosts4Access;
import com.zxu.constant.MediaTypeConst;
import com.zxu.constant.Uri4Storage;
import com.zxu.constant.Uri4Upload;
import com.zxu.result.DockResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Component
public class UploadClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountClient.class);
    
    // 上传文件
    public DockResult uploadFile (MultipartFile uploadFile) {
        String url = Hosts4Access.fileStorageHosts + Uri4Upload.UPLOAD;
        String filename = uploadFile.getOriginalFilename();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType(MediaTypeConst.FORM_DATA);
        headers.setContentType(type);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("file", uploadFile.getResource());
        form.add("filename", filename);
        HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, headers);
        DockResult result = getRestemplate().postForObject(url, files, DockResult.class);
        return result;
    }
    
    // 删除文件
    public DockResult deleteFile (String fileName) {
        return DockResult.done();
    }

    private RestTemplate getRestemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }
}
