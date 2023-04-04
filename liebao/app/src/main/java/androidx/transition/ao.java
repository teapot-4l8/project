package androidx.transition;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi19.java */
/* loaded from: classes.dex */
class ao extends ar {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2536a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2537b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f2538c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2539d;

    @Override // androidx.transition.ar
    public void b(View view) {
    }

    @Override // androidx.transition.ar
    public void c(View view) {
    }

    @Override // androidx.transition.ar
    public void a(View view, float f) {
        a();
        Method method = f2536a;
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(f));
                return;
            } catch (IllegalAccessException unused) {
                return;
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        view.setAlpha(f);
    }

    @Override // androidx.transition.ar
    public float a(View view) {
        b();
        Method method = f2538c;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return super.a(view);
    }

    private void a() {
        if (f2537b) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
            f2536a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e2);
        }
        f2537b = true;
    }

    private void b() {
        if (f2539d) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
            f2538c = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e2);
        }
        f2539d = true;
    }
}
