package androidx.appcompat.a.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.am;
import androidx.core.content.b;
import java.util.WeakHashMap;

/* compiled from: AppCompatResources.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f530a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0018a>> f531b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f532c = new Object();

    public static ColorStateList a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList d2 = d(context, i);
        if (d2 != null) {
            return d2;
        }
        ColorStateList c2 = c(context, i);
        if (c2 != null) {
            a(context, i, c2);
            return c2;
        }
        return b.b(context, i);
    }

    public static Drawable b(Context context, int i) {
        return am.a().a(context, i);
    }

    private static ColorStateList c(Context context, int i) {
        if (e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return androidx.core.content.b.a.a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static ColorStateList d(Context context, int i) {
        C0018a c0018a;
        synchronized (f532c) {
            SparseArray<C0018a> sparseArray = f531b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0018a = sparseArray.get(i)) != null) {
                if (c0018a.f534b.equals(context.getResources().getConfiguration())) {
                    return c0018a.f533a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    private static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f532c) {
            SparseArray<C0018a> sparseArray = f531b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f531b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0018a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static boolean e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue a2 = a();
        resources.getValue(i, a2, true);
        return a2.type >= 28 && a2.type <= 31;
    }

    private static TypedValue a() {
        TypedValue typedValue = f530a.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            f530a.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatResources.java */
    /* renamed from: androidx.appcompat.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0018a {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f533a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f534b;

        C0018a(ColorStateList colorStateList, Configuration configuration) {
            this.f533a = colorStateList;
            this.f534b = configuration;
        }
    }
}
