package kotlin.d.b;

import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;

/* compiled from: ReflectionFactory.java */
/* loaded from: classes2.dex */
public class p {
    public KProperty1 a(l lVar) {
        return lVar;
    }

    public KClass a(Class cls) {
        return new e(cls);
    }

    public String a(j jVar) {
        return a((h) jVar);
    }

    public String a(h hVar) {
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }
}
