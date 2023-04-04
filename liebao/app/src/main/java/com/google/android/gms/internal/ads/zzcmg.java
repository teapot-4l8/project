package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public final class zzcmg extends zzcmj {
    private final zzdue zzgom;

    public zzcmg(Executor executor, zzbas zzbasVar, zzdue zzdueVar, zzdug zzdugVar) {
        super(executor, zzbasVar, zzdugVar);
        this.zzgom = zzdueVar;
        zzarr();
    }

    public final Map<String, String> zzarq() {
        return new HashMap(this.zzgof);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcmj
    public final void zzarr() {
        this.zzgom.zzq(this.zzgof);
    }
}
