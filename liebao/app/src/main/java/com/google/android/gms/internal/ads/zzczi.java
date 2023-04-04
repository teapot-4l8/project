package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzczi extends zzxm {
    private zzxc zzbqc;
    private final zzbhh zzgxu;
    private final Context zzham;
    private final zzdpo zzhan = new zzdpo();
    private final zzcea zzhao = new zzcea();

    public zzczi(zzbhh zzbhhVar, Context context, String str) {
        this.zzgxu = zzbhhVar;
        this.zzhan.zzgt(str);
        this.zzham = context;
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final zzxi zzrf() {
        zzcdy zzapk = this.zzhao.zzapk();
        this.zzhan.zzc(zzapk.zzapi());
        this.zzhan.zzd(zzapk.zzapj());
        zzdpo zzdpoVar = this.zzhan;
        if (zzdpoVar.zzkk() == null) {
            zzdpoVar.zzg(zzvt.zzqk());
        }
        return new zzczl(this.zzham, this.zzgxu, this.zzhan, zzapk, this.zzbqc);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zzb(zzxc zzxcVar) {
        this.zzbqc = zzxcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(zzafs zzafsVar) {
        this.zzhao.zzb(zzafsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(zzagl zzaglVar) {
        this.zzhao.zzb(zzaglVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(zzafx zzafxVar) {
        this.zzhao.zzb(zzafxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(String str, zzagd zzagdVar, zzafy zzafyVar) {
        this.zzhao.zzb(str, zzagdVar, zzafyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(zzaei zzaeiVar) {
        this.zzhan.zzd(zzaeiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(zzajy zzajyVar) {
        this.zzhan.zzb(zzajyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(zzakg zzakgVar) {
        this.zzhao.zzb(zzakgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zzb(zzye zzyeVar) {
        this.zzhan.zzc(zzyeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(zzagg zzaggVar, zzvt zzvtVar) {
        this.zzhao.zza(zzaggVar);
        this.zzhan.zzg(zzvtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzhan.zzb(publisherAdViewOptions);
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void zza(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzhan.zzb(adManagerAdViewOptions);
    }
}
