package MyUtil.report;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import MyUtil.AppUtils;
import kotlin.TypeCastException;

public final class b {
    private static final String d;

    private static final String str;

    private static final String str2;

    static {
        d = "9cafa6466a028bfb";
        str = "fd6b639dbcff0c2a1b03b389ec763c4b";
        str2 = "77b07a672d57d64c";
    }


    public static final Charset charset = Charset.forName("UTF-8");

    public static String b(String params) {
        byte[] bytes = params.getBytes(charset); // 将字符串转化成字节
        String str = d;
        if (str != null) {
            byte[] bytes2 = str.getBytes(charset);
            String g = g(bytes, bytes2); // 加密
            Locale locale = Locale.US;
            if (g != null) {
                String lowerCase = g.toLowerCase(locale); // 变成小写字符串再返回
                return lowerCase;
            }

        }
        return "";
    }

    public static String bb(String str) {
        byte[] bytes = str.getBytes(); // 字符串转为字节
        bytes[0] = (byte) (bytes[0] ^ ((byte) (bytes.length & 255))); // 将位运算得到的十进制的值转换成字节
        for (int i = 1; i < bytes.length; i++) {
            bytes[i] = (byte) ((bytes[i - 1] ^ bytes[i]) & 255); // 255 -> 0xFF
        }
        try {
            return new String(Base64.encode(bytes, 11));
        } catch (Exception unused) {
            return str;
        }
    }


    public static byte[] a(String body) {
        try {
            Charset charset = Charset.forName("UTF-8");
            if (str != null) {
                byte[] bytes = str.getBytes(charset); // bytes from str
                // 将此String解码使用平台的默认字符集，并将结果存储到一个新的字节数组中的字节序列
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES"); // 系统包 from bytes
                if (str2 != null) {
                    byte[] bytes2 = str2.getBytes(charset); // bytes2 from str2
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes2); // iv from bytes2
                    byte[] bytes3 = body.getBytes(charset);
                    byte[] i = i(secretKeySpec, ivParameterSpec, bytes3); // key, iv, byte
                    return i;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception e2) {
            Charset charset4 = Charset.forName("UTF-8");
            byte[] bytes4 = body.getBytes(charset4);
            return bytes4;
        }
    }


    // did
    public static String g() {
        String f = AppUtils.f(); // 长度不小于4 f
        return bb(f);
    }

    // hook看看f返回了啥
//    public static String f(Context context) {
//        StringBuffer stringBuffer = new StringBuffer(); // 比StringBuilder多个线程安全
//        String j2 = j(context);
//        if (j2 != null) {
//            String lowerCase = j2.replaceAll("[^0-9A-Fa-f]", "").toLowerCase();
//            if (k(lowerCase)) {
//                stringBuffer.append(lowerCase);
//            }
//        }
//        stringBuffer.append('|');
//        String a2 = z.a("persist.service.bdroid.bdaddr");
//        if (a2.length() > 0) {
//            String lowerCase2 = a2.replaceAll("[^0-9A-Fa-f]", "").toLowerCase();
//            if (k(lowerCase2)) {
//                stringBuffer.append(lowerCase2);
//            }
//        }
//        stringBuffer.append('|');
//        String h = h();
//        if (h != null) {
//            stringBuffer.append(h.toLowerCase());
//        }
//        stringBuffer.append('|');
//        String i = i();
//        if (i != null) {
//            stringBuffer.append(i.toLowerCase());
//        }
//        return stringBuffer.toString();
//    }


    public static String g(byte[] bArr, byte[] bArr2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(bArr); // 盐不是固定的,要获取它
            if (bArr2 != null) {
                messageDigest.update(bArr2); // update: 加盐
            }
            return H(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    // 字节转成十六进制字符串
    public static String H(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            int i = b2 & 255;
            if (i < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }

    public static byte[] i(SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] bArr) throws GeneralSecurityException {
        try { // AES加密
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // AES加密
            cipher.init(1, secretKey, ivParameterSpec);
            return cipher.doFinal(bArr); // bArr: 明文
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new AssertionError(e);
        }
    }

}
