package b.a.k;

import android.util.Log;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3261a = true;

    public static void a(String str, Object... objArr) {
        Log.d("OpenInstall", String.format(str, objArr));
    }

    public static void b(String str, Object... objArr) {
        Log.w("OpenInstall", String.format(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e("OpenInstall", String.format(str, objArr));
    }
}
