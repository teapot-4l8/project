package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbrr implements zzbvm {
    private final Context zzaai;
    private final zzbar zzbpj;
    private final com.google.android.gms.ads.internal.util.zzf zzecl;
    private final zzcna zzfsu;
    private final zzdpm zzfzg;

    public zzbrr(Context context, zzdpm zzdpmVar, zzbar zzbarVar, com.google.android.gms.ads.internal.util.zzf zzfVar, zzcna zzcnaVar) {
        this.zzaai = context;
        this.zzfzg = zzdpmVar;
        this.zzbpj = zzbarVar;
        this.zzecl = zzfVar;
        this.zzfsu = zzcnaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzdpi zzdpiVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzauj zzaujVar) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcul)).booleanValue()) {
            com.google.android.gms.ads.internal.zzr.zzld().zza(this.zzaai, this.zzbpj, this.zzfzg.zzhny, this.zzecl.zzzg());
        }
        this.zzfsu.zzarv();
    }
}
