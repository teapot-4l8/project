package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzeqe implements ListIterator<String> {
    private final /* synthetic */ int zzicz;
    private ListIterator<String> zziyf;
    private final /* synthetic */ zzeqf zziyg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeqe(zzeqf zzeqfVar, int i) {
        zzenu zzenuVar;
        this.zziyg = zzeqfVar;
        this.zzicz = i;
        zzenuVar = this.zziyg.zziyh;
        this.zziyf = zzenuVar.listIterator(this.zzicz);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zziyf.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zziyf.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zziyf.nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zziyf.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zziyf.previous();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.zziyf.next();
    }
}
