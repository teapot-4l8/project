package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* compiled from: RoundedBitmapDrawable.java */
/* loaded from: classes.dex */
public abstract class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final Bitmap f1623a;

    /* renamed from: c  reason: collision with root package name */
    private int f1625c;
    private final BitmapShader f;
    private float h;
    private boolean k;
    private int l;
    private int m;

    /* renamed from: d  reason: collision with root package name */
    private int f1626d = 119;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f1627e = new Paint(3);
    private final Matrix g = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    final Rect f1624b = new Rect();
    private final RectF i = new RectF();
    private boolean j = true;

    private static boolean b(float f) {
        return f > 0.05f;
    }

    private void c() {
        this.l = this.f1623a.getScaledWidth(this.f1625c);
        this.m = this.f1623a.getScaledHeight(this.f1625c);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f1627e.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f1627e.setDither(z);
        invalidateSelf();
    }

    void a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.j) {
            if (this.k) {
                int min = Math.min(this.l, this.m);
                a(this.f1626d, min, min, getBounds(), this.f1624b);
                int min2 = Math.min(this.f1624b.width(), this.f1624b.height());
                this.f1624b.inset(Math.max(0, (this.f1624b.width() - min2) / 2), Math.max(0, (this.f1624b.height() - min2) / 2));
                this.h = min2 * 0.5f;
            } else {
                a(this.f1626d, this.l, this.m, getBounds(), this.f1624b);
            }
            this.i.set(this.f1624b);
            if (this.f != null) {
                this.g.setTranslate(this.i.left, this.i.top);
                this.g.preScale(this.i.width() / this.f1623a.getWidth(), this.i.height() / this.f1623a.getHeight());
                this.f.setLocalMatrix(this.g);
                this.f1627e.setShader(this.f);
            }
            this.j = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f1623a;
        if (bitmap == null) {
            return;
        }
        a();
        if (this.f1627e.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f1624b, this.f1627e);
            return;
        }
        RectF rectF = this.i;
        float f = this.h;
        canvas.drawRoundRect(rectF, f, f, this.f1627e);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f1627e.getAlpha()) {
            this.f1627e.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1627e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1627e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f1627e.getColorFilter();
    }

    private void d() {
        this.h = Math.min(this.m, this.l) / 2;
    }

    public void a(float f) {
        if (this.h == f) {
            return;
        }
        this.k = false;
        if (b(f)) {
            this.f1627e.setShader(this.f);
        } else {
            this.f1627e.setShader(null);
        }
        this.h = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.k) {
            d();
        }
        this.j = true;
    }

    public float b() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.f1626d != 119 || this.k || (bitmap = this.f1623a) == null || bitmap.hasAlpha() || this.f1627e.getAlpha() < 255 || b(this.h)) ? -3 : -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Resources resources, Bitmap bitmap) {
        this.f1625c = 160;
        if (resources != null) {
            this.f1625c = resources.getDisplayMetrics().densityDpi;
        }
        this.f1623a = bitmap;
        if (bitmap != null) {
            c();
            this.f = new BitmapShader(this.f1623a, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            return;
        }
        this.m = -1;
        this.l = -1;
        this.f = null;
    }
}
