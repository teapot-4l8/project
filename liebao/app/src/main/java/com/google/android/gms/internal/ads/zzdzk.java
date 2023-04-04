package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzdzk extends zzdzy<F, T> {
    private final /* synthetic */ zzdzh zzibf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdzk(zzdzh zzdzhVar, ListIterator listIterator) {
        super(listIterator);
        this.zzibf = zzdzhVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdzv
    public final T zzae(F f) {
        return this.zzibf.zzibe.apply(f);
    }
}
