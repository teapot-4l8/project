package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwp implements zzesa<zzcwm> {
    private final zzesn<zzcjw> zzezi;
    private final zzesn<zzcmb> zzfac;
    private final zzesn<zzdpz> zzfaq;
    private final zzesn<zzdtw> zzgma;

    private zzcwp(zzesn<zzdpz> zzesnVar, zzesn<zzcjw> zzesnVar2, zzesn<zzcmb> zzesnVar3, zzesn<zzdtw> zzesnVar4) {
        this.zzfaq = zzesnVar;
        this.zzezi = zzesnVar2;
        this.zzfac = zzesnVar3;
        this.zzgma = zzesnVar4;
    }

    public static zzcwp zze(zzesn<zzdpz> zzesnVar, zzesn<zzcjw> zzesnVar2, zzesn<zzcmb> zzesnVar3, zzesn<zzdtw> zzesnVar4) {
        return new zzcwp(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcwm(this.zzfaq.get(), this.zzezi.get(), this.zzfac.get(), this.zzgma.get());
    }
}
