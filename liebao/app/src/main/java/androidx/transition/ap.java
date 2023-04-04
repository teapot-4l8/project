package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi21.java */
/* loaded from: classes.dex */
class ap extends ao {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2540a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2541b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f2542c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2543d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f2544e;
    private static boolean f;

    @Override // androidx.transition.ar
    public void a(View view, Matrix matrix) {
        a();
        Method method = f2540a;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // androidx.transition.ar
    public void b(View view, Matrix matrix) {
        b();
        Method method = f2542c;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // androidx.transition.ar
    public void c(View view, Matrix matrix) {
        c();
        Method method = f2544e;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2.getCause());
            } catch (InvocationTargetException unused) {
            }
        }
    }

    private void a() {
        if (f2541b) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
            f2540a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e2);
        }
        f2541b = true;
    }

    private void b() {
        if (f2543d) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
            f2542c = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e2);
        }
        f2543d = true;
    }

    private void c() {
        if (f) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("setAnimationMatrix", Matrix.class);
            f2544e = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi21", "Failed to retrieve setAnimationMatrix method", e2);
        }
        f = true;
    }
}
