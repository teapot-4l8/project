package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbpw implements zzesa<zzdpi> {
    private final zzbps zzfzb;

    private zzbpw(zzbps zzbpsVar) {
        this.zzfzb = zzbpsVar;
    }

    public static zzbpw zze(zzbps zzbpsVar) {
        return new zzbpw(zzbpsVar);
    }

    public static zzdpi zzf(zzbps zzbpsVar) {
        return (zzdpi) zzesg.zzbd(zzbpsVar.zzalq());
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzf(this.zzfzb);
    }
}
