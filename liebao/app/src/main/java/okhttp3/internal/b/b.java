package okhttp3.internal.b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.k;

/* compiled from: ConnectionSpecSelector.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<k> f7439a;

    /* renamed from: b  reason: collision with root package name */
    private int f7440b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7441c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7442d;

    public b(List<k> list) {
        this.f7439a = list;
    }

    public k a(SSLSocket sSLSocket) {
        k kVar;
        int i = this.f7440b;
        int size = this.f7439a.size();
        while (true) {
            if (i >= size) {
                kVar = null;
                break;
            }
            kVar = this.f7439a.get(i);
            if (kVar.a(sSLSocket)) {
                this.f7440b = i + 1;
                break;
            }
            i++;
        }
        if (kVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f7442d + ", modes=" + this.f7439a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.f7441c = b(sSLSocket);
        okhttp3.internal.a.f7398a.a(kVar, sSLSocket, this.f7442d);
        return kVar;
    }

    public boolean a(IOException iOException) {
        this.f7442d = true;
        if (!this.f7441c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.f7440b; i < this.f7439a.size(); i++) {
            if (this.f7439a.get(i).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
