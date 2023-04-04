package kotlin.d.b;

import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;

/* compiled from: Reflection.java */
/* loaded from: classes2.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static final p f7162a;

    /* renamed from: b  reason: collision with root package name */
    private static final KClass[] f7163b;

    static {
        p pVar = null;
        try {
            pVar = (p) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (pVar == null) {
            pVar = new p();
        }
        f7162a = pVar;
        f7163b = new KClass[0];
    }

    public static KClass a(Class cls) {
        return f7162a.a(cls);
    }

    public static String a(j jVar) {
        return f7162a.a(jVar);
    }

    public static KProperty1 a(l lVar) {
        return f7162a.a(lVar);
    }
}
