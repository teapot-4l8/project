package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbqk implements zzesa<zzbzl<zzbsy>> {
    private final zzbqi zzfzt;
    private final zzesn<zzbqr> zzfzu;

    private zzbqk(zzbqi zzbqiVar, zzesn<zzbqr> zzesnVar) {
        this.zzfzt = zzbqiVar;
        this.zzfzu = zzesnVar;
    }

    public static zzbqk zza(zzbqi zzbqiVar, zzesn<zzbqr> zzesnVar) {
        return new zzbqk(zzbqiVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfzu.get(), zzbat.zzekj));
    }
}
