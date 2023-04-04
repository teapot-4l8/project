package com.facebook.a.a.a;

import java.security.SecureRandom;

/* compiled from: FixedSecureRandom.java */
/* loaded from: classes.dex */
public class b extends SecureRandom {
    @Override // java.security.SecureRandom, java.util.Random
    public synchronized void nextBytes(byte[] bArr) {
        c.a();
        super.nextBytes(bArr);
    }
}
