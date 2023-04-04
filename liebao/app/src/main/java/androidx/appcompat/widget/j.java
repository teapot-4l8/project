package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppCompatCompoundButtonHelper.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f1080a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f1081b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1082c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1083d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1084e = false;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(CompoundButton compoundButton) {
        this.f1080a = compoundButton;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:3:0x001f, B:5:0x0027, B:7:0x002f, B:11:0x0043, B:13:0x004b, B:15:0x0053, B:16:0x0062, B:18:0x006a, B:19:0x0075, B:21:0x007d), top: B:28:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007d A[Catch: all -> 0x0092, TRY_LEAVE, TryCatch #0 {all -> 0x0092, blocks: (B:3:0x001f, B:5:0x0027, B:7:0x002f, B:11:0x0043, B:13:0x004b, B:15:0x0053, B:16:0x0062, B:18:0x006a, B:19:0x0075, B:21:0x007d), top: B:28:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(AttributeSet attributeSet, int i) {
        boolean z;
        int g;
        int g2;
        aw a2 = aw.a(this.f1080a.getContext(), attributeSet, R.styleable.CompoundButton, i, 0);
        CompoundButton compoundButton = this.f1080a;
        androidx.core.h.w.a(compoundButton, compoundButton.getContext(), R.styleable.CompoundButton, attributeSet, a2.a(), i, 0);
        try {
            if (a2.g(R.styleable.CompoundButton_buttonCompat) && (g2 = a2.g(R.styleable.CompoundButton_buttonCompat, 0)) != 0) {
                try {
                    this.f1080a.setButtonDrawable(androidx.appcompat.a.a.a.b(this.f1080a.getContext(), g2));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                }
                if (!z && a2.g(R.styleable.CompoundButton_android_button) && (g = a2.g(R.styleable.CompoundButton_android_button, 0)) != 0) {
                    this.f1080a.setButtonDrawable(androidx.appcompat.a.a.a.b(this.f1080a.getContext(), g));
                }
                if (a2.g(R.styleable.CompoundButton_buttonTint)) {
                    androidx.core.widget.c.a(this.f1080a, a2.e(R.styleable.CompoundButton_buttonTint));
                }
                if (a2.g(R.styleable.CompoundButton_buttonTintMode)) {
                    androidx.core.widget.c.a(this.f1080a, ae.a(a2.a(R.styleable.CompoundButton_buttonTintMode, -1), null));
                }
            }
            z = false;
            if (!z) {
                this.f1080a.setButtonDrawable(androidx.appcompat.a.a.a.b(this.f1080a.getContext(), g));
            }
            if (a2.g(R.styleable.CompoundButton_buttonTint)) {
            }
            if (a2.g(R.styleable.CompoundButton_buttonTintMode)) {
            }
        } finally {
            a2.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        this.f1081b = colorStateList;
        this.f1083d = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList a() {
        return this.f1081b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        this.f1082c = mode;
        this.f1084e = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode b() {
        return this.f1082c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f) {
            this.f = false;
            return;
        }
        this.f = true;
        d();
    }

    void d() {
        Drawable a2 = androidx.core.widget.c.a(this.f1080a);
        if (a2 != null) {
            if (this.f1083d || this.f1084e) {
                Drawable mutate = androidx.core.graphics.drawable.a.g(a2).mutate();
                if (this.f1083d) {
                    androidx.core.graphics.drawable.a.a(mutate, this.f1081b);
                }
                if (this.f1084e) {
                    androidx.core.graphics.drawable.a.a(mutate, this.f1082c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f1080a.getDrawableState());
                }
                this.f1080a.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        Drawable a2;
        return (Build.VERSION.SDK_INT >= 17 || (a2 = androidx.core.widget.c.a(this.f1080a)) == null) ? i : i + a2.getIntrinsicWidth();
    }
}
