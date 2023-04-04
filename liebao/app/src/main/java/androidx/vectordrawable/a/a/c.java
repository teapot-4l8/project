package androidx.vectordrawable.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AnimatedVectorDrawableCompat.java */
/* loaded from: classes.dex */
public class c extends h implements androidx.vectordrawable.a.a.b {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<Object> f2682a;

    /* renamed from: b  reason: collision with root package name */
    final Drawable.Callback f2683b;

    /* renamed from: d  reason: collision with root package name */
    private a f2684d;

    /* renamed from: e  reason: collision with root package name */
    private Context f2685e;
    private ArgbEvaluator f;
    private Animator.AnimatorListener g;

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
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    c() {
        this(null, null, null);
    }

    private c(Context context) {
        this(context, null, null);
    }

    private c(Context context, a aVar, Resources resources) {
        this.f = null;
        this.g = null;
        this.f2682a = null;
        this.f2683b = new Drawable.Callback() { // from class: androidx.vectordrawable.a.a.c.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                c.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                c.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                c.this.unscheduleSelf(runnable);
            }
        };
        this.f2685e = context;
        if (aVar != null) {
            this.f2684d = aVar;
        } else {
            this.f2684d = new a(context, aVar, this.f2683b, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.f2697c != null) {
            this.f2697c.mutate();
        }
        return this;
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f2697c == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(this.f2697c.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        if (this.f2697c != null) {
            return this.f2697c.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f2684d.f2687a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f2697c != null) {
            this.f2697c.draw(canvas);
            return;
        }
        this.f2684d.f2688b.draw(canvas);
        if (this.f2684d.f2689c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f2697c != null) {
            this.f2697c.setBounds(rect);
        } else {
            this.f2684d.f2688b.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.f2697c != null) {
            return this.f2697c.setState(iArr);
        }
        return this.f2684d.f2688b.setState(iArr);
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (this.f2697c != null) {
            return this.f2697c.setLevel(i);
        }
        return this.f2684d.f2688b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        if (this.f2697c != null) {
            return androidx.core.graphics.drawable.a.c(this.f2697c);
        }
        return this.f2684d.f2688b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f2697c != null) {
            this.f2697c.setAlpha(i);
        } else {
            this.f2684d.f2688b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f2697c != null) {
            this.f2697c.setColorFilter(colorFilter);
        } else {
            this.f2684d.f2688b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        if (this.f2697c != null) {
            return androidx.core.graphics.drawable.a.e(this.f2697c);
        }
        return this.f2684d.f2688b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public void setTint(int i) {
        if (this.f2697c != null) {
            androidx.core.graphics.drawable.a.a(this.f2697c, i);
        } else {
            this.f2684d.f2688b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public void setTintList(ColorStateList colorStateList) {
        if (this.f2697c != null) {
            androidx.core.graphics.drawable.a.a(this.f2697c, colorStateList);
        } else {
            this.f2684d.f2688b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f2697c != null) {
            androidx.core.graphics.drawable.a.a(this.f2697c, mode);
        } else {
            this.f2684d.f2688b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.f2697c != null) {
            return this.f2697c.setVisible(z, z2);
        }
        this.f2684d.f2688b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.f2697c != null) {
            return this.f2697c.isStateful();
        }
        return this.f2684d.f2688b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f2697c != null) {
            return this.f2697c.getOpacity();
        }
        return this.f2684d.f2688b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f2697c != null) {
            return this.f2697c.getIntrinsicWidth();
        }
        return this.f2684d.f2688b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f2697c != null) {
            return this.f2697c.getIntrinsicHeight();
        }
        return this.f2684d.f2688b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        if (this.f2697c != null) {
            return androidx.core.graphics.drawable.a.b(this.f2697c);
        }
        return this.f2684d.f2688b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f2697c != null) {
            androidx.core.graphics.drawable.a.a(this.f2697c, z);
        } else {
            this.f2684d.f2688b.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.f2697c != null) {
            androidx.core.graphics.drawable.a.a(this.f2697c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a2 = androidx.core.content.b.g.a(resources, theme, attributeSet, androidx.vectordrawable.a.a.a.f2681e);
                    int resourceId = a2.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i a3 = i.a(resources, resourceId, theme);
                        a3.a(false);
                        a3.setCallback(this.f2683b);
                        if (this.f2684d.f2688b != null) {
                            this.f2684d.f2688b.setCallback(null);
                        }
                        this.f2684d.f2688b = a3;
                    }
                    a2.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.a.a.a.f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f2685e;
                        if (context != null) {
                            a(string, e.a(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f2684d.a();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // androidx.vectordrawable.a.a.h, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        if (this.f2697c != null) {
            androidx.core.graphics.drawable.a.a(this.f2697c, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f2697c != null) {
            return androidx.core.graphics.drawable.a.d(this.f2697c);
        }
        return false;
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* loaded from: classes.dex */
    private static class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f2692a;

        public b(Drawable.ConstantState constantState) {
            this.f2692a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            c cVar = new c();
            cVar.f2697c = this.f2692a.newDrawable();
            cVar.f2697c.setCallback(cVar.f2683b);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            cVar.f2697c = this.f2692a.newDrawable(resources);
            cVar.f2697c.setCallback(cVar.f2683b);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            cVar.f2697c = this.f2692a.newDrawable(resources, theme);
            cVar.f2697c.setCallback(cVar.f2683b);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f2692a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2692a.getChangingConfigurations();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f2687a;

        /* renamed from: b  reason: collision with root package name */
        i f2688b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f2689c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Animator> f2690d;

        /* renamed from: e  reason: collision with root package name */
        androidx.b.a<Animator, String> f2691e;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.f2687a = aVar.f2687a;
                i iVar = aVar.f2688b;
                if (iVar != null) {
                    Drawable.ConstantState constantState = iVar.getConstantState();
                    if (resources != null) {
                        this.f2688b = (i) constantState.newDrawable(resources);
                    } else {
                        this.f2688b = (i) constantState.newDrawable();
                    }
                    i iVar2 = (i) this.f2688b.mutate();
                    this.f2688b = iVar2;
                    iVar2.setCallback(callback);
                    this.f2688b.setBounds(aVar.f2688b.getBounds());
                    this.f2688b.a(false);
                }
                ArrayList<Animator> arrayList = aVar.f2690d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f2690d = new ArrayList<>(size);
                    this.f2691e = new androidx.b.a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.f2690d.get(i);
                        Animator clone = animator.clone();
                        String str = aVar.f2691e.get(animator);
                        clone.setTarget(this.f2688b.a(str));
                        this.f2690d.add(clone);
                        this.f2691e.put(clone, str);
                    }
                    a();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2687a;
        }

        public void a() {
            if (this.f2689c == null) {
                this.f2689c = new AnimatorSet();
            }
            this.f2689c.playTogether(this.f2690d);
        }
    }

    private void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                a(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f == null) {
                    this.f = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.f2684d.f2688b.a(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        if (this.f2684d.f2690d == null) {
            this.f2684d.f2690d = new ArrayList<>();
            this.f2684d.f2691e = new androidx.b.a<>();
        }
        this.f2684d.f2690d.add(animator);
        this.f2684d.f2691e.put(animator, str);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        if (this.f2697c != null) {
            return ((AnimatedVectorDrawable) this.f2697c).isRunning();
        }
        return this.f2684d.f2689c.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f2697c != null) {
            ((AnimatedVectorDrawable) this.f2697c).start();
        } else if (this.f2684d.f2689c.isStarted()) {
        } else {
            this.f2684d.f2689c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f2697c != null) {
            ((AnimatedVectorDrawable) this.f2697c).stop();
        } else {
            this.f2684d.f2689c.end();
        }
    }
}
