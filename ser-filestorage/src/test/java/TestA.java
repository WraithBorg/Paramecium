import com.zxu.security.AESTools;

public class TestA {
    public static void main (String[] args) {
        String url_key = "1d299e5bb42d4b45";
        String url_cipher = "A+9SMFShWPakdhO8pln+ebAwfmegfxAz3VzBcsGI6V4=";
//        String message = "http://192.168.27.25/image/";
//        String url_key = AESTools.getUKey();
//        System.out.println(url_key);
//        String encryptMsg = AESTools.encryptMsg(message, url_key);
//        System.out.println(encryptMsg);
        String decrypt = AESTools.decrypt(url_cipher, url_key);
        System.out.println(decrypt);
    }
}
