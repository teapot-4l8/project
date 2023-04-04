package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzejh implements zzecn {
    private static final ThreadLocal<Cipher> zzimb = new zzejg();
    private static final ThreadLocal<Cipher> zzimc = new zzejj();
    private final SecretKeySpec zzily;
    private final byte[] zzimd;
    private final byte[] zzime;
    private final int zzimf;

    public zzejh(byte[] bArr, int i) {
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zzimf = i;
        zzeku.zzgc(bArr.length);
        this.zzily = new SecretKeySpec(bArr, "AES");
        Cipher cipher = zzimb.get();
        cipher.init(1, this.zzily);
        byte[] zzo = zzo(cipher.doFinal(new byte[16]));
        this.zzimd = zzo;
        this.zzime = zzo(zzo);
    }

    private static byte[] zzd(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static byte[] zzo(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            int i2 = i + 1;
            bArr2[i] = (byte) ((bArr[i] << 1) ^ ((bArr[i2] & 255) >>> 7));
            i = i2;
        }
        bArr2[15] = (byte) ((bArr[15] << 1) ^ ((bArr[0] & 128) != 0 ? 135 : 0));
        return bArr2;
    }

    private final byte[] zza(Cipher cipher, int i, byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(zzd(bArr3, this.zzimd));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                doFinal[i5] = (byte) (doFinal[i5] ^ bArr[(i2 + i4) + i5]);
            }
            doFinal = cipher.doFinal(doFinal);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = zzd(copyOfRange, this.zzimd);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzime, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zzd(doFinal, bArr2));
    }

    @Override // com.google.android.gms.internal.ads.zzecn
    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.zzimf;
        if (length > (Integer.MAX_VALUE - i) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + i + 16];
        byte[] zzgb = zzekt.zzgb(i);
        System.arraycopy(zzgb, 0, bArr3, 0, this.zzimf);
        Cipher cipher = zzimb.get();
        cipher.init(1, this.zzily);
        byte[] zza = zza(cipher, 0, zzgb, 0, zzgb.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] zza2 = zza(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = zzimc.get();
        cipher2.init(1, this.zzily, new IvParameterSpec(zza));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.zzimf);
        byte[] zza3 = zza(cipher, 2, bArr3, this.zzimf, bArr.length);
        int length2 = bArr.length + this.zzimf;
        for (int i2 = 0; i2 < 16; i2++) {
            bArr3[length2 + i2] = (byte) ((zza2[i2] ^ zza[i2]) ^ zza3[i2]);
        }
        return bArr3;
    }
}
