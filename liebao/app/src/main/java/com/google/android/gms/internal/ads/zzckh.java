package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzckh implements zzesa<zzckd> {
    private final zzesn<Executor> zzeyl;

    public zzckh(zzesn<Executor> zzesnVar) {
        this.zzeyl = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzckd(this.zzeyl.get());
    }
}
