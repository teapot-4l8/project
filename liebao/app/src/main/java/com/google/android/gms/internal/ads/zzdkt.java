package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdkt extends zzxp implements com.google.android.gms.ads.internal.overlay.zzp, zzsi {
    private final String zzbvf;
    private final zzbhh zzgxu;
    private final Context zzham;
    private final zzdkd zzhia;
    private zzblz zzhic;
    private final zzdkr zzhjb;
    protected zzbmz zzhjd;
    private AtomicBoolean zzhhy = new AtomicBoolean();
    private long zzhjc = -1;

    public zzdkt(zzbhh zzbhhVar, Context context, String str, zzdkr zzdkrVar, zzdkd zzdkdVar) {
        this.zzgxu = zzbhhVar;
        this.zzham = context;
        this.zzbvf = str;
        this.zzhjb = zzdkrVar;
        this.zzhia = zzdkdVar;
        zzdkdVar.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzasr zzasrVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzasx zzasxVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzavn zzavnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzvq zzvqVar, zzxd zzxdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzwx zzwxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxc zzxcVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxt zzxtVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxy zzxyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzyg zzygVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzyx zzyxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzzj zzzjVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zzbl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zze(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final IObjectWrapper zzki() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxy zzkn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxc zzko() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzwc zzwcVar) {
        this.zzhjb.zza(zzwcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized boolean zza(zzvq zzvqVar) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        com.google.android.gms.ads.internal.zzr.zzkv();
        if (com.google.android.gms.ads.internal.util.zzj.zzbc(this.zzham) && zzvqVar.zzcip == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Failed to load the ad because app ID is missing.");
            this.zzhia.zzd(zzdqh.zza(zzdqj.APP_ID_MISSING, null, null));
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            this.zzhhy = new AtomicBoolean();
            return this.zzhjb.zza(zzvqVar, this.zzbvf, new zzdky(this), new zzdkx(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzbmz zzbmzVar) {
        zzbmzVar.zza(this);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zza(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        int i = zzdla.zzhjg[zzlVar.ordinal()];
        if (i == 1) {
            zzej(zzbmf.zzfwc);
        } else if (i == 2) {
            zzej(zzbmf.zzfwb);
        } else if (i == 3) {
            zzej(zzbmf.zzfwd);
        } else if (i != 4) {
        } else {
            zzej(zzbmf.zzfwf);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onUserLeaveHint() {
        if (this.zzhjd != null) {
            this.zzhjd.zzb(com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - this.zzhjc, zzbmf.zzfwa);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsi
    public final void zzmz() {
        zzej(zzbmf.zzfwc);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void zzvz() {
        if (this.zzhjd == null) {
            return;
        }
        this.zzhjc = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime();
        int zzakb = this.zzhjd.zzakb();
        if (zzakb <= 0) {
            return;
        }
        zzblz zzblzVar = new zzblz(this.zzgxu.zzafw(), com.google.android.gms.ads.internal.zzr.zzlc());
        this.zzhic = zzblzVar;
        zzblzVar.zza(zzakb, new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdkv
            private final zzdkt zzhje;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhje = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhje.zzavf();
            }
        });
    }

    private final synchronized void zzej(int i) {
        if (this.zzhhy.compareAndSet(false, true)) {
            this.zzhia.onAdClosed();
            if (this.zzhic != null) {
                com.google.android.gms.ads.internal.zzr.zzky().zzb(this.zzhic);
            }
            if (this.zzhjd != null) {
                long j = -1;
                if (this.zzhjc != -1) {
                    j = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - this.zzhjc;
                }
                this.zzhjd.zzb(j, i);
            }
            destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzhjd != null) {
            this.zzhjd.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzsq zzsqVar) {
        this.zzhia.zzb(zzsqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void zza(zzvt zzvtVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized boolean isLoading() {
        return this.zzhjb.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized String getAdUnitId() {
        return this.zzbvf;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized zzzc zzkm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized zzvt zzkk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void showInterstitial() {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized String getMediationAdapterClassName() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized String zzkl() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void zzkj() {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void zza(zzye zzyeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void setManualImpressionsEnabled(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized zzzd getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void zza(zzaaz zzaazVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void zza(zzacm zzacmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final Bundle getAdMetadata() {
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzavf() {
        this.zzgxu.zzafv().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdkw
            private final zzdkt zzhje;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhje = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhje.zzavg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzavg() {
        zzej(zzbmf.zzfwe);
    }
}
