package b.b.h;

import b.b.e.g.l;
import b.b.e.g.m;
import b.b.i;
import java.util.concurrent.Callable;

/* compiled from: Schedulers.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final i f3499a = b.b.g.a.d(new h());

    /* renamed from: b  reason: collision with root package name */
    static final i f3500b = b.b.g.a.a(new b());

    /* renamed from: c  reason: collision with root package name */
    static final i f3501c = b.b.g.a.b(new c());

    /* renamed from: d  reason: collision with root package name */
    static final i f3502d = m.c();

    /* renamed from: e  reason: collision with root package name */
    static final i f3503e = b.b.g.a.c(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: b.b.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0075a {

        /* renamed from: a  reason: collision with root package name */
        static final i f3504a = new b.b.e.g.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        static final i f3505a = new b.b.e.g.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        static final i f3506a = new b.b.e.g.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        static final i f3507a = new l();
    }

    public static i a() {
        return b.b.g.a.a(f3500b);
    }

    public static i b() {
        return b.b.g.a.b(f3501c);
    }

    public static i c() {
        return f3502d;
    }

    public static i d() {
        return b.b.g.a.c(f3503e);
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    static final class c implements Callable<i> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public i call() {
            return d.f3505a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    static final class f implements Callable<i> {
        f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public i call() {
            return e.f3506a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    static final class h implements Callable<i> {
        h() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public i call() {
            return g.f3507a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    static final class b implements Callable<i> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public i call() {
            return C0075a.f3504a;
        }
    }
}
