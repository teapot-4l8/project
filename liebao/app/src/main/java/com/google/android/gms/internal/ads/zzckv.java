package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzckv implements zzesa<Set<zzbzl<zzdtm>>> {
    private final zzesn<zzcll> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzckv(zzesn<Executor> zzesnVar, zzesn<zzcll> zzesnVar2) {
        this.zzeyl = zzesnVar;
        this.zzeyk = zzesnVar2;
    }

    public static zzckv zzac(zzesn<Executor> zzesnVar, zzesn<zzcll> zzesnVar2) {
        return new zzckv(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        Set emptySet;
        Executor executor = this.zzeyl.get();
        zzcll zzcllVar = this.zzeyk.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcwb)).booleanValue()) {
            emptySet = Collections.singleton(new zzbzl(zzcllVar, executor));
        } else {
            emptySet = Collections.emptySet();
        }
        return (Set) zzesg.zzbd(emptySet);
    }
}
