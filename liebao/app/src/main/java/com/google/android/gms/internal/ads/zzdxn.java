package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
abstract class zzdxn<T> implements Iterator<T> {
    private int zzhyn = zzdxp.zzhyq;
    @NullableDecl
    private T zzhyo;

    protected abstract T zzazz();

    /* JADX INFO: Access modifiers changed from: protected */
    @NullableDecl
    public final T zzbaa() {
        this.zzhyn = zzdxp.zzhyr;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!(this.zzhyn != zzdxp.zzhys)) {
            throw new IllegalStateException();
        }
        int i = zzdxm.zzhym[this.zzhyn - 1];
        if (i != 1) {
            if (i != 2) {
                this.zzhyn = zzdxp.zzhys;
                this.zzhyo = zzazz();
                if (this.zzhyn != zzdxp.zzhyr) {
                    this.zzhyn = zzdxp.zzhyp;
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.zzhyn = zzdxp.zzhyq;
        T t = this.zzhyo;
        this.zzhyo = null;
        return t;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
