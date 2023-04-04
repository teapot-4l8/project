package a.a.a.d;

import a.a.a.d.bx;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: RRset.java */
/* loaded from: classes.dex */
public class bu<T extends bx> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<T> f192a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<bt> f193b;

    /* renamed from: c  reason: collision with root package name */
    private short f194c;

    /* renamed from: d  reason: collision with root package name */
    private long f195d;

    public bu() {
        this.f192a = new ArrayList<>(1);
        this.f193b = new ArrayList<>(0);
    }

    public bu(T t) {
        this();
        a((bu<T>) t);
    }

    public bu(bu<T> buVar) {
        this.f192a = new ArrayList<>(buVar.f192a);
        this.f193b = new ArrayList<>(buVar.f193b);
        this.f194c = buVar.f194c;
        this.f195d = buVar.f195d;
    }

    public void a(T t) {
        if (t instanceof bt) {
            a((bu<T>) ((bt) t), this.f193b);
        } else {
            a((bu<T>) t, this.f192a);
        }
    }

    private <X extends bx> void a(X x, List<X> list) {
        if (this.f193b.isEmpty() && this.f192a.isEmpty()) {
            list.add(x);
            this.f195d = x.m();
            return;
        }
        b(x, this.f192a);
        b(x, this.f193b);
        if (x.m() > this.f195d) {
            x = (X) x.n();
            x.a(this.f195d);
        } else if (x.m() < this.f195d) {
            this.f195d = x.m();
            a(x.m(), this.f192a);
            a(x.m(), this.f193b);
        }
        if (list.contains(x)) {
            return;
        }
        list.add(x);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <X extends bx> void a(long j, List<X> list) {
        for (int i = 0; i < list.size(); i++) {
            bx n = ((bx) list.get(i)).n();
            n.a(j);
            list.set(i, n);
        }
    }

    private void b(bx bxVar, List<? extends bx> list) {
        if (!list.isEmpty() && !bxVar.a(list.get(0))) {
            throw new IllegalArgumentException("record does not match rrset");
        }
    }

    public List<T> a(boolean z) {
        if (!z || this.f192a.size() <= 1) {
            return Collections.unmodifiableList(this.f192a);
        }
        ArrayList arrayList = new ArrayList(this.f192a.size());
        short s = this.f194c;
        this.f194c = (short) (s + 1);
        int size = s % this.f192a.size();
        ArrayList<T> arrayList2 = this.f192a;
        arrayList.addAll(arrayList2.subList(size, arrayList2.size()));
        arrayList.addAll(this.f192a.subList(0, size));
        return arrayList;
    }

    public List<T> c() {
        return a(true);
    }

    public bj d() {
        return g().j();
    }

    public int b() {
        return g().l_();
    }

    public int e() {
        return g().l();
    }

    public long f() {
        return g().m();
    }

    public bx g() {
        if (!this.f192a.isEmpty()) {
            return this.f192a.get(0);
        }
        if (!this.f193b.isEmpty()) {
            return this.f193b.get(0);
        }
        throw new IllegalStateException("rrset is empty");
    }

    private void a(Iterator<? extends bx> it, StringBuilder sb) {
        while (it.hasNext()) {
            sb.append("[");
            sb.append(it.next().i());
            sb.append("]");
            if (it.hasNext()) {
                sb.append(" ");
            }
        }
    }

    public String toString() {
        if (this.f192a.size() == 0) {
            return "{empty}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        sb.append(d());
        sb.append(" ");
        sb.append(f());
        sb.append(" ");
        sb.append(p.b(e()));
        sb.append(" ");
        sb.append(cz.b(b()));
        sb.append(" ");
        a(this.f192a.iterator(), sb);
        if (!this.f193b.isEmpty()) {
            sb.append(" sigs: ");
            a(this.f193b.iterator(), sb);
        }
        sb.append(" }");
        return sb.toString();
    }
}
