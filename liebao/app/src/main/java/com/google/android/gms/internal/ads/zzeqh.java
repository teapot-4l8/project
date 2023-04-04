package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzeqh implements Iterator<String> {
    private final /* synthetic */ zzeqf zziyg;
    private Iterator<String> zzizc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeqh(zzeqf zzeqfVar) {
        zzenu zzenuVar;
        this.zziyg = zzeqfVar;
        zzenuVar = this.zziyg.zziyh;
        this.zzizc = zzenuVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzizc.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzizc.next();
    }
}
