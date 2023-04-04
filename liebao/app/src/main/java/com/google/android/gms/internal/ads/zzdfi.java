package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfi implements zzesa<zzdfg> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzdor> zzgww;

    private zzdfi(zzesn<zzebs> zzesnVar, zzesn<zzdor> zzesnVar2) {
        this.zzeyl = zzesnVar;
        this.zzgww = zzesnVar2;
    }

    public static zzdfi zzax(zzesn<zzebs> zzesnVar, zzesn<zzdor> zzesnVar2) {
        return new zzdfi(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdfg(this.zzeyl.get(), this.zzgww.get());
    }
}
