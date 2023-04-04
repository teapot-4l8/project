package okhttp3.internal.g;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.y;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Jdk9Platform.java */
/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: a  reason: collision with root package name */
    final Method f7646a;

    /* renamed from: b  reason: collision with root package name */
    final Method f7647b;

    c(Method method, Method method2) {
        this.f7646a = method;
        this.f7647b = method2;
    }

    @Override // okhttp3.internal.g.f
    public void a(SSLSocket sSLSocket, String str, List<y> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a2 = a(list);
            this.f7646a.invoke(sSLParameters, a2.toArray(new String[a2.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.internal.c.a("unable to set ssl parameters", (Exception) e2);
        }
    }

    @Override // okhttp3.internal.g.f
    @Nullable
    public String a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f7647b.invoke(sSLSocket, new Object[0]);
            if (str != null) {
                if (str.equals("")) {
                    return null;
                }
                return str;
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.internal.c.a("unable to get selected protocols", (Exception) e2);
        }
    }

    public static c a() {
        try {
            return new c(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
