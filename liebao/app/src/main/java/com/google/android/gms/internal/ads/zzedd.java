package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import com.google.android.gms.internal.ads.zzeik;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public final class zzedd {
    @Deprecated
    public static final zzecz zzl(byte[] bArr) {
        try {
            zzeik zzc = zzeik.zzc(bArr, zzemn.zzbiv());
            for (zzeik.zzb zzbVar : zzc.zzbfj()) {
                if (zzbVar.zzbfn().zzbex() == zzeic.zza.UNKNOWN_KEYMATERIAL || zzbVar.zzbfn().zzbex() == zzeic.zza.SYMMETRIC || zzbVar.zzbfn().zzbex() == zzeic.zza.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return zzecz.zza(zzc);
        } catch (zzenn unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
