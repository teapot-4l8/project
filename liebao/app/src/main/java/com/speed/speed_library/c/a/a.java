package com.speed.speed_library.c.a;

import android.os.Build;
import com.speed.speed_library.b.g;
import com.speed.speed_library.model.UserModel;
import com.speed.speed_library.utils.e;
import kotlin.d.b.i;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.u;

/* compiled from: HeaderInterceptor.kt */
/* loaded from: classes2.dex */
public final class a implements u {
    @Override // okhttp3.u
    public ac a(u.a aVar) {
        i.b(aVar, "chain");
        aa.a e2 = aVar.a().e();
        e2.a("Platform", "Android");
        e2.a("bundleId", g.f5610b.a().getPackageName());
        e2.a("versionCode", String.valueOf(e.b(g.f5610b.a())));
        e2.a("deviceId", com.speed.speed_library.b.e.f5601a.a(g.f5610b.a()).a());
        e2.a("channel", g.f5610b.b());
        e2.a("spreadNum", g.f5610b.c());
        e2.a("push-id", g.f5610b.G());
        e2.a("b_version", String.valueOf(kotlin.f.d.a(new kotlin.f.c(0, 9), kotlin.e.c.f7166b)) + Build.VERSION.RELEASE + String.valueOf(kotlin.f.d.a(new kotlin.f.c(0, 9), kotlin.e.c.f7166b)));
        e2.a("RouteType", "");
        e2.a("Ua", com.speed.speed_library.b.c.f5594a.a());
        if (g.f5610b.j() != null) {
            UserModel j = g.f5610b.j();
            e2.a("Authorization", j != null ? j.getToken() : null);
        }
        ac a2 = aVar.a(e2.a());
        i.a((Object) a2, "chain.proceed(newRequestBuilder.build())");
        return a2;
    }
}
