package com.speed.speed_library.b;

import com.speed.speed_library.model.DomainModel;
import utils.AppLog;
import wg.Wg;

/* compiled from: Api.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f5592a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f5593b = true;

    private b() {
    }

    public final String a() {
        return n() + "/broadcast.html";
    }

    public final String a(String str) {
        kotlin.d.b.i.b(str, com.umeng.analytics.pro.d.y);
        return n() + "/recharge.html?type=" + str;
    }

    public final String b() {
        return n() + "/notice.html";
    }

    public final String c() {
        return n() + "/activity/share.html";
    }

    public final String d() {
        return n() + "/user/coupon.html";
    }

    public final String b(String str) {
        kotlin.d.b.i.b(str, "id");
        return n() + "/order/recharge_coupon.html?id=" + str;
    }

    public final String e() {
        return n() + "/order.html";
    }

    public final String f() {
        return n() + "/feedback.html";
    }

    public final String g() {
        return n() + "/recommend.html";
    }

    public final String h() {
        return n() + "/policy.html";
    }

    public final String i() {
        return n() + "/collaborate.html";
    }

    public final String j() {
        return k() + "/api/app/common/report/endpoint";
    }

    public final String k() {
        if (g.f5610b.l() != null) {
            com.speed.speed_library.business.b bVar = com.speed.speed_library.business.b.f5625a;
            DomainModel l = g.f5610b.l();
            return bVar.b(l != null ? l.getDomain() : null);
        }
        return l();
    }

    public final String l() {
        if (kotlin.d.b.i.a((Object) g.f5610b.S(), (Object) "")) {
            return i.f5619a.a();
        }
        return com.speed.speed_library.business.b.f5625a.b(g.f5610b.S());
    }

    public final String m() {
        if (kotlin.d.b.i.a((Object) g.f5610b.S(), (Object) "")) {
            return i.f5619a.b();
        }
        return com.speed.speed_library.business.b.f5625a.c(g.f5610b.S());
    }

    public final String n() {
        if (g.f5610b.l() != null) {
            com.speed.speed_library.business.b bVar = com.speed.speed_library.business.b.f5625a;
            DomainModel l = g.f5610b.l();
            return bVar.c(l != null ? l.getDomain() : null);
        }
        return m();
    }

    public final String o() {
        String domain = Wg.getDomain(i.f5619a.d(), "", false);
        AppLog appLog = AppLog.INSTANCE;
        appLog.i("qtReturnDomain:" + domain);
        if (domain.equals("")) {
            return k();
        }
        return com.speed.speed_library.business.b.f5625a.b(domain);
    }
}
