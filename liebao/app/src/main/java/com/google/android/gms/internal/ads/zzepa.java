package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzepa<E> extends zzelk<E> implements RandomAccess {
    private static final zzepa<Object> zziwq;
    private int size;
    private E[] zzibl;

    public static <E> zzepa<E> zzbld() {
        return (zzepa<E>) zziwq;
    }

    zzepa() {
        this(new Object[10], 0);
    }

    private zzepa(E[] eArr, int i) {
        this.zzibl = eArr;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e2) {
        zzbhf();
        int i = this.size;
        E[] eArr = this.zzibl;
        if (i == eArr.length) {
            this.zzibl = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzibl;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = e2;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.List
    public final void add(int i, E e2) {
        int i2;
        zzbhf();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzgf(i));
        }
        E[] eArr = this.zzibl;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzibl, i, eArr2, i + 1, this.size - i);
            this.zzibl = eArr2;
        }
        this.zzibl[i] = e2;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        zzge(i);
        return this.zzibl[i];
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        int i2;
        zzbhf();
        zzge(i);
        E[] eArr = this.zzibl;
        E e2 = eArr[i];
        if (i < this.size - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.List
    public final E set(int i, E e2) {
        zzbhf();
        zzge(i);
        E[] eArr = this.zzibl;
        E e3 = eArr[i];
        eArr[i] = e2;
        this.modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    private final void zzge(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzgf(i));
        }
    }

    private final String zzgf(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzenk
    public final /* synthetic */ zzenk zzgg(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzepa(Arrays.copyOf(this.zzibl, i), this.size);
    }

    static {
        zzepa<Object> zzepaVar = new zzepa<>(new Object[0], 0);
        zziwq = zzepaVar;
        zzepaVar.zzbhe();
    }
}
