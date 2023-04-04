package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbpv implements zzesa<zzdot> {
    private final zzbps zzfzb;

    private zzbpv(zzbps zzbpsVar) {
        this.zzfzb = zzbpsVar;
    }

    public static zzbpv zzc(zzbps zzbpsVar) {
        return new zzbpv(zzbpsVar);
    }

    public static zzdot zzd(zzbps zzbpsVar) {
        return (zzdot) zzesg.zzbd(zzbpsVar.zzalr());
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzd(this.zzfzb);
    }
}
