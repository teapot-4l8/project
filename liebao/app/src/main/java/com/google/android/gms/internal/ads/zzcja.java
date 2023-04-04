package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcja {
    private final Context context;
    private final zzbar zzbpx;
    private final zzbfq zzbqk;
    private final zztz zzesy;
    private final zzei zzeus;
    private final zzacv zzeut;
    private final com.google.android.gms.ads.internal.zzb zzeuv;
    private final zzbve zzgmh;

    public zzcja(zzbfq zzbfqVar, Context context, zzei zzeiVar, zzacv zzacvVar, zzbar zzbarVar, com.google.android.gms.ads.internal.zzb zzbVar, zztz zztzVar, zzbve zzbveVar) {
        this.zzbqk = zzbfqVar;
        this.context = context;
        this.zzeus = zzeiVar;
        this.zzeut = zzacvVar;
        this.zzbpx = zzbarVar;
        this.zzeuv = zzbVar;
        this.zzesy = zztzVar;
        this.zzgmh = zzbveVar;
    }

    public final zzbfi zze(zzvt zzvtVar) {
        return zza(zzvtVar, null, null);
    }

    public final zzbfi zza(zzvt zzvtVar, zzdot zzdotVar, zzdoy zzdoyVar) {
        return zzbfq.zza(this.context, zzbgx.zzb(zzvtVar), zzvtVar.zzadd, false, false, this.zzeus, this.zzeut, this.zzbpx, null, new zzcjd(this), this.zzeuv, this.zzesy, zzdotVar, zzdoyVar);
    }
}
