package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcqy implements zzesa<zzcqz> {
    private final zzesn<zzdtw> zzgma;
    private final zzesn<String> zzgox;

    public zzcqy(zzesn<String> zzesnVar, zzesn<zzdtw> zzesnVar2) {
        this.zzgox = zzesnVar;
        this.zzgma = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcqz(this.zzgox.get(), this.zzgma.get());
    }
}
