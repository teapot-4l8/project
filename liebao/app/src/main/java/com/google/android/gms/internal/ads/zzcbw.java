package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zzuh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcbw implements zzesa<zzcbx> {
    private final zzesn<zzayd> zzecg;
    private final zzesn<Context> zzeyq;
    private final zzesn<View> zzfub;
    private final zzesn<zzuh.zza.EnumC0120zza> zzfvk;
    private final zzesn<zzaya> zzfyk;

    private zzcbw(zzesn<zzaya> zzesnVar, zzesn<Context> zzesnVar2, zzesn<zzayd> zzesnVar3, zzesn<View> zzesnVar4, zzesn<zzuh.zza.EnumC0120zza> zzesnVar5) {
        this.zzfyk = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzecg = zzesnVar3;
        this.zzfub = zzesnVar4;
        this.zzfvk = zzesnVar5;
    }

    public static zzcbw zzd(zzesn<zzaya> zzesnVar, zzesn<Context> zzesnVar2, zzesn<zzayd> zzesnVar3, zzesn<View> zzesnVar4, zzesn<zzuh.zza.EnumC0120zza> zzesnVar5) {
        return new zzcbw(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcbx(this.zzfyk.get(), this.zzeyq.get(), this.zzecg.get(), this.zzfub.get(), this.zzfvk.get());
    }
}
