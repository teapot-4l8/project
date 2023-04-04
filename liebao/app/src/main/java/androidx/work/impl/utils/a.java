package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.k;
import androidx.work.m;
import java.util.LinkedList;

/* compiled from: CancelWorkRunnable.java */
/* loaded from: classes.dex */
public abstract class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final androidx.work.impl.b f2999a = new androidx.work.impl.b();

    abstract void b();

    public k a() {
        return this.f2999a;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            b();
            this.f2999a.a(k.f3067a);
        } catch (Throwable th) {
            this.f2999a.a(new k.a.C0063a(th));
        }
    }

    void a(androidx.work.impl.h hVar, String str) {
        a(hVar.c(), str);
        hVar.f().c(str);
        for (androidx.work.impl.d dVar : hVar.e()) {
            dVar.a(str);
        }
    }

    void a(androidx.work.impl.h hVar) {
        androidx.work.impl.e.a(hVar.d(), hVar.c(), hVar.e());
    }

    private void a(WorkDatabase workDatabase, String str) {
        androidx.work.impl.b.k p = workDatabase.p();
        androidx.work.impl.b.b q2 = workDatabase.q();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            m.a f = p.f(str2);
            if (f != m.a.SUCCEEDED && f != m.a.FAILED) {
                p.a(m.a.CANCELLED, str2);
            }
            linkedList.addAll(q2.b(str2));
        }
    }

    public static a a(final String str, final androidx.work.impl.h hVar) {
        return new a() { // from class: androidx.work.impl.utils.a.1
            @Override // androidx.work.impl.utils.a
            void b() {
                WorkDatabase c2 = androidx.work.impl.h.this.c();
                c2.g();
                try {
                    for (String str2 : c2.p().h(str)) {
                        a(androidx.work.impl.h.this, str2);
                    }
                    c2.j();
                    c2.h();
                    a(androidx.work.impl.h.this);
                } catch (Throwable th) {
                    c2.h();
                    throw th;
                }
            }
        };
    }

    public static a a(final String str, final androidx.work.impl.h hVar, final boolean z) {
        return new a() { // from class: androidx.work.impl.utils.a.2
            @Override // androidx.work.impl.utils.a
            void b() {
                WorkDatabase c2 = androidx.work.impl.h.this.c();
                c2.g();
                try {
                    for (String str2 : c2.p().i(str)) {
                        a(androidx.work.impl.h.this, str2);
                    }
                    c2.j();
                    c2.h();
                    if (z) {
                        a(androidx.work.impl.h.this);
                    }
                } catch (Throwable th) {
                    c2.h();
                    throw th;
                }
            }
        };
    }
}
