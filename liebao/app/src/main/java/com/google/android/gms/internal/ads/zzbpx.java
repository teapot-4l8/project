package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbpx implements zzesa<zzdoy> {
    private final zzbps zzfzb;

    private zzbpx(zzbps zzbpsVar) {
        this.zzfzb = zzbpsVar;
    }

    public static zzbpx zzg(zzbps zzbpsVar) {
        return new zzbpx(zzbpsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzdoy) zzesg.zzbd(this.zzfzb.zzals());
    }
}
