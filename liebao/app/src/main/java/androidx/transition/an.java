package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    static final Property<View, Float> f2531a;

    /* renamed from: b  reason: collision with root package name */
    static final Property<View, Rect> f2532b;

    /* renamed from: c  reason: collision with root package name */
    private static final ar f2533c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f2534d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f2535e;

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            f2533c = new aq();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f2533c = new ap();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f2533c = new ao();
        } else {
            f2533c = new ar();
        }
        f2531a = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.transition.an.1
            @Override // android.util.Property
            /* renamed from: a */
            public Float get(View view) {
                return Float.valueOf(an.c(view));
            }

            @Override // android.util.Property
            /* renamed from: a */
            public void set(View view, Float f) {
                an.a(view, f.floatValue());
            }
        };
        f2532b = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.transition.an.2
            @Override // android.util.Property
            /* renamed from: a */
            public Rect get(View view) {
                return androidx.core.h.w.C(view);
            }

            @Override // android.util.Property
            /* renamed from: a */
            public void set(View view, Rect rect) {
                androidx.core.h.w.a(view, rect);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static am a(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new al(view);
        }
        return ak.d(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static av b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new au(view);
        }
        return new at(view.getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, float f) {
        f2533c.a(view, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(View view) {
        return f2533c.a(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(View view) {
        f2533c.b(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(View view) {
        f2533c.c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, int i) {
        a();
        Field field = f2534d;
        if (field != null) {
            try {
                f2534d.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, Matrix matrix) {
        f2533c.a(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(View view, Matrix matrix) {
        f2533c.b(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(View view, Matrix matrix) {
        f2533c.c(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, int i, int i2, int i3, int i4) {
        f2533c.a(view, i, i2, i3, i4);
    }

    private static void a() {
        if (f2535e) {
            return;
        }
        try {
            Field declaredField = View.class.getDeclaredField("mViewFlags");
            f2534d = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
            Log.i("ViewUtils", "fetchViewFlagsField: ");
        }
        f2535e = true;
    }
}
