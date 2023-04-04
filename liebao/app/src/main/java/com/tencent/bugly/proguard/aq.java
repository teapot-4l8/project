package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class aq extends k {
    private static byte[] i;
    private static Map<String, String> j;

    /* renamed from: a  reason: collision with root package name */
    public byte f6167a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f6168b = 0;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f6169c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f6170d = "";

    /* renamed from: e  reason: collision with root package name */
    public long f6171e = 0;
    private String h = "";
    public String f = "";
    public Map<String, String> g = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f6167a, 0);
        jVar.a(this.f6168b, 1);
        byte[] bArr = this.f6169c;
        if (bArr != null) {
            jVar.a(bArr, 2);
        }
        String str = this.f6170d;
        if (str != null) {
            jVar.a(str, 3);
        }
        jVar.a(this.f6171e, 4);
        String str2 = this.h;
        if (str2 != null) {
            jVar.a(str2, 5);
        }
        String str3 = this.f;
        if (str3 != null) {
            jVar.a(str3, 6);
        }
        Map<String, String> map = this.g;
        if (map != null) {
            jVar.a((Map) map, 7);
        }
    }

    static {
        i = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f6167a = iVar.a(this.f6167a, 0, true);
        this.f6168b = iVar.a(this.f6168b, 1, true);
        this.f6169c = iVar.c(2, false);
        this.f6170d = iVar.b(3, false);
        this.f6171e = iVar.a(this.f6171e, 4, false);
        this.h = iVar.b(5, false);
        this.f = iVar.b(6, false);
        this.g = (Map) iVar.a((i) j, 7, false);
    }
}
