package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R;
import androidx.core.g.e;
import androidx.core.h.ae;
import androidx.core.h.p;
import androidx.core.h.r;
import androidx.core.h.s;
import androidx.core.h.w;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements p {
    static final Class<?>[] CONSTRUCTOR_PARAMS;
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME;
    static final ThreadLocal<Map<String, Constructor<b>>> sConstructors;
    private static final e.a<Rect> sRectPool;
    private s mApplyWindowInsetsListener;
    private View mBehaviorTouchView;
    private final androidx.coordinatorlayout.widget.a<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private ae mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final r mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private f mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final int[] mTempIntPair;
    private final List<View> mTempList1;

    /* loaded from: classes.dex */
    public interface a {
        b getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface c {
        Class<? extends b> a();
    }

    private static int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static int resolveAnchoredChildGravity(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    private static int resolveGravity(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    private static int resolveKeylineGravity(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        WIDGET_PACKAGE_NAME = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            TOP_SORTED_CHILDREN_COMPARATOR = new h();
        } else {
            TOP_SORTED_CHILDREN_COMPARATOR = null;
        }
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal<>();
        sRectPool = new e.c(12);
    }

    private static Rect acquireTempRect() {
        Rect a2 = sRectPool.a();
        return a2 == null ? new Rect() : a2;
    }

    private static void releaseTempRect(Rect rect) {
        rect.setEmpty();
        sRectPool.a(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new androidx.coordinatorlayout.widget.a<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mTempIntPair = new int[2];
        this.mNestedScrollingParentHelper = new r(this);
        if (i == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr = this.mKeylines;
                iArr[i2] = (int) (iArr[i2] * f2);
            }
        }
        this.mStatusBarBackground = obtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new d());
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && w.s(this)) {
            w.r(this);
        }
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.mIsAttachedToWindow = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.mStatusBarBackground = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.mStatusBarBackground, w.g(this));
                this.mStatusBarBackground.setVisible(getVisibility() == 0, false);
                this.mStatusBarBackground.setCallback(this);
            }
            w.e(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.mStatusBarBackground;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.mStatusBarBackground.setVisible(z, false);
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? androidx.core.content.b.a(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    final ae setWindowInsets(ae aeVar) {
        if (androidx.core.g.c.a(this.mLastInsets, aeVar)) {
            return aeVar;
        }
        this.mLastInsets = aeVar;
        boolean z = true;
        boolean z2 = aeVar != null && aeVar.b() > 0;
        this.mDrawStatusBarBackground = z2;
        setWillNotDraw((z2 || getBackground() != null) ? false : false);
        ae dispatchApplyWindowInsetsToBehaviors = dispatchApplyWindowInsetsToBehaviors(aeVar);
        requestLayout();
        return dispatchApplyWindowInsetsToBehaviors;
    }

    public final ae getLastWindowInsets() {
        return this.mLastInsets;
    }

    private void resetTouchBehaviors(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            b b2 = ((e) childAt.getLayoutParams()).b();
            if (b2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    b2.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    b2.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((e) getChildAt(i2).getLayoutParams()).f();
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private void getTopSortedChildren(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.mTempList1;
        getTopSortedChildren(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            View view = list.get(i2);
            e eVar = (e) view.getLayoutParams();
            b b2 = eVar.b();
            if (!(z || z2) || actionMasked == 0) {
                if (!z && b2 != null) {
                    if (i == 0) {
                        z = b2.onInterceptTouchEvent(this, view, motionEvent);
                    } else if (i == 1) {
                        z = b2.onTouchEvent(this, view, motionEvent);
                    }
                    if (z) {
                        this.mBehaviorTouchView = view;
                    }
                }
                boolean e2 = eVar.e();
                boolean a2 = eVar.a(this, view);
                z2 = a2 && !e2;
                if (a2 && !z2) {
                    break;
                }
            } else if (b2 != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i == 0) {
                    b2.onInterceptTouchEvent(this, view, motionEvent2);
                } else if (i == 1) {
                    b2.onTouchEvent(this, view, motionEvent2);
                }
            }
        }
        list.clear();
        return z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean performIntercept = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            resetTouchBehaviors(true);
        }
        return performIntercept;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean onTouchEvent;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        if (this.mBehaviorTouchView == null) {
            z = performIntercept(motionEvent, 1);
        } else {
            z = false;
        }
        b b2 = ((e) this.mBehaviorTouchView.getLayoutParams()).b();
        if (b2 != null) {
            onTouchEvent = b2.onTouchEvent(this, this.mBehaviorTouchView, motionEvent);
            motionEvent2 = null;
            if (this.mBehaviorTouchView != null) {
                onTouchEvent |= super.onTouchEvent(motionEvent);
            } else if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEvent2);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            if (actionMasked != 1 || actionMasked == 3) {
                resetTouchBehaviors(false);
            }
            return onTouchEvent;
        }
        onTouchEvent = false;
        motionEvent2 = null;
        if (this.mBehaviorTouchView != null) {
        }
        if (motionEvent2 != null) {
        }
        if (actionMasked != 1) {
        }
        resetTouchBehaviors(false);
        return onTouchEvent;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.mDisallowInterceptReset) {
            return;
        }
        resetTouchBehaviors(false);
        this.mDisallowInterceptReset = true;
    }

    private int getKeyline(int i) {
        int[] iArr = this.mKeylines;
        if (iArr == null) {
            Log.e(TAG, "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i < 0 || i >= iArr.length) {
            Log.e(TAG, "Keyline index " + i + " out of range for " + this);
            return 0;
        } else {
            return iArr[i];
        }
    }

    static b parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(WIDGET_PACKAGE_NAME)) {
            str = WIDGET_PACKAGE_NAME + '.' + str;
        }
        try {
            Map<String, Constructor<b>> map = sConstructors.get();
            if (map == null) {
                map = new HashMap<>();
                sConstructors.set(map);
            }
            Constructor<b> constructor = map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (b) constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    e getResolvedLayoutParams(View view) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.f1389b) {
            if (view instanceof a) {
                b behavior = ((a) view).getBehavior();
                if (behavior == null) {
                    Log.e(TAG, "Attached behavior class is null");
                }
                eVar.a(behavior);
                eVar.f1389b = true;
            } else {
                c cVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    cVar = (c) cls.getAnnotation(c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        eVar.a(cVar.a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e(TAG, "Default behavior class " + cVar.a().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                eVar.f1389b = true;
            }
        }
        return eVar;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            e resolvedLayoutParams = getResolvedLayoutParams(childAt);
            resolvedLayoutParams.b(this, childAt);
            this.mChildDag.a((androidx.coordinatorlayout.widget.a<View>) childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (resolvedLayoutParams.a(this, childAt, childAt2)) {
                        if (!this.mChildDag.b(childAt2)) {
                            this.mChildDag.a((androidx.coordinatorlayout.widget.a<View>) childAt2);
                        }
                        this.mChildDag.a(childAt2, childAt);
                    }
                }
            }
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.b());
        Collections.reverse(this.mDependencySortedChildren);
    }

    void getDescendantRect(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.b(this, view, rect);
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public void onMeasureChild(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x011c, code lost:
        if (r0.onMeasureChild(r30, r20, r11, r21, r23, 0) == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        b b2;
        e eVar;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        prepareChildren();
        ensurePreDrawListener();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int g2 = w.g(this);
        boolean z = g2 == 1;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i13 = paddingLeft + paddingRight;
        int i14 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z2 = this.mLastInsets != null && w.s(this);
        int size3 = this.mDependencySortedChildren.size();
        int i15 = suggestedMinimumWidth;
        int i16 = suggestedMinimumHeight;
        int i17 = 0;
        int i18 = 0;
        while (i18 < size3) {
            View view = this.mDependencySortedChildren.get(i18);
            if (view.getVisibility() == 8) {
                i11 = i18;
                i8 = size3;
                i9 = paddingLeft;
            } else {
                e eVar2 = (e) view.getLayoutParams();
                if (eVar2.f1392e < 0 || mode == 0) {
                    i3 = i17;
                } else {
                    int keyline = getKeyline(eVar2.f1392e);
                    int a2 = androidx.core.h.e.a(resolveKeylineGravity(eVar2.f1390c), g2) & 7;
                    i3 = i17;
                    if ((a2 == 3 && !z) || (a2 == 5 && z)) {
                        i4 = Math.max(0, (size - paddingRight) - keyline);
                    } else if ((a2 == 5 && !z) || (a2 == 3 && z)) {
                        i4 = Math.max(0, keyline - paddingLeft);
                    }
                    if (z2 || w.s(view)) {
                        i5 = i;
                        i6 = i2;
                    } else {
                        i5 = View.MeasureSpec.makeMeasureSpec(size - (this.mLastInsets.a() + this.mLastInsets.c()), mode);
                        i6 = View.MeasureSpec.makeMeasureSpec(size2 - (this.mLastInsets.b() + this.mLastInsets.d()), mode2);
                    }
                    b2 = eVar2.b();
                    if (b2 == null) {
                        eVar = eVar2;
                        i10 = i3;
                        i11 = i18;
                        i7 = i16;
                        i9 = paddingLeft;
                        i12 = i15;
                        i8 = size3;
                    } else {
                        eVar = eVar2;
                        i7 = i16;
                        i8 = size3;
                        i9 = paddingLeft;
                        i10 = i3;
                        i11 = i18;
                        i12 = i15;
                    }
                    onMeasureChild(view, i5, i4, i6, 0);
                    e eVar3 = eVar;
                    int max = Math.max(i12, i13 + view.getMeasuredWidth() + eVar3.leftMargin + eVar3.rightMargin);
                    int max2 = Math.max(i7, i14 + view.getMeasuredHeight() + eVar3.topMargin + eVar3.bottomMargin);
                    i17 = View.combineMeasuredStates(i10, view.getMeasuredState());
                    i15 = max;
                    i16 = max2;
                }
                i4 = 0;
                if (z2) {
                }
                i5 = i;
                i6 = i2;
                b2 = eVar2.b();
                if (b2 == null) {
                }
                onMeasureChild(view, i5, i4, i6, 0);
                e eVar32 = eVar;
                int max3 = Math.max(i12, i13 + view.getMeasuredWidth() + eVar32.leftMargin + eVar32.rightMargin);
                int max22 = Math.max(i7, i14 + view.getMeasuredHeight() + eVar32.topMargin + eVar32.bottomMargin);
                i17 = View.combineMeasuredStates(i10, view.getMeasuredState());
                i15 = max3;
                i16 = max22;
            }
            i18 = i11 + 1;
            paddingLeft = i9;
            size3 = i8;
        }
        int i19 = i17;
        setMeasuredDimension(View.resolveSizeAndState(i15, i, (-16777216) & i19), View.resolveSizeAndState(i16, i2, i19 << 16));
    }

    private ae dispatchApplyWindowInsetsToBehaviors(ae aeVar) {
        b b2;
        if (aeVar.f()) {
            return aeVar;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (w.s(childAt) && (b2 = ((e) childAt.getLayoutParams()).b()) != null) {
                aeVar = b2.onApplyWindowInsets(this, childAt, aeVar);
                if (aeVar.f()) {
                    break;
                }
            }
        }
        return aeVar;
    }

    public void onLayoutChild(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (eVar.k != null) {
            layoutChildWithAnchor(view, eVar.k, i);
        } else if (eVar.f1392e >= 0) {
            layoutChildWithKeyline(view, eVar.f1392e, i);
        } else {
            layoutChild(view, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b b2;
        int g2 = w.g(this);
        int size = this.mDependencySortedChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.mDependencySortedChildren.get(i5);
            if (view.getVisibility() != 8 && ((b2 = ((e) view.getLayoutParams()).b()) == null || !b2.onLayoutChild(this, view, g2))) {
                onLayoutChild(view, g2);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mDrawStatusBarBackground || this.mStatusBarBackground == null) {
            return;
        }
        ae aeVar = this.mLastInsets;
        int b2 = aeVar != null ? aeVar.b() : 0;
        if (b2 > 0) {
            this.mStatusBarBackground.setBounds(0, 0, getWidth(), b2);
            this.mStatusBarBackground.draw(canvas);
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    void recordLastChildRect(View view, Rect rect) {
        ((e) view.getLayoutParams()).a(rect);
    }

    void getLastChildRect(View view, Rect rect) {
        rect.set(((e) view.getLayoutParams()).c());
    }

    void getChildRect(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            getDescendantRect(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int i, Rect rect, Rect rect2, e eVar, int i2, int i3) {
        int width;
        int height;
        int a2 = androidx.core.h.e.a(resolveAnchoredChildGravity(eVar.f1390c), i);
        int a3 = androidx.core.h.e.a(resolveGravity(eVar.f1391d), i);
        int i4 = a2 & 7;
        int i5 = a2 & 112;
        int i6 = a3 & 7;
        int i7 = a3 & 112;
        if (i6 == 1) {
            width = rect.left + (rect.width() / 2);
        } else if (i6 != 5) {
            width = rect.left;
        } else {
            width = rect.right;
        }
        if (i7 == 16) {
            height = rect.top + (rect.height() / 2);
        } else if (i7 != 80) {
            height = rect.top;
        } else {
            height = rect.bottom;
        }
        if (i4 == 1) {
            width -= i2 / 2;
        } else if (i4 != 5) {
            width -= i2;
        }
        if (i5 == 16) {
            height -= i3 / 2;
        } else if (i5 != 80) {
            height -= i3;
        }
        rect2.set(width, height, i2 + width, i3 + height);
    }

    private void constrainChildRect(e eVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - eVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - eVar.bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    void getDesiredAnchoredChildRect(View view, int i, Rect rect, Rect rect2) {
        e eVar = (e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(view, i, rect, rect2, eVar, measuredWidth, measuredHeight);
        constrainChildRect(eVar, rect2, measuredWidth, measuredHeight);
    }

    private void layoutChildWithAnchor(View view, View view2, int i) {
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view2, acquireTempRect);
            getDesiredAnchoredChildRect(view, i, acquireTempRect, acquireTempRect2);
            view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    private void layoutChildWithKeyline(View view, int i, int i2) {
        e eVar = (e) view.getLayoutParams();
        int a2 = androidx.core.h.e.a(resolveKeylineGravity(eVar.f1390c), i2);
        int i3 = a2 & 7;
        int i4 = a2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int keyline = getKeyline(i) - measuredWidth;
        int i5 = 0;
        if (i3 == 1) {
            keyline += measuredWidth / 2;
        } else if (i3 == 5) {
            keyline += measuredWidth;
        }
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - eVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - eVar.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void layoutChild(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        Rect acquireTempRect = acquireTempRect();
        acquireTempRect.set(getPaddingLeft() + eVar.leftMargin, getPaddingTop() + eVar.topMargin, (getWidth() - getPaddingRight()) - eVar.rightMargin, (getHeight() - getPaddingBottom()) - eVar.bottomMargin);
        if (this.mLastInsets != null && w.s(this) && !w.s(view)) {
            acquireTempRect.left += this.mLastInsets.a();
            acquireTempRect.top += this.mLastInsets.b();
            acquireTempRect.right -= this.mLastInsets.c();
            acquireTempRect.bottom -= this.mLastInsets.d();
        }
        Rect acquireTempRect2 = acquireTempRect();
        androidx.core.h.e.a(resolveGravity(eVar.f1390c), view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect, acquireTempRect2, i);
        view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.f1388a != null) {
            float scrimOpacity = eVar.f1388a.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(eVar.f1388a.getScrimColor(this, view));
                this.mScrimPaint.setAlpha(clamp(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    final void onChildViewsChanged(int i) {
        boolean z;
        int g2 = w.g(this);
        int size = this.mDependencySortedChildren.size();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        Rect acquireTempRect3 = acquireTempRect();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.mDependencySortedChildren.get(i2);
            e eVar = (e) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (eVar.l == this.mDependencySortedChildren.get(i3)) {
                        offsetChildToAnchor(view, g2);
                    }
                }
                getChildRect(view, true, acquireTempRect2);
                if (eVar.g != 0 && !acquireTempRect2.isEmpty()) {
                    int a2 = androidx.core.h.e.a(eVar.g, g2);
                    int i4 = a2 & 112;
                    if (i4 == 48) {
                        acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                    } else if (i4 == 80) {
                        acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                    }
                    int i5 = a2 & 7;
                    if (i5 == 3) {
                        acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                    } else if (i5 == 5) {
                        acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                    }
                }
                if (eVar.h != 0 && view.getVisibility() == 0) {
                    offsetChildByInset(view, acquireTempRect, g2);
                }
                if (i != 2) {
                    getLastChildRect(view, acquireTempRect3);
                    if (!acquireTempRect3.equals(acquireTempRect2)) {
                        recordLastChildRect(view, acquireTempRect2);
                    }
                }
                for (int i6 = i2 + 1; i6 < size; i6++) {
                    View view2 = this.mDependencySortedChildren.get(i6);
                    e eVar2 = (e) view2.getLayoutParams();
                    b b2 = eVar2.b();
                    if (b2 != null && b2.layoutDependsOn(this, view2, view)) {
                        if (i == 0 && eVar2.g()) {
                            eVar2.h();
                        } else {
                            if (i == 2) {
                                b2.onDependentViewRemoved(this, view2, view);
                                z = true;
                            } else {
                                z = b2.onDependentViewChanged(this, view2, view);
                            }
                            if (i == 1) {
                                eVar2.a(z);
                            }
                        }
                    }
                }
            }
        }
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
        releaseTempRect(acquireTempRect3);
    }

    private void offsetChildByInset(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int height;
        int i3;
        if (w.A(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            e eVar = (e) view.getLayoutParams();
            b b2 = eVar.b();
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            acquireTempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (b2 != null && b2.getInsetDodgeRect(this, view, acquireTempRect)) {
                if (!acquireTempRect2.contains(acquireTempRect)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + acquireTempRect.toShortString() + " | Bounds:" + acquireTempRect2.toShortString());
                }
            } else {
                acquireTempRect.set(acquireTempRect2);
            }
            releaseTempRect(acquireTempRect2);
            if (acquireTempRect.isEmpty()) {
                releaseTempRect(acquireTempRect);
                return;
            }
            int a2 = androidx.core.h.e.a(eVar.h, i);
            boolean z3 = true;
            if ((a2 & 48) != 48 || (i3 = (acquireTempRect.top - eVar.topMargin) - eVar.j) >= rect.top) {
                z = false;
            } else {
                setInsetOffsetY(view, rect.top - i3);
                z = true;
            }
            if ((a2 & 80) == 80 && (height = ((getHeight() - acquireTempRect.bottom) - eVar.bottomMargin) + eVar.j) < rect.bottom) {
                setInsetOffsetY(view, height - rect.bottom);
                z = true;
            }
            if (!z) {
                setInsetOffsetY(view, 0);
            }
            if ((a2 & 3) != 3 || (i2 = (acquireTempRect.left - eVar.leftMargin) - eVar.i) >= rect.left) {
                z2 = false;
            } else {
                setInsetOffsetX(view, rect.left - i2);
                z2 = true;
            }
            if ((a2 & 5) != 5 || (width = ((getWidth() - acquireTempRect.right) - eVar.rightMargin) + eVar.i) >= rect.right) {
                z3 = z2;
            } else {
                setInsetOffsetX(view, width - rect.right);
            }
            if (!z3) {
                setInsetOffsetX(view, 0);
            }
            releaseTempRect(acquireTempRect);
        }
    }

    private void setInsetOffsetX(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.i != i) {
            w.g(view, i - eVar.i);
            eVar.i = i;
        }
    }

    private void setInsetOffsetY(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.j != i) {
            w.f(view, i - eVar.j);
            eVar.j = i;
        }
    }

    public void dispatchDependentViewsChanged(View view) {
        List c2 = this.mChildDag.c(view);
        if (c2 == null || c2.isEmpty()) {
            return;
        }
        for (int i = 0; i < c2.size(); i++) {
            View view2 = (View) c2.get(i);
            b b2 = ((e) view2.getLayoutParams()).b();
            if (b2 != null) {
                b2.onDependentViewChanged(this, view2, view);
            }
        }
    }

    public List<View> getDependencies(View view) {
        List<View> d2 = this.mChildDag.d(view);
        this.mTempDependenciesList.clear();
        if (d2 != null) {
            this.mTempDependenciesList.addAll(d2);
        }
        return this.mTempDependenciesList;
    }

    public List<View> getDependents(View view) {
        List c2 = this.mChildDag.c(view);
        this.mTempDependenciesList.clear();
        if (c2 != null) {
            this.mTempDependenciesList.addAll(c2);
        }
        return this.mTempDependenciesList;
    }

    final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    void ensurePreDrawListener() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (hasDependencies(getChildAt(i))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z != this.mNeedsPreDrawListener) {
            if (z) {
                addPreDrawListener();
            } else {
                removePreDrawListener();
            }
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.e(view);
    }

    void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    void offsetChildToAnchor(View view, int i) {
        b b2;
        e eVar = (e) view.getLayoutParams();
        if (eVar.k != null) {
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            Rect acquireTempRect3 = acquireTempRect();
            getDescendantRect(eVar.k, acquireTempRect);
            boolean z = false;
            getChildRect(view, false, acquireTempRect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            getDesiredAnchoredChildRectWithoutConstraints(view, i, acquireTempRect, acquireTempRect3, eVar, measuredWidth, measuredHeight);
            z = (acquireTempRect3.left == acquireTempRect2.left && acquireTempRect3.top == acquireTempRect2.top) ? true : true;
            constrainChildRect(eVar, acquireTempRect3, measuredWidth, measuredHeight);
            int i2 = acquireTempRect3.left - acquireTempRect2.left;
            int i3 = acquireTempRect3.top - acquireTempRect2.top;
            if (i2 != 0) {
                w.g(view, i2);
            }
            if (i3 != 0) {
                w.f(view, i3);
            }
            if (z && (b2 = eVar.b()) != null) {
                b2.onDependentViewChanged(this, view, eVar.k);
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
            releaseTempRect(acquireTempRect3);
        }
    }

    public boolean isPointInChildBounds(View view, int i, int i2) {
        Rect acquireTempRect = acquireTempRect();
        getDescendantRect(view, acquireTempRect);
        try {
            return acquireTempRect.contains(i, i2);
        } finally {
            releaseTempRect(acquireTempRect);
        }
    }

    public boolean doViewsOverlap(View view, View view2) {
        boolean z = false;
        if (view.getVisibility() == 0 && view2.getVisibility() == 0) {
            Rect acquireTempRect = acquireTempRect();
            getChildRect(view, view.getParent() != this, acquireTempRect);
            Rect acquireTempRect2 = acquireTempRect();
            getChildRect(view2, view2.getParent() != this, acquireTempRect2);
            try {
                if (acquireTempRect.left <= acquireTempRect2.right && acquireTempRect.top <= acquireTempRect2.bottom && acquireTempRect.right >= acquireTempRect2.left) {
                    if (acquireTempRect.bottom >= acquireTempRect2.top) {
                        z = true;
                    }
                }
                return z;
            } finally {
                releaseTempRect(acquireTempRect);
                releaseTempRect(acquireTempRect2);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // androidx.core.h.p
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                b b2 = eVar.b();
                if (b2 != null) {
                    boolean onStartNestedScroll = b2.onStartNestedScroll(this, childAt, view, view2, i, i2);
                    z |= onStartNestedScroll;
                    eVar.a(i2, onStartNestedScroll);
                } else {
                    eVar.a(i2, false);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // androidx.core.h.p
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        b b2;
        this.mNestedScrollingParentHelper.a(view, view2, i, i2);
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.b(i2) && (b2 = eVar.b()) != null) {
                b2.onNestedScrollAccepted(this, childAt, view, view2, i, i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // androidx.core.h.p
    public void onStopNestedScroll(View view, int i) {
        this.mNestedScrollingParentHelper.a(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.b(i)) {
                b b2 = eVar.b();
                if (b2 != null) {
                    b2.onStopNestedScroll(this, childAt, view, i);
                }
                eVar.a(i);
                eVar.h();
            }
        }
        this.mNestedScrollingTarget = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // androidx.core.h.p
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        b b2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b(i5) && (b2 = eVar.b()) != null) {
                    b2.onNestedScroll(this, childAt, view, i, i2, i3, i4, i5);
                    z = true;
                }
            }
        }
        if (z) {
            onChildViewsChanged(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // androidx.core.h.p
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        b b2;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b(i3) && (b2 = eVar.b()) != null) {
                    int[] iArr2 = this.mTempIntPair;
                    iArr2[1] = 0;
                    iArr2[0] = 0;
                    b2.onNestedPreScroll(this, childAt, view, i, i2, iArr2, i3);
                    int[] iArr3 = this.mTempIntPair;
                    i4 = i > 0 ? Math.max(i4, iArr3[0]) : Math.min(i4, iArr3[0]);
                    int[] iArr4 = this.mTempIntPair;
                    i5 = i2 > 0 ? Math.max(i5, iArr4[1]) : Math.min(i5, iArr4[1]);
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        b b2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b(0) && (b2 = eVar.b()) != null) {
                    z2 |= b2.onNestedFling(this, childAt, view, f2, f3, z);
                }
            }
        }
        if (z2) {
            onChildViewsChanged(1);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h.o
    public boolean onNestedPreFling(View view, float f2, float f3) {
        b b2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b(0) && (b2 = eVar.b()) != null) {
                    z |= b2.onNestedPreFling(this, childAt, view, f2, f3);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class h implements Comparator<View> {
        h() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            float B = w.B(view);
            float B2 = w.B(view2);
            if (B > B2) {
                return -1;
            }
            return B < B2 ? 1 : 0;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b<V extends View> {
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public ae onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, ae aeVar) {
            return aeVar;
        }

        public void onAttachedToLayoutParams(e eVar) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public b() {
        }

        public b(Context context, AttributeSet attributeSet) {
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
            return getScrimOpacity(coordinatorLayout, v) > 0.0f;
        }

        public static void setTag(View view, Object obj) {
            ((e) view.getLayoutParams()).n = obj;
        }

        public static Object getTag(View view) {
            return ((e) view.getLayoutParams()).n;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return onStartNestedScroll(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v, view, view2, i);
            }
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                onStopNestedScroll(coordinatorLayout, v, view);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                onNestedScroll(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                onNestedPreScroll(coordinatorLayout, v, view, i, i2, iArr);
            }
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        b f1388a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1389b;

        /* renamed from: c  reason: collision with root package name */
        public int f1390c;

        /* renamed from: d  reason: collision with root package name */
        public int f1391d;

        /* renamed from: e  reason: collision with root package name */
        public int f1392e;
        int f;
        public int g;
        public int h;
        int i;
        int j;
        View k;
        View l;
        final Rect m;
        Object n;
        private boolean o;
        private boolean p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f1393q;
        private boolean r;

        public e(int i, int i2) {
            super(i, i2);
            this.f1389b = false;
            this.f1390c = 0;
            this.f1391d = 0;
            this.f1392e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1389b = false;
            this.f1390c = 0;
            this.f1391d = 0;
            this.f1392e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f1390c = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f1391d = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f1392e = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.g = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.h = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            this.f1389b = hasValue;
            if (hasValue) {
                this.f1388a = CoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            b bVar = this.f1388a;
            if (bVar != null) {
                bVar.onAttachedToLayoutParams(this);
            }
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f1389b = false;
            this.f1390c = 0;
            this.f1391d = 0;
            this.f1392e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1389b = false;
            this.f1390c = 0;
            this.f1391d = 0;
            this.f1392e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1389b = false;
            this.f1390c = 0;
            this.f1391d = 0;
            this.f1392e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        public int a() {
            return this.f;
        }

        public b b() {
            return this.f1388a;
        }

        public void a(b bVar) {
            b bVar2 = this.f1388a;
            if (bVar2 != bVar) {
                if (bVar2 != null) {
                    bVar2.onDetachedFromLayoutParams();
                }
                this.f1388a = bVar;
                this.n = null;
                this.f1389b = true;
                if (bVar != null) {
                    bVar.onAttachedToLayoutParams(this);
                }
            }
        }

        void a(Rect rect) {
            this.m.set(rect);
        }

        Rect c() {
            return this.m;
        }

        boolean d() {
            return this.k == null && this.f != -1;
        }

        boolean e() {
            if (this.f1388a == null) {
                this.o = false;
            }
            return this.o;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.o;
            if (z) {
                return true;
            }
            b bVar = this.f1388a;
            boolean blocksInteractionBelow = (bVar != null ? bVar.blocksInteractionBelow(coordinatorLayout, view) : false) | z;
            this.o = blocksInteractionBelow;
            return blocksInteractionBelow;
        }

        void f() {
            this.o = false;
        }

        void a(int i) {
            a(i, false);
        }

        void a(int i, boolean z) {
            if (i == 0) {
                this.p = z;
            } else if (i != 1) {
            } else {
                this.f1393q = z;
            }
        }

        boolean b(int i) {
            if (i != 0) {
                if (i != 1) {
                    return false;
                }
                return this.f1393q;
            }
            return this.p;
        }

        boolean g() {
            return this.r;
        }

        void a(boolean z) {
            this.r = z;
        }

        void h() {
            this.r = false;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            b bVar;
            return view2 == this.l || a(view2, w.g(coordinatorLayout)) || ((bVar = this.f1388a) != null && bVar.layoutDependsOn(coordinatorLayout, view, view2));
        }

        View b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.k;
        }

        private void a(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f);
            this.k = findViewById;
            if (findViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f) + " to anchor view " + view);
            } else if (findViewById == coordinatorLayout) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            } else {
                for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.l = null;
                            this.k = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (parent instanceof View) {
                        findViewById = (View) parent;
                    }
                }
                this.l = findViewById;
            }
        }

        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f) {
                return false;
            }
            View view2 = this.k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.l = null;
                    this.k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.l = view2;
            return true;
        }

        private boolean a(View view, int i) {
            int a2 = androidx.core.h.e.a(((e) view.getLayoutParams()).g, i);
            return a2 != 0 && (androidx.core.h.e.a(this.h, i) & a2) == a2;
        }
    }

    /* loaded from: classes.dex */
    private class d implements ViewGroup.OnHierarchyChangeListener {
        d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        SparseArray<Parcelable> sparseArray = gVar.f1395a;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            b b2 = getResolvedLayoutParams(childAt).b();
            if (id != -1 && b2 != null && (parcelable2 = sparseArray.get(id)) != null) {
                b2.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        g gVar = new g(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            b b2 = ((e) childAt.getLayoutParams()).b();
            if (id != -1 && b2 != null && (onSaveInstanceState = b2.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id, onSaveInstanceState);
            }
        }
        gVar.f1395a = sparseArray;
        return gVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        b b2 = ((e) view.getLayoutParams()).b();
        if (b2 == null || !b2.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void setupForInsets() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (w.s(this)) {
            if (this.mApplyWindowInsetsListener == null) {
                this.mApplyWindowInsetsListener = new s() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.1
                    @Override // androidx.core.h.s
                    public ae onApplyWindowInsets(View view, ae aeVar) {
                        return CoordinatorLayout.this.setWindowInsets(aeVar);
                    }
                };
            }
            w.a(this, this.mApplyWindowInsetsListener);
            setSystemUiVisibility(1280);
            return;
        }
        w.a(this, (s) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class g extends androidx.customview.a.a {
        public static final Parcelable.Creator<g> CREATOR = new Parcelable.ClassLoaderCreator<g>() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.g.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public g[] newArray(int i) {
                return new g[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        SparseArray<Parcelable> f1395a;

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f1395a = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f1395a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.f1395a;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f1395a.keyAt(i2);
                parcelableArr[i2] = this.f1395a.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }
}
