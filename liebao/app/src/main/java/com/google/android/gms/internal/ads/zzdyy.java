package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
class zzdyy<E> extends zzdyx<E> {
    int size;
    Object[] zziaq;
    boolean zziar;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdyy(int i) {
        zzdyu.zzh(i, "initialCapacity");
        this.zziaq = new Object[i];
        this.size = 0;
    }

    private final void zzey(int i) {
        Object[] objArr = this.zziaq;
        if (objArr.length < i) {
            int length = objArr.length;
            if (i < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i2 = length + (length >> 1) + 1;
            if (i2 < i) {
                i2 = Integer.highestOneBit(i - 1) << 1;
            }
            if (i2 < 0) {
                i2 = Integer.MAX_VALUE;
            }
            this.zziaq = Arrays.copyOf(objArr, i2);
            this.zziar = false;
        } else if (this.zziar) {
            this.zziaq = (Object[]) objArr.clone();
            this.zziar = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyx
    /* renamed from: zzab */
    public zzdyy<E> zzaa(E e2) {
        zzdyi.checkNotNull(e2);
        zzey(this.size + 1);
        Object[] objArr = this.zziaq;
        int i = this.size;
        this.size = i + 1;
        objArr[i] = e2;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdyx
    public zzdyx<E> zzg(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzey(this.size + collection.size());
            if (collection instanceof zzdyv) {
                this.size = ((zzdyv) collection).zza(this.zziaq, this.size);
                return this;
            }
        }
        super.zzg(iterable);
        return this;
    }
}
