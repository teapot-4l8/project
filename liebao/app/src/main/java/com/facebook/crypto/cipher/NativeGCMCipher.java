package com.facebook.crypto.cipher;

import com.facebook.crypto.e.b;

/* loaded from: classes.dex */
public class NativeGCMCipher {

    /* renamed from: a  reason: collision with root package name */
    private a f5294a = a.UNINITIALIZED;

    /* renamed from: b  reason: collision with root package name */
    private final b f5295b;
    private long mCtxPtr;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum a {
        UNINITIALIZED,
        ENCRYPT_INITIALIZED,
        DECRYPT_INITIALIZED,
        ENCRYPT_FINALIZED,
        DECRYPT_FINALIZED
    }

    private native int nativeDecryptFinal(byte[] bArr, int i);

    private native int nativeDecryptInit(byte[] bArr, byte[] bArr2);

    private native int nativeDestroy();

    private native int nativeEncryptFinal(byte[] bArr, int i);

    private native int nativeEncryptInit(byte[] bArr, byte[] bArr2);

    private static native int nativeFailure();

    private native int nativeGetCipherBlockSize();

    private native int nativeUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    private native int nativeUpdateAad(byte[] bArr, int i);

    public NativeGCMCipher(b bVar) {
        this.f5295b = bVar;
    }

    public void a(byte[] bArr, byte[] bArr2) {
        com.facebook.crypto.e.a.a(this.f5294a == a.UNINITIALIZED, "Cipher has already been initialized");
        this.f5295b.a();
        if (nativeEncryptInit(bArr, bArr2) == nativeFailure()) {
            throw new com.facebook.crypto.cipher.a("encryptInit");
        }
        this.f5294a = a.ENCRYPT_INITIALIZED;
    }

    public void b(byte[] bArr, byte[] bArr2) {
        com.facebook.crypto.e.a.a(this.f5294a == a.UNINITIALIZED, "Cipher has already been initialized");
        this.f5295b.a();
        if (nativeDecryptInit(bArr, bArr2) == nativeFailure()) {
            throw new com.facebook.crypto.cipher.a("decryptInit");
        }
        this.f5294a = a.DECRYPT_INITIALIZED;
    }

    public int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        c();
        int nativeUpdate = nativeUpdate(bArr, i, i2, bArr2, i3);
        if (nativeUpdate >= 0) {
            return nativeUpdate;
        }
        throw new com.facebook.crypto.cipher.a(a("update: Offset = %d; DataLen = %d; Result = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(nativeUpdate)));
    }

    public void a(byte[] bArr, int i) {
        c();
        if (nativeUpdateAad(bArr, i) < 0) {
            throw new com.facebook.crypto.cipher.a(a("updateAAd: DataLen = %d", Integer.valueOf(i)));
        }
    }

    public void b(byte[] bArr, int i) {
        com.facebook.crypto.e.a.a(this.f5294a == a.ENCRYPT_INITIALIZED, "Cipher has not been initialized");
        this.f5294a = a.ENCRYPT_FINALIZED;
        if (nativeEncryptFinal(bArr, i) == nativeFailure()) {
            throw new com.facebook.crypto.cipher.a(a("encryptFinal: %d", Integer.valueOf(i)));
        }
    }

    public void c(byte[] bArr, int i) {
        com.facebook.crypto.e.a.a(this.f5294a == a.DECRYPT_INITIALIZED, "Cipher has not been initialized");
        this.f5294a = a.DECRYPT_FINALIZED;
        if (nativeDecryptFinal(bArr, i) == nativeFailure()) {
            throw new com.facebook.crypto.cipher.a("The message could not be decrypted successfully.It has either been tampered with or the wrong resource is being decrypted.");
        }
    }

    public void a() {
        d();
        if (nativeDestroy() == nativeFailure()) {
            throw new com.facebook.crypto.cipher.a("destroy");
        }
        this.f5294a = a.UNINITIALIZED;
    }

    public int b() {
        c();
        return nativeGetCipherBlockSize();
    }

    private void c() {
        com.facebook.crypto.e.a.a(this.f5294a == a.DECRYPT_INITIALIZED || this.f5294a == a.ENCRYPT_INITIALIZED, "Cipher has not been initialized");
    }

    private void d() {
        com.facebook.crypto.e.a.a(this.f5294a == a.DECRYPT_FINALIZED || this.f5294a == a.ENCRYPT_FINALIZED, "Cipher has not been finalized");
    }

    private String a(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }
}
