package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzepp implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzepn zzixv;
    private Iterator<Map.Entry<K, V>> zzixw;

    private zzepp(zzepn zzepnVar) {
        List list;
        this.zzixv = zzepnVar;
        list = this.zzixv.zzixq;
        this.pos = list.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i = this.pos;
        if (i > 0) {
            list = this.zzixv.zzixq;
            if (i <= list.size()) {
                return true;
            }
        }
        return zzblu().hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzblu() {
        Map map;
        if (this.zzixw == null) {
            map = this.zzixv.zzixt;
            this.zzixw = map.entrySet().iterator();
        }
        return this.zzixw;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        if (zzblu().hasNext()) {
            return (Map.Entry) zzblu().next();
        }
        list = this.zzixv.zzixq;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) list.get(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzepp(zzepn zzepnVar, zzepm zzepmVar) {
        this(zzepnVar);
    }
}
