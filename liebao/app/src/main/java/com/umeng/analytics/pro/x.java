package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: SessionIdGenerateServiceImpl.java */
/* loaded from: classes2.dex */
class x implements w {

    /* renamed from: a  reason: collision with root package name */
    private long f6637a = AnalyticsConfig.kContinueSessionMillis;

    @Override // com.umeng.analytics.pro.w
    public void a(long j) {
        this.f6637a = j;
    }

    @Override // com.umeng.analytics.pro.w
    public long a() {
        return this.f6637a;
    }

    @Override // com.umeng.analytics.pro.w
    public String a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey == null) {
            throw new RuntimeException("Appkey is null or empty, Please check!");
        }
        return UMUtils.MD5(currentTimeMillis + appkey + "02:00:00:00:00:00");
    }

    @Override // com.umeng.analytics.pro.w
    public boolean a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        return (j == 0 || currentTimeMillis - j >= this.f6637a) && j2 > 0 && currentTimeMillis - j2 > this.f6637a;
    }

    @Override // com.umeng.analytics.pro.w
    public void a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString("session_id", str);
            edit.putLong(u.f6627b, 0L);
            edit.putLong(u.f6630e, currentTimeMillis);
            edit.putLong(u.f, 0L);
            edit.commit();
        } catch (Exception unused) {
        }
    }
}
