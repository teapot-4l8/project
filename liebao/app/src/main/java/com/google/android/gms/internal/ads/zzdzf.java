package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzdzf extends zzdzx<T> {
    private boolean zziba;
    private final /* synthetic */ Object zzibb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzf(Object obj) {
        this.zzibb = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zziba;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @Override // java.util.Iterator
    public final T next() {
        if (this.zziba) {
            throw new NoSuchElementException();
        }
        this.zziba = true;
        return this.zzibb;
    }
}
