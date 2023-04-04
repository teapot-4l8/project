package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzert implements Iterator<E> {
    private int pos = 0;
    private final /* synthetic */ zzerq zzjep;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzert(zzerq zzerqVar) {
        this.zzjep = zzerqVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.pos < this.zzjep.zzjen.size() || this.zzjep.zzjeo.hasNext();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [E, java.lang.Object] */
    @Override // java.util.Iterator
    public final E next() {
        while (this.pos >= this.zzjep.zzjen.size()) {
            this.zzjep.zzjen.add(this.zzjep.zzjeo.next());
        }
        List<E> list = this.zzjep.zzjen;
        int i = this.pos;
        this.pos = i + 1;
        return list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
