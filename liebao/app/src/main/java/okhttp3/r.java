package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: Handshake.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    private final af f7704a;

    /* renamed from: b  reason: collision with root package name */
    private final h f7705b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Certificate> f7706c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Certificate> f7707d;

    private r(af afVar, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.f7704a = afVar;
        this.f7705b = hVar;
        this.f7706c = list;
        this.f7707d = list2;
    }

    public static r a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        h a2 = h.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        af a3 = af.a(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        if (certificateArr != null) {
            emptyList = okhttp3.internal.c.a(certificateArr);
        } else {
            emptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            emptyList2 = okhttp3.internal.c.a(localCertificates);
        } else {
            emptyList2 = Collections.emptyList();
        }
        return new r(a3, a2, emptyList, emptyList2);
    }

    public static r a(af afVar, h hVar, List<Certificate> list, List<Certificate> list2) {
        if (afVar != null) {
            if (hVar == null) {
                throw new NullPointerException("cipherSuite == null");
            }
            return new r(afVar, hVar, okhttp3.internal.c.a(list), okhttp3.internal.c.a(list2));
        }
        throw new NullPointerException("tlsVersion == null");
    }

    public af a() {
        return this.f7704a;
    }

    public h b() {
        return this.f7705b;
    }

    public List<Certificate> c() {
        return this.f7706c;
    }

    public List<Certificate> d() {
        return this.f7707d;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof r) {
            r rVar = (r) obj;
            return this.f7704a.equals(rVar.f7704a) && this.f7705b.equals(rVar.f7705b) && this.f7706c.equals(rVar.f7706c) && this.f7707d.equals(rVar.f7707d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f7704a.hashCode()) * 31) + this.f7705b.hashCode()) * 31) + this.f7706c.hashCode()) * 31) + this.f7707d.hashCode();
    }
}
