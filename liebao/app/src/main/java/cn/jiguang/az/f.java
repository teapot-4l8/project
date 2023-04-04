package cn.jiguang.az;

import com.umeng.analytics.pro.bz;

/* loaded from: classes.dex */
public final class f {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            stringBuffer.append("0123456789ABCDEF".charAt((b2 >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(b2 & bz.m));
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }
}
