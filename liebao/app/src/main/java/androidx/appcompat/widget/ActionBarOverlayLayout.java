package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.m;
import androidx.core.h.ae;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements ac, androidx.core.h.o, androidx.core.h.p, androidx.core.h.q {

    /* renamed from: e  reason: collision with root package name */
    static final int[] f836e = {R.attr.actionBarSize, 16842841};
    private androidx.core.h.ae A;
    private a B;
    private OverScroller C;
    private final Runnable D;
    private final Runnable E;
    private final androidx.core.h.r F;

    /* renamed from: a  reason: collision with root package name */
    ActionBarContainer f837a;

    /* renamed from: b  reason: collision with root package name */
    boolean f838b;

    /* renamed from: c  reason: collision with root package name */
    ViewPropertyAnimator f839c;

    /* renamed from: d  reason: collision with root package name */
    final AnimatorListenerAdapter f840d;
    private int f;
    private int g;
    private ContentFrameLayout h;
    private ad i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;

    /* renamed from: q  reason: collision with root package name */
    private final Rect f841q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private final Rect v;
    private final Rect w;
    private androidx.core.h.ae x;
    private androidx.core.h.ae y;
    private androidx.core.h.ae z;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i);

        void g(boolean z);

        void j();

        void k();

        void l();

        void m();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0;
        this.f841q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        this.w = new Rect();
        this.x = androidx.core.h.ae.f1688a;
        this.y = androidx.core.h.ae.f1688a;
        this.z = androidx.core.h.ae.f1688a;
        this.A = androidx.core.h.ae.f1688a;
        this.f840d = new AnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout.this.f839c = null;
                ActionBarOverlayLayout.this.f838b = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout.this.f839c = null;
                ActionBarOverlayLayout.this.f838b = false;
            }
        };
        this.D = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.d();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f839c = actionBarOverlayLayout.f837a.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f840d);
            }
        };
        this.E = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.d();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f839c = actionBarOverlayLayout.f837a.animate().translationY(-ActionBarOverlayLayout.this.f837a.getHeight()).setListener(ActionBarOverlayLayout.this.f840d);
            }
        };
        a(context);
        this.F = new androidx.core.h.r(this);
    }

    private void a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f836e);
        this.f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.j = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.k = context.getApplicationInfo().targetSdkVersion < 19;
        this.C = new OverScroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.B = aVar;
        if (getWindowToken() != null) {
            this.B.a(this.g);
            int i = this.p;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                androidx.core.h.w.r(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.l = z;
        this.k = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public boolean a() {
        return this.l;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.m = z;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        androidx.core.h.w.r(this);
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        c();
        int i2 = this.p ^ i;
        this.p = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        a aVar = this.B;
        if (aVar != null) {
            aVar.g(!z2);
            if (z || !z2) {
                this.B.j();
            } else {
                this.B.k();
            }
        }
        if ((i2 & 256) == 0 || this.B == null) {
            return;
        }
        androidx.core.h.w.r(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.g = i;
        a aVar = this.B;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    private boolean a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        b bVar = (b) view.getLayoutParams();
        if (!z || bVar.leftMargin == rect.left) {
            z5 = false;
        } else {
            bVar.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && bVar.topMargin != rect.top) {
            bVar.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && bVar.rightMargin != rect.right) {
            bVar.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || bVar.bottomMargin == rect.bottom) {
            return z5;
        }
        bVar.bottomMargin = rect.bottom;
        return true;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        c();
        boolean a2 = a(this.f837a, rect, true, true, false, true);
        this.t.set(rect);
        bc.a(this, this.t, this.f841q);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            a2 = true;
        }
        if (!this.r.equals(this.f841q)) {
            this.r.set(this.f841q);
            a2 = true;
        }
        if (a2) {
            requestLayout();
        }
        return true;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        c();
        androidx.core.h.ae a2 = androidx.core.h.ae.a(windowInsets);
        boolean a3 = a(this.f837a, new Rect(a2.a(), a2.b(), a2.c(), a2.d()), true, true, false, true);
        androidx.core.h.w.a(this, a2, this.f841q);
        androidx.core.h.ae b2 = a2.b(this.f841q.left, this.f841q.top, this.f841q.right, this.f841q.bottom);
        this.x = b2;
        boolean z = true;
        if (!this.y.equals(b2)) {
            this.y = this.x;
            a3 = true;
        }
        if (this.r.equals(this.f841q)) {
            z = a3;
        } else {
            this.r.set(this.f841q);
        }
        if (z) {
            requestLayout();
        }
        return a2.i().g().h().k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: b */
    public b generateDefaultLayoutParams() {
        return new b(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: a */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        c();
        measureChildWithMargins(this.f837a, i, 0, i2, 0);
        b bVar = (b) this.f837a.getLayoutParams();
        int max = Math.max(0, this.f837a.getMeasuredWidth() + bVar.leftMargin + bVar.rightMargin);
        int max2 = Math.max(0, this.f837a.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f837a.getMeasuredState());
        boolean z = (androidx.core.h.w.q(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f;
            if (this.m && this.f837a.getTabContainer() != null) {
                measuredHeight += this.f;
            }
        } else {
            measuredHeight = this.f837a.getVisibility() != 8 ? this.f837a.getMeasuredHeight() : 0;
        }
        this.s.set(this.f841q);
        if (Build.VERSION.SDK_INT >= 21) {
            this.z = this.x;
        } else {
            this.v.set(this.t);
        }
        if (!this.l && !z) {
            this.s.top += measuredHeight;
            this.s.bottom += 0;
            if (Build.VERSION.SDK_INT >= 21) {
                this.z = this.z.b(0, measuredHeight, 0, 0);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.z = new ae.a(this.z).a(androidx.core.graphics.b.a(this.z.a(), this.z.b() + measuredHeight, this.z.c(), this.z.d() + 0)).a();
        } else {
            this.v.top += measuredHeight;
            this.v.bottom += 0;
        }
        a(this.h, this.s, true, true, true, true);
        if (Build.VERSION.SDK_INT >= 21 && !this.A.equals(this.z)) {
            androidx.core.h.ae aeVar = this.z;
            this.A = aeVar;
            androidx.core.h.w.b(this.h, aeVar);
        } else if (Build.VERSION.SDK_INT < 21 && !this.w.equals(this.v)) {
            this.w.set(this.v);
            this.h.a(this.v);
        }
        measureChildWithMargins(this.h, i, 0, i2, 0);
        b bVar2 = (b) this.h.getLayoutParams();
        int max3 = Math.max(max, this.h.getMeasuredWidth() + bVar2.leftMargin + bVar2.rightMargin);
        int max4 = Math.max(max2, this.h.getMeasuredHeight() + bVar2.topMargin + bVar2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = bVar.leftMargin + paddingLeft;
                int i7 = bVar.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.j == null || this.k) {
            return;
        }
        int bottom = this.f837a.getVisibility() == 0 ? (int) (this.f837a.getBottom() + this.f837a.getTranslationY() + 0.5f) : 0;
        this.j.setBounds(0, bottom, getWidth(), this.j.getIntrinsicHeight() + bottom);
        this.j.draw(canvas);
    }

    @Override // androidx.core.h.q
    public void a(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScroll(view, i, i2, i3, i4, i5);
    }

    @Override // androidx.core.h.p
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // androidx.core.h.p
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // androidx.core.h.p
    public void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.h.p
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // androidx.core.h.p
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f837a.getVisibility() != 0) {
            return false;
        }
        return this.n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.F.a(view, view2, i);
        this.o = getActionBarHideOffset();
        d();
        a aVar = this.B;
        if (aVar != null) {
            aVar.l();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.o + i2;
        this.o = i5;
        setActionBarHideOffset(i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public void onStopNestedScroll(View view) {
        if (this.n && !this.f838b) {
            if (this.o <= this.f837a.getHeight()) {
                l();
            } else {
                m();
            }
        }
        a aVar = this.B;
        if (aVar != null) {
            aVar.m();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (this.n && z) {
            if (a(f2)) {
                o();
            } else {
                n();
            }
            this.f838b = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.F.a();
    }

    void c() {
        if (this.h == null) {
            this.h = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f837a = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.i = a(findViewById(R.id.action_bar));
        }
    }

    private ad a(View view) {
        if (view instanceof ad) {
            return (ad) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.n) {
            this.n = z;
            if (z) {
                return;
            }
            d();
            setActionBarHideOffset(0);
        }
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f837a;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        d();
        this.f837a.setTranslationY(-Math.max(0, Math.min(i, this.f837a.getHeight())));
    }

    void d() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.f839c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    private void l() {
        d();
        postDelayed(this.D, 600L);
    }

    private void m() {
        d();
        postDelayed(this.E, 600L);
    }

    private void n() {
        d();
        this.D.run();
    }

    private void o() {
        d();
        this.E.run();
    }

    private boolean a(float f) {
        this.C.fling(0, 0, 0, (int) f, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.C.getFinalY() > this.f837a.getHeight();
    }

    @Override // androidx.appcompat.widget.ac
    public void setWindowCallback(Window.Callback callback) {
        c();
        this.i.a(callback);
    }

    @Override // androidx.appcompat.widget.ac
    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.i.a(charSequence);
    }

    public CharSequence getTitle() {
        c();
        return this.i.e();
    }

    @Override // androidx.appcompat.widget.ac
    public void a(int i) {
        c();
        if (i == 2) {
            this.i.f();
        } else if (i == 5) {
            this.i.g();
        } else if (i != 109) {
        } else {
            setOverlayMode(true);
        }
    }

    public void setIcon(int i) {
        c();
        this.i.a(i);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.i.a(drawable);
    }

    public void setLogo(int i) {
        c();
        this.i.b(i);
    }

    @Override // androidx.appcompat.widget.ac
    public boolean e() {
        c();
        return this.i.h();
    }

    @Override // androidx.appcompat.widget.ac
    public boolean f() {
        c();
        return this.i.i();
    }

    @Override // androidx.appcompat.widget.ac
    public boolean g() {
        c();
        return this.i.j();
    }

    @Override // androidx.appcompat.widget.ac
    public boolean h() {
        c();
        return this.i.k();
    }

    @Override // androidx.appcompat.widget.ac
    public boolean i() {
        c();
        return this.i.l();
    }

    @Override // androidx.appcompat.widget.ac
    public void j() {
        c();
        this.i.m();
    }

    @Override // androidx.appcompat.widget.ac
    public void a(Menu menu, m.a aVar) {
        c();
        this.i.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.ac
    public void k() {
        c();
        this.i.n();
    }

    /* loaded from: classes.dex */
    public static class b extends ViewGroup.MarginLayoutParams {
        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
