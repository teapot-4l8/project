package kotlin.b;

import kotlin.d.b.i;
import kotlin.h.g;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7144a;

    static {
        a aVar;
        Object newInstance;
        Object newInstance2;
        int a2 = a();
        if (a2 >= 65544) {
            try {
                newInstance = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                i.a(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
            } catch (ClassNotFoundException unused) {
                Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                i.a(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    if (newInstance3 == null) {
                        throw new kotlin.i("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) newInstance3;
                } catch (ClassCastException e2) {
                    ClassLoader classLoader = newInstance3.getClass().getClassLoader();
                    ClassLoader classLoader2 = a.class.getClassLoader();
                    Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e2);
                    i.a((Object) initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause;
                }
            }
            try {
                if (newInstance == null) {
                    throw new kotlin.i("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                aVar = (a) newInstance;
                f7144a = aVar;
            } catch (ClassCastException e3) {
                ClassLoader classLoader3 = newInstance.getClass().getClassLoader();
                ClassLoader classLoader4 = a.class.getClassLoader();
                Throwable initCause2 = new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + classLoader4).initCause(e3);
                i.a((Object) initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw initCause2;
            }
        }
        if (a2 >= 65543) {
            try {
                newInstance2 = Class.forName("kotlin.b.a.a").newInstance();
                i.a(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
            } catch (ClassNotFoundException unused2) {
                Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                i.a(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    if (newInstance4 == null) {
                        throw new kotlin.i("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) newInstance4;
                } catch (ClassCastException e4) {
                    ClassLoader classLoader5 = newInstance4.getClass().getClassLoader();
                    ClassLoader classLoader6 = a.class.getClassLoader();
                    Throwable initCause3 = new ClassCastException("Instance classloader: " + classLoader5 + ", base type classloader: " + classLoader6).initCause(e4);
                    i.a((Object) initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause3;
                }
            }
            try {
                if (newInstance2 == null) {
                    throw new kotlin.i("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                aVar = (a) newInstance2;
                f7144a = aVar;
            } catch (ClassCastException e5) {
                ClassLoader classLoader7 = newInstance2.getClass().getClassLoader();
                ClassLoader classLoader8 = a.class.getClassLoader();
                Throwable initCause4 = new ClassCastException("Instance classloader: " + classLoader7 + ", base type classloader: " + classLoader8).initCause(e5);
                i.a((Object) initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw initCause4;
            }
        }
        aVar = new a();
        f7144a = aVar;
    }

    private static final int a() {
        String property = System.getProperty("java.specification.version");
        if (property != null) {
            String str = property;
            int a2 = g.a((CharSequence) str, '.', 0, false, 6, (Object) null);
            if (a2 < 0) {
                try {
                    return Integer.parseInt(property) * 65536;
                } catch (NumberFormatException unused) {
                    return 65542;
                }
            }
            int i = a2 + 1;
            int a3 = g.a((CharSequence) str, '.', i, false, 4, (Object) null);
            if (a3 < 0) {
                a3 = property.length();
            }
            if (property != null) {
                String substring = property.substring(0, a2);
                i.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (property != null) {
                    String substring2 = property.substring(i, a3);
                    i.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    try {
                        return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
                    } catch (NumberFormatException unused2) {
                        return 65542;
                    }
                }
                throw new kotlin.i("null cannot be cast to non-null type java.lang.String");
            }
            throw new kotlin.i("null cannot be cast to non-null type java.lang.String");
        }
        return 65542;
    }
}
