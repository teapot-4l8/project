package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.s;

/* compiled from: Request.java */
/* loaded from: classes.dex */
public final class aa {

    /* renamed from: a  reason: collision with root package name */
    final t f7304a;

    /* renamed from: b  reason: collision with root package name */
    final String f7305b;

    /* renamed from: c  reason: collision with root package name */
    final s f7306c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    final ab f7307d;

    /* renamed from: e  reason: collision with root package name */
    final Map<Class<?>, Object> f7308e;
    @Nullable
    private volatile d f;

    aa(a aVar) {
        this.f7304a = aVar.f7309a;
        this.f7305b = aVar.f7310b;
        this.f7306c = aVar.f7311c.a();
        this.f7307d = aVar.f7312d;
        this.f7308e = okhttp3.internal.c.a(aVar.f7313e);
    }

    public t a() {
        return this.f7304a;
    }

    public String b() {
        return this.f7305b;
    }

    public s c() {
        return this.f7306c;
    }

    @Nullable
    public String a(String str) {
        return this.f7306c.a(str);
    }

    public List<String> b(String str) {
        return this.f7306c.b(str);
    }

    @Nullable
    public ab d() {
        return this.f7307d;
    }

    public a e() {
        return new a(this);
    }

    public d f() {
        d dVar = this.f;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f7306c);
        this.f = a2;
        return a2;
    }

    public boolean g() {
        return this.f7304a.c();
    }

    public String toString() {
        return "Request{method=" + this.f7305b + ", url=" + this.f7304a + ", tags=" + this.f7308e + '}';
    }

    /* compiled from: Request.java */
    /* loaded from: classes.dex */
    public static class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        t f7309a;

        /* renamed from: b  reason: collision with root package name */
        String f7310b;

        /* renamed from: c  reason: collision with root package name */
        s.a f7311c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        ab f7312d;

        /* renamed from: e  reason: collision with root package name */
        Map<Class<?>, Object> f7313e;

        public a() {
            this.f7313e = Collections.emptyMap();
            this.f7310b = "GET";
            this.f7311c = new s.a();
        }

        a(aa aaVar) {
            Map<Class<?>, Object> linkedHashMap;
            this.f7313e = Collections.emptyMap();
            this.f7309a = aaVar.f7304a;
            this.f7310b = aaVar.f7305b;
            this.f7312d = aaVar.f7307d;
            if (aaVar.f7308e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(aaVar.f7308e);
            }
            this.f7313e = linkedHashMap;
            this.f7311c = aaVar.f7306c.c();
        }

        public a a(t tVar) {
            if (tVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f7309a = tVar;
            return this;
        }

        public a a(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return a(t.e(str));
        }

        public a a(String str, String str2) {
            this.f7311c.c(str, str2);
            return this;
        }

        public a b(String str, String str2) {
            this.f7311c.a(str, str2);
            return this;
        }

        public a b(String str) {
            this.f7311c.b(str);
            return this;
        }

        public a a(s sVar) {
            this.f7311c = sVar.c();
            return this;
        }

        public a a(ab abVar) {
            return a("POST", abVar);
        }

        public a a(String str, @Nullable ab abVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (abVar != null && !okhttp3.internal.c.f.c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (abVar == null && okhttp3.internal.c.f.b(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            } else {
                this.f7310b = str;
                this.f7312d = abVar;
                return this;
            }
        }

        public <T> a a(Class<? super T> cls, @Nullable T t) {
            if (cls != null) {
                if (t == null) {
                    this.f7313e.remove(cls);
                } else {
                    if (this.f7313e.isEmpty()) {
                        this.f7313e = new LinkedHashMap();
                    }
                    this.f7313e.put(cls, cls.cast(t));
                }
                return this;
            }
            throw new NullPointerException("type == null");
        }

        public aa a() {
            if (this.f7309a == null) {
                throw new IllegalStateException("url == null");
            }
            return new aa(this);
        }
    }
}
