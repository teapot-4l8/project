package androidx.a.a.a;

import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor.java */
/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f481a;

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f482d = new Executor() { // from class: androidx.a.a.a.a.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.a().b(runnable);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f483e = new Executor() { // from class: androidx.a.a.a.a.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.a().a(runnable);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private c f484b;

    /* renamed from: c  reason: collision with root package name */
    private c f485c;

    private a() {
        b bVar = new b();
        this.f485c = bVar;
        this.f484b = bVar;
    }

    public static a a() {
        if (f481a != null) {
            return f481a;
        }
        synchronized (a.class) {
            if (f481a == null) {
                f481a = new a();
            }
        }
        return f481a;
    }

    @Override // androidx.a.a.a.c
    public void a(Runnable runnable) {
        this.f484b.a(runnable);
    }

    @Override // androidx.a.a.a.c
    public void b(Runnable runnable) {
        this.f484b.b(runnable);
    }

    public static Executor b() {
        return f483e;
    }

    @Override // androidx.a.a.a.c
    public boolean c() {
        return this.f484b.c();
    }
}
