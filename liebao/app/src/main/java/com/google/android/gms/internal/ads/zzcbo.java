package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcbo implements zzesa<zzcsz<zzcaj>> {
    private final zzesn<zzebs> zzfxf;
    private final zzesn<zzdtg> zzfxq;
    private final zzesn<zzcvj> zzfxr;
    private final zzesn<zzcxs> zzfxs;

    public zzcbo(zzesn<zzdtg> zzesnVar, zzesn<zzebs> zzesnVar2, zzesn<zzcvj> zzesnVar3, zzesn<zzcxs> zzesnVar4) {
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
