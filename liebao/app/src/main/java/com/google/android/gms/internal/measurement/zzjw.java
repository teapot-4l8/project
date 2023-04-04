package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes.dex */
final class zzjw<E> extends zzgj<E> implements RandomAccess {
    private static final zzjw<Object> zza;
    private E[] zzb;
    private int zzc;

    public static <E> zzjw<E> zzd() {
        return (zzjw<E>) zza;
    }

    zzjw() {
        this(new Object[10], 0);
    }

    private zzjw(E[] eArr, int i) {
        this.zzb = eArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzgj, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e2) {
        zzc();
        int i = this.zzc;
        E[] eArr = this.zzb;
        if (i == eArr.length) {
            this.zzb = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        eArr2[i2] = e2;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzgj, java.util.AbstractList, java.util.List
    public final void add(int i, E e2) {
        int i2;
        zzc();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzc(i));
        }
        E[] eArr = this.zzb;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzb, i, eArr2, i + 1, this.zzc - i);
            this.zzb = eArr2;
        }
        this.zzb[i] = e2;
        this.zzc++;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        zzb(i);
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzgj, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        int i2;
        zzc();
        zzb(i);
        E[] eArr = this.zzb;
        E e2 = eArr[i];
        if (i < this.zzc - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return e2;
    }

    @Override // com.google.android.gms.internal.measurement.zzgj, java.util.AbstractList, java.util.List
    public final E set(int i, E e2) {
        zzc();
        zzb(i);
        E[] eArr = this.zzb;
        E e3 = eArr[i];
        eArr[i] = e2;
        this.modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    private final void zzb(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzc(i));
        }
    }

    private final String zzc(int i) {
        int i2 = this.zzc;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzig
    public final /* synthetic */ zzig zza(int i) {
        if (i < this.zzc) {
            throw new IllegalArgumentException();
        }
        return new zzjw(Arrays.copyOf(this.zzb, i), this.zzc);
    }

    static {
        zzjw<Object> zzjwVar = new zzjw<>(new Object[0], 0);
        zza = zzjwVar;
        zzjwVar.i_();
    }
}
