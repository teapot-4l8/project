package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzcrk implements Callable {
    private final zzcrj zzgsy;

    private zzcrk(zzcrj zzcrjVar) {
        this.zzgsy = zzcrjVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Callable zza(zzcrj zzcrjVar) {
        return new zzcrk(zzcrjVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzgsy.getWritableDatabase();
    }
}
