package b.b.e.e.c;

import b.b.i;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableInterval.java */
/* loaded from: classes.dex */
public final class g extends b.b.e<Long> {

    /* renamed from: a  reason: collision with root package name */
    final b.b.i f3333a;

    /* renamed from: b  reason: collision with root package name */
    final long f3334b;

    /* renamed from: c  reason: collision with root package name */
    final long f3335c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f3336d;

    public g(long j, long j2, TimeUnit timeUnit, b.b.i iVar) {
        this.f3334b = j;
        this.f3335c = j2;
        this.f3336d = timeUnit;
        this.f3333a = iVar;
    }

    @Override // b.b.e
    public void b(b.b.h<? super Long> hVar) {
        a aVar = new a(hVar);
        hVar.a(aVar);
        b.b.i iVar = this.f3333a;
        if (iVar instanceof b.b.e.g.m) {
            i.c a2 = iVar.a();
            aVar.a(a2);
            a2.a(aVar, this.f3334b, this.f3335c, this.f3336d);
            return;
        }
        aVar.a(iVar.a(aVar, this.f3334b, this.f3335c, this.f3336d));
    }

    /* compiled from: ObservableInterval.java */
    /* loaded from: classes.dex */
    static final class a extends AtomicReference<b.b.b.b> implements b.b.b.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final b.b.h<? super Long> f3337a;

        /* renamed from: b  reason: collision with root package name */
        long f3338b;

        a(b.b.h<? super Long> hVar) {
            this.f3337a = hVar;
        }

        @Override // b.b.b.b
        public void a() {
            b.b.e.a.b.a((AtomicReference<b.b.b.b>) this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != b.b.e.a.b.DISPOSED) {
                b.b.h<? super Long> hVar = this.f3337a;
                long j = this.f3338b;
                this.f3338b = 1 + j;
                hVar.a_(Long.valueOf(j));
            }
        }

        public void a(b.b.b.b bVar) {
            b.b.e.a.b.a((AtomicReference<b.b.b.b>) this, bVar);
        }
    }
}
