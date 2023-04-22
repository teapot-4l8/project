package Util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

import Util.jni.AHAPIHelper;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class SecurityUtil {

    public static final byte m = 15;
    private static final String encoding = "UTF-8";
    private static final String iv = "appapich";
    private static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();


    public static String encodeMD5(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & m];
            }
            return new String(cArr2).toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encode3Des(Context context, String str) {
        Log.e("[*]encode3Des->", str);
        String desKey = AHAPIHelper.getDesKey(context);
        byte[] bArr = null;
        if (TextUtils.isEmpty(desKey)) {
            return null;
        }
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("desede").generateSecret(new DESedeKeySpec(desKey.getBytes()));
            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
            cipher.init(1, generateSecret, new IvParameterSpec(iv.getBytes()));
            bArr = cipher.doFinal(str.getBytes("UTF-8"));
        } catch (Exception unused) {
        }
        return encode(bArr);
    }

    private static String encode(byte[] bArr) {
        return Base64.encodeToString(bArr, Base64.DEFAULT);
    }


    /*
    TODO:修改一下 不知道为什么会报错
    public static String encode(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        int i = length - 3;
        int i2 = 0;
        while (true) {
            int i3 = 0;
            while (i2 <= i) {
                int i4 = ((bArr[i2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) | (bArr[i2 + 2] & 255);
                stringBuffer.append(legalChars[(i4 >> 18) & 63]);
                stringBuffer.append(legalChars[(i4 >> 12) & 63]);
                stringBuffer.append(legalChars[(i4 >> 6) & 63]);
                stringBuffer.append(legalChars[i4 & 63]);
                i2 += 3;
                int i5 = i3 + 1;
                if (i3 >= 14) {
                    break;
                }
                i3 = i5;
            }
            stringBuffer.append(" ");
        }
        int i6 = 0 + length;
        if (i2 == i6 - 2) {
            int i7 = ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2] & 255) << 16);
            stringBuffer.append(legalChars[(i7 >> 18) & 63]);
            stringBuffer.append(legalChars[(i7 >> 12) & 63]);
            stringBuffer.append(legalChars[(i7 >> 6) & 63]);
            stringBuffer.append("=");
        } else if (i2 == i6 - 1) {
            int i8 = (bArr[i2] & 255) << 16;
            stringBuffer.append(legalChars[(i8 >> 18) & 63]);
            stringBuffer.append(legalChars[(i8 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer.toString();
    }
    */

}
