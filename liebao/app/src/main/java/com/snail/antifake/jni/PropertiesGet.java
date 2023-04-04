package com.snail.antifake.jni;

/* loaded from: classes2.dex */
public class PropertiesGet {
    private static native String native_get(String str);

    static {
        System.loadLibrary("property_get");
    }

    public static String a(String str) {
        return native_get(str);
    }
}
