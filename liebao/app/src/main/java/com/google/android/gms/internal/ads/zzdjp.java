package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdjp extends zzxp implements com.google.android.gms.ads.internal.overlay.zzab, zzbus, zzsi {
    private final zzbar zzbpj;
    private final String zzbvf;
    private final ViewGroup zzfwu;
    private final zzbhh zzgxu;
    private final Context zzham;
    private final zzdjn zzhhz;
    private final zzdkd zzhia;
    private zzblz zzhic;
    protected zzbmp zzhid;
    private AtomicBoolean zzhhy = new AtomicBoolean();
    private long zzhib = -1;

    public zzdjp(zzbhh zzbhhVar, Context context, String str, zzdjn zzdjnVar, zzdkd zzdkdVar, zzbar zzbarVar) {
        this.zzfwu = new FrameLayout(context);
        this.zzgxu = zzbhhVar;
        this.zzham = context;
        this.zzbvf = str;
        this.zzhhz = zzdjnVar;
        this.zzhia = zzdkdVar;
        zzdkdVar.zza(this);
        this.zzbpj = zzbarVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void showInterstitial() {
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
    public final zzxy zzkn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxc zzko() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final IObjectWrapper zzki() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfwu);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzwc zzwcVar) {
        this.zzhhz.zza(zzwcVar);
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
            return this.zzhhz.zza(zzvqVar, this.zzbvf, new zzdju(this), new zzdjt(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.google.android.gms.ads.internal.overlay.zzr zza(zzbmp zzbmpVar) {
        boolean zzadm = zzbmpVar.zzadm();
        int intValue = ((Integer) zzww.zzra().zzd(zzabq.zzcwa)).intValue();
        com.google.android.gms.ads.internal.overlay.zzq zzqVar = new com.google.android.gms.ads.internal.overlay.zzq();
        zzqVar.size = 50;
        zzqVar.paddingLeft = zzadm ? intValue : 0;
        zzqVar.paddingRight = zzadm ? 0 : intValue;
        zzqVar.paddingTop = 0;
        zzqVar.paddingBottom = intValue;
        return new com.google.android.gms.ads.internal.overlay.zzr(this.zzham, zzqVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RelativeLayout.LayoutParams zzb(zzbmp zzbmpVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(zzbmpVar.zzadm() ? 11 : 9);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzbmp zzbmpVar) {
        zzbmpVar.zza(this);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzab
    public final void zzwg() {
        zzej(zzbmf.zzfwd);
    }

    @Override // com.google.android.gms.internal.ads.zzsi
    public final void zzmz() {
        zzej(zzbmf.zzfwc);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzamk() {
        if (this.zzhid == null) {
            return;
        }
        this.zzhib = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime();
        int zzakb = this.zzhid.zzakb();
        if (zzakb <= 0) {
            return;
        }
        zzblz zzblzVar = new zzblz(this.zzgxu.zzafw(), com.google.android.gms.ads.internal.zzr.zzlc());
        this.zzhic = zzblzVar;
        zzblzVar.zza(zzakb, new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdjr
            private final zzdjp zzhih;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhih = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhih.zzavc();
            }
        });
    }

    private final synchronized void zzej(int i) {
        if (this.zzhhy.compareAndSet(false, true)) {
            if (this.zzhid != null && this.zzhid.zzakn() != null) {
                this.zzhia.zzb(this.zzhid.zzakn());
            }
            this.zzhia.onAdClosed();
            this.zzfwu.removeAllViews();
            if (this.zzhic != null) {
                com.google.android.gms.ads.internal.zzr.zzky().zzb(this.zzhic);
            }
            if (this.zzhid != null) {
                long j = -1;
                if (this.zzhib != -1) {
                    j = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - this.zzhib;
                }
                this.zzhid.zzb(j, i);
            }
            destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzvt zzavb() {
        return zzdpr.zzb(this.zzham, Collections.singletonList(this.zzhid.zzakk()));
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzhid != null) {
            this.zzhid.destroy();
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
    public final synchronized zzvt zzkk() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzhid != null) {
            return zzdpr.zzb(this.zzham, Collections.singletonList(this.zzhid.zzakk()));
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void zza(zzvt zzvtVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
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
    public final synchronized zzzc zzkm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized boolean isLoading() {
        return this.zzhhz.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized String getAdUnitId() {
        return this.zzbvf;
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
    public final /* synthetic */ void zzavc() {
        zzww.zzqw();
        if (zzbae.zzaaq()) {
            zzej(zzbmf.zzfwe);
        } else {
            this.zzgxu.zzafv().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdjs
                private final zzdjp zzhih;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhih = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzhih.zzavd();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzavd() {
        zzej(zzbmf.zzfwe);
    }
}
