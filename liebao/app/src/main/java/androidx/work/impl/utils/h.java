package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.k;
import androidx.work.m;

/* compiled from: StopWorkRunnable.java */
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3054a = androidx.work.h.a("StopWorkRunnable");

    /* renamed from: b  reason: collision with root package name */
    private androidx.work.impl.h f3055b;

    /* renamed from: c  reason: collision with root package name */
    private String f3056c;

    public h(androidx.work.impl.h hVar, String str) {
        this.f3055b = hVar;
        this.f3056c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        WorkDatabase c2 = this.f3055b.c();
        k p = c2.p();
        c2.g();
        try {
            if (p.f(this.f3056c) == m.a.RUNNING) {
                p.a(m.a.ENQUEUED, this.f3056c);
            }
            androidx.work.h.a().b(f3054a, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.f3056c, Boolean.valueOf(this.f3055b.f().b(this.f3056c))), new Throwable[0]);
            c2.j();
        } finally {
            c2.h();
        }
    }
}
