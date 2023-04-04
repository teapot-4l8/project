package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbxr;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdnz implements zzdat<zzcip> {
    private final Executor zzfur;
    private final zzdph zzgbf;
    private final zzdpo zzhan;
    private final zzbhh zzhco;
    private final Context zzhik;
    private final zzdmh<zzcis, zzcip> zzhim;
    private zzebt<zzcip> zzhjl;
    private final zzdnb zzhlj;

    public zzdnz(Context context, Executor executor, zzbhh zzbhhVar, zzdmh<zzcis, zzcip> zzdmhVar, zzdnb zzdnbVar, zzdpo zzdpoVar, zzdph zzdphVar) {
        this.zzhik = context;
        this.zzfur = executor;
        this.zzhco = zzbhhVar;
        this.zzhim = zzdmhVar;
        this.zzhlj = zzdnbVar;
        this.zzhan = zzdpoVar;
        this.zzgbf = zzdphVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdat
    public final boolean isLoading() {
        zzebt<zzcip> zzebtVar = this.zzhjl;
        return (zzebtVar == null || zzebtVar.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzdat
    public final boolean zza(zzvq zzvqVar, String str, zzdas zzdasVar, zzdav<? super zzcip> zzdavVar) {
        zzavt zzavtVar = new zzavt(zzvqVar, str);
        if (zzdasVar instanceof zzdoa) {
            zzdoa zzdoaVar = (zzdoa) zzdasVar;
        }
        if (zzavtVar.zzbvf == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Ad unit ID should not be null for rewarded video ad.");
            this.zzfur.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdoc
                private final zzdnz zzhll;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhll = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzhll.zzavu();
                }
            });
            return false;
        }
        zzebt<zzcip> zzebtVar = this.zzhjl;
        if (zzebtVar == null || zzebtVar.isDone()) {
            zzdqa.zze(this.zzhik, zzavtVar.zzdvn.zzcid);
            zzdpm zzawg = this.zzhan.zzgt(zzavtVar.zzbvf).zzg(zzvt.zzql()).zzh(zzavtVar.zzdvn).zzawg();
            zzdof zzdofVar = new zzdof(null);
            zzdofVar.zzfzg = zzawg;
            zzdofVar.zzhlk = null;
            zzebt<zzcip> zza = this.zzhim.zza(new zzdmm(zzdofVar), new zzdmj(this) { // from class: com.google.android.gms.internal.ads.zzdob
                private final zzdnz zzhll;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhll = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdmj
                public final zzbsg zzc(zzdmk zzdmkVar) {
                    return this.zzhll.zze(zzdmkVar);
                }
            });
            this.zzhjl = zza;
            zzebh.zza(zza, new zzdoe(this, zzdavVar, zzdofVar), this.zzfur);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzek(int i) {
        this.zzhan.zzawf().zzel(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzciv zze(zzdmk zzdmkVar) {
        zzdof zzdofVar = (zzdof) zzdmkVar;
        return this.zzhco.zzagk().zzf(new zzbsj.zza().zzci(this.zzhik).zza(zzdofVar.zzfzg).zzft(zzdofVar.zzhlk).zza(this.zzgbf).zzami()).zzf(new zzbxr.zza().zzanf());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzavu() {
        this.zzhlj.zzd(zzdqh.zza(zzdqj.INVALID_AD_UNIT_ID, null, null));
    }
}
