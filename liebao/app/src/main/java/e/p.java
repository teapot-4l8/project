package e;

import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.q;
import okhttp3.t;
import okhttp3.v;
import okhttp3.w;

/* compiled from: RequestBuilder.java */
/* loaded from: classes.dex */
final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f7098a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f7099b = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: c  reason: collision with root package name */
    private final String f7100c;

    /* renamed from: d  reason: collision with root package name */
    private final okhttp3.t f7101d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f7102e;
    @Nullable
    private t.a f;
    private final aa.a g;
    @Nullable
    private v h;
    private final boolean i;
    @Nullable
    private w.a j;
    @Nullable
    private q.a k;
    @Nullable
    private ab l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, okhttp3.t tVar, @Nullable String str2, @Nullable okhttp3.s sVar, @Nullable v vVar, boolean z, boolean z2, boolean z3) {
        this.f7100c = str;
        this.f7101d = tVar;
        this.f7102e = str2;
        aa.a aVar = new aa.a();
        this.g = aVar;
        this.h = vVar;
        this.i = z;
        if (sVar != null) {
            aVar.a(sVar);
        }
        if (z2) {
            this.k = new q.a();
        } else if (z3) {
            w.a aVar2 = new w.a();
            this.j = aVar2;
            aVar2.a(w.f7729e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Object obj) {
        this.f7102e = obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                this.h = v.a(str2);
                return;
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Malformed content type: " + str2, e2);
            }
        }
        this.g.b(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, boolean z) {
        if (this.f7102e == null) {
            throw new AssertionError();
        }
        String a2 = a(str2, z);
        String str3 = this.f7102e;
        String replace = str3.replace("{" + str + "}", a2);
        if (f7099b.matcher(replace).matches()) {
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
        }
        this.f7102e = replace;
    }

    private static String a(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                i += Character.charCount(codePointAt);
            } else {
                c.c cVar = new c.c();
                cVar.a(str, 0, i);
                a(cVar, str, i, length, z);
                return cVar.q();
            }
        }
        return str;
    }

    private static void a(c.c cVar, String str, int i, int i2, boolean z) {
        c.c cVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (cVar2 == null) {
                        cVar2 = new c.c();
                    }
                    cVar2.a(codePointAt);
                    while (!cVar2.f()) {
                        int i3 = cVar2.i() & 255;
                        cVar.i(37);
                        cVar.i((int) f7098a[(i3 >> 4) & 15]);
                        cVar.i((int) f7098a[i3 & 15]);
                    }
                } else {
                    cVar.a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, @Nullable String str2, boolean z) {
        String str3 = this.f7102e;
        if (str3 != null) {
            t.a d2 = this.f7101d.d(str3);
            this.f = d2;
            if (d2 == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f7101d + ", Relative: " + this.f7102e);
            }
            this.f7102e = null;
        }
        if (z) {
            this.f.b(str, str2);
        } else {
            this.f.a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, String str2, boolean z) {
        if (z) {
            this.k.b(str, str2);
        } else {
            this.k.a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(okhttp3.s sVar, ab abVar) {
        this.j.a(sVar, abVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(w.b bVar) {
        this.j.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ab abVar) {
        this.l = abVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa.a a() {
        okhttp3.t c2;
        t.a aVar = this.f;
        if (aVar != null) {
            c2 = aVar.c();
        } else {
            c2 = this.f7101d.c(this.f7102e);
            if (c2 == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f7101d + ", Relative: " + this.f7102e);
            }
        }
        a aVar2 = this.l;
        if (aVar2 == null) {
            q.a aVar3 = this.k;
            if (aVar3 != null) {
                aVar2 = aVar3.a();
            } else {
                w.a aVar4 = this.j;
                if (aVar4 != null) {
                    aVar2 = aVar4.a();
                } else if (this.i) {
                    aVar2 = ab.a((v) null, new byte[0]);
                }
            }
        }
        v vVar = this.h;
        if (vVar != null) {
            if (aVar2 != null) {
                aVar2 = new a(aVar2, vVar);
            } else {
                this.g.b("Content-Type", vVar.toString());
            }
        }
        return this.g.a(c2).a(this.f7100c, aVar2);
    }

    /* compiled from: RequestBuilder.java */
    /* loaded from: classes2.dex */
    private static class a extends ab {

        /* renamed from: a  reason: collision with root package name */
        private final ab f7103a;

        /* renamed from: b  reason: collision with root package name */
        private final v f7104b;

        a(ab abVar, v vVar) {
            this.f7103a = abVar;
            this.f7104b = vVar;
        }

        @Override // okhttp3.ab
        public v b() {
            return this.f7104b;
        }

        @Override // okhttp3.ab
        public long c() {
            return this.f7103a.c();
        }

        @Override // okhttp3.ab
        public void a(c.d dVar) {
            this.f7103a.a(dVar);
        }
    }
}
