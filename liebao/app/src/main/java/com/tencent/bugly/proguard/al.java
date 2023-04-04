package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class al extends k implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static ArrayList<String> f6146c;

    /* renamed from: a  reason: collision with root package name */
    private String f6147a = "";

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f6148b = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f6147a, 0);
        ArrayList<String> arrayList = this.f6148b;
        if (arrayList != null) {
            jVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f6147a = iVar.b(0, true);
        if (f6146c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f6146c = arrayList;
            arrayList.add("");
        }
        this.f6148b = (ArrayList) iVar.a((i) f6146c, 1, false);
    }
}
