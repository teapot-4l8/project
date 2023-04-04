package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzenj<F, T> extends AbstractList<T> {
    private final List<F> zzibd;
    private final zzeni<F, T> zziuh;

    public zzenj(List<F> list, zzeni<F, T> zzeniVar) {
        this.zzibd = list;
        this.zziuh = zzeniVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final T get(int i) {
        return this.zziuh.convert(this.zzibd.get(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzibd.size();
    }
}
