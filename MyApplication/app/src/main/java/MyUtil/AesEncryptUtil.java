package MyUtil;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class AesEncryptUtil {
    private static final String TAG = AesEncryptUtil.class.getSimpleName();

    public static String encrypt(String data, String key, String iv) throws Exception {
        byte[] keyBytes = md5(key.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        byte[] ivBytes = iv.getBytes(StandardCharsets.UTF_8);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] rawData = padString(data.getBytes(StandardCharsets.UTF_8), cipher.getBlockSize());
            byte[] encryptedData = cipher.doFinal(rawData);

            byte[] totalBytes = new byte[ivBytes.length + encryptedData.length];
            System.arraycopy(ivBytes, 0, totalBytes, 0, ivBytes.length);
            System.arraycopy(encryptedData, 0, totalBytes, ivBytes.length, encryptedData.length);

            byte[] encodedBytes = Base64.getEncoder().encode(totalBytes);
            return new String(encodedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static byte[] md5(byte[] bytes) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(bytes);
        return md5.digest();
    }

    private static byte[] padString(byte[] source, int blockSize) {
        int paddingCount = blockSize - source.length % blockSize;
        byte[] paddingBytes = new byte[paddingCount];
        for (int i = 0; i < paddingCount; i++) {
            paddingBytes[i] = (byte) paddingCount;
        }
        byte[] paddedSourceBytes = new byte[source.length + paddingCount];
        System.arraycopy(source, 0, paddedSourceBytes, 0, source.length);
        System.arraycopy(paddingBytes, 0, paddedSourceBytes, source.length, paddingBytes.length);
        return paddedSourceBytes;
    }
}