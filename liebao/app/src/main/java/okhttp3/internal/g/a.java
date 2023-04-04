package okhttp3.internal.g;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.y;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidPlatform.java */
/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f7634a;

    /* renamed from: b  reason: collision with root package name */
    private final e<Socket> f7635b;

    /* renamed from: c  reason: collision with root package name */
    private final e<Socket> f7636c;

    /* renamed from: d  reason: collision with root package name */
    private final e<Socket> f7637d;

    /* renamed from: e  reason: collision with root package name */
    private final e<Socket> f7638e;
    private final c f = c.a();

    a(Class<?> cls, e<Socket> eVar, e<Socket> eVar2, e<Socket> eVar3, e<Socket> eVar4) {
        this.f7634a = cls;
        this.f7635b = eVar;
        this.f7636c = eVar2;
        this.f7637d = eVar3;
        this.f7638e = eVar4;
    }

    @Override // okhttp3.internal.g.f
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e2) {
            if (!okhttp3.internal.c.a(e2)) {
                throw e2;
            }
            throw new IOException(e2);
        } catch (ClassCastException e3) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e3);
                throw iOException;
            }
            throw e3;
        } catch (SecurityException e4) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e4);
            throw iOException2;
        }
    }

    @Override // okhttp3.internal.g.f
    public void a(SSLSocket sSLSocket, String str, List<y> list) {
        if (str != null) {
            this.f7635b.b(sSLSocket, true);
            this.f7636c.b(sSLSocket, str);
        }
        e<Socket> eVar = this.f7638e;
        if (eVar == null || !eVar.a((e<Socket>) sSLSocket)) {
            return;
        }
        this.f7638e.d(sSLSocket, b(list));
    }

    @Override // okhttp3.internal.g.f
    @Nullable
    public String a(SSLSocket sSLSocket) {
        byte[] bArr;
        e<Socket> eVar = this.f7637d;
        if (eVar == null || !eVar.a((e<Socket>) sSLSocket) || (bArr = (byte[]) this.f7637d.d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, okhttp3.internal.c.f7468e);
    }

    @Override // okhttp3.internal.g.f
    public void a(int i, String str, @Nullable Throwable th) {
        int min;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    @Override // okhttp3.internal.g.f
    public Object a(String str) {
        return this.f.a(str);
    }

    @Override // okhttp3.internal.g.f
    public void a(String str, Object obj) {
        if (this.f.a(obj)) {
            return;
        }
        a(5, str, (Throwable) null);
    }

    @Override // okhttp3.internal.g.f
    public boolean b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw okhttp3.internal.c.a("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw okhttp3.internal.c.a("unable to determine cleartext support", e);
        } catch (InvocationTargetException e4) {
            e = e4;
            throw okhttp3.internal.c.a("unable to determine cleartext support", e);
        }
    }

    private boolean a(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return b(str, cls, obj);
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.b(str);
        }
    }

    private static boolean f() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // okhttp3.internal.g.f
    public okhttp3.internal.i.c a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0187a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    public static f a() {
        Class<?> cls;
        e eVar;
        e eVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            e eVar3 = new e(null, "setUseSessionTickets", Boolean.TYPE);
            e eVar4 = new e(null, "setHostname", String.class);
            if (f()) {
                e eVar5 = new e(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                eVar2 = new e(null, "setAlpnProtocols", byte[].class);
                eVar = eVar5;
            } else {
                eVar = null;
                eVar2 = null;
            }
            return new a(cls2, eVar3, eVar4, eVar, eVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    @Override // okhttp3.internal.g.f
    public okhttp3.internal.i.e b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(x509TrustManager);
        }
    }

    /* compiled from: AndroidPlatform.java */
    /* renamed from: okhttp3.internal.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0187a extends okhttp3.internal.i.c {

        /* renamed from: a  reason: collision with root package name */
        private final Object f7639a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f7640b;

        public int hashCode() {
            return 0;
        }

        C0187a(Object obj, Method method) {
            this.f7639a = obj;
            this.f7640b = method;
        }

        @Override // okhttp3.internal.i.c
        public List<Certificate> a(List<Certificate> list, String str) {
            try {
                return (List) this.f7640b.invoke(this.f7639a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e3.getMessage());
                sSLPeerUnverifiedException.initCause(e3);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0187a;
        }
    }

    /* compiled from: AndroidPlatform.java */
    /* loaded from: classes2.dex */
    static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Method f7643a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f7644b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f7645c;

        c(Method method, Method method2, Method method3) {
            this.f7643a = method;
            this.f7644b = method2;
            this.f7645c = method3;
        }

        Object a(String str) {
            Method method = this.f7643a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f7644b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean a(Object obj) {
            if (obj != null) {
                try {
                    this.f7645c.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }

        static c a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new c(method3, method2, method);
        }
    }

    /* compiled from: AndroidPlatform.java */
    /* loaded from: classes2.dex */
    static final class b implements okhttp3.internal.i.e {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f7641a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f7642b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.f7642b = method;
            this.f7641a = x509TrustManager;
        }

        @Override // okhttp3.internal.i.e
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f7642b.invoke(this.f7641a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw okhttp3.internal.c.a("unable to get issues and signature", (Exception) e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f7641a.equals(bVar.f7641a) && this.f7642b.equals(bVar.f7642b);
            }
            return false;
        }

        public int hashCode() {
            return this.f7641a.hashCode() + (this.f7642b.hashCode() * 31);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000b, code lost:
        if (android.os.Build.VERSION.SDK_INT < 22) goto L8;
     */
    @Override // okhttp3.internal.g.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SSLContext b() {
        boolean z = true;
        try {
            if (Build.VERSION.SDK_INT >= 16) {
            }
            z = false;
        } catch (NoClassDefFoundError unused) {
        }
        if (z) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No TLS provider", e2);
        }
    }
}
