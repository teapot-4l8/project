package b.b.b;

import b.b.e.h.f;
import java.util.ArrayList;

/* compiled from: CompositeDisposable.java */
/* loaded from: classes.dex */
public final class a implements b, b.b.e.a.a {

    /* renamed from: a  reason: collision with root package name */
    f<b> f3281a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f3282b;

    @Override // b.b.b.b
    public void a() {
        if (this.f3282b) {
            return;
        }
        synchronized (this) {
            if (this.f3282b) {
                return;
            }
            this.f3282b = true;
            f<b> fVar = this.f3281a;
            this.f3281a = null;
            a(fVar);
        }
    }

    public boolean b() {
        return this.f3282b;
    }

    @Override // b.b.e.a.a
    public boolean a(b bVar) {
        b.b.e.b.b.a(bVar, "d is null");
        if (!this.f3282b) {
            synchronized (this) {
                if (!this.f3282b) {
                    f<b> fVar = this.f3281a;
                    if (fVar == null) {
                        fVar = new f<>();
                        this.f3281a = fVar;
                    }
                    fVar.a((f<b>) bVar);
                    return true;
                }
            }
        }
        bVar.a();
        return false;
    }

    @Override // b.b.e.a.a
    public boolean b(b bVar) {
        if (c(bVar)) {
            bVar.a();
            return true;
        }
        return false;
    }

    @Override // b.b.e.a.a
    public boolean c(b bVar) {
        b.b.e.b.b.a(bVar, "Disposable item is null");
        if (this.f3282b) {
            return false;
        }
        synchronized (this) {
            if (this.f3282b) {
                return false;
            }
            f<b> fVar = this.f3281a;
            if (fVar != null && fVar.b(bVar)) {
                return true;
            }
            return false;
        }
    }

    public void c() {
        if (this.f3282b) {
            return;
        }
        synchronized (this) {
            if (this.f3282b) {
                return;
            }
            f<b> fVar = this.f3281a;
            this.f3281a = null;
            a(fVar);
        }
    }

    void a(f<b> fVar) {
        Object[] b2;
        if (fVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : fVar.b()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).a();
                } catch (Throwable th) {
                    b.b.c.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw b.b.e.h.c.a((Throwable) arrayList.get(0));
            }
            throw new b.b.c.a(arrayList);
        }
    }
}
