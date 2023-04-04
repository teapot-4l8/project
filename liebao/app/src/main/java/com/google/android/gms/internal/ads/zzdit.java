package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdit implements zzesa<zzdir> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzazk> zzfad;
    private final zzesn<String> zzgaw;

    public zzdit(zzesn<zzazk> zzesnVar, zzesn<zzebs> zzesnVar2, zzesn<String> zzesnVar3) {
        this.zzfad = zzesnVar;
        this.zzeyl = zzesnVar2;
        this.zzgaw = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdir(this.zzfad.get(), this.zzeyl.get(), this.zzgaw.get());
    }
}
