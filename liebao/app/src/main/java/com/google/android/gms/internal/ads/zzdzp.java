package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzdzp extends zzdza<Map.Entry<K, V>> {
    private final /* synthetic */ zzdzq zzibm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzp(zzdzq zzdzqVar) {
        this.zzibm = zzdzqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv
    public final boolean zzbak() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.zzibm.size;
        return i;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        i2 = this.zzibm.size;
        zzdyi.zzv(i, i2);
        objArr = this.zzibm.zzibj;
        int i3 = i * 2;
        Object obj = objArr[i3];
        objArr2 = this.zzibm.zzibj;
        return new AbstractMap.SimpleImmutableEntry(obj, objArr2[i3 + 1]);
    }
}
