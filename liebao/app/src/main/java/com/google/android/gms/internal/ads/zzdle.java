package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdle implements zzebi<zzbne> {
    private final /* synthetic */ zzdav zzhcc;
    private final /* synthetic */ zzboa zzhjm;
    final /* synthetic */ zzdlc zzhjn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdle(zzdlc zzdlcVar, zzdav zzdavVar, zzboa zzboaVar) {
        this.zzhjn = zzdlcVar;
        this.zzhcc = zzdavVar;
        this.zzhjm = zzboaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        zzbve zzbveVar;
        Executor executor;
        zzvh zze = this.zzhjm.zzahd().zze(th);
        synchronized (this.zzhjn) {
            this.zzhjn.zzhjl = null;
            this.zzhjm.zzahe().zzd(zze);
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdas)).booleanValue()) {
                executor = this.zzhjn.zzfur;
                executor.execute(new Runnable(this, zze) { // from class: com.google.android.gms.internal.ads.zzdlg
                    private final zzvh zzhcg;
                    private final zzdle zzhjq;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhjq = this;
                        this.zzhcg = zze;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzczm zzczmVar;
                        zzdle zzdleVar = this.zzhjq;
                        zzvh zzvhVar = this.zzhcg;
                        zzczmVar = zzdleVar.zzhjn.zzhas;
                        zzczmVar.zzd(zzvhVar);
                    }
                });
            }
            zzbveVar = this.zzhjn.zzhjk;
            zzbveVar.zzef(60);
            zzdqa.zza(zze.errorCode, th, "BannerAdLoader.onFailure");
            this.zzhcc.zzatg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(zzbne zzbneVar) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        zzbve zzbveVar;
        Executor executor;
        zzczm zzczmVar;
        zzczm zzczmVar2;
        zzdaj zzdajVar;
        zzbne zzbneVar2 = zzbneVar;
        synchronized (this.zzhjn) {
            this.zzhjn.zzhjl = null;
            viewGroup = this.zzhjn.zzfwu;
            viewGroup.removeAllViews();
            if (zzbneVar2.zzakl() != null) {
                ViewParent parent = zzbneVar2.zzakl().getParent();
                if (parent instanceof ViewGroup) {
                    String mediationAdapterClassName = zzbneVar2.zzall() != null ? zzbneVar2.zzall().getMediationAdapterClassName() : "";
                    StringBuilder sb = new StringBuilder(String.valueOf(mediationAdapterClassName).length() + 78);
                    sb.append("Banner view provided from ");
                    sb.append(mediationAdapterClassName);
                    sb.append(" already has a parent view. Removing its old parent.");
                    com.google.android.gms.ads.internal.util.zzd.zzez(sb.toString());
                    ((ViewGroup) parent).removeView(zzbneVar2.zzakl());
                }
            }
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdas)).booleanValue()) {
                zzbwp zzaln = zzbneVar2.zzaln();
                zzczmVar2 = this.zzhjn.zzhas;
                zzbwp zza = zzaln.zza(zzczmVar2);
                zzdajVar = this.zzhjn.zzhji;
                zza.zza(zzdajVar);
            }
            viewGroup2 = this.zzhjn.zzfwu;
            viewGroup2.addView(zzbneVar2.zzakl());
            this.zzhcc.onSuccess(zzbneVar2);
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdas)).booleanValue()) {
                executor = this.zzhjn.zzfur;
                zzczmVar = this.zzhjn.zzhas;
                zzczmVar.getClass();
                executor.execute(zzdld.zzb(zzczmVar));
            }
            zzbveVar = this.zzhjn.zzhjk;
            zzbveVar.zzef(zzbneVar2.zzaku());
        }
    }
}
