package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcaj extends zzbpc {
    private final Context context;
    private final zzcbr zzfwq;
    private boolean zzfwr;
    private final WeakReference<zzbfi> zzgdl;
    private final zzbyz zzgdm;
    private final zzbpz zzgdn;
    private final zzdvj zzgdo;
    private final zzbtb zzgdp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcaj(zzbpf zzbpfVar, Context context, @Nullable zzbfi zzbfiVar, zzbyz zzbyzVar, zzcbr zzcbrVar, zzbpz zzbpzVar, zzdvj zzdvjVar, zzbtb zzbtbVar) {
        super(zzbpfVar);
        this.zzfwr = false;
        this.context = context;
        this.zzgdl = new WeakReference<>(zzbfiVar);
        this.zzgdm = zzbyzVar;
        this.zzfwq = zzcbrVar;
        this.zzgdn = zzbpzVar;
        this.zzgdo = zzdvjVar;
        this.zzgdp = zzbtbVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.content.Context] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzb(boolean z, @Nullable Activity activity) {
        boolean z2;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpj)).booleanValue()) {
            com.google.android.gms.ads.internal.zzr.zzkv();
            if (com.google.android.gms.ads.internal.util.zzj.zzat(this.context)) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzgdp.zzamj();
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcpk)).booleanValue()) {
                    this.zzgdo.zzhg(this.zzftl.zzhnt.zzeuy.zzbwe);
                }
                z2 = false;
                if (z2) {
                    this.zzgdm.zzalz();
                    Activity activity2 = activity;
                    if (activity == null) {
                        activity2 = this.context;
                    }
                    try {
                        this.zzfwq.zza(z, activity2);
                        this.zzgdm.zzalx();
                        this.zzfwr = true;
                        return true;
                    } catch (zzcbq e2) {
                        this.zzgdp.zza(e2);
                        return false;
                    }
                }
                return false;
            }
        }
        if (!this.zzfwr) {
            z2 = true;
            if (z2) {
            }
        }
        z2 = false;
        if (z2) {
        }
    }

    public final boolean isClosed() {
        return this.zzgdn.isClosed();
    }

    public final void finalize() {
        try {
            zzbfi zzbfiVar = this.zzgdl.get();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzczr)).booleanValue()) {
                if (!this.zzfwr && zzbfiVar != null) {
                    zzebs zzebsVar = zzbat.zzeki;
                    zzbfiVar.getClass();
                    zzebsVar.execute(zzcai.zze(zzbfiVar));
                }
            } else if (zzbfiVar != null) {
                zzbfiVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }
}
