package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class ar extends k implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public String f6172a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f6173b = "";

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f6172a, 0);
        jVar.a(this.f6173b, 1);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f6172a = iVar.b(0, true);
        this.f6173b = iVar.b(1, true);
    }
}
