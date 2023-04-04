package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeju {
    private ECPublicKey zzims;

    public zzeju(ECPublicKey eCPublicKey) {
        this.zzims = eCPublicKey;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzejx zza(String str, byte[] bArr, byte[] bArr2, int i, zzekb zzekbVar) {
        byte[] bArr3;
        byte[] bArr4;
        Mac zzhx;
        KeyPair zza = zzejw.zza(this.zzims.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) zza.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) zza.getPrivate();
        ECPublicKey eCPublicKey2 = this.zzims;
        try {
            ECParameterSpec params = eCPublicKey2.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            int i2 = 1;
            if (!(params.getCurve().equals(params2.getCurve()) && params.getGenerator().equals(params2.getGenerator()) && params.getOrder().equals(params2.getOrder()) && params.getCofactor() == params2.getCofactor())) {
                throw new GeneralSecurityException("invalid public key spec");
            }
            byte[] zza2 = zzejw.zza(eCPrivateKey, eCPublicKey2.getW());
            EllipticCurve curve = eCPublicKey.getParams().getCurve();
            ECPoint w = eCPublicKey.getW();
            zzejw.zza(w, curve);
            int bitLength = (zzejw.zza(curve).subtract(BigInteger.ONE).bitLength() + 7) / 8;
            int i3 = zzejz.zzimz[zzekbVar.ordinal()];
            if (i3 == 1) {
                int i4 = (bitLength * 2) + 1;
                bArr3 = new byte[i4];
                byte[] byteArray = w.getAffineX().toByteArray();
                byte[] byteArray2 = w.getAffineY().toByteArray();
                System.arraycopy(byteArray2, 0, bArr3, i4 - byteArray2.length, byteArray2.length);
                System.arraycopy(byteArray, 0, bArr3, (bitLength + 1) - byteArray.length, byteArray.length);
                bArr3[0] = 4;
            } else if (i3 != 2) {
                if (i3 == 3) {
                    int i5 = bitLength + 1;
                    bArr4 = new byte[i5];
                    byte[] byteArray3 = w.getAffineX().toByteArray();
                    System.arraycopy(byteArray3, 0, bArr4, i5 - byteArray3.length, byteArray3.length);
                    bArr4[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
                    byte[] zza3 = zzejn.zza(bArr4, zza2);
                    zzhx = zzekd.zzink.zzhx(str);
                    if (i <= zzhx.getMacLength() * 255) {
                        throw new GeneralSecurityException("size too large");
                    }
                    if (bArr == null || bArr.length == 0) {
                        zzhx.init(new SecretKeySpec(new byte[zzhx.getMacLength()], str));
                    } else {
                        zzhx.init(new SecretKeySpec(bArr, str));
                    }
                    byte[] doFinal = zzhx.doFinal(zza3);
                    byte[] bArr5 = new byte[i];
                    zzhx.init(new SecretKeySpec(doFinal, str));
                    byte[] bArr6 = new byte[0];
                    int i6 = 0;
                    while (true) {
                        zzhx.update(bArr6);
                        zzhx.update(bArr2);
                        zzhx.update((byte) i2);
                        bArr6 = zzhx.doFinal();
                        if (bArr6.length + i6 < i) {
                            System.arraycopy(bArr6, 0, bArr5, i6, bArr6.length);
                            i6 += bArr6.length;
                            i2++;
                        } else {
                            System.arraycopy(bArr6, 0, bArr5, i6, i - i6);
                            return new zzejx(bArr4, bArr5);
                        }
                    }
                } else {
                    String valueOf = String.valueOf(zzekbVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
                    sb.append("invalid format:");
                    sb.append(valueOf);
                    throw new GeneralSecurityException(sb.toString());
                }
            } else {
                int i7 = bitLength * 2;
                bArr3 = new byte[i7];
                byte[] byteArray4 = w.getAffineX().toByteArray();
                if (byteArray4.length > bitLength) {
                    byteArray4 = Arrays.copyOfRange(byteArray4, byteArray4.length - bitLength, byteArray4.length);
                }
                byte[] byteArray5 = w.getAffineY().toByteArray();
                if (byteArray5.length > bitLength) {
                    byteArray5 = Arrays.copyOfRange(byteArray5, byteArray5.length - bitLength, byteArray5.length);
                }
                System.arraycopy(byteArray5, 0, bArr3, i7 - byteArray5.length, byteArray5.length);
                System.arraycopy(byteArray4, 0, bArr3, bitLength - byteArray4.length, byteArray4.length);
            }
            bArr4 = bArr3;
            byte[] zza32 = zzejn.zza(bArr4, zza2);
            zzhx = zzekd.zzink.zzhx(str);
            if (i <= zzhx.getMacLength() * 255) {
            }
        } catch (IllegalArgumentException | NullPointerException e2) {
            throw new GeneralSecurityException(e2.toString());
        }
    }
}
