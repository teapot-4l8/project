package com.tencent.bugly.proguard;

import com.umeng.analytics.pro.bz;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f6192a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = f6192a;
            cArr[i2 + 1] = cArr2[b2 & bz.m];
            cArr[i2] = cArr2[((byte) (b2 >>> 4)) & bz.m];
        }
        return new String(cArr);
    }
}
