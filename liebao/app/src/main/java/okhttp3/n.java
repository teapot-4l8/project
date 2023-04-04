package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.z;

/* compiled from: Dispatcher.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f7690a = !n.class.desiredAssertionStatus();
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Runnable f7693d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private ExecutorService f7694e;

    /* renamed from: b  reason: collision with root package name */
    private int f7691b = 64;

    /* renamed from: c  reason: collision with root package name */
    private int f7692c = 5;
    private final Deque<z.a> f = new ArrayDeque();
    private final Deque<z.a> g = new ArrayDeque();
    private final Deque<z> h = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.f7694e == null) {
            this.f7694e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.c.a("OkHttp Dispatcher", false));
        }
        return this.f7694e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(z.a aVar) {
        synchronized (this) {
            this.f.add(aVar);
        }
        c();
    }

    private boolean c() {
        int i;
        boolean z;
        if (f7690a || !Thread.holdsLock(this)) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                Iterator<z.a> it = this.f.iterator();
                while (it.hasNext()) {
                    z.a next = it.next();
                    if (this.g.size() >= this.f7691b) {
                        break;
                    } else if (c(next) < this.f7692c) {
                        it.remove();
                        arrayList.add(next);
                        this.g.add(next);
                    }
                }
                z = b() > 0;
            }
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                ((z.a) arrayList.get(i)).a(a());
            }
            return z;
        }
        throw new AssertionError();
    }

    private int c(z.a aVar) {
        int i = 0;
        for (z.a aVar2 : this.g) {
            if (!aVar2.b().f7756e && aVar2.a().equals(aVar.a())) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(z zVar) {
        this.h.add(zVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(z.a aVar) {
        a(this.g, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(z zVar) {
        a(this.h, zVar);
    }

    private <T> void a(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f7693d;
        }
        if (c() || runnable == null) {
            return;
        }
        runnable.run();
    }

    public synchronized int b() {
        return this.g.size() + this.h.size();
    }
}
