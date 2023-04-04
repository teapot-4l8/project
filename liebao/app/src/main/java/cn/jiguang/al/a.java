package cn.jiguang.al;

import com.umeng.analytics.pro.bz;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f3723a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        FileInputStream fileInputStream;
        Exception e2;
        String str2;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                fileInputStream.close();
                str2 = a(messageDigest.digest());
            } catch (Exception e3) {
                e2 = e3;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                e2.printStackTrace();
                str2 = "";
                cn.jiguang.an.d.b("FU", str + "---- m = " + str2);
                return str2;
            }
        } catch (Exception e5) {
            fileInputStream = null;
            e2 = e5;
        }
        cn.jiguang.an.d.b("FU", str + "---- m = " + str2);
        return str2;
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(f3723a[(bArr[i] & 240) >>> 4]);
            sb.append(f3723a[bArr[i] & bz.m]);
        }
        return sb.toString();
    }
}
