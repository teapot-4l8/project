package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdeg implements zzesa<zzdee> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<String> zzfvk;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzckd> zzhet;

    private zzdeg(zzesn<zzebs> zzesnVar, zzesn<zzckd> zzesnVar2, zzesn<zzdpm> zzesnVar3, zzesn<String> zzesnVar4) {
        this.zzeyl = zzesnVar;
        this.zzhet = zzesnVar2;
        this.zzfxn = zzesnVar3;
        this.zzfvk = zzesnVar4;
    }

    public static zzdeg zzi(zzesn<zzebs> zzesnVar, zzesn<zzckd> zzesnVar2, zzesn<zzdpm> zzesnVar3, zzesn<String> zzesnVar4) {
        return new zzdeg(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdee(this.zzeyl.get(), this.zzhet.get(), this.zzfxn.get(), this.zzfvk.get());
    }
}
