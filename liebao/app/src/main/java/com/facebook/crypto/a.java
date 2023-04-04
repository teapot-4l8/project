package com.facebook.crypto;

/* compiled from: CheckedKeyChain.java */
/* loaded from: classes.dex */
class a implements com.facebook.crypto.b.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.facebook.crypto.b.a f5287a;

    /* renamed from: b  reason: collision with root package name */
    private final f f5288b;

    public a(com.facebook.crypto.b.a aVar, f fVar) {
        this.f5287a = aVar;
        this.f5288b = fVar;
    }

    @Override // com.facebook.crypto.b.a
    public byte[] a() {
        byte[] a2 = this.f5287a.a();
        a(a2, this.f5288b.f5324d, "Key");
        return a2;
    }

    @Override // com.facebook.crypto.b.a
    public byte[] b() {
        byte[] b2 = this.f5287a.b();
        a(b2, this.f5288b.f5325e, "IV");
        return b2;
    }

    private void a(byte[] bArr, int i, String str) {
        if (bArr.length == i) {
            return;
        }
        throw new IllegalStateException(str + " should be " + i + " bytes long but is " + bArr.length);
    }
}
