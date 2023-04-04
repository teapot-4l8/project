package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzenv extends zzelk<String> implements zzenu, RandomAccess {
    private static final zzenv zzivc;
    private static final zzenu zzivd;
    private final List<Object> zzive;

    public zzenv() {
        this(10);
    }

    public zzenv(int i) {
        this(new ArrayList(i));
    }

    private zzenv(ArrayList<Object> arrayList) {
        this.zzive = arrayList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzive.size();
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzbhf();
        if (collection instanceof zzenu) {
            collection = ((zzenu) collection).zzbkl();
        }
        boolean addAll = this.zzive.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzbhf();
        this.zzive.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzak(zzelq zzelqVar) {
        zzbhf();
        this.zzive.add(zzelqVar);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final Object zzhr(int i) {
        return this.zzive.get(i);
    }

    private static String zzam(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzelq) {
            return ((zzelq) obj).zzbhh();
        }
        return zzenc.zzy((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final List<?> zzbkl() {
        return Collections.unmodifiableList(this.zzive);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final zzenu zzbkm() {
        return zzbhd() ? new zzeqf(this) : this;
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzbhf();
        return zzam(this.zzive.set(i, (String) obj));
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbhf();
        Object remove = this.zzive.remove(i);
        this.modCount++;
        return zzam(remove);
    }

    @Override // com.google.android.gms.internal.ads.zzelk, com.google.android.gms.internal.ads.zzenk
    public final /* bridge */ /* synthetic */ boolean zzbhd() {
        return super.zzbhd();
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzbhf();
        this.zzive.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzenk
    public final /* synthetic */ zzenk zzgg(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzive);
        return new zzenv(arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzive.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzelq) {
            zzelq zzelqVar = (zzelq) obj;
            String zzbhh = zzelqVar.zzbhh();
            if (zzelqVar.zzbhi()) {
                this.zzive.set(i, zzbhh);
            }
            return zzbhh;
        }
        byte[] bArr = (byte[]) obj;
        String zzy = zzenc.zzy(bArr);
        if (zzenc.zzx(bArr)) {
            this.zzive.set(i, zzy);
        }
        return zzy;
    }

    static {
        zzenv zzenvVar = new zzenv();
        zzivc = zzenvVar;
        zzenvVar.zzbhe();
        zzivd = zzivc;
    }
}
