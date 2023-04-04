package com.speed.speed_library.c.a;

import c.e;
import com.speed.speed_library.R;
import com.speed.speed_library.b.g;
import com.speed.speed_library.utils.DeviceUtils;
import java.nio.charset.Charset;
import kotlin.d.b.i;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.u;
import okhttp3.v;
import utils.AppLog;

/* compiled from: ResponseDecryptInterceptor.kt */
/* loaded from: classes2.dex */
public final class d implements u {
    @Override // okhttp3.u
    public ac a(u.a aVar) {
        i.b(aVar, "chain");
        ac a2 = aVar.a(aVar.a());
        ad h = a2.h();
        if (h != null) {
            try {
                e c2 = h.c();
                c2.b(Long.MAX_VALUE);
                c.c c3 = c2.c();
                Charset forName = Charset.forName("UTF-8");
                v a3 = h.a();
                if (a3 != null) {
                    forName = a3.a(forName);
                }
                String a4 = c3.clone().a(forName);
                AppLog appLog = AppLog.INSTANCE;
                i.a((Object) a4, "bodyString");
                appLog.i(a4);
                String a5 = com.speed.speed_library.utils.d.f5865a.a(a4, g.f5610b.a().getResources().getString(R.string.d_key_three) + g.f5610b.aa() + DeviceUtils.ddmm(g.f5610b.a()), g.f5610b.a().getResources().getString(R.string.d_key_three) + g.f5610b.aa() + DeviceUtils.ddmm(g.f5610b.a()));
                if (a5 != null) {
                    a2 = a2.i().a(ad.a(a3, kotlin.h.g.a(a5).toString())).a();
                } else {
                    throw new kotlin.i("null cannot be cast to non-null type kotlin.CharSequence");
                }
            } catch (Exception unused) {
                i.a((Object) a2, "response");
                return a2;
            }
        }
        i.a((Object) a2, "response");
        return a2;
    }
}
