package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzdzr extends zzdza<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzibj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzr(Object[] objArr, int i, int i2) {
        this.zzibj = objArr;
        this.offset = i;
        this.size = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final boolean zzbak() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzdyi.zzv(i, this.size);
        return this.zzibj[(i * 2) + this.offset];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }
}
