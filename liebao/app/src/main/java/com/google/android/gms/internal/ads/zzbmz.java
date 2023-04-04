package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbmz extends zzbpc {
    private final Context context;
    private final zzbfi zzdkm;
    private final int zzfvw;
    private final zzbme zzfwl;
    private final zzcbr zzfwq;
    private boolean zzfwr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbmz(zzbpf zzbpfVar, Context context, zzbfi zzbfiVar, int i, zzbme zzbmeVar, zzcbr zzcbrVar) {
        super(zzbpfVar);
        this.zzfwr = false;
        this.zzdkm = zzbfiVar;
        this.context = context;
        this.zzfvw = i;
        this.zzfwl = zzbmeVar;
        this.zzfwq = zzcbrVar;
    }

    public final void zza(zzsi zzsiVar) {
        zzbfi zzbfiVar = this.zzdkm;
        if (zzbfiVar != null) {
            zzbfiVar.zza(zzsiVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r6 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.content.Context] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(Activity activity, zzsw zzswVar, boolean z) {
        Activity activity2;
        if (activity == null) {
            activity2 = this.context;
        }
        boolean z2 = false;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpj)).booleanValue()) {
            com.google.android.gms.ads.internal.zzr.zzkv();
            if (com.google.android.gms.ads.internal.util.zzj.zzat(activity2)) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                zzswVar.zzb(zzdqh.zza(zzdqj.APP_NOT_FOREGROUND, null, null));
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcpk)).booleanValue()) {
                    new zzdvj(activity2.getApplicationContext(), com.google.android.gms.ads.internal.zzr.zzlj().zzaai()).zzhg(this.zzftl.zzhnt.zzeuy.zzbwe);
                }
                if (z2) {
                    return;
                }
                try {
                    this.zzfwq.zza(z, activity2);
                    this.zzfwr = true;
                    return;
                } catch (zzcbq e2) {
                    zzswVar.zzb(zzdqh.zzh(e2));
                    return;
                }
            }
        }
        if (this.zzfwr) {
            com.google.android.gms.ads.internal.util.zzd.zzez("App open interstitial ad is already visible.");
        }
        if (!this.zzfwr) {
            z2 = true;
        }
        if (z2) {
        }
    }

    public final int zzakb() {
        return this.zzfvw;
    }

    public final void zzb(long j, int i) {
        this.zzfwl.zzb(j, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final void destroy() {
        super.destroy();
        zzbfi zzbfiVar = this.zzdkm;
        if (zzbfiVar != null) {
            zzbfiVar.destroy();
        }
    }
}
