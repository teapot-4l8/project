package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdmt implements zzebi<zzcaj> {
    private final /* synthetic */ zzdav zzhcc;
    private final /* synthetic */ zzcbj zzhkw;
    final /* synthetic */ zzdmr zzhkx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdmt(zzdmr zzdmrVar, zzdav zzdavVar, zzcbj zzcbjVar) {
        this.zzhkx = zzdmrVar;
        this.zzhcc = zzdavVar;
        this.zzhkw = zzcbjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        Executor executor;
        Executor executor2;
        zzvh zze = this.zzhkw.zzahd().zze(th);
        synchronized (this.zzhkx) {
            this.zzhkx.zzhjl = null;
            this.zzhkw.zzahe().zzd(zze);
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdau)).booleanValue()) {
                executor = this.zzhkx.zzfur;
                executor.execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzdmy
                    private final zzvh zzhcg;
                    private final zzdmt zzhkz;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhkz = this;
                        this.zzhcg = zze;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzczm zzczmVar;
                        zzdmt zzdmtVar = this.zzhkz;
                        zzvh zzvhVar = this.zzhcg;
                        zzczmVar = zzdmtVar.zzhkx.zzhas;
                        zzczmVar.zzd(zzvhVar);
                    }
                });
                executor2 = this.zzhkx.zzfur;
                executor2.execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzdmx
                    private final zzvh zzhcg;
                    private final zzdmt zzhkz;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhkz = this;
                        this.zzhcg = zze;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdnb zzdnbVar;
                        zzdmt zzdmtVar = this.zzhkz;
                        zzvh zzvhVar = this.zzhcg;
                        zzdnbVar = zzdmtVar.zzhkx.zzhkv;
                        zzdnbVar.zzd(zzvhVar);
                    }
                });
            }
            zzdqa.zza(zze.errorCode, th, "InterstitialAdLoader.onFailure");
            this.zzhcc.zzatg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(zzcaj zzcajVar) {
        Executor executor;
        Executor executor2;
        zzczm zzczmVar;
        zzdnb zzdnbVar;
        zzcaj zzcajVar2 = zzcajVar;
        synchronized (this.zzhkx) {
            this.zzhkx.zzhjl = null;
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdau)).booleanValue()) {
                zzbwp zzaln = zzcajVar2.zzaln();
                zzczmVar = this.zzhkx.zzhas;
                zzbwp zza = zzaln.zza(zzczmVar);
                zzdnbVar = this.zzhkx.zzhkv;
                zza.zza(zzdnbVar);
            }
            this.zzhcc.onSuccess(zzcajVar2);
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdau)).booleanValue()) {
                executor = this.zzhkx.zzfur;
                executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdmw
                    private final zzdmt zzhkz;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhkz = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzczm zzczmVar2;
                        zzczmVar2 = this.zzhkz.zzhkx.zzhas;
                        zzczmVar2.onAdLoaded();
                    }
                });
                executor2 = this.zzhkx.zzfur;
                executor2.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdmv
                    private final zzdmt zzhkz;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhkz = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdnb zzdnbVar2;
                        zzdnbVar2 = this.zzhkz.zzhkx.zzhkv;
                        zzdnbVar2.onAdLoaded();
                    }
                });
            }
        }
    }
}
