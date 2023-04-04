package okhttp3;

import com.umeng.analytics.pro.bz;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;

/* compiled from: MultipartBody.java */
/* loaded from: classes.dex */
public final class w extends ab {

    /* renamed from: a  reason: collision with root package name */
    public static final v f7725a = v.a("multipart/mixed");

    /* renamed from: b  reason: collision with root package name */
    public static final v f7726b = v.a("multipart/alternative");

    /* renamed from: c  reason: collision with root package name */
    public static final v f7727c = v.a("multipart/digest");

    /* renamed from: d  reason: collision with root package name */
    public static final v f7728d = v.a("multipart/parallel");

    /* renamed from: e  reason: collision with root package name */
    public static final v f7729e = v.a("multipart/form-data");
    private static final byte[] f = {58, 32};
    private static final byte[] g = {bz.k, 10};
    private static final byte[] h = {45, 45};
    private final c.f i;
    private final v j;
    private final v k;
    private final List<b> l;
    private long m = -1;

    w(c.f fVar, v vVar, List<b> list) {
        this.i = fVar;
        this.j = vVar;
        this.k = v.a(vVar + "; boundary=" + fVar.a());
        this.l = okhttp3.internal.c.a(list);
    }

    public List<b> a() {
        return this.l;
    }

    @Override // okhttp3.ab
    public v b() {
        return this.k;
    }

    @Override // okhttp3.ab
    public long c() {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        long a2 = a((c.d) null, true);
        this.m = a2;
        return a2;
    }

    @Override // okhttp3.ab
    public void a(c.d dVar) {
        a(dVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long a(@Nullable c.d dVar, boolean z) {
        c.c cVar;
        if (z) {
            dVar = new c.c();
            cVar = dVar;
        } else {
            cVar = 0;
        }
        int size = this.l.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            b bVar = this.l.get(i);
            s sVar = bVar.f7733a;
            ab abVar = bVar.f7734b;
            dVar.c(h);
            dVar.b(this.i);
            dVar.c(g);
            if (sVar != null) {
                int a2 = sVar.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    dVar.b(sVar.a(i2)).c(f).b(sVar.b(i2)).c(g);
                }
            }
            v b2 = abVar.b();
            if (b2 != null) {
                dVar.b("Content-Type: ").b(b2.toString()).c(g);
            }
            long c2 = abVar.c();
            if (c2 != -1) {
                dVar.b("Content-Length: ").m(c2).c(g);
            } else if (z) {
                cVar.u();
                return -1L;
            }
            dVar.c(g);
            if (z) {
                j += c2;
            } else {
                abVar.a(dVar);
            }
            dVar.c(g);
        }
        dVar.c(h);
        dVar.b(this.i);
        dVar.c(h);
        dVar.c(g);
        if (z) {
            long b3 = j + cVar.b();
            cVar.u();
            return b3;
        }
        return j;
    }

    static StringBuilder a(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt == '\"') {
                sb.append("%22");
            } else {
                sb.append(charAt);
            }
        }
        sb.append('\"');
        return sb;
    }

    /* compiled from: MultipartBody.java */
    /* loaded from: classes.dex */
    public static final class b {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        final s f7733a;

        /* renamed from: b  reason: collision with root package name */
        final ab f7734b;

        public static b a(@Nullable s sVar, ab abVar) {
            if (abVar == null) {
                throw new NullPointerException("body == null");
            }
            if (sVar != null && sVar.a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (sVar != null && sVar.a("Content-Length") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new b(sVar, abVar);
        }

        public static b a(String str, @Nullable String str2, ab abVar) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=");
            w.a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                w.a(sb, str2);
            }
            return a(s.a("Content-Disposition", sb.toString()), abVar);
        }

        private b(@Nullable s sVar, ab abVar) {
            this.f7733a = sVar;
            this.f7734b = abVar;
        }

        @Nullable
        public s a() {
            return this.f7733a;
        }

        public ab b() {
            return this.f7734b;
        }
    }

    /* compiled from: MultipartBody.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final c.f f7730a;

        /* renamed from: b  reason: collision with root package name */
        private v f7731b;

        /* renamed from: c  reason: collision with root package name */
        private final List<b> f7732c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.f7731b = w.f7725a;
            this.f7732c = new ArrayList();
            this.f7730a = c.f.a(str);
        }

        public a a(v vVar) {
            if (vVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!vVar.a().equals("multipart")) {
                throw new IllegalArgumentException("multipart != " + vVar);
            }
            this.f7731b = vVar;
            return this;
        }

        public a a(@Nullable s sVar, ab abVar) {
            return a(b.a(sVar, abVar));
        }

        public a a(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("part == null");
            }
            this.f7732c.add(bVar);
            return this;
        }

        public w a() {
            if (this.f7732c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new w(this.f7730a, this.f7731b, this.f7732c);
        }
    }
}
