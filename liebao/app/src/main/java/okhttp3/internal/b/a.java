package okhttp3.internal.b;

import okhttp3.aa;
import okhttp3.ac;
import okhttp3.u;
import okhttp3.x;

/* compiled from: ConnectInterceptor.java */
/* loaded from: classes2.dex */
public final class a implements u {

    /* renamed from: a  reason: collision with root package name */
    public final x f7438a;

    public a(x xVar) {
        this.f7438a = xVar;
    }

    @Override // okhttp3.u
    public ac a(u.a aVar) {
        okhttp3.internal.c.g gVar = (okhttp3.internal.c.g) aVar;
        aa a2 = gVar.a();
        g f = gVar.f();
        return gVar.a(a2, f, f.a(this.f7438a, aVar, !a2.b().equals("GET")), f.c());
    }
}
