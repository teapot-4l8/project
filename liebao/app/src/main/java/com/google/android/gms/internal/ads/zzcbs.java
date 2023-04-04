package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzuh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcbs implements zzesa<zzcbt> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<zzuh.zza.EnumC0120zza> zzfvk;
    private final zzesn<zzbfi> zzfxc;
    private final zzesn<zzdot> zzfxz;

    private zzcbs(zzesn<Context> zzesnVar, zzesn<zzbfi> zzesnVar2, zzesn<zzdot> zzesnVar3, zzesn<zzbar> zzesnVar4, zzesn<zzuh.zza.EnumC0120zza> zzesnVar5) {
        this.zzeyq = zzesnVar;
        this.zzfxc = zzesnVar2;
        this.zzfxz = zzesnVar3;
        this.zzfsw = zzesnVar4;
        this.zzfvk = zzesnVar5;
    }

    public static zzcbs zzc(zzesn<Context> zzesnVar, zzesn<zzbfi> zzesnVar2, zzesn<zzdot> zzesnVar3, zzesn<zzbar> zzesnVar4, zzesn<zzuh.zza.EnumC0120zza> zzesnVar5) {
        return new zzcbs(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcbt(this.zzeyq.get(), this.zzfxc.get(), this.zzfxz.get(), this.zzfsw.get(), this.zzfvk.get());
    }
}
