package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcdp implements zzesa<zzcdm> {
    private final zzesn<zzcdd> zzggr;

    private zzcdp(zzesn<zzcdd> zzesnVar) {
        this.zzggr = zzesnVar;
    }

    public static zzcdp zzz(zzesn<zzcdd> zzesnVar) {
        return new zzcdp(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcdm(this.zzggr.get());
    }
}
