package cn.jiguang.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.bb.d;
import cn.jiguang.internal.JConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, SharedPreferences> f4084a = new ConcurrentHashMap();

    public static <T> T a(Context context, a<T> aVar) {
        T t = (T) b(context, aVar);
        return t != null ? t : aVar.f4083e;
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

    private static <T> void a(Context context, a<T> aVar, a<T> aVar2) {
        T t;
        if (b(context, aVar) != null || (t = (T) b(context, aVar2)) == null) {
            return;
        }
        aVar.f4083e = t;
        a(context, aVar);
        aVar2.f4083e = null;
        a(context, aVar2);
    }

    public static void a(Context context, String str) {
        SharedPreferences b2 = b(context, str);
        if (b2 != null) {
            b2.edit().clear().apply();
        }
    }

    public static void a(Context context, a<?>... aVarArr) {
        SharedPreferences b2;
        if (aVarArr.length > 0) {
            HashMap hashMap = new HashMap();
            for (a<?> aVar : aVarArr) {
                SharedPreferences.Editor editor = (SharedPreferences.Editor) hashMap.get(aVar.f4081c);
                if (editor == null && (b2 = b(context, aVar.f4081c)) != null) {
                    editor = b2.edit();
                    hashMap.put(aVar.f4081c, editor);
                }
                String str = aVar.f4082d;
                Object obj = aVar.f4083e;
                boolean z = aVar.g;
                if (editor != null) {
                    if (obj == null) {
                        editor.remove(str);
                    } else if (obj instanceof Boolean) {
                        editor.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof String) {
                        if (z) {
                            String str2 = (String) obj;
                            if (str2.length() > 0) {
                                obj = d.a(str2);
                            }
                        }
                        editor.putString(str, (String) obj);
                    } else if (obj instanceof Integer) {
                        editor.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Long) {
                        editor.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof Float) {
                        editor.putFloat(str, ((Float) obj).floatValue());
                    }
                }
            }
            for (SharedPreferences.Editor editor2 : hashMap.values()) {
                editor2.commit();
            }
        }
    }

    private static SharedPreferences b(Context context, String str) {
        Context appContext;
        a C;
        a C2;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SharedPreferences sharedPreferences = f4084a.get(str);
        if (sharedPreferences == null && (appContext = JConstants.getAppContext(context)) != null) {
            sharedPreferences = appContext.getSharedPreferences(str, 0);
            f4084a.put(str, sharedPreferences);
            String str3 = (String) a(appContext, a.v());
            if (TextUtils.isEmpty(str3) || str3.startsWith("1.")) {
                if (str.equals(a.f4079a)) {
                    a<String> i = a.i();
                    a<String> i2 = a.i();
                    i2.f4081c = "cn.jpush.android.user.profile";
                    a(appContext, i, i2);
                    a<Long> j = a.j();
                    a<Long> j2 = a.j();
                    j2.f4081c = "cn.jpush.android.user.profile";
                    a(appContext, j, j2);
                    C = a.k();
                    C2 = a.k();
                    C2.f4081c = "cn.jpush.android.user.profile";
                } else if (str.equals("cn.jiguang.sdk.user.set.profile")) {
                    a<String> l = a.l();
                    a<String> l2 = a.l();
                    l2.f4081c = "cn.jpush.preferences.v2";
                    a(appContext, l, l2);
                    C = a.m();
                    C2 = a.m();
                    C2.f4083e = "cn.jpush.android.user.profile";
                } else {
                    if (str.equals("cn.jiguang.sdk.user.profile")) {
                        a<Long> c2 = a.c();
                        a<Long> c3 = a.c();
                        c3.f4081c = "cn.jpush.android.user.profile";
                        c3.f4082d = "device_uid";
                        a(appContext, c2, c3);
                        a<String> d2 = a.d();
                        a<String> d3 = a.d();
                        d3.f4081c = "cn.jpush.android.user.profile";
                        d3.f4082d = "device_registration_id";
                        a(appContext, d2, d3);
                        C = a.e();
                        C2 = a.e();
                        C2.f4081c = "cn.jpush.android.user.profile";
                        str2 = "device_password";
                    } else if (str.equals("cn.jiguang.sdk.address")) {
                        a<String> O = a.O();
                        a<String> O2 = a.O();
                        O2.f4081c = "cn.jpush.android.user.profile";
                        O2.f4082d = "conn";
                        a(appContext, O, O2);
                        C = a.P();
                        C2 = a.P();
                        C2.f4081c = "cn.jpush.android.user.profile";
                        str2 = "srv";
                    } else if (str.equals(a.f4080b)) {
                        a<String> B = a.B();
                        a<String> B2 = a.B();
                        B2.f4082d = "device_registered_appkey";
                        a(appContext, B, B2);
                        C = a.C();
                        C2 = a.C();
                        str2 = "imei";
                    }
                    C2.f4082d = str2;
                }
                a(appContext, C, C2);
            }
        }
        return sharedPreferences;
    }

    public static <T> T b(Context context, a<T> aVar) {
        SharedPreferences sharedPreferences;
        Object a2 = a(b(context, aVar.f4081c), aVar.f4082d, aVar.f4083e);
        if (a2 == null && aVar.f) {
            String str = aVar.f4081c;
            Context appContext = JConstants.getAppContext(context);
            if (appContext != null) {
                if (Build.VERSION.SDK_INT >= 11) {
                    appContext.getSharedPreferences(str, 4);
                }
                sharedPreferences = appContext.getSharedPreferences(str, 0);
            } else {
                sharedPreferences = null;
            }
            a2 = (T) a(sharedPreferences, aVar.f4082d, aVar.f4083e);
        }
        if (a2 != null) {
            if (aVar.g && (a2 instanceof String)) {
                String str2 = a2;
                if (str2.length() > 0) {
                    a2 = (T) d.b(str2);
                }
            }
            aVar.f4083e = (T) a2;
            return (T) a2;
        }
        return null;
    }
}
