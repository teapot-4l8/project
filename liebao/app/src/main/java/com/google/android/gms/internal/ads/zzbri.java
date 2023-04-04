package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbri implements zzesa<zzbzl<com.google.android.gms.ads.internal.overlay.zzp>> {
    private final zzesn<zzbpz> zzfvz;
    private final zzbra zzgad;

    private zzbri(zzbra zzbraVar, zzesn<zzbpz> zzesnVar) {
        this.zzgad = zzbraVar;
        this.zzfvz = zzesnVar;
    }

    public static zzbri zza(zzbra zzbraVar, zzesn<zzbpz> zzesnVar) {
        return new zzbri(zzbraVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), zzbat.zzekj));
    }
}
