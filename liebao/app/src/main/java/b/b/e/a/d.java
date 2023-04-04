package b.b.e.a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ListCompositeDisposable.java */
/* loaded from: classes.dex */
public final class d implements b.b.b.b, a {

    /* renamed from: a  reason: collision with root package name */
    List<b.b.b.b> f3295a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f3296b;

    @Override // b.b.b.b
    public void a() {
        if (this.f3296b) {
            return;
        }
        synchronized (this) {
            if (this.f3296b) {
                return;
            }
            this.f3296b = true;
            List<b.b.b.b> list = this.f3295a;
            this.f3295a = null;
            a(list);
        }
    }

    @Override // b.b.e.a.a
    public boolean a(b.b.b.b bVar) {
        b.b.e.b.b.a(bVar, "d is null");
        if (!this.f3296b) {
            synchronized (this) {
                if (!this.f3296b) {
                    List list = this.f3295a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f3295a = list;
                    }
                    list.add(bVar);
                    return true;
                }
            }
        }
        bVar.a();
        return false;
    }

    @Override // b.b.e.a.a
    public boolean b(b.b.b.b bVar) {
        if (c(bVar)) {
            bVar.a();
            return true;
        }
        return false;
    }

    @Override // b.b.e.a.a
    public boolean c(b.b.b.b bVar) {
        b.b.e.b.b.a(bVar, "Disposable item is null");
        if (this.f3296b) {
            return false;
        }
        synchronized (this) {
            if (this.f3296b) {
                return false;
            }
            List<b.b.b.b> list = this.f3295a;
            if (list != null && list.remove(bVar)) {
                return true;
            }
            return false;
        }
    }

    void a(List<b.b.b.b> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        for (b.b.b.b bVar : list) {
            try {
                bVar.a();
            } catch (Throwable th) {
                b.b.c.b.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
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
