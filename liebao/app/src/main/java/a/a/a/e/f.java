package a.a.a.e;

import android.util.Log;

/* compiled from: HttpLog.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static int f367a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static String f368b = "http_model";

    public static void a(String str) {
        if (f367a <= 3) {
            Log.i(f368b, str);
        }
    }

    public static void b(String str) {
        if (f367a <= 5) {
            Log.e(f368b, str);
        }
    }
}
