package e;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* compiled from: Invocation.java */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final Method f7054a;

    /* renamed from: b  reason: collision with root package name */
    private final List<?> f7055b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Method method, List<?> list) {
        this.f7054a = method;
        this.f7055b = Collections.unmodifiableList(list);
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f7054a.getDeclaringClass().getName(), this.f7054a.getName(), this.f7055b);
    }
}
