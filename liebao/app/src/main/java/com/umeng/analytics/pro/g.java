package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMDBManager.java */
/* loaded from: classes2.dex */
class g {

    /* renamed from: b  reason: collision with root package name */
    private static SQLiteOpenHelper f6554b;

    /* renamed from: d  reason: collision with root package name */
    private static Context f6555d;

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f6556a;

    /* renamed from: c  reason: collision with root package name */
    private SQLiteDatabase f6557c;

    private g() {
        this.f6556a = new AtomicInteger();
    }

    /* compiled from: UMDBManager.java */
    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final g f6558a = new g();

        private a() {
        }
    }

    public static g a(Context context) {
        if (f6555d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            f6555d = applicationContext;
            f6554b = f.a(applicationContext);
        }
        return a.f6558a;
    }

    public synchronized SQLiteDatabase a() {
        if (this.f6556a.incrementAndGet() == 1) {
            this.f6557c = f6554b.getWritableDatabase();
        }
        return this.f6557c;
    }

    public synchronized void b() {
        try {
            if (this.f6556a.decrementAndGet() == 0) {
                this.f6557c.close();
            }
        } catch (Throwable unused) {
        }
    }
}
