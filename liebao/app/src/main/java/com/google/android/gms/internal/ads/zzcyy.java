package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcyy implements zzesa<zzcyz> {
    private final zzesn<zzckb> zzgzb;

    private zzcyy(zzesn<zzckb> zzesnVar) {
        this.zzgzb = zzesnVar;
    }

    public static zzcyy zzai(zzesn<zzckb> zzesnVar) {
        return new zzcyy(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcyz(this.zzgzb.get());
    }
}