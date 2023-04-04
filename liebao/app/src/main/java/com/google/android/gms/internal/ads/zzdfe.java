package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfe implements zzesa<zzdfc> {
    private final zzesn<zzebs> zzeyl;

    private zzdfe(zzesn<zzebs> zzesnVar) {
        this.zzeyl = zzesnVar;
    }

    public static zzdfe zzao(zzesn<zzebs> zzesnVar) {
        return new zzdfe(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdfc(this.zzeyl.get());
    }
}
