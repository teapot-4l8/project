package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbxr;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdlc implements zzdat<zzbne> {
    private final Executor zzfur;
    private final ViewGroup zzfwu;
    private final zzdpo zzhan;
    private final zzczm zzhas;
    private final zzbhh zzhco;
    private final Context zzhik;
    private final zzdaj zzhji;
    private zzacm zzhjj;
    private final zzbve zzhjk;
    private zzebt<zzbne> zzhjl;

    public zzdlc(Context context, Executor executor, zzvt zzvtVar, zzbhh zzbhhVar, zzczm zzczmVar, zzdaj zzdajVar, zzdpo zzdpoVar) {
        this.zzhik = context;
        this.zzfur = executor;
        this.zzhco = zzbhhVar;
        this.zzhas = zzczmVar;
        this.zzhji = zzdajVar;
        this.zzhan = zzdpoVar;
        this.zzhjk = zzbhhVar.zzafz();
        this.zzfwu = new FrameLayout(context);
        zzdpoVar.zzg(zzvtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdat
    public final boolean isLoading() {
        zzebt<zzbne> zzebtVar = this.zzhjl;
        return (zzebtVar == null || zzebtVar.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzdat
    public final boolean zza(zzvq zzvqVar, String str, zzdas zzdasVar, zzdav<? super zzbne> zzdavVar) {
        zzboa zzaie;
        if (str == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Ad unit ID should not be null for banner ad.");
            this.zzfur.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdlb
                private final zzdlc zzhjh;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhjh = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzhjh.zzavl();
                }
            });
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            zzdpm zzawg = this.zzhan.zzgt(str).zzh(zzvqVar).zzawg();
            if (zzado.zzdfj.get().booleanValue() && this.zzhan.zzkk().zzciv) {
                zzczm zzczmVar = this.zzhas;
                if (zzczmVar != null) {
                    zzczmVar.zzd(zzdqh.zza(zzdqj.INVALID_AD_SIZE, null, null));
                }
                return false;
            }
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdas)).booleanValue()) {
                zzaie = this.zzhco.zzagc().zzd(new zzbsj.zza().zzci(this.zzhik).zza(zzawg).zzami()).zzd(new zzbxr.zza().zza((zzbvm) this.zzhas, this.zzfur).zza((AppEventListener) this.zzhas, this.zzfur).zzanf()).zza(new zzcyo(this.zzhjj)).zzb(new zzccb(zzcdy.zzghq, null)).zza(new zzboz(this.zzhjk)).zzd(new zzbnd(this.zzfwu)).zzaie();
            } else {
                zzaie = this.zzhco.zzagc().zzd(new zzbsj.zza().zzci(this.zzhik).zza(zzawg).zzami()).zzd(new zzbxr.zza().zza((zzbvm) this.zzhas, this.zzfur).zza((zzve) this.zzhas, this.zzfur).zza(this.zzhji, this.zzfur).zza((zzbtq) this.zzhas, this.zzfur).zza((zzbsy) this.zzhas, this.zzfur).zza((zzbuj) this.zzhas, this.zzfur).zza((zzbsz) this.zzhas, this.zzfur).zza((AppEventListener) this.zzhas, this.zzfur).zza((zzbvb) this.zzhas, this.zzfur).zzanf()).zza(new zzcyo(this.zzhjj)).zzb(new zzccb(zzcdy.zzghq, null)).zza(new zzboz(this.zzhjk)).zzd(new zzbnd(this.zzfwu)).zzaie();
            }
            zzebt<zzbne> zzalv = zzaie.zzahd().zzalv();
            this.zzhjl = zzalv;
            zzebh.zza(zzalv, new zzdle(this, zzdavVar, zzaie), this.zzfur);
            return true;
        }
    }

    public final ViewGroup zzavh() {
        return this.zzfwu;
    }

    public final void zza(zzacm zzacmVar) {
        this.zzhjj = zzacmVar;
    }

    public final void zza(zzwx zzwxVar) {
        this.zzhji.zzb(zzwxVar);
    }

    public final zzdpo zzavi() {
        return this.zzhan;
    }

    public final boolean zzavj() {
        ViewParent parent = this.zzfwu.getParent();
        if (parent instanceof View) {
            View view = (View) parent;
            return com.google.android.gms.ads.internal.zzr.zzkv().zza(view, view.getContext());
        }
        return false;
    }

    public final void zza(zzbvi zzbviVar) {
        this.zzhjk.zza(zzbviVar, this.zzfur);
    }

    public final void zzavk() {
        this.zzhjk.zzef(60);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzavl() {
        this.zzhas.zzd(zzdqh.zza(zzdqj.INVALID_AD_UNIT_ID, null, null));
    }
}
