package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsj;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwc implements zzesa<zzcwd> {
    private final zzesn<zzbhh> zzgeh;
    private final zzesn<zzbsj.zza> zzgei;
    private final zzesn<zzbxr> zzgej;
    private final zzesn<zzccb> zzgek;

    public zzcwc(zzesn<zzbhh> zzesnVar, zzesn<zzccb> zzesnVar2, zzesn<zzbsj.zza> zzesnVar3, zzesn<zzbxr> zzesnVar4) {
        this.zzgeh = zzesnVar;
        this.zzgek = zzesnVar2;
        this.zzgei = zzesnVar3;
        this.zzgej = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcwd(this.zzgeh.get(), this.zzgek.get(), this.zzgei.get(), this.zzgej.get());
    }
}
