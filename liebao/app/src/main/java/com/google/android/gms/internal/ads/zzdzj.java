package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzdzj<F, T> extends AbstractSequentialList<T> implements Serializable {
    private final List<F> zzibd;
    final zzdxw<? super F, ? extends T> zzibe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzj(List<F> list, zzdxw<? super F, ? extends T> zzdxwVar) {
        this.zzibd = (List) zzdyi.checkNotNull(list);
        this.zzibe = (zzdxw) zzdyi.checkNotNull(zzdxwVar);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.zzibd.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzibd.size();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator<T> listIterator(int i) {
        return new zzdzm(this, this.zzibd.listIterator(i));
    }
}
