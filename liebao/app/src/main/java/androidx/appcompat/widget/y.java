package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.b.f;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* compiled from: AppCompatTextHelper.java */
/* loaded from: classes.dex */
class y {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f1141a;

    /* renamed from: b  reason: collision with root package name */
    private au f1142b;

    /* renamed from: c  reason: collision with root package name */
    private au f1143c;

    /* renamed from: d  reason: collision with root package name */
    private au f1144d;

    /* renamed from: e  reason: collision with root package name */
    private au f1145e;
    private au f;
    private au g;
    private au h;
    private final aa i;
    private int j = 0;
    private int k = -1;
    private Typeface l;
    private boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TextView textView) {
        this.f1141a = textView;
        this.i = new aa(textView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        String str;
        boolean z;
        boolean z2;
        ColorStateList colorStateList2;
        String str2;
        ColorStateList colorStateList3;
        boolean z3;
        int i2;
        Context context = this.f1141a.getContext();
        k b2 = k.b();
        aw a2 = aw.a(context, attributeSet, R.styleable.AppCompatTextHelper, i, 0);
        TextView textView = this.f1141a;
        androidx.core.h.w.a(textView, textView.getContext(), R.styleable.AppCompatTextHelper, attributeSet, a2.a(), i, 0);
        int g = a2.g(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (a2.g(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f1142b = a(context, b2, a2.g(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a2.g(R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.f1143c = a(context, b2, a2.g(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a2.g(R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.f1144d = a(context, b2, a2.g(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a2.g(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.f1145e = a(context, b2, a2.g(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (a2.g(R.styleable.AppCompatTextHelper_android_drawableStart)) {
                this.f = a(context, b2, a2.g(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (a2.g(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
                this.g = a(context, b2, a2.g(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        a2.b();
        boolean z4 = this.f1141a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (g != -1) {
            aw a3 = aw.a(context, g, R.styleable.TextAppearance);
            if (z4 || !a3.g(R.styleable.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z = a3.a(R.styleable.TextAppearance_textAllCaps, false);
                z2 = true;
            }
            a(context, a3);
            if (Build.VERSION.SDK_INT < 23) {
                colorStateList3 = a3.g(R.styleable.TextAppearance_android_textColor) ? a3.e(R.styleable.TextAppearance_android_textColor) : null;
                colorStateList = a3.g(R.styleable.TextAppearance_android_textColorHint) ? a3.e(R.styleable.TextAppearance_android_textColorHint) : null;
                colorStateList2 = a3.g(R.styleable.TextAppearance_android_textColorLink) ? a3.e(R.styleable.TextAppearance_android_textColorLink) : null;
            } else {
                colorStateList = null;
                colorStateList2 = null;
                colorStateList3 = null;
            }
            str2 = a3.g(R.styleable.TextAppearance_textLocale) ? a3.d(R.styleable.TextAppearance_textLocale) : null;
            str = (Build.VERSION.SDK_INT < 26 || !a3.g(R.styleable.TextAppearance_fontVariationSettings)) ? null : a3.d(R.styleable.TextAppearance_fontVariationSettings);
            a3.b();
        } else {
            colorStateList = null;
            str = null;
            z = false;
            z2 = false;
            colorStateList2 = null;
            str2 = null;
            colorStateList3 = null;
        }
        aw a4 = aw.a(context, attributeSet, R.styleable.TextAppearance, i, 0);
        if (z4 || !a4.g(R.styleable.TextAppearance_textAllCaps)) {
            z3 = z2;
        } else {
            z = a4.a(R.styleable.TextAppearance_textAllCaps, false);
            z3 = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a4.g(R.styleable.TextAppearance_android_textColor)) {
                colorStateList3 = a4.e(R.styleable.TextAppearance_android_textColor);
            }
            if (a4.g(R.styleable.TextAppearance_android_textColorHint)) {
                colorStateList = a4.e(R.styleable.TextAppearance_android_textColorHint);
            }
            if (a4.g(R.styleable.TextAppearance_android_textColorLink)) {
                colorStateList2 = a4.e(R.styleable.TextAppearance_android_textColorLink);
            }
        }
        if (a4.g(R.styleable.TextAppearance_textLocale)) {
            str2 = a4.d(R.styleable.TextAppearance_textLocale);
        }
        if (Build.VERSION.SDK_INT >= 26 && a4.g(R.styleable.TextAppearance_fontVariationSettings)) {
            str = a4.d(R.styleable.TextAppearance_fontVariationSettings);
        }
        if (Build.VERSION.SDK_INT >= 28 && a4.g(R.styleable.TextAppearance_android_textSize) && a4.e(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f1141a.setTextSize(0, 0.0f);
        }
        a(context, a4);
        a4.b();
        if (colorStateList3 != null) {
            this.f1141a.setTextColor(colorStateList3);
        }
        if (colorStateList != null) {
            this.f1141a.setHintTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.f1141a.setLinkTextColor(colorStateList2);
        }
        if (!z4 && z3) {
            a(z);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                this.f1141a.setTypeface(typeface, this.j);
            } else {
                this.f1141a.setTypeface(typeface);
            }
        }
        if (str != null) {
            this.f1141a.setFontVariationSettings(str);
        }
        if (str2 != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f1141a.setTextLocales(LocaleList.forLanguageTags(str2));
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.f1141a.setTextLocale(Locale.forLanguageTag(str2.substring(0, str2.indexOf(44))));
            }
        }
        this.i.a(attributeSet, i);
        if (androidx.core.widget.b.f1776d && this.i.a() != 0) {
            int[] e2 = this.i.e();
            if (e2.length > 0) {
                if (this.f1141a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f1141a.setAutoSizeTextTypeUniformWithConfiguration(this.i.c(), this.i.d(), this.i.b(), 0);
                } else {
                    this.f1141a.setAutoSizeTextTypeUniformWithPresetSizes(e2, 0);
                }
            }
        }
        aw a5 = aw.a(context, attributeSet, R.styleable.AppCompatTextView);
        int g2 = a5.g(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        Drawable a6 = g2 != -1 ? b2.a(context, g2) : null;
        int g3 = a5.g(R.styleable.AppCompatTextView_drawableTopCompat, -1);
        Drawable a7 = g3 != -1 ? b2.a(context, g3) : null;
        int g4 = a5.g(R.styleable.AppCompatTextView_drawableRightCompat, -1);
        Drawable a8 = g4 != -1 ? b2.a(context, g4) : null;
        int g5 = a5.g(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        Drawable a9 = g5 != -1 ? b2.a(context, g5) : null;
        int g6 = a5.g(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        Drawable a10 = g6 != -1 ? b2.a(context, g6) : null;
        int g7 = a5.g(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        a(a6, a7, a8, a9, a10, g7 != -1 ? b2.a(context, g7) : null);
        if (a5.g(R.styleable.AppCompatTextView_drawableTint)) {
            androidx.core.widget.i.a(this.f1141a, a5.e(R.styleable.AppCompatTextView_drawableTint));
        }
        if (a5.g(R.styleable.AppCompatTextView_drawableTintMode)) {
            i2 = -1;
            androidx.core.widget.i.a(this.f1141a, ae.a(a5.a(R.styleable.AppCompatTextView_drawableTintMode, -1), null));
        } else {
            i2 = -1;
        }
        int e3 = a5.e(R.styleable.AppCompatTextView_firstBaselineToTopHeight, i2);
        int e4 = a5.e(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, i2);
        int e5 = a5.e(R.styleable.AppCompatTextView_lineHeight, i2);
        a5.b();
        if (e3 != i2) {
            androidx.core.widget.i.b(this.f1141a, e3);
        }
        if (e4 != i2) {
            androidx.core.widget.i.c(this.f1141a, e4);
        }
        if (e5 != i2) {
            androidx.core.widget.i.d(this.f1141a, e5);
        }
    }

    private void a(Context context, aw awVar) {
        int i;
        String d2;
        this.j = awVar.a(R.styleable.TextAppearance_android_textStyle, this.j);
        if (Build.VERSION.SDK_INT >= 28) {
            int a2 = awVar.a(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.k = a2;
            if (a2 != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        if (awVar.g(R.styleable.TextAppearance_android_fontFamily) || awVar.g(R.styleable.TextAppearance_fontFamily)) {
            this.l = null;
            if (awVar.g(R.styleable.TextAppearance_fontFamily)) {
                i = R.styleable.TextAppearance_fontFamily;
            } else {
                i = R.styleable.TextAppearance_android_fontFamily;
            }
            final int i2 = this.k;
            final int i3 = this.j;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.f1141a);
                try {
                    Typeface a3 = awVar.a(i, this.j, new f.a() { // from class: androidx.appcompat.widget.y.1
                        @Override // androidx.core.content.b.f.a
                        public void onFontRetrievalFailed(int i4) {
                        }

                        @Override // androidx.core.content.b.f.a
                        public void onFontRetrieved(Typeface typeface) {
                            int i4;
                            if (Build.VERSION.SDK_INT >= 28 && (i4 = i2) != -1) {
                                typeface = Typeface.create(typeface, i4, (i3 & 2) != 0);
                            }
                            y.this.a(weakReference, typeface);
                        }
                    });
                    if (a3 != null) {
                        if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
                            this.l = Typeface.create(Typeface.create(a3, 0), this.k, (this.j & 2) != 0);
                        } else {
                            this.l = a3;
                        }
                    }
                    this.m = this.l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.l != null || (d2 = awVar.d(i)) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
                this.l = Typeface.create(Typeface.create(d2, 0), this.k, (this.j & 2) != 0);
            } else {
                this.l = Typeface.create(d2, this.j);
            }
        } else if (awVar.g(R.styleable.TextAppearance_android_typeface)) {
            this.m = false;
            int a4 = awVar.a(R.styleable.TextAppearance_android_typeface, 1);
            if (a4 == 1) {
                this.l = Typeface.SANS_SERIF;
            } else if (a4 == 2) {
                this.l = Typeface.SERIF;
            } else if (a4 != 3) {
            } else {
                this.l = Typeface.MONOSPACE;
            }
        }
    }

    void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, int i) {
        String d2;
        ColorStateList e2;
        aw a2 = aw.a(context, i, R.styleable.TextAppearance);
        if (a2.g(R.styleable.TextAppearance_textAllCaps)) {
            a(a2.a(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a2.g(R.styleable.TextAppearance_android_textColor) && (e2 = a2.e(R.styleable.TextAppearance_android_textColor)) != null) {
            this.f1141a.setTextColor(e2);
        }
        if (a2.g(R.styleable.TextAppearance_android_textSize) && a2.e(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f1141a.setTextSize(0, 0.0f);
        }
        a(context, a2);
        if (Build.VERSION.SDK_INT >= 26 && a2.g(R.styleable.TextAppearance_fontVariationSettings) && (d2 = a2.d(R.styleable.TextAppearance_fontVariationSettings)) != null) {
            this.f1141a.setFontVariationSettings(d2);
        }
        a2.b();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.f1141a.setTypeface(typeface, this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f1141a.setAllCaps(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f1142b != null || this.f1143c != null || this.f1144d != null || this.f1145e != null) {
            Drawable[] compoundDrawables = this.f1141a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1142b);
            a(compoundDrawables[1], this.f1143c);
            a(compoundDrawables[2], this.f1144d);
            a(compoundDrawables[3], this.f1145e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f == null && this.g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f1141a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    private void a(Drawable drawable, au auVar) {
        if (drawable == null || auVar == null) {
            return;
        }
        k.a(drawable, auVar, this.f1141a.getDrawableState());
    }

    private static au a(Context context, k kVar, int i) {
        ColorStateList b2 = kVar.b(context, i);
        if (b2 != null) {
            au auVar = new au();
            auVar.f1016d = true;
            auVar.f1013a = b2;
            return auVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, int i, int i2, int i3, int i4) {
        if (androidx.core.widget.b.f1776d) {
            return;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, float f) {
        if (androidx.core.widget.b.f1776d || d()) {
            return;
        }
        b(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.i.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.i.g();
    }

    private void b(int i, float f) {
        this.i.a(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.i.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, int i4) {
        this.i.a(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int[] iArr, int i) {
        this.i.a(iArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.i.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.i.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.i.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.i.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] i() {
        return this.i.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        au auVar = this.h;
        if (auVar != null) {
            return auVar.f1013a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new au();
        }
        this.h.f1013a = colorStateList;
        this.h.f1016d = colorStateList != null;
        l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        au auVar = this.h;
        if (auVar != null) {
            return auVar.f1014b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new au();
        }
        this.h.f1014b = mode;
        this.h.f1015c = mode != null;
        l();
    }

    private void l() {
        au auVar = this.h;
        this.f1142b = auVar;
        this.f1143c = auVar;
        this.f1144d = auVar;
        this.f1145e = auVar;
        this.f = auVar;
        this.g = auVar;
    }

    private void a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f1141a.getCompoundDrawablesRelative();
            TextView textView = this.f1141a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
        } else {
            if (Build.VERSION.SDK_INT >= 17) {
                Drawable[] compoundDrawablesRelative2 = this.f1141a.getCompoundDrawablesRelative();
                if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                    TextView textView2 = this.f1141a;
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative2[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.f1141a.getCompoundDrawables();
            TextView textView3 = this.f1141a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }
}
