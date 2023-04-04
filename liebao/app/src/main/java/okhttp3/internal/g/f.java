package okhttp3.internal.g;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.x;
import okhttp3.y;

/* compiled from: Platform.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final f f7659a = a();

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f7660b = Logger.getLogger(x.class.getName());

    @Nullable
    public String a(SSLSocket sSLSocket) {
        return null;
    }

    public void a(SSLSocket sSLSocket, @Nullable String str, List<y> list) {
    }

    public void a(SSLSocketFactory sSLSocketFactory) {
    }

    public void b(SSLSocket sSLSocket) {
    }

    public boolean b(String str) {
        return true;
    }

    public String d() {
        return "OkHttp";
    }

    public static f c() {
        return f7659a;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public void a(int i, String str, @Nullable Throwable th) {
        f7660b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (f7660b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public static List<String> a(List<y> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            y yVar = list.get(i);
            if (yVar != y.HTTP_1_0) {
                arrayList.add(yVar.toString());
            }
        }
        return arrayList;
    }

    public okhttp3.internal.i.c a(X509TrustManager x509TrustManager) {
        return new okhttp3.internal.i.a(b(x509TrustManager));
    }

    public static boolean e() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    private static f a() {
        b a2;
        f a3 = a.a();
        if (a3 != null) {
            return a3;
        }
        if (!e() || (a2 = b.a()) == null) {
            c a4 = c.a();
            if (a4 != null) {
                return a4;
            }
            f a5 = d.a();
            return a5 != null ? a5 : new f();
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b(List<y> list) {
        c.c cVar = new c.c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            y yVar = list.get(i);
            if (yVar != y.HTTP_1_0) {
                cVar.i(yVar.toString().length());
                cVar.b(yVar.toString());
            }
        }
        return cVar.t();
    }

    public SSLContext b() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No TLS provider", e2);
        }
    }

    public okhttp3.internal.i.e b(X509TrustManager x509TrustManager) {
        return new okhttp3.internal.i.b(x509TrustManager.getAcceptedIssuers());
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
