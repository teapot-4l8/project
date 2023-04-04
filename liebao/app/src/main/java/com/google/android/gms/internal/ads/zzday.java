package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzday implements zzebi<zzbpc> {
    private final /* synthetic */ zzdav zzhcc;
    private final /* synthetic */ zzccf zzhcd;
    final /* synthetic */ zzdax zzhce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzday(zzdax zzdaxVar, zzdav zzdavVar, zzccf zzccfVar) {
        this.zzhce = zzdaxVar;
        this.zzhcc = zzdavVar;
        this.zzhcd = zzccfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        zzbhh zzbhhVar;
        zzvh zze = this.zzhcd.zzahd().zze(th);
        this.zzhcd.zzahe().zzd(zze);
        zzbhhVar = this.zzhce.zzgxu;
        zzbhhVar.zzafv().execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzdba
            private final zzday zzhcf;
            private final zzvh zzhcg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhcf = this;
                this.zzhcg = zze;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzdar zzdarVar;
                zzday zzdayVar = this.zzhcf;
                zzvh zzvhVar = this.zzhcg;
                zzdarVar = zzdayVar.zzhce.zzhca;
                zzdarVar.zzatn().zzd(zzvhVar);
            }
        });
        zzdqa.zza(zze.errorCode, th, "NativeAdLoader.onFailure");
        this.zzhcc.zzatg();
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(zzbpc zzbpcVar) {
        zzdar zzdarVar;
        zzbhh zzbhhVar;
        zzbpc zzbpcVar2 = zzbpcVar;
        synchronized (this.zzhce) {
            zzbwp zzaln = zzbpcVar2.zzaln();
            zzdarVar = this.zzhce.zzhca;
            zzaln.zza(zzdarVar.zzatl());
            this.zzhcc.onSuccess(zzbpcVar2);
            zzbhhVar = this.zzhce.zzgxu;
            zzbhhVar.zzafv().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdbb
                private final zzday zzhcf;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhcf = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzdar zzdarVar2;
                    zzdarVar2 = this.zzhcf.zzhce.zzhca;
                    zzdarVar2.zzatm().onAdLoaded();
                }
            });
        }
    }
}
