package cn.jiguang.aa;

import android.content.Context;
import android.os.Build;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {
    private static Class<?> a(Context context, String str) {
        if (str.trim().length() != 0) {
            boolean z = context != null;
            if (z && Build.VERSION.SDK_INT >= 29) {
                try {
                    return context.getClassLoader().loadClass(str);
                } catch (ClassNotFoundException unused) {
                }
            }
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e2) {
                cn.jiguang.ad.a.d("IdProvider", String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), e2.getLocalizedMessage()));
                throw new ClassNotFoundException("loadClass fail ", e2);
            }
        }
        throw new ClassNotFoundException("class is empty");
    }

    public static String a(Context context) {
        try {
            Class<?> a2 = a(context, "com.android.id.impl.IdProviderImpl");
            Object newInstance = a2.newInstance();
            a2.getMethod("getUDID", Context.class);
            Method method = a2.getMethod("getOAID", Context.class);
            Method method2 = a2.getMethod("getVAID", Context.class);
            Object invoke = a2.getMethod("getAAID", Context.class).invoke(newInstance, context);
            Object invoke2 = method2.invoke(newInstance, context);
            Object invoke3 = method.invoke(newInstance, context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("oaid", invoke3);
            jSONObject.put("vaid", invoke2);
            jSONObject.put("aaid", invoke);
            return jSONObject.toString();
        } catch (Throwable th) {
            cn.jiguang.ad.a.e("IdProvider", "getIds failed:" + th.getMessage());
            return "";
        }
    }
}
