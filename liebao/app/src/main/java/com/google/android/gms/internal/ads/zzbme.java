package com.google.android.gms.internal.ads;

import com.umeng.analytics.pro.ak;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbme {
    private final zzcmb zzdje;
    private final zzdtw zzdjf;
    private final zzdpi zzfbh;

    public zzbme(zzcmb zzcmbVar, zzdpi zzdpiVar, zzdtw zzdtwVar) {
        this.zzdjf = zzdtwVar;
        this.zzdje = zzcmbVar;
        this.zzfbh = zzdpiVar;
    }

    public final void zzb(long j, int i) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
            this.zzdjf.zzb(zzdtx.zzgy("ad_closed").zzb(this.zzfbh.zzhnt.zzeuy).zzw("show_time", String.valueOf(j)).zzw("ad_format", "app_open_ad").zzw("acr", zzee(i)));
        } else {
            this.zzdje.zzarp().zza(this.zzfbh.zzhnt.zzeuy).zzs("action", "ad_closed").zzs("show_time", String.valueOf(j)).zzs("ad_format", "app_open_ad").zzs("acr", zzee(i)).zzarm();
        }
    }

    private static String zzee(int i) {
        int i2 = zzbmh.zzfwh[i - 1];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? ak.aG : "cb" : "ac" : "cc" : "h" : "bb";
    }
}
