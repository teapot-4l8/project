package com.facebook.crypto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: Crypto.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final com.facebook.crypto.b.a f5291a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.crypto.e.b f5292b;

    /* renamed from: c  reason: collision with root package name */
    private final d f5293c;

    public c(com.facebook.crypto.b.a aVar, com.facebook.crypto.e.b bVar, f fVar) {
        a aVar2 = new a(aVar, fVar);
        this.f5291a = aVar2;
        this.f5292b = bVar;
        this.f5293c = new e(bVar, aVar2, fVar);
    }

    public boolean a() {
        try {
            this.f5292b.a();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public OutputStream a(OutputStream outputStream, g gVar, byte[] bArr) {
        return this.f5293c.a(outputStream, gVar, bArr);
    }

    public InputStream a(InputStream inputStream, g gVar) {
        return this.f5293c.a(inputStream, gVar);
    }

    public byte[] a(byte[] bArr, g gVar) {
        com.facebook.crypto.d.a aVar = new com.facebook.crypto.d.a(bArr.length + b());
        OutputStream a2 = a(aVar, gVar, null);
        a2.write(bArr);
        a2.close();
        return aVar.a();
    }

    public byte[] b(byte[] bArr, g gVar) {
        int length = bArr.length;
        InputStream a2 = a(new ByteArrayInputStream(bArr), gVar);
        com.facebook.crypto.d.a aVar = new com.facebook.crypto.d.a(length - b());
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = a2.read(bArr2);
            if (read != -1) {
                aVar.write(bArr2, 0, read);
            } else {
                a2.close();
                return aVar.a();
            }
        }
    }

    int b() {
        return this.f5293c.a();
    }
}
