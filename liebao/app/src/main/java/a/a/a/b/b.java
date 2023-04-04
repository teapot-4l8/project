package a.a.a.b;

import a.a.a.e.q;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.util.Map;

/* compiled from: HttpModel.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f12a;

    /* renamed from: b  reason: collision with root package name */
    private final URL f13b;

    /* renamed from: c  reason: collision with root package name */
    private final h f14c;

    /* renamed from: d  reason: collision with root package name */
    private final g f15d;

    /* renamed from: e  reason: collision with root package name */
    private final String f16e;
    private String f;
    private URL g;
    private int h;

    public b(String str, h hVar, g gVar) {
        this(str, a.f11b, hVar, gVar);
    }

    public b(String str, a aVar, h hVar, g gVar) {
        this.f13b = null;
        this.f14c = hVar;
        this.f16e = q.a(str);
        this.f12a = (a) q.a(aVar);
        this.f15d = gVar;
    }

    public g a() {
        return this.f15d;
    }

    public h b() {
        return this.f14c;
    }

    public URL c() {
        return g();
    }

    private URL g() {
        if (this.g == null) {
            this.g = new URL(h());
        }
        return this.g;
    }

    public String d() {
        return h();
    }

    private String h() {
        if (TextUtils.isEmpty(this.f)) {
            String str = this.f16e;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) q.a(this.f13b)).toString();
            }
            this.f = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f;
    }

    public Map<String, String> e() {
        return this.f12a.a();
    }

    public String f() {
        String str = this.f16e;
        return str != null ? str : ((URL) q.a(this.f13b)).toString();
    }

    public String toString() {
        return f();
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return f().equals(bVar.f()) && this.f12a.equals(bVar.f12a);
        }
        return false;
    }

    public int hashCode() {
        if (this.h == 0) {
            int hashCode = f().hashCode();
            this.h = hashCode;
            this.h = (hashCode * 2) + this.f12a.hashCode();
        }
        return this.h;
    }
}
