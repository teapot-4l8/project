package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcro implements zzesa<zzcrp> {
    private final zzesn<com.google.android.gms.ads.internal.util.zzf> zzecf;
    private final zzesn<zzcru> zzgtd;

    private zzcro(zzesn<zzcru> zzesnVar, zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar2) {
        this.zzgtd = zzesnVar;
        this.zzecf = zzesnVar2;
    }

    public static zzcro zzar(zzesn<zzcru> zzesnVar, zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar2) {
        return new zzcro(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcrp(this.zzgtd.get(), this.zzecf.get());
    }
}
