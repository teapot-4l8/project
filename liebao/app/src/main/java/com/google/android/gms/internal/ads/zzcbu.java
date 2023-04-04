package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcbu implements zzesa<zzcbv> {
    private final zzesn<zzbts> zzgam;

    private zzcbu(zzesn<zzbts> zzesnVar) {
        this.zzgam = zzesnVar;
    }

    public static zzcbu zzx(zzesn<zzbts> zzesnVar) {
        return new zzcbu(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcbv(this.zzgam.get());
    }
}
