package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbpy implements zzesa<zzbpz> {
    private final zzesn<zzbty> zzfio;

    private zzbpy(zzesn<zzbty> zzesnVar) {
        this.zzfio = zzesnVar;
    }

    public static zzbpy zze(zzesn<zzbty> zzesnVar) {
        return new zzbpy(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbpz(this.zzfio.get());
    }
}
