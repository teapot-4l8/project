package okhttp3;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: HttpUrl.java */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f7710d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    final String f7711a;

    /* renamed from: b  reason: collision with root package name */
    final String f7712b;

    /* renamed from: c  reason: collision with root package name */
    final int f7713c;

    /* renamed from: e  reason: collision with root package name */
    private final String f7714e;
    private final String f;
    private final List<String> g;
    @Nullable
    private final List<String> h;
    @Nullable
    private final String i;
    private final String j;

    t(a aVar) {
        this.f7711a = aVar.f7715a;
        this.f7714e = a(aVar.f7716b, false);
        this.f = a(aVar.f7717c, false);
        this.f7712b = aVar.f7718d;
        this.f7713c = aVar.a();
        this.g = a(aVar.f, false);
        this.h = aVar.g != null ? a(aVar.g, true) : null;
        this.i = aVar.h != null ? a(aVar.h, false) : null;
        this.j = aVar.toString();
    }

    public URI a() {
        String aVar = p().b().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public String b() {
        return this.f7711a;
    }

    public boolean c() {
        return this.f7711a.equals("https");
    }

    public String d() {
        if (this.f7714e.isEmpty()) {
            return "";
        }
        int length = this.f7711a.length() + 3;
        String str = this.j;
        return this.j.substring(length, okhttp3.internal.c.a(str, length, str.length(), ":@"));
    }

    public String e() {
        if (this.f.isEmpty()) {
            return "";
        }
        int indexOf = this.j.indexOf(64);
        return this.j.substring(this.j.indexOf(58, this.f7711a.length() + 3) + 1, indexOf);
    }

    public String f() {
        return this.f7712b;
    }

    public int g() {
        return this.f7713c;
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String h() {
        int indexOf = this.j.indexOf(47, this.f7711a.length() + 3);
        String str = this.j;
        return this.j.substring(indexOf, okhttp3.internal.c.a(str, indexOf, str.length(), "?#"));
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public List<String> i() {
        int indexOf = this.j.indexOf(47, this.f7711a.length() + 3);
        String str = this.j;
        int a2 = okhttp3.internal.c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i = indexOf + 1;
            int a3 = okhttp3.internal.c.a(this.j, i, a2, '/');
            arrayList.add(this.j.substring(i, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public List<String> j() {
        return this.g;
    }

    @Nullable
    public String k() {
        if (this.h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        String str = this.j;
        return this.j.substring(indexOf, okhttp3.internal.c.a(str, indexOf, str.length(), '#'));
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    @Nullable
    public String l() {
        if (this.h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, this.h);
        return sb.toString();
    }

    public int m() {
        List<String> list = this.h;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public String a(int i) {
        List<String> list = this.h;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        return list.get(i * 2);
    }

    public String b(int i) {
        List<String> list = this.h;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        return list.get((i * 2) + 1);
    }

    @Nullable
    public String n() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public String o() {
        return d("/...").b("").c("").c().toString();
    }

    @Nullable
    public t c(String str) {
        a d2 = d(str);
        if (d2 != null) {
            return d2.c();
        }
        return null;
    }

    public a p() {
        a aVar = new a();
        aVar.f7715a = this.f7711a;
        aVar.f7716b = d();
        aVar.f7717c = e();
        aVar.f7718d = this.f7712b;
        aVar.f7719e = this.f7713c != a(this.f7711a) ? this.f7713c : -1;
        aVar.f.clear();
        aVar.f.addAll(i());
        aVar.e(k());
        aVar.h = n();
        return aVar;
    }

    @Nullable
    public a d(String str) {
        try {
            return new a().a(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static t e(String str) {
        return new a().a((t) null, str).c();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof t) && ((t) obj).j.equals(this.j);
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }

    /* compiled from: HttpUrl.java */
    /* loaded from: classes.dex */
    public static final class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        String f7715a;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        String f7718d;
        final List<String> f;
        @Nullable
        List<String> g;
        @Nullable
        String h;

        /* renamed from: b  reason: collision with root package name */
        String f7716b = "";

        /* renamed from: c  reason: collision with root package name */
        String f7717c = "";

        /* renamed from: e  reason: collision with root package name */
        int f7719e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        public a a(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f7715a = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.f7715a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public a b(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f7716b = t.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a c(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f7717c = t.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a d(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String e2 = e(str, 0, str.length());
            if (e2 == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.f7718d = e2;
            return this;
        }

        public a a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.f7719e = i;
            return this;
        }

        int a() {
            int i = this.f7719e;
            return i != -1 ? i : t.a(this.f7715a);
        }

        public a e(@Nullable String str) {
            this.g = str != null ? t.b(t.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a a(String str, @Nullable String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(t.a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            this.g.add(str2 != null ? t.a(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
            return this;
        }

        public a b(String str, @Nullable String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(t.a(str, " \"'<>#&=", true, false, true, true));
            this.g.add(str2 != null ? t.a(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        a b() {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.set(i, t.a(this.f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, t.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = t.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public t c() {
            if (this.f7715a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f7718d == null) {
                throw new IllegalStateException("host == null");
            }
            return new t(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f7715a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f7716b.isEmpty() || !this.f7717c.isEmpty()) {
                sb.append(this.f7716b);
                if (!this.f7717c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f7717c);
                }
                sb.append('@');
            }
            String str2 = this.f7718d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f7718d);
                    sb.append(']');
                } else {
                    sb.append(this.f7718d);
                }
            }
            if (this.f7719e != -1 || this.f7715a != null) {
                int a2 = a();
                String str3 = this.f7715a;
                if (str3 == null || a2 != t.a(str3)) {
                    sb.append(':');
                    sb.append(a2);
                }
            }
            t.a(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                t.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        a a(@Nullable t tVar, String str) {
            int b2;
            int a2;
            int i;
            int a3 = okhttp3.internal.c.a(str, 0, str.length());
            int b3 = okhttp3.internal.c.b(str, a3, str.length());
            if (b(str, a3, b3) != -1) {
                if (str.regionMatches(true, a3, "https:", 0, 6)) {
                    this.f7715a = "https";
                    a3 += 6;
                } else if (str.regionMatches(true, a3, "http:", 0, 5)) {
                    this.f7715a = "http";
                    a3 += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, b2) + "'");
                }
            } else if (tVar != null) {
                this.f7715a = tVar.f7711a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int c2 = c(str, a3, b3);
            char c3 = '?';
            char c4 = '#';
            if (c2 >= 2 || tVar == null || !tVar.f7711a.equals(this.f7715a)) {
                int i2 = a3 + c2;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a2 = okhttp3.internal.c.a(str, i2, b3, "@/\\?#");
                    char charAt = a2 != b3 ? str.charAt(a2) : (char) 65535;
                    if (charAt == 65535 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int a4 = okhttp3.internal.c.a(str, i2, a2, ':');
                            i = a2;
                            String a5 = t.a(str, i2, a4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                a5 = this.f7716b + "%40" + a5;
                            }
                            this.f7716b = a5;
                            if (a4 != i) {
                                this.f7717c = t.a(str, a4 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = a2;
                            this.f7717c += "%40" + t.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                    }
                    c3 = '?';
                    c4 = '#';
                }
                int d2 = d(str, i2, a2);
                int i3 = d2 + 1;
                if (i3 < a2) {
                    this.f7718d = e(str, i2, d2);
                    int f = f(str, i3, a2);
                    this.f7719e = f;
                    if (f == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, a2) + '\"');
                    }
                } else {
                    this.f7718d = e(str, i2, d2);
                    this.f7719e = t.a(this.f7715a);
                }
                if (this.f7718d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, d2) + '\"');
                }
                a3 = a2;
            } else {
                this.f7716b = tVar.d();
                this.f7717c = tVar.e();
                this.f7718d = tVar.f7712b;
                this.f7719e = tVar.f7713c;
                this.f.clear();
                this.f.addAll(tVar.i());
                if (a3 == b3 || str.charAt(a3) == '#') {
                    e(tVar.k());
                }
            }
            int a6 = okhttp3.internal.c.a(str, a3, b3, "?#");
            a(str, a3, a6);
            if (a6 < b3 && str.charAt(a6) == '?') {
                int a7 = okhttp3.internal.c.a(str, a6, b3, '#');
                this.g = t.b(t.a(str, a6 + 1, a7, " \"'<>#", true, false, true, true, null));
                a6 = a7;
            }
            if (a6 < b3 && str.charAt(a6) == '#') {
                this.h = t.a(str, 1 + a6, b3, "", true, false, false, false, null);
            }
            return this;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:11:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = okhttp3.internal.c.a(r11, r6, r13, r12)
                if (r12 >= r13) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.t.a.a(java.lang.String, int, int):void");
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String a2 = t.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (f(a2)) {
                return;
            }
            if (g(a2)) {
                d();
                return;
            }
            List<String> list = this.f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f;
                list2.set(list2.size() - 1, a2);
            } else {
                this.f.add(a2);
            }
            if (z) {
                this.f.add("");
            }
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void d() {
            List<String> list = this.f;
            if (list.remove(list.size() - 1).isEmpty() && !this.f.isEmpty()) {
                List<String> list2 = this.f;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.f.add("");
        }

        private static int b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int d(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static String e(String str, int i, int i2) {
            return okhttp3.internal.c.a(t.a(str, i, i2, false));
        }

        private static int f(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(t.a(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                c.c cVar = new c.c();
                cVar.a(str, i, i3);
                a(cVar, str, i3, i2, z);
                return cVar.q();
            }
        }
        return str.substring(i, i2);
    }

    static void a(c.c cVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int a2 = okhttp3.internal.c.a(str.charAt(i + 1));
                int a3 = okhttp3.internal.c.a(str.charAt(i3));
                if (a2 != -1 && a3 != -1) {
                    cVar.i((a2 << 4) + a3);
                    i = i3;
                }
                cVar.a(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    cVar.i(32);
                }
                cVar.a(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    static boolean a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && okhttp3.internal.c.a(str.charAt(i + 1)) != -1 && okhttp3.internal.c.a(str.charAt(i3)) != -1;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i3, i2)))) && (codePointAt != 43 || !z3))) {
                    i3 += Character.charCount(codePointAt);
                }
            }
            c.c cVar = new c.c();
            cVar.a(str, i, i3);
            a(cVar, str, i3, i2, str2, z, z2, z3, z4, charset);
            return cVar.q();
        }
        return str.substring(i, i2);
    }

    static void a(c.c cVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        c.c cVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.b(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !a(str, i, i2)))))) {
                    if (cVar2 == null) {
                        cVar2 = new c.c();
                    }
                    if (charset == null || charset.equals(okhttp3.internal.c.f7468e)) {
                        cVar2.a(codePointAt);
                    } else {
                        cVar2.a(str, i, Character.charCount(codePointAt) + i, charset);
                    }
                    while (!cVar2.f()) {
                        int i3 = cVar2.i() & 255;
                        cVar.i(37);
                        cVar.i((int) f7710d[(i3 >> 4) & 15]);
                        cVar.i((int) f7710d[i3 & 15]);
                    }
                } else {
                    cVar.a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
