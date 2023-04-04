package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdpx implements zzesa<zzdpu> {
    private final zzesn<zzdup> zzfab;
    private final zzesn<zzdot> zzfxz;
    private final zzesn<zzcsh> zzglz;
    private final zzesn<zzdoy> zzgmb;

    private zzdpx(zzesn<zzcsh> zzesnVar, zzesn<zzdup> zzesnVar2, zzesn<zzdot> zzesnVar3, zzesn<zzdoy> zzesnVar4) {
        this.zzglz = zzesnVar;
        this.zzfab = zzesnVar2;
        this.zzfxz = zzesnVar3;
        this.zzgmb = zzesnVar4;
    }

    public static zzdpx zzk(zzesn<zzcsh> zzesnVar, zzesn<zzdup> zzesnVar2, zzesn<zzdot> zzesnVar3, zzesn<zzdoy> zzesnVar4) {
        return new zzdpx(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdpu(this.zzglz.get(), this.zzfab.get(), this.zzfxz.get(), this.zzgmb.get());
    }
}
