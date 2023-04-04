package okhttp3.internal;

import c.e;
import c.f;
import c.s;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f7464a;

    /* renamed from: c  reason: collision with root package name */
    public static final ad f7466c;

    /* renamed from: d  reason: collision with root package name */
    public static final ab f7467d;
    private static final Method r;
    private static final Pattern s;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f7465b = new String[0];
    private static final f i = f.c("efbbbf");
    private static final f j = f.c("feff");
    private static final f k = f.c("fffe");
    private static final f l = f.c("0000ffff");
    private static final f m = f.c("ffff0000");

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f7468e = Charset.forName("UTF-8");
    public static final Charset f = Charset.forName("ISO-8859-1");
    private static final Charset n = Charset.forName("UTF-16BE");
    private static final Charset o = Charset.forName("UTF-16LE");
    private static final Charset p = Charset.forName("UTF-32BE");

    /* renamed from: q  reason: collision with root package name */
    private static final Charset f7469q = Charset.forName("UTF-32LE");
    public static final TimeZone g = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> h = new Comparator<String>() { // from class: okhttp3.internal.c.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };

    public static int a(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    return -1;
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    static {
        byte[] bArr = new byte[0];
        f7464a = bArr;
        Method method = null;
        f7466c = ad.a((v) null, bArr);
        f7467d = ab.a((v) null, f7464a);
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        r = method;
        s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static void a(Throwable th, Throwable th2) {
        Method method = r;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static void a(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(s sVar, int i2, TimeUnit timeUnit) {
        try {
            return b(sVar, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean b(s sVar, int i2, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long d2 = sVar.a().o_() ? sVar.a().d() - nanoTime : Long.MAX_VALUE;
        sVar.a().a(Math.min(d2, timeUnit.toNanos(i2)) + nanoTime);
        try {
            c.c cVar = new c.c();
            while (sVar.a(cVar, 8192L) != -1) {
                cVar.u();
            }
            if (d2 == Long.MAX_VALUE) {
                sVar.a().f();
            } else {
                sVar.a().a(nanoTime + d2);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (d2 == Long.MAX_VALUE) {
                sVar.a().f();
            } else {
                sVar.a().a(nanoTime + d2);
            }
            return false;
        } catch (Throwable th) {
            if (d2 == Long.MAX_VALUE) {
                sVar.a().f();
            } else {
                sVar.a().a(nanoTime + d2);
            }
            throw th;
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <K, V> Map<K, V> a(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(final String str, final boolean z) {
        return new ThreadFactory() { // from class: okhttp3.internal.c.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i2++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String a(t tVar, boolean z) {
        String f2;
        if (tVar.f().contains(":")) {
            f2 = "[" + tVar.f() + "]";
        } else {
            f2 = tVar.f();
        }
        if (z || tVar.g() != t.a(tVar.b())) {
            return f2 + ":" + tVar.g();
        }
        return f2;
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static String[] a(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int a(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int b(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char charAt = str.charAt(i4);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static String c(String str, int i2, int i3) {
        int a2 = a(str, i2, i3);
        return str.substring(a2, b(str, a2, i3));
    }

    public static int a(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String a(String str) {
        InetAddress d2;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                d2 = d(str, 1, str.length() - 1);
            } else {
                d2 = d(str, 0, str.length());
            }
            if (d2 == null) {
                return null;
            }
            byte[] address = d2.getAddress();
            if (address.length == 16) {
                return a(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (d(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static boolean d(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int b(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean c(String str) {
        return s.matcher(str).matches();
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset a(e eVar, Charset charset) {
        if (eVar.a(0L, i)) {
            eVar.i(i.h());
            return f7468e;
        } else if (eVar.a(0L, j)) {
            eVar.i(j.h());
            return n;
        } else if (eVar.a(0L, k)) {
            eVar.i(k.h());
            return o;
        } else if (eVar.a(0L, l)) {
            eVar.i(l.h());
            return p;
        } else if (eVar.a(0L, m)) {
            eVar.i(m.h());
            return f7469q;
        } else {
            return charset;
        }
    }

    public static int a(String str, long j2, TimeUnit timeUnit) {
        if (j2 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        } else if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        } else {
            long millis = timeUnit.toMillis(j2);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            } else if (millis != 0 || j2 <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(str + " too small.");
            }
        }
    }

    public static AssertionError a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static InetAddress d(String str, int i2, int i3) {
        int i4;
        byte[] bArr = new byte[16];
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i2 < i3) {
                if (i5 != 16) {
                    int i8 = i2 + 2;
                    if (i8 <= i3 && str.regionMatches(i2, "::", 0, 2)) {
                        if (i6 == -1) {
                            i5 += 2;
                            i6 = i5;
                            if (i8 != i3) {
                                i7 = i8;
                                i2 = i7;
                                int i9 = 0;
                                while (i2 < i3) {
                                }
                                i4 = i2 - i7;
                                if (i4 == 0) {
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        return null;
                    }
                    if (i5 != 0) {
                        if (str.regionMatches(i2, ":", 0, 1)) {
                            i2++;
                        } else if (!str.regionMatches(i2, ".", 0, 1) || !a(str, i7, i3, bArr, i5 - 2)) {
                            return null;
                        } else {
                            i5 += 2;
                        }
                    }
                    i7 = i2;
                    i2 = i7;
                    int i92 = 0;
                    while (i2 < i3) {
                        int a2 = a(str.charAt(i2));
                        if (a2 == -1) {
                            break;
                        }
                        i92 = (i92 << 4) + a2;
                        i2++;
                    }
                    i4 = i2 - i7;
                    if (i4 == 0 || i4 > 4) {
                        break;
                    }
                    int i10 = i5 + 1;
                    bArr[i5] = (byte) ((i92 >>> 8) & 255);
                    i5 = i10 + 1;
                    bArr[i10] = (byte) (i92 & 255);
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        if (i5 != 16) {
            if (i6 == -1) {
                return null;
            }
            int i11 = i5 - i6;
            System.arraycopy(bArr, i6, bArr, 16 - i11, i11);
            Arrays.fill(bArr, i6, (16 - i5) + i6, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    private static boolean a(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char charAt = str.charAt(i6);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i6++;
                }
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    private static String a(byte[] bArr) {
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i3 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        c.c cVar = new c.c();
        while (i2 < bArr.length) {
            if (i2 == i3) {
                cVar.i(58);
                i2 += i5;
                if (i2 == 16) {
                    cVar.i(58);
                }
            } else {
                if (i2 > 0) {
                    cVar.i(58);
                }
                cVar.l(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return cVar.q();
    }

    public static X509TrustManager a() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            return (X509TrustManager) trustManagers[0];
        } catch (GeneralSecurityException e2) {
            throw a("No System TLS", (Exception) e2);
        }
    }

    public static okhttp3.s b(List<okhttp3.internal.e.c> list) {
        s.a aVar = new s.a();
        for (okhttp3.internal.e.c cVar : list) {
            a.f7398a.a(aVar, cVar.g.a(), cVar.h.a());
        }
        return aVar.a();
    }
}
