package com.umeng.commonsdk.statistics.idtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: AbstractIdTracker.java */
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f6850a = 10;

    /* renamed from: b  reason: collision with root package name */
    private final int f6851b = 100;

    /* renamed from: c  reason: collision with root package name */
    private final String f6852c;

    /* renamed from: d  reason: collision with root package name */
    private List<com.umeng.commonsdk.statistics.proto.a> f6853d;

    /* renamed from: e  reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.b f6854e;

    public abstract String f();

    public a(String str) {
        this.f6852c = str;
    }

    public boolean a() {
        return g();
    }

    public String b() {
        return this.f6852c;
    }

    public boolean c() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f6854e;
        return bVar == null || bVar.h() <= 100;
    }

    private boolean g() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f6854e;
        String b2 = bVar == null ? null : bVar.b();
        int h = bVar == null ? 0 : bVar.h();
        String a2 = a(f());
        if (a2 == null || a2.equals(b2)) {
            return false;
        }
        if (bVar == null) {
            bVar = new com.umeng.commonsdk.statistics.proto.b();
        }
        bVar.a(a2);
        bVar.a(System.currentTimeMillis());
        bVar.a(h + 1);
        com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
        aVar.a(this.f6852c);
        aVar.c(a2);
        aVar.b(b2);
        aVar.a(bVar.e());
        if (this.f6853d == null) {
            this.f6853d = new ArrayList(2);
        }
        this.f6853d.add(aVar);
        if (this.f6853d.size() > 10) {
            this.f6853d.remove(0);
        }
        this.f6854e = bVar;
        return true;
    }

    public com.umeng.commonsdk.statistics.proto.b d() {
        return this.f6854e;
    }

    public void a(com.umeng.commonsdk.statistics.proto.b bVar) {
        this.f6854e = bVar;
    }

    public List<com.umeng.commonsdk.statistics.proto.a> e() {
        return this.f6853d;
    }

    public void a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f6853d = list;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || "unknown".equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    public void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        this.f6854e = cVar.c().get(this.f6852c);
        List<com.umeng.commonsdk.statistics.proto.a> h = cVar.h();
        if (h == null || h.size() <= 0) {
            return;
        }
        if (this.f6853d == null) {
            this.f6853d = new ArrayList();
        }
        for (com.umeng.commonsdk.statistics.proto.a aVar : h) {
            if (this.f6852c.equals(aVar.f6899a)) {
                this.f6853d.add(aVar);
            }
        }
    }
}
