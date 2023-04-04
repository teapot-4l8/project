package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdae implements zzesa<zzczm> {
    private final zzesn<zzdtw> zzgma;

    private zzdae(zzesn<zzdtw> zzesnVar) {
        this.zzgma = zzesnVar;
    }

    public static zzdae zzaj(zzesn<zzdtw> zzesnVar) {
        return new zzdae(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzczm(this.zzgma.get());
    }
}
