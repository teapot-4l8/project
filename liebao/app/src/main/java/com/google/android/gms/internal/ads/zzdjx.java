package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbmm;
import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbxr;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzdjx<AppOpenAd extends zzbpc, AppOpenRequestComponent extends zzbmm<AppOpenAd>, AppOpenRequestComponentBuilder extends zzbsg<AppOpenRequestComponent>> implements zzdat<AppOpenAd> {
    private final Executor zzfur;
    private final ViewGroup zzfwu;
    private final zzdpo zzhan;
    protected final zzbhh zzhco;
    private final Context zzhik;
    private final zzdkd zzhil;
    private final zzdmh<AppOpenRequestComponent, AppOpenAd> zzhim;
    @Nullable
    private zzebt<AppOpenAd> zzhin;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdjx(Context context, Executor executor, zzbhh zzbhhVar, zzdmh<AppOpenRequestComponent, AppOpenAd> zzdmhVar, zzdkd zzdkdVar, zzdpo zzdpoVar) {
        this.zzhik = context;
        this.zzfur = executor;
        this.zzhco = zzbhhVar;
        this.zzhim = zzdmhVar;
        this.zzhil = zzdkdVar;
        this.zzhan = zzdpoVar;
        this.zzfwu = new FrameLayout(context);
    }

    protected abstract AppOpenRequestComponentBuilder zza(zzbnd zzbndVar, zzbsj zzbsjVar, zzbxr zzbxrVar);

    @Override // com.google.android.gms.internal.ads.zzdat
    public final boolean isLoading() {
        zzebt<AppOpenAd> zzebtVar = this.zzhin;
        return (zzebtVar == null || zzebtVar.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzdat
    public final synchronized boolean zza(zzvq zzvqVar, String str, zzdas zzdasVar, zzdav<? super AppOpenAd> zzdavVar) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (str == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Ad unit ID should not be null for app open ad.");
            this.zzfur.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdka
                private final zzdjx zzhio;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhio = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzhio.zzave();
                }
            });
            return false;
        } else if (this.zzhin != null) {
            return false;
        } else {
            zzdqa.zze(this.zzhik, zzvqVar.zzcid);
            zzdpm zzawg = this.zzhan.zzgt(str).zzg(zzvt.zzqm()).zzh(zzvqVar).zzawg();
            zzdke zzdkeVar = new zzdke(null);
            zzdkeVar.zzfzg = zzawg;
            zzebt<AppOpenAd> zza = this.zzhim.zza(new zzdmm(zzdkeVar), new zzdmj(this) { // from class: com.google.android.gms.internal.ads.zzdjz
                private final zzdjx zzhio;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhio = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdmj
                public final zzbsg zzc(zzdmk zzdmkVar) {
                    return this.zzhio.zzb(zzdmkVar);
                }
            });
            this.zzhin = zza;
            zzebh.zza(zza, new zzdkc(this, zzdavVar, zzdkeVar), this.zzfur);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zza */
    public final synchronized AppOpenRequestComponentBuilder zzb(zzdmk zzdmkVar) {
        zzdke zzdkeVar = (zzdke) zzdmkVar;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdat)).booleanValue()) {
            return zza(new zzbnd(this.zzfwu), new zzbsj.zza().zzci(this.zzhik).zza(zzdkeVar.zzfzg).zzami(), new zzbxr.zza().zzanf());
        }
        zzdkd zzb = zzdkd.zzb(this.zzhil);
        zzbxr.zza zzaVar = new zzbxr.zza();
        zzaVar.zza((zzbsz) zzb, this.zzfur);
        zzaVar.zza((zzbus) zzb, this.zzfur);
        zzaVar.zza((com.google.android.gms.ads.internal.overlay.zzp) zzb, this.zzfur);
        zzaVar.zza((zzbvb) zzb, this.zzfur);
        zzaVar.zza(zzb);
        return zza(new zzbnd(this.zzfwu), new zzbsj.zza().zzci(this.zzhik).zza(zzdkeVar.zzfzg).zzami(), zzaVar.zzanf());
    }

    public final void zza(zzwc zzwcVar) {
        this.zzhan.zzb(zzwcVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzave() {
        this.zzhil.zzd(zzdqh.zza(zzdqj.INVALID_AD_UNIT_ID, null, null));
    }
}
