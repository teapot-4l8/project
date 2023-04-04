package com.umeng.commonsdk.internal;

import android.content.Context;

/* compiled from: UMInternalData.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f6752b;

    /* renamed from: a  reason: collision with root package name */
    private Context f6753a;

    /* renamed from: c  reason: collision with root package name */
    private c f6754c;

    private b(Context context) {
        this.f6753a = context;
        this.f6754c = new c(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f6752b == null) {
                f6752b = new b(context.getApplicationContext());
            }
            bVar = f6752b;
        }
        return bVar;
    }

    public c a() {
        return this.f6754c;
    }
}
