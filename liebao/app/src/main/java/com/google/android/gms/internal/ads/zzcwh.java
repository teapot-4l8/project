package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbsj;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwh implements zzesa<zzcwe> {
    private final zzesn<zzbve> zzgaq;
    private final zzesn<zzbhh> zzgeh;
    private final zzesn<zzbsj.zza> zzgei;
    private final zzesn<zzbxr> zzgej;
    private final zzesn<zzccb> zzgek;
    private final zzesn<zzcyo> zzgxw;
    private final zzesn<ViewGroup> zzgxx;

    public zzcwh(zzesn<zzbhh> zzesnVar, zzesn<zzbsj.zza> zzesnVar2, zzesn<zzcyo> zzesnVar3, zzesn<zzbxr> zzesnVar4, zzesn<zzccb> zzesnVar5, zzesn<zzbve> zzesnVar6, zzesn<ViewGroup> zzesnVar7) {
        this.zzgeh = zzesnVar;
        this.zzgei = zzesnVar2;
        this.zzgxw = zzesnVar3;
        this.zzgej = zzesnVar4;
        this.zzgek = zzesnVar5;
        this.zzgaq = zzesnVar6;
        this.zzgxx = zzesnVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcwe(this.zzgeh.get(), this.zzgei.get(), this.zzgxw.get(), this.zzgej.get(), this.zzgek.get(), this.zzgaq.get(), this.zzgxx.get());
    }
}
