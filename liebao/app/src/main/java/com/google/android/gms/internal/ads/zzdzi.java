package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdzi {
    public static <E> ArrayList<E> zzfb(int i) {
        zzdyu.zzh(i, "initialArraySize");
        return new ArrayList<>(i);
    }

    public static <F, T> List<T> zza(List<F> list, zzdxw<? super F, ? extends T> zzdxwVar) {
        if (list instanceof RandomAccess) {
            return new zzdzh(list, zzdxwVar);
        }
        return new zzdzj(list, zzdxwVar);
    }
}
