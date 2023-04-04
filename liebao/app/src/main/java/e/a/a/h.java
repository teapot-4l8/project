package e.a.a;

import b.b.i;
import b.b.j;
import e.c;
import e.r;
import e.s;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* compiled from: RxJava2CallAdapterFactory.java */
/* loaded from: classes.dex */
public final class h extends c.a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final i f7008a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f7009b;

    public static h a() {
        return new h(null, false);
    }

    private h(@Nullable i iVar, boolean z) {
        this.f7008a = iVar;
        this.f7009b = z;
    }

    @Override // e.c.a
    @Nullable
    public e.c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        Type type2;
        boolean z;
        boolean z2;
        Class<?> a2 = a(type);
        if (a2 == b.b.b.class) {
            return new g(Void.class, this.f7008a, this.f7009b, false, true, false, false, false, true);
        }
        boolean z3 = a2 == b.b.c.class;
        boolean z4 = a2 == j.class;
        boolean z5 = a2 == b.b.d.class;
        if (a2 == b.b.e.class || z3 || z4 || z5) {
            if (!(type instanceof ParameterizedType)) {
                String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
                throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
            }
            Type a3 = a(0, (ParameterizedType) type);
            Class<?> a4 = a(a3);
            if (a4 == r.class) {
                if (!(a3 instanceof ParameterizedType)) {
                    throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
                }
                type2 = a(0, (ParameterizedType) a3);
                z = false;
            } else if (a4 == e.class) {
                if (!(a3 instanceof ParameterizedType)) {
                    throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
                }
                type2 = a(0, (ParameterizedType) a3);
                z = true;
            } else {
                type2 = a3;
                z = false;
                z2 = true;
                return new g(type2, this.f7008a, this.f7009b, z, z2, z3, z4, z5, false);
            }
            z2 = false;
            return new g(type2, this.f7008a, this.f7009b, z, z2, z3, z4, z5, false);
        }
        return null;
    }
}
