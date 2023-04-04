package com.speed.speed_library.debug.netinfo;

import a.a.a.b.b;
import a.a.a.b.f;
import a.a.a.b.h;
import a.a.a.e.q;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.e;
import okhttp3.v;
import okhttp3.x;

/* compiled from: OkHttpUrlLoader.java */
/* loaded from: classes2.dex */
public class a implements f<String> {

    /* renamed from: a  reason: collision with root package name */
    private b f5684a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f5685b = 5000;

    /* renamed from: c  reason: collision with root package name */
    private ad f5686c;

    /* renamed from: d  reason: collision with root package name */
    private volatile e f5687d;

    /* renamed from: e  reason: collision with root package name */
    private e.a f5688e;

    @Override // a.a.a.b.f
    public void a(f.a<? super String> aVar) {
        if (this.f5684a == null || this.f5685b < 1) {
            a.a.a.e.f.b("Failed to load data");
            aVar.a((Exception) new IllegalArgumentException("Failed to load data"));
        }
        this.f5688e = new x().A().a(this.f5685b, TimeUnit.MILLISECONDS).b(this.f5685b, TimeUnit.MILLISECONDS).c(this.f5685b, TimeUnit.MILLISECONDS).a();
        aa.a a2 = new aa.a().a(this.f5684a.d());
        for (Map.Entry<String, String> entry : this.f5684a.e().entrySet()) {
            a2.b(entry.getKey(), entry.getValue());
        }
        if (h.POST == this.f5684a.b() && q.b(this.f5684a.a().a())) {
            a2.a(ab.a(v.b("application/octet-stream"), this.f5684a.a().a().getBytes()));
        }
        this.f5687d = this.f5688e.a(a2.a());
        try {
            ac a3 = this.f5687d.a();
            this.f5686c = a3.h();
            if (a3.d()) {
                aVar.a((f.a<? super String>) this.f5686c.e());
            } else {
                aVar.a((Exception) new a.a.a.a.a(a3.e(), a3.c()));
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            aVar.a((Exception) e2);
        }
        a();
    }

    public void a() {
        ad adVar = this.f5686c;
        if (adVar != null) {
            adVar.close();
        }
    }

    @Override // a.a.a.b.f
    public f<String> a(b bVar) {
        this.f5684a = bVar;
        return this;
    }
}
