package org.b.b.b.a;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: IdentifierManager.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Object f7771a;

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f7772b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f7773c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f7774d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f7775e;
    private static Method f;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f7772b = cls;
            f7771a = cls.newInstance();
            f7773c = f7772b.getMethod("getUDID", Context.class);
            f7774d = f7772b.getMethod("getOAID", Context.class);
            f7775e = f7772b.getMethod("getVAID", Context.class);
            f = f7772b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }

    public static boolean a() {
        return (f7772b == null || f7771a == null) ? false : true;
    }

    public static String a(Context context) {
        return a(context, f7774d);
    }

    private static String a(Context context, Method method) {
        Object obj = f7771a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            Log.e("IdentifierManager", "invoke exception!", e2);
            return null;
        }
    }
}
