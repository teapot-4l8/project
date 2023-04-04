package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdzc<E> extends zzdyr<E> {
    private final zzdza<E> zziau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzc(zzdza<E> zzdzaVar, int i) {
        super(zzdzaVar.size(), i);
        this.zziau = zzdzaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    protected final E get(int i) {
        return this.zziau.get(i);
    }
}
