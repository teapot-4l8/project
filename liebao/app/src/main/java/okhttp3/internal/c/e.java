package okhttp3.internal.c;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.m;
import okhttp3.s;
import okhttp3.t;

/* compiled from: HttpHeaders.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final c.f f7478a = c.f.a("\"\\");

    /* renamed from: b  reason: collision with root package name */
    private static final c.f f7479b = c.f.a("\t ,=");

    public static long a(ac acVar) {
        return a(acVar.g());
    }

    public static long a(s sVar) {
        return a(sVar.a("Content-Length"));
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean a(ac acVar, s sVar, aa aaVar) {
        for (String str : e(acVar)) {
            if (!okhttp3.internal.c.a(sVar.b(str), aaVar.b(str))) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(ac acVar) {
        return b(acVar.g());
    }

    public static boolean b(s sVar) {
        return c(sVar).contains("*");
    }

    private static Set<String> e(ac acVar) {
        return c(acVar.g());
    }

    public static Set<String> c(s sVar) {
        Set<String> emptySet = Collections.emptySet();
        int a2 = sVar.a();
        for (int i = 0; i < a2; i++) {
            if ("Vary".equalsIgnoreCase(sVar.a(i))) {
                String b2 = sVar.b(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : b2.split(",")) {
                    emptySet.add(str.trim());
                }
            }
        }
        return emptySet;
    }

    public static s c(ac acVar) {
        return a(acVar.j().a().c(), acVar.g());
    }

    public static s a(s sVar, s sVar2) {
        Set<String> c2 = c(sVar2);
        if (c2.isEmpty()) {
            return new s.a().a();
        }
        s.a aVar = new s.a();
        int a2 = sVar.a();
        for (int i = 0; i < a2; i++) {
            String a3 = sVar.a(i);
            if (c2.contains(a3)) {
                aVar.a(a3, sVar.b(i));
            }
        }
        return aVar.a();
    }

    public static void a(m mVar, t tVar, s sVar) {
        if (mVar == m.f7689a) {
            return;
        }
        List<okhttp3.l> a2 = okhttp3.l.a(tVar, sVar);
        if (a2.isEmpty()) {
            return;
        }
        mVar.a(tVar, a2);
    }

    public static boolean d(ac acVar) {
        if (acVar.a().b().equals("HEAD")) {
            return false;
        }
        int c2 = acVar.c();
        return (((c2 >= 100 && c2 < 200) || c2 == 204 || c2 == 304) && a(acVar) == -1 && !"chunked".equalsIgnoreCase(acVar.a("Transfer-Encoding"))) ? false : true;
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
