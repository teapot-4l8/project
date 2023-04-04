package androidx.transition;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi22.java */
/* loaded from: classes.dex */
class aq extends ap {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2545a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2546b;

    @Override // androidx.transition.ar
    public void a(View view, int i, int i2, int i3, int i4) {
        a();
        Method method = f2545a;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    private void a() {
        if (f2546b) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("setLeftTopRightBottom", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            f2545a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e2);
        }
        f2546b = true;
    }
}
