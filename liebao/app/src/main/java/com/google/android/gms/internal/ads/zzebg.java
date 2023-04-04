package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzebg<V> extends zzebd<V> implements zzebt<V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzebd
    /* renamed from: zzbbd */
    public abstract zzebt<? extends V> zzbbc();

    @Override // com.google.android.gms.internal.ads.zzebt
    public void addListener(Runnable runnable, Executor executor) {
        zzbbc().addListener(runnable, executor);
    }
}
