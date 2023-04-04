package com.tencent.bugly.proguard;

import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class as extends k implements Cloneable {
    private static Map<String, String> n;
    private static /* synthetic */ boolean o = !as.class.desiredAssertionStatus();
    private static ar m = new ar();

    /* renamed from: a  reason: collision with root package name */
    public boolean f6174a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6175b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6176c = true;

    /* renamed from: d  reason: collision with root package name */
    public String f6177d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6178e = "";
    public ar f = null;
    public Map<String, String> g = null;
    public long h = 0;
    private String j = "";
    private String k = "";
    private int l = 0;
    public int i = 0;

    static {
        HashMap hashMap = new HashMap();
        n = hashMap;
        hashMap.put("", "");
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        as asVar = (as) obj;
        return l.a(this.f6174a, asVar.f6174a) && l.a(this.f6175b, asVar.f6175b) && l.a(this.f6176c, asVar.f6176c) && l.a(this.f6177d, asVar.f6177d) && l.a(this.f6178e, asVar.f6178e) && l.a(this.f, asVar.f) && l.a(this.g, asVar.g) && l.a(this.h, asVar.h) && l.a(this.j, asVar.j) && l.a(this.k, asVar.k) && l.a(this.l, asVar.l) && l.a(this.i, asVar.i);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f6174a, 0);
        jVar.a(this.f6175b, 1);
        jVar.a(this.f6176c, 2);
        String str = this.f6177d;
        if (str != null) {
            jVar.a(str, 3);
        }
        String str2 = this.f6178e;
        if (str2 != null) {
            jVar.a(str2, 4);
        }
        ar arVar = this.f;
        if (arVar != null) {
            jVar.a((k) arVar, 5);
        }
        Map<String, String> map = this.g;
        if (map != null) {
            jVar.a((Map) map, 6);
        }
        jVar.a(this.h, 7);
        String str3 = this.j;
        if (str3 != null) {
            jVar.a(str3, 8);
        }
        String str4 = this.k;
        if (str4 != null) {
            jVar.a(str4, 9);
        }
        jVar.a(this.l, 10);
        jVar.a(this.i, 11);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f6174a = iVar.a(0, true);
        this.f6175b = iVar.a(1, true);
        this.f6176c = iVar.a(2, true);
        this.f6177d = iVar.b(3, false);
        this.f6178e = iVar.b(4, false);
        this.f = (ar) iVar.a((k) m, 5, false);
        this.g = (Map) iVar.a((i) n, 6, false);
        this.h = iVar.a(this.h, 7, false);
        this.j = iVar.b(8, false);
        this.k = iVar.b(9, false);
        this.l = iVar.a(this.l, 10, false);
        this.i = iVar.a(this.i, 11, false);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
        h hVar = new h(sb, i);
        hVar.a(this.f6174a, "enable");
        hVar.a(this.f6175b, "enableUserInfo");
        hVar.a(this.f6176c, "enableQuery");
        hVar.a(this.f6177d, ImagesContract.URL);
        hVar.a(this.f6178e, "expUrl");
        hVar.a((k) this.f, "security");
        hVar.a((Map) this.g, "valueMap");
        hVar.a(this.h, "strategylastUpdateTime");
        hVar.a(this.j, "httpsUrl");
        hVar.a(this.k, "httpsExpUrl");
        hVar.a(this.l, "eventRecordCount");
        hVar.a(this.i, "eventTimeInterval");
    }
}
