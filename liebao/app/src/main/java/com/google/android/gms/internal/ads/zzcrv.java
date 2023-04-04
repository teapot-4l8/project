package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcrv implements zzesa<zzcrs> {
    private final zzesn<zzcrr> zzgtu;

    private zzcrv(zzesn<zzcrr> zzesnVar) {
        this.zzgtu = zzesnVar;
    }

    public static zzcrv zzag(zzesn<zzcrr> zzesnVar) {
        return new zzcrv(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcrs(this.zzgtu.get());
    }
}
