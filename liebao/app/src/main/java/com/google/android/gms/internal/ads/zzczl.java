package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzczl extends zzxh {
    private final zzdap zzhau;

    public zzczl(Context context, zzbhh zzbhhVar, zzdpo zzdpoVar, zzcdy zzcdyVar, zzxc zzxcVar) {
        zzdar zzdarVar = new zzdar(zzcdyVar, zzbhhVar.zzafu());
        zzdarVar.zzd(zzxcVar);
        this.zzhau = new zzdap(new zzdax(zzbhhVar, context, zzdarVar, zzdpoVar), zzdpoVar.zzawe());
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final synchronized boolean isLoading() {
        return this.zzhau.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzb(zzvq zzvqVar) {
        this.zzhau.zza(zzvqVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final synchronized void zza(zzvq zzvqVar, int i) {
        this.zzhau.zza(zzvqVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final synchronized String getMediationAdapterClassName() {
        return this.zzhau.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final synchronized String zzkl() {
        return this.zzhau.zzkl();
    }
}
