package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzds;
import com.google.android.gms.internal.ads.zzduv;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzh implements Runnable {
    private final /* synthetic */ boolean zzbpm;
    private final /* synthetic */ zzf zzbpn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(zzf zzfVar, boolean z) {
        this.zzbpn = zzfVar;
        this.zzbpm = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzduv zzduvVar;
        zzbar zzbarVar;
        Context context;
        Context zze;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzbarVar = this.zzbpn.zzbpk;
            String str = zzbarVar.zzbrz;
            zzf zzfVar = this.zzbpn;
            context = this.zzbpn.zzbpi;
            zze = zzf.zze(context);
            zzds.zza(str, zze, this.zzbpm).zzbu();
        } catch (NullPointerException e2) {
            zzduvVar = this.zzbpn.zzxh;
            zzduvVar.zza(2027, System.currentTimeMillis() - currentTimeMillis, e2);
        }
    }
}
