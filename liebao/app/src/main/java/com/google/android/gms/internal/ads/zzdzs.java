package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzdzs<K> extends zzdzd<K> {
    private final transient zzdza<K> zziau;
    private final transient zzdze<K, ?> zzibn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzs(zzdze<K, ?> zzdzeVar, zzdza<K> zzdzaVar) {
        this.zzibn = zzdzeVar;
        this.zziau = zzdzaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final boolean zzbak() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv
    public final zzdzx<K> zzbaf() {
        return (zzdzx) zzbaj().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final int zza(Object[] objArr, int i) {
        return zzbaj().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdzd, com.google.android.gms.internal.ads.zzdyv
    public final zzdza<K> zzbaj() {
        return this.zziau;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@NullableDecl Object obj) {
        return this.zzibn.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzibn.size();
    }

    @Override // com.google.android.gms.internal.ads.zzdzd, com.google.android.gms.internal.ads.zzdyv, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
