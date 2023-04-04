package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcll implements zzdtm {
    private zztz zzgnj;
    private Map<zzdth, zzcln> zzgnr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcll(zztz zztzVar, Map<zzdth, zzcln> map) {
        this.zzgnr = map;
        this.zzgnj = zztzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zza(zzdth zzdthVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zzb(zzdth zzdthVar, String str) {
        if (this.zzgnr.containsKey(zzdthVar)) {
            this.zzgnj.zza(this.zzgnr.get(zzdthVar).zzgnt);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zza(zzdth zzdthVar, String str, Throwable th) {
        if (this.zzgnr.containsKey(zzdthVar)) {
            this.zzgnj.zza(this.zzgnr.get(zzdthVar).zzgnv);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zzc(zzdth zzdthVar, String str) {
        if (this.zzgnr.containsKey(zzdthVar)) {
            this.zzgnj.zza(this.zzgnr.get(zzdthVar).zzgnu);
        }
    }
}
