package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcmn implements zzesa<zzcmk> {
    private final zzesn<String> zzgox;
    private final zzesn<zzcmg> zzgoy;

    public zzcmn(zzesn<String> zzesnVar, zzesn<zzcmg> zzesnVar2) {
        this.zzgox = zzesnVar;
        this.zzgoy = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcmk(this.zzgox.get(), this.zzgoy.get());
    }
}
