package com.speed.speed_library.c.a;

import com.speed.speed_library.business.e;
import com.speed.speed_library.model.UserModel;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.d.b.g;
import kotlin.d.b.i;
import okhttp3.a.a;
import okhttp3.x;

/* compiled from: OKHttpClient.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5659a = new a(null);

    /* compiled from: OKHttpClient.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final b a() {
            return new b();
        }
    }

    public final x a() {
        UserModel j;
        okhttp3.a.a aVar = new okhttp3.a.a();
        aVar.a(a.EnumC0184a.NONE);
        x.a a2 = new x.a().a(true).a(10L, TimeUnit.SECONDS).b(10L, TimeUnit.SECONDS).a(new com.speed.speed_library.c.a.a()).a(new c()).a(aVar).a(new d());
        if (e.f5632a.b() && (j = com.speed.speed_library.b.g.f5610b.j()) != null && j.getWhitelist() == 1) {
            a2.a(new leavesc.hello.monitor.b(com.speed.speed_library.b.g.f5610b.a()));
        }
        a2.a(b());
        x a3 = a2.a();
        i.a((Object) a3, "okHttpClientBuilder.build()");
        return a3;
    }

    public final okhttp3.c b() {
        return new okhttp3.c(new File(com.speed.speed_library.b.g.f5610b.a().getCacheDir(), "OkCache"), 52428800L);
    }
}
