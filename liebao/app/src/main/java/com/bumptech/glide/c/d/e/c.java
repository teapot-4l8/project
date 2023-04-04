package com.bumptech.glide.c.d.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.bumptech.glide.c.d.e.g;
import com.bumptech.glide.c.m;
import java.nio.ByteBuffer;

/* compiled from: GifDrawable.java */
/* loaded from: classes.dex */
public class c extends Drawable implements Animatable, g.b {

    /* renamed from: a  reason: collision with root package name */
    private final a f5062a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5063b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5064c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5065d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5066e;
    private int f;
    private int g;
    private boolean h;
    private Paint i;
    private Rect j;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public c(Context context, com.bumptech.glide.b.a aVar, m<Bitmap> mVar, int i, int i2, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.c.a(context), aVar, i, i2, mVar, bitmap)));
    }

    c(a aVar) {
        this.f5066e = true;
        this.g = -1;
        this.f5062a = (a) com.bumptech.glide.i.i.a(aVar);
    }

    public int a() {
        return this.f5062a.f5067a.d();
    }

    public Bitmap b() {
        return this.f5062a.f5067a.a();
    }

    public void a(m<Bitmap> mVar, Bitmap bitmap) {
        this.f5062a.f5067a.a(mVar, bitmap);
    }

    public ByteBuffer c() {
        return this.f5062a.f5067a.f();
    }

    public int d() {
        return this.f5062a.f5067a.g();
    }

    public int e() {
        return this.f5062a.f5067a.e();
    }

    private void h() {
        this.f = 0;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f5064c = true;
        h();
        if (this.f5066e) {
            i();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f5064c = false;
        j();
    }

    private void i() {
        com.bumptech.glide.i.i.a(!this.f5065d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f5062a.f5067a.g() == 1) {
            invalidateSelf();
        } else if (this.f5063b) {
        } else {
            this.f5063b = true;
            this.f5062a.f5067a.a(this);
            invalidateSelf();
        }
    }

    private void j() {
        this.f5063b = false;
        this.f5062a.f5067a.b(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        com.bumptech.glide.i.i.a(!this.f5065d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f5066e = z;
        if (!z) {
            j();
        } else if (this.f5064c) {
            i();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f5062a.f5067a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f5062a.f5067a.c();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f5063b;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.h = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f5065d) {
            return;
        }
        if (this.h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), k());
            this.h = false;
        }
        canvas.drawBitmap(this.f5062a.f5067a.i(), (Rect) null, k(), l());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        l().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        l().setColorFilter(colorFilter);
    }

    private Rect k() {
        if (this.j == null) {
            this.j = new Rect();
        }
        return this.j;
    }

    private Paint l() {
        if (this.i == null) {
            this.i = new Paint(2);
        }
        return this.i;
    }

    private Drawable.Callback m() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    @Override // com.bumptech.glide.c.d.e.g.b
    public void f() {
        if (m() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (e() == d() - 1) {
            this.f++;
        }
        int i = this.g;
        if (i == -1 || this.f < i) {
            return;
        }
        stop();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f5062a;
    }

    public void g() {
        this.f5065d = true;
        this.f5062a.f5067a.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifDrawable.java */
    /* loaded from: classes.dex */
    public static final class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        final g f5067a;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        a(g gVar) {
            this.f5067a = gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new c(this);
        }
    }
}
