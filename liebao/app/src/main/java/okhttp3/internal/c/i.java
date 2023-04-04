package okhttp3.internal.c;

import java.net.Proxy;
import okhttp3.aa;
import okhttp3.t;

/* compiled from: RequestLine.java */
/* loaded from: classes2.dex */
public final class i {
    public static String a(aa aaVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(aaVar.b());
        sb.append(' ');
        if (b(aaVar, type)) {
            sb.append(aaVar.a());
        } else {
            sb.append(a(aaVar.a()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(aa aaVar, Proxy.Type type) {
        return !aaVar.g() && type == Proxy.Type.HTTP;
    }

    public static String a(t tVar) {
        String h = tVar.h();
        String k = tVar.k();
        if (k != null) {
            return h + '?' + k;
        }
        return h;
    }
}
