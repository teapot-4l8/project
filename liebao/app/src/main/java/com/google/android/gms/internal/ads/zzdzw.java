package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdzw<E> extends zzdzd<E> {
    private final transient E zzibt;
    private transient int zzibu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzw(E e2) {
        this.zzibt = (E) zzdyi.checkNotNull(e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final boolean zzbak() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzw(E e2, int i) {
        this.zzibt = e2;
        this.zzibu = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zzibt.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdyv
    public final zzdzx<E> zzbaf() {
        return new zzdzf(this.zzibt);
    }

    @Override // com.google.android.gms.internal.ads.zzdzd
    final zzdza<E> zzban() {
        return zzdza.zzac(this.zzibt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zzibt;
        return i + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzdzd, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.zzibu;
        if (i == 0) {
            int hashCode = this.zzibt.hashCode();
            this.zzibu = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzdzd
    final boolean zzbam() {
        return this.zzibu != 0;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String obj = this.zzibt.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdzd, com.google.android.gms.internal.ads.zzdyv, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
