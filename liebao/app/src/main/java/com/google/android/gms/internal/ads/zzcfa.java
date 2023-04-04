package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcfa implements zzesa<zzcev> {
    private final zzesn<zzcdz> zzfko;
    private final zzesn<zzchu> zzflr;
    private final zzesn<zzcja> zzgiz;
    private final zzesn<zzblv> zzgja;

    public zzcfa(zzesn<zzcja> zzesnVar, zzesn<zzchu> zzesnVar2, zzesn<zzblv> zzesnVar3, zzesn<zzcdz> zzesnVar4) {
        this.zzgiz = zzesnVar;
        this.zzflr = zzesnVar2;
        this.zzgja = zzesnVar3;
        this.zzfko = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcev(this.zzgiz.get(), this.zzflr.get(), this.zzgja.get(), this.zzfko.get());
    }
}
