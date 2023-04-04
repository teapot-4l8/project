package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdzo<E> extends zzdza<E> {
    static final zzdza<Object> zzibk = new zzdzo(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzibl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzo(Object[] objArr, int i) {
        this.zzibl = objArr;
        this.size = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final int zzbah() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final boolean zzbak() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final Object[] zzbag() {
        return this.zzibl;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv
    final int zzbai() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdza, com.google.android.gms.internal.ads.zzdyv
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzibl, 0, objArr, i, this.size);
        return i + this.size;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdyi.zzv(i, this.size);
        return (E) this.zzibl[i];
    }
}
