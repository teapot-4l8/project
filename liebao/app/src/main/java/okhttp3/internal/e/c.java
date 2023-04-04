package okhttp3.internal.e;

import okhttp3.s;

/* compiled from: Header.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c.f f7520a = c.f.a(":");

    /* renamed from: b  reason: collision with root package name */
    public static final c.f f7521b = c.f.a(":status");

    /* renamed from: c  reason: collision with root package name */
    public static final c.f f7522c = c.f.a(":method");

    /* renamed from: d  reason: collision with root package name */
    public static final c.f f7523d = c.f.a(":path");

    /* renamed from: e  reason: collision with root package name */
    public static final c.f f7524e = c.f.a(":scheme");
    public static final c.f f = c.f.a(":authority");
    public final c.f g;
    public final c.f h;
    final int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Header.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(s sVar);
    }

    public c(String str, String str2) {
        this(c.f.a(str), c.f.a(str2));
    }

    public c(c.f fVar, String str) {
        this(fVar, c.f.a(str));
    }

    public c(c.f fVar, c.f fVar2) {
        this.g = fVar;
        this.h = fVar2;
        this.i = fVar.h() + 32 + fVar2.h();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.g.equals(cVar.g) && this.h.equals(cVar.h);
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return okhttp3.internal.c.a("%s: %s", this.g.a(), this.h.a());
    }
}
