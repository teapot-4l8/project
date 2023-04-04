package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;

/* compiled from: OpenDeviceId.java */
/* loaded from: classes2.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private static z f6342a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f6343b = false;

    public static synchronized String a(Context context) {
        synchronized (aa.class) {
            try {
                if (context == null) {
                    throw new RuntimeException("Context is null");
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    throw new IllegalStateException("Cannot be called from the main thread");
                }
                b(context);
                if (f6342a != null) {
                    try {
                        return f6342a.a(context);
                    } catch (Exception unused) {
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void b(Context context) {
        if (f6342a != null || f6343b) {
            return;
        }
        synchronized (aa.class) {
            if (f6342a == null && !f6343b) {
                f6342a = ac.a(context);
                f6343b = true;
            }
        }
    }
}
