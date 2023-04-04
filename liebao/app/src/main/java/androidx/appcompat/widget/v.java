package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;

/* compiled from: AppCompatSeekBarHelper.java */
/* loaded from: classes.dex */
class v extends r {

    /* renamed from: a  reason: collision with root package name */
    private final SeekBar f1112a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f1113b;

    /* renamed from: c  reason: collision with root package name */
    private ColorStateList f1114c;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuff.Mode f1115d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1116e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SeekBar seekBar) {
        super(seekBar);
        this.f1114c = null;
        this.f1115d = null;
        this.f1116e = false;
        this.f = false;
        this.f1112a = seekBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.r
    public void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        aw a2 = aw.a(this.f1112a.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i, 0);
        SeekBar seekBar = this.f1112a;
        androidx.core.h.w.a(seekBar, seekBar.getContext(), R.styleable.AppCompatSeekBar, attributeSet, a2.a(), i, 0);
        Drawable b2 = a2.b(R.styleable.AppCompatSeekBar_android_thumb);
        if (b2 != null) {
            this.f1112a.setThumb(b2);
        }
        a(a2.a(R.styleable.AppCompatSeekBar_tickMark));
        if (a2.g(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1115d = ae.a(a2.a(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f1115d);
            this.f = true;
        }
        if (a2.g(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f1114c = a2.e(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.f1116e = true;
        }
        a2.b();
        d();
    }

    void a(Drawable drawable) {
        Drawable drawable2 = this.f1113b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1113b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1112a);
            androidx.core.graphics.drawable.a.b(drawable, androidx.core.h.w.g(this.f1112a));
            if (drawable.isStateful()) {
                drawable.setState(this.f1112a.getDrawableState());
            }
            d();
        }
        this.f1112a.invalidate();
    }

    private void d() {
        if (this.f1113b != null) {
            if (this.f1116e || this.f) {
                Drawable g = androidx.core.graphics.drawable.a.g(this.f1113b.mutate());
                this.f1113b = g;
                if (this.f1116e) {
                    androidx.core.graphics.drawable.a.a(g, this.f1114c);
                }
                if (this.f) {
                    androidx.core.graphics.drawable.a.a(this.f1113b, this.f1115d);
                }
                if (this.f1113b.isStateful()) {
                    this.f1113b.setState(this.f1112a.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.f1113b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.f1113b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1112a.getDrawableState())) {
            this.f1112a.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (this.f1113b != null) {
            int max = this.f1112a.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f1113b.getIntrinsicWidth();
                int intrinsicHeight = this.f1113b.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f1113b.setBounds(-i, -i2, i, i2);
                float width = ((this.f1112a.getWidth() - this.f1112a.getPaddingLeft()) - this.f1112a.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f1112a.getPaddingLeft(), this.f1112a.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f1113b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
