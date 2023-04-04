package androidx.work.impl.a.b;

import android.content.Context;

/* compiled from: Trackers.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f2835a;

    /* renamed from: b  reason: collision with root package name */
    private a f2836b;

    /* renamed from: c  reason: collision with root package name */
    private b f2837c;

    /* renamed from: d  reason: collision with root package name */
    private e f2838d;

    /* renamed from: e  reason: collision with root package name */
    private f f2839e;

    public static synchronized g a(Context context, androidx.work.impl.utils.b.a aVar) {
        g gVar;
        synchronized (g.class) {
            if (f2835a == null) {
                f2835a = new g(context, aVar);
            }
            gVar = f2835a;
        }
        return gVar;
    }

    private g(Context context, androidx.work.impl.utils.b.a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f2836b = new a(applicationContext, aVar);
        this.f2837c = new b(applicationContext, aVar);
        this.f2838d = new e(applicationContext, aVar);
        this.f2839e = new f(applicationContext, aVar);
    }

    public a a() {
        return this.f2836b;
    }

    public b b() {
        return this.f2837c;
    }

    public e c() {
        return this.f2838d;
    }

    public f d() {
        return this.f2839e;
    }
}
