package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzdzq<K, V> extends zzdzd<Map.Entry<K, V>> {
    private final transient int size;
    private final transient Object[] zzibj;
    private final transient zzdze<K, V> zzibn;
    private final transient int zzibo = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzq(zzdze<K, V> zzdzeVar, Object[] objArr, int i, int i2) {
        this.zzibn = zzdzeVar;
        this.zzibj = objArr;
        this.size = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final boolean zzbak() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv
    public final zzdzx<Map.Entry<K, V>> zzbaf() {
        return (zzdzx) zzbaj().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final int zza(Object[] objArr, int i) {
        return zzbaj().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdzd
    final zzdza<Map.Entry<K, V>> zzban() {
        return new zzdzp(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdyv, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zzibn.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdzd, com.google.android.gms.internal.ads.zzdyv, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
