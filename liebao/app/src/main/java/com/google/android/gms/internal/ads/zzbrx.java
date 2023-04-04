package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbrx implements zzbsy, zzbtm, zzbxb, zzbza {
    private final Executor executor;
    private final zzbtl zzgah;
    private final zzdot zzgai;
    private final ScheduledExecutorService zzgaj;
    private zzecb<Boolean> zzgak = zzecb.zzbbf();
    private ScheduledFuture<?> zzgal;

    public zzbrx(zzbtl zzbtlVar, zzdot zzdotVar, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zzgah = zzbtlVar;
        this.zzgai = zzdotVar;
        this.zzgaj = scheduledExecutorService;
        this.executor = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzalz() {
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzama() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzb(zzavd zzavdVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdOpened() {
        if (this.zzgai.zzhmt == 0 || this.zzgai.zzhmt == 1) {
            this.zzgah.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzalx() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcrt)).booleanValue() && this.zzgai.zzhmt == 2) {
            if (this.zzgai.zzhmf == 0) {
                this.zzgah.onAdImpression();
                return;
            }
            zzebh.zza(this.zzgak, new zzbrz(this), this.executor);
            this.zzgal = this.zzgaj.schedule(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbrw
                private final zzbrx zzgag;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgag = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgag.zzamb();
                }
            }, this.zzgai.zzhmf, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final synchronized void zzk(zzvh zzvhVar) {
        if (this.zzgak.isDone()) {
            return;
        }
        if (this.zzgal != null) {
            this.zzgal.cancel(true);
        }
        this.zzgak.setException(new Exception());
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final synchronized void zzaly() {
        if (this.zzgak.isDone()) {
            return;
        }
        if (this.zzgal != null) {
            this.zzgal.cancel(true);
        }
        this.zzgak.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzamb() {
        synchronized (this) {
            if (this.zzgak.isDone()) {
                return;
            }
            this.zzgak.set(true);
        }
    }
}
