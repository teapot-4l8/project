package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* compiled from: XiaomiDeviceIdSupplier.java */
/* loaded from: classes2.dex */
class ai implements z {
    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        String str = null;
        try {
            if (!org.b.b.b.a.a.a()) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            } else {
                str = org.b.b.b.a.a.a(context);
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return str;
    }
}