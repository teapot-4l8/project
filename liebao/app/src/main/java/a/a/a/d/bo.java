package a.a.a.d;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* compiled from: Options.java */
/* loaded from: classes.dex */
public final class bo {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, String> f186a;

    static {
        try {
            a();
        } catch (SecurityException unused) {
        }
    }

    public static void a() {
        String property = System.getProperty("dnsjava.options");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf == -1) {
                    a(nextToken);
                } else {
                    a(nextToken.substring(0, indexOf), nextToken.substring(indexOf + 1));
                }
            }
        }
    }

    public static void a(String str) {
        if (f186a == null) {
            f186a = new HashMap();
        }
        f186a.put(str.toLowerCase(), "true");
    }

    public static void a(String str, String str2) {
        if (f186a == null) {
            f186a = new HashMap();
        }
        f186a.put(str.toLowerCase(), str2.toLowerCase());
    }

    public static boolean b(String str) {
        Map<String, String> map = f186a;
        return (map == null || map.get(str.toLowerCase()) == null) ? false : true;
    }

    public static String c(String str) {
        Map<String, String> map = f186a;
        if (map == null) {
            return null;
        }
        return map.get(str.toLowerCase());
    }

    public static int d(String str) {
        String c2 = c(str);
        if (c2 != null) {
            try {
                int parseInt = Integer.parseInt(c2);
                if (parseInt > 0) {
                    return parseInt;
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return -1;
    }
}
