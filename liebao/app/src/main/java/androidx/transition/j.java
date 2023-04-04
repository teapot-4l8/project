package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: GhostViewApi21.java */
/* loaded from: classes.dex */
class j implements k {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f2640a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2641b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f2642c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2643d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f2644e;
    private static boolean f;
    private final View g;

    @Override // androidx.transition.k
    public void a(ViewGroup viewGroup, View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k a(View view, ViewGroup viewGroup, Matrix matrix) {
        b();
        Method method = f2642c;
        if (method != null) {
            try {
                return new j((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        c();
        Method method = f2644e;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    private j(View view) {
        this.g = view;
    }

    @Override // androidx.transition.k
    public void setVisibility(int i) {
        this.g.setVisibility(i);
    }

    private static void a() {
        if (f2641b) {
            return;
        }
        try {
            f2640a = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e2);
        }
        f2641b = true;
    }

    private static void b() {
        if (f2643d) {
            return;
        }
        try {
            a();
            Method declaredMethod = f2640a.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            f2642c = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e2);
        }
        f2643d = true;
    }

    private static void c() {
        if (f) {
            return;
        }
        try {
            a();
            Method declaredMethod = f2640a.getDeclaredMethod("removeGhost", View.class);
            f2644e = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e2);
        }
        f = true;
    }
}
