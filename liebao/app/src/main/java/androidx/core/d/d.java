package androidx.core.d;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: TraceCompat.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static long f1504a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f1505b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f1506c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f1507d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f1508e;

    static {
        if (Build.VERSION.SDK_INT < 18 || Build.VERSION.SDK_INT >= 29) {
            return;
        }
        try {
            f1504a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            f1505b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            f1506c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            f1507d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            f1508e = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
        } catch (Exception e2) {
            Log.i("TraceCompat", "Unable to initialize via reflection.", e2);
        }
    }

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
