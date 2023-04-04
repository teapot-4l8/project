package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzdzh<F, T> extends AbstractList<T> implements Serializable, RandomAccess {
    private final List<F> zzibd;
    final zzdxw<? super F, ? extends T> zzibe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzh(List<F> list, zzdxw<? super F, ? extends T> zzdxwVar) {
        this.zzibd = (List) zzdyi.checkNotNull(list);
        this.zzibe = (zzdxw) zzdyi.checkNotNull(zzdxwVar);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.zzibd.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final T get(int i) {
        return this.zzibe.apply((F) this.zzibd.get(i));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<T> listIterator(int i) {
        return new zzdzk(this, this.zzibd.listIterator(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.zzibd.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.List
    public final T remove(int i) {
        return this.zzibe.apply((F) this.zzibd.remove(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzibd.size();
    }
}
