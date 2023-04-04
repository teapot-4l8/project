package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements j {

    /* renamed from: a  reason: collision with root package name */
    private static int f507a;

    /* renamed from: b  reason: collision with root package name */
    private static Field f508b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f509c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f510d;

    /* renamed from: e  reason: collision with root package name */
    private Activity f511e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmLeaksCleaner(Activity activity) {
        this.f511e = activity;
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, h.a aVar) {
        if (aVar != h.a.ON_DESTROY) {
            return;
        }
        if (f507a == 0) {
            a();
        }
        if (f507a == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f511e.getSystemService("input_method");
            try {
                Object obj = f508b.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f509c.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f510d.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (ClassCastException unused2) {
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }

    private static void a() {
        try {
            f507a = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f509c = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f510d = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f508b = declaredField3;
            declaredField3.setAccessible(true);
            f507a = 1;
        } catch (NoSuchFieldException unused) {
        }
    }
}
