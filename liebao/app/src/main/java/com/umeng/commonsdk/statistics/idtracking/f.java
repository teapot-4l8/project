package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: ImeiTracker.java */
/* loaded from: classes2.dex */
public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6868a = "imei";

    /* renamed from: b  reason: collision with root package name */
    private Context f6869b;

    public f(Context context) {
        super(f6868a);
        this.f6869b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getImeiNew(this.f6869b);
    }
}
