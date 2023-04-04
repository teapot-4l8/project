package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R;

/* compiled from: ThemeUtils.java */
/* loaded from: classes.dex */
public class ar {
    private static final ThreadLocal<TypedValue> i = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    static final int[] f1004a = {-16842910};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f1005b = {16842908};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f1006c = {16843518};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f1007d = {16842919};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f1008e = {16842912};
    static final int[] f = {16842913};
    static final int[] g = {-16842919, -16842908};
    static final int[] h = new int[0];
    private static final int[] j = new int[1];

    public static int a(Context context, int i2) {
        int[] iArr = j;
        iArr[0] = i2;
        aw a2 = aw.a(context, (AttributeSet) null, iArr);
        try {
            return a2.b(0, 0);
        } finally {
            a2.b();
        }
    }

    public static ColorStateList b(Context context, int i2) {
        int[] iArr = j;
        iArr[0] = i2;
        aw a2 = aw.a(context, (AttributeSet) null, iArr);
        try {
            return a2.e(0);
        } finally {
            a2.b();
        }
    }

    public static int c(Context context, int i2) {
        ColorStateList b2 = b(context, i2);
        if (b2 != null && b2.isStateful()) {
            return b2.getColorForState(f1004a, b2.getDefaultColor());
        }
        TypedValue a2 = a();
        context.getTheme().resolveAttribute(16842803, a2, true);
        return a(context, i2, a2.getFloat());
    }

    private static TypedValue a() {
        TypedValue typedValue = i.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            i.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    static int a(Context context, int i2, float f2) {
        int a2 = a(context, i2);
        return androidx.core.graphics.a.b(a2, Math.round(Color.alpha(a2) * f2));
    }

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
