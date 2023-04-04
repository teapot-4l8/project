package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: MacTracker.java */
/* loaded from: classes2.dex */
public class g extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6870a = "mac";

    /* renamed from: b  reason: collision with root package name */
    private Context f6871b;

    public g(Context context) {
        super(f6870a);
        this.f6871b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            return DeviceConfig.getMac(this.f6871b);
        } catch (Exception e2) {
            if (AnalyticsConstants.UM_DEBUG) {
                e2.printStackTrace();
            }
            UMCrashManager.reportCrash(this.f6871b, e2);
            return null;
        }
    }
}
