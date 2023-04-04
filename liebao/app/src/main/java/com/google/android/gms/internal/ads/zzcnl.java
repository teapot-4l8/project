package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcnl implements zzebi<String> {
    final /* synthetic */ zzcna zzgpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcnl(zzcna zzcnaVar) {
        this.zzgpu = zzcnaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        long j;
        zzbbe zzbbeVar;
        synchronized (this) {
            this.zzgpu.zzgpd = true;
            zzcna zzcnaVar = this.zzgpu;
            long elapsedRealtime = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime();
            j = this.zzgpu.zzgpe;
            zzcnaVar.zza("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (elapsedRealtime - j));
            zzbbeVar = this.zzgpu.zzgpf;
            zzbbeVar.setException(new Exception());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(@Nullable String str) {
        long j;
        Executor executor;
        String str2 = str;
        synchronized (this) {
            this.zzgpu.zzgpd = true;
            zzcna zzcnaVar = this.zzgpu;
            long elapsedRealtime = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime();
            j = this.zzgpu.zzgpe;
            zzcnaVar.zza("com.google.android.gms.ads.MobileAds", true, "", (int) (elapsedRealtime - j));
            executor = this.zzgpu.executor;
            executor.execute(new Runnable(this, str2) { // from class: com.google.android.gms.internal.ads.zzcnk
                private final String zzdkl;
                private final zzcnl zzgpt;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgpt = this;
                    this.zzdkl = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzcnl zzcnlVar = this.zzgpt;
                    zzcnlVar.zzgpu.zzgi(this.zzdkl);
                }
            });
        }
    }
}
