package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import com.google.android.gms.internal.ads.zzeik;
import com.google.android.gms.internal.ads.zzein;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzedp {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static zzein zzb(zzeik zzeikVar) {
        zzein.zzb zzfv = zzein.zzbfq().zzfv(zzeikVar.zzbfi());
        for (zzeik.zzb zzbVar : zzeikVar.zzbfj()) {
            zzfv.zzb((zzein.zza) ((zzena) zzein.zza.zzbfs().zzhw(zzbVar.zzbfn().zzbev()).zzb(zzbVar.zzbbr()).zzb(zzbVar.zzbbs()).zzfw(zzbVar.zzbfo()).zzbjv()));
        }
        return (zzein) ((zzena) zzfv.zzbjv());
    }

    public static void zzc(zzeik zzeikVar) {
        int zzbfi = zzeikVar.zzbfi();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzeik.zzb zzbVar : zzeikVar.zzbfj()) {
            if (zzbVar.zzbbr() == zzeid.ENABLED) {
                if (!zzbVar.zzbfm()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzbVar.zzbfo())));
                }
                if (zzbVar.zzbbs() == zzeiw.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzbVar.zzbfo())));
                }
                if (zzbVar.zzbbr() == zzeid.UNKNOWN_STATUS) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzbVar.zzbfo())));
                }
                if (zzbVar.zzbfo() == zzbfi) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                if (zzbVar.zzbfn().zzbex() != zzeic.zza.ASYMMETRIC_PUBLIC) {
                    z2 = false;
                }
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
