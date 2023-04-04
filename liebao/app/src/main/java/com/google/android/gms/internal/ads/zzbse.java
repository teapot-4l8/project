package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbse implements zzesa<zzbsc> {
    private final zzesn<com.google.android.gms.ads.internal.util.zzf> zzeck;
    private final zzesn<zzdhd<Bundle>> zzfeu;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<zzdtg> zzfxq;
    private final zzesn<ApplicationInfo> zzgav;
    private final zzesn<String> zzgaw;
    private final zzesn<List<String>> zzgax;
    private final zzesn<PackageInfo> zzgay;
    private final zzesn<zzebt<String>> zzgaz;
    private final zzesn<String> zzgba;

    private zzbse(zzesn<zzdtg> zzesnVar, zzesn<zzbar> zzesnVar2, zzesn<ApplicationInfo> zzesnVar3, zzesn<String> zzesnVar4, zzesn<List<String>> zzesnVar5, zzesn<PackageInfo> zzesnVar6, zzesn<zzebt<String>> zzesnVar7, zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar8, zzesn<String> zzesnVar9, zzesn<zzdhd<Bundle>> zzesnVar10) {
        this.zzfxq = zzesnVar;
        this.zzfvj = zzesnVar2;
        this.zzgav = zzesnVar3;
        this.zzgaw = zzesnVar4;
        this.zzgax = zzesnVar5;
        this.zzgay = zzesnVar6;
        this.zzgaz = zzesnVar7;
        this.zzeck = zzesnVar8;
        this.zzgba = zzesnVar9;
        this.zzfeu = zzesnVar10;
    }

    public static zzbse zza(zzesn<zzdtg> zzesnVar, zzesn<zzbar> zzesnVar2, zzesn<ApplicationInfo> zzesnVar3, zzesn<String> zzesnVar4, zzesn<List<String>> zzesnVar5, zzesn<PackageInfo> zzesnVar6, zzesn<zzebt<String>> zzesnVar7, zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar8, zzesn<String> zzesnVar9, zzesn<zzdhd<Bundle>> zzesnVar10) {
        return new zzbse(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5, zzesnVar6, zzesnVar7, zzesnVar8, zzesnVar9, zzesnVar10);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbsc(this.zzfxq.get(), this.zzfvj.get(), this.zzgav.get(), this.zzgaw.get(), this.zzgax.get(), this.zzgay.get(), zzesb.zzat(this.zzgaz), this.zzeck.get(), this.zzgba.get(), this.zzfeu.get());
    }
}
