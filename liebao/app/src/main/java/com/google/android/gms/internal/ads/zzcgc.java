package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcgc implements zzesa<zzcgb> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzcgf> zzgkd;
    private final zzesn<zzcgp> zzgke;

    public zzcgc(zzesn<zzebs> zzesnVar, zzesn<zzcgf> zzesnVar2, zzesn<zzcgp> zzesnVar3) {
        this.zzeyl = zzesnVar;
        this.zzgkd = zzesnVar2;
        this.zzgke = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcgb(this.zzeyl.get(), this.zzgkd.get(), this.zzgke.get());
    }
}
