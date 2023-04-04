package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdge implements zzesa<zzdgb> {
    private final zzesn<String> zzgno;
    private final zzesn<String> zzhfp;

    private zzdge(zzesn<String> zzesnVar, zzesn<String> zzesnVar2) {
        this.zzgno = zzesnVar;
        this.zzhfp = zzesnVar2;
    }

    public static zzdge zzba(zzesn<String> zzesnVar, zzesn<String> zzesnVar2) {
        return new zzdge(zzesnVar, zzesnVar2);
    }

    public static zzdgb zzv(String str, String str2) {
        return new zzdgb(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzv(this.zzgno.get(), this.zzhfp.get());
    }
}
