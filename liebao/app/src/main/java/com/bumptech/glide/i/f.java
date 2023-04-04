package com.bumptech.glide.i;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class f<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, Y> f5250a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private final long f5251b;

    /* renamed from: c  reason: collision with root package name */
    private long f5252c;

    /* renamed from: d  reason: collision with root package name */
    private long f5253d;

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(Y y) {
        return 1;
    }

    protected void a(T t, Y y) {
    }

    public f(long j) {
        this.f5251b = j;
        this.f5252c = j;
    }

    public synchronized long b() {
        return this.f5252c;
    }

    public synchronized Y b(T t) {
        return this.f5250a.get(t);
    }

    public synchronized Y b(T t, Y y) {
        long a2 = a((f<T, Y>) y);
        if (a2 >= this.f5252c) {
            a(t, y);
            return null;
        }
        if (y != null) {
            this.f5253d += a2;
        }
        Y put = this.f5250a.put(t, y);
        if (put != null) {
            this.f5253d -= a((f<T, Y>) put);
            if (!put.equals(y)) {
                a(t, put);
            }
        }
        c();
        return put;
    }

    public synchronized Y c(T t) {
        Y remove;
        remove = this.f5250a.remove(t);
        if (remove != null) {
            this.f5253d -= a((f<T, Y>) remove);
        }
        return remove;
    }

    public void a() {
        a(0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(long j) {
        while (this.f5253d > j) {
            Iterator<Map.Entry<T, Y>> it = this.f5250a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f5253d -= a((f<T, Y>) value);
            T key = next.getKey();
            it.remove();
            a(key, value);
        }
    }

    private void c() {
        a(this.f5252c);
    }
}
