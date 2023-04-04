package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcvv implements zzesa<zzcvp> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzcgb> zzffy;
    private final zzesn<zzccf> zzgvz;
    private final zzesn<zzdqc<zzchu>> zzgxr;

    public zzcvv(zzesn<zzccf> zzesnVar, zzesn<zzebs> zzesnVar2, zzesn<zzcgb> zzesnVar3, zzesn<zzdqc<zzchu>> zzesnVar4) {
        this.zzgvz = zzesnVar;
        this.zzeyl = zzesnVar2;
        this.zzffy = zzesnVar3;
        this.zzgxr = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcvp(this.zzgvz.get(), this.zzeyl.get(), this.zzffy.get(), this.zzgxr.get());
    }
}
