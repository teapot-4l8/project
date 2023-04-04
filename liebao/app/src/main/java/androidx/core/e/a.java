package androidx.core.e;

import android.util.Base64;
import androidx.core.g.f;
import java.util.List;

/* compiled from: FontRequest.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f1509a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1510b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1511c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f1512d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1513e = 0;
    private final String f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f1509a = (String) f.a(str);
        this.f1510b = (String) f.a(str2);
        this.f1511c = (String) f.a(str3);
        this.f1512d = (List) f.a(list);
        this.f = this.f1509a + "-" + this.f1510b + "-" + this.f1511c;
    }

    public String a() {
        return this.f1509a;
    }

    public String b() {
        return this.f1510b;
    }

    public String c() {
        return this.f1511c;
    }

    public List<List<byte[]>> d() {
        return this.f1512d;
    }

    public int e() {
        return this.f1513e;
    }

    public String f() {
        return this.f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f1509a + ", mProviderPackage: " + this.f1510b + ", mQuery: " + this.f1511c + ", mCertificates:");
        for (int i = 0; i < this.f1512d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f1512d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f1513e);
        return sb.toString();
    }
}
