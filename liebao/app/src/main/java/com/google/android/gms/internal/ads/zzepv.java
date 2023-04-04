package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzepv implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzepn zzixv;
    private Iterator<Map.Entry<K, V>> zzixw;
    private boolean zziya;

    private zzepv(zzepn zzepnVar) {
        this.zzixv = zzepnVar;
        this.pos = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.pos + 1;
        list = this.zzixv.zzixq;
        if (i >= list.size()) {
            map = this.zzixv.zzixr;
            if (map.isEmpty() || !zzblu().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.zziya) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zziya = false;
        this.zzixv.zzbls();
        int i = this.pos;
        list = this.zzixv.zzixq;
        if (i < list.size()) {
            zzepn zzepnVar = this.zzixv;
            int i2 = this.pos;
            this.pos = i2 - 1;
            zzepnVar.zzid(i2);
            return;
        }
        zzblu().remove();
    }

    private final Iterator<Map.Entry<K, V>> zzblu() {
        Map map;
        if (this.zzixw == null) {
            map = this.zzixv.zzixr;
            this.zzixw = map.entrySet().iterator();
        }
        return this.zzixw;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        List list2;
        this.zziya = true;
        int i = this.pos + 1;
        this.pos = i;
        list = this.zzixv.zzixq;
        if (i >= list.size()) {
            return (Map.Entry) zzblu().next();
        }
        list2 = this.zzixv.zzixq;
        return (Map.Entry) list2.get(this.pos);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzepv(zzepn zzepnVar, zzepm zzepmVar) {
        this(zzepnVar);
    }
}
