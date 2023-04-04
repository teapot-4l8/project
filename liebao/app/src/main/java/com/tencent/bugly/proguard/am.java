package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class am extends k implements Cloneable {

    /* renamed from: d  reason: collision with root package name */
    private static byte[] f6149d;

    /* renamed from: a  reason: collision with root package name */
    private byte f6150a;

    /* renamed from: b  reason: collision with root package name */
    private String f6151b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f6152c;

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i) {
    }

    public am() {
        this.f6150a = (byte) 0;
        this.f6151b = "";
        this.f6152c = null;
    }

    public am(byte b2, String str, byte[] bArr) {
        this.f6150a = (byte) 0;
        this.f6151b = "";
        this.f6152c = null;
        this.f6150a = b2;
        this.f6151b = str;
        this.f6152c = bArr;
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f6150a, 0);
        jVar.a(this.f6151b, 1);
        byte[] bArr = this.f6152c;
        if (bArr != null) {
            jVar.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f6150a = iVar.a(this.f6150a, 0, true);
        this.f6151b = iVar.b(1, true);
        if (f6149d == null) {
            f6149d = r0;
            byte[] bArr = {0};
        }
        this.f6152c = iVar.c(2, false);
    }
}
