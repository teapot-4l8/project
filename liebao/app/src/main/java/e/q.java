package e;

import e.c.x;
import e.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.aa;
import okhttp3.s;
import okhttp3.v;
import okhttp3.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestFactory.java */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    final String f7105a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f7106b;

    /* renamed from: c  reason: collision with root package name */
    private final okhttp3.t f7107c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f7108d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final okhttp3.s f7109e;
    @Nullable
    private final v f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final n<?>[] j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q a(s sVar, Method method) {
        return new a(sVar, method).a();
    }

    q(a aVar) {
        this.f7106b = aVar.f7111b;
        this.f7107c = aVar.f7110a.f7120b;
        this.f7105a = aVar.n;
        this.f7108d = aVar.r;
        this.f7109e = aVar.s;
        this.f = aVar.t;
        this.g = aVar.o;
        this.h = aVar.p;
        this.i = aVar.f7115q;
        this.j = aVar.v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa a(Object[] objArr) {
        n<?>[] nVarArr = this.j;
        int length = objArr.length;
        if (length != nVarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + nVarArr.length + ")");
        }
        p pVar = new p(this.f7105a, this.f7107c, this.f7108d, this.f7109e, this.f, this.g, this.h, this.i);
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(objArr[i]);
            nVarArr[i].a(pVar, objArr[i]);
        }
        return pVar.a().a((Class<? super Class>) k.class, (Class) new k(this.f7106b, arrayList)).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestFactory.java */
    /* loaded from: classes.dex */
    public static final class a {
        private static final Pattern w = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        private static final Pattern x = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: a  reason: collision with root package name */
        final s f7110a;

        /* renamed from: b  reason: collision with root package name */
        final Method f7111b;

        /* renamed from: c  reason: collision with root package name */
        final Annotation[] f7112c;

        /* renamed from: d  reason: collision with root package name */
        final Annotation[][] f7113d;

        /* renamed from: e  reason: collision with root package name */
        final Type[] f7114e;
        boolean f;
        boolean g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        @Nullable
        String n;
        boolean o;
        boolean p;

        /* renamed from: q  reason: collision with root package name */
        boolean f7115q;
        @Nullable
        String r;
        @Nullable
        okhttp3.s s;
        @Nullable
        v t;
        @Nullable
        Set<String> u;
        @Nullable
        n<?>[] v;

        a(s sVar, Method method) {
            this.f7110a = sVar;
            this.f7111b = method;
            this.f7112c = method.getAnnotations();
            this.f7114e = method.getGenericParameterTypes();
            this.f7113d = method.getParameterAnnotations();
        }

        q a() {
            for (Annotation annotation : this.f7112c) {
                a(annotation);
            }
            if (this.n == null) {
                throw u.a(this.f7111b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.o) {
                if (this.f7115q) {
                    throw u.a(this.f7111b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.p) {
                    throw u.a(this.f7111b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f7113d.length;
            this.v = new n[length];
            for (int i = 0; i < length; i++) {
                this.v[i] = a(i, this.f7114e[i], this.f7113d[i]);
            }
            if (this.r != null || this.m) {
                if (!this.p && !this.f7115q && !this.o && this.h) {
                    throw u.a(this.f7111b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                }
                if (this.p && !this.f) {
                    throw u.a(this.f7111b, "Form-encoded method must contain at least one @Field.", new Object[0]);
                }
                if (this.f7115q && !this.g) {
                    throw u.a(this.f7111b, "Multipart method must contain at least one @Part.", new Object[0]);
                }
                return new q(this);
            }
            throw u.a(this.f7111b, "Missing either @%s URL or @Url parameter.", this.n);
        }

        private void a(Annotation annotation) {
            if (annotation instanceof e.c.b) {
                a("DELETE", ((e.c.b) annotation).a(), false);
            } else if (annotation instanceof e.c.f) {
                a("GET", ((e.c.f) annotation).a(), false);
            } else if (annotation instanceof e.c.g) {
                a("HEAD", ((e.c.g) annotation).a(), false);
            } else if (annotation instanceof e.c.n) {
                a("PATCH", ((e.c.n) annotation).a(), true);
            } else if (annotation instanceof e.c.o) {
                a("POST", ((e.c.o) annotation).a(), true);
            } else if (annotation instanceof e.c.p) {
                a("PUT", ((e.c.p) annotation).a(), true);
            } else if (annotation instanceof e.c.m) {
                a("OPTIONS", ((e.c.m) annotation).a(), false);
            } else if (annotation instanceof e.c.h) {
                e.c.h hVar = (e.c.h) annotation;
                a(hVar.a(), hVar.b(), hVar.c());
            } else if (annotation instanceof e.c.k) {
                String[] a2 = ((e.c.k) annotation).a();
                if (a2.length == 0) {
                    throw u.a(this.f7111b, "@Headers annotation is empty.", new Object[0]);
                }
                this.s = a(a2);
            } else if (annotation instanceof e.c.l) {
                if (this.p) {
                    throw u.a(this.f7111b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f7115q = true;
            } else if (annotation instanceof e.c.e) {
                if (this.f7115q) {
                    throw u.a(this.f7111b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.p = true;
            }
        }

        private void a(String str, String str2, boolean z) {
            String str3 = this.n;
            if (str3 != null) {
                throw u.a(this.f7111b, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.n = str;
            this.o = z;
            if (str2.isEmpty()) {
                return;
            }
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                String substring = str2.substring(indexOf + 1);
                if (w.matcher(substring).find()) {
                    throw u.a(this.f7111b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                }
            }
            this.r = str2;
            this.u = a(str2);
        }

        private okhttp3.s a(String[] strArr) {
            s.a aVar = new s.a();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw u.a(this.f7111b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    try {
                        this.t = v.a(trim);
                    } catch (IllegalArgumentException e2) {
                        throw u.a(this.f7111b, e2, "Malformed content type: %s", trim);
                    }
                } else {
                    aVar.a(substring, trim);
                }
            }
            return aVar.a();
        }

        private n<?> a(int i, Type type, @Nullable Annotation[] annotationArr) {
            n<?> nVar = null;
            if (annotationArr != null) {
                for (Annotation annotation : annotationArr) {
                    n<?> a2 = a(i, type, annotationArr, annotation);
                    if (a2 != null) {
                        if (nVar != null) {
                            throw u.a(this.f7111b, i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        nVar = a2;
                    }
                }
            }
            if (nVar != null) {
                return nVar;
            }
            throw u.a(this.f7111b, i, "No Retrofit annotation found.", new Object[0]);
        }

        @Nullable
        private n<?> a(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof x) {
                a(i, type);
                if (this.m) {
                    throw u.a(this.f7111b, i, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.i) {
                    throw u.a(this.f7111b, i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.j) {
                    throw u.a(this.f7111b, i, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.k) {
                    throw u.a(this.f7111b, i, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.l) {
                    throw u.a(this.f7111b, i, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.r == null) {
                    this.m = true;
                    if (type == okhttp3.t.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                        return new n.m();
                    }
                    throw u.a(this.f7111b, i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                }
                throw u.a(this.f7111b, i, "@Url cannot be used with @%s URL", this.n);
            } else if (annotation instanceof e.c.s) {
                a(i, type);
                if (this.j) {
                    throw u.a(this.f7111b, i, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.k) {
                    throw u.a(this.f7111b, i, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.l) {
                    throw u.a(this.f7111b, i, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.m) {
                    throw u.a(this.f7111b, i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.r != null) {
                    this.i = true;
                    e.c.s sVar = (e.c.s) annotation;
                    String a2 = sVar.a();
                    a(i, a2);
                    return new n.h(a2, this.f7110a.c(type, annotationArr), sVar.b());
                }
                throw u.a(this.f7111b, i, "@Path can only be used with relative url on @%s", this.n);
            } else if (annotation instanceof e.c.t) {
                a(i, type);
                e.c.t tVar = (e.c.t) annotation;
                String a3 = tVar.a();
                boolean b2 = tVar.b();
                Class<?> a4 = u.a(type);
                this.j = true;
                if (Iterable.class.isAssignableFrom(a4)) {
                    if (!(type instanceof ParameterizedType)) {
                        Method method = this.f7111b;
                        throw u.a(method, i, a4.getSimpleName() + " must include generic type (e.g., " + a4.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new n.i(a3, this.f7110a.c(u.a(0, (ParameterizedType) type), annotationArr), b2).a();
                } else if (a4.isArray()) {
                    return new n.i(a3, this.f7110a.c(a(a4.getComponentType()), annotationArr), b2).b();
                } else {
                    return new n.i(a3, this.f7110a.c(type, annotationArr), b2);
                }
            } else if (annotation instanceof e.c.v) {
                a(i, type);
                boolean a5 = ((e.c.v) annotation).a();
                Class<?> a6 = u.a(type);
                this.k = true;
                if (Iterable.class.isAssignableFrom(a6)) {
                    if (!(type instanceof ParameterizedType)) {
                        Method method2 = this.f7111b;
                        throw u.a(method2, i, a6.getSimpleName() + " must include generic type (e.g., " + a6.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new n.k(this.f7110a.c(u.a(0, (ParameterizedType) type), annotationArr), a5).a();
                } else if (a6.isArray()) {
                    return new n.k(this.f7110a.c(a(a6.getComponentType()), annotationArr), a5).b();
                } else {
                    return new n.k(this.f7110a.c(type, annotationArr), a5);
                }
            } else if (annotation instanceof e.c.u) {
                a(i, type);
                Class<?> a7 = u.a(type);
                this.l = true;
                if (!Map.class.isAssignableFrom(a7)) {
                    throw u.a(this.f7111b, i, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type b3 = u.b(type, a7, Map.class);
                if (!(b3 instanceof ParameterizedType)) {
                    throw u.a(this.f7111b, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) b3;
                Type a8 = u.a(0, parameterizedType);
                if (String.class != a8) {
                    Method method3 = this.f7111b;
                    throw u.a(method3, i, "@QueryMap keys must be of type String: " + a8, new Object[0]);
                }
                return new n.j(this.f7110a.c(u.a(1, parameterizedType), annotationArr), ((e.c.u) annotation).a());
            } else if (annotation instanceof e.c.i) {
                a(i, type);
                String a9 = ((e.c.i) annotation).a();
                Class<?> a10 = u.a(type);
                if (Iterable.class.isAssignableFrom(a10)) {
                    if (!(type instanceof ParameterizedType)) {
                        Method method4 = this.f7111b;
                        throw u.a(method4, i, a10.getSimpleName() + " must include generic type (e.g., " + a10.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new n.d(a9, this.f7110a.c(u.a(0, (ParameterizedType) type), annotationArr)).a();
                } else if (a10.isArray()) {
                    return new n.d(a9, this.f7110a.c(a(a10.getComponentType()), annotationArr)).b();
                } else {
                    return new n.d(a9, this.f7110a.c(type, annotationArr));
                }
            } else if (annotation instanceof e.c.j) {
                a(i, type);
                Class<?> a11 = u.a(type);
                if (!Map.class.isAssignableFrom(a11)) {
                    throw u.a(this.f7111b, i, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type b4 = u.b(type, a11, Map.class);
                if (!(b4 instanceof ParameterizedType)) {
                    throw u.a(this.f7111b, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) b4;
                Type a12 = u.a(0, parameterizedType2);
                if (String.class != a12) {
                    Method method5 = this.f7111b;
                    throw u.a(method5, i, "@HeaderMap keys must be of type String: " + a12, new Object[0]);
                }
                return new n.e(this.f7110a.c(u.a(1, parameterizedType2), annotationArr));
            } else if (annotation instanceof e.c.c) {
                a(i, type);
                if (!this.p) {
                    throw u.a(this.f7111b, i, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                e.c.c cVar = (e.c.c) annotation;
                String a13 = cVar.a();
                boolean b5 = cVar.b();
                this.f = true;
                Class<?> a14 = u.a(type);
                if (Iterable.class.isAssignableFrom(a14)) {
                    if (!(type instanceof ParameterizedType)) {
                        Method method6 = this.f7111b;
                        throw u.a(method6, i, a14.getSimpleName() + " must include generic type (e.g., " + a14.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new n.b(a13, this.f7110a.c(u.a(0, (ParameterizedType) type), annotationArr), b5).a();
                } else if (a14.isArray()) {
                    return new n.b(a13, this.f7110a.c(a(a14.getComponentType()), annotationArr), b5).b();
                } else {
                    return new n.b(a13, this.f7110a.c(type, annotationArr), b5);
                }
            } else if (annotation instanceof e.c.d) {
                a(i, type);
                if (!this.p) {
                    throw u.a(this.f7111b, i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> a15 = u.a(type);
                if (!Map.class.isAssignableFrom(a15)) {
                    throw u.a(this.f7111b, i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type b6 = u.b(type, a15, Map.class);
                if (!(b6 instanceof ParameterizedType)) {
                    throw u.a(this.f7111b, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) b6;
                Type a16 = u.a(0, parameterizedType3);
                if (String.class != a16) {
                    Method method7 = this.f7111b;
                    throw u.a(method7, i, "@FieldMap keys must be of type String: " + a16, new Object[0]);
                }
                f c2 = this.f7110a.c(u.a(1, parameterizedType3), annotationArr);
                this.f = true;
                return new n.c(c2, ((e.c.d) annotation).a());
            } else if (annotation instanceof e.c.q) {
                a(i, type);
                if (!this.f7115q) {
                    throw u.a(this.f7111b, i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                e.c.q qVar = (e.c.q) annotation;
                this.g = true;
                String a17 = qVar.a();
                Class<?> a18 = u.a(type);
                if (a17.isEmpty()) {
                    if (Iterable.class.isAssignableFrom(a18)) {
                        if (!(type instanceof ParameterizedType)) {
                            Method method8 = this.f7111b;
                            throw u.a(method8, i, a18.getSimpleName() + " must include generic type (e.g., " + a18.getSimpleName() + "<String>)", new Object[0]);
                        } else if (!w.b.class.isAssignableFrom(u.a(u.a(0, (ParameterizedType) type)))) {
                            throw u.a(this.f7111b, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        } else {
                            return n.l.f7095a.a();
                        }
                    } else if (a18.isArray()) {
                        if (!w.b.class.isAssignableFrom(a18.getComponentType())) {
                            throw u.a(this.f7111b, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        return n.l.f7095a.b();
                    } else if (w.b.class.isAssignableFrom(a18)) {
                        return n.l.f7095a;
                    } else {
                        throw u.a(this.f7111b, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                }
                okhttp3.s a19 = okhttp3.s.a("Content-Disposition", "form-data; name=\"" + a17 + "\"", "Content-Transfer-Encoding", qVar.b());
                if (Iterable.class.isAssignableFrom(a18)) {
                    if (!(type instanceof ParameterizedType)) {
                        Method method9 = this.f7111b;
                        throw u.a(method9, i, a18.getSimpleName() + " must include generic type (e.g., " + a18.getSimpleName() + "<String>)", new Object[0]);
                    }
                    Type a20 = u.a(0, (ParameterizedType) type);
                    if (w.b.class.isAssignableFrom(u.a(a20))) {
                        throw u.a(this.f7111b, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new n.f(a19, this.f7110a.a(a20, annotationArr, this.f7112c)).a();
                } else if (a18.isArray()) {
                    Class<?> a21 = a(a18.getComponentType());
                    if (w.b.class.isAssignableFrom(a21)) {
                        throw u.a(this.f7111b, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new n.f(a19, this.f7110a.a(a21, annotationArr, this.f7112c)).b();
                } else if (w.b.class.isAssignableFrom(a18)) {
                    throw u.a(this.f7111b, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                } else {
                    return new n.f(a19, this.f7110a.a(type, annotationArr, this.f7112c));
                }
            } else if (annotation instanceof e.c.r) {
                a(i, type);
                if (!this.f7115q) {
                    throw u.a(this.f7111b, i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.g = true;
                Class<?> a22 = u.a(type);
                if (!Map.class.isAssignableFrom(a22)) {
                    throw u.a(this.f7111b, i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type b7 = u.b(type, a22, Map.class);
                if (!(b7 instanceof ParameterizedType)) {
                    throw u.a(this.f7111b, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) b7;
                Type a23 = u.a(0, parameterizedType4);
                if (String.class != a23) {
                    Method method10 = this.f7111b;
                    throw u.a(method10, i, "@PartMap keys must be of type String: " + a23, new Object[0]);
                }
                Type a24 = u.a(1, parameterizedType4);
                if (w.b.class.isAssignableFrom(u.a(a24))) {
                    throw u.a(this.f7111b, i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                }
                return new n.g(this.f7110a.a(a24, annotationArr, this.f7112c), ((e.c.r) annotation).a());
            } else if (annotation instanceof e.c.a) {
                a(i, type);
                if (this.p || this.f7115q) {
                    throw u.a(this.f7111b, i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                }
                if (this.h) {
                    throw u.a(this.f7111b, i, "Multiple @Body method annotations found.", new Object[0]);
                }
                try {
                    f a25 = this.f7110a.a(type, annotationArr, this.f7112c);
                    this.h = true;
                    return new n.a(a25);
                } catch (RuntimeException e2) {
                    throw u.a(this.f7111b, e2, i, "Unable to create @Body converter for %s", type);
                }
            } else {
                return null;
            }
        }

        private void a(int i, Type type) {
            if (u.d(type)) {
                throw u.a(this.f7111b, i, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        private void a(int i, String str) {
            if (!x.matcher(str).matches()) {
                throw u.a(this.f7111b, i, "@Path parameter name must match %s. Found: %s", w.pattern(), str);
            }
            if (!this.u.contains(str)) {
                throw u.a(this.f7111b, i, "URL \"%s\" does not contain \"{%s}\".", this.r, str);
            }
        }

        static Set<String> a(String str) {
            Matcher matcher = w.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private static Class<?> a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }
    }
}
