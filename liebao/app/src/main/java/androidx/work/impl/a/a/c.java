package androidx.work.impl.a.a;

import androidx.work.impl.b.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ConstraintController.java */
/* loaded from: classes.dex */
public abstract class c<T> implements androidx.work.impl.a.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f2808a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private T f2809b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.work.impl.a.b.d<T> f2810c;

    /* renamed from: d  reason: collision with root package name */
    private a f2811d;

    /* compiled from: ConstraintController.java */
    /* loaded from: classes.dex */
    public interface a {
        void b(List<String> list);

        void c(List<String> list);
    }

    abstract boolean a(j jVar);

    abstract boolean b(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(androidx.work.impl.a.b.d<T> dVar) {
        this.f2810c = dVar;
    }

    public void a(a aVar) {
        if (this.f2811d != aVar) {
            this.f2811d = aVar;
            b();
        }
    }

    public void a(List<j> list) {
        this.f2808a.clear();
        for (j jVar : list) {
            if (a(jVar)) {
                this.f2808a.add(jVar.f2864a);
            }
        }
        if (this.f2808a.isEmpty()) {
            this.f2810c.b(this);
        } else {
            this.f2810c.a((androidx.work.impl.a.a) this);
        }
        b();
    }

    public void a() {
        if (this.f2808a.isEmpty()) {
            return;
        }
        this.f2808a.clear();
        this.f2810c.b(this);
    }

    public boolean a(String str) {
        T t = this.f2809b;
        return t != null && b(t) && this.f2808a.contains(str);
    }

    private void b() {
        if (this.f2808a.isEmpty() || this.f2811d == null) {
            return;
        }
        T t = this.f2809b;
        if (t == null || b(t)) {
            this.f2811d.c(this.f2808a);
        } else {
            this.f2811d.b(this.f2808a);
        }
    }

    @Override // androidx.work.impl.a.a
    public void a(T t) {
        this.f2809b = t;
        b();
    }
}
