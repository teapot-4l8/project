package com.umeng.commonsdk.statistics.idtracking;

import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: SerialTracker.java */
/* loaded from: classes2.dex */
public class i extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6877a = "serial";

    public i() {
        super(f6877a);
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getSerial();
    }
}
