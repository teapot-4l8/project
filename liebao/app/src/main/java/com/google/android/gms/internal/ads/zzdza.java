package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzdza<E> extends zzdyv<E> implements List<E>, RandomAccess {
    private static final zzeaa<Object> zzias = new zzdzc(zzdzo.zzibk, 0);

    public static <E> zzdza<E> zzbal() {
        return (zzdza<E>) zzdzo.zzibk;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv
    public final zzdza<E> zzbaj() {
        return this;
    }

    public static <E> zzdza<E> zzac(E e2) {
        Object[] objArr = {e2};
        for (int i = 0; i <= 0; i++) {
            zzdzl.zzd(objArr[0], 0);
        }
        return zzb(objArr, 1);
    }

    public static <E> zzdza<E> zzh(Iterable<? extends E> iterable) {
        zzdyi.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return zzb((Collection) iterable);
        }
        Iterator<? extends E> it = iterable.iterator();
        if (!it.hasNext()) {
            return (zzdza<E>) zzdzo.zzibk;
        }
        E next = it.next();
        if (!it.hasNext()) {
            return zzac(next);
        }
        zzdyz zzdyzVar = (zzdyz) ((zzdyz) new zzdyz().zzaa(next)).zza(it);
        zzdyzVar.zziar = true;
        return zzb(zzdyzVar.zziaq, zzdyzVar.size);
    }

    public static <E> zzdza<E> zzb(Collection<? extends E> collection) {
        if (collection instanceof zzdyv) {
            zzdza<E> zzbaj = ((zzdyv) collection).zzbaj();
            if (zzbaj.zzbak()) {
                Object[] array = zzbaj.toArray();
                return zzb(array, array.length);
            }
            return zzbaj;
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i = 0; i < length; i++) {
            zzdzl.zzd(array2[i], i);
        }
        return zzb(array2, array2.length);
    }

    public static <E> zzdza<E> zzb(E[] eArr) {
        if (eArr.length == 0) {
            return (zzdza<E>) zzdzo.zzibk;
        }
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            zzdzl.zzd(objArr[i], i);
        }
        return zzb(objArr, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> zzdza<E> zzc(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> zzdza<E> zzb(Object[] objArr, int i) {
        if (i == 0) {
            return (zzdza<E>) zzdzo.zzibk;
        }
        return new zzdzo(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdyv
    public final zzdzx<E> zzbaf() {
        return (zzeaa) listIterator();
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            int size = size();
            int i = 0;
            if (obj == null) {
                while (i < size) {
                    if (get(i) == null) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < size) {
                    if (obj.equals(get(i))) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }
        ListIterator<E> listIterator = listIterator();
        while (listIterator.hasNext()) {
            if (zzdyc.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (!(this instanceof RandomAccess)) {
            ListIterator<E> listIterator = listIterator(size());
            while (listIterator.hasPrevious()) {
                if (zzdyc.equal(obj, listIterator.previous())) {
                    return listIterator.nextIndex();
                }
            }
            return -1;
        }
        if (obj == null) {
            for (int size = size() - 1; size >= 0; size--) {
                if (get(size) == null) {
                    return size;
                }
            }
        } else {
            for (int size2 = size() - 1; size2 >= 0; size2--) {
                if (obj.equals(get(size2))) {
                    return size2;
                }
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List
    /* renamed from: zzx */
    public zzdza<E> subList(int i, int i2) {
        zzdyi.zzf(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return (zzdza<E>) zzdzo.zzibk;
        }
        return new zzdzb(this, i, i3);
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzdyi.checkNotNull(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if ((this instanceof RandomAccess) && (list instanceof RandomAccess)) {
                    for (int i = 0; i < size; i++) {
                        if (zzdyc.equal(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                zzdza<E> zzdzaVar = this;
                int size2 = zzdzaVar.size();
                Iterator<E> it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        E e2 = zzdzaVar.get(i2);
                        i2++;
                        if (!zzdyc.equal(e2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ (-1)) ^ (-1);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i) {
        zzdyi.zzw(i, size());
        if (isEmpty()) {
            return zzias;
        }
        return new zzdzc(this, i);
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (zzeaa) listIterator(0);
    }
}
