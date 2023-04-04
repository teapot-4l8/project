package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcns implements zzesa<zzcno> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzebs> zzgqh;
    private final zzesn<zzcoz> zzgqi;
    private final zzesn<zzcqb> zzgqj;

    private zzcns(zzesn<zzebs> zzesnVar, zzesn<zzebs> zzesnVar2, zzesn<zzcoz> zzesnVar3, zzesn<zzcqb> zzesnVar4) {
        this.zzgqh = zzesnVar;
        this.zzeyl = zzesnVar2;
        this.zzgqi = zzesnVar3;
        this.zzgqj = zzesnVar4;
    }

    public static zzcns zzd(zzesn<zzebs> zzesnVar, zzesn<zzebs> zzesnVar2, zzesn<zzcoz> zzesnVar3, zzesn<zzcqb> zzesnVar4) {
        return new zzcns(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcno(this.zzgqh.get(), this.zzeyl.get(), this.zzgqi.get(), zzesb.zzat(this.zzgqj));
    }
}
