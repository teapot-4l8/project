package okhttp3.internal.c;

import java.util.List;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.m;
import okhttp3.u;
import okhttp3.v;

/* compiled from: BridgeInterceptor.java */
/* loaded from: classes2.dex */
public final class a implements u {

    /* renamed from: a  reason: collision with root package name */
    private final m f7472a;

    public a(m mVar) {
        this.f7472a = mVar;
    }

    @Override // okhttp3.u
    public ac a(u.a aVar) {
        aa a2 = aVar.a();
        aa.a e2 = a2.e();
        ab d2 = a2.d();
        if (d2 != null) {
            v b2 = d2.b();
            if (b2 != null) {
                e2.a("Content-Type", b2.toString());
            }
            long c2 = d2.c();
            if (c2 != -1) {
                e2.a("Content-Length", Long.toString(c2));
                e2.b("Transfer-Encoding");
            } else {
                e2.a("Transfer-Encoding", "chunked");
                e2.b("Content-Length");
            }
        }
        boolean z = false;
        if (a2.a("Host") == null) {
            e2.a("Host", okhttp3.internal.c.a(a2.a(), false));
        }
        if (a2.a("Connection") == null) {
            e2.a("Connection", "Keep-Alive");
        }
        if (a2.a("Accept-Encoding") == null && a2.a("Range") == null) {
            z = true;
            e2.a("Accept-Encoding", "gzip");
        }
        List<okhttp3.l> a3 = this.f7472a.a(a2.a());
        if (!a3.isEmpty()) {
            e2.a("Cookie", a(a3));
        }
        if (a2.a("User-Agent") == null) {
            e2.a("User-Agent", okhttp3.internal.d.a());
        }
        ac a4 = aVar.a(e2.a());
        e.a(this.f7472a, a2.a(), a4.g());
        ac.a a5 = a4.i().a(a2);
        if (z && "gzip".equalsIgnoreCase(a4.a("Content-Encoding")) && e.d(a4)) {
            c.j jVar = new c.j(a4.h().c());
            a5.a(a4.g().c().b("Content-Encoding").b("Content-Length").a());
            a5.a(new h(a4.a("Content-Type"), -1L, c.l.a(jVar)));
        }
        return a5.a();
    }

    private String a(List<okhttp3.l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            okhttp3.l lVar = list.get(i);
            sb.append(lVar.a());
            sb.append('=');
            sb.append(lVar.b());
        }
        return sb.toString();
    }
}
