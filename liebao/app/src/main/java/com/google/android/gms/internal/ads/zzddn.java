package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzddn implements zzesa<zzddl> {
    private final zzesn<zzdqm> zzfcs;
    private final zzesn<zzbqr> zzfdm;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<String> zzhec;
    private final zzesn<String> zzhed;

    private zzddn(zzesn<String> zzesnVar, zzesn<String> zzesnVar2, zzesn<zzbqr> zzesnVar3, zzesn<zzdqm> zzesnVar4, zzesn<zzdpm> zzesnVar5) {
        this.zzhec = zzesnVar;
        this.zzhed = zzesnVar2;
        this.zzfdm = zzesnVar3;
        this.zzfcs = zzesnVar4;
        this.zzfxn = zzesnVar5;
    }

    public static zzddn zzh(zzesn<String> zzesnVar, zzesn<String> zzesnVar2, zzesn<zzbqr> zzesnVar3, zzesn<zzdqm> zzesnVar4, zzesn<zzdpm> zzesnVar5) {
        return new zzddn(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzddl(this.zzhec.get(), this.zzhed.get(), this.zzfdm.get(), this.zzfcs.get(), this.zzfxn.get());
    }
}
