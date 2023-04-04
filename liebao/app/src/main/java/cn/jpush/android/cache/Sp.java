package cn.jpush.android.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class Sp {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, SharedPreferences> f4305a = new ConcurrentHashMap();

    private static SharedPreferences a(Context context, String str) {
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SharedPreferences sharedPreferences = f4305a.get(str);
        if (sharedPreferences != null || (appContext = JPushConstants.getAppContext(context)) == null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = appContext.getSharedPreferences(str, 0);
        f4305a.put(str, sharedPreferences2);
        b(appContext, str);
        return sharedPreferences2;
    }

    private static <T> T a(SharedPreferences sharedPreferences, String str, T t) {
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            try {
                if (t instanceof Boolean) {
                    return (T) Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()));
                }
                if (t instanceof String) {
                    return (T) sharedPreferences.getString(str, (String) t);
                }
                if (t instanceof Integer) {
                    return (T) Integer.valueOf(sharedPreferences.getInt(str, ((Integer) t).intValue()));
                }
                if (t instanceof Long) {
                    return (T) Long.valueOf(sharedPreferences.getLong(str, ((Long) t).longValue()));
                }
                if (t instanceof Float) {
                    return (T) Float.valueOf(sharedPreferences.getFloat(str, ((Float) t).floatValue()));
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static <T> void a(SharedPreferences.Editor editor, String str, T t) {
        if (editor != null) {
            if (t == null) {
                editor.remove(str);
            } else if (t instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) t).booleanValue());
            } else if (t instanceof String) {
                editor.putString(str, (String) t);
            } else if (t instanceof Integer) {
                editor.putInt(str, ((Integer) t).intValue());
            } else if (t instanceof Long) {
                editor.putLong(str, ((Long) t).longValue());
            } else if (t instanceof Float) {
                editor.putFloat(str, ((Float) t).floatValue());
            }
        }
    }

    private static void b(Context context, String str) {
    }

    public static void clear(Context context, String str) {
        SharedPreferences a2 = a(context, str);
        if (a2 != null) {
            a2.edit().clear().apply();
        }
    }

    public static <T> T get(Context context, Key<T> key) {
        T t = (T) getWithNull(context, key);
        return t != null ? t : key.f4303c;
    }

    public static <T> T getWithNull(Context context, Key<T> key) {
        T t = (T) a(a(context, key.f4301a), key.f4302b, key.f4303c);
        if (t == null && key.f4304d) {
            t = (T) a(reload(context, key.f4301a), key.f4302b, key.f4303c);
        }
        if (t != null) {
            key.set(t);
            return t;
        }
        return null;
    }

    public static void read(Context context, Key<?>... keyArr) {
        if (keyArr == null || keyArr.length <= 0) {
            return;
        }
        for (Key<?> key : keyArr) {
            get(context, key);
        }
    }

    public static SharedPreferences reload(Context context, String str) {
        Context appContext = JPushConstants.getAppContext(context);
        if (appContext != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                appContext.getSharedPreferences(str, 4);
            }
            return appContext.getSharedPreferences(str, 0);
        }
        return null;
    }

    public static void set(Context context, Key<?>... keyArr) {
        if (keyArr == null || keyArr.length <= 0) {
            return;
        }
        SharedPreferences a2 = a(context, keyArr[0].f4301a);
        if (a2 != null) {
            SharedPreferences.Editor edit = a2.edit();
            for (Key<?> key : keyArr) {
                a(edit, key.f4302b, key.f4303c);
            }
            edit.commit();
        }
    }
}
