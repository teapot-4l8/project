package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdom implements zzesa<zzdoh> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdph> zzfri;
    private final zzesn<String> zzhbn;
    private final zzesn<zzdnz> zzhbo;
    private final zzesn<zzdnb> zzhij;

    public zzdom(zzesn<String> zzesnVar, zzesn<zzdnz> zzesnVar2, zzesn<Context> zzesnVar3, zzesn<zzdnb> zzesnVar4, zzesn<zzdph> zzesnVar5) {
        this.zzhbn = zzesnVar;
        this.zzhbo = zzesnVar2;
        this.zzeyq = zzesnVar3;
        this.zzhij = zzesnVar4;
        this.zzfri = zzesnVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdoh(this.zzhbn.get(), this.zzhbo.get(), this.zzeyq.get(), this.zzhij.get(), this.zzfri.get());
    }
}
