package androidx.lifecycle;

import androidx.lifecycle.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ClassesInfoCache.java */
/* loaded from: classes.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    static b f1998a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class, a> f1999b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class, Boolean> f2000c = new HashMap();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Class cls) {
        Boolean bool = this.f2000c.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] c2 = c(cls);
        for (Method method : c2) {
            if (((t) method.getAnnotation(t.class)) != null) {
                a(cls, c2);
                return true;
            }
        }
        this.f2000c.put(cls, false);
        return false;
    }

    private Method[] c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a b(Class cls) {
        a aVar = this.f1999b.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    private void a(Map<C0046b, h.a> map, C0046b c0046b, h.a aVar, Class cls) {
        h.a aVar2 = map.get(c0046b);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(c0046b, aVar);
                return;
            }
            return;
        }
        Method method = c0046b.f2004b;
        throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    private a a(Class cls, Method[] methodArr) {
        int i;
        a b2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (b2 = b(superclass)) != null) {
            hashMap.putAll(b2.f2002b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0046b, h.a> entry : b(cls2).f2002b.entrySet()) {
                a(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            t tVar = (t) method.getAnnotation(t.class);
            if (tVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (!parameterTypes[0].isAssignableFrom(l.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i = 1;
                }
                h.a a2 = tVar.a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(h.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (a2 != h.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                a(hashMap, new C0046b(i, method), a2, cls);
                z = true;
            }
        }
        a aVar = new a(hashMap);
        this.f1999b.put(cls, aVar);
        this.f2000c.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassesInfoCache.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Map<h.a, List<C0046b>> f2001a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<C0046b, h.a> f2002b;

        a(Map<C0046b, h.a> map) {
            this.f2002b = map;
            for (Map.Entry<C0046b, h.a> entry : map.entrySet()) {
                h.a value = entry.getValue();
                List<C0046b> list = this.f2001a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f2001a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(l lVar, h.a aVar, Object obj) {
            a(this.f2001a.get(aVar), lVar, aVar, obj);
            a(this.f2001a.get(h.a.ON_ANY), lVar, aVar, obj);
        }

        private static void a(List<C0046b> list, l lVar, h.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(lVar, aVar, obj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassesInfoCache.java */
    /* renamed from: androidx.lifecycle.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0046b {

        /* renamed from: a  reason: collision with root package name */
        final int f2003a;

        /* renamed from: b  reason: collision with root package name */
        final Method f2004b;

        C0046b(int i, Method method) {
            this.f2003a = i;
            this.f2004b = method;
            method.setAccessible(true);
        }

        void a(l lVar, h.a aVar, Object obj) {
            try {
                int i = this.f2003a;
                if (i == 0) {
                    this.f2004b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f2004b.invoke(obj, lVar);
                } else if (i != 2) {
                } else {
                    this.f2004b.invoke(obj, lVar, aVar);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to call observer method", e3.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0046b c0046b = (C0046b) obj;
            return this.f2003a == c0046b.f2003a && this.f2004b.getName().equals(c0046b.f2004b.getName());
        }

        public int hashCode() {
            return (this.f2003a * 31) + this.f2004b.getName().hashCode();
        }
    }
}
