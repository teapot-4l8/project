package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbbk implements zzebi<T> {
    private final /* synthetic */ zzbbh zzeku;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbk(zzbbh zzbbhVar) {
        this.zzeku = zzbbhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void onSuccess(T t) {
        AtomicInteger atomicInteger;
        atomicInteger = this.zzeku.zzekr;
        atomicInteger.set(1);
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        AtomicInteger atomicInteger;
        atomicInteger = this.zzeku.zzekr;
        atomicInteger.set(-1);
    }
}
