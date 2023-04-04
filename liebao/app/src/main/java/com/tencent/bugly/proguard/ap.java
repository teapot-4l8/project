package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class ap extends k {
    private static byte[] y;
    private static Map<String, String> z;

    /* renamed from: a  reason: collision with root package name */
    public int f6161a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f6162b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f6163c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f6164d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6165e = "";
    public String f = "";
    public int g = 0;
    public byte[] h = null;
    public String i = "";
    public String j = "";
    public Map<String, String> k = null;
    public String l = "";
    public long m = 0;
    public String n = "";
    public String o = "";
    public String p = "";

    /* renamed from: q  reason: collision with root package name */
    public long f6166q = 0;
    public String r = "";
    public String s = "";
    public String t = "";
    public String u = "";
    public String v = "";
    public String w = "";
    private String x = "";

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f6161a, 0);
        jVar.a(this.f6162b, 1);
        jVar.a(this.f6163c, 2);
        jVar.a(this.f6164d, 3);
        String str = this.f6165e;
        if (str != null) {
            jVar.a(str, 4);
        }
        jVar.a(this.f, 5);
        jVar.a(this.g, 6);
        jVar.a(this.h, 7);
        String str2 = this.i;
        if (str2 != null) {
            jVar.a(str2, 8);
        }
        String str3 = this.j;
        if (str3 != null) {
            jVar.a(str3, 9);
        }
        Map<String, String> map = this.k;
        if (map != null) {
            jVar.a((Map) map, 10);
        }
        String str4 = this.l;
        if (str4 != null) {
            jVar.a(str4, 11);
        }
        jVar.a(this.m, 12);
        String str5 = this.n;
        if (str5 != null) {
            jVar.a(str5, 13);
        }
        String str6 = this.o;
        if (str6 != null) {
            jVar.a(str6, 14);
        }
        String str7 = this.p;
        if (str7 != null) {
            jVar.a(str7, 15);
        }
        jVar.a(this.f6166q, 16);
        String str8 = this.r;
        if (str8 != null) {
            jVar.a(str8, 17);
        }
        String str9 = this.s;
        if (str9 != null) {
            jVar.a(str9, 18);
        }
        String str10 = this.t;
        if (str10 != null) {
            jVar.a(str10, 19);
        }
        String str11 = this.u;
        if (str11 != null) {
            jVar.a(str11, 20);
        }
        String str12 = this.v;
        if (str12 != null) {
            jVar.a(str12, 21);
        }
        String str13 = this.w;
        if (str13 != null) {
            jVar.a(str13, 22);
        }
        String str14 = this.x;
        if (str14 != null) {
            jVar.a(str14, 23);
        }
    }

    static {
        y = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        z = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f6161a = iVar.a(this.f6161a, 0, true);
        this.f6162b = iVar.b(1, true);
        this.f6163c = iVar.b(2, true);
        this.f6164d = iVar.b(3, true);
        this.f6165e = iVar.b(4, false);
        this.f = iVar.b(5, true);
        this.g = iVar.a(this.g, 6, true);
        this.h = iVar.c(7, true);
        this.i = iVar.b(8, false);
        this.j = iVar.b(9, false);
        this.k = (Map) iVar.a((i) z, 10, false);
        this.l = iVar.b(11, false);
        this.m = iVar.a(this.m, 12, false);
        this.n = iVar.b(13, false);
        this.o = iVar.b(14, false);
        this.p = iVar.b(15, false);
        this.f6166q = iVar.a(this.f6166q, 16, false);
        this.r = iVar.b(17, false);
        this.s = iVar.b(18, false);
        this.t = iVar.b(19, false);
        this.u = iVar.b(20, false);
        this.v = iVar.b(21, false);
        this.w = iVar.b(22, false);
        this.x = iVar.b(23, false);
    }
}
