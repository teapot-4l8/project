package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbls implements zzesa<Set<zzbzl<com.google.android.gms.ads.internal.overlay.zzp>>> {
    private final zzesn<zzbli> zzeyk;
    private final zzesn<Executor> zzeyl;
    private final zzesn<JSONObject> zzfvl;

    private zzbls(zzesn<zzbli> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<JSONObject> zzesnVar3) {
        this.zzeyk = zzesnVar;
        this.zzeyl = zzesnVar2;
        this.zzfvl = zzesnVar3;
    }

    public static zzbls zzd(zzesn<zzbli> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<JSONObject> zzesnVar3) {
        return new zzbls(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        Set singleton;
        zzbli zzbliVar = this.zzeyk.get();
        Executor executor = this.zzeyl.get();
        if (this.zzfvl.get() == null) {
            singleton = Collections.emptySet();
        } else {
            singleton = Collections.singleton(new zzbzl(zzbliVar, executor));
        }
        return (Set) zzesg.zzbd(singleton);
    }
}
