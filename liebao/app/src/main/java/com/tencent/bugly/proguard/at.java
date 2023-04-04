package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class at extends k {
    private static Map<String, String> i;

    /* renamed from: a  reason: collision with root package name */
    public long f6179a = 0;

    /* renamed from: b  reason: collision with root package name */
    public byte f6180b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f6181c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f6182d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6183e = "";
    public Map<String, String> f = null;
    public String g = "";
    public boolean h = true;

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f6179a, 0);
        jVar.a(this.f6180b, 1);
        String str = this.f6181c;
        if (str != null) {
            jVar.a(str, 2);
        }
        String str2 = this.f6182d;
        if (str2 != null) {
            jVar.a(str2, 3);
        }
        String str3 = this.f6183e;
        if (str3 != null) {
            jVar.a(str3, 4);
        }
        Map<String, String> map = this.f;
        if (map != null) {
            jVar.a((Map) map, 5);
        }
        String str4 = this.g;
        if (str4 != null) {
            jVar.a(str4, 6);
        }
        jVar.a(this.h, 7);
    }

    static {
        HashMap hashMap = new HashMap();
        i = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f6179a = iVar.a(this.f6179a, 0, true);
        this.f6180b = iVar.a(this.f6180b, 1, true);
        this.f6181c = iVar.b(2, false);
        this.f6182d = iVar.b(3, false);
        this.f6183e = iVar.b(4, false);
        this.f = (Map) iVar.a((i) i, 5, false);
        this.g = iVar.b(6, false);
        this.h = iVar.a(7, false);
    }
}
