package com.facebook.crypto;

import java.security.SecureRandom;

/* compiled from: Conceal.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.facebook.crypto.e.b f5289a;

    /* renamed from: b  reason: collision with root package name */
    public final SecureRandom f5290b;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(com.facebook.crypto.e.b bVar, SecureRandom secureRandom) {
        this.f5289a = bVar;
        this.f5290b = secureRandom;
    }

    public c a(com.facebook.crypto.b.a aVar) {
        return b(aVar);
    }

    public c b(com.facebook.crypto.b.a aVar) {
        return new c(aVar, this.f5289a, f.KEY_256);
    }
}
