package leavesc.hello.monitor;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import c.c;
import c.j;
import c.l;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import leavesc.hello.monitor.db.MonitorHttpInformationDatabase;
import leavesc.hello.monitor.holder.ContextHolder;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.internal.c.e;
import okhttp3.s;
import okhttp3.u;
import okhttp3.v;

/* compiled from: MonitorInterceptor.java */
/* loaded from: classes2.dex */
public class b implements u {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f7225a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private Context f7226b;

    /* renamed from: c  reason: collision with root package name */
    private long f7227c = 250000;

    public b(Context context) {
        this.f7226b = context.getApplicationContext();
        ContextHolder.setContext(context);
    }

    @Override // okhttp3.u
    public ac a(u.a aVar) {
        v a2;
        Charset charset;
        String str;
        aa a3 = aVar.a();
        ab d2 = a3.d();
        leavesc.hello.monitor.db.a.b bVar = new leavesc.hello.monitor.db.a.b();
        bVar.a(new Date());
        bVar.a(a3.c());
        bVar.a(a3.b());
        String tVar = a3.a().toString();
        bVar.b(tVar);
        if (!TextUtils.isEmpty(tVar)) {
            Uri parse = Uri.parse(tVar);
            bVar.c(parse.getHost());
            StringBuilder sb = new StringBuilder();
            sb.append(parse.getPath());
            if (parse.getQuery() != null) {
                str = "?" + parse.getQuery();
            } else {
                str = "";
            }
            sb.append(str);
            bVar.d(sb.toString());
            bVar.e(parse.getScheme());
        }
        if (d2 != null) {
            v b2 = d2.b();
            if (b2 != null) {
                bVar.i(b2.toString());
            }
            if (d2.c() != -1) {
                bVar.c(d2.c());
            }
        }
        bVar.c(!a(a3.c()));
        if (d2 != null && bVar.w()) {
            c c2 = a(new c(), b(a3.c())).c();
            d2.a(c2);
            v b3 = d2.b();
            if (b3 != null) {
                charset = b3.a(f7225a);
            } else {
                charset = f7225a;
            }
            if (a(c2)) {
                bVar.h(a(c2, charset));
            } else {
                bVar.d(false);
            }
        }
        bVar.a(a(bVar));
        long nanoTime = System.nanoTime();
        try {
            ac a4 = aVar.a(a3);
            bVar.b(new Date());
            bVar.b(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime));
            bVar.a(a4.a().c());
            bVar.f(a4.b().toString());
            bVar.a(a4.c());
            bVar.l(a4.e());
            ad h = a4.h();
            if (h != null) {
                bVar.d(h.b());
                v a5 = h.a();
                if (a5 != null) {
                    bVar.m(a5.toString());
                }
            }
            bVar.b(a4.g());
            bVar.d(!a(a4.g()));
            if (e.d(a4) && bVar.D()) {
                c.e a6 = a(a4);
                a6.b(Long.MAX_VALUE);
                c c3 = a6.c();
                Charset charset2 = f7225a;
                if (h != null && (a2 = h.a()) != null) {
                    try {
                        charset2 = a2.a(f7225a);
                    } catch (UnsupportedCharsetException unused) {
                        b(bVar);
                        return a4;
                    }
                }
                if (a(c3)) {
                    bVar.k(a(c3.clone(), charset2));
                } else {
                    bVar.d(false);
                }
                bVar.d(c3.b());
            }
            b(bVar);
            return a4;
        } catch (Exception e2) {
            bVar.n(e2.toString());
            b(bVar);
            throw e2;
        }
    }

    private long a(leavesc.hello.monitor.db.a.b bVar) {
        c(bVar);
        return MonitorHttpInformationDatabase.a(this.f7226b).m().a(bVar);
    }

    private void b(leavesc.hello.monitor.db.a.b bVar) {
        c(bVar);
        MonitorHttpInformationDatabase.a(this.f7226b).m().b(bVar);
    }

    private void c(leavesc.hello.monitor.db.a.b bVar) {
        leavesc.hello.monitor.holder.a.a(this.f7226b).a(bVar);
    }

    private boolean a(c cVar) {
        try {
            c cVar2 = new c();
            cVar.a(cVar2, 0L, cVar.b() < 64 ? cVar.b() : 64L);
            for (int i = 0; i < 16; i++) {
                if (cVar2.f()) {
                    return true;
                }
                int s = cVar2.s();
                if (Character.isISOControl(s) && !Character.isWhitespace(s)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    private boolean a(s sVar) {
        String a2 = sVar.a("Content-Encoding");
        return (a2 == null || a2.equalsIgnoreCase("identity") || a2.equalsIgnoreCase("gzip")) ? false : true;
    }

    private String a(c cVar, Charset charset) {
        String str;
        long b2 = cVar.b();
        try {
            str = cVar.a(Math.min(b2, this.f7227c), charset);
        } catch (EOFException unused) {
            str = "\\n\\n--- Unexpected end of content ---";
        }
        if (b2 > this.f7227c) {
            return str + "\\n\\n--- Content truncated ---";
        }
        return str;
    }

    private c.e a(ac acVar) {
        if (b(acVar.g())) {
            c.e c2 = acVar.a(this.f7227c).c();
            if (c2.c().b() < this.f7227c) {
                return a(c2, true);
            }
            Log.e("MonitorInterceptor", "gzip encoded response was too long");
        }
        return acVar.h().c();
    }

    private c.e a(c.e eVar, boolean z) {
        return z ? l.a(new j(eVar)) : eVar;
    }

    private boolean b(s sVar) {
        return "gzip".equalsIgnoreCase(sVar.a("Content-Encoding"));
    }
}
