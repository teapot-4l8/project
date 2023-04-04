package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbql implements zzesa<zzbzl<zzve>> {
    private final zzbqi zzfzt;
    private final zzesn<zzbqr> zzfzu;

    private zzbql(zzbqi zzbqiVar, zzesn<zzbqr> zzesnVar) {
        this.zzfzt = zzbqiVar;
        this.zzfzu = zzesnVar;
    }

    public static zzbql zzb(zzbqi zzbqiVar, zzesn<zzbqr> zzesnVar) {
        return new zzbql(zzbqiVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfzu.get(), zzbat.zzekj));
    }
}
