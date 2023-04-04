package a.a.a.e;

import android.os.Build;
import android.os.SystemClock;

/* compiled from: LogTime.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final double f372a;

    static {
        f372a = Build.VERSION.SDK_INT >= 17 ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    public static long a() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }

    public static int a(long j) {
        double a2 = a() - j;
        double d2 = f372a;
        Double.isNaN(a2);
        return (int) (a2 * d2);
    }
}
