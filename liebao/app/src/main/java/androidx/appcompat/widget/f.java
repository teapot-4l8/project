package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;

/* compiled from: AppCompatBackgroundHelper.java */
/* loaded from: classes.dex */
class f {

    /* renamed from: a  reason: collision with root package name */
    private final View f1073a;

    /* renamed from: d  reason: collision with root package name */
    private au f1076d;

    /* renamed from: e  reason: collision with root package name */
    private au f1077e;
    private au f;

    /* renamed from: c  reason: collision with root package name */
    private int f1075c = -1;

    /* renamed from: b  reason: collision with root package name */
    private final k f1074b = k.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(View view) {
        this.f1073a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        aw a2 = aw.a(this.f1073a.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i, 0);
        View view = this.f1073a;
        androidx.core.h.w.a(view, view.getContext(), R.styleable.ViewBackgroundHelper, attributeSet, a2.a(), i, 0);
        try {
            if (a2.g(R.styleable.ViewBackgroundHelper_android_background)) {
                this.f1075c = a2.g(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList b2 = this.f1074b.b(this.f1073a.getContext(), this.f1075c);
                if (b2 != null) {
                    b(b2);
                }
            }
            if (a2.g(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                androidx.core.h.w.a(this.f1073a, a2.e(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.g(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                androidx.core.h.w.a(this.f1073a, ae.a(a2.a(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            a2.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.f1075c = i;
        k kVar = this.f1074b;
        b(kVar != null ? kVar.b(this.f1073a.getContext(), i) : null);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        this.f1075c = -1;
        b((ColorStateList) null);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.f1077e == null) {
            this.f1077e = new au();
        }
        this.f1077e.f1013a = colorStateList;
        this.f1077e.f1016d = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList a() {
        au auVar = this.f1077e;
        if (auVar != null) {
            return auVar.f1013a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.f1077e == null) {
            this.f1077e = new au();
        }
        this.f1077e.f1014b = mode;
        this.f1077e.f1015c = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode b() {
        au auVar = this.f1077e;
        if (auVar != null) {
            return auVar.f1014b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable background = this.f1073a.getBackground();
        if (background != null) {
            if (d() && b(background)) {
                return;
            }
            au auVar = this.f1077e;
            if (auVar != null) {
                k.a(background, auVar, this.f1073a.getDrawableState());
                return;
            }
            au auVar2 = this.f1076d;
            if (auVar2 != null) {
                k.a(background, auVar2, this.f1073a.getDrawableState());
            }
        }
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1076d == null) {
                this.f1076d = new au();
            }
            this.f1076d.f1013a = colorStateList;
            this.f1076d.f1016d = true;
        } else {
            this.f1076d = null;
        }
        c();
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f1076d != null : i == 21;
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new au();
        }
        au auVar = this.f;
        auVar.a();
        ColorStateList w = androidx.core.h.w.w(this.f1073a);
        if (w != null) {
            auVar.f1016d = true;
            auVar.f1013a = w;
        }
        PorterDuff.Mode x = androidx.core.h.w.x(this.f1073a);
        if (x != null) {
            auVar.f1015c = true;
            auVar.f1014b = x;
        }
        if (auVar.f1016d || auVar.f1015c) {
            k.a(drawable, auVar, this.f1073a.getDrawableState());
            return true;
        }
        return false;
    }
}
