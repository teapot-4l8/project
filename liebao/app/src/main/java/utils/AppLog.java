package utils;

import com.a.a.a;
import com.a.a.d;
import kotlin.d.b.i;

/* compiled from: AppLog.kt */
/* loaded from: classes.dex */
public final class AppLog {
    public static final AppLog INSTANCE = new AppLog();
    private static boolean debug;

    private AppLog() {
    }

    public final boolean getDebug() {
        return debug;
    }

    public final void setDebug(boolean z) {
        debug = z;
    }

    public final void initLog() {
        d.a(new a.C0082a().a(Integer.MIN_VALUE).a(com.speed.speed_library.b.d.f5595a.a()).d().f(), new com.a.a.d.a());
    }

    public final void i(String str) {
        i.b(str, "message");
        if (debug) {
            d.c(str);
        }
    }

    public final void d(String str) {
        i.b(str, "message");
        if (debug) {
            d.b(str);
        }
    }

    public final void d(String str, Throwable th) {
        i.b(str, "message");
        i.b(th, "throwable");
        if (debug) {
            d.a(str, th);
        }
    }

    public final void json(String str) {
        i.b(str, "message");
        if (debug) {
            d.d(str);
        }
    }

    public final void d(String str, String str2) {
        i.b(str, "tag");
        i.b(str2, "message");
        if (debug) {
            d.a(str).b(str2);
        }
    }
}
