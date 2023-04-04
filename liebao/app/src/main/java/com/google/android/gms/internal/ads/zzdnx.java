package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdnx implements zzesa<zzdnb> {
    private final zzesn<zzdqs> zzhja;

    private zzdnx(zzesn<zzdqs> zzesnVar) {
        this.zzhja = zzesnVar;
    }

    public static zzdnx zzaq(zzesn<zzdqs> zzesnVar) {
        return new zzdnx(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdnb(this.zzhja.get());
    }
}
