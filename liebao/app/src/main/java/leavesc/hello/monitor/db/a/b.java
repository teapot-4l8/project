package leavesc.hello.monitor.db.a;

import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import leavesc.hello.monitor.b.c;
import okhttp3.s;

/* compiled from: HttpInformation.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private long f7240a;

    /* renamed from: b  reason: collision with root package name */
    private Date f7241b;

    /* renamed from: c  reason: collision with root package name */
    private Date f7242c;

    /* renamed from: d  reason: collision with root package name */
    private long f7243d;

    /* renamed from: e  reason: collision with root package name */
    private String f7244e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private long n;

    /* renamed from: q  reason: collision with root package name */
    private String f7245q;
    private String r;
    private String s;
    private String t;
    private long u;
    private String w;
    private boolean o = true;
    private int p = -100;
    private boolean v = true;

    /* compiled from: HttpInformation.java */
    /* loaded from: classes2.dex */
    public enum a {
        Requested,
        Complete,
        Failed
    }

    public void a(s sVar) {
        if (sVar != null) {
            ArrayList arrayList = new ArrayList();
            int a2 = sVar.a();
            for (int i = 0; i < a2; i++) {
                arrayList.add(new leavesc.hello.monitor.db.a.a(sVar.a(i), sVar.b(i)));
            }
            g(c.a().toJson(arrayList));
            return;
        }
        g(null);
    }

    public void b(s sVar) {
        if (sVar != null) {
            ArrayList arrayList = new ArrayList();
            int a2 = sVar.a();
            for (int i = 0; i < a2; i++) {
                arrayList.add(new leavesc.hello.monitor.db.a.a(sVar.a(i), sVar.b(i)));
            }
            j(c.a().toJson(arrayList));
            return;
        }
        j(null);
    }

    public a a() {
        if (this.w != null) {
            return a.Failed;
        }
        if (this.p == -100) {
            return a.Requested;
        }
        return a.Complete;
    }

    /* compiled from: HttpInformation.java */
    /* renamed from: leavesc.hello.monitor.db.a.b$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7248a;

        static {
            int[] iArr = new int[a.values().length];
            f7248a = iArr;
            try {
                iArr[a.Failed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7248a[a.Requested.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String b() {
        int i = AnonymousClass3.f7248a[a().ordinal()];
        if (i == 1) {
            return " ! ! !  " + this.h;
        } else if (i == 2) {
            return " . . .  " + this.h;
        } else {
            return String.valueOf(this.p) + " " + this.h;
        }
    }

    public String c() {
        int i = AnonymousClass3.f7248a[a().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return String.valueOf(this.p) + " " + this.s;
            }
            return null;
        }
        return this.w;
    }

    private List<leavesc.hello.monitor.db.a.a> F() {
        return (List) c.a().fromJson(this.k, new TypeToken<List<leavesc.hello.monitor.db.a.a>>() { // from class: leavesc.hello.monitor.db.a.b.1
        }.getType());
    }

    public String a(boolean z) {
        return leavesc.hello.monitor.b.b.a(F(), z);
    }

    public String d() {
        return leavesc.hello.monitor.b.b.a(this.l, this.m);
    }

    public String e() {
        return leavesc.hello.monitor.b.b.a(this.r, this.t);
    }

    private List<leavesc.hello.monitor.db.a.a> G() {
        return (List) c.a().fromJson(this.f7245q, new TypeToken<List<leavesc.hello.monitor.db.a.a>>() { // from class: leavesc.hello.monitor.db.a.b.2
        }.getType());
    }

    public String b(boolean z) {
        return leavesc.hello.monitor.b.b.a(G(), z);
    }

    public String f() {
        return this.f7243d + " ms";
    }

    public boolean g() {
        return "https".equalsIgnoreCase(this.i);
    }

    public String h() {
        return leavesc.hello.monitor.b.b.a(this.n + this.u);
    }

    public long i() {
        return this.f7240a;
    }

    public void a(long j) {
        this.f7240a = j;
    }

    public Date j() {
        return this.f7241b;
    }

    public void a(Date date) {
        this.f7241b = date;
    }

    public Date k() {
        return this.f7242c;
    }

    public void b(Date date) {
        this.f7242c = date;
    }

    public long l() {
        return this.f7243d;
    }

    public void b(long j) {
        this.f7243d = j;
    }

    public String m() {
        return this.f7244e;
    }

    public void a(String str) {
        this.f7244e = str;
    }

    public String n() {
        return this.f;
    }

    public void b(String str) {
        this.f = str;
    }

    public String o() {
        return this.g;
    }

    public void c(String str) {
        this.g = str;
    }

    public String p() {
        return this.h;
    }

    public void d(String str) {
        this.h = str;
    }

    public String q() {
        return this.i;
    }

    public void e(String str) {
        this.i = str;
    }

    public String r() {
        return this.j;
    }

    public void f(String str) {
        this.j = str;
    }

    public String s() {
        return this.k;
    }

    public void g(String str) {
        this.k = str;
    }

    public String t() {
        return this.l;
    }

    public void h(String str) {
        this.l = str;
    }

    public String u() {
        return this.m;
    }

    public void i(String str) {
        this.m = str;
    }

    public long v() {
        return this.n;
    }

    public void c(long j) {
        this.n = j;
    }

    public boolean w() {
        return this.o;
    }

    public void c(boolean z) {
        this.o = z;
    }

    public int x() {
        return this.p;
    }

    public void a(int i) {
        this.p = i;
    }

    public String y() {
        return this.f7245q;
    }

    public void j(String str) {
        this.f7245q = str;
    }

    public String z() {
        return this.r;
    }

    public void k(String str) {
        this.r = str;
    }

    public String A() {
        return this.s;
    }

    public void l(String str) {
        this.s = str;
    }

    public String B() {
        return this.t;
    }

    public void m(String str) {
        this.t = str;
    }

    public long C() {
        return this.u;
    }

    public void d(long j) {
        this.u = j;
    }

    public boolean D() {
        return this.v;
    }

    public void d(boolean z) {
        this.v = z;
    }

    public String E() {
        return this.w;
    }

    public void n(String str) {
        this.w = str;
    }

    public String toString() {
        return "HttpInformation{id=" + this.f7240a + ", requestDate=" + this.f7241b + ", responseDate=" + this.f7242c + ", duration=" + this.f7243d + ", method='" + this.f7244e + "', url='" + this.f + "', host='" + this.g + "', path='" + this.h + "', scheme='" + this.i + "', protocol='" + this.j + "', requestHeaders='" + this.k + "', requestBody='" + this.l + "', requestContentType='" + this.m + "', requestContentLength=" + this.n + ", requestBodyIsPlainText=" + this.o + ", responseCode=" + this.p + ", responseHeaders='" + this.f7245q + "', responseBody='" + this.r + "', responseMessage='" + this.s + "', responseContentType='" + this.t + "', responseContentLength=" + this.u + ", responseBodyIsPlainText=" + this.v + ", error='" + this.w + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f7240a == bVar.f7240a && this.f7243d == bVar.f7243d && this.n == bVar.n && this.o == bVar.o && this.p == bVar.p && this.u == bVar.u && this.v == bVar.v) {
            Date date = this.f7241b;
            if (date == null ? bVar.f7241b == null : date.equals(bVar.f7241b)) {
                Date date2 = this.f7242c;
                if (date2 == null ? bVar.f7242c == null : date2.equals(bVar.f7242c)) {
                    String str = this.f7244e;
                    if (str == null ? bVar.f7244e == null : str.equals(bVar.f7244e)) {
                        String str2 = this.f;
                        if (str2 == null ? bVar.f == null : str2.equals(bVar.f)) {
                            String str3 = this.g;
                            if (str3 == null ? bVar.g == null : str3.equals(bVar.g)) {
                                String str4 = this.h;
                                if (str4 == null ? bVar.h == null : str4.equals(bVar.h)) {
                                    String str5 = this.i;
                                    if (str5 == null ? bVar.i == null : str5.equals(bVar.i)) {
                                        String str6 = this.j;
                                        if (str6 == null ? bVar.j == null : str6.equals(bVar.j)) {
                                            String str7 = this.k;
                                            if (str7 == null ? bVar.k == null : str7.equals(bVar.k)) {
                                                String str8 = this.l;
                                                if (str8 == null ? bVar.l == null : str8.equals(bVar.l)) {
                                                    String str9 = this.m;
                                                    if (str9 == null ? bVar.m == null : str9.equals(bVar.m)) {
                                                        String str10 = this.f7245q;
                                                        if (str10 == null ? bVar.f7245q == null : str10.equals(bVar.f7245q)) {
                                                            String str11 = this.r;
                                                            if (str11 == null ? bVar.r == null : str11.equals(bVar.r)) {
                                                                String str12 = this.s;
                                                                if (str12 == null ? bVar.s == null : str12.equals(bVar.s)) {
                                                                    String str13 = this.t;
                                                                    if (str13 == null ? bVar.t == null : str13.equals(bVar.t)) {
                                                                        String str14 = this.w;
                                                                        String str15 = bVar.w;
                                                                        return str14 != null ? str14.equals(str15) : str15 == null;
                                                                    }
                                                                    return false;
                                                                }
                                                                return false;
                                                            }
                                                            return false;
                                                        }
                                                        return false;
                                                    }
                                                    return false;
                                                }
                                                return false;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f7240a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Date date = this.f7241b;
        int hashCode = (i + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.f7242c;
        int hashCode2 = date2 != null ? date2.hashCode() : 0;
        long j2 = this.f7243d;
        int i2 = (((hashCode + hashCode2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.f7244e;
        int hashCode3 = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.g;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.h;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.i;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.j;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.k;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.l;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.m;
        int hashCode11 = str9 != null ? str9.hashCode() : 0;
        long j3 = this.n;
        int i3 = (((((((hashCode10 + hashCode11) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.o ? 1 : 0)) * 31) + this.p) * 31;
        String str10 = this.f7245q;
        int hashCode12 = (i3 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.r;
        int hashCode13 = (hashCode12 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.s;
        int hashCode14 = (hashCode13 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.t;
        int hashCode15 = str13 != null ? str13.hashCode() : 0;
        long j4 = this.u;
        int i4 = (((((hashCode14 + hashCode15) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.v ? 1 : 0)) * 31;
        String str14 = this.w;
        return i4 + (str14 != null ? str14.hashCode() : 0);
    }
}
