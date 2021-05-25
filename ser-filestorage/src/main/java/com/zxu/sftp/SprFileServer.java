package com.zxu.sftp;


import com.zxu.security.AESTools;

/***
 * 文件存储服务
 */

public class SprFileServer {
    private static final String uKey_path = "db71ea37a2d04c66";
    private static final String cipher_path = "RlxNIekPC4HTPEclldtBr3deECLhT0c4QtaTI8ZB4qo=";
    private static final String url_key = "1d299e5bb42d4b45";
    private static final String url_cipher = "A+9SMFShWPakdhO8pln+ebAwfmegfxAz3VzBcsGI6V4=";
    private static String accessUrl;
    private static String imgFolderPath;

    /**
     * 获取ftp路径
     */
    public static String getImgFolderPath () {
        if (imgFolderPath == null) {
            imgFolderPath = AESTools.decrypt(cipher_path, uKey_path);
        }
        return imgFolderPath;
    }

    /**
     * 获取文件访问地址
     */
    public static String getAccessUrl () {
        if (accessUrl == null) {
            accessUrl = AESTools.decrypt(url_key, url_cipher);
        }
        return accessUrl;
    }
}
