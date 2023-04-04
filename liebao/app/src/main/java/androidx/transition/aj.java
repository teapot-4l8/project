package androidx.transition;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewGroupUtilsApi18.java */
/* loaded from: classes.dex */
class aj {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2522a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2523b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ViewGroup viewGroup, boolean z) {
        a();
        Method method = f2522a;
        if (method != null) {
            try {
                method.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e2) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e2);
            } catch (InvocationTargetException e3) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e3);
            }
        }
    }

    private static void a() {
        if (f2523b) {
            return;
        }
        try {
            Method declaredMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
            f2522a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e2);
        }
        f2523b = true;
    }
}
