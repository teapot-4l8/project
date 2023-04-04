package e;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* compiled from: ServiceMethod.java */
/* loaded from: classes2.dex */
abstract class t<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T a(Object[] objArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> t<T> a(s sVar, Method method) {
        q a2 = q.a(sVar, method);
        Type genericReturnType = method.getGenericReturnType();
        if (u.d(genericReturnType)) {
            throw u.a(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }
        if (genericReturnType == Void.TYPE) {
            throw u.a(method, "Service methods cannot return void.", new Object[0]);
        }
        return j.a(sVar, method, a2);
    }
}
