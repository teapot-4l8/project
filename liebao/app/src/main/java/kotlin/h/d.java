package kotlin.h;

import java.nio.charset.Charset;

/* compiled from: Charsets.kt */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f7190a;

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f7191b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f7192c;

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f7193d;

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f7194e;
    public static final Charset f;
    public static final d g = new d();

    static {
        Charset forName = Charset.forName("UTF-8");
        kotlin.d.b.i.a((Object) forName, "Charset.forName(\"UTF-8\")");
        f7190a = forName;
        Charset forName2 = Charset.forName("UTF-16");
        kotlin.d.b.i.a((Object) forName2, "Charset.forName(\"UTF-16\")");
        f7191b = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        kotlin.d.b.i.a((Object) forName3, "Charset.forName(\"UTF-16BE\")");
        f7192c = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        kotlin.d.b.i.a((Object) forName4, "Charset.forName(\"UTF-16LE\")");
        f7193d = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        kotlin.d.b.i.a((Object) forName5, "Charset.forName(\"US-ASCII\")");
        f7194e = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        kotlin.d.b.i.a((Object) forName6, "Charset.forName(\"ISO-8859-1\")");
        f = forName6;
    }

    private d() {
    }
}
