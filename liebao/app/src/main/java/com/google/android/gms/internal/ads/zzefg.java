package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzefg {
    public static void zza(zzehj zzehjVar) {
        zzejw.zza(zza(zzehjVar.zzbdu().zzbeh()));
        zza(zzehjVar.zzbdu().zzbei());
        if (zzehjVar.zzbdw() == zzehd.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzedl.zza(zzehjVar.zzbdv().zzbdp());
    }

    public static String zza(zzehs zzehsVar) {
        int i = zzefj.zzigw[zzehsVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return "HmacSha512";
                }
                String valueOf = String.valueOf(zzehsVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
                sb.append("hash unsupported for HMAC: ");
                sb.append(valueOf);
                throw new NoSuchAlgorithmException(sb.toString());
            }
            return "HmacSha256";
        }
        return "HmacSha1";
    }

    public static zzejy zza(zzehr zzehrVar) {
        int i = zzefj.zzigx[zzehrVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return zzejy.NIST_P521;
                }
                String valueOf = String.valueOf(zzehrVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("unknown curve type: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
            }
            return zzejy.NIST_P384;
        }
        return zzejy.NIST_P256;
    }

    public static zzekb zza(zzehd zzehdVar) {
        int i = zzefj.zzigy[zzehdVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return zzekb.COMPRESSED;
                }
                String valueOf = String.valueOf(zzehdVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("unknown point format: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
            }
            return zzekb.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        return zzekb.UNCOMPRESSED;
    }
}
