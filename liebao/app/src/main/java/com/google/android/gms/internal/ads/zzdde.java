package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdde implements zzesa<zzdcx> {
    private final zzesn<zzckb> zzeyj;
    private final zzesn<zzcna> zzezu;
    private final zzesn<zzdcz> zzfam;
    private final zzesn<zzebs> zzhdg;

    private zzdde(zzesn<zzebs> zzesnVar, zzesn<zzckb> zzesnVar2, zzesn<zzcna> zzesnVar3, zzesn<zzdcz> zzesnVar4) {
        this.zzhdg = zzesnVar;
        this.zzeyj = zzesnVar2;
        this.zzezu = zzesnVar3;
        this.zzfam = zzesnVar4;
    }

    public static zzdde zzh(zzesn<zzebs> zzesnVar, zzesn<zzckb> zzesnVar2, zzesn<zzcna> zzesnVar3, zzesn<zzdcz> zzesnVar4) {
        return new zzdde(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdcx(this.zzhdg.get(), this.zzeyj.get(), this.zzezu.get(), this.zzfam.get());
    }
}
