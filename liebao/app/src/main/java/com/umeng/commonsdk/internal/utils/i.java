package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* compiled from: UMInternalUtils.java */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6784a = "um_pri";

    /* renamed from: b  reason: collision with root package name */
    private static final String f6785b = "um_common_strength";

    /* renamed from: c  reason: collision with root package name */
    private static final String f6786c = "um_common_battery";

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f6784a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f6786c, null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f6784a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f6786c, str).commit();
    }
}
