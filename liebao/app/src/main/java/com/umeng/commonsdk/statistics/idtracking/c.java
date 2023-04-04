package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: IDFATracker.java */
/* loaded from: classes2.dex */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6857a = "idfa";

    /* renamed from: b  reason: collision with root package name */
    private Context f6858b;

    public c(Context context) {
        super(f6857a);
        this.f6858b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getIdfa(this.f6858b);
    }
}
