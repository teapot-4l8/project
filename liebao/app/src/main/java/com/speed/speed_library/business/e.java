package com.speed.speed_library.business;

import com.speed.speed_library.b.g;
import com.speed.speed_library.model.UserModel;
import kotlin.d.b.i;

/* compiled from: User.kt */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f5632a = new e();

    private e() {
    }

    public final long a() {
        return System.currentTimeMillis() / 1000;
    }

    public final boolean b() {
        return g.f5610b.j() != null;
    }

    public final boolean c() {
        UserModel j = g.f5610b.j();
        Long valueOf = j != null ? Long.valueOf(j.getExpire_time()) : null;
        if (valueOf == null) {
            i.a();
        }
        return valueOf.longValue() < a();
    }

    public final boolean d() {
        UserModel j = g.f5610b.j();
        Long valueOf = j != null ? Long.valueOf(j.getVip_expire_time()) : null;
        if (valueOf == null) {
            i.a();
        }
        return valueOf.longValue() < a();
    }
}
