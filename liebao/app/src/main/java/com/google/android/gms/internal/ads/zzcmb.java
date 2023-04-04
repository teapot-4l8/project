package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public final class zzcmb {
    private final Executor executor;
    private final zzcmg zzgob;
    private final Map<String, String> zzgof;

    public zzcmb(zzcmg zzcmgVar, Executor executor) {
        this.zzgob = zzcmgVar;
        this.zzgof = zzcmgVar.zzarq();
        this.executor = executor;
    }

    public final zzcma zzarp() {
        return zzcma.zzb(new zzcma(this));
    }
}
