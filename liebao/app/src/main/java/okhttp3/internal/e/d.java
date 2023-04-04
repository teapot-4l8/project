package okhttp3.internal.e;

import c.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Hpack.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    static final c[] f7525a = {new c(c.f, ""), new c(c.f7522c, "GET"), new c(c.f7522c, "POST"), new c(c.f7523d, "/"), new c(c.f7523d, "/index.html"), new c(c.f7524e, "http"), new c(c.f7524e, "https"), new c(c.f7521b, "200"), new c(c.f7521b, "204"), new c(c.f7521b, "206"), new c(c.f7521b, "304"), new c(c.f7521b, "400"), new c(c.f7521b, "404"), new c(c.f7521b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};

    /* renamed from: b  reason: collision with root package name */
    static final Map<c.f, Integer> f7526b = a();

    /* compiled from: Hpack.java */
    /* loaded from: classes2.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        c[] f7527a;

        /* renamed from: b  reason: collision with root package name */
        int f7528b;

        /* renamed from: c  reason: collision with root package name */
        int f7529c;

        /* renamed from: d  reason: collision with root package name */
        int f7530d;

        /* renamed from: e  reason: collision with root package name */
        private final List<c> f7531e;
        private final c.e f;
        private final int g;
        private int h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, s sVar) {
            this(i, i, sVar);
        }

        a(int i, int i2, s sVar) {
            this.f7531e = new ArrayList();
            c[] cVarArr = new c[8];
            this.f7527a = cVarArr;
            this.f7528b = cVarArr.length - 1;
            this.f7529c = 0;
            this.f7530d = 0;
            this.g = i;
            this.h = i2;
            this.f = c.l.a(sVar);
        }

        private void d() {
            int i = this.h;
            int i2 = this.f7530d;
            if (i < i2) {
                if (i == 0) {
                    e();
                } else {
                    a(i2 - i);
                }
            }
        }

        private void e() {
            Arrays.fill(this.f7527a, (Object) null);
            this.f7528b = this.f7527a.length - 1;
            this.f7529c = 0;
            this.f7530d = 0;
        }

        private int a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f7527a.length;
                while (true) {
                    length--;
                    if (length < this.f7528b || i <= 0) {
                        break;
                    }
                    i -= this.f7527a[length].i;
                    this.f7530d -= this.f7527a[length].i;
                    this.f7529c--;
                    i2++;
                }
                c[] cVarArr = this.f7527a;
                int i3 = this.f7528b;
                System.arraycopy(cVarArr, i3 + 1, cVarArr, i3 + 1 + i2, this.f7529c);
                this.f7528b += i2;
            }
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            while (!this.f.f()) {
                int i = this.f.i() & 255;
                if (i == 128) {
                    throw new IOException("index == 0");
                }
                if ((i & 128) == 128) {
                    b(a(i, 127) - 1);
                } else if (i == 64) {
                    g();
                } else if ((i & 64) == 64) {
                    e(a(i, 63) - 1);
                } else if ((i & 32) == 32) {
                    int a2 = a(i, 31);
                    this.h = a2;
                    if (a2 < 0 || a2 > this.g) {
                        throw new IOException("Invalid dynamic table size update " + this.h);
                    }
                    d();
                } else if (i == 16 || i == 0) {
                    f();
                } else {
                    d(a(i, 15) - 1);
                }
            }
        }

        public List<c> b() {
            ArrayList arrayList = new ArrayList(this.f7531e);
            this.f7531e.clear();
            return arrayList;
        }

        private void b(int i) {
            if (g(i)) {
                this.f7531e.add(d.f7525a[i]);
                return;
            }
            int c2 = c(i - d.f7525a.length);
            if (c2 >= 0) {
                c[] cVarArr = this.f7527a;
                if (c2 < cVarArr.length) {
                    this.f7531e.add(cVarArr[c2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int c(int i) {
            return this.f7528b + 1 + i;
        }

        private void d(int i) {
            this.f7531e.add(new c(f(i), c()));
        }

        private void f() {
            this.f7531e.add(new c(d.a(c()), c()));
        }

        private void e(int i) {
            a(-1, new c(f(i), c()));
        }

        private void g() {
            a(-1, new c(d.a(c()), c()));
        }

        private c.f f(int i) {
            if (g(i)) {
                return d.f7525a[i].g;
            }
            int c2 = c(i - d.f7525a.length);
            if (c2 >= 0) {
                c[] cVarArr = this.f7527a;
                if (c2 < cVarArr.length) {
                    return cVarArr[c2].g;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private boolean g(int i) {
            return i >= 0 && i <= d.f7525a.length - 1;
        }

        private void a(int i, c cVar) {
            this.f7531e.add(cVar);
            int i2 = cVar.i;
            if (i != -1) {
                i2 -= this.f7527a[c(i)].i;
            }
            int i3 = this.h;
            if (i2 > i3) {
                e();
                return;
            }
            int a2 = a((this.f7530d + i2) - i3);
            if (i == -1) {
                int i4 = this.f7529c + 1;
                c[] cVarArr = this.f7527a;
                if (i4 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f7528b = this.f7527a.length - 1;
                    this.f7527a = cVarArr2;
                }
                int i5 = this.f7528b;
                this.f7528b = i5 - 1;
                this.f7527a[i5] = cVar;
                this.f7529c++;
            } else {
                this.f7527a[i + c(i) + a2] = cVar;
            }
            this.f7530d += i2;
        }

        private int h() {
            return this.f.i() & 255;
        }

        int a(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int h = h();
                if ((h & 128) == 0) {
                    return i2 + (h << i4);
                }
                i2 += (h & 127) << i4;
                i4 += 7;
            }
        }

        c.f c() {
            int h = h();
            boolean z = (h & 128) == 128;
            int a2 = a(h, 127);
            if (z) {
                return c.f.a(k.a().a(this.f.h(a2)));
            }
            return this.f.d(a2);
        }
    }

    private static Map<c.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f7525a.length);
        int i = 0;
        while (true) {
            c[] cVarArr = f7525a;
            if (i < cVarArr.length) {
                if (!linkedHashMap.containsKey(cVarArr[i].g)) {
                    linkedHashMap.put(f7525a[i].g, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    /* compiled from: Hpack.java */
    /* loaded from: classes2.dex */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f7532a;

        /* renamed from: b  reason: collision with root package name */
        int f7533b;

        /* renamed from: c  reason: collision with root package name */
        c[] f7534c;

        /* renamed from: d  reason: collision with root package name */
        int f7535d;

        /* renamed from: e  reason: collision with root package name */
        int f7536e;
        int f;
        private final c.c g;
        private final boolean h;
        private int i;
        private boolean j;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(c.c cVar) {
            this(4096, true, cVar);
        }

        b(int i, boolean z, c.c cVar) {
            this.i = Integer.MAX_VALUE;
            c[] cVarArr = new c[8];
            this.f7534c = cVarArr;
            this.f7535d = cVarArr.length - 1;
            this.f7536e = 0;
            this.f = 0;
            this.f7532a = i;
            this.f7533b = i;
            this.h = z;
            this.g = cVar;
        }

        private void a() {
            Arrays.fill(this.f7534c, (Object) null);
            this.f7535d = this.f7534c.length - 1;
            this.f7536e = 0;
            this.f = 0;
        }

        private int b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f7534c.length;
                while (true) {
                    length--;
                    if (length < this.f7535d || i <= 0) {
                        break;
                    }
                    i -= this.f7534c[length].i;
                    this.f -= this.f7534c[length].i;
                    this.f7536e--;
                    i2++;
                }
                c[] cVarArr = this.f7534c;
                int i3 = this.f7535d;
                System.arraycopy(cVarArr, i3 + 1, cVarArr, i3 + 1 + i2, this.f7536e);
                c[] cVarArr2 = this.f7534c;
                int i4 = this.f7535d;
                Arrays.fill(cVarArr2, i4 + 1, i4 + 1 + i2, (Object) null);
                this.f7535d += i2;
            }
            return i2;
        }

        private void a(c cVar) {
            int i = cVar.i;
            int i2 = this.f7533b;
            if (i > i2) {
                a();
                return;
            }
            b((this.f + i) - i2);
            int i3 = this.f7536e + 1;
            c[] cVarArr = this.f7534c;
            if (i3 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f7535d = this.f7534c.length - 1;
                this.f7534c = cVarArr2;
            }
            int i4 = this.f7535d;
            this.f7535d = i4 - 1;
            this.f7534c[i4] = cVar;
            this.f7536e++;
            this.f += i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<c> list) {
            int i;
            int i2;
            if (this.j) {
                int i3 = this.i;
                if (i3 < this.f7533b) {
                    a(i3, 31, 32);
                }
                this.j = false;
                this.i = Integer.MAX_VALUE;
                a(this.f7533b, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                c cVar = list.get(i4);
                c.f g = cVar.g.g();
                c.f fVar = cVar.h;
                Integer num = d.f7526b.get(g);
                if (num != null) {
                    i = num.intValue() + 1;
                    if (i > 1 && i < 8) {
                        if (okhttp3.internal.c.a(d.f7525a[i - 1].h, fVar)) {
                            i2 = i;
                        } else if (okhttp3.internal.c.a(d.f7525a[i].h, fVar)) {
                            i2 = i;
                            i++;
                        }
                    }
                    i2 = i;
                    i = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i == -1) {
                    int i5 = this.f7535d + 1;
                    int length = this.f7534c.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (okhttp3.internal.c.a(this.f7534c[i5].g, g)) {
                            if (okhttp3.internal.c.a(this.f7534c[i5].h, fVar)) {
                                i = d.f7525a.length + (i5 - this.f7535d);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i5 - this.f7535d) + d.f7525a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i != -1) {
                    a(i, 127, 128);
                } else if (i2 == -1) {
                    this.g.i(64);
                    a(g);
                    a(fVar);
                    a(cVar);
                } else if (g.a(c.f7520a) && !c.f.equals(g)) {
                    a(i2, 15, 0);
                    a(fVar);
                } else {
                    a(i2, 63, 64);
                    a(fVar);
                    a(cVar);
                }
            }
        }

        void a(int i, int i2, int i3) {
            if (i < i2) {
                this.g.i(i | i3);
                return;
            }
            this.g.i(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.g.i(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.g.i(i4);
        }

        void a(c.f fVar) {
            if (this.h && k.a().a(fVar) < fVar.h()) {
                c.c cVar = new c.c();
                k.a().a(fVar, cVar);
                c.f p = cVar.p();
                a(p.h(), 127, 128);
                this.g.b(p);
                return;
            }
            a(fVar.h(), 127, 0);
            this.g.b(fVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i) {
            this.f7532a = i;
            int min = Math.min(i, 16384);
            int i2 = this.f7533b;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.i = Math.min(this.i, min);
            }
            this.j = true;
            this.f7533b = min;
            b();
        }

        private void b() {
            int i = this.f7533b;
            int i2 = this.f;
            if (i < i2) {
                if (i == 0) {
                    a();
                } else {
                    b(i2 - i);
                }
            }
        }
    }

    static c.f a(c.f fVar) {
        int h = fVar.h();
        for (int i = 0; i < h; i++) {
            byte a2 = fVar.a(i);
            if (a2 >= 65 && a2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.a());
            }
        }
        return fVar;
    }
}
