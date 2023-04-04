package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMProcessDBManager.java */
/* loaded from: classes2.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f6669a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<String, a> f6670b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private Context f6671c;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(Context context) {
        if (f6669a == null) {
            synchronized (c.class) {
                if (f6669a == null) {
                    f6669a = new c();
                }
            }
        }
        c cVar = f6669a;
        cVar.f6671c = context;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(String str) {
        c(str).b();
    }

    private a c(String str) {
        if (this.f6670b.get(str) == null) {
            a a2 = a.a(this.f6671c, str);
            this.f6670b.put(str, a2);
            return a2;
        }
        return this.f6670b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UMProcessDBManager.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private AtomicInteger f6672a = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        private SQLiteOpenHelper f6673b;

        /* renamed from: c  reason: collision with root package name */
        private SQLiteDatabase f6674c;

        private a() {
        }

        static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.f6673b = b.a(appContext, str);
            return aVar;
        }

        synchronized SQLiteDatabase a() {
            if (this.f6672a.incrementAndGet() == 1) {
                this.f6674c = this.f6673b.getWritableDatabase();
            }
            return this.f6674c;
        }

        synchronized void b() {
            try {
                if (this.f6672a.decrementAndGet() == 0) {
                    this.f6674c.close();
                }
            } catch (Throwable unused) {
            }
        }
    }
}
