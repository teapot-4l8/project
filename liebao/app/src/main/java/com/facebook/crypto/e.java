package com.facebook.crypto;

import com.facebook.crypto.cipher.NativeGCMCipher;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: CryptoAlgoGcm.java */
/* loaded from: classes.dex */
public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private final com.facebook.crypto.e.b f5314a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.crypto.b.a f5315b;

    /* renamed from: c  reason: collision with root package name */
    private final f f5316c;

    public e(com.facebook.crypto.e.b bVar, com.facebook.crypto.b.a aVar, f fVar) {
        this.f5314a = bVar;
        this.f5315b = aVar;
        this.f5316c = fVar;
    }

    @Override // com.facebook.crypto.d
    public OutputStream a(OutputStream outputStream, g gVar, byte[] bArr) {
        outputStream.write(1);
        outputStream.write(this.f5316c.f5323c);
        byte[] b2 = this.f5315b.b();
        NativeGCMCipher nativeGCMCipher = new NativeGCMCipher(this.f5314a);
        nativeGCMCipher.a(this.f5315b.a(), b2);
        outputStream.write(b2);
        a(nativeGCMCipher, (byte) 1, this.f5316c.f5323c, gVar.a());
        return new com.facebook.crypto.d.c(outputStream, nativeGCMCipher, bArr, this.f5316c.f);
    }

    @Override // com.facebook.crypto.d
    public InputStream a(InputStream inputStream, g gVar) {
        byte read = (byte) inputStream.read();
        byte read2 = (byte) inputStream.read();
        boolean z = read == 1;
        com.facebook.crypto.e.a.b(z, "Unexpected crypto version " + ((int) read));
        boolean z2 = read2 == this.f5316c.f5323c;
        com.facebook.crypto.e.a.b(z2, "Unexpected cipher ID " + ((int) read2));
        byte[] bArr = new byte[this.f5316c.f5325e];
        new DataInputStream(inputStream).readFully(bArr);
        NativeGCMCipher nativeGCMCipher = new NativeGCMCipher(this.f5314a);
        nativeGCMCipher.b(this.f5315b.a(), bArr);
        a(nativeGCMCipher, read, read2, gVar.a());
        return new com.facebook.crypto.d.b(inputStream, nativeGCMCipher, this.f5316c.f);
    }

    private void a(NativeGCMCipher nativeGCMCipher, byte b2, byte b3, byte[] bArr) {
        nativeGCMCipher.a(new byte[]{b2}, 1);
        nativeGCMCipher.a(new byte[]{b3}, 1);
        nativeGCMCipher.a(bArr, bArr.length);
    }

    @Override // com.facebook.crypto.d
    public int a() {
        return this.f5316c.f5325e + 2 + this.f5316c.f;
    }
}
