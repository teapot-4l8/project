package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzdyx<E> {
    public abstract zzdyx<E> zzaa(E e2);

    public zzdyx<E> zzg(Iterable<? extends E> iterable) {
        for (E e2 : iterable) {
            zzaa(e2);
        }
        return this;
    }

    public zzdyx<E> zza(Iterator<? extends E> it) {
        while (it.hasNext()) {
            zzaa(it.next());
        }
        return this;
    }
}
