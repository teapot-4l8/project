package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcfi implements zzesa<zzcfd> {
    private final zzesn<zzchu> zzflr;
    private final zzesn<zzcja> zzgiz;

    public zzcfi(zzesn<zzcja> zzesnVar, zzesn<zzchu> zzesnVar2) {
        this.zzgiz = zzesnVar;
        this.zzflr = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcfd(this.zzgiz.get(), this.zzflr.get());
    }
}
