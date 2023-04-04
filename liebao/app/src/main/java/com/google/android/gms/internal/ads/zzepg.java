package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzepg implements Iterator<zzelx> {
    private final ArrayDeque<zzepf> zzixd;
    private zzelx zzixe;

    private zzepg(zzelq zzelqVar) {
        zzelq zzelqVar2;
        if (zzelqVar instanceof zzepf) {
            zzepf zzepfVar = (zzepf) zzelqVar;
            ArrayDeque<zzepf> arrayDeque = new ArrayDeque<>(zzepfVar.zzbhl());
            this.zzixd = arrayDeque;
            arrayDeque.push(zzepfVar);
            zzelqVar2 = zzepfVar.zziwz;
            this.zzixe = zzal(zzelqVar2);
            return;
        }
        this.zzixd = null;
        this.zzixe = (zzelx) zzelqVar;
    }

    private final zzelx zzal(zzelq zzelqVar) {
        while (zzelqVar instanceof zzepf) {
            zzepf zzepfVar = (zzepf) zzelqVar;
            this.zzixd.push(zzepfVar);
            zzelqVar = zzepfVar.zziwz;
        }
        return (zzelx) zzelqVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzixe != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ zzelx next() {
        zzelx zzelxVar;
        zzelq zzelqVar;
        zzelx zzelxVar2 = this.zzixe;
        if (zzelxVar2 == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque<zzepf> arrayDeque = this.zzixd;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                zzelxVar = null;
                break;
            }
            zzelqVar = this.zzixd.pop().zzixa;
            zzelxVar = zzal(zzelqVar);
        } while (zzelxVar.isEmpty());
        this.zzixe = zzelxVar;
        return zzelxVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzepg(zzelq zzelqVar, zzepe zzepeVar) {
        this(zzelqVar);
    }
}
