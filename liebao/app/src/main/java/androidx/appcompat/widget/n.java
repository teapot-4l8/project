package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R;

/* compiled from: AppCompatImageHelper.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f1093a;

    /* renamed from: b  reason: collision with root package name */
    private au f1094b;

    /* renamed from: c  reason: collision with root package name */
    private au f1095c;

    /* renamed from: d  reason: collision with root package name */
    private au f1096d;

    public n(ImageView imageView) {
        this.f1093a = imageView;
    }

    public void a(AttributeSet attributeSet, int i) {
        int g;
        aw a2 = aw.a(this.f1093a.getContext(), attributeSet, R.styleable.AppCompatImageView, i, 0);
        ImageView imageView = this.f1093a;
        androidx.core.h.w.a(imageView, imageView.getContext(), R.styleable.AppCompatImageView, attributeSet, a2.a(), i, 0);
        try {
            Drawable drawable = this.f1093a.getDrawable();
            if (drawable == null && (g = a2.g(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = androidx.appcompat.a.a.a.b(this.f1093a.getContext(), g)) != null) {
                this.f1093a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                ae.a(drawable);
            }
            if (a2.g(R.styleable.AppCompatImageView_tint)) {
                androidx.core.widget.e.a(this.f1093a, a2.e(R.styleable.AppCompatImageView_tint));
            }
            if (a2.g(R.styleable.AppCompatImageView_tintMode)) {
                androidx.core.widget.e.a(this.f1093a, ae.a(a2.a(R.styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            a2.b();
        }
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b2 = androidx.appcompat.a.a.a.b(this.f1093a.getContext(), i);
            if (b2 != null) {
                ae.a(b2);
            }
            this.f1093a.setImageDrawable(b2);
        } else {
            this.f1093a.setImageDrawable(null);
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1093a.getBackground() instanceof RippleDrawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.f1095c == null) {
            this.f1095c = new au();
        }
        this.f1095c.f1013a = colorStateList;
        this.f1095c.f1016d = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        au auVar = this.f1095c;
        if (auVar != null) {
            return auVar.f1013a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.f1095c == null) {
            this.f1095c = new au();
        }
        this.f1095c.f1014b = mode;
        this.f1095c.f1015c = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        au auVar = this.f1095c;
        if (auVar != null) {
            return auVar.f1014b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        Drawable drawable = this.f1093a.getDrawable();
        if (drawable != null) {
            ae.a(drawable);
        }
        if (drawable != null) {
            if (e() && a(drawable)) {
                return;
            }
            au auVar = this.f1095c;
            if (auVar != null) {
                k.a(drawable, auVar, this.f1093a.getDrawableState());
                return;
            }
            au auVar2 = this.f1094b;
            if (auVar2 != null) {
                k.a(drawable, auVar2, this.f1093a.getDrawableState());
            }
        }
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f1094b != null : i == 21;
    }

    private boolean a(Drawable drawable) {
        if (this.f1096d == null) {
            this.f1096d = new au();
        }
        au auVar = this.f1096d;
        auVar.a();
        ColorStateList a2 = androidx.core.widget.e.a(this.f1093a);
        if (a2 != null) {
            auVar.f1016d = true;
            auVar.f1013a = a2;
        }
        PorterDuff.Mode b2 = androidx.core.widget.e.b(this.f1093a);
        if (b2 != null) {
            auVar.f1015c = true;
            auVar.f1014b = b2;
        }
        if (auVar.f1016d || auVar.f1015c) {
            k.a(drawable, auVar, this.f1093a.getDrawableState());
            return true;
        }
        return false;
    }
}
