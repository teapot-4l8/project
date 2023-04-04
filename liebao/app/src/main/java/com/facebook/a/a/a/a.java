package com.facebook.a.a.a;

/* compiled from: AndroidConceal.java */
/* loaded from: classes.dex */
public class a extends com.facebook.crypto.b {

    /* renamed from: c  reason: collision with root package name */
    private static a f5275c;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f5275c == null) {
                f5275c = new a();
            }
            aVar = f5275c;
        }
        return aVar;
    }

    private a() {
        super(new com.facebook.crypto.e.c(), new b());
    }
}
