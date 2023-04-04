package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Lifecycling.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Class, Integer> f2029a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<Class, List<Constructor<? extends f>>> f2030b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a(Object obj) {
        boolean z = obj instanceof j;
        boolean z2 = obj instanceof e;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((e) obj, (j) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((e) obj, null);
        }
        if (z) {
            return (j) obj;
        }
        Class<?> cls = obj.getClass();
        if (b(cls) == 2) {
            List<Constructor<? extends f>> list = f2030b.get(cls);
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(a(list.get(0), obj));
            }
            f[] fVarArr = new f[list.size()];
            for (int i = 0; i < list.size(); i++) {
                fVarArr[i] = a(list.get(i), obj);
            }
            return new CompositeGeneratedAdaptersObserver(fVarArr);
        }
        return new ReflectiveGenericLifecycleObserver(obj);
    }

    private static f a(Constructor<? extends f> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    private static Constructor<? extends f> a(Class<?> cls) {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String a2 = a(canonicalName);
            if (!name.isEmpty()) {
                a2 = name + "." + a2;
            }
            Constructor declaredConstructor = Class.forName(a2).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static int b(Class<?> cls) {
        Integer num = f2029a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int c2 = c(cls);
        f2029a.put(cls, Integer.valueOf(c2));
        return c2;
    }

    private static int c(Class<?> cls) {
        Class<?>[] interfaces;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends f> a2 = a(cls);
        if (a2 != null) {
            f2030b.put(cls, Collections.singletonList(a2));
            return 2;
        } else if (b.f1998a.a(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (d(superclass)) {
                if (b(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f2030b.get(superclass));
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (d(cls2)) {
                    if (b(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f2030b.get(cls2));
                }
            }
            if (arrayList != null) {
                f2030b.put(cls, arrayList);
                return 2;
            }
            return 1;
        }
    }

    private static boolean d(Class<?> cls) {
        return cls != null && k.class.isAssignableFrom(cls);
    }

    public static String a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
