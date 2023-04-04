package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcfn implements zzesa<zzcfk> {
    private final zzesn<zzcdv> zzfkp;
    private final zzesn<zzcdr> zzgff;

    public zzcfn(zzesn<zzcdr> zzesnVar, zzesn<zzcdv> zzesnVar2) {
        this.zzgff = zzesnVar;
        this.zzfkp = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcfk(this.zzgff.get(), this.zzfkp.get());
    }
}
