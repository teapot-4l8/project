package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: InfoPreference.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6782a = "info";

    /* renamed from: b  reason: collision with root package name */
    private static final String f6783b = "ua";

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f6782a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f6783b, str).commit();
        }
    }

    public static String a(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f6782a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f6783b, null);
        }
        return null;
    }
}
