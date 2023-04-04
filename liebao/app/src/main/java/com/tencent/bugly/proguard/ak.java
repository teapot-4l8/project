package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class ak extends k implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public String f6141a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f6142b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f6143c = "";

    /* renamed from: e  reason: collision with root package name */
    private String f6145e = "";

    /* renamed from: d  reason: collision with root package name */
    public String f6144d = "";

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f6141a, 0);
        String str = this.f6142b;
        if (str != null) {
            jVar.a(str, 1);
        }
        String str2 = this.f6143c;
        if (str2 != null) {
            jVar.a(str2, 2);
        }
        String str3 = this.f6145e;
        if (str3 != null) {
            jVar.a(str3, 3);
        }
        String str4 = this.f6144d;
        if (str4 != null) {
            jVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f6141a = iVar.b(0, true);
        this.f6142b = iVar.b(1, false);
        this.f6143c = iVar.b(2, false);
        this.f6145e = iVar.b(3, false);
        this.f6144d = iVar.b(4, false);
    }
}
