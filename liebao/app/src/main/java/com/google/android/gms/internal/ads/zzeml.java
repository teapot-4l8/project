package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzeml extends zzelk<Double> implements zzenk<Double>, zzeoz, RandomAccess {
    private static final zzeml zziqh;
    private int size;
    private double[] zziqi;

    zzeml() {
        this(new double[10], 0);
    }

    private zzeml(double[] dArr, int i) {
        this.zziqi = dArr;
        this.size = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzbhf();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zziqi;
        System.arraycopy(dArr, i2, dArr, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeml)) {
            return super.equals(obj);
        }
        zzeml zzemlVar = (zzeml) obj;
        if (this.size != zzemlVar.size) {
            return false;
        }
        double[] dArr = zzemlVar.zziqi;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zziqi[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzenc.zzfr(Double.doubleToLongBits(this.zziqi[i2]));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            int size = size();
            for (int i = 0; i < size; i++) {
                if (this.zziqi[i] == doubleValue) {
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zze(double d2) {
        zzbhf();
        int i = this.size;
        double[] dArr = this.zziqi;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zziqi = dArr2;
        }
        double[] dArr3 = this.zziqi;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr3[i2] = d2;
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzbhf();
        zzenc.checkNotNull(collection);
        if (!(collection instanceof zzeml)) {
            return super.addAll(collection);
        }
        zzeml zzemlVar = (zzeml) collection;
        int i = zzemlVar.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.zziqi;
        if (i3 > dArr.length) {
            this.zziqi = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(zzemlVar.zziqi, 0, this.zziqi, this.size, zzemlVar.size);
        this.size = i3;
        this.modCount++;
        return true;
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

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzbhf();
        zzge(i);
        double[] dArr = this.zziqi;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        int i2;
        zzbhf();
        zzge(i);
        double[] dArr = this.zziqi;
        double d2 = dArr[i];
        if (i < this.size - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d2);
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        zzbhf();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzgf(i));
        }
        double[] dArr = this.zziqi;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zziqi, i, dArr2, i + 1, this.size - i);
            this.zziqi = dArr2;
        }
        this.zziqi[i] = doubleValue;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zze(((Double) obj).doubleValue());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzenk
    public final /* synthetic */ zzenk<Double> zzgg(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzeml(Arrays.copyOf(this.zziqi, i), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzge(i);
        return Double.valueOf(this.zziqi[i]);
    }

    static {
        zzeml zzemlVar = new zzeml(new double[0], 0);
        zziqh = zzemlVar;
        zzemlVar.zzbhe();
    }
}
