package androidx.core.f;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompat.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Method f1565a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f1566b;

    static {
        if (Build.VERSION.SDK_INT < 21) {
            try {
                Class<?> cls = Class.forName("libcore.icu.ICU");
                if (cls != null) {
                    f1565a = cls.getMethod("getScript", String.class);
                    f1566b = cls.getMethod("addLikelySubtags", String.class);
                }
            } catch (Exception e2) {
                f1565a = null;
                f1566b = null;
                Log.w("ICUCompat", e2);
            }
        } else if (Build.VERSION.SDK_INT < 24) {
            try {
                f1566b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e3) {
                throw new IllegalStateException(e3);
            }
        }
    }

    public static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f1566b.invoke(null, locale)).getScript();
            } catch (IllegalAccessException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            } catch (InvocationTargetException e3) {
                Log.w("ICUCompat", e3);
                return locale.getScript();
            }
        }
        String b2 = b(locale);
        if (b2 != null) {
            return a(b2);
        }
        return null;
    }

    private static String a(String str) {
        try {
            if (f1565a != null) {
                return (String) f1565a.invoke(null, str);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return null;
    }

    private static String b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f1566b != null) {
                return (String) f1566b.invoke(null, locale2);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return locale2;
    }
}
