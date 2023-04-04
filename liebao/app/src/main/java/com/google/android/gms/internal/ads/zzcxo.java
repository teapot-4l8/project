package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcxo implements zzbzy {
    private final /* synthetic */ zzdot zzgyd;
    private final /* synthetic */ zzdpi zzgyq;
    private final /* synthetic */ zzctb zzgyr;
    final /* synthetic */ zzcxm zzgys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcxo(zzcxm zzcxmVar, zzdpi zzdpiVar, zzdot zzdotVar, zzctb zzctbVar) {
        this.zzgys = zzcxmVar;
        this.zzgyq = zzdpiVar;
        this.zzgyd = zzdotVar;
        this.zzgyr = zzctbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzy
    public final void onInitializationSucceeded() {
        Executor executor;
        executor = this.zzgys.zzfur;
        executor.execute(new Runnable(this, this.zzgyq, this.zzgyd, this.zzgyr) { // from class: com.google.android.gms.internal.ads.zzcxr
            private final zzdot zzfxi;
            private final zzdpi zzgjy;
            private final zzcxo zzgyx;
            private final zzctb zzgyy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgyx = this;
                this.zzgjy = r2;
                this.zzfxi = r3;
                this.zzgyy = r4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzcxo zzcxoVar = this.zzgyx;
                zzdpi zzdpiVar = this.zzgjy;
                zzdot zzdotVar = this.zzfxi;
                zzctb zzctbVar = this.zzgyy;
                zzcxm zzcxmVar = zzcxoVar.zzgys;
                zzcxm.zzc(zzdpiVar, zzdotVar, zzctbVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbzy
    public final void zzeg(int i) {
        String valueOf = String.valueOf(this.zzgyr.zzcja);
        com.google.android.gms.ads.internal.util.zzd.zzez(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "));
    }
}
