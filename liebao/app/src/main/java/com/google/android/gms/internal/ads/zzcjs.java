package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcjs implements zzesa<zzcjt> {
    private final zzesn<zzbfi> zzfxc;

    private zzcjs(zzesn<zzbfi> zzesnVar) {
        this.zzfxc = zzesnVar;
    }

    public static zzcjs zzaa(zzesn<zzbfi> zzesnVar) {
        return new zzcjs(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcjt(this.zzfxc.get());
    }
}
