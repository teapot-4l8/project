package e;

import e.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import okhttp3.ad;

/* compiled from: OptionalConverterFactory.java */
/* loaded from: classes.dex */
final class m extends f.a {

    /* renamed from: a  reason: collision with root package name */
    static final f.a f7068a = new m();

    m() {
    }

    @Override // e.f.a
    @Nullable
    public f<ad, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        if (a(type) != Optional.class) {
            return null;
        }
        return new a(sVar.b(a(0, (ParameterizedType) type), annotationArr));
    }

    /* compiled from: OptionalConverterFactory.java */
    /* loaded from: classes2.dex */
    static final class a<T> implements f<ad, Optional<T>> {

        /* renamed from: a  reason: collision with root package name */
        final f<ad, T> f7069a;

        a(f<ad, T> fVar) {
            this.f7069a = fVar;
        }

        @Override // e.f
        public Optional<T> a(ad adVar) {
            return Optional.ofNullable(this.f7069a.a(adVar));
        }
    }
}
