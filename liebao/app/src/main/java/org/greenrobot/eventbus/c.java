package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

/* compiled from: EventBus.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f7790a = "EventBus";

    /* renamed from: b  reason: collision with root package name */
    static volatile c f7791b;

    /* renamed from: c  reason: collision with root package name */
    private static final d f7792c = new d();

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f7793d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<q>> f7794e;
    private final Map<Object, List<Class<?>>> f;
    private final Map<Class<?>, Object> g;
    private final ThreadLocal<a> h;
    private final h i;
    private final l j;
    private final b k;
    private final org.greenrobot.eventbus.a l;
    private final p m;
    private final ExecutorService n;
    private final boolean o;
    private final boolean p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f7795q;
    private final boolean r;
    private final boolean s;
    private final boolean t;
    private final int u;
    private final g v;

    public static c a() {
        if (f7791b == null) {
            synchronized (c.class) {
                if (f7791b == null) {
                    f7791b = new c();
                }
            }
        }
        return f7791b;
    }

    public c() {
        this(f7792c);
    }

    c(d dVar) {
        this.h = new ThreadLocal<a>() { // from class: org.greenrobot.eventbus.c.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* renamed from: a */
            public a initialValue() {
                return new a();
            }
        };
        this.v = dVar.a();
        this.f7794e = new HashMap();
        this.f = new HashMap();
        this.g = new ConcurrentHashMap();
        h b2 = dVar.b();
        this.i = b2;
        this.j = b2 != null ? b2.a(this) : null;
        this.k = new b(this);
        this.l = new org.greenrobot.eventbus.a(this);
        this.u = dVar.j != null ? dVar.j.size() : 0;
        this.m = new p(dVar.j, dVar.h, dVar.g);
        this.p = dVar.f7803a;
        this.f7795q = dVar.f7804b;
        this.r = dVar.f7805c;
        this.s = dVar.f7806d;
        this.o = dVar.f7807e;
        this.t = dVar.f;
        this.n = dVar.i;
    }

    public void a(Object obj) {
        List<o> a2 = this.m.a(obj.getClass());
        synchronized (this) {
            for (o oVar : a2) {
                a(obj, oVar);
            }
        }
    }

    private void a(Object obj, o oVar) {
        Class<?> cls = oVar.f7829c;
        q qVar = new q(obj, oVar);
        CopyOnWriteArrayList<q> copyOnWriteArrayList = this.f7794e.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f7794e.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(qVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || oVar.f7830d > copyOnWriteArrayList.get(i).f7843b.f7830d) {
                copyOnWriteArrayList.add(i, qVar);
                break;
            }
        }
        List<Class<?>> list = this.f.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.f.put(obj, list);
        }
        list.add(cls);
        if (oVar.f7831e) {
            if (this.t) {
                for (Map.Entry<Class<?>, Object> entry : this.g.entrySet()) {
                    if (cls.isAssignableFrom(entry.getKey())) {
                        b(qVar, entry.getValue());
                    }
                }
                return;
            }
            b(qVar, this.g.get(cls));
        }
    }

    private void b(q qVar, Object obj) {
        if (obj != null) {
            a(qVar, obj, d());
        }
    }

    private boolean d() {
        h hVar = this.i;
        if (hVar != null) {
            return hVar.a();
        }
        return true;
    }

    public synchronized boolean b(Object obj) {
        return this.f.containsKey(obj);
    }

    private void a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList = this.f7794e.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                q qVar = copyOnWriteArrayList.get(i);
                if (qVar.f7842a == obj) {
                    qVar.f7844c = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    public synchronized void c(Object obj) {
        List<Class<?>> list = this.f.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                a(obj, cls);
            }
            this.f.remove(obj);
        } else {
            g gVar = this.v;
            Level level = Level.WARNING;
            gVar.a(level, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public void d(Object obj) {
        a aVar = this.h.get();
        List<Object> list = aVar.f7798a;
        list.add(obj);
        if (aVar.f7799b) {
            return;
        }
        aVar.f7800c = d();
        aVar.f7799b = true;
        if (aVar.f) {
            throw new e("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                a(list.remove(0), aVar);
            } finally {
                aVar.f7799b = false;
                aVar.f7800c = false;
            }
        }
    }

    private void a(Object obj, a aVar) {
        boolean a2;
        Class<?> cls = obj.getClass();
        if (this.t) {
            List<Class<?>> a3 = a(cls);
            int size = a3.size();
            a2 = false;
            for (int i = 0; i < size; i++) {
                a2 |= a(obj, aVar, a3.get(i));
            }
        } else {
            a2 = a(obj, aVar, cls);
        }
        if (a2) {
            return;
        }
        if (this.f7795q) {
            g gVar = this.v;
            Level level = Level.FINE;
            gVar.a(level, "No subscribers registered for event " + cls);
        }
        if (!this.s || cls == i.class || cls == n.class) {
            return;
        }
        d(new i(this, obj));
    }

    private boolean a(Object obj, a aVar, Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f7794e.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<q> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            aVar.f7802e = obj;
            aVar.f7801d = next;
            try {
                a(next, obj, aVar.f7800c);
                if (aVar.f) {
                    return true;
                }
            } finally {
                aVar.f7802e = null;
                aVar.f7801d = null;
                aVar.f = false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventBus.java */
    /* renamed from: org.greenrobot.eventbus.c$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7797a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            f7797a = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7797a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7797a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7797a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7797a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void a(q qVar, Object obj, boolean z) {
        int i = AnonymousClass2.f7797a[qVar.f7843b.f7828b.ordinal()];
        if (i == 1) {
            a(qVar, obj);
        } else if (i == 2) {
            if (z) {
                a(qVar, obj);
            } else {
                this.j.a(qVar, obj);
            }
        } else if (i == 3) {
            l lVar = this.j;
            if (lVar != null) {
                lVar.a(qVar, obj);
            } else {
                a(qVar, obj);
            }
        } else if (i == 4) {
            if (z) {
                this.k.a(qVar, obj);
            } else {
                a(qVar, obj);
            }
        } else if (i == 5) {
            this.l.a(qVar, obj);
        } else {
            throw new IllegalStateException("Unknown thread mode: " + qVar.f7843b.f7828b);
        }
    }

    private static List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        synchronized (f7793d) {
            list = f7793d.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                f7793d.put(cls, list);
            }
        }
        return list;
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        Object obj = jVar.f7818a;
        q qVar = jVar.f7819b;
        j.a(jVar);
        if (qVar.f7844c) {
            a(qVar, obj);
        }
    }

    void a(q qVar, Object obj) {
        try {
            qVar.f7843b.f7827a.invoke(qVar.f7842a, obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e3) {
            a(qVar, obj, e3.getCause());
        }
    }

    private void a(q qVar, Object obj, Throwable th) {
        if (obj instanceof n) {
            if (this.p) {
                g gVar = this.v;
                Level level = Level.SEVERE;
                gVar.a(level, "SubscriberExceptionEvent subscriber " + qVar.f7842a.getClass() + " threw an exception", th);
                n nVar = (n) obj;
                g gVar2 = this.v;
                Level level2 = Level.SEVERE;
                gVar2.a(level2, "Initial event " + nVar.f7825c + " caused exception in " + nVar.f7826d, nVar.f7824b);
            }
        } else if (this.o) {
            throw new e("Invoking subscriber failed", th);
        } else {
            if (this.p) {
                g gVar3 = this.v;
                Level level3 = Level.SEVERE;
                gVar3.a(level3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + qVar.f7842a.getClass(), th);
            }
            if (this.r) {
                d(new n(this, th, obj, qVar.f7842a));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventBus.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<Object> f7798a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        boolean f7799b;

        /* renamed from: c  reason: collision with root package name */
        boolean f7800c;

        /* renamed from: d  reason: collision with root package name */
        q f7801d;

        /* renamed from: e  reason: collision with root package name */
        Object f7802e;
        boolean f;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorService b() {
        return this.n;
    }

    public g c() {
        return this.v;
    }

    public String toString() {
        return "EventBus[indexCount=" + this.u + ", eventInheritance=" + this.t + "]";
    }
}
