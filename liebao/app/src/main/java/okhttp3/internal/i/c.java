package okhttp3.internal.i;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.g.f;

/* compiled from: CertificateChainCleaner.java */
/* loaded from: classes2.dex */
public abstract class c {
    public abstract List<Certificate> a(List<Certificate> list, String str);

    public static c a(X509TrustManager x509TrustManager) {
        return f.c().a(x509TrustManager);
    }
}
