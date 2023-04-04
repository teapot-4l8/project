package cn.jpush.android.u;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class f {
    public static Object a(Class<?> cls, String str, Object[] objArr, Class[] clsArr) {
        a(cls);
        a(clsArr, objArr);
        return cls.getMethod(str, clsArr).invoke(cls, objArr);
    }

    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        Object obj2;
        if ((objArr != null ? objArr.length : 0) == (clsArr != null ? clsArr.length : 0)) {
            Method method = obj.getClass().getMethod(str, clsArr);
            boolean isAccessible = method.isAccessible();
            if (!isAccessible) {
                method.setAccessible(true);
            }
            Exception exc = null;
            try {
                obj2 = method.invoke(obj, objArr);
            } catch (Exception e2) {
                exc = e2;
                obj2 = null;
            }
            if (!isAccessible) {
                method.setAccessible(false);
            }
            if (exc == null) {
                return obj2;
            }
            throw exc;
        }
        throw new IllegalArgumentException("argClasses' size is not equal to args' size");
    }

    private static void a(Object obj) {
        if (obj == null) {
            throw new Exception("owner can not be null");
        }
    }

    private static void a(Class<?>[] clsArr, Object[] objArr) {
        if ((objArr != null ? objArr.length : 0) != (clsArr != null ? clsArr.length : 0)) {
            throw new Exception("argClasses' size is not equal to args' size");
        }
    }
}
