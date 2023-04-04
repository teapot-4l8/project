package e;

import e.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultCallAdapterFactory.java */
/* loaded from: classes.dex */
public final class g extends c.a {

    /* renamed from: a  reason: collision with root package name */
    static final c.a f7033a = new g();

    g() {
    }

    @Override // e.c.a
    @Nullable
    public c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        if (a(type) != b.class) {
            return null;
        }
        final Type e2 = u.e(type);
        return new c<Object, b<?>>() { // from class: e.g.1
            @Override // e.c
            /* renamed from: b */
            public b<Object> a(b<Object> bVar) {
                return bVar;
            }

            @Override // e.c
            public Type a() {
                return e2;
            }
        };
    }
}
