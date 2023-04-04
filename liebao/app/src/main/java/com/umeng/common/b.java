package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* compiled from: SPHelper.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f6683a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Context f6684b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f6685c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final String f6686d = "mobclick_agent_user_";

    /* compiled from: SPHelper.java */
    /* loaded from: classes2.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f6687a = new b();

        private a() {
        }
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f6684b == null && context != null) {
                f6684b = context.getApplicationContext();
            }
            if (f6684b != null) {
                f6685c = context.getPackageName();
            }
            bVar = a.f6687a;
        }
        return bVar;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = e().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }

    public String[] a() {
        SharedPreferences e2 = e();
        if (e2 != null) {
            String string = e2.getString("au_p", null);
            String string2 = e2.getString("au_u", null);
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                return null;
            }
            return new String[]{string, string2};
        }
        return null;
    }

    public void b() {
        SharedPreferences e2 = e();
        if (e2 != null) {
            e2.edit().remove("au_p").remove("au_u").commit();
        }
    }

    public String c() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f6684b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f6684b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(int i) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f6684b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    public int d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f6684b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    private SharedPreferences e() {
        Context context = f6684b;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(f6686d + f6685c, 0);
    }

    public static String a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0)) == null) ? "" : sharedPreferences.getString(str2, "");
    }

    public static void a(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString(str2, str3);
        edit.commit();
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(str, 0).edit();
        edit.remove(AnalyticsConfig.DEBUG_KEY);
        edit.remove(AnalyticsConfig.RTD_PERIOD);
        edit.remove(AnalyticsConfig.RTD_START_TIME);
        edit.clear();
        edit.commit();
    }
}
