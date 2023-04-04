package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzelo extends zzelk<Boolean> implements zzenk<Boolean>, zzeoz, RandomAccess {
    private static final zzelo zzioz;
    private int size;
    private boolean[] zzipa;

    zzelo() {
        this(new boolean[10], 0);
    }

    private zzelo(boolean[] zArr, int i) {
        this.zzipa = zArr;
        this.size = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzbhf();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zzipa;
        System.arraycopy(zArr, i2, zArr, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzelo)) {
            return super.equals(obj);
        }
        zzelo zzeloVar = (zzelo) obj;
        if (this.size != zzeloVar.size) {
            return false;
        }
        boolean[] zArr = zzeloVar.zzipa;
        for (int i = 0; i < this.size; i++) {
            if (this.zzipa[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzenc.zzby(this.zzipa[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            int size = size();
            for (int i = 0; i < size; i++) {
                if (this.zzipa[i] == booleanValue) {
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

    public final void addBoolean(boolean z) {
        zzbhf();
        int i = this.size;
        boolean[] zArr = this.zzipa;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zzipa = zArr2;
        }
        boolean[] zArr3 = this.zzipa;
        int i2 = this.size;
        this.size = i2 + 1;
        zArr3[i2] = z;
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzbhf();
        zzenc.checkNotNull(collection);
        if (!(collection instanceof zzelo)) {
            return super.addAll(collection);
        }
        zzelo zzeloVar = (zzelo) collection;
        int i = zzeloVar.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.zzipa;
        if (i3 > zArr.length) {
            this.zzipa = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(zzeloVar.zzipa, 0, this.zzipa, this.size, zzeloVar.size);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbhf();
        zzge(i);
        boolean[] zArr = this.zzipa;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        int i2;
        zzbhf();
        zzge(i);
        boolean[] zArr = this.zzipa;
        boolean z = zArr[i];
        if (i < this.size - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbhf();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzgf(i));
        }
        boolean[] zArr = this.zzipa;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zzipa, i, zArr2, i + 1, this.size - i);
            this.zzipa = zArr2;
        }
        this.zzipa[i] = booleanValue;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzelk, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzenk
    public final /* synthetic */ zzenk<Boolean> zzgg(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzelo(Arrays.copyOf(this.zzipa, i), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzge(i);
        return Boolean.valueOf(this.zzipa[i]);
    }

    static {
        zzelo zzeloVar = new zzelo(new boolean[0], 0);
        zzioz = zzeloVar;
        zzeloVar.zzbhe();
    }
}
