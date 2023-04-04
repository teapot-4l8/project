package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbko implements zzesa<zzbkp> {
    private final zzesn<com.google.android.gms.ads.internal.util.zzf> zzeck;

    private zzbko(zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar) {
        this.zzeck = zzesnVar;
    }

    public static zzbko zza(zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar) {
        return new zzbko(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbkp(this.zzeck.get());
    }
}
