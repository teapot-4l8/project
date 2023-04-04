package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: CertificatePinner.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f7384a = new a().a();

    /* renamed from: b  reason: collision with root package name */
    private final Set<b> f7385b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final okhttp3.internal.i.c f7386c;

    g(Set<b> set, @Nullable okhttp3.internal.i.c cVar) {
        this.f7385b = set;
        this.f7386c = cVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (okhttp3.internal.c.a(this.f7386c, gVar.f7386c) && this.f7385b.equals(gVar.f7385b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        okhttp3.internal.i.c cVar = this.f7386c;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f7385b.hashCode();
    }

    public void a(String str, List<Certificate> list) {
        List<b> a2 = a(str);
        if (a2.isEmpty()) {
            return;
        }
        okhttp3.internal.i.c cVar = this.f7386c;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = a2.size();
            c.f fVar = null;
            c.f fVar2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                b bVar = a2.get(i2);
                if (bVar.f7390c.equals("sha256/")) {
                    if (fVar == null) {
                        fVar = b(x509Certificate);
                    }
                    if (bVar.f7391d.equals(fVar)) {
                        return;
                    }
                } else if (bVar.f7390c.equals("sha1/")) {
                    if (fVar2 == null) {
                        fVar2 = a(x509Certificate);
                    }
                    if (bVar.f7391d.equals(fVar2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + bVar.f7390c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = a2.size();
        for (int i4 = 0; i4 < size4; i4++) {
            sb.append("\n    ");
            sb.append(a2.get(i4));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f7385b) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g a(@Nullable okhttp3.internal.i.c cVar) {
        return okhttp3.internal.c.a(this.f7386c, cVar) ? this : new g(this.f7385b, cVar);
    }

    public static String a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + b((X509Certificate) certificate).b();
    }

    static c.f a(X509Certificate x509Certificate) {
        return c.f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    static c.f b(X509Certificate x509Certificate) {
        return c.f.a(x509Certificate.getPublicKey().getEncoded()).e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CertificatePinner.java */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f7388a;

        /* renamed from: b  reason: collision with root package name */
        final String f7389b;

        /* renamed from: c  reason: collision with root package name */
        final String f7390c;

        /* renamed from: d  reason: collision with root package name */
        final c.f f7391d;

        boolean a(String str) {
            if (this.f7388a.startsWith("*.")) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.f7389b.length()) {
                    String str2 = this.f7389b;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.f7389b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f7388a.equals(bVar.f7388a) && this.f7390c.equals(bVar.f7390c) && this.f7391d.equals(bVar.f7391d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f7388a.hashCode()) * 31) + this.f7390c.hashCode()) * 31) + this.f7391d.hashCode();
        }

        public String toString() {
            return this.f7390c + this.f7391d.b();
        }
    }

    /* compiled from: CertificatePinner.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<b> f7387a = new ArrayList();

        public g a() {
            return new g(new LinkedHashSet(this.f7387a), null);
        }
    }
}
