package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcaw implements zzesa<zzaya> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdpm> zzfxn;
    private final zzcak zzgdr;

    private zzcaw(zzcak zzcakVar, zzesn<Context> zzesnVar, zzesn<zzdpm> zzesnVar2) {
        this.zzgdr = zzcakVar;
        this.zzeyq = zzesnVar;
        this.zzfxn = zzesnVar2;
    }

    public static zzcaw zza(zzcak zzcakVar, zzesn<Context> zzesnVar, zzesn<zzdpm> zzesnVar2) {
        return new zzcaw(zzcakVar, zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzaya) zzesg.zzbd(new zzaya(this.zzeyq.get(), this.zzfxn.get().zzhny));
    }
}
