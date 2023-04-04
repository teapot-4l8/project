package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbnz implements zzesa<zzbzl<zzqw>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbpb> zzfvz;
    private final zzbnl zzfxk;

    public zzbnz(zzbnl zzbnlVar, zzesn<zzbpb> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzfxk = zzbnlVar;
        this.zzfvz = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), this.zzeyl.get()));
    }
}
