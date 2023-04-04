package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsj;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwj implements zzesa<zzcwg> {
    private final zzesn<zzbhh> zzgeh;
    private final zzesn<zzbsj.zza> zzgei;
    private final zzesn<zzbxr> zzgej;
    private final zzesn<zzcyo> zzgxw;

    public zzcwj(zzesn<zzbhh> zzesnVar, zzesn<zzbsj.zza> zzesnVar2, zzesn<zzcyo> zzesnVar3, zzesn<zzbxr> zzesnVar4) {
        this.zzgeh = zzesnVar;
        this.zzgei = zzesnVar2;
        this.zzgxw = zzesnVar3;
        this.zzgej = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcwg(this.zzgeh.get(), this.zzgei.get(), this.zzgxw.get(), this.zzgej.get());
    }
}
