package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbow implements zzesa<zzbox> {
    private final zzesn<zzdot> zzfua;
    private final zzesn<zzbtl> zzfyc;
    private final zzesn<zzbun> zzfyd;

    private zzbow(zzesn<zzdot> zzesnVar, zzesn<zzbtl> zzesnVar2, zzesn<zzbun> zzesnVar3) {
        this.zzfua = zzesnVar;
        this.zzfyc = zzesnVar2;
        this.zzfyd = zzesnVar3;
    }

    public static zzbow zzf(zzesn<zzdot> zzesnVar, zzesn<zzbtl> zzesnVar2, zzesn<zzbun> zzesnVar3) {
        return new zzbow(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbox(this.zzfua.get(), this.zzfyc.get(), this.zzfyd.get());
    }
}
