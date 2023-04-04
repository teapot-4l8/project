package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriberMethodFinder.java */
/* loaded from: classes2.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, List<o>> f7832a = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final a[] f7833e = new a[4];

    /* renamed from: b  reason: collision with root package name */
    private List<org.greenrobot.eventbus.a.b> f7834b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7835c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f7836d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(List<org.greenrobot.eventbus.a.b> list, boolean z, boolean z2) {
        this.f7834b = list;
        this.f7835c = z;
        this.f7836d = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<o> a(Class<?> cls) {
        List<o> b2;
        List<o> list = f7832a.get(cls);
        if (list != null) {
            return list;
        }
        if (this.f7836d) {
            b2 = c(cls);
        } else {
            b2 = b(cls);
        }
        if (b2.isEmpty()) {
            throw new e("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
        }
        f7832a.put(cls, b2);
        return b2;
    }

    private List<o> b(Class<?> cls) {
        o[] b2;
        a a2 = a();
        a2.a(cls);
        while (a2.f != null) {
            a2.h = b(a2);
            if (a2.h != null) {
                for (o oVar : a2.h.b()) {
                    if (a2.a(oVar.f7827a, oVar.f7829c)) {
                        a2.f7837a.add(oVar);
                    }
                }
            } else {
                c(a2);
            }
            a2.b();
        }
        return a(a2);
    }

    private List<o> a(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f7837a);
        aVar.a();
        synchronized (f7833e) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                } else if (f7833e[i] == null) {
                    f7833e[i] = aVar;
                    break;
                } else {
                    i++;
                }
            }
        }
        return arrayList;
    }

    private a a() {
        synchronized (f7833e) {
            for (int i = 0; i < 4; i++) {
                a aVar = f7833e[i];
                if (aVar != null) {
                    f7833e[i] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    private org.greenrobot.eventbus.a.a b(a aVar) {
        if (aVar.h != null && aVar.h.c() != null) {
            org.greenrobot.eventbus.a.a c2 = aVar.h.c();
            if (aVar.f == c2.a()) {
                return c2;
            }
        }
        List<org.greenrobot.eventbus.a.b> list = this.f7834b;
        if (list != null) {
            for (org.greenrobot.eventbus.a.b bVar : list) {
                org.greenrobot.eventbus.a.a a2 = bVar.a(aVar.f);
                if (a2 != null) {
                    return a2;
                }
            }
            return null;
        }
        return null;
    }

    private List<o> c(Class<?> cls) {
        a a2 = a();
        a2.a(cls);
        while (a2.f != null) {
            c(a2);
            a2.b();
        }
        return a(a2);
    }

    private void c(a aVar) {
        Method[] methods;
        try {
            methods = aVar.f.getDeclaredMethods();
        } catch (Throwable unused) {
            methods = aVar.f.getMethods();
            aVar.g = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    m mVar = (m) method.getAnnotation(m.class);
                    if (mVar != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f7837a.add(new o(method, cls, mVar.a(), mVar.c(), mVar.b()));
                        }
                    }
                } else if (this.f7835c && method.isAnnotationPresent(m.class)) {
                    throw new e("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f7835c && method.isAnnotationPresent(m.class)) {
                throw new e((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SubscriberMethodFinder.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final List<o> f7837a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        final Map<Class, Object> f7838b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        final Map<String, Class> f7839c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        final StringBuilder f7840d = new StringBuilder(128);

        /* renamed from: e  reason: collision with root package name */
        Class<?> f7841e;
        Class<?> f;
        boolean g;
        org.greenrobot.eventbus.a.a h;

        a() {
        }

        void a(Class<?> cls) {
            this.f = cls;
            this.f7841e = cls;
            this.g = false;
            this.h = null;
        }

        void a() {
            this.f7837a.clear();
            this.f7838b.clear();
            this.f7839c.clear();
            this.f7840d.setLength(0);
            this.f7841e = null;
            this.f = null;
            this.g = false;
            this.h = null;
        }

        boolean a(Method method, Class<?> cls) {
            Object put = this.f7838b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (!b((Method) put, cls)) {
                    throw new IllegalStateException();
                }
                this.f7838b.put(cls, this);
            }
            return b(method, cls);
        }

        private boolean b(Method method, Class<?> cls) {
            this.f7840d.setLength(0);
            this.f7840d.append(method.getName());
            StringBuilder sb = this.f7840d;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.f7840d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.f7839c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f7839c.put(sb2, put);
            return false;
        }

        void b() {
            if (this.g) {
                this.f = null;
                return;
            }
            Class<? super Object> superclass = this.f.getSuperclass();
            this.f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f = null;
            }
        }
    }
}
