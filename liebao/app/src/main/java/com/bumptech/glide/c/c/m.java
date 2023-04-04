package com.bumptech.glide.c.c;

import java.util.Queue;

/* compiled from: ModelCache.java */
/* loaded from: classes.dex */
public class m<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.i.f<a<A>, B> f4937a;

    public m() {
        this(250L);
    }

    public m(long j) {
        this.f4937a = new com.bumptech.glide.i.f<a<A>, B>(j) { // from class: com.bumptech.glide.c.c.m.1
            @Override // com.bumptech.glide.i.f
            protected /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
                a((a) ((a) obj), (a<A>) obj2);
            }

            protected void a(a<A> aVar, B b2) {
                aVar.a();
            }
        };
    }

    public B a(A a2, int i, int i2) {
        a<A> a3 = a.a(a2, i, i2);
        B b2 = this.f4937a.b(a3);
        a3.a();
        return b2;
    }

    public void a(A a2, int i, int i2, B b2) {
        this.f4937a.b(a.a(a2, i, i2), b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ModelCache.java */
    /* loaded from: classes.dex */
    public static final class a<A> {

        /* renamed from: a  reason: collision with root package name */
        private static final Queue<a<?>> f4939a = com.bumptech.glide.i.j.a(0);

        /* renamed from: b  reason: collision with root package name */
        private int f4940b;

        /* renamed from: c  reason: collision with root package name */
        private int f4941c;

        /* renamed from: d  reason: collision with root package name */
        private A f4942d;

        static <A> a<A> a(A a2, int i, int i2) {
            a<A> aVar;
            synchronized (f4939a) {
                aVar = (a<A>) f4939a.poll();
            }
            if (aVar == null) {
                aVar = new a<>();
            }
            aVar.b(a2, i, i2);
            return aVar;
        }

        private a() {
        }

        private void b(A a2, int i, int i2) {
            this.f4942d = a2;
            this.f4941c = i;
            this.f4940b = i2;
        }

        public void a() {
            synchronized (f4939a) {
                f4939a.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f4941c == aVar.f4941c && this.f4940b == aVar.f4940b && this.f4942d.equals(aVar.f4942d);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f4940b * 31) + this.f4941c) * 31) + this.f4942d.hashCode();
        }
    }
}
