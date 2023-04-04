package com.snail.antifake.a;

import android.content.Context;
import com.snail.antifake.jni.PropertiesGet;

/* compiled from: AndroidDeviceIMEIUtil.java */
/* loaded from: classes2.dex */
public class a {
    public static boolean a(Context context) {
        return com.snail.antifake.a.a.a.a(context);
    }

    public static String a() {
        return PropertiesGet.a("ro.product.cpu.abi");
    }
}
