package kotlin.d.b;

import java.util.Arrays;

/* compiled from: Intrinsics.java */
/* loaded from: classes.dex */
public class i {
    private i() {
    }

    public static void a() {
        throw ((kotlin.a) a(new kotlin.a()));
    }

    public static void a(String str) {
        throw ((kotlin.k) a(new kotlin.k(str)));
    }

    public static void b(String str) {
        a("lateinit property " + str + " has not been initialized");
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) a(new IllegalStateException(str + " must not be null")));
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            c(str);
        }
    }

    private static void c(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        throw ((IllegalArgumentException) a(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str)));
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static <T extends Throwable> T a(T t) {
        return (T) a((Throwable) t, i.class.getName());
    }

    static <T extends Throwable> T a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }
}
