package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcmy implements AppEventListener, zzbsy, zzbsz, zzbtp, zzbtq, zzbuj, zzbvm, zzdtm, zzve {
    private long startTime;
    private final List<Object> zzejx;
    private final zzcmm zzgpa;

    public zzcmy(zzcmm zzcmmVar, zzbhh zzbhhVar) {
        this.zzgpa = zzcmmVar;
        this.zzejx = Collections.singletonList(zzbhhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzdpi zzdpiVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzce(Context context) {
        zza(zzbtp.class, "onPause", context);
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzcf(Context context) {
        zza(zzbtp.class, "onResume", context);
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzcg(Context context) {
        zza(zzbtp.class, "onDestroy", context);
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final void onAppEvent(String str, String str2) {
        zza(AppEventListener.class, "onAppEvent", str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        long elapsedRealtime = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - this.startTime;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Ad Request Latency : ");
        sb.append(elapsedRealtime);
        com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
        zza(zzbuj.class, "onAdLoaded", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzd(zzvh zzvhVar) {
        zza(zzbsz.class, "onAdFailedToLoad", Integer.valueOf(zzvhVar.errorCode), zzvhVar.zzchs, zzvhVar.zzcht);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdOpened() {
        zza(zzbsy.class, "onAdOpened", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdClosed() {
        zza(zzbsy.class, "onAdClosed", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdLeftApplication() {
        zza(zzbsy.class, "onAdLeftApplication", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void onAdClicked() {
        zza(zzve.class, "onAdClicked", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void onAdImpression() {
        zza(zzbtq.class, "onAdImpression", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoStarted() {
        zza(zzbsy.class, "onRewardedVideoStarted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    @ParametersAreNonnullByDefault
    public final void zzb(zzavd zzavdVar, String str, String str2) {
        zza(zzbsy.class, "onRewarded", zzavdVar, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoCompleted() {
        zza(zzbsy.class, "onRewardedVideoCompleted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zza(zzdth zzdthVar, String str) {
        zza(zzdte.class, "onTaskCreated", str);
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zzb(zzdth zzdthVar, String str) {
        zza(zzdte.class, "onTaskStarted", str);
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zza(zzdth zzdthVar, String str, Throwable th) {
        zza(zzdte.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zzc(zzdth zzdthVar, String str) {
        zza(zzdte.class, "onTaskSucceeded", str);
    }

    private final void zza(Class<?> cls, String str, Object... objArr) {
        zzcmm zzcmmVar = this.zzgpa;
        List<Object> list = this.zzejx;
        String valueOf = String.valueOf(cls.getSimpleName());
        zzcmmVar.zza(list, valueOf.length() != 0 ? "Event-".concat(valueOf) : new String("Event-"), str, objArr);
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzauj zzaujVar) {
        this.startTime = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime();
        zza(zzbvm.class, "onAdRequest", new Object[0]);
    }
}
