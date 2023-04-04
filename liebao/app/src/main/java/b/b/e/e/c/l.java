package b.b.e.e.c;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservablePublish.java */
/* loaded from: classes.dex */
public final class l<T> extends b.b.f.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final b.b.f<T> f3353a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<b<T>> f3354b;

    /* renamed from: c  reason: collision with root package name */
    final b.b.f<T> f3355c;

    public static <T> b.b.f.a<T> c(b.b.f<T> fVar) {
        AtomicReference atomicReference = new AtomicReference();
        return b.b.g.a.a((b.b.f.a) new l(new c(atomicReference), fVar, atomicReference));
    }

    private l(b.b.f<T> fVar, b.b.f<T> fVar2, AtomicReference<b<T>> atomicReference) {
        this.f3355c = fVar;
        this.f3353a = fVar2;
        this.f3354b = atomicReference;
    }

    @Override // b.b.e
    protected void b(b.b.h<? super T> hVar) {
        this.f3355c.a(hVar);
    }

    @Override // b.b.f.a
    public void a(b.b.d.d<? super b.b.b.b> dVar) {
        b<T> bVar;
        while (true) {
            bVar = this.f3354b.get();
            if (bVar != null && !bVar.c()) {
                break;
            }
            b<T> bVar2 = new b<>(this.f3354b);
            if (this.f3354b.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z = true;
        z = (bVar.f3361e.get() || !bVar.f3361e.compareAndSet(false, true)) ? false : false;
        try {
            dVar.a(bVar);
            if (z) {
                this.f3353a.a(bVar);
            }
        } catch (Throwable th) {
            b.b.c.b.b(th);
            throw b.b.e.h.c.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes.dex */
    public static final class b<T> implements b.b.b.b, b.b.h<T> {

        /* renamed from: b  reason: collision with root package name */
        static final a[] f3357b = new a[0];

        /* renamed from: c  reason: collision with root package name */
        static final a[] f3358c = new a[0];

        /* renamed from: a  reason: collision with root package name */
        final AtomicReference<b<T>> f3359a;
        final AtomicReference<b.b.b.b> f = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<a<T>[]> f3360d = new AtomicReference<>(f3357b);

        /* renamed from: e  reason: collision with root package name */
        final AtomicBoolean f3361e = new AtomicBoolean();

        b(AtomicReference<b<T>> atomicReference) {
            this.f3359a = atomicReference;
        }

        @Override // b.b.b.b
        public void a() {
            if (this.f3360d.getAndSet(f3358c) != f3358c) {
                this.f3359a.compareAndSet(this, null);
                b.b.e.a.b.a(this.f);
            }
        }

        public boolean c() {
            return this.f3360d.get() == f3358c;
        }

        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            b.b.e.a.b.a(this.f, bVar);
        }

        @Override // b.b.h
        public void a_(T t) {
            for (a<T> aVar : this.f3360d.get()) {
                aVar.f3356a.a_(t);
            }
        }

        @Override // b.b.h
        public void a(Throwable th) {
            this.f3359a.compareAndSet(this, null);
            a<T>[] andSet = this.f3360d.getAndSet(f3358c);
            if (andSet.length != 0) {
                for (a<T> aVar : andSet) {
                    aVar.f3356a.a(th);
                }
                return;
            }
            b.b.g.a.a(th);
        }

        @Override // b.b.h
        public void b() {
            this.f3359a.compareAndSet(this, null);
            for (a<T> aVar : this.f3360d.getAndSet(f3358c)) {
                aVar.f3356a.b();
            }
        }

        boolean a(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.f3360d.get();
                if (aVarArr == f3358c) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.f3360d.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.f3360d.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (aVarArr[i2].equals(aVar)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = f3357b;
                } else {
                    a[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                    System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.f3360d.compareAndSet(aVarArr, aVarArr2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<Object> implements b.b.b.b {

        /* renamed from: a  reason: collision with root package name */
        final b.b.h<? super T> f3356a;

        a(b.b.h<? super T> hVar) {
            this.f3356a = hVar;
        }

        @Override // b.b.b.b
        public void a() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((b) andSet).b(this);
        }

        void a(b<T> bVar) {
            if (compareAndSet(null, bVar)) {
                return;
            }
            bVar.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes.dex */
    public static final class c<T> implements b.b.f<T> {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicReference<b<T>> f3362a;

        c(AtomicReference<b<T>> atomicReference) {
            this.f3362a = atomicReference;
        }

        @Override // b.b.f
        public void a(b.b.h<? super T> hVar) {
            a aVar = new a(hVar);
            hVar.a(aVar);
            while (true) {
                b<T> bVar = this.f3362a.get();
                if (bVar == null || bVar.c()) {
                    b<T> bVar2 = new b<>(this.f3362a);
                    if (this.f3362a.compareAndSet(bVar, bVar2)) {
                        bVar = bVar2;
                    } else {
                        continue;
                    }
                }
                if (bVar.a(aVar)) {
                    aVar.a(bVar);
                    return;
                }
            }
        }
    }
}
