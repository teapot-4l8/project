package com.google.android.gms.internal.ads;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public class zzepn<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zziqt;
    private final int zzixp;
    private List<zzeps> zzixq;
    private Map<K, V> zzixr;
    private volatile zzepu zzixs;
    private Map<K, V> zzixt;
    private volatile zzepo zzixu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends zzemv<FieldDescriptorType>> zzepn<FieldDescriptorType, Object> zzib(int i) {
        return new zzepm(i);
    }

    private zzepn(int i) {
        this.zzixp = i;
        this.zzixq = Collections.emptyList();
        this.zzixr = Collections.emptyMap();
        this.zzixt = Collections.emptyMap();
    }

    public void zzbhe() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.zziqt) {
            return;
        }
        if (this.zzixr.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.zzixr);
        }
        this.zzixr = unmodifiableMap;
        if (this.zzixt.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.zzixt);
        }
        this.zzixt = unmodifiableMap2;
        this.zziqt = true;
    }

    public final boolean isImmutable() {
        return this.zziqt;
    }

    public final int zzblp() {
        return this.zzixq.size();
    }

    public final Map.Entry<K, V> zzic(int i) {
        return this.zzixq.get(i);
    }

    public final Iterable<Map.Entry<K, V>> zzblq() {
        if (this.zzixr.isEmpty()) {
            return zzepr.zzblv();
        }
        return this.zzixr.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzixq.size() + this.zzixr.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((zzepn<K, V>) comparable) >= 0 || this.zzixr.containsKey(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzepn<K, V>) comparable);
        if (zza >= 0) {
            return (V) this.zzixq.get(zza).getValue();
        }
        return this.zzixr.get(comparable);
    }

    public final V zza(K k, V v) {
        zzbls();
        int zza = zza((zzepn<K, V>) k);
        if (zza >= 0) {
            return (V) this.zzixq.get(zza).setValue(v);
        }
        zzbls();
        if (this.zzixq.isEmpty() && !(this.zzixq instanceof ArrayList)) {
            this.zzixq = new ArrayList(this.zzixp);
        }
        int i = -(zza + 1);
        if (i >= this.zzixp) {
            return zzblt().put(k, v);
        }
        int size = this.zzixq.size();
        int i2 = this.zzixp;
        if (size == i2) {
            zzeps remove = this.zzixq.remove(i2 - 1);
            zzblt().put((K) remove.getKey(), (V) remove.getValue());
        }
        this.zzixq.add(i, new zzeps(this, k, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzbls();
        if (!this.zzixq.isEmpty()) {
            this.zzixq.clear();
        }
        if (this.zzixr.isEmpty()) {
            return;
        }
        this.zzixr.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzbls();
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzepn<K, V>) comparable);
        if (zza >= 0) {
            return (V) zzid(zza);
        }
        if (this.zzixr.isEmpty()) {
            return null;
        }
        return this.zzixr.remove(comparable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzid(int i) {
        zzbls();
        V v = (V) this.zzixq.remove(i).getValue();
        if (!this.zzixr.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzblt().entrySet().iterator();
            this.zzixq.add(new zzeps(this, it.next()));
            it.remove();
        }
        return v;
    }

    private final int zza(K k) {
        int size = this.zzixq.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzixq.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzixq.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzixs == null) {
            this.zzixs = new zzepu(this, null);
        }
        return this.zzixs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzblr() {
        if (this.zzixu == null) {
            this.zzixu = new zzepo(this, null);
        }
        return this.zzixu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbls() {
        if (this.zziqt) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzblt() {
        zzbls();
        if (this.zzixr.isEmpty() && !(this.zzixr instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzixr = treeMap;
            this.zzixt = treeMap.descendingMap();
        }
        return (SortedMap) this.zzixr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzepn)) {
            return super.equals(obj);
        }
        zzepn zzepnVar = (zzepn) obj;
        int size = size();
        if (size != zzepnVar.size()) {
            return false;
        }
        int zzblp = zzblp();
        if (zzblp != zzepnVar.zzblp()) {
            return entrySet().equals(zzepnVar.entrySet());
        }
        for (int i = 0; i < zzblp; i++) {
            if (!zzic(i).equals(zzepnVar.zzic(i))) {
                return false;
            }
        }
        if (zzblp != size) {
            return this.zzixr.equals(zzepnVar.zzixr);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int zzblp = zzblp();
        int i = 0;
        for (int i2 = 0; i2 < zzblp; i2++) {
            i += this.zzixq.get(i2).hashCode();
        }
        return this.zzixr.size() > 0 ? i + this.zzixr.hashCode() : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((zzepn<K, V>) ((Comparable) obj), (Comparable) obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzepn(int i, zzepm zzepmVar) {
        this(i);
    }
}
