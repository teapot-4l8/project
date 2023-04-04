package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzdzd<E> extends zzdyv<E> implements Set<E> {
    @NullableDecl
    private transient zzdza<E> zziav;

    public static <E> zzdzd<E> zzad(E e2) {
        return new zzdzw(e2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzy(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    boolean zzbam() {
        return false;
    }

    @SafeVarargs
    public static <E> zzdzd<E> zza(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        zzdyi.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e2;
        objArr[1] = e3;
        objArr[2] = e4;
        objArr[3] = e5;
        objArr[4] = e6;
        objArr[5] = e7;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return zza(length, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> zzdzd<E> zza(int i, Object... objArr) {
        while (i != 0) {
            if (i == 1) {
                return zzad(objArr[0]);
            }
            int zzez = zzez(i);
            Object[] objArr2 = new Object[zzez];
            int i2 = zzez - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object zzd = zzdzl.zzd(objArr[i5], i5);
                int hashCode = zzd.hashCode();
                int zzex = zzdyw.zzex(hashCode);
                while (true) {
                    int i6 = zzex & i2;
                    Object obj = objArr2[i6];
                    if (obj == null) {
                        objArr[i4] = zzd;
                        objArr2[i6] = zzd;
                        i3 += hashCode;
                        i4++;
                        break;
                    } else if (!obj.equals(zzd)) {
                        zzex++;
                    }
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                return new zzdzw(objArr[0], i3);
            }
            if (zzez(i4) >= zzez / 2) {
                if (zzy(i4, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i4);
                }
                return new zzdzu(objArr, i3, objArr2, i2, i4);
            }
            i = i4;
        }
        return zzdzu.zzibp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzez(int i) {
        int max = Math.max(i, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (true) {
                double d2 = highestOneBit;
                Double.isNaN(d2);
                if (d2 * 0.7d >= max) {
                    return highestOneBit;
                }
                highestOneBit <<= 1;
            }
        } else {
            zzdyi.checkArgument(max < 1073741824, "collection too large");
            return 1073741824;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzdzd) && zzbam() && ((zzdzd) obj).zzbam() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzdzt.zza(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzdzt.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdyv
    public zzdza<E> zzbaj() {
        zzdza<E> zzdzaVar = this.zziav;
        if (zzdzaVar == null) {
            zzdza<E> zzban = zzban();
            this.zziav = zzban;
            return zzban;
        }
        return zzdzaVar;
    }

    zzdza<E> zzban() {
        return zzdza.zzc(toArray());
    }

    public static <E> zzdzg<E> zzfa(int i) {
        zzdyu.zzh(i, "expectedSize");
        return new zzdzg<>(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdyv, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
