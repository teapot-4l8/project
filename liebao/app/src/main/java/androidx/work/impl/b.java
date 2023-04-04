package androidx.work.impl;

import androidx.lifecycle.r;
import androidx.work.k;

/* compiled from: OperationImpl.java */
/* loaded from: classes.dex */
public class b implements k {

    /* renamed from: c  reason: collision with root package name */
    private final r<k.a> f2844c = new r<>();

    /* renamed from: d  reason: collision with root package name */
    private final androidx.work.impl.utils.a.c<k.a.c> f2845d = androidx.work.impl.utils.a.c.d();

    public b() {
        a(k.f3068b);
    }

    public void a(k.a aVar) {
        this.f2844c.a((r<k.a>) aVar);
        if (aVar instanceof k.a.c) {
            this.f2845d.a((androidx.work.impl.utils.a.c<k.a.c>) ((k.a.c) aVar));
        } else if (aVar instanceof k.a.C0063a) {
            this.f2845d.a(((k.a.C0063a) aVar).a());
        }
    }
}
