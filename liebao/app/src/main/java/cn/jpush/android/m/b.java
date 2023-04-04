package cn.jpush.android.m;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f4389a;

    /* renamed from: b  reason: collision with root package name */
    private static Object f4390b;

    private b() {
    }

    public static b a() {
        if (f4389a == null) {
            synchronized (b.class) {
                if (f4389a == null) {
                    f4389a = new b();
                }
            }
        }
        return f4389a;
    }

    private static Object a(Context context) {
        if (Build.VERSION.SDK_INT >= 11 && f4390b == null && context != null) {
            synchronized (b.class) {
                if (f4390b == null) {
                    boolean z = Looper.myLooper() == null;
                    if (z) {
                        Looper.prepare();
                    }
                    f4390b = a.a(context);
                    if (z && Looper.myLooper() != null) {
                        Looper.myLooper().quit();
                    }
                }
            }
        }
        return f4390b;
    }

    public void a(Context context, JSONObject jSONObject) {
        try {
            if (Build.VERSION.SDK_INT < 11) {
                Logger.d("CopyManager", "sdk below 11, won't deal");
                return;
            }
            try {
                String upperCase = Build.MODEL.toUpperCase();
                if (upperCase.startsWith("GIONEE") || upperCase.startsWith("LG")) {
                    Logger.d("CopyManager", "give up because " + Build.MODEL);
                    return;
                }
            } catch (Throwable unused) {
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            JSONArray optJSONArray = jSONObject2.optJSONArray("app");
            String string = jSONObject2.getString("board");
            if (TextUtils.isEmpty(string)) {
                Logger.w("CopyManager", "content is empty");
                return;
            }
            if (optJSONArray != null && optJSONArray.length() > 0) {
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= optJSONArray.length()) {
                        break;
                    } else if (cn.jpush.android.u.a.c(context, optJSONArray.getString(i))) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!z) {
                    Logger.d("CopyManager", "no target app");
                    return;
                }
            }
            Object a2 = a(context);
            if (a2 != null) {
                a.a(a2, a.a(string));
                Logger.d("CopyManager", "copy=" + string);
            }
        } catch (Throwable th) {
            Logger.w("CopyManager", "deal 57 e:" + th);
        }
    }
}
