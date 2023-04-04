package androidx.vectordrawable.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.graphics.c;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat.java */
/* loaded from: classes.dex */
public class i extends androidx.vectordrawable.a.a.h {

    /* renamed from: a  reason: collision with root package name */
    static final PorterDuff.Mode f2698a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private g f2699b;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuffColorFilter f2700d;

    /* renamed from: e  reason: collision with root package name */
    private ColorFilter f2701e;
    private boolean f;
    private boolean g;
    private Drawable.ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    i() {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f2699b = new g();
    }

    i(g gVar) {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f2699b = gVar;
        this.f2700d = a(this.f2700d, gVar.f2720c, gVar.f2721d);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.f2697c != null) {
            this.f2697c.mutate();
            return this;
        }
        if (!this.f && super.mutate() == this) {
            this.f2699b = new g(this.f2699b);
            this.f = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str) {
        return this.f2699b.f2719b.k.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f2697c != null && Build.VERSION.SDK_INT >= 24) {
            return new h(this.f2697c.getConstantState());
        }
        this.f2699b.f2718a = getChangingConfigurations();
        return this.f2699b;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f2697c != null) {
            this.f2697c.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() <= 0 || this.k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f2701e;
        if (colorFilter == null) {
            colorFilter = this.f2700d;
        }
        canvas.getMatrix(this.j);
        this.j.getValues(this.i);
        float abs = Math.abs(this.i[0]);
        float abs2 = Math.abs(this.i[4]);
        float abs3 = Math.abs(this.i[1]);
        float abs4 = Math.abs(this.i[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.k.width() * abs));
        int min2 = Math.min(2048, (int) (this.k.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.k.left, this.k.top);
        if (a()) {
            canvas.translate(this.k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.k.offsetTo(0, 0);
        this.f2699b.b(min, min2);
        if (!this.g) {
            this.f2699b.a(min, min2);
        } else if (!this.f2699b.b()) {
            this.f2699b.a(min, min2);
            this.f2699b.c();
        }
        this.f2699b.a(canvas, colorFilter, this.k);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        if (this.f2697c != null) {
            return androidx.core.graphics.drawable.a.c(this.f2697c);
        }
        return this.f2699b.f2719b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f2697c != null) {
            this.f2697c.setAlpha(i);
        } else if (this.f2699b.f2719b.getRootAlpha() != i) {
            this.f2699b.f2719b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f2697c != null) {
            this.f2697c.setColorFilter(colorFilter);
            return;
        }
        this.f2701e = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        if (this.f2697c != null) {
            return androidx.core.graphics.drawable.a.e(this.f2697c);
        }
        return this.f2701e;
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public void setTint(int i) {
        if (this.f2697c != null) {
            androidx.core.graphics.drawable.a.a(this.f2697c, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public void setTintList(ColorStateList colorStateList) {
        if (this.f2697c != null) {
            androidx.core.graphics.drawable.a.a(this.f2697c, colorStateList);
            return;
        }
        g gVar = this.f2699b;
        if (gVar.f2720c != colorStateList) {
            gVar.f2720c = colorStateList;
            this.f2700d = a(this.f2700d, colorStateList, gVar.f2721d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f2697c != null) {
            androidx.core.graphics.drawable.a.a(this.f2697c, mode);
            return;
        }
        g gVar = this.f2699b;
        if (gVar.f2721d != mode) {
            gVar.f2721d = mode;
            this.f2700d = a(this.f2700d, gVar.f2720c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        g gVar;
        if (this.f2697c != null) {
            return this.f2697c.isStateful();
        }
        return super.isStateful() || ((gVar = this.f2699b) != null && (gVar.d() || (this.f2699b.f2720c != null && this.f2699b.f2720c.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.f2697c != null) {
            return this.f2697c.setState(iArr);
        }
        boolean z = false;
        g gVar = this.f2699b;
        if (gVar.f2720c != null && gVar.f2721d != null) {
            this.f2700d = a(this.f2700d, gVar.f2720c, gVar.f2721d);
            invalidateSelf();
            z = true;
        }
        if (gVar.d() && gVar.a(iArr)) {
            invalidateSelf();
            return true;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f2697c != null) {
            return this.f2697c.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f2697c != null) {
            return this.f2697c.getIntrinsicWidth();
        }
        return (int) this.f2699b.f2719b.f2715d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f2697c != null) {
            return this.f2697c.getIntrinsicHeight();
        }
        return (int) this.f2699b.f2719b.f2716e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f2697c != null) {
            androidx.core.graphics.drawable.a.d(this.f2697c);
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        if (this.f2697c != null) {
            return androidx.core.graphics.drawable.a.b(this.f2697c);
        }
        return this.f2699b.f2722e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f2697c != null) {
            androidx.core.graphics.drawable.a.a(this.f2697c, z);
        } else {
            this.f2699b.f2722e = z;
        }
    }

    public static i a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.f2697c = androidx.core.content.b.f.a(resources, i, theme);
            iVar.h = new h(iVar.f2697c.getConstantState());
            return iVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            return a(resources, xml, asAttributeSet, theme);
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static i a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    static int a(int i, float f2) {
        return (i & 16777215) | (((int) (Color.alpha(i) * f2)) << 24);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.f2697c != null) {
            this.f2697c.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.f2697c != null) {
            androidx.core.graphics.drawable.a.a(this.f2697c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.f2699b;
        gVar.f2719b = new f();
        TypedArray a2 = androidx.core.content.b.g.a(resources, theme, attributeSet, androidx.vectordrawable.a.a.a.f2677a);
        a(a2, xmlPullParser, theme);
        a2.recycle();
        gVar.f2718a = getChangingConfigurations();
        gVar.k = true;
        b(resources, xmlPullParser, attributeSet, theme);
        this.f2700d = a(this.f2700d, gVar.f2720c, gVar.f2721d);
    }

    private static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i == 9) {
                    return PorterDuff.Mode.SRC_ATOP;
                }
                switch (i) {
                    case 14:
                        return PorterDuff.Mode.MULTIPLY;
                    case 15:
                        return PorterDuff.Mode.SCREEN;
                    case 16:
                        return PorterDuff.Mode.ADD;
                    default:
                        return mode;
                }
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        g gVar = this.f2699b;
        f fVar = gVar.f2719b;
        gVar.f2721d = a(androidx.core.content.b.g.a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList a2 = androidx.core.content.b.g.a(typedArray, xmlPullParser, theme, "tint", 1);
        if (a2 != null) {
            gVar.f2720c = a2;
        }
        gVar.f2722e = androidx.core.content.b.g.a(typedArray, xmlPullParser, "autoMirrored", 5, gVar.f2722e);
        fVar.f = androidx.core.content.b.g.a(typedArray, xmlPullParser, "viewportWidth", 7, fVar.f);
        fVar.g = androidx.core.content.b.g.a(typedArray, xmlPullParser, "viewportHeight", 8, fVar.g);
        if (fVar.f <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (fVar.g <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            fVar.f2715d = typedArray.getDimension(3, fVar.f2715d);
            fVar.f2716e = typedArray.getDimension(2, fVar.f2716e);
            if (fVar.f2715d <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (fVar.f2716e <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                fVar.setAlpha(androidx.core.content.b.g.a(typedArray, xmlPullParser, "alpha", 4, fVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    fVar.i = string;
                    fVar.k.put(string, fVar);
                }
            }
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        g gVar = this.f2699b;
        f fVar = gVar.f2719b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.f2714c);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2708b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.k.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    gVar.f2718a = bVar.o | gVar.f2718a;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2708b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.k.put(aVar.getPathName(), aVar);
                    }
                    gVar.f2718a = aVar.o | gVar.f2718a;
                } else if ("group".equals(name)) {
                    c cVar2 = new c();
                    cVar2.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2708b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.k.put(cVar2.getGroupName(), cVar2);
                    }
                    gVar.f2718a = cVar2.f2711e | gVar.f2718a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.g = z;
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a.i(this) == 1;
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f2697c != null) {
            this.f2697c.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        if (this.f2697c != null) {
            return this.f2697c.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f2699b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f2697c != null) {
            this.f2697c.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.f2697c != null) {
            this.f2697c.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.f2697c != null) {
            return this.f2697c.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        if (this.f2697c != null) {
            this.f2697c.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f2723a;

        public h(Drawable.ConstantState constantState) {
            this.f2723a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i();
            iVar.f2697c = (VectorDrawable) this.f2723a.newDrawable();
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.f2697c = (VectorDrawable) this.f2723a.newDrawable(resources);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.f2697c = (VectorDrawable) this.f2723a.newDrawable(resources, theme);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f2723a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2723a.getChangingConfigurations();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class g extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f2718a;

        /* renamed from: b  reason: collision with root package name */
        f f2719b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f2720c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f2721d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2722e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public g(g gVar) {
            this.f2720c = null;
            this.f2721d = i.f2698a;
            if (gVar != null) {
                this.f2718a = gVar.f2718a;
                this.f2719b = new f(gVar.f2719b);
                if (gVar.f2719b.f2713b != null) {
                    this.f2719b.f2713b = new Paint(gVar.f2719b.f2713b);
                }
                if (gVar.f2719b.f2712a != null) {
                    this.f2719b.f2712a = new Paint(gVar.f2719b.f2712a);
                }
                this.f2720c = gVar.f2720c;
                this.f2721d = gVar.f2721d;
                this.f2722e = gVar.f2722e;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, a(colorFilter));
        }

        public boolean a() {
            return this.f2719b.getRootAlpha() < 255;
        }

        public Paint a(ColorFilter colorFilter) {
            if (a() || colorFilter != null) {
                if (this.l == null) {
                    Paint paint = new Paint();
                    this.l = paint;
                    paint.setFilterBitmap(true);
                }
                this.l.setAlpha(this.f2719b.getRootAlpha());
                this.l.setColorFilter(colorFilter);
                return this.l;
            }
            return null;
        }

        public void a(int i, int i2) {
            this.f.eraseColor(0);
            this.f2719b.a(new Canvas(this.f), i, i2, (ColorFilter) null);
        }

        public void b(int i, int i2) {
            if (this.f == null || !c(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean c(int i, int i2) {
            return i == this.f.getWidth() && i2 == this.f.getHeight();
        }

        public boolean b() {
            return !this.k && this.g == this.f2720c && this.h == this.f2721d && this.j == this.f2722e && this.i == this.f2719b.getRootAlpha();
        }

        public void c() {
            this.g = this.f2720c;
            this.h = this.f2721d;
            this.i = this.f2719b.getRootAlpha();
            this.j = this.f2722e;
            this.k = false;
        }

        public g() {
            this.f2720c = null;
            this.f2721d = i.f2698a;
            this.f2719b = new f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new i(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2718a;
        }

        public boolean d() {
            return this.f2719b.a();
        }

        public boolean a(int[] iArr) {
            boolean a2 = this.f2719b.a(iArr);
            this.k |= a2;
            return a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class f {
        private static final Matrix n = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        Paint f2712a;

        /* renamed from: b  reason: collision with root package name */
        Paint f2713b;

        /* renamed from: c  reason: collision with root package name */
        final c f2714c;

        /* renamed from: d  reason: collision with root package name */
        float f2715d;

        /* renamed from: e  reason: collision with root package name */
        float f2716e;
        float f;
        float g;
        int h;
        String i;
        Boolean j;
        final androidx.b.a<String, Object> k;
        private final Path l;
        private final Path m;
        private final Matrix o;
        private PathMeasure p;

        /* renamed from: q  reason: collision with root package name */
        private int f2717q;

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        public f() {
            this.o = new Matrix();
            this.f2715d = 0.0f;
            this.f2716e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 255;
            this.i = null;
            this.j = null;
            this.k = new androidx.b.a<>();
            this.f2714c = new c();
            this.l = new Path();
            this.m = new Path();
        }

        public void setRootAlpha(int i) {
            this.h = i;
        }

        public int getRootAlpha() {
            return this.h;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public f(f fVar) {
            this.o = new Matrix();
            this.f2715d = 0.0f;
            this.f2716e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 255;
            this.i = null;
            this.j = null;
            androidx.b.a<String, Object> aVar = new androidx.b.a<>();
            this.k = aVar;
            this.f2714c = new c(fVar.f2714c, aVar);
            this.l = new Path(fVar.l);
            this.m = new Path(fVar.m);
            this.f2715d = fVar.f2715d;
            this.f2716e = fVar.f2716e;
            this.f = fVar.f;
            this.g = fVar.g;
            this.f2717q = fVar.f2717q;
            this.h = fVar.h;
            this.i = fVar.i;
            String str = fVar.i;
            if (str != null) {
                this.k.put(str, this);
            }
            this.j = fVar.j;
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.f2707a.set(matrix);
            cVar.f2707a.preConcat(cVar.f2710d);
            canvas.save();
            for (int i3 = 0; i3 < cVar.f2708b.size(); i3++) {
                d dVar = cVar.f2708b.get(i3);
                if (dVar instanceof c) {
                    a((c) dVar, cVar.f2707a, canvas, i, i2, colorFilter);
                } else if (dVar instanceof e) {
                    a(cVar, (e) dVar, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.f2714c, n, canvas, i, i2, colorFilter);
        }

        private void a(c cVar, e eVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.f;
            float f2 = i2 / this.g;
            float min = Math.min(f, f2);
            Matrix matrix = cVar.f2707a;
            this.o.set(matrix);
            this.o.postScale(f, f2);
            float a2 = a(matrix);
            if (a2 == 0.0f) {
                return;
            }
            eVar.a(this.l);
            Path path = this.l;
            this.m.reset();
            if (eVar.a()) {
                this.m.setFillType(eVar.n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.m.addPath(path, this.o);
                canvas.clipPath(this.m);
                return;
            }
            b bVar = (b) eVar;
            if (bVar.f != 0.0f || bVar.g != 1.0f) {
                float f3 = (bVar.f + bVar.h) % 1.0f;
                float f4 = (bVar.g + bVar.h) % 1.0f;
                if (this.p == null) {
                    this.p = new PathMeasure();
                }
                this.p.setPath(this.l, false);
                float length = this.p.getLength();
                float f5 = f3 * length;
                float f6 = f4 * length;
                path.reset();
                if (f5 > f6) {
                    this.p.getSegment(f5, length, path, true);
                    this.p.getSegment(0.0f, f6, path, true);
                } else {
                    this.p.getSegment(f5, f6, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.m.addPath(path, this.o);
            if (bVar.f2704c.e()) {
                androidx.core.content.b.b bVar2 = bVar.f2704c;
                if (this.f2713b == null) {
                    Paint paint = new Paint(1);
                    this.f2713b = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f2713b;
                if (bVar2.c()) {
                    Shader a3 = bVar2.a();
                    a3.setLocalMatrix(this.o);
                    paint2.setShader(a3);
                    paint2.setAlpha(Math.round(bVar.f2706e * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(i.a(bVar2.b(), bVar.f2706e));
                }
                paint2.setColorFilter(colorFilter);
                this.m.setFillType(bVar.n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.m, paint2);
            }
            if (bVar.f2702a.e()) {
                androidx.core.content.b.b bVar3 = bVar.f2702a;
                if (this.f2712a == null) {
                    Paint paint3 = new Paint(1);
                    this.f2712a = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f2712a;
                if (bVar.j != null) {
                    paint4.setStrokeJoin(bVar.j);
                }
                if (bVar.i != null) {
                    paint4.setStrokeCap(bVar.i);
                }
                paint4.setStrokeMiter(bVar.k);
                if (bVar3.c()) {
                    Shader a4 = bVar3.a();
                    a4.setLocalMatrix(this.o);
                    paint4.setShader(a4);
                    paint4.setAlpha(Math.round(bVar.f2705d * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(i.a(bVar3.b(), bVar.f2705d));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(bVar.f2703b * min * a2);
                canvas.drawPath(this.m, paint4);
            }
        }

        private float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public boolean a() {
            if (this.j == null) {
                this.j = Boolean.valueOf(this.f2714c.b());
            }
            return this.j.booleanValue();
        }

        public boolean a(int[] iArr) {
            return this.f2714c.a(iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class d {
        public boolean a(int[] iArr) {
            return false;
        }

        public boolean b() {
            return false;
        }

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class c extends d {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f2707a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<d> f2708b;

        /* renamed from: c  reason: collision with root package name */
        float f2709c;

        /* renamed from: d  reason: collision with root package name */
        final Matrix f2710d;

        /* renamed from: e  reason: collision with root package name */
        int f2711e;
        private float f;
        private float g;
        private float h;
        private float i;
        private float j;
        private float k;
        private int[] l;
        private String m;

        public c(c cVar, androidx.b.a<String, Object> aVar) {
            super();
            e aVar2;
            this.f2707a = new Matrix();
            this.f2708b = new ArrayList<>();
            this.f2709c = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 1.0f;
            this.i = 1.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.f2710d = new Matrix();
            this.m = null;
            this.f2709c = cVar.f2709c;
            this.f = cVar.f;
            this.g = cVar.g;
            this.h = cVar.h;
            this.i = cVar.i;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            String str = cVar.m;
            this.m = str;
            this.f2711e = cVar.f2711e;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f2710d.set(cVar.f2710d);
            ArrayList<d> arrayList = cVar.f2708b;
            for (int i = 0; i < arrayList.size(); i++) {
                d dVar = arrayList.get(i);
                if (dVar instanceof c) {
                    this.f2708b.add(new c((c) dVar, aVar));
                } else {
                    if (dVar instanceof b) {
                        aVar2 = new b((b) dVar);
                    } else if (dVar instanceof a) {
                        aVar2 = new a((a) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f2708b.add(aVar2);
                    if (aVar2.m != null) {
                        aVar.put(aVar2.m, aVar2);
                    }
                }
            }
        }

        public c() {
            super();
            this.f2707a = new Matrix();
            this.f2708b = new ArrayList<>();
            this.f2709c = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 1.0f;
            this.i = 1.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.f2710d = new Matrix();
            this.m = null;
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.f2710d;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = androidx.core.content.b.g.a(resources, theme, attributeSet, androidx.vectordrawable.a.a.a.f2678b);
            a(a2, xmlPullParser);
            a2.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f2709c = androidx.core.content.b.g.a(typedArray, xmlPullParser, "rotation", 5, this.f2709c);
            this.f = typedArray.getFloat(1, this.f);
            this.g = typedArray.getFloat(2, this.g);
            this.h = androidx.core.content.b.g.a(typedArray, xmlPullParser, "scaleX", 3, this.h);
            this.i = androidx.core.content.b.g.a(typedArray, xmlPullParser, "scaleY", 4, this.i);
            this.j = androidx.core.content.b.g.a(typedArray, xmlPullParser, "translateX", 6, this.j);
            this.k = androidx.core.content.b.g.a(typedArray, xmlPullParser, "translateY", 7, this.k);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            a();
        }

        private void a() {
            this.f2710d.reset();
            this.f2710d.postTranslate(-this.f, -this.g);
            this.f2710d.postScale(this.h, this.i);
            this.f2710d.postRotate(this.f2709c, 0.0f, 0.0f);
            this.f2710d.postTranslate(this.j + this.f, this.k + this.g);
        }

        public float getRotation() {
            return this.f2709c;
        }

        public void setRotation(float f) {
            if (f != this.f2709c) {
                this.f2709c = f;
                a();
            }
        }

        public float getPivotX() {
            return this.f;
        }

        public void setPivotX(float f) {
            if (f != this.f) {
                this.f = f;
                a();
            }
        }

        public float getPivotY() {
            return this.g;
        }

        public void setPivotY(float f) {
            if (f != this.g) {
                this.g = f;
                a();
            }
        }

        public float getScaleX() {
            return this.h;
        }

        public void setScaleX(float f) {
            if (f != this.h) {
                this.h = f;
                a();
            }
        }

        public float getScaleY() {
            return this.i;
        }

        public void setScaleY(float f) {
            if (f != this.i) {
                this.i = f;
                a();
            }
        }

        public float getTranslateX() {
            return this.j;
        }

        public void setTranslateX(float f) {
            if (f != this.j) {
                this.j = f;
                a();
            }
        }

        public float getTranslateY() {
            return this.k;
        }

        public void setTranslateY(float f) {
            if (f != this.k) {
                this.k = f;
                a();
            }
        }

        @Override // androidx.vectordrawable.a.a.i.d
        public boolean b() {
            for (int i = 0; i < this.f2708b.size(); i++) {
                if (this.f2708b.get(i).b()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.a.a.i.d
        public boolean a(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f2708b.size(); i++) {
                z |= this.f2708b.get(i).a(iArr);
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class e extends d {
        protected c.b[] l;
        String m;
        int n;
        int o;

        public boolean a() {
            return false;
        }

        public e() {
            super();
            this.l = null;
            this.n = 0;
        }

        public e(e eVar) {
            super();
            this.l = null;
            this.n = 0;
            this.m = eVar.m;
            this.o = eVar.o;
            this.l = androidx.core.graphics.c.a(eVar.l);
        }

        public void a(Path path) {
            path.reset();
            c.b[] bVarArr = this.l;
            if (bVarArr != null) {
                c.b.a(bVarArr, path);
            }
        }

        public String getPathName() {
            return this.m;
        }

        public c.b[] getPathData() {
            return this.l;
        }

        public void setPathData(c.b[] bVarArr) {
            if (!androidx.core.graphics.c.a(this.l, bVarArr)) {
                this.l = androidx.core.graphics.c.a(bVarArr);
            } else {
                androidx.core.graphics.c.b(this.l, bVarArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class a extends e {
        @Override // androidx.vectordrawable.a.a.i.e
        public boolean a() {
            return true;
        }

        a() {
        }

        a(a aVar) {
            super(aVar);
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (androidx.core.content.b.g.a(xmlPullParser, "pathData")) {
                TypedArray a2 = androidx.core.content.b.g.a(resources, theme, attributeSet, androidx.vectordrawable.a.a.a.f2680d);
                a(a2, xmlPullParser);
                a2.recycle();
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.l = androidx.core.graphics.c.b(string2);
            }
            this.n = androidx.core.content.b.g.a(typedArray, xmlPullParser, "fillType", 2, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends e {

        /* renamed from: a  reason: collision with root package name */
        androidx.core.content.b.b f2702a;

        /* renamed from: b  reason: collision with root package name */
        float f2703b;

        /* renamed from: c  reason: collision with root package name */
        androidx.core.content.b.b f2704c;

        /* renamed from: d  reason: collision with root package name */
        float f2705d;

        /* renamed from: e  reason: collision with root package name */
        float f2706e;
        float f;
        float g;
        float h;
        Paint.Cap i;
        Paint.Join j;
        float k;
        private int[] p;

        b() {
            this.f2703b = 0.0f;
            this.f2705d = 1.0f;
            this.f2706e = 1.0f;
            this.f = 0.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = Paint.Cap.BUTT;
            this.j = Paint.Join.MITER;
            this.k = 4.0f;
        }

        b(b bVar) {
            super(bVar);
            this.f2703b = 0.0f;
            this.f2705d = 1.0f;
            this.f2706e = 1.0f;
            this.f = 0.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = Paint.Cap.BUTT;
            this.j = Paint.Join.MITER;
            this.k = 4.0f;
            this.p = bVar.p;
            this.f2702a = bVar.f2702a;
            this.f2703b = bVar.f2703b;
            this.f2705d = bVar.f2705d;
            this.f2704c = bVar.f2704c;
            this.n = bVar.n;
            this.f2706e = bVar.f2706e;
            this.f = bVar.f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
        }

        private Paint.Cap a(int i, Paint.Cap cap) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? cap : Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        private Paint.Join a(int i, Paint.Join join) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? join : Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = androidx.core.content.b.g.a(resources, theme, attributeSet, androidx.vectordrawable.a.a.a.f2679c);
            a(a2, xmlPullParser, theme);
            a2.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.p = null;
            if (androidx.core.content.b.g.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.m = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.l = androidx.core.graphics.c.b(string2);
                }
                this.f2704c = androidx.core.content.b.g.a(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f2706e = androidx.core.content.b.g.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f2706e);
                this.i = a(androidx.core.content.b.g.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.i);
                this.j = a(androidx.core.content.b.g.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.j);
                this.k = androidx.core.content.b.g.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.k);
                this.f2702a = androidx.core.content.b.g.a(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f2705d = androidx.core.content.b.g.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f2705d);
                this.f2703b = androidx.core.content.b.g.a(typedArray, xmlPullParser, "strokeWidth", 4, this.f2703b);
                this.g = androidx.core.content.b.g.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.g);
                this.h = androidx.core.content.b.g.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.h);
                this.f = androidx.core.content.b.g.a(typedArray, xmlPullParser, "trimPathStart", 5, this.f);
                this.n = androidx.core.content.b.g.a(typedArray, xmlPullParser, "fillType", 13, this.n);
            }
        }

        @Override // androidx.vectordrawable.a.a.i.d
        public boolean b() {
            return this.f2704c.d() || this.f2702a.d();
        }

        @Override // androidx.vectordrawable.a.a.i.d
        public boolean a(int[] iArr) {
            return this.f2702a.a(iArr) | this.f2704c.a(iArr);
        }

        int getStrokeColor() {
            return this.f2702a.b();
        }

        void setStrokeColor(int i) {
            this.f2702a.b(i);
        }

        float getStrokeWidth() {
            return this.f2703b;
        }

        void setStrokeWidth(float f) {
            this.f2703b = f;
        }

        float getStrokeAlpha() {
            return this.f2705d;
        }

        void setStrokeAlpha(float f) {
            this.f2705d = f;
        }

        int getFillColor() {
            return this.f2704c.b();
        }

        void setFillColor(int i) {
            this.f2704c.b(i);
        }

        float getFillAlpha() {
            return this.f2706e;
        }

        void setFillAlpha(float f) {
            this.f2706e = f;
        }

        float getTrimPathStart() {
            return this.f;
        }

        void setTrimPathStart(float f) {
            this.f = f;
        }

        float getTrimPathEnd() {
            return this.g;
        }

        void setTrimPathEnd(float f) {
            this.g = f;
        }

        float getTrimPathOffset() {
            return this.h;
        }

        void setTrimPathOffset(float f) {
            this.h = f;
        }
    }
}
