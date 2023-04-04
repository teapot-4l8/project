package androidx.appcompat.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DrawableContainer.java */
/* loaded from: classes.dex */
public class b extends Drawable implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    private AbstractC0023b f678a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f679b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f680c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f681d;
    private boolean f;
    private boolean h;
    private Runnable i;
    private long j;
    private long k;
    private a l;

    /* renamed from: e  reason: collision with root package name */
    private int f682e = 255;
    private int g = -1;

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f680c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f681d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f678a.getChangingConfigurations();
    }

    private boolean a() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.i(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect e2 = this.f678a.e();
        if (e2 != null) {
            rect.set(e2);
            padding = (e2.right | ((e2.left | e2.top) | e2.bottom)) != 0;
        } else {
            Drawable drawable = this.f680c;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (a()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f680c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f && this.f682e == i) {
            return;
        }
        this.f = true;
        this.f682e = i;
        Drawable drawable = this.f680c;
        if (drawable != null) {
            if (this.j == 0) {
                drawable.setAlpha(i);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f682e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        if (this.f678a.z != z) {
            this.f678a.z = z;
            Drawable drawable = this.f680c;
            if (drawable != null) {
                drawable.setDither(this.f678a.z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f678a.G = true;
        if (this.f678a.F != colorFilter) {
            this.f678a.F = colorFilter;
            Drawable drawable = this.f680c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public void setTintList(ColorStateList colorStateList) {
        this.f678a.J = true;
        if (this.f678a.H != colorStateList) {
            this.f678a.H = colorStateList;
            androidx.core.graphics.drawable.a.a(this.f680c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public void setTintMode(PorterDuff.Mode mode) {
        this.f678a.K = true;
        if (this.f678a.I != mode) {
            this.f678a.I = mode;
            androidx.core.graphics.drawable.a.a(this.f680c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f681d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f680c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f678a.m();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f678a.E != z) {
            this.f678a.E = z;
            Drawable drawable = this.f680c;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.a(drawable, this.f678a.E);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f678a.E;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f681d;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f681d = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f680c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f) {
                this.f680c.setAlpha(this.f682e);
            }
        }
        if (this.k != 0) {
            this.k = 0L;
            z = true;
        }
        if (this.j != 0) {
            this.j = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.f680c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.f679b;
        if (rect == null) {
            this.f679b = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.f680c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f679b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f681d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f680c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.f681d;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.f680c;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.f678a.d(i, d());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f678a.f()) {
            return this.f678a.g();
        }
        Drawable drawable = this.f680c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f678a.f()) {
            return this.f678a.h();
        }
        Drawable drawable = this.f680c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f678a.f()) {
            return this.f678a.i();
        }
        Drawable drawable = this.f680c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f678a.f()) {
            return this.f678a.j();
        }
        Drawable drawable = this.f680c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public void invalidateDrawable(Drawable drawable) {
        AbstractC0023b abstractC0023b = this.f678a;
        if (abstractC0023b != null) {
            abstractC0023b.b();
        }
        if (drawable != this.f680c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.f680c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f680c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f681d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f680c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f680c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f678a.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        if (i == this.g) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f678a.D > 0) {
            Drawable drawable = this.f681d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f680c;
            if (drawable2 != null) {
                this.f681d = drawable2;
                this.k = this.f678a.D + uptimeMillis;
            } else {
                this.f681d = null;
                this.k = 0L;
            }
        } else {
            Drawable drawable3 = this.f680c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i >= 0 && i < this.f678a.j) {
            Drawable b2 = this.f678a.b(i);
            this.f680c = b2;
            this.g = i;
            if (b2 != null) {
                if (this.f678a.C > 0) {
                    this.j = uptimeMillis + this.f678a.C;
                }
                a(b2);
            }
        } else {
            this.f680c = null;
            this.g = -1;
        }
        if (this.j != 0 || this.k != 0) {
            Runnable runnable = this.i;
            if (runnable == null) {
                this.i = new Runnable() { // from class: androidx.appcompat.b.a.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a(true);
                        b.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(runnable);
            }
            a(true);
        }
        invalidateSelf();
        return true;
    }

    private void a(Drawable drawable) {
        if (this.l == null) {
            this.l = new a();
        }
        drawable.setCallback(this.l.a(drawable.getCallback()));
        try {
            if (this.f678a.C <= 0 && this.f) {
                drawable.setAlpha(this.f682e);
            }
            if (this.f678a.G) {
                drawable.setColorFilter(this.f678a.F);
            } else {
                if (this.f678a.J) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f678a.H);
                }
                if (this.f678a.K) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f678a.I);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f678a.z);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f678a.E);
            }
            Rect rect = this.f679b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.l.a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(boolean z) {
        boolean z2;
        Drawable drawable;
        boolean z3 = true;
        this.f = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f680c;
        if (drawable2 != null) {
            long j = this.j;
            if (j != 0) {
                if (j <= uptimeMillis) {
                    drawable2.setAlpha(this.f682e);
                    this.j = 0L;
                } else {
                    this.f680c.setAlpha(((255 - (((int) ((j - uptimeMillis) * 255)) / this.f678a.C)) * this.f682e) / 255);
                    z2 = true;
                    drawable = this.f681d;
                    if (drawable == null) {
                        long j2 = this.k;
                        if (j2 != 0) {
                            if (j2 <= uptimeMillis) {
                                drawable.setVisible(false, false);
                                this.f681d = null;
                                this.k = 0L;
                            } else {
                                this.f681d.setAlpha(((((int) ((j2 - uptimeMillis) * 255)) / this.f678a.D) * this.f682e) / 255);
                                if (z && z3) {
                                    scheduleSelf(this.i, uptimeMillis + 16);
                                    return;
                                }
                                return;
                            }
                        }
                    } else {
                        this.k = 0L;
                    }
                    z3 = z2;
                    if (z) {
                        return;
                    }
                    return;
                }
            }
        } else {
            this.j = 0L;
        }
        z2 = false;
        drawable = this.f681d;
        if (drawable == null) {
        }
        z3 = z2;
        if (z) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f680c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Resources resources) {
        this.f678a.a(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f678a.a(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f678a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f678a.n()) {
            this.f678a.f = getChangingConfigurations();
            return this.f678a;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.h && super.mutate() == this) {
            AbstractC0023b c2 = c();
            c2.a();
            a(c2);
            this.h = true;
        }
        return this;
    }

    AbstractC0023b c() {
        return this.f678a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawableContainer.java */
    /* renamed from: androidx.appcompat.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0023b extends Drawable.ConstantState {
        boolean A;
        int B;
        int C;
        int D;
        boolean E;
        ColorFilter F;
        boolean G;
        ColorStateList H;
        PorterDuff.Mode I;
        boolean J;
        boolean K;

        /* renamed from: c  reason: collision with root package name */
        final b f685c;

        /* renamed from: d  reason: collision with root package name */
        Resources f686d;

        /* renamed from: e  reason: collision with root package name */
        int f687e;
        int f;
        int g;
        SparseArray<Drawable.ConstantState> h;
        Drawable[] i;
        int j;
        boolean k;
        boolean l;
        Rect m;
        boolean n;
        boolean o;
        int p;

        /* renamed from: q  reason: collision with root package name */
        int f688q;
        int r;
        int s;
        boolean t;
        int u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        boolean z;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AbstractC0023b(AbstractC0023b abstractC0023b, b bVar, Resources resources) {
            Resources resources2;
            this.f687e = 160;
            this.k = false;
            this.n = false;
            this.z = true;
            this.C = 0;
            this.D = 0;
            this.f685c = bVar;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = abstractC0023b != null ? abstractC0023b.f686d : null;
            }
            this.f686d = resources2;
            int a2 = b.a(resources, abstractC0023b != null ? abstractC0023b.f687e : 0);
            this.f687e = a2;
            if (abstractC0023b != null) {
                this.f = abstractC0023b.f;
                this.g = abstractC0023b.g;
                this.x = true;
                this.y = true;
                this.k = abstractC0023b.k;
                this.n = abstractC0023b.n;
                this.z = abstractC0023b.z;
                this.A = abstractC0023b.A;
                this.B = abstractC0023b.B;
                this.C = abstractC0023b.C;
                this.D = abstractC0023b.D;
                this.E = abstractC0023b.E;
                this.F = abstractC0023b.F;
                this.G = abstractC0023b.G;
                this.H = abstractC0023b.H;
                this.I = abstractC0023b.I;
                this.J = abstractC0023b.J;
                this.K = abstractC0023b.K;
                if (abstractC0023b.f687e == a2) {
                    if (abstractC0023b.l) {
                        this.m = new Rect(abstractC0023b.m);
                        this.l = true;
                    }
                    if (abstractC0023b.o) {
                        this.p = abstractC0023b.p;
                        this.f688q = abstractC0023b.f688q;
                        this.r = abstractC0023b.r;
                        this.s = abstractC0023b.s;
                        this.o = true;
                    }
                }
                if (abstractC0023b.t) {
                    this.u = abstractC0023b.u;
                    this.t = true;
                }
                if (abstractC0023b.v) {
                    this.w = abstractC0023b.w;
                    this.v = true;
                }
                Drawable[] drawableArr = abstractC0023b.i;
                this.i = new Drawable[drawableArr.length];
                this.j = abstractC0023b.j;
                SparseArray<Drawable.ConstantState> sparseArray = abstractC0023b.h;
                if (sparseArray != null) {
                    this.h = sparseArray.clone();
                } else {
                    this.h = new SparseArray<>(this.j);
                }
                int i = this.j;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null) {
                        Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.h.put(i2, constantState);
                        } else {
                            this.i[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.i = new Drawable[10];
            this.j = 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f | this.g;
        }

        public final int a(Drawable drawable) {
            int i = this.j;
            if (i >= this.i.length) {
                e(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f685c);
            this.i[i] = drawable;
            this.j++;
            this.g = drawable.getChangingConfigurations() | this.g;
            b();
            this.m = null;
            this.l = false;
            this.o = false;
            this.x = false;
            return i;
        }

        void b() {
            this.t = false;
            this.v = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int c() {
            return this.i.length;
        }

        private void o() {
            SparseArray<Drawable.ConstantState> sparseArray = this.h;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.i[this.h.keyAt(i)] = b(this.h.valueAt(i).newDrawable(this.f686d));
                }
                this.h = null;
            }
        }

        private Drawable b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.B);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f685c);
            return mutate;
        }

        public final int d() {
            return this.j;
        }

        public final Drawable b(int i) {
            int indexOfKey;
            Drawable drawable = this.i[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.h;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable b2 = b(this.h.valueAt(indexOfKey).newDrawable(this.f686d));
            this.i[i] = b2;
            this.h.removeAt(indexOfKey);
            if (this.h.size() == 0) {
                this.h = null;
            }
            return b2;
        }

        final boolean d(int i, int i2) {
            int i3 = this.j;
            Drawable[] drawableArr = this.i;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.B = i;
            return z;
        }

        final void a(Resources resources) {
            if (resources != null) {
                this.f686d = resources;
                int a2 = b.a(resources, this.f687e);
                int i = this.f687e;
                this.f687e = a2;
                if (i != a2) {
                    this.o = false;
                    this.l = false;
                }
            }
        }

        final void a(Resources.Theme theme) {
            if (theme != null) {
                o();
                int i = this.j;
                Drawable[] drawableArr = this.i;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.g |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                a(theme.getResources());
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.j;
            Drawable[] drawableArr = this.i;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    if (drawable.canApplyTheme()) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.h.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                }
            }
            return false;
        }

        void a() {
            int i = this.j;
            Drawable[] drawableArr = this.i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null) {
                    drawableArr[i2].mutate();
                }
            }
            this.A = true;
        }

        public final void a(boolean z) {
            this.k = z;
        }

        public final Rect e() {
            Rect rect = null;
            if (this.k) {
                return null;
            }
            if (this.m != null || this.l) {
                return this.m;
            }
            o();
            Rect rect2 = new Rect();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect2)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    if (rect2.left > rect.left) {
                        rect.left = rect2.left;
                    }
                    if (rect2.top > rect.top) {
                        rect.top = rect2.top;
                    }
                    if (rect2.right > rect.right) {
                        rect.right = rect2.right;
                    }
                    if (rect2.bottom > rect.bottom) {
                        rect.bottom = rect2.bottom;
                    }
                }
            }
            this.l = true;
            this.m = rect;
            return rect;
        }

        public final void b(boolean z) {
            this.n = z;
        }

        public final boolean f() {
            return this.n;
        }

        public final int g() {
            if (!this.o) {
                k();
            }
            return this.p;
        }

        public final int h() {
            if (!this.o) {
                k();
            }
            return this.f688q;
        }

        public final int i() {
            if (!this.o) {
                k();
            }
            return this.r;
        }

        public final int j() {
            if (!this.o) {
                k();
            }
            return this.s;
        }

        protected void k() {
            this.o = true;
            o();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            this.f688q = -1;
            this.p = -1;
            this.s = 0;
            this.r = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.p) {
                    this.p = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f688q) {
                    this.f688q = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.r) {
                    this.r = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.s) {
                    this.s = minimumHeight;
                }
            }
        }

        public final void c(int i) {
            this.C = i;
        }

        public final void d(int i) {
            this.D = i;
        }

        public final int l() {
            if (this.t) {
                return this.u;
            }
            o();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.u = opacity;
            this.t = true;
            return opacity;
        }

        public final boolean m() {
            if (this.v) {
                return this.w;
            }
            o();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                } else if (drawableArr[i2].isStateful()) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            this.w = z;
            this.v = true;
            return z;
        }

        public void e(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.i, 0, drawableArr, 0, i);
            this.i = drawableArr;
        }

        public synchronized boolean n() {
            if (this.x) {
                return this.y;
            }
            o();
            this.x = true;
            int i = this.j;
            Drawable[] drawableArr = this.i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.y = false;
                    return false;
                }
            }
            this.y = true;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AbstractC0023b abstractC0023b) {
        this.f678a = abstractC0023b;
        int i = this.g;
        if (i >= 0) {
            Drawable b2 = abstractC0023b.b(i);
            this.f680c = b2;
            if (b2 != null) {
                a(b2);
            }
        }
        this.f681d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawableContainer.java */
    /* loaded from: classes.dex */
    public static class a implements Drawable.Callback {

        /* renamed from: a  reason: collision with root package name */
        private Drawable.Callback f684a;

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        a() {
        }

        public a a(Drawable.Callback callback) {
            this.f684a = callback;
            return this;
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f684a;
            this.f684a = null;
            return callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f684a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f684a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static int a(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }
}
