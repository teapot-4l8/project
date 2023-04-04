package androidx.recyclerview.widget;

import androidx.core.g.e;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewInfoStore.java */
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    final androidx.b.g<RecyclerView.x, a> f2378a = new androidx.b.g<>();

    /* renamed from: b  reason: collision with root package name */
    final androidx.b.d<RecyclerView.x> f2379b = new androidx.b.d<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewInfoStore.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(RecyclerView.x xVar);

        void a(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void b(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void c(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f2378a.clear();
        this.f2379b.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.x xVar, RecyclerView.f.c cVar) {
        a aVar = this.f2378a.get(xVar);
        if (aVar == null) {
            aVar = a.a();
            this.f2378a.put(xVar, aVar);
        }
        aVar.f2382b = cVar;
        aVar.f2381a |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.x xVar) {
        a aVar = this.f2378a.get(xVar);
        return (aVar == null || (aVar.f2381a & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.f.c b(RecyclerView.x xVar) {
        return a(xVar, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.f.c c(RecyclerView.x xVar) {
        return a(xVar, 8);
    }

    private RecyclerView.f.c a(RecyclerView.x xVar, int i) {
        a c2;
        RecyclerView.f.c cVar;
        int a2 = this.f2378a.a(xVar);
        if (a2 < 0 || (c2 = this.f2378a.c(a2)) == null || (c2.f2381a & i) == 0) {
            return null;
        }
        c2.f2381a &= i ^ (-1);
        if (i == 4) {
            cVar = c2.f2382b;
        } else if (i == 8) {
            cVar = c2.f2383c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((c2.f2381a & 12) == 0) {
            this.f2378a.d(a2);
            a.a(c2);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j, RecyclerView.x xVar) {
        this.f2379b.b(j, xVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.x xVar, RecyclerView.f.c cVar) {
        a aVar = this.f2378a.get(xVar);
        if (aVar == null) {
            aVar = a.a();
            this.f2378a.put(xVar, aVar);
        }
        aVar.f2381a |= 2;
        aVar.f2382b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(RecyclerView.x xVar) {
        a aVar = this.f2378a.get(xVar);
        return (aVar == null || (aVar.f2381a & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.x a(long j) {
        return this.f2379b.a(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(RecyclerView.x xVar, RecyclerView.f.c cVar) {
        a aVar = this.f2378a.get(xVar);
        if (aVar == null) {
            aVar = a.a();
            this.f2378a.put(xVar, aVar);
        }
        aVar.f2383c = cVar;
        aVar.f2381a |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(RecyclerView.x xVar) {
        a aVar = this.f2378a.get(xVar);
        if (aVar == null) {
            aVar = a.a();
            this.f2378a.put(xVar, aVar);
        }
        aVar.f2381a |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(RecyclerView.x xVar) {
        a aVar = this.f2378a.get(xVar);
        if (aVar == null) {
            return;
        }
        aVar.f2381a &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        for (int size = this.f2378a.size() - 1; size >= 0; size--) {
            RecyclerView.x b2 = this.f2378a.b(size);
            a d2 = this.f2378a.d(size);
            if ((d2.f2381a & 3) == 3) {
                bVar.a(b2);
            } else if ((d2.f2381a & 1) != 0) {
                if (d2.f2382b == null) {
                    bVar.a(b2);
                } else {
                    bVar.a(b2, d2.f2382b, d2.f2383c);
                }
            } else if ((d2.f2381a & 14) == 14) {
                bVar.b(b2, d2.f2382b, d2.f2383c);
            } else if ((d2.f2381a & 12) == 12) {
                bVar.c(b2, d2.f2382b, d2.f2383c);
            } else if ((d2.f2381a & 4) != 0) {
                bVar.a(b2, d2.f2382b, null);
            } else if ((d2.f2381a & 8) != 0) {
                bVar.b(b2, d2.f2382b, d2.f2383c);
            } else {
                int i = d2.f2381a;
            }
            a.a(d2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(RecyclerView.x xVar) {
        int b2 = this.f2379b.b() - 1;
        while (true) {
            if (b2 < 0) {
                break;
            } else if (xVar == this.f2379b.c(b2)) {
                this.f2379b.a(b2);
                break;
            } else {
                b2--;
            }
        }
        a remove = this.f2378a.remove(xVar);
        if (remove != null) {
            a.a(remove);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        a.b();
    }

    public void h(RecyclerView.x xVar) {
        f(xVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewInfoStore.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        static e.a<a> f2380d = new e.b(20);

        /* renamed from: a  reason: collision with root package name */
        int f2381a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.f.c f2382b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.f.c f2383c;

        private a() {
        }

        static a a() {
            a a2 = f2380d.a();
            return a2 == null ? new a() : a2;
        }

        static void a(a aVar) {
            aVar.f2381a = 0;
            aVar.f2382b = null;
            aVar.f2383c = null;
            f2380d.a(aVar);
        }

        static void b() {
            do {
            } while (f2380d.a() != null);
        }
    }
}
