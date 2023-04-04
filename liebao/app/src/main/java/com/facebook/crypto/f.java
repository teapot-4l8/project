package com.facebook.crypto;

/* compiled from: CryptoConfig.java */
/* loaded from: classes.dex */
public enum f {
    KEY_128((byte) 1, 16, 12, 16),
    KEY_256((byte) 2, 32, 12, 16);
    

    /* renamed from: c  reason: collision with root package name */
    public final byte f5323c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5324d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5325e;
    public final int f;

    f(byte b2, int i, int i2, int i3) {
        this.f5323c = b2;
        this.f5324d = i;
        this.f5325e = i2;
        this.f = i3;
    }
}
