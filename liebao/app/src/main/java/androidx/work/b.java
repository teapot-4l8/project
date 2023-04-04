package androidx.work;

import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: Configuration.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f2764a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f2765b;

    /* renamed from: c  reason: collision with root package name */
    private final p f2766c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2767d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2768e;
    private final int f;
    private final int g;

    /* compiled from: Configuration.java */
    /* renamed from: androidx.work.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0061b {
        b a();
    }

    b(a aVar) {
        if (aVar.f2769a == null) {
            this.f2764a = h();
        } else {
            this.f2764a = aVar.f2769a;
        }
        if (aVar.f2771c == null) {
            this.f2765b = h();
        } else {
            this.f2765b = aVar.f2771c;
        }
        if (aVar.f2770b == null) {
            this.f2766c = p.a();
        } else {
            this.f2766c = aVar.f2770b;
        }
        this.f2767d = aVar.f2772d;
        this.f2768e = aVar.f2773e;
        this.f = aVar.f;
        this.g = aVar.g;
    }

    public Executor a() {
        return this.f2764a;
    }

    public Executor b() {
        return this.f2765b;
    }

    public p c() {
        return this.f2766c;
    }

    public int d() {
        return this.f2767d;
    }

    public int e() {
        return this.f2768e;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        if (Build.VERSION.SDK_INT == 23) {
            return this.g / 2;
        }
        return this.g;
    }

    private Executor h() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }

    /* compiled from: Configuration.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        Executor f2769a;

        /* renamed from: b  reason: collision with root package name */
        p f2770b;

        /* renamed from: c  reason: collision with root package name */
        Executor f2771c;

        /* renamed from: d  reason: collision with root package name */
        int f2772d = 4;

        /* renamed from: e  reason: collision with root package name */
        int f2773e = 0;
        int f = Integer.MAX_VALUE;
        int g = 20;

        public b a() {
            return new b(this);
        }
    }
}
