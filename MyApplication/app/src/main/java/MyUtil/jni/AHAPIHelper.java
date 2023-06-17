package MyUtil.jni;

import android.content.Context;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AHAPIHelper {
//    TODO: change to jni method
    public static String getDesKey(Context context) {
        return "appapiche168comappapiche168comap";
    }


    // TODO:得物 -> jni
    public static byte[] aesEncrypt(String dataString) {
        try {
            String key = "d245a0ba8d678a61";
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(dataString.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
