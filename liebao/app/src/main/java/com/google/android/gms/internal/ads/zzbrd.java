package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbrd implements zzesa<zzbzl<zzve>> {
    private final zzesn<zzbvl> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzbrd(zzesn<zzbvl> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzeyk = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    public static zzbrd zzl(zzesn<zzbvl> zzesnVar, zzesn<Executor> zzesnVar2) {
        return new zzbrd(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
