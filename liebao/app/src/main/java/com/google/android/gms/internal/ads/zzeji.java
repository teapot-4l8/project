package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeji implements zzecn {
    private static final ThreadLocal<Cipher> zzigk = new zzejl();
    private final SecretKey zzigl;

    public zzeji(byte[] bArr) {
        zzeku.zzgc(bArr.length);
        this.zzigl = new SecretKeySpec(bArr, "AES");
    }

    @Override // com.google.android.gms.internal.ads.zzecn
    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        AlgorithmParameterSpec gCMParameterSpec;
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + 12 + 16];
        byte[] zzgb = zzekt.zzgb(12);
        System.arraycopy(zzgb, 0, bArr3, 0, 12);
        int length = zzgb.length;
        if (zzekv.zzbgu() && zzekv.zzbgv() <= 19) {
            gCMParameterSpec = new IvParameterSpec(zzgb, 0, length);
        } else {
            gCMParameterSpec = new GCMParameterSpec(128, zzgb, 0, length);
        }
        zzigk.get().init(1, this.zzigl, gCMParameterSpec);
        if (bArr2 != null && bArr2.length != 0) {
            zzigk.get().updateAAD(bArr2);
        }
        int doFinal = zzigk.get().doFinal(bArr, 0, bArr.length, bArr3, 12);
        if (doFinal == bArr.length + 16) {
            return bArr3;
        }
        throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(doFinal - bArr.length)));
    }
}
