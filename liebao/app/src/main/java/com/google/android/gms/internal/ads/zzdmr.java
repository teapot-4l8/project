package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbxr;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdmr implements zzdat<zzcaj> {
    private final Executor zzfur;
    private final zzdpo zzhan;
    private final zzczm zzhas;
    private final zzbhh zzhco;
    private final Context zzhik;
    private zzacm zzhjj;
    private zzebt<zzcaj> zzhjl;
    private final zzdnb zzhkv;

    public zzdmr(Context context, Executor executor, zzbhh zzbhhVar, zzczm zzczmVar, zzdnb zzdnbVar, zzdpo zzdpoVar) {
        this.zzhik = context;
        this.zzfur = executor;
        this.zzhco = zzbhhVar;
        this.zzhas = zzczmVar;
        this.zzhan = zzdpoVar;
        this.zzhkv = zzdnbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdat
    public final boolean isLoading() {
        zzebt<zzcaj> zzebtVar = this.zzhjl;
        return (zzebtVar == null || zzebtVar.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzdat
    public final boolean zza(zzvq zzvqVar, String str, zzdas zzdasVar, zzdav<? super zzcaj> zzdavVar) {
        zzvt zzvtVar;
        zzcbj zzair;
        if (str == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Ad unit ID should not be null for interstitial ad.");
            this.zzfur.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdmu
                private final zzdmr zzhky;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhky = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzhky.zzavt();
                }
            });
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            if (zzdasVar instanceof zzdms) {
                zzvtVar = ((zzdms) zzdasVar).zzedt;
            } else {
                zzvtVar = new zzvt();
            }
            zzdpm zzawg = this.zzhan.zzgt(str).zzg(zzvtVar).zzh(zzvqVar).zzawg();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdau)).booleanValue()) {
                zzair = this.zzhco.zzagh().zze(new zzbsj.zza().zzci(this.zzhik).zza(zzawg).zzami()).zze(new zzbxr.zza().zza((zzbvm) this.zzhas, this.zzfur).zza((AppEventListener) this.zzhas, this.zzfur).zzanf()).zzb(new zzcyo(this.zzhjj)).zzair();
            } else {
                zzbxr.zza zzaVar = new zzbxr.zza();
                zzdnb zzdnbVar = this.zzhkv;
                if (zzdnbVar != null) {
                    zzaVar.zza((zzbsy) zzdnbVar, this.zzfur).zza((zzbuj) this.zzhkv, this.zzfur).zza((zzbsz) this.zzhkv, this.zzfur);
                }
                zzair = this.zzhco.zzagh().zze(new zzbsj.zza().zzci(this.zzhik).zza(zzawg).zzami()).zze(zzaVar.zza((zzbvm) this.zzhas, this.zzfur).zza((zzbsy) this.zzhas, this.zzfur).zza((zzbuj) this.zzhas, this.zzfur).zza((zzbsz) this.zzhas, this.zzfur).zza((zzve) this.zzhas, this.zzfur).zza((AppEventListener) this.zzhas, this.zzfur).zza((zzbvb) this.zzhas, this.zzfur).zza((zzbtm) this.zzhas, this.zzfur).zzanf()).zzb(new zzcyo(this.zzhjj)).zzair();
            }
            zzebt<zzcaj> zzalv = zzair.zzahd().zzalv();
            this.zzhjl = zzalv;
            zzebh.zza(zzalv, new zzdmt(this, zzdavVar, zzair), this.zzfur);
            return true;
        }
    }

    public final void zza(zzacm zzacmVar) {
        this.zzhjj = zzacmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzavt() {
        this.zzhas.zzd(zzdqh.zza(zzdqj.INVALID_AD_UNIT_ID, null, null));
    }
}
