package e;

import e.c;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExecutorCallAdapterFactory.java */
/* loaded from: classes.dex */
public final class h extends c.a {

    /* renamed from: a  reason: collision with root package name */
    final Executor f7036a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Executor executor) {
        this.f7036a = executor;
    }

    @Override // e.c.a
    @Nullable
    public c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        if (a(type) != b.class) {
            return null;
        }
        final Type e2 = u.e(type);
        return new c<Object, b<?>>() { // from class: e.h.1
            @Override // e.c
            public Type a() {
                return e2;
            }

            @Override // e.c
            /* renamed from: b */
            public b<Object> a(b<Object> bVar) {
                return new a(h.this.f7036a, bVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExecutorCallAdapterFactory.java */
    /* loaded from: classes2.dex */
    public static final class a<T> implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        final Executor f7039a;

        /* renamed from: b  reason: collision with root package name */
        final b<T> f7040b;

        a(Executor executor, b<T> bVar) {
            this.f7039a = executor;
            this.f7040b = bVar;
        }

        @Override // e.b
        public void a(final d<T> dVar) {
            u.a(dVar, "callback == null");
            this.f7040b.a(new d<T>() { // from class: e.h.a.1
                @Override // e.d
                public void a(b<T> bVar, final r<T> rVar) {
                    a.this.f7039a.execute(new Runnable() { // from class: e.h.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.f7040b.c()) {
                                dVar.a(a.this, new IOException("Canceled"));
                            } else {
                                dVar.a(a.this, rVar);
                            }
                        }
                    });
                }

                @Override // e.d
                public void a(b<T> bVar, final Throwable th) {
                    a.this.f7039a.execute(new Runnable() { // from class: e.h.a.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            dVar.a(a.this, th);
                        }
                    });
                }
            });
        }

        @Override // e.b
        public r<T> a() {
            return this.f7040b.a();
        }

        @Override // e.b
        public void b() {
            this.f7040b.b();
        }

        @Override // e.b
        public boolean c() {
            return this.f7040b.c();
        }

        @Override // e.b
        /* renamed from: d */
        public b<T> clone() {
            return new a(this.f7039a, this.f7040b.d());
        }
    }
}
