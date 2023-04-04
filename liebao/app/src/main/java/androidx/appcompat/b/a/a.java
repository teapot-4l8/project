package androidx.appcompat.b.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.b.a.b;
import androidx.appcompat.b.a.d;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.am;
import androidx.b.h;
import androidx.core.content.b.g;
import androidx.vectordrawable.a.a.i;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedStateListDrawableCompat.java */
/* loaded from: classes.dex */
public class a extends androidx.appcompat.b.a.d implements androidx.core.graphics.drawable.e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f664a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private b f665b;

    /* renamed from: c  reason: collision with root package name */
    private f f666c;

    /* renamed from: d  reason: collision with root package name */
    private int f667d;

    /* renamed from: e  reason: collision with root package name */
    private int f668e;
    private boolean f;

    @Override // androidx.appcompat.b.a.d, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.b.a.d, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public a() {
        this(null, null);
    }

    a(b bVar, Resources resources) {
        super(null);
        this.f667d = -1;
        this.f668e = -1;
        a(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static a a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        a aVar = new a();
        aVar.b(context, resources, xmlPullParser, attributeSet, theme);
        return aVar;
    }

    @Override // androidx.appcompat.b.a.d
    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(a2.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        c(context, resources, xmlPullParser, attributeSet, theme);
        e();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.f666c != null && (visible || z2)) {
            if (z) {
                this.f666c.a();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        f fVar = this.f666c;
        if (fVar != null) {
            fVar.b();
            this.f666c = null;
            a(this.f667d);
            this.f667d = -1;
            this.f668e = -1;
        }
    }

    @Override // androidx.appcompat.b.a.d, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int a2 = this.f665b.a(iArr);
        boolean z = a2 != d() && (b(a2) || a(a2));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    private boolean b(int i) {
        int d2;
        int a2;
        f c0022a;
        f fVar = this.f666c;
        if (fVar != null) {
            if (i == this.f667d) {
                return true;
            }
            if (i == this.f668e && fVar.c()) {
                fVar.d();
                this.f667d = this.f668e;
                this.f668e = i;
                return true;
            }
            d2 = this.f667d;
            fVar.b();
        } else {
            d2 = d();
        }
        this.f666c = null;
        this.f668e = -1;
        this.f667d = -1;
        b bVar = this.f665b;
        int a3 = bVar.a(d2);
        int a4 = bVar.a(i);
        if (a4 == 0 || a3 == 0 || (a2 = bVar.a(a3, a4)) < 0) {
            return false;
        }
        boolean c2 = bVar.c(a3, a4);
        a(a2);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            c0022a = new d((AnimationDrawable) current, bVar.b(a3, a4), c2);
        } else if (current instanceof androidx.vectordrawable.a.a.c) {
            c0022a = new c((androidx.vectordrawable.a.a.c) current);
        } else {
            if (current instanceof Animatable) {
                c0022a = new C0022a((Animatable) current);
            }
            return false;
        }
        c0022a.a();
        this.f666c = c0022a;
        this.f668e = d2;
        this.f667d = i;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class f {
        public abstract void a();

        public abstract void b();

        public boolean c() {
            return false;
        }

        public void d() {
        }

        private f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0022a extends f {

        /* renamed from: a  reason: collision with root package name */
        private final Animatable f669a;

        C0022a(Animatable animatable) {
            super();
            this.f669a = animatable;
        }

        @Override // androidx.appcompat.b.a.a.f
        public void a() {
            this.f669a.start();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void b() {
            this.f669a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class d extends f {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectAnimator f673a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f674b;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration(eVar.a());
            ofInt.setInterpolator(eVar);
            this.f674b = z2;
            this.f673a = ofInt;
        }

        @Override // androidx.appcompat.b.a.a.f
        public boolean c() {
            return this.f674b;
        }

        @Override // androidx.appcompat.b.a.a.f
        public void a() {
            this.f673a.start();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void d() {
            this.f673a.reverse();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void b() {
            this.f673a.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.vectordrawable.a.a.c f672a;

        c(androidx.vectordrawable.a.a.c cVar) {
            super();
            this.f672a = cVar;
        }

        @Override // androidx.appcompat.b.a.a.f
        public void a() {
            this.f672a.start();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void b() {
            this.f672a.stop();
        }
    }

    private void a(TypedArray typedArray) {
        b bVar = this.f665b;
        if (Build.VERSION.SDK_INT >= 21) {
            bVar.f |= typedArray.getChangingConfigurations();
        }
        bVar.a(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, bVar.k));
        bVar.b(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, bVar.n));
        bVar.c(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.C));
        bVar.d(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.D));
        setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, bVar.z));
    }

    private void e() {
        onStateChange(getState());
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    e(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    d(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private int d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = a2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = a2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = a2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable a3 = resourceId3 > 0 ? am.a().a(context, resourceId3) : null;
        boolean z = a2.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        a2.recycle();
        if (a3 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                a3 = androidx.vectordrawable.a.a.c.a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (a3 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId == -1 || resourceId2 == -1) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        } else {
            return this.f665b.a(resourceId, resourceId2, a3, z);
        }
    }

    private int e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
        int resourceId = a2.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = a2.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable a3 = resourceId2 > 0 ? am.a().a(context, resourceId2) : null;
        a2.recycle();
        int[] a4 = a(attributeSet);
        if (a3 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("vector")) {
                a3 = i.a(resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (a3 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        return this.f665b.a(a4, a3, resourceId);
    }

    @Override // androidx.appcompat.b.a.d, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f && super.mutate() == this) {
            this.f665b.a();
            this.f = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b.a.d, androidx.appcompat.b.a.b
    /* renamed from: a */
    public b c() {
        return new b(this.f665b, this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends d.a {

        /* renamed from: a  reason: collision with root package name */
        androidx.b.d<Long> f670a;

        /* renamed from: b  reason: collision with root package name */
        h<Integer> f671b;

        private static long f(int i, int i2) {
            return i2 | (i << 32);
        }

        b(b bVar, a aVar, Resources resources) {
            super(bVar, aVar, resources);
            if (bVar != null) {
                this.f670a = bVar.f670a;
                this.f671b = bVar.f671b;
                return;
            }
            this.f670a = new androidx.b.d<>();
            this.f671b = new h<>();
        }

        @Override // androidx.appcompat.b.a.d.a, androidx.appcompat.b.a.b.AbstractC0023b
        void a() {
            this.f670a = this.f670a.clone();
            this.f671b = this.f671b.clone();
        }

        int a(int i, int i2, Drawable drawable, boolean z) {
            int a2 = super.a(drawable);
            long f = f(i, i2);
            long j = z ? 8589934592L : 0L;
            long j2 = a2;
            this.f670a.c(f, Long.valueOf(j2 | j));
            if (z) {
                this.f670a.c(f(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return a2;
        }

        int a(int[] iArr, Drawable drawable, int i) {
            int a2 = super.a(iArr, drawable);
            this.f671b.b(a2, Integer.valueOf(i));
            return a2;
        }

        int a(int[] iArr) {
            int b2 = super.b(iArr);
            return b2 >= 0 ? b2 : super.b(StateSet.WILD_CARD);
        }

        int a(int i) {
            if (i < 0) {
                return 0;
            }
            return this.f671b.a(i, 0).intValue();
        }

        int a(int i, int i2) {
            return (int) this.f670a.a(f(i, i2), -1L).longValue();
        }

        boolean b(int i, int i2) {
            return (this.f670a.a(f(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        boolean c(int i, int i2) {
            return (this.f670a.a(f(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // androidx.appcompat.b.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // androidx.appcompat.b.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    @Override // androidx.appcompat.b.a.d, androidx.appcompat.b.a.b
    void a(b.AbstractC0023b abstractC0023b) {
        super.a(abstractC0023b);
        if (abstractC0023b instanceof b) {
            this.f665b = (b) abstractC0023b;
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    private static class e implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        private int[] f675a;

        /* renamed from: b  reason: collision with root package name */
        private int f676b;

        /* renamed from: c  reason: collision with root package name */
        private int f677c;

        e(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f676b = numberOfFrames;
            int[] iArr = this.f675a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f675a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f675a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.f677c = i;
            return i;
        }

        int a() {
            return this.f677c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.f677c) + 0.5f);
            int i2 = this.f676b;
            int[] iArr = this.f675a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.f677c : 0.0f);
        }
    }
}
