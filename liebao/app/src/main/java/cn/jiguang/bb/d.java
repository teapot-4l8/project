package cn.jiguang.bb;

import android.util.Base64;
import cn.jiguang.f.i;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class d {
    public static int a() {
        return Math.abs(new SecureRandom().nextInt()) & 16777215;
    }

    public static String a(long j) {
        long j2;
        long j3;
        switch ((int) (j % 10)) {
            case 1:
                j2 = 5 * j;
                j3 = 88;
                break;
            case 2:
                j2 = 23 * j;
                j3 = 15;
                break;
            case 3:
                j2 = 3 * j;
                j3 = 73;
                break;
            case 4:
                j2 = 13 * j;
                j3 = 96;
                break;
            case 5:
                j2 = 17 * j;
                j3 = 49;
                break;
            case 6:
                j2 = 7 * j;
                j3 = 68;
                break;
            case 7:
                j2 = 31 * j;
                j3 = 39;
                break;
            case 8:
                j2 = 29 * j;
                j3 = 41;
                break;
            case 9:
                j2 = 37 * j;
                j3 = 91;
                break;
            default:
                j2 = 8 * j;
                j3 = 74;
                break;
        }
        long j4 = j2 + (j % j3);
        return i.d("JCKP" + j4);
    }

    public static String a(String str) {
        try {
            return a(str.getBytes(), "DFA84B10B7ACDD25", "DFA84B10B7ACDD25");
        } catch (Exception unused) {
            cn.jiguang.an.d.f("", "Unexpected - failed to AES encrypt.");
            return "";
        }
    }

    public static String a(String str, String str2) {
        return new String(Base64.encode(a(str, c(str2)), 2), "UTF-8");
    }

    public static String a(byte[] bArr, long j) {
        return a(bArr, b(j), b(j ^ (-1)));
    }

    public static String a(byte[] bArr, String str, String str2) {
        return Base64.encodeToString(a(bArr, str, str2, true), 2);
    }

    private static IvParameterSpec a(byte[] bArr) {
        try {
            return (IvParameterSpec) IvParameterSpec.class.getConstructor(byte[].class).newInstance(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3) {
        return a(Base64.decode(str, 2), str2, str3, false);
    }

    private static synchronized byte[] a(String str, RSAPublicKey rSAPublicKey) {
        byte[] doFinal;
        synchronized (d.class) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
            cipher.init(1, rSAPublicKey);
            doFinal = cipher.doFinal(str.getBytes());
        }
        return doFinal;
    }

    public static synchronized byte[] a(byte[] bArr, String str, String str2, boolean z) {
        synchronized (d.class) {
            if (str == null) {
                return null;
            }
            byte[] bArr2 = new byte[str.length()];
            byte[] bytes = str.substring(0, str.length() / 2).getBytes("UTF-8");
            byte[] bytes2 = str.substring(str.length() / 2).getBytes("UTF-8");
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bytes2, 0, bArr2, bytes.length, bytes2.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            IvParameterSpec a2 = a(str2.getBytes("UTF-8"));
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(z ? 1 : 2, secretKeySpec, a2);
            return cipher.doFinal(bArr);
        }
    }

    private static String b(long j) {
        return String.format(Locale.ENGLISH, "%016d", Long.valueOf(j % 1000000000000000L));
    }

    public static String b(String str) {
        try {
            return new String(a(str, "DFA84B10B7ACDD25", "DFA84B10B7ACDD25"));
        } catch (Exception unused) {
            cn.jiguang.an.d.f("", "Unexpected - failed to AES decrypt.");
            return "";
        }
    }

    private static RSAPublicKey c(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Throwable unused) {
            return null;
        }
    }
}
