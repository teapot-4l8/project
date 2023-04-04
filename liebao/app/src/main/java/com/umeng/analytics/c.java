package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: InternalConfig.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f6326a = new String[2];

    public static void a(Context context, String str, String str2) {
        String[] strArr = f6326a;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            com.umeng.common.b.a(context).a(str, str2);
        }
    }

    public static String[] a(Context context) {
        String[] a2;
        if (TextUtils.isEmpty(f6326a[0]) || TextUtils.isEmpty(f6326a[1])) {
            if (context == null || (a2 = com.umeng.common.b.a(context).a()) == null) {
                return null;
            }
            String[] strArr = f6326a;
            strArr[0] = a2[0];
            strArr[1] = a2[1];
            return strArr;
        }
        return f6326a;
    }

    public static void b(Context context) {
        String[] strArr = f6326a;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            com.umeng.common.b.a(context).b();
        }
    }
}
