package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsj;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwl implements zzesa<zzcwi> {
    private final zzesn<zzbhh> zzgeh;
    private final zzesn<zzbsj.zza> zzgei;
    private final zzesn<zzbxr> zzgej;

    public zzcwl(zzesn<zzbhh> zzesnVar, zzesn<zzbsj.zza> zzesnVar2, zzesn<zzbxr> zzesnVar3) {
        this.zzgeh = zzesnVar;
        this.zzgei = zzesnVar2;
        this.zzgej = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcwi(this.zzgeh.get(), this.zzgei.get(), this.zzgej.get());
    }
}
