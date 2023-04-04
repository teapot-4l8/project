package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbzs implements zzesa<zzbzt> {
    private final zzesn<zzdup> zzfab;
    private final zzesn<zzdot> zzfua;

    private zzbzs(zzesn<zzdot> zzesnVar, zzesn<zzdup> zzesnVar2) {
        this.zzfua = zzesnVar;
        this.zzfab = zzesnVar2;
    }

    public static zzbzs zzs(zzesn<zzdot> zzesnVar, zzesn<zzdup> zzesnVar2) {
        return new zzbzs(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbzt(this.zzfua.get(), this.zzfab.get());
    }
}
