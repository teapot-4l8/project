package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class ao extends k implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<an> f6159b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<an> f6160a = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a((Collection) this.f6160a, 0);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        if (f6159b == null) {
            f6159b = new ArrayList<>();
            f6159b.add(new an());
        }
        this.f6160a = (ArrayList) iVar.a((i) f6159b, 0, true);
    }
}
