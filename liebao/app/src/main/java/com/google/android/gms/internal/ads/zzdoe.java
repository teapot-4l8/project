package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdoe implements zzebi<zzcip> {
    private final /* synthetic */ zzdav zzhcc;
    private final /* synthetic */ zzdof zzhln;
    final /* synthetic */ zzdnz zzhlo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdoe(zzdnz zzdnzVar, zzdav zzdavVar, zzdof zzdofVar) {
        this.zzhlo = zzdnzVar;
        this.zzhcc = zzdavVar;
        this.zzhln = zzdofVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        zzdmh zzdmhVar;
        final zzvh zze;
        zzdnb zzdnbVar;
        zzciv zze2;
        Executor executor;
        zzdmhVar = this.zzhlo.zzhim;
        zzcis zzcisVar = (zzcis) zzdmhVar.zzavm();
        if (zzcisVar == null) {
            zze = zzdqh.zza(th, (zzctc) null);
        } else {
            zze = zzcisVar.zzahd().zze(th);
        }
        synchronized (this.zzhlo) {
            if (zzcisVar != null) {
                zzcisVar.zzahe().zzd(zze);
                executor = this.zzhlo.zzfur;
                executor.execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzdog
                    private final zzvh zzhcg;
                    private final zzdoe zzhlp;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhlp = this;
                        this.zzhcg = zze;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdnb zzdnbVar2;
                        zzdoe zzdoeVar = this.zzhlp;
                        zzvh zzvhVar = this.zzhcg;
                        zzdnbVar2 = zzdoeVar.zzhlo.zzhlj;
                        zzdnbVar2.zzd(zzvhVar);
                    }
                });
            } else {
                zzdnbVar = this.zzhlo.zzhlj;
                zzdnbVar.zzd(zze);
                zze2 = this.zzhlo.zze(this.zzhln);
                zze2.zzaix().zzahd().zzalw().zzamr();
            }
            zzdqa.zza(zze.errorCode, th, "RewardedAdLoader.onFailure");
            this.zzhcc.zzatg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(zzcip zzcipVar) {
        zzdnb zzdnbVar;
        Executor executor;
        zzdnb zzdnbVar2;
        zzdnb zzdnbVar3;
        zzcip zzcipVar2 = zzcipVar;
        synchronized (this.zzhlo) {
            zzbwp zzaln = zzcipVar2.zzaln();
            zzdnbVar = this.zzhlo.zzhlj;
            zzaln.zza(zzdnbVar);
            this.zzhcc.onSuccess(zzcipVar2);
            executor = this.zzhlo.zzfur;
            zzdnbVar2 = this.zzhlo.zzhlj;
            zzdnbVar2.getClass();
            executor.execute(zzdod.zzb(zzdnbVar2));
            zzdnbVar3 = this.zzhlo.zzhlj;
            zzdnbVar3.onAdMetadataChanged();
        }
    }
}
