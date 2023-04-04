package e;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.ab;
import okhttp3.ad;

/* compiled from: Converter.java */
/* loaded from: classes.dex */
public interface f<F, T> {
    @Nullable
    T a(F f);

    /* compiled from: Converter.java */
    /* loaded from: classes.dex */
    public static abstract class a {
        @Nullable
        public f<ad, ?> a(Type type, Annotation[] annotationArr, s sVar) {
            return null;
        }

        @Nullable
        public f<?, ab> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
            return null;
        }

        @Nullable
        public f<?, String> b(Type type, Annotation[] annotationArr, s sVar) {
            return null;
        }

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
