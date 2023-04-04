package com.bumptech.glide.c.b.b;

import androidx.core.g.e;
import com.bumptech.glide.i.a.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SafeKeyGenerator.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.i.f<com.bumptech.glide.c.h, String> f4745a = new com.bumptech.glide.i.f<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final e.a<a> f4746b = com.bumptech.glide.i.a.a.b(10, new a.InterfaceC0099a<a>() { // from class: com.bumptech.glide.c.b.b.j.1
        @Override // com.bumptech.glide.i.a.a.InterfaceC0099a
        /* renamed from: a */
        public a b() {
            try {
                return new a(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    });

    public String a(com.bumptech.glide.c.h hVar) {
        String b2;
        synchronized (this.f4745a) {
            b2 = this.f4745a.b(hVar);
        }
        if (b2 == null) {
            b2 = b(hVar);
        }
        synchronized (this.f4745a) {
            this.f4745a.b(hVar, b2);
        }
        return b2;
    }

    private String b(com.bumptech.glide.c.h hVar) {
        a aVar = (a) com.bumptech.glide.i.i.a(this.f4746b.a());
        try {
            hVar.a(aVar.f4748a);
            return com.bumptech.glide.i.j.a(aVar.f4748a.digest());
        } finally {
            this.f4746b.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeKeyGenerator.java */
    /* loaded from: classes.dex */
    public static final class a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final MessageDigest f4748a;

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.i.a.c f4749b = com.bumptech.glide.i.a.c.a();

        a(MessageDigest messageDigest) {
            this.f4748a = messageDigest;
        }

        @Override // com.bumptech.glide.i.a.a.c
        public com.bumptech.glide.i.a.c d_() {
            return this.f4749b;
        }
    }
}
