package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdkc implements zzebi<AppOpenAd> {
    private final /* synthetic */ zzdav zzhcc;
    private final /* synthetic */ zzdke zzhiq;
    final /* synthetic */ zzdjx zzhir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdkc(zzdjx zzdjxVar, zzdav zzdavVar, zzdke zzdkeVar) {
        this.zzhir = zzdjxVar;
        this.zzhcc = zzdavVar;
        this.zzhiq = zzdkeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        zzdmh zzdmhVar;
        final zzvh zze;
        zzdkd zzdkdVar;
        zzbsg zzb;
        Executor executor;
        zzdmhVar = this.zzhir.zzhim;
        zzbmm zzbmmVar = (zzbmm) zzdmhVar.zzavm();
        if (zzbmmVar == null) {
            zze = zzdqh.zza(th, (zzctc) null);
        } else {
            zze = zzbmmVar.zzahd().zze(th);
        }
        synchronized (this.zzhir) {
            this.zzhir.zzhin = null;
            if (zzbmmVar != null) {
                zzbmmVar.zzahe().zzd(zze);
                if (((Boolean) zzww.zzra().zzd(zzabq.zzdat)).booleanValue()) {
                    executor = this.zzhir.zzfur;
                    executor.execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzdkb
                        private final zzvh zzhcg;
                        private final zzdkc zzhip;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzhip = this;
                            this.zzhcg = zze;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdkd zzdkdVar2;
                            zzdkc zzdkcVar = this.zzhip;
                            zzvh zzvhVar = this.zzhcg;
                            zzdkdVar2 = zzdkcVar.zzhir.zzhil;
                            zzdkdVar2.zzd(zzvhVar);
                        }
                    });
                }
            } else {
                zzdkdVar = this.zzhir.zzhil;
                zzdkdVar.zzd(zze);
                zzb = this.zzhir.zzb(this.zzhiq);
                ((zzbmm) zzb.zzahg()).zzahd().zzalw().zzamr();
            }
            zzdqa.zza(zze.errorCode, th, "AppOpenAdLoader.onFailure");
            this.zzhcc.zzatg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(Object obj) {
        zzdkd zzdkdVar;
        zzbpc zzbpcVar = (zzbpc) obj;
        synchronized (this.zzhir) {
            this.zzhir.zzhin = null;
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdat)).booleanValue()) {
                zzbwp zzaln = zzbpcVar.zzaln();
                zzdkdVar = this.zzhir.zzhil;
                zzaln.zza(zzdkdVar);
            }
            this.zzhcc.onSuccess(zzbpcVar);
        }
    }
}
