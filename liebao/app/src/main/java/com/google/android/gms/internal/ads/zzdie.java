package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdie implements zzesa<zzdic> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzaum> zzfad;
    private final zzesn<String> zzgaw;

    public zzdie(zzesn<zzaum> zzesnVar, zzesn<Context> zzesnVar2, zzesn<String> zzesnVar3, zzesn<zzebs> zzesnVar4) {
        this.zzfad = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzgaw = zzesnVar3;
        this.zzeyl = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdic(this.zzfad.get(), this.zzeyq.get(), this.zzgaw.get(), this.zzeyl.get());
    }
}
