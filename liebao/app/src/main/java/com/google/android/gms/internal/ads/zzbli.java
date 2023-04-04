package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.umeng.analytics.pro.ak;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbli implements com.google.android.gms.ads.internal.overlay.zzp, zzbtp, zzbtq, zzqw {
    private final Clock zzbqq;
    private final zzbld zzfun;
    private final zzblg zzfuo;
    private final zzana<JSONObject, JSONObject> zzfuq;
    private final Executor zzfur;
    private final Set<zzbfi> zzfup = new HashSet();
    private final AtomicBoolean zzfus = new AtomicBoolean(false);
    private final zzblk zzfut = new zzblk();
    private boolean zzfuu = false;
    private WeakReference<?> zzfuv = new WeakReference<>(this);

    public zzbli(zzamx zzamxVar, zzblg zzblgVar, Executor executor, zzbld zzbldVar, Clock clock) {
        this.zzfun = zzbldVar;
        this.zzfuq = zzamxVar.zzb("google.afma.activeView.handleUpdate", zzamn.zzdma, zzamn.zzdma);
        this.zzfuo = zzblgVar;
        this.zzfur = executor;
        this.zzbqq = clock;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onUserLeaveHint() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zza(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzvz() {
    }

    public final synchronized void zzajs() {
        if (!(this.zzfuv.get() != null)) {
            zzaju();
            return;
        }
        if (!this.zzfuu && this.zzfus.get()) {
            try {
                this.zzfut.timestamp = this.zzbqq.elapsedRealtime();
                final JSONObject zzi = this.zzfuo.zzi(this.zzfut);
                for (final zzbfi zzbfiVar : this.zzfup) {
                    this.zzfur.execute(new Runnable(zzbfiVar, zzi) { // from class: com.google.android.gms.internal.ads.zzbll
                        private final zzbfi zzewn;
                        private final JSONObject zzfvb;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzewn = zzbfiVar;
                            this.zzfvb = zzi;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzewn.zzb("AFMA_updateActiveView", this.zzfvb);
                        }
                    });
                }
                zzbba.zzb(this.zzfuq.zzf(zzi), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e2) {
                com.google.android.gms.ads.internal.util.zzd.zza("Failed to call ActiveViewJS", e2);
            }
        }
    }

    private final void zzajt() {
        for (zzbfi zzbfiVar : this.zzfup) {
            this.zzfun.zzb(zzbfiVar);
        }
        this.zzfun.zzajr();
    }

    public final synchronized void zzaju() {
        zzajt();
        this.zzfuu = true;
    }

    public final synchronized void zzc(zzbfi zzbfiVar) {
        this.zzfup.add(zzbfiVar);
        this.zzfun.zza(zzbfiVar);
    }

    public final void zzn(Object obj) {
        this.zzfuv = new WeakReference<>(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final synchronized void zza(zzqx zzqxVar) {
        this.zzfut.zzbrt = zzqxVar.zzbrt;
        this.zzfut.zzfva = zzqxVar;
        zzajs();
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final synchronized void zzce(Context context) {
        this.zzfut.zzfux = true;
        zzajs();
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final synchronized void zzcf(Context context) {
        this.zzfut.zzfux = false;
        zzajs();
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final synchronized void zzcg(Context context) {
        this.zzfut.zzfuz = ak.aG;
        zzajs();
        zzajt();
        this.zzfuu = true;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onPause() {
        this.zzfut.zzfux = true;
        zzajs();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onResume() {
        this.zzfut.zzfux = false;
        zzajs();
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final synchronized void onAdImpression() {
        if (this.zzfus.compareAndSet(false, true)) {
            this.zzfun.zza(this);
            zzajs();
        }
    }
}
