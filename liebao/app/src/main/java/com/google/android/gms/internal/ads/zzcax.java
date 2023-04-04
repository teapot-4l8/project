package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcax implements zzesa<Set<zzbzl<zzbsy>>> {
    private final zzesn<zzbrx> zzfvz;
    private final zzcak zzgdr;

    private zzcax(zzcak zzcakVar, zzesn<zzbrx> zzesnVar) {
        this.zzgdr = zzcakVar;
        this.zzfvz = zzesnVar;
    }

    public static zzcax zze(zzcak zzcakVar, zzesn<zzbrx> zzesnVar) {
        return new zzcax(zzcakVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdr.zzb(this.zzfvz.get()));
    }
}
