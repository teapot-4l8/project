package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class au extends k implements Cloneable {
    private static ArrayList<at> f;
    private static Map<String, String> g;

    /* renamed from: a  reason: collision with root package name */
    public byte f6184a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f6185b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f6186c = "";

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<at> f6187d = null;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f6188e = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f6184a, 0);
        String str = this.f6185b;
        if (str != null) {
            jVar.a(str, 1);
        }
        String str2 = this.f6186c;
        if (str2 != null) {
            jVar.a(str2, 2);
        }
        ArrayList<at> arrayList = this.f6187d;
        if (arrayList != null) {
            jVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f6188e;
        if (map != null) {
            jVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f6184a = iVar.a(this.f6184a, 0, true);
        this.f6185b = iVar.b(1, false);
        this.f6186c = iVar.b(2, false);
        if (f == null) {
            f = new ArrayList<>();
            f.add(new at());
        }
        this.f6187d = (ArrayList) iVar.a((i) f, 3, false);
        if (g == null) {
            HashMap hashMap = new HashMap();
            g = hashMap;
            hashMap.put("", "");
        }
        this.f6188e = (Map) iVar.a((i) g, 4, false);
    }
}
