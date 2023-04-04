package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcip extends zzbpc {
    private final Context context;
    private final zzawa zzeaz;
    private final WeakReference<zzbfi> zzgdl;
    private final zzbyz zzgdm;
    private final zzbpz zzgdn;
    private final zzdvj zzgdo;
    private final zzbtb zzgdp;
    private final zzcbr zzgdq;
    private boolean zzglb;
    private final zzbum zzgls;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcip(zzbpf zzbpfVar, Context context, zzbfi zzbfiVar, zzcbr zzcbrVar, zzbyz zzbyzVar, zzbtb zzbtbVar, zzbum zzbumVar, zzbpz zzbpzVar, zzdot zzdotVar, zzdvj zzdvjVar) {
        super(zzbpfVar);
        this.zzglb = false;
        this.context = context;
        this.zzgdq = zzcbrVar;
        this.zzgdl = new WeakReference<>(zzbfiVar);
        this.zzgdm = zzbyzVar;
        this.zzgdp = zzbtbVar;
        this.zzgls = zzbumVar;
        this.zzgdn = zzbpzVar;
        this.zzgdo = zzdvjVar;
        this.zzeaz = new zzaxb(zzdotVar.zzdxw);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.content.Context] */
    public final boolean zzb(boolean z, Activity activity) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpj)).booleanValue()) {
            com.google.android.gms.ads.internal.zzr.zzkv();
            if (com.google.android.gms.ads.internal.util.zzj.zzat(this.context)) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzgdp.zzamj();
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcpk)).booleanValue()) {
                    this.zzgdo.zzhg(this.zzftl.zzhnt.zzeuy.zzbwe);
                }
                return false;
            }
        }
        if (this.zzglb) {
            com.google.android.gms.ads.internal.util.zzd.zzez("The rewarded ad have been showed.");
            this.zzgdp.zzl(zzdqh.zza(zzdqj.AD_REUSED, null, null));
            return false;
        }
        this.zzglb = true;
        this.zzgdm.zzalz();
        Activity activity2 = activity;
        if (activity == null) {
            activity2 = this.context;
        }
        try {
            this.zzgdq.zza(z, activity2);
            this.zzgdm.zzalx();
            return true;
        } catch (zzcbq e2) {
            this.zzgdp.zza(e2);
            return false;
        }
    }

    public final boolean isUsed() {
        return this.zzglb;
    }

    public final zzawa zzsb() {
        return this.zzeaz;
    }

    public final boolean isClosed() {
        return this.zzgdn.isClosed();
    }

    public final boolean zzsc() {
        zzbfi zzbfiVar = this.zzgdl.get();
        return (zzbfiVar == null || zzbfiVar.zzaeu()) ? false : true;
    }

    public final Bundle getAdMetadata() {
        return this.zzgls.getAdMetadata();
    }

    public final void finalize() {
        try {
            zzbfi zzbfiVar = this.zzgdl.get();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzczr)).booleanValue()) {
                if (!this.zzglb && zzbfiVar != null) {
                    zzebs zzebsVar = zzbat.zzeki;
                    zzbfiVar.getClass();
                    zzebsVar.execute(zzcio.zze(zzbfiVar));
                }
            } else if (zzbfiVar != null) {
                zzbfiVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }
}
