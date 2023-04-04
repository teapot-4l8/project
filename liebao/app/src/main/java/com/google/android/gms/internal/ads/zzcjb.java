package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcjb implements zzesa<zzcsz<zzcip>> {
    private final zzesn<zzebs> zzfxf;
    private final zzesn<zzdtg> zzfxq;
    private final zzesn<zzcwx> zzfxr;
    private final zzesn<zzcxs> zzfxs;

    public zzcjb(zzesn<zzdtg> zzesnVar, zzesn<zzebs> zzesnVar2, zzesn<zzcwx> zzesnVar3, zzesn<zzcxs> zzesnVar4) {
        this.zzfxq = zzesnVar;
        this.zzfxf = zzesnVar2;
        this.zzfxr = zzesnVar3;
        this.zzfxs = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzcsz) zzesg.zzbd(new zzcxw(this.zzfxq.get(), this.zzfxf.get(), this.zzfxs.get(), this.zzfxr.get()));
    }
}
