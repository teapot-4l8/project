package cn.jiguang.al;

import android.util.Base64;

/* loaded from: classes.dex */
public final class d {
    public static String a(String str) {
        return new String(Base64.decode(str.getBytes(), 2));
    }
}
