package okhttp3.internal.g;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: OptionalMethod.java */
/* loaded from: classes2.dex */
class e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f7656a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7657b;

    /* renamed from: c  reason: collision with root package name */
    private final Class[] f7658c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Class<?> cls, String str, Class... clsArr) {
        this.f7656a = cls;
        this.f7657b = str;
        this.f7658c = clsArr;
    }

    public boolean a(T t) {
        return a(t.getClass()) != null;
    }

    public Object a(T t, Object... objArr) {
        Method a2 = a(t.getClass());
        if (a2 == null) {
            return null;
        }
        try {
            return a2.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object b(T t, Object... objArr) {
        try {
            return a(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object c(T t, Object... objArr) {
        Method a2 = a(t.getClass());
        if (a2 == null) {
            throw new AssertionError("Method " + this.f7657b + " not supported for object " + t);
        }
        try {
            return a2.invoke(t, objArr);
        } catch (IllegalAccessException e2) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a2);
            assertionError.initCause(e2);
            throw assertionError;
        }
    }

    public Object d(T t, Object... objArr) {
        try {
            return c(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    private Method a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f7657b;
        if (str != null) {
            Method a2 = a(cls, str, this.f7658c);
            if (a2 == null || (cls2 = this.f7656a) == null || cls2.isAssignableFrom(a2.getReturnType())) {
                return a2;
            }
            return null;
        }
        return null;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
