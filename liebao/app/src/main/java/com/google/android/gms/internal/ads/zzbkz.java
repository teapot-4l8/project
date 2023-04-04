package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbkz implements zzbsy, zzbtm, zzbtq, zzbuj, zzve {
    private final Context context;
    private final Executor executor;
    private final zzacv zzeut;
    private final zzdpi zzftl;
    private final zzdun zzftm;
    private final ScheduledExecutorService zzftq;
    private final zzdot zzftr;
    private final zzdpu zzfts;
    private final zzei zzftt;
    private final zzacw zzftu;
    private final WeakReference<View> zzftv;
    private boolean zzftw;
    private boolean zzftx;

    public zzbkz(Context context, Executor executor, ScheduledExecutorService scheduledExecutorService, zzdpi zzdpiVar, zzdot zzdotVar, zzdun zzdunVar, zzdpu zzdpuVar, View view, zzei zzeiVar, zzacv zzacvVar, zzacw zzacwVar) {
        this.context = context;
        this.executor = executor;
        this.zzftq = scheduledExecutorService;
        this.zzftl = zzdpiVar;
        this.zzftr = zzdotVar;
        this.zzftm = zzdunVar;
        this.zzfts = zzdpuVar;
        this.zzftt = zzeiVar;
        this.zzftv = new WeakReference<>(view);
        this.zzeut = zzacvVar;
        this.zzftu = zzacwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdOpened() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final synchronized void onAdLoaded() {
        if (this.zzftw) {
            ArrayList arrayList = new ArrayList(this.zzftr.zzdnb);
            arrayList.addAll(this.zzftr.zzhmb);
            this.zzfts.zzj(this.zzftm.zza(this.zzftl, this.zzftr, true, null, null, arrayList));
        } else {
            this.zzfts.zzj(this.zzftm.zza(this.zzftl, this.zzftr, this.zzftr.zzhmd));
            this.zzfts.zzj(this.zzftm.zza(this.zzftl, this.zzftr, this.zzftr.zzhmb));
        }
        this.zzftw = true;
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void onAdClicked() {
        if ((((Boolean) zzww.zzra().zzd(zzabq.zzcpb)).booleanValue() && this.zzftl.zzhnt.zzeuy.zzegd) || !zzadk.zzdep.get().booleanValue()) {
            zzdpu zzdpuVar = this.zzfts;
            zzdun zzdunVar = this.zzftm;
            zzdpi zzdpiVar = this.zzftl;
            zzdot zzdotVar = this.zzftr;
            List<String> zza = zzdunVar.zza(zzdpiVar, zzdotVar, zzdotVar.zzdna);
            com.google.android.gms.ads.internal.zzr.zzkv();
            zzdpuVar.zza(zza, com.google.android.gms.ads.internal.util.zzj.zzbd(this.context) ? zzcse.zzgui : zzcse.zzguh);
            return;
        }
        zzebh.zza(zzebc.zzg(this.zzftu.zza(this.context, this.zzeut.zzte(), this.zzeut.zztf())).zza(((Long) zzww.zzra().zzd(zzabq.zzcqd)).longValue(), TimeUnit.MILLISECONDS, this.zzftq), new zzbky(this), this.executor);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final synchronized void onAdImpression() {
        if (!this.zzftx) {
            String zza = ((Boolean) zzww.zzra().zzd(zzabq.zzctj)).booleanValue() ? this.zzftt.zzcb().zza(this.context, this.zzftv.get(), (Activity) null) : null;
            if (!(((Boolean) zzww.zzra().zzd(zzabq.zzcpb)).booleanValue() && this.zzftl.zzhnt.zzeuy.zzegd) && zzadk.zzdeq.get().booleanValue()) {
                zzebh.zza(zzebc.zzg(this.zzftu.zzk(this.context)).zza(((Long) zzww.zzra().zzd(zzabq.zzcqd)).longValue(), TimeUnit.MILLISECONDS, this.zzftq), new zzblb(this, zza), this.executor);
                this.zzftx = true;
            }
            this.zzfts.zzj(this.zzftm.zza(this.zzftl, this.zzftr, false, zza, null, this.zzftr.zzdnb));
            this.zzftx = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzb(zzavd zzavdVar, String str, String str2) {
        zzdpu zzdpuVar = this.zzfts;
        zzdun zzdunVar = this.zzftm;
        zzdot zzdotVar = this.zzftr;
        zzdpuVar.zzj(zzdunVar.zza(zzdotVar, zzdotVar.zzdxy, zzavdVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoStarted() {
        zzdpu zzdpuVar = this.zzfts;
        zzdun zzdunVar = this.zzftm;
        zzdpi zzdpiVar = this.zzftl;
        zzdot zzdotVar = this.zzftr;
        zzdpuVar.zzj(zzdunVar.zza(zzdpiVar, zzdotVar, zzdotVar.zzdxx));
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoCompleted() {
        zzdpu zzdpuVar = this.zzfts;
        zzdun zzdunVar = this.zzftm;
        zzdpi zzdpiVar = this.zzftl;
        zzdot zzdotVar = this.zzftr;
        zzdpuVar.zzj(zzdunVar.zza(zzdpiVar, zzdotVar, zzdotVar.zzhmc));
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final void zzk(zzvh zzvhVar) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcrs)).booleanValue()) {
            this.zzfts.zzj(this.zzftm.zza(this.zzftl, this.zzftr, zzdun.zza(2, zzvhVar.errorCode, this.zzftr.zzhme)));
        }
    }
}
