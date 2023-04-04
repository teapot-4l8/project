package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcsy<DelegateT, AdapterT> implements zzcsz<AdapterT> {
    private final zzcsz<DelegateT> zzgvi;
    private final zzdxw<DelegateT, AdapterT> zzgvj;

    public zzcsy(zzcsz<DelegateT> zzcszVar, zzdxw<DelegateT, AdapterT> zzdxwVar) {
        this.zzgvi = zzcszVar;
        this.zzgvj = zzdxwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final boolean zza(zzdpi zzdpiVar, zzdot zzdotVar) {
        return this.zzgvi.zza(zzdpiVar, zzdotVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final zzebt<AdapterT> zzb(zzdpi zzdpiVar, zzdot zzdotVar) {
        return zzebh.zzb(this.zzgvi.zzb(zzdpiVar, zzdotVar), this.zzgvj, zzbat.zzeke);
    }
}
