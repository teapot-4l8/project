package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbqz implements zzesa<zzbpf> {
    private final zzesn<zzbts> zzfie;
    private final zzesn<zzbvl> zzfif;
    private final zzesn<zzbui> zzfjn;
    private final zzesn<zzdpi> zzftz;
    private final zzesn<zzdot> zzfxz;
    private final zzesn<zzdmi> zzfzx;
    private final zzesn<zzbsp> zzfzy;

    private zzbqz(zzesn<zzdpi> zzesnVar, zzesn<zzdot> zzesnVar2, zzesn<zzbts> zzesnVar3, zzesn<zzbui> zzesnVar4, zzesn<zzdmi> zzesnVar5, zzesn<zzbsp> zzesnVar6, zzesn<zzbvl> zzesnVar7) {
        this.zzftz = zzesnVar;
        this.zzfxz = zzesnVar2;
        this.zzfie = zzesnVar3;
        this.zzfjn = zzesnVar4;
        this.zzfzx = zzesnVar5;
        this.zzfzy = zzesnVar6;
        this.zzfif = zzesnVar7;
    }

    public static zzbqz zza(zzesn<zzdpi> zzesnVar, zzesn<zzdot> zzesnVar2, zzesn<zzbts> zzesnVar3, zzesn<zzbui> zzesnVar4, zzesn<zzdmi> zzesnVar5, zzesn<zzbsp> zzesnVar6, zzesn<zzbvl> zzesnVar7) {
        return new zzbqz(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5, zzesnVar6, zzesnVar7);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbpf(this.zzftz.get(), this.zzfxz.get(), this.zzfie.get(), this.zzfjn.get(), this.zzfzx.get(), this.zzfzy.get(), this.zzfif.get());
    }
}
