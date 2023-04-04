package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdos implements zzesa<zzdon> {
    private final zzesn<zzdph> zzfri;
    private final zzesn<zzdnz> zzhbo;
    private final zzesn<zzdnb> zzhij;

    public zzdos(zzesn<zzdnz> zzesnVar, zzesn<zzdnb> zzesnVar2, zzesn<zzdph> zzesnVar3) {
        this.zzhbo = zzesnVar;
        this.zzhij = zzesnVar2;
        this.zzfri = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdon(this.zzhbo.get(), this.zzhij.get(), this.zzfri.get());
    }
}
