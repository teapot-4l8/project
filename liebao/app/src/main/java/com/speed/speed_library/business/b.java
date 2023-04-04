package com.speed.speed_library.business;

import android.text.TextUtils;
import b.b.h;
import com.speed.speed_library.b.g;
import com.speed.speed_library.b.i;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.DomainModel;
import java.util.List;

/* compiled from: Domain.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f5625a = new b();

    private b() {
    }

    public final void a() {
        if (TextUtils.isEmpty(i.f5619a.d())) {
            return;
        }
        b.b.e.b("").a(a.f5626a).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new C0138b());
    }

    /* compiled from: Domain.kt */
    /* loaded from: classes2.dex */
    static final class a<T, R> implements b.b.d.e<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f5626a = new a();

        a() {
        }

        @Override // b.b.d.e
        public final String a(String str) {
            kotlin.d.b.i.b(str, "it");
            return com.speed.speed_library.b.b.f5592a.o();
        }
    }

    /* compiled from: Domain.kt */
    /* renamed from: com.speed.speed_library.business.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0138b implements h<String> {
        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            kotlin.d.b.i.b(bVar, "d");
        }

        @Override // b.b.h
        public void a(Throwable th) {
            kotlin.d.b.i.b(th, "e");
        }

        @Override // b.b.h
        public void b() {
        }

        C0138b() {
        }

        @Override // b.b.h
        /* renamed from: a */
        public void a_(String str) {
            kotlin.d.b.i.b(str, "baseUrl");
            b.f5625a.a(str);
        }
    }

    public final void a(String str) {
        kotlin.d.b.i.b(str, "baseUrl");
        d.a.a.a.a.c.f6985a.a(str).i().b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new c());
    }

    /* compiled from: Domain.kt */
    /* loaded from: classes2.dex */
    public static final class c extends com.speed.speed_library.a.c<BaseModel<DomainModel>> {
        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            kotlin.d.b.i.b(th, "e");
        }

        c() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<DomainModel> baseModel) {
            kotlin.d.b.i.b(baseModel, "response");
            if (com.speed.speed_library.b.h.f5614a.a(baseModel, false)) {
                DomainModel data = baseModel.getData();
                if (data != null) {
                    if (!TextUtils.isEmpty(data.getDomain())) {
                        g.f5610b.a(data);
                        return;
                    } else {
                        g.f5610b.m();
                        return;
                    }
                }
                return;
            }
            g.f5610b.m();
        }
    }

    public final String b(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (str == null) {
            kotlin.d.b.i.a();
        }
        List b2 = kotlin.h.g.b((CharSequence) str2, new String[]{";"}, false, 0, 6, (Object) null);
        return b2.isEmpty() ? "" : (String) b2.get(0);
    }

    public final String c(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (str == null) {
            kotlin.d.b.i.a();
        }
        List b2 = kotlin.h.g.b((CharSequence) str2, new String[]{";"}, false, 0, 6, (Object) null);
        return (!b2.isEmpty() && b2.size() > 1) ? (String) b2.get(1) : "";
    }
}
