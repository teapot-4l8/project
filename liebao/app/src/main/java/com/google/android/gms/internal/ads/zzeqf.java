package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeqf extends AbstractList<String> implements zzenu, RandomAccess {
    private final zzenu zziyh;

    public zzeqf(zzenu zzenuVar) {
        this.zziyh = zzenuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final zzenu zzbkm() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final Object zzhr(int i) {
        return this.zziyh.zzhr(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zziyh.size();
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzak(zzelq zzelqVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzeqe(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzeqh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final List<?> zzbkl() {
        return this.zziyh.zzbkl();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zziyh.get(i);
    }
}
