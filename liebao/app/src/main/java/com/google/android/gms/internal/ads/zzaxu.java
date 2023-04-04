package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaxu implements zzesa<zzaxv> {
    private final zzesn<zzayd> zzecg;
    private final zzesn<com.google.android.gms.ads.internal.util.zzf> zzeck;

    public zzaxu(zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar, zzesn<zzayd> zzesnVar2) {
        this.zzeck = zzesnVar;
        this.zzecg = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzaxv(this.zzeck.get(), this.zzecg.get());
    }
}
