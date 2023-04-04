package e;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* compiled from: CallAdapter.java */
/* loaded from: classes.dex */
public interface c<R, T> {
    T a(b<R> bVar);

    Type a();

    /* compiled from: CallAdapter.java */
    /* loaded from: classes.dex */
    public static abstract class a {
        @Nullable
        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, s sVar);

        /* JADX INFO: Access modifiers changed from: protected */
        public static Type a(int i, ParameterizedType parameterizedType) {
            return u.a(i, parameterizedType);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static Class<?> a(Type type) {
            return u.a(type);
        }
    }
}
