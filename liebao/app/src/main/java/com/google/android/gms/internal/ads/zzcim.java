package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcim implements zzesa<zzcin> {
    private final zzesn<zzbty> zzfio;
    private final zzesn<zzdot> zzfua;

    public zzcim(zzesn<zzbty> zzesnVar, zzesn<zzdot> zzesnVar2) {
        this.zzfio = zzesnVar;
        this.zzfua = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcin(this.zzfio.get(), this.zzfua.get());
    }
}
