package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfn implements zzesa<zzdfk> {
    private final zzesn<com.google.android.gms.ads.internal.util.zzf> zzeck;
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<PackageInfo> zzgay;

    public zzdfn(zzesn<zzebs> zzesnVar, zzesn<zzdpm> zzesnVar2, zzesn<PackageInfo> zzesnVar3, zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar4) {
        this.zzeyl = zzesnVar;
        this.zzfxn = zzesnVar2;
        this.zzgay = zzesnVar3;
        this.zzeck = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdfk(this.zzeyl.get(), this.zzfxn.get(), this.zzgay.get(), this.zzeck.get());
    }
}
