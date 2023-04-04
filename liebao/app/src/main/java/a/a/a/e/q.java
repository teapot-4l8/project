package a.a.a.e;

import android.text.TextUtils;

/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public final class q {
    public static <T> T a(T t) {
        return (T) a(t, "Argument must not be null");
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str);
    }
}
