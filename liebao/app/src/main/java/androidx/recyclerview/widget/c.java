package androidx.recyclerview.widget;

import androidx.recyclerview.widget.h;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: AsyncDifferConfig.java */
/* loaded from: classes.dex */
public final class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f2214a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f2215b;

    /* renamed from: c  reason: collision with root package name */
    private final h.c<T> f2216c;

    c(Executor executor, Executor executor2, h.c<T> cVar) {
        this.f2214a = executor;
        this.f2215b = executor2;
        this.f2216c = cVar;
    }

    public Executor a() {
        return this.f2214a;
    }

    public Executor b() {
        return this.f2215b;
    }

    public h.c<T> c() {
        return this.f2216c;
    }

    /* compiled from: AsyncDifferConfig.java */
    /* loaded from: classes.dex */
    public static final class a<T> {

        /* renamed from: d  reason: collision with root package name */
        private static final Object f2217d = new Object();

        /* renamed from: e  reason: collision with root package name */
        private static Executor f2218e = null;

        /* renamed from: a  reason: collision with root package name */
        private Executor f2219a;

        /* renamed from: b  reason: collision with root package name */
        private Executor f2220b;

        /* renamed from: c  reason: collision with root package name */
        private final h.c<T> f2221c;

        public a(h.c<T> cVar) {
            this.f2221c = cVar;
        }

        public c<T> a() {
            if (this.f2220b == null) {
                synchronized (f2217d) {
                    if (f2218e == null) {
                        f2218e = Executors.newFixedThreadPool(2);
                    }
                }
                this.f2220b = f2218e;
            }
            return new c<>(this.f2219a, this.f2220b, this.f2221c);
        }
    }
}
