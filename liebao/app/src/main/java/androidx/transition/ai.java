package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewGroupUtilsApi14.java */
/* loaded from: classes.dex */
class ai {

    /* renamed from: a  reason: collision with root package name */
    private static LayoutTransition f2517a;

    /* renamed from: b  reason: collision with root package name */
    private static Field f2518b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2519c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f2520d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f2521e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(ViewGroup viewGroup, boolean z) {
        LayoutTransition layoutTransition;
        boolean z2 = false;
        if (f2517a == null) {
            LayoutTransition layoutTransition2 = new LayoutTransition() { // from class: androidx.transition.ai.1
                @Override // android.animation.LayoutTransition
                public boolean isChangingLayout() {
                    return true;
                }
            };
            f2517a = layoutTransition2;
            layoutTransition2.setAnimator(2, null);
            f2517a.setAnimator(0, null);
            f2517a.setAnimator(1, null);
            f2517a.setAnimator(3, null);
            f2517a.setAnimator(4, null);
        }
        if (z) {
            LayoutTransition layoutTransition3 = viewGroup.getLayoutTransition();
            if (layoutTransition3 != null) {
                if (layoutTransition3.isRunning()) {
                    a(layoutTransition3);
                }
                if (layoutTransition3 != f2517a) {
                    viewGroup.setTag(R.id.transition_layout_save, layoutTransition3);
                }
            }
            viewGroup.setLayoutTransition(f2517a);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!f2519c) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f2518b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
            }
            f2519c = true;
        }
        Field field = f2518b;
        if (field != null) {
            try {
                boolean z3 = field.getBoolean(viewGroup);
                if (z3) {
                    try {
                        f2518b.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                        z2 = z3;
                        Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
                        if (z2) {
                        }
                        layoutTransition = (LayoutTransition) viewGroup.getTag(R.id.transition_layout_save);
                        if (layoutTransition == null) {
                        }
                    }
                }
                z2 = z3;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z2) {
            viewGroup.requestLayout();
        }
        layoutTransition = (LayoutTransition) viewGroup.getTag(R.id.transition_layout_save);
        if (layoutTransition == null) {
            viewGroup.setTag(R.id.transition_layout_save, null);
            viewGroup.setLayoutTransition(layoutTransition);
        }
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!f2521e) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f2520d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f2521e = true;
        }
        Method method = f2520d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }
}
