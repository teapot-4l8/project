package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* compiled from: OppoDeviceIdSupplier.java */
/* loaded from: classes2.dex */
public class af implements z {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6356a = false;

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        try {
            if (!this.f6356a) {
                org.b.b.a.a.a.a.a(context);
                this.f6356a = true;
            }
            if (!org.b.b.a.a.a.a.a()) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
                return null;
            }
            return org.b.b.a.a.a.a.b(context);
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
