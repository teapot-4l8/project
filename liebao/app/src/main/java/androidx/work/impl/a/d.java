package androidx.work.impl.a;

import android.content.Context;
import androidx.work.h;
import androidx.work.impl.a.a.c;
import androidx.work.impl.a.a.e;
import androidx.work.impl.a.a.f;
import androidx.work.impl.a.a.g;
import androidx.work.impl.b.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WorkConstraintsTracker.java */
/* loaded from: classes.dex */
public class d implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2840a = h.a("WorkConstraintsTracker");

    /* renamed from: b  reason: collision with root package name */
    private final c f2841b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.work.impl.a.a.c<?>[] f2842c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f2843d;

    public d(Context context, androidx.work.impl.utils.b.a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.f2841b = cVar;
        this.f2842c = new androidx.work.impl.a.a.c[]{new androidx.work.impl.a.a.a(applicationContext, aVar), new androidx.work.impl.a.a.b(applicationContext, aVar), new androidx.work.impl.a.a.h(applicationContext, aVar), new androidx.work.impl.a.a.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
        this.f2843d = new Object();
    }

    public void a(List<j> list) {
        synchronized (this.f2843d) {
            for (androidx.work.impl.a.a.c<?> cVar : this.f2842c) {
                cVar.a((c.a) null);
            }
            for (androidx.work.impl.a.a.c<?> cVar2 : this.f2842c) {
                cVar2.a(list);
            }
            for (androidx.work.impl.a.a.c<?> cVar3 : this.f2842c) {
                cVar3.a((c.a) this);
            }
        }
    }

    public void a() {
        synchronized (this.f2843d) {
            for (androidx.work.impl.a.a.c<?> cVar : this.f2842c) {
                cVar.a();
            }
        }
    }

    public boolean a(String str) {
        androidx.work.impl.a.a.c<?>[] cVarArr;
        synchronized (this.f2843d) {
            for (androidx.work.impl.a.a.c<?> cVar : this.f2842c) {
                if (cVar.a(str)) {
                    h.a().b(f2840a, String.format("Work %s constrained by %s", str, cVar.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    @Override // androidx.work.impl.a.a.c.a
    public void b(List<String> list) {
        synchronized (this.f2843d) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (a(str)) {
                    h.a().b(f2840a, String.format("Constraints met for %s", str), new Throwable[0]);
                    arrayList.add(str);
                }
            }
            if (this.f2841b != null) {
                this.f2841b.a(arrayList);
            }
        }
    }

    @Override // androidx.work.impl.a.a.c.a
    public void c(List<String> list) {
        synchronized (this.f2843d) {
            if (this.f2841b != null) {
                this.f2841b.b(list);
            }
        }
    }
}
