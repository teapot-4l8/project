package okhttp3.internal.g;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.y;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JdkWithJettyBootPlatform.java */
/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Method f7648a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f7649b;

    /* renamed from: c  reason: collision with root package name */
    private final Method f7650c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<?> f7651d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f7652e;

    d(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f7648a = method;
        this.f7649b = method2;
        this.f7650c = method3;
        this.f7651d = cls;
        this.f7652e = cls2;
    }

    @Override // okhttp3.internal.g.f
    public void a(SSLSocket sSLSocket, String str, List<y> list) {
        try {
            this.f7648a.invoke(null, sSLSocket, Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{this.f7651d, this.f7652e}, new a(a(list))));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.internal.c.a("unable to set alpn", (Exception) e2);
        }
    }

    @Override // okhttp3.internal.g.f
    public void b(SSLSocket sSLSocket) {
        try {
            this.f7650c.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.internal.c.a("unable to remove alpn", (Exception) e2);
        }
    }

    @Override // okhttp3.internal.g.f
    @Nullable
    public String a(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f7649b.invoke(null, sSLSocket));
            if (!aVar.f7653a && aVar.f7654b == null) {
                f.c().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (aVar.f7653a) {
                return null;
            } else {
                return aVar.f7654b;
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.internal.c.a("unable to get selected protocol", (Exception) e2);
        }
    }

    public static f a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            return new d(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    /* compiled from: JdkWithJettyBootPlatform.java */
    /* loaded from: classes2.dex */
    private static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        boolean f7653a;

        /* renamed from: b  reason: collision with root package name */
        String f7654b;

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f7655c;

        a(List<String> list) {
            this.f7655c = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = okhttp3.internal.c.f7465b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f7653a = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f7655c;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f7655c.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.f7654b = str;
                            return str;
                        }
                    }
                    String str2 = this.f7655c.get(0);
                    this.f7654b = str2;
                    return str2;
                } else if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                    this.f7654b = (String) objArr[0];
                    return null;
                } else {
                    return method.invoke(this, objArr);
                }
            }
        }
    }
}
