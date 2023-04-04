package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdzb extends zzdza<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzdza zziat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzb(zzdza zzdzaVar, int i, int i2) {
        this.zziat = zzdzaVar;
        this.offset = i;
        this.length = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final boolean zzbak() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final Object[] zzbag() {
        return this.zziat.zzbag();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyv
    public final int zzbah() {
        return this.zziat.zzbah() + this.offset;
    }

    @Override // com.google.android.gms.internal.ads.zzdyv
    final int zzbai() {
        return this.zziat.zzbah() + this.offset + this.length;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdyi.zzv(i, this.length);
        return this.zziat.get(i + this.offset);
    }

    @Override // com.google.android.gms.internal.ads.zzdza
    public final zzdza<E> zzx(int i, int i2) {
        zzdyi.zzf(i, i2, this.length);
        zzdza zzdzaVar = this.zziat;
        int i3 = this.offset;
        return (zzdza) zzdzaVar.subList(i + i3, i2 + i3);
    }

    @Override // com.google.android.gms.internal.ads.zzdza, java.util.List
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
