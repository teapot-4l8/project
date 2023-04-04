package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdgw implements zzesa<zzdgu> {
    private final zzesn<zzdmp> zzgan;

    private zzdgw(zzesn<zzdmp> zzesnVar) {
        this.zzgan = zzesnVar;
    }

    public static zzdgw zzap(zzesn<zzdmp> zzesnVar) {
        return new zzdgw(zzesnVar);
    }

    public static zzdgu zzb(zzdmp zzdmpVar) {
        return new zzdgu(zzdmpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzb(this.zzgan.get());
    }
}
