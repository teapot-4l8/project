package com.bumptech.glide.i;

/* compiled from: CachedHashCodeArrayMap.java */
/* loaded from: classes.dex */
public final class b<K, V> extends androidx.b.a<K, V> {
    private int i;

    @Override // androidx.b.g, java.util.Map
    public void clear() {
        this.i = 0;
        super.clear();
    }

    @Override // androidx.b.g
    public V a(int i, V v) {
        this.i = 0;
        return (V) super.a(i, (int) v);
    }

    @Override // androidx.b.g, java.util.Map
    public V put(K k, V v) {
        this.i = 0;
        return (V) super.put(k, v);
    }

    @Override // androidx.b.g
    public void a(androidx.b.g<? extends K, ? extends V> gVar) {
        this.i = 0;
        super.a((androidx.b.g) gVar);
    }

    @Override // androidx.b.g
    public V d(int i) {
        this.i = 0;
        return (V) super.d(i);
    }

    @Override // androidx.b.g, java.util.Map
    public int hashCode() {
        if (this.i == 0) {
            this.i = super.hashCode();
        }
        return this.i;
    }
}
