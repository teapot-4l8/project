package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.h;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* compiled from: AsyncListDiffer.java */
/* loaded from: classes.dex */
public class d<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f2222e = new b();

    /* renamed from: a  reason: collision with root package name */
    final c<T> f2223a;

    /* renamed from: b  reason: collision with root package name */
    Executor f2224b;

    /* renamed from: c  reason: collision with root package name */
    int f2225c;

    /* renamed from: d  reason: collision with root package name */
    private final q f2226d;
    private final List<a<T>> f;
    private List<T> g;
    private List<T> h;

    /* compiled from: AsyncListDiffer.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        void a(List<T> list, List<T> list2);
    }

    /* compiled from: AsyncListDiffer.java */
    /* loaded from: classes.dex */
    private static class b implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final Handler f2235a = new Handler(Looper.getMainLooper());

        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f2235a.post(runnable);
        }
    }

    public d(RecyclerView.a aVar, h.c<T> cVar) {
        this(new androidx.recyclerview.widget.b(aVar), new c.a(cVar).a());
    }

    public d(q qVar, c<T> cVar) {
        this.f = new CopyOnWriteArrayList();
        this.h = Collections.emptyList();
        this.f2226d = qVar;
        this.f2223a = cVar;
        if (cVar.a() != null) {
            this.f2224b = cVar.a();
        } else {
            this.f2224b = f2222e;
        }
    }

    public List<T> a() {
        return this.h;
    }

    public void a(List<T> list) {
        a(list, null);
    }

    public void a(final List<T> list, final Runnable runnable) {
        final int i = this.f2225c + 1;
        this.f2225c = i;
        final List<T> list2 = this.g;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List<T> list3 = this.h;
        if (list == null) {
            int size = list2.size();
            this.g = null;
            this.h = Collections.emptyList();
            this.f2226d.b(0, size);
            b(list3, runnable);
        } else if (list2 == null) {
            this.g = list;
            this.h = Collections.unmodifiableList(list);
            this.f2226d.a(0, list.size());
            b(list3, runnable);
        } else {
            this.f2223a.b().execute(new Runnable() { // from class: androidx.recyclerview.widget.d.1
                @Override // java.lang.Runnable
                public void run() {
                    final h.b a2 = h.a(new h.a() { // from class: androidx.recyclerview.widget.d.1.1
                        @Override // androidx.recyclerview.widget.h.a
                        public int a() {
                            return list2.size();
                        }

                        @Override // androidx.recyclerview.widget.h.a
                        public int b() {
                            return list.size();
                        }

                        @Override // androidx.recyclerview.widget.h.a
                        public boolean a(int i2, int i3) {
                            Object obj = list2.get(i2);
                            Object obj2 = list.get(i3);
                            if (obj == null || obj2 == null) {
                                return obj == null && obj2 == null;
                            }
                            return d.this.f2223a.c().a(obj, obj2);
                        }

                        @Override // androidx.recyclerview.widget.h.a
                        public boolean b(int i2, int i3) {
                            Object obj = list2.get(i2);
                            Object obj2 = list.get(i3);
                            if (obj == null || obj2 == null) {
                                if (obj == null && obj2 == null) {
                                    return true;
                                }
                                throw new AssertionError();
                            }
                            return d.this.f2223a.c().b(obj, obj2);
                        }

                        @Override // androidx.recyclerview.widget.h.a
                        public Object c(int i2, int i3) {
                            Object obj = list2.get(i2);
                            Object obj2 = list.get(i3);
                            if (obj != null && obj2 != null) {
                                return d.this.f2223a.c().c(obj, obj2);
                            }
                            throw new AssertionError();
                        }
                    });
                    d.this.f2224b.execute(new Runnable() { // from class: androidx.recyclerview.widget.d.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.this.f2225c == i) {
                                d.this.a(list, a2, runnable);
                            }
                        }
                    });
                }
            });
        }
    }

    void a(List<T> list, h.b bVar, Runnable runnable) {
        List<T> list2 = this.h;
        this.g = list;
        this.h = Collections.unmodifiableList(list);
        bVar.a(this.f2226d);
        b(list2, runnable);
    }

    private void b(List<T> list, Runnable runnable) {
        for (a<T> aVar : this.f) {
            aVar.a(list, this.h);
        }
        if (runnable != null) {
            runnable.run();
        }
    }
}
