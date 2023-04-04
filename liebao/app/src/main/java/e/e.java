package e;

import e.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;

/* compiled from: CompletableFutureCallAdapterFactory.java */
/* loaded from: classes.dex */
final class e extends c.a {

    /* renamed from: a  reason: collision with root package name */
    static final c.a f7022a = new e();

    e() {
    }

    @Override // e.c.a
    @Nullable
    public c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        if (a(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type a2 = a(0, (ParameterizedType) type);
        if (a(a2) != r.class) {
            return new a(a2);
        }
        if (!(a2 instanceof ParameterizedType)) {
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        return new b(a(0, (ParameterizedType) a2));
    }

    /* compiled from: CompletableFutureCallAdapterFactory.java */
    /* loaded from: classes2.dex */
    private static final class a<R> implements c<R, CompletableFuture<R>> {

        /* renamed from: a  reason: collision with root package name */
        private final Type f7023a;

        a(Type type) {
            this.f7023a = type;
        }

        @Override // e.c
        public Type a() {
            return this.f7023a;
        }

        @Override // e.c
        /* renamed from: b */
        public CompletableFuture<R> a(final e.b<R> bVar) {
            final CompletableFuture<R> completableFuture = new CompletableFuture<R>() { // from class: e.e.a.1
                @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
                public boolean cancel(boolean z) {
                    if (z) {
                        bVar.b();
                    }
                    return super.cancel(z);
                }
            };
            bVar.a(new d<R>() { // from class: e.e.a.2
                @Override // e.d
                public void a(e.b<R> bVar2, r<R> rVar) {
                    if (rVar.c()) {
                        completableFuture.complete(rVar.d());
                    } else {
                        completableFuture.completeExceptionally(new i(rVar));
                    }
                }

                @Override // e.d
                public void a(e.b<R> bVar2, Throwable th) {
                    completableFuture.completeExceptionally(th);
                }
            });
            return completableFuture;
        }
    }

    /* compiled from: CompletableFutureCallAdapterFactory.java */
    /* loaded from: classes2.dex */
    private static final class b<R> implements c<R, CompletableFuture<r<R>>> {

        /* renamed from: a  reason: collision with root package name */
        private final Type f7028a;

        b(Type type) {
            this.f7028a = type;
        }

        @Override // e.c
        public Type a() {
            return this.f7028a;
        }

        @Override // e.c
        /* renamed from: b */
        public CompletableFuture<r<R>> a(final e.b<R> bVar) {
            final CompletableFuture<r<R>> completableFuture = new CompletableFuture<r<R>>() { // from class: e.e.b.1
                @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
                public boolean cancel(boolean z) {
                    if (z) {
                        bVar.b();
                    }
                    return super.cancel(z);
                }
            };
            bVar.a(new d<R>() { // from class: e.e.b.2
                @Override // e.d
                public void a(e.b<R> bVar2, r<R> rVar) {
                    completableFuture.complete(rVar);
                }

                @Override // e.d
                public void a(e.b<R> bVar2, Throwable th) {
                    completableFuture.completeExceptionally(th);
                }
            });
            return completableFuture;
        }
    }
}
