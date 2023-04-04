package com.bumptech.glide.c.b.a;

import com.bumptech.glide.c.b.a.m;
import java.util.Queue;

/* compiled from: BaseKeyPool.java */
/* loaded from: classes.dex */
abstract class d<T extends m> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f4686a = com.bumptech.glide.i.j.a(20);

    abstract T b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public T c() {
        T poll = this.f4686a.poll();
        return poll == null ? b() : poll;
    }

    public void a(T t) {
        if (this.f4686a.size() < 20) {
            this.f4686a.offer(t);
        }
    }
}
