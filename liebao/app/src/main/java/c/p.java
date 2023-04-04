package c;

import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentPool.java */
/* loaded from: classes.dex */
public final class p {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    static o f3580a;

    /* renamed from: b  reason: collision with root package name */
    static long f3581b;

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a() {
        synchronized (p.class) {
            if (f3580a != null) {
                o oVar = f3580a;
                f3580a = oVar.f;
                oVar.f = null;
                f3581b -= 8192;
                return oVar;
            }
            return new o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(o oVar) {
        if (oVar.f != null || oVar.g != null) {
            throw new IllegalArgumentException();
        }
        if (oVar.f3578d) {
            return;
        }
        synchronized (p.class) {
            if (f3581b + 8192 > 65536) {
                return;
            }
            f3581b += 8192;
            oVar.f = f3580a;
            oVar.f3577c = 0;
            oVar.f3576b = 0;
            f3580a = oVar;
        }
    }
}
