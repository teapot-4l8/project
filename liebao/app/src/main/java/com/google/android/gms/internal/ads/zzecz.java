package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeik;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzecz {
    private final zzeik zziep;

    private zzecz(zzeik zzeikVar) {
        this.zziep = zzeikVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzecz zza(zzeik zzeikVar) {
        if (zzeikVar == null || zzeikVar.zzbfk() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return new zzecz(zzeikVar);
    }

    public final String toString() {
        return zzedp.zzb(this.zziep).toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <P> P zza(Class<P> cls) {
        Class<?> zzd = zzedl.zzd(cls);
        if (zzd == null) {
            String valueOf = String.valueOf(cls.getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
        }
        zzedp.zzc(this.zziep);
        zzedc zzb = zzedc.zzb(zzd);
        for (zzeik.zzb zzbVar : this.zziep.zzbfj()) {
            if (zzbVar.zzbbr() == zzeid.ENABLED) {
                zzede zza = zzb.zza(zzedl.zza(zzbVar.zzbfn(), zzd), zzbVar);
                if (zzbVar.zzbfo() == this.zziep.zzbfi()) {
                    zzb.zza(zza);
                }
            }
        }
        return (P) zzedl.zza(zzb, cls);
    }
}
