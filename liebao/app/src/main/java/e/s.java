package e;

import e.a;
import e.c;
import e.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.e;
import okhttp3.x;

/* compiled from: Retrofit.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    final e.a f7119a;

    /* renamed from: b  reason: collision with root package name */
    final okhttp3.t f7120b;

    /* renamed from: c  reason: collision with root package name */
    final List<f.a> f7121c;

    /* renamed from: d  reason: collision with root package name */
    final List<c.a> f7122d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    final Executor f7123e;
    final boolean f;
    private final Map<Method, t<?>> g = new ConcurrentHashMap();

    s(e.a aVar, okhttp3.t tVar, List<f.a> list, List<c.a> list2, @Nullable Executor executor, boolean z) {
        this.f7119a = aVar;
        this.f7120b = tVar;
        this.f7121c = list;
        this.f7122d = list2;
        this.f7123e = executor;
        this.f = z;
    }

    public <T> T a(final Class<T> cls) {
        u.a((Class) cls);
        if (this.f) {
            b(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: e.s.1

            /* renamed from: c  reason: collision with root package name */
            private final o f7126c = o.a();

            /* renamed from: d  reason: collision with root package name */
            private final Object[] f7127d = new Object[0];

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, @Nullable Object[] objArr) {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (this.f7126c.a(method)) {
                    return this.f7126c.a(method, cls, obj, objArr);
                }
                t<?> a2 = s.this.a(method);
                if (objArr == null) {
                    objArr = this.f7127d;
                }
                return a2.a(objArr);
            }
        });
    }

    private void b(Class<?> cls) {
        Method[] declaredMethods;
        o a2 = o.a();
        for (Method method : cls.getDeclaredMethods()) {
            if (!a2.a(method)) {
                a(method);
            }
        }
    }

    t<?> a(Method method) {
        t<?> tVar;
        t<?> tVar2 = this.g.get(method);
        if (tVar2 != null) {
            return tVar2;
        }
        synchronized (this.g) {
            tVar = this.g.get(method);
            if (tVar == null) {
                tVar = t.a(this, method);
                this.g.put(method, tVar);
            }
        }
        return tVar;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr) {
        return a((c.a) null, type, annotationArr);
    }

    public c<?, ?> a(@Nullable c.a aVar, Type type, Annotation[] annotationArr) {
        u.a(type, "returnType == null");
        u.a(annotationArr, "annotations == null");
        int indexOf = this.f7122d.indexOf(aVar) + 1;
        int size = this.f7122d.size();
        for (int i = indexOf; i < size; i++) {
            c<?, ?> a2 = this.f7122d.get(i).a(type, annotationArr, this);
            if (a2 != null) {
                return a2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f7122d.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f7122d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f7122d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> f<T, ab> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return a(null, type, annotationArr, annotationArr2);
    }

    public <T> f<T, ab> a(@Nullable f.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        u.a(type, "type == null");
        u.a(annotationArr, "parameterAnnotations == null");
        u.a(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f7121c.indexOf(aVar) + 1;
        int size = this.f7121c.size();
        for (int i = indexOf; i < size; i++) {
            f<T, ab> fVar = (f<T, ab>) this.f7121c.get(i).a(type, annotationArr, annotationArr2, this);
            if (fVar != null) {
                return fVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f7121c.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f7121c.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f7121c.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> f<ad, T> b(Type type, Annotation[] annotationArr) {
        return a((f.a) null, type, annotationArr);
    }

    public <T> f<ad, T> a(@Nullable f.a aVar, Type type, Annotation[] annotationArr) {
        u.a(type, "type == null");
        u.a(annotationArr, "annotations == null");
        int indexOf = this.f7121c.indexOf(aVar) + 1;
        int size = this.f7121c.size();
        for (int i = indexOf; i < size; i++) {
            f<ad, T> fVar = (f<ad, T>) this.f7121c.get(i).a(type, annotationArr, this);
            if (fVar != null) {
                return fVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f7121c.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f7121c.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f7121c.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> f<T, String> c(Type type, Annotation[] annotationArr) {
        u.a(type, "type == null");
        u.a(annotationArr, "annotations == null");
        int size = this.f7121c.size();
        for (int i = 0; i < size; i++) {
            f<T, String> fVar = (f<T, String>) this.f7121c.get(i).b(type, annotationArr, this);
            if (fVar != null) {
                return fVar;
            }
        }
        return a.d.f7012a;
    }

    /* compiled from: Retrofit.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final o f7128a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private e.a f7129b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private okhttp3.t f7130c;

        /* renamed from: d  reason: collision with root package name */
        private final List<f.a> f7131d;

        /* renamed from: e  reason: collision with root package name */
        private final List<c.a> f7132e;
        @Nullable
        private Executor f;
        private boolean g;

        a(o oVar) {
            this.f7131d = new ArrayList();
            this.f7132e = new ArrayList();
            this.f7128a = oVar;
        }

        public a() {
            this(o.a());
        }

        public a a(x xVar) {
            return a((e.a) u.a(xVar, "client == null"));
        }

        public a a(e.a aVar) {
            this.f7129b = (e.a) u.a(aVar, "factory == null");
            return this;
        }

        public a a(String str) {
            u.a(str, "baseUrl == null");
            return a(okhttp3.t.e(str));
        }

        public a a(okhttp3.t tVar) {
            u.a(tVar, "baseUrl == null");
            List<String> j = tVar.j();
            if (!"".equals(j.get(j.size() - 1))) {
                throw new IllegalArgumentException("baseUrl must end in /: " + tVar);
            }
            this.f7130c = tVar;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a a(f.a aVar) {
            this.f7131d.add(u.a(aVar, "factory == null"));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a a(c.a aVar) {
            this.f7132e.add(u.a(aVar, "factory == null"));
            return this;
        }

        public s a() {
            if (this.f7130c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            e.a aVar = this.f7129b;
            if (aVar == null) {
                aVar = new x();
            }
            e.a aVar2 = aVar;
            Executor executor = this.f;
            if (executor == null) {
                executor = this.f7128a.b();
            }
            Executor executor2 = executor;
            ArrayList arrayList = new ArrayList(this.f7132e);
            arrayList.addAll(this.f7128a.a(executor2));
            ArrayList arrayList2 = new ArrayList(this.f7131d.size() + 1 + this.f7128a.d());
            arrayList2.add(new e.a());
            arrayList2.addAll(this.f7131d);
            arrayList2.addAll(this.f7128a.c());
            return new s(aVar2, this.f7130c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor2, this.g);
        }
    }
}
