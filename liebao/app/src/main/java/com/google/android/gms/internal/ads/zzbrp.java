package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbrp implements zzesa<zzbzl<zzbtp>> {
    private final zzesn<zzbsa> zzeyk;
    private final zzbra zzgad;

    private zzbrp(zzbra zzbraVar, zzesn<zzbsa> zzesnVar) {
        this.zzgad = zzbraVar;
        this.zzeyk = zzesnVar;
    }

    public static zzbrp zzc(zzbra zzbraVar, zzesn<zzbsa> zzesnVar) {
        return new zzbrp(zzbraVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), zzbat.zzekj));
    }
}
