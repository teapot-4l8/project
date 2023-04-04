package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* compiled from: Cookie.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f7684a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f7685b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f7686c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f7687d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: e  reason: collision with root package name */
    private final String f7688e;
    private final String f;
    private final long g;
    private final String h;
    private final String i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    private l(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f7688e = str;
        this.f = str2;
        this.g = j;
        this.h = str3;
        this.i = str4;
        this.j = z;
        this.k = z2;
        this.m = z3;
        this.l = z4;
    }

    public String a() {
        return this.f7688e;
    }

    public String b() {
        return this.f;
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !okhttp3.internal.c.c(str);
    }

    @Nullable
    public static l a(t tVar, String str) {
        return a(System.currentTimeMillis(), tVar, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0128  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static l a(long j, t tVar, String str) {
        long j2;
        String f;
        l lVar;
        String str2;
        String substring;
        int length = str.length();
        char c2 = ';';
        int a2 = okhttp3.internal.c.a(str, 0, length, ';');
        char c3 = '=';
        int a3 = okhttp3.internal.c.a(str, 0, a2, '=');
        if (a3 == a2) {
            return null;
        }
        String c4 = okhttp3.internal.c.c(str, 0, a3);
        if (c4.isEmpty() || okhttp3.internal.c.b(c4) != -1) {
            return null;
        }
        String c5 = okhttp3.internal.c.c(str, a3 + 1, a2);
        if (okhttp3.internal.c.b(c5) != -1) {
            return null;
        }
        int i = a2 + 1;
        String str3 = null;
        String str4 = null;
        long j3 = -1;
        long j4 = 253402300799999L;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        while (i < length) {
            int a4 = okhttp3.internal.c.a(str, i, length, c2);
            int a5 = okhttp3.internal.c.a(str, i, a4, c3);
            String c6 = okhttp3.internal.c.c(str, i, a5);
            String c7 = a5 < a4 ? okhttp3.internal.c.c(str, a5 + 1, a4) : "";
            if (c6.equalsIgnoreCase("expires")) {
                try {
                    j4 = a(c7, 0, c7.length());
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (c6.equalsIgnoreCase("max-age")) {
                j3 = a(c7);
            } else {
                if (c6.equalsIgnoreCase("domain")) {
                    str4 = b(c7);
                    z3 = false;
                } else if (c6.equalsIgnoreCase("path")) {
                    str3 = c7;
                } else if (c6.equalsIgnoreCase("secure")) {
                    z = true;
                } else if (c6.equalsIgnoreCase("httponly")) {
                    z2 = true;
                }
                i = a4 + 1;
                c2 = ';';
                c3 = '=';
            }
            z4 = true;
            i = a4 + 1;
            c2 = ';';
            c3 = '=';
        }
        long j5 = Long.MIN_VALUE;
        if (j3 != Long.MIN_VALUE) {
            if (j3 != -1) {
                j5 = j + (j3 <= 9223372036854775L ? j3 * 1000 : Long.MAX_VALUE);
                if (j5 < j || j5 > 253402300799999L) {
                    j2 = 253402300799999L;
                }
            } else {
                j2 = j4;
            }
            f = tVar.f();
            if (str4 != null) {
                str2 = f;
                lVar = null;
            } else if (!a(f, str4)) {
                return null;
            } else {
                lVar = null;
                str2 = str4;
            }
            if (f.length() == str2.length() && PublicSuffixDatabase.a().a(str2) == null) {
                return lVar;
            }
            if (str3 == null && str3.startsWith("/")) {
                substring = str3;
            } else {
                String h = tVar.h();
                int lastIndexOf = h.lastIndexOf(47);
                substring = lastIndexOf != 0 ? h.substring(0, lastIndexOf) : "/";
            }
            return new l(c4, c5, j2, str2, substring, z, z2, z3, z4);
        }
        j2 = j5;
        f = tVar.f();
        if (str4 != null) {
        }
        if (f.length() == str2.length()) {
        }
        if (str3 == null) {
        }
        String h2 = tVar.h();
        int lastIndexOf2 = h2.lastIndexOf(47);
        substring = lastIndexOf2 != 0 ? h2.substring(0, lastIndexOf2) : "/";
        return new l(c4, c5, j2, str2, substring, z, z2, z3, z4);
    }

    private static long a(String str, int i, int i2) {
        int a2 = a(str, i, i2, false);
        Matcher matcher = f7687d.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (a2 < i2) {
            int a3 = a(str, a2 + 1, i2, true);
            matcher.region(a2, a3);
            if (i4 == -1 && matcher.usePattern(f7687d).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(f7686c).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (i6 == -1 && matcher.usePattern(f7685b).matches()) {
                i6 = f7685b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i3 == -1 && matcher.usePattern(f7684a).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
            }
            a2 = a(str, a3 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 >= 1601) {
            if (i6 != -1) {
                if (i5 < 1 || i5 > 31) {
                    throw new IllegalArgumentException();
                }
                if (i4 < 0 || i4 > 23) {
                    throw new IllegalArgumentException();
                }
                if (i7 < 0 || i7 > 59) {
                    throw new IllegalArgumentException();
                }
                if (i8 < 0 || i8 > 59) {
                    throw new IllegalArgumentException();
                }
                GregorianCalendar gregorianCalendar = new GregorianCalendar(okhttp3.internal.c.g);
                gregorianCalendar.setLenient(false);
                gregorianCalendar.set(1, i3);
                gregorianCalendar.set(2, i6 - 1);
                gregorianCalendar.set(5, i5);
                gregorianCalendar.set(11, i4);
                gregorianCalendar.set(12, i7);
                gregorianCalendar.set(13, i8);
                gregorianCalendar.set(14, 0);
                return gregorianCalendar.getTimeInMillis();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static int a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e2) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e2;
        }
    }

    private static String b(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String a2 = okhttp3.internal.c.a(str);
        if (a2 != null) {
            return a2;
        }
        throw new IllegalArgumentException();
    }

    public static List<l> a(t tVar, s sVar) {
        List<String> b2 = sVar.b("Set-Cookie");
        int size = b2.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            l a2 = a(tVar, b2.get(i));
            if (a2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a2);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return a(false);
    }

    String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7688e);
        sb.append('=');
        sb.append(this.f);
        if (this.l) {
            if (this.g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(okhttp3.internal.c.d.a(new Date(this.g)));
            }
        }
        if (!this.m) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.h);
        }
        sb.append("; path=");
        sb.append(this.i);
        if (this.j) {
            sb.append("; secure");
        }
        if (this.k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            return lVar.f7688e.equals(this.f7688e) && lVar.f.equals(this.f) && lVar.h.equals(this.h) && lVar.i.equals(this.i) && lVar.g == this.g && lVar.j == this.j && lVar.k == this.k && lVar.l == this.l && lVar.m == this.m;
        }
        return false;
    }

    public int hashCode() {
        long j = this.g;
        return ((((((((((((((((527 + this.f7688e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (!this.j ? 1 : 0)) * 31) + (!this.k ? 1 : 0)) * 31) + (!this.l ? 1 : 0)) * 31) + (!this.m ? 1 : 0);
    }
}
