package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcgs {
    private final Executor zzfur;
    private final zzdpm zzfzg;
    private final zzcja zzgix;

    public zzcgs(zzdpm zzdpmVar, Executor executor, zzcja zzcjaVar) {
        this.zzfzg = zzdpmVar;
        this.zzfur = executor;
        this.zzgix = zzcjaVar;
    }

    public final zzebt<zzbfi> zzo(JSONObject jSONObject) {
        return zzebh.zzb(zzebh.zzb(zzebh.zzag(null), new zzear(this) { // from class: com.google.android.gms.internal.ads.zzcgx
            private final zzcgs zzgkw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgkw = this;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgkw.zzq(obj);
            }
        }, this.zzfur), new zzear(this, jSONObject) { // from class: com.google.android.gms.internal.ads.zzcgv
            private final JSONObject zzfvb;
            private final zzcgs zzgkw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgkw = this;
                this.zzfvb = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgkw.zza(this.zzfvb, (zzbfi) obj);
            }
        }, this.zzfur);
    }

    public final zzebt<zzbfi> zzp(String str, String str2) {
        return zzebh.zzb(zzebh.zzag(null), new zzear(this, str, str2) { // from class: com.google.android.gms.internal.ads.zzcgu
            private final String zzdkl;
            private final String zzdmx;
            private final zzcgs zzgkw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgkw = this;
                this.zzdkl = str;
                this.zzdmx = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgkw.zza(this.zzdkl, this.zzdmx, obj);
            }
        }, this.zzfur);
    }

    private final void zzh(zzbfi zzbfiVar) {
        zzbfiVar.zza("/video", zzahr.zzdis);
        zzbfiVar.zza("/videoMeta", zzahr.zzdit);
        zzbfiVar.zza("/precache", new zzbep());
        zzbfiVar.zza("/delayPageLoaded", zzahr.zzdiw);
        zzbfiVar.zza("/instrument", zzahr.zzdiu);
        zzbfiVar.zza("/log", zzahr.zzdin);
        zzbfiVar.zza("/videoClicked", zzahr.zzdio);
        zzbfiVar.zzaef().zzbc(true);
        zzbfiVar.zza("/click", zzahr.zzdij);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcts)).booleanValue()) {
            zzbfiVar.zza("/getNativeAdViewSignals", zzahr.zzdiz);
        }
        if (this.zzfzg.zzdxd != null) {
            zzbfiVar.zzaef().zzbd(true);
            zzbfiVar.zza("/open", new zzaio(null, null, null, null, null));
        } else {
            zzbfiVar.zzaef().zzbd(false);
        }
        if (com.google.android.gms.ads.internal.zzr.zzlt().zzaa(zzbfiVar.getContext())) {
            zzbfiVar.zza("/logScionEvent", new zzaim(zzbfiVar.getContext()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzq(Object obj) {
        zzbfi zza = this.zzgix.zza(zzvt.zzqk(), null, null);
        zzbbb zzk = zzbbb.zzk(zza);
        zzh(zza);
        zza.zzaef().zza(new zzbgw(zzk) { // from class: com.google.android.gms.internal.ads.zzcgw
            private final zzbbb zzety;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzety = zzk;
            }

            @Override // com.google.android.gms.internal.ads.zzbgw
            public final void zzuv() {
                this.zzety.zzaav();
            }
        });
        zza.loadUrl((String) zzww.zzra().zzd(zzabq.zzctr));
        return zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(String str, String str2, Object obj) {
        zzbfi zza = this.zzgix.zza(zzvt.zzqk(), null, null);
        zzbbb zzk = zzbbb.zzk(zza);
        zzh(zza);
        if (this.zzfzg.zzdxd != null) {
            zza.zza(zzbgx.zzafi());
        } else {
            zza.zza(zzbgx.zzafh());
        }
        zza.zzaef().zza(new zzbgt(this, zza, zzk) { // from class: com.google.android.gms.internal.ads.zzcgz
            private final zzbfi zzgji;
            private final zzcgs zzgkw;
            private final zzbbb zzgkx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgkw = this;
                this.zzgji = zza;
                this.zzgkx = zzk;
            }

            @Override // com.google.android.gms.internal.ads.zzbgt
            public final void zzam(boolean z) {
                this.zzgkw.zza(this.zzgji, this.zzgkx, z);
            }
        });
        zza.zzb(str, str2, null);
        return zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbfi zzbfiVar, zzbbb zzbbbVar, boolean z) {
        if (z) {
            if (this.zzfzg.zzhnw != null && zzbfiVar.zzabv() != null) {
                zzbfiVar.zzabv().zzb(this.zzfzg.zzhnw);
            }
            zzbbbVar.zzaav();
            return;
        }
        zzbbbVar.setException(new zzcwo(zzdqj.INTERNAL_ERROR, "Instream video Web View failed to load."));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(JSONObject jSONObject, zzbfi zzbfiVar) {
        zzbbb zzk = zzbbb.zzk(zzbfiVar);
        if (this.zzfzg.zzdxd != null) {
            zzbfiVar.zza(zzbgx.zzafi());
        } else {
            zzbfiVar.zza(zzbgx.zzafh());
        }
        zzbfiVar.zzaef().zza(new zzbgt(this, zzbfiVar, zzk) { // from class: com.google.android.gms.internal.ads.zzcgy
            private final zzbfi zzgji;
            private final zzcgs zzgkw;
            private final zzbbb zzgkx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgkw = this;
                this.zzgji = zzbfiVar;
                this.zzgkx = zzk;
            }

            @Override // com.google.android.gms.internal.ads.zzbgt
            public final void zzam(boolean z) {
                this.zzgkw.zzb(this.zzgji, this.zzgkx, z);
            }
        });
        zzbfiVar.zzb("google.afma.nativeAds.renderVideo", jSONObject);
        return zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbfi zzbfiVar, zzbbb zzbbbVar, boolean z) {
        if (this.zzfzg.zzhnw != null && zzbfiVar.zzabv() != null) {
            zzbfiVar.zzabv().zzb(this.zzfzg.zzhnw);
        }
        zzbbbVar.zzaav();
    }
}
