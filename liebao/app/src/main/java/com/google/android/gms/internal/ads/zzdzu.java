package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdzu<E> extends zzdzd<E> {
    static final zzdzu<Object> zzibp = new zzdzu<>(new Object[0], 0, null, 0, 0);
    private final transient int mask;
    private final transient int size;
    private final transient int zzaih;
    private final transient Object[] zzibq;
    private final transient Object[] zzibr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzu(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzibq = objArr;
        this.zzibr = objArr2;
        this.mask = i2;
        this.zzaih = i;
        this.size = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final int zzbah() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final boolean zzbak() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdzd
    final boolean zzbam() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.zzibr;
        if (obj == null || objArr == null) {
            return false;
        }
        int zzex = zzdyw.zzex(obj == null ? 0 : obj.hashCode());
        while (true) {
            int i = zzex & this.mask;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zzex = i + 1;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv
    public final zzdzx<E> zzbaf() {
        return (zzdzx) zzbaj().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final Object[] zzbag() {
        return this.zzibq;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv
    final int zzbai() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzibq, 0, objArr, i, this.size);
        return i + this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdzd
    final zzdza<E> zzban() {
        return zzdza.zzb(this.zzibq, this.size);
    }

    @Override // com.google.android.gms.internal.ads.zzdzd, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zzaih;
    }

    @Override // com.google.android.gms.internal.ads.zzdzd, com.google.android.gms.internal.ads.zzdyv, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
