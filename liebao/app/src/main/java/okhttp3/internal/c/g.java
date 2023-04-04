package okhttp3.internal.c;

import java.util.List;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.p;
import okhttp3.u;

/* compiled from: RealInterceptorChain.java */
/* loaded from: classes2.dex */
public final class g implements u.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<u> f7480a;

    /* renamed from: b  reason: collision with root package name */
    private final okhttp3.internal.b.g f7481b;

    /* renamed from: c  reason: collision with root package name */
    private final c f7482c;

    /* renamed from: d  reason: collision with root package name */
    private final okhttp3.internal.b.c f7483d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7484e;
    private final aa f;
    private final okhttp3.e g;
    private final p h;
    private final int i;
    private final int j;
    private final int k;
    private int l;

    public g(List<u> list, okhttp3.internal.b.g gVar, c cVar, okhttp3.internal.b.c cVar2, int i, aa aaVar, okhttp3.e eVar, p pVar, int i2, int i3, int i4) {
        this.f7480a = list;
        this.f7483d = cVar2;
        this.f7481b = gVar;
        this.f7482c = cVar;
        this.f7484e = i;
        this.f = aaVar;
        this.g = eVar;
        this.h = pVar;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    @Override // okhttp3.u.a
    public okhttp3.i b() {
        return this.f7483d;
    }

    @Override // okhttp3.u.a
    public int c() {
        return this.i;
    }

    @Override // okhttp3.u.a
    public int d() {
        return this.j;
    }

    @Override // okhttp3.u.a
    public int e() {
        return this.k;
    }

    public okhttp3.internal.b.g f() {
        return this.f7481b;
    }

    public c g() {
        return this.f7482c;
    }

    public okhttp3.e h() {
        return this.g;
    }

    public p i() {
        return this.h;
    }

    @Override // okhttp3.u.a
    public aa a() {
        return this.f;
    }

    @Override // okhttp3.u.a
    public ac a(aa aaVar) {
        return a(aaVar, this.f7481b, this.f7482c, this.f7483d);
    }

    public ac a(aa aaVar, okhttp3.internal.b.g gVar, c cVar, okhttp3.internal.b.c cVar2) {
        if (this.f7484e >= this.f7480a.size()) {
            throw new AssertionError();
        }
        this.l++;
        if (this.f7482c != null && !this.f7483d.a(aaVar.a())) {
            throw new IllegalStateException("network interceptor " + this.f7480a.get(this.f7484e - 1) + " must retain the same host and port");
        } else if (this.f7482c != null && this.l > 1) {
            throw new IllegalStateException("network interceptor " + this.f7480a.get(this.f7484e - 1) + " must call proceed() exactly once");
        } else {
            g gVar2 = new g(this.f7480a, gVar, cVar, cVar2, this.f7484e + 1, aaVar, this.g, this.h, this.i, this.j, this.k);
            u uVar = this.f7480a.get(this.f7484e);
            ac a2 = uVar.a(gVar2);
            if (cVar != null && this.f7484e + 1 < this.f7480a.size() && gVar2.l != 1) {
                throw new IllegalStateException("network interceptor " + uVar + " must call proceed() exactly once");
            } else if (a2 == null) {
                throw new NullPointerException("interceptor " + uVar + " returned null");
            } else if (a2.h() != null) {
                return a2;
            } else {
                throw new IllegalStateException("interceptor " + uVar + " returned a response with no body");
            }
        }
    }
}
