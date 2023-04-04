package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbho implements zzesa<Set<zzbzl<zzbyw>>> {
    private final zzesn<zzcqz> zzeyk;
    private final zzesn<Executor> zzeyl;

    public zzbho(zzesn<zzcqz> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzeyk = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        Set emptySet;
        zzcqz zzcqzVar = this.zzeyk.get();
        Executor executor = this.zzeyl.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsg)).booleanValue()) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
                emptySet = Collections.singleton(new zzbzl(zzcqzVar, executor));
                return (Set) zzesg.zzbd(emptySet);
            }
        }
        emptySet = Collections.emptySet();
        return (Set) zzesg.zzbd(emptySet);
    }
}
