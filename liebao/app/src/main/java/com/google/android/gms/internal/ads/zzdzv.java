package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
abstract class zzdzv<F, T> implements Iterator<T> {
    final Iterator<? extends F> zzibs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzv(Iterator<? extends F> it) {
        this.zzibs = (Iterator) zzdyi.checkNotNull(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzae(F f);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzibs.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return zzae(this.zzibs.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzibs.remove();
    }
}
