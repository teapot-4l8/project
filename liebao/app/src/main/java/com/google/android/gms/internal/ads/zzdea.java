package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdea implements zzesa<zzddy> {
    private final zzesn<zzdlr> zzgan;

    private zzdea(zzesn<zzdlr> zzesnVar) {
        this.zzgan = zzesnVar;
    }

    public static zzdea zzam(zzesn<zzdlr> zzesnVar) {
        return new zzdea(zzesnVar);
    }

    public static zzddy zzb(zzdlr zzdlrVar) {
        return new zzddy(zzdlrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzb(this.zzgan.get());
    }
}
