package e;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.ab;
import okhttp3.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ParameterHandler.java */
/* loaded from: classes.dex */
public abstract class n<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(p pVar, @Nullable T t);

    n() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final n<Iterable<T>> a() {
        return new n<Iterable<T>>() { // from class: e.n.1
            @Override // e.n
            /* bridge */ /* synthetic */ void a(p pVar, @Nullable Object obj) {
                a(pVar, (Iterable) ((Iterable) obj));
            }

            void a(p pVar, @Nullable Iterable<T> iterable) {
                if (iterable == null) {
                    return;
                }
                for (T t : iterable) {
                    n.this.a(pVar, t);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final n<Object> b() {
        return new n<Object>() { // from class: e.n.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // e.n
            void a(p pVar, @Nullable Object obj) {
                if (obj == null) {
                    return;
                }
                int length = Array.getLength(obj);
                for (int i2 = 0; i2 < length; i2++) {
                    n.this.a(pVar, Array.get(obj, i2));
                }
            }
        };
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    static final class m extends n<Object> {
        @Override // e.n
        void a(p pVar, @Nullable Object obj) {
            u.a(obj, "@Url parameter is null.");
            pVar.a(obj);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    static final class d<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f7078a;

        /* renamed from: b  reason: collision with root package name */
        private final e.f<T, String> f7079b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(String str, e.f<T, String> fVar) {
            this.f7078a = (String) u.a(str, "name == null");
            this.f7079b = fVar;
        }

        @Override // e.n
        void a(p pVar, @Nullable T t) {
            String a2;
            if (t == null || (a2 = this.f7079b.a(t)) == null) {
                return;
            }
            pVar.a(this.f7078a, a2);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    static final class h<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f7085a;

        /* renamed from: b  reason: collision with root package name */
        private final e.f<T, String> f7086b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f7087c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public h(String str, e.f<T, String> fVar, boolean z) {
            this.f7085a = (String) u.a(str, "name == null");
            this.f7086b = fVar;
            this.f7087c = z;
        }

        @Override // e.n
        void a(p pVar, @Nullable T t) {
            if (t == null) {
                throw new IllegalArgumentException("Path parameter \"" + this.f7085a + "\" value must not be null.");
            }
            pVar.a(this.f7085a, this.f7086b.a(t), this.f7087c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    static final class i<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f7088a;

        /* renamed from: b  reason: collision with root package name */
        private final e.f<T, String> f7089b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f7090c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(String str, e.f<T, String> fVar, boolean z) {
            this.f7088a = (String) u.a(str, "name == null");
            this.f7089b = fVar;
            this.f7090c = z;
        }

        @Override // e.n
        void a(p pVar, @Nullable T t) {
            String a2;
            if (t == null || (a2 = this.f7089b.a(t)) == null) {
                return;
            }
            pVar.b(this.f7088a, a2, this.f7090c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    static final class k<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        private final e.f<T, String> f7093a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f7094b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(e.f<T, String> fVar, boolean z) {
            this.f7093a = fVar;
            this.f7094b = z;
        }

        @Override // e.n
        void a(p pVar, @Nullable T t) {
            if (t == null) {
                return;
            }
            pVar.b(this.f7093a.a(t), null, this.f7094b);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    static final class j<T> extends n<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        private final e.f<T, String> f7091a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f7092b;

        @Override // e.n
        /* bridge */ /* synthetic */ void a(p pVar, @Nullable Object obj) {
            a(pVar, (Map) ((Map) obj));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(e.f<T, String> fVar, boolean z) {
            this.f7091a = fVar;
            this.f7092b = z;
        }

        void a(p pVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw new IllegalArgumentException("Query map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Query map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Query map contained null value for key '" + key + "'.");
                }
                String a2 = this.f7091a.a(value);
                if (a2 == null) {
                    throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.f7091a.getClass().getName() + " for key '" + key + "'.");
                }
                pVar.b(key, a2, this.f7092b);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    static final class e<T> extends n<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        private final e.f<T, String> f7080a;

        @Override // e.n
        /* bridge */ /* synthetic */ void a(p pVar, @Nullable Object obj) {
            a(pVar, (Map) ((Map) obj));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(e.f<T, String> fVar) {
            this.f7080a = fVar;
        }

        void a(p pVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw new IllegalArgumentException("Header map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Header map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Header map contained null value for key '" + key + "'.");
                }
                pVar.a(key, this.f7080a.a(value));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    static final class b<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f7073a;

        /* renamed from: b  reason: collision with root package name */
        private final e.f<T, String> f7074b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f7075c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str, e.f<T, String> fVar, boolean z) {
            this.f7073a = (String) u.a(str, "name == null");
            this.f7074b = fVar;
            this.f7075c = z;
        }

        @Override // e.n
        void a(p pVar, @Nullable T t) {
            String a2;
            if (t == null || (a2 = this.f7074b.a(t)) == null) {
                return;
            }
            pVar.c(this.f7073a, a2, this.f7075c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    static final class c<T> extends n<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        private final e.f<T, String> f7076a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f7077b;

        @Override // e.n
        /* bridge */ /* synthetic */ void a(p pVar, @Nullable Object obj) {
            a(pVar, (Map) ((Map) obj));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(e.f<T, String> fVar, boolean z) {
            this.f7076a = fVar;
            this.f7077b = z;
        }

        void a(p pVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw new IllegalArgumentException("Field map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Field map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Field map contained null value for key '" + key + "'.");
                }
                String a2 = this.f7076a.a(value);
                if (a2 == null) {
                    throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.f7076a.getClass().getName() + " for key '" + key + "'.");
                }
                pVar.c(key, a2, this.f7077b);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    static final class f<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        private final okhttp3.s f7081a;

        /* renamed from: b  reason: collision with root package name */
        private final e.f<T, ab> f7082b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(okhttp3.s sVar, e.f<T, ab> fVar) {
            this.f7081a = sVar;
            this.f7082b = fVar;
        }

        @Override // e.n
        void a(p pVar, @Nullable T t) {
            if (t == null) {
                return;
            }
            try {
                pVar.a(this.f7081a, this.f7082b.a(t));
            } catch (IOException e2) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    static final class l extends n<w.b> {

        /* renamed from: a  reason: collision with root package name */
        static final l f7095a = new l();

        private l() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // e.n
        public void a(p pVar, @Nullable w.b bVar) {
            if (bVar != null) {
                pVar.a(bVar);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    static final class g<T> extends n<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        private final e.f<T, ab> f7083a;

        /* renamed from: b  reason: collision with root package name */
        private final String f7084b;

        @Override // e.n
        /* bridge */ /* synthetic */ void a(p pVar, @Nullable Object obj) {
            a(pVar, (Map) ((Map) obj));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(e.f<T, ab> fVar, String str) {
            this.f7083a = fVar;
            this.f7084b = str;
        }

        void a(p pVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw new IllegalArgumentException("Part map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Part map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                }
                pVar.a(okhttp3.s.a("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f7084b), this.f7083a.a(value));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    static final class a<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        private final e.f<T, ab> f7072a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(e.f<T, ab> fVar) {
            this.f7072a = fVar;
        }

        @Override // e.n
        void a(p pVar, @Nullable T t) {
            if (t == null) {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
            try {
                pVar.a(this.f7072a.a(t));
            } catch (IOException e2) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }
}
