package androidx.fragment.app;

import androidx.fragment.app.d;
import java.lang.reflect.InvocationTargetException;

/* compiled from: FragmentFactory.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final androidx.b.g<String, Class<?>> f1858a = new androidx.b.g<>();

    private static Class<?> d(ClassLoader classLoader, String str) {
        Class<?> cls = f1858a.get(str);
        if (cls == null) {
            Class<?> cls2 = Class.forName(str, false, classLoader);
            f1858a.put(str, cls2);
            return cls2;
        }
        return cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(ClassLoader classLoader, String str) {
        try {
            return d.class.isAssignableFrom(d(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class<? extends d> b(ClassLoader classLoader, String str) {
        try {
            return d(classLoader, str);
        } catch (ClassCastException e2) {
            throw new d.b("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e2);
        } catch (ClassNotFoundException e3) {
            throw new d.b("Unable to instantiate fragment " + str + ": make sure class name exists", e3);
        }
    }

    public d c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e2) {
            throw new d.b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new d.b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new d.b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new d.b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }
}
