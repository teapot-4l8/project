package androidx.work.impl.a.b;

import android.content.Context;
import androidx.work.h;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: ConstraintTracker.java */
/* loaded from: classes.dex */
public abstract class d<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f2823d = h.a("ConstraintTracker");

    /* renamed from: a  reason: collision with root package name */
    protected final androidx.work.impl.utils.b.a f2824a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f2825b;

    /* renamed from: c  reason: collision with root package name */
    T f2826c;

    /* renamed from: e  reason: collision with root package name */
    private final Object f2827e = new Object();
    private final Set<androidx.work.impl.a.a<T>> f = new LinkedHashSet();

    public abstract T c();

    public abstract void d();

    public abstract void e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, androidx.work.impl.utils.b.a aVar) {
        this.f2825b = context.getApplicationContext();
        this.f2824a = aVar;
    }

    public void a(androidx.work.impl.a.a<T> aVar) {
        synchronized (this.f2827e) {
            if (this.f.add(aVar)) {
                if (this.f.size() == 1) {
                    this.f2826c = c();
                    h.a().b(f2823d, String.format("%s: initial state = %s", getClass().getSimpleName(), this.f2826c), new Throwable[0]);
                    d();
                }
                aVar.a(this.f2826c);
            }
        }
    }

    public void b(androidx.work.impl.a.a<T> aVar) {
        synchronized (this.f2827e) {
            if (this.f.remove(aVar) && this.f.isEmpty()) {
                e();
            }
        }
    }

    public void a(T t) {
        synchronized (this.f2827e) {
            if (this.f2826c != t && (this.f2826c == null || !this.f2826c.equals(t))) {
                this.f2826c = t;
                final ArrayList arrayList = new ArrayList(this.f);
                this.f2824a.a().execute(new Runnable() { // from class: androidx.work.impl.a.b.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (androidx.work.impl.a.a aVar : arrayList) {
                            aVar.a(d.this.f2826c);
                        }
                    }
                });
            }
        }
    }
}
