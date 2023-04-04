package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcxv implements zzesa<zzcxs> {
    private final zzesn<zzcyz> zzgzb;

    private zzcxv(zzesn<zzcyz> zzesnVar) {
        this.zzgzb = zzesnVar;
    }

    public static zzcxv zzah(zzesn<zzcyz> zzesnVar) {
        return new zzcxv(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcxs(this.zzgzb.get());
    }
}
