package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcby implements zzesa<zzcbz> {
    private final zzesn<zzcdy> zzfxe;
    private final zzesn<Map<String, zzcsz<zzbpi>>> zzfyt;
    private final zzesn<Map<String, zzcsz<zzcdf>>> zzgdz;
    private final zzesn<Map<String, zzcvm<zzcdf>>> zzgea;
    private final zzesn<zzbph<zzbne>> zzgeb;

    public zzcby(zzesn<Map<String, zzcsz<zzbpi>>> zzesnVar, zzesn<Map<String, zzcsz<zzcdf>>> zzesnVar2, zzesn<Map<String, zzcvm<zzcdf>>> zzesnVar3, zzesn<zzbph<zzbne>> zzesnVar4, zzesn<zzcdy> zzesnVar5) {
        this.zzfyt = zzesnVar;
        this.zzgdz = zzesnVar2;
        this.zzgea = zzesnVar3;
        this.zzgeb = zzesnVar4;
        this.zzfxe = zzesnVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcbz(this.zzfyt.get(), this.zzgdz.get(), this.zzgea.get(), this.zzgeb, this.zzfxe.get());
    }
}
