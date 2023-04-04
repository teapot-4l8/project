package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.h.ae;
import androidx.core.h.s;
import androidx.core.h.w;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private int mActivePointerId;
    androidx.viewpager.widget.a mAdapter;
    private List<e> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private f mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<b> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private h mObserver;
    private int mOffscreenPageLimit;
    private f mOnPageChangeListener;
    private List<f> mOnPageChangeListeners;
    private int mPageMargin;
    private g mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final b mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    static final int[] LAYOUT_ATTRS = {16842931};
    private static final Comparator<b> COMPARATOR = new Comparator<b>() { // from class: androidx.viewpager.widget.ViewPager.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar.f2734b - bVar2.f2734b;
        }
    };
    private static final Interpolator sInterpolator = new Interpolator() { // from class: androidx.viewpager.widget.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final k sPositionComparator = new k();

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface a {
    }

    /* loaded from: classes.dex */
    public interface e {
        void onAdapterChanged(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    /* loaded from: classes.dex */
    public interface f {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(View view, float f);
    }

    /* loaded from: classes.dex */
    public static class j implements f {
        @Override // androidx.viewpager.widget.ViewPager.f
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.f
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.f
        public void onPageSelected(int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        Object f2733a;

        /* renamed from: b  reason: collision with root package name */
        int f2734b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2735c;

        /* renamed from: d  reason: collision with root package name */
        float f2736d;

        /* renamed from: e  reason: collision with root package name */
        float f2737e;

        b() {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.mItems = new ArrayList<>();
        this.mTempItem = new b();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: androidx.viewpager.widget.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItems = new ArrayList<>();
        this.mTempItem = new b();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: androidx.viewpager.widget.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f2);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f2);
        this.mCloseEnough = (int) (2.0f * f2);
        this.mDefaultGutterSize = (int) (f2 * 16.0f);
        w.a(this, new d());
        if (w.f(this) == 0) {
            w.b((View) this, 1);
        }
        w.a(this, new s() { // from class: androidx.viewpager.widget.ViewPager.4

            /* renamed from: b  reason: collision with root package name */
            private final Rect f2732b = new Rect();

            @Override // androidx.core.h.s
            public ae onApplyWindowInsets(View view, ae aeVar) {
                ae a2 = w.a(view, aeVar);
                if (a2.f()) {
                    return a2;
                }
                Rect rect = this.f2732b;
                rect.left = a2.a();
                rect.top = a2.b();
                rect.right = a2.c();
                rect.bottom = a2.d();
                int childCount = ViewPager.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    ae b2 = w.b(ViewPager.this.getChildAt(i2), a2);
                    rect.left = Math.min(b2.a(), rect.left);
                    rect.top = Math.min(b2.b(), rect.top);
                    rect.right = Math.min(b2.c(), rect.right);
                    rect.bottom = Math.min(b2.d(), rect.bottom);
                }
                return a2.a(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i2) {
        if (this.mScrollState == i2) {
            return;
        }
        this.mScrollState = i2;
        if (this.mPageTransformer != null) {
            enableLayers(i2 != 0);
        }
        dispatchOnScrollStateChanged(i2);
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
        androidx.viewpager.widget.a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.c((DataSetObserver) null);
            this.mAdapter.a((ViewGroup) this);
            for (int i2 = 0; i2 < this.mItems.size(); i2++) {
                b bVar = this.mItems.get(i2);
                this.mAdapter.a((ViewGroup) this, bVar.f2734b, bVar.f2733a);
            }
            this.mAdapter.b((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        this.mExpectedAdapterCount = 0;
        if (aVar != null) {
            if (this.mObserver == null) {
                this.mObserver = new h();
            }
            this.mAdapter.c(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.b();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.a(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!z) {
                populate();
            } else {
                requestLayout();
            }
        }
        List<e> list = this.mAdapterChangeListeners;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.mAdapterChangeListeners.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mAdapterChangeListeners.get(i3).onAdapterChanged(this, aVar3, aVar);
        }
    }

    private void removeNonDecorViews() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((c) getChildAt(i2).getLayoutParams()).f2738a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.mAdapter;
    }

    public void addOnAdapterChangeListener(e eVar) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(eVar);
    }

    public void removeOnAdapterChangeListener(e eVar) {
        List<e> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(eVar);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i2) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, !this.mFirstLayout, false);
    }

    public void setCurrentItem(int i2, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, z, false);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    void setCurrentItemInternal(int i2, boolean z, boolean z2) {
        setCurrentItemInternal(i2, z, z2, 0);
    }

    void setCurrentItemInternal(int i2, boolean z, boolean z2, int i3) {
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar == null || aVar.b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (!z2 && this.mCurItem == i2 && this.mItems.size() != 0) {
            setScrollingCacheEnabled(false);
        } else {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.mAdapter.b()) {
                i2 = this.mAdapter.b() - 1;
            }
            int i4 = this.mOffscreenPageLimit;
            int i5 = this.mCurItem;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.mItems.size(); i6++) {
                    this.mItems.get(i6).f2735c = true;
                }
            }
            boolean z3 = this.mCurItem != i2;
            if (this.mFirstLayout) {
                this.mCurItem = i2;
                if (z3) {
                    dispatchOnPageSelected(i2);
                }
                requestLayout();
                return;
            }
            populate(i2);
            scrollToItem(i2, z, i3, z3);
        }
    }

    private void scrollToItem(int i2, boolean z, int i3, boolean z2) {
        b infoForPosition = infoForPosition(i2);
        int clientWidth = infoForPosition != null ? (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(infoForPosition.f2737e, this.mLastOffset))) : 0;
        if (z) {
            smoothScrollTo(clientWidth, 0, i3);
            if (z2) {
                dispatchOnPageSelected(i2);
                return;
            }
            return;
        }
        if (z2) {
            dispatchOnPageSelected(i2);
        }
        completeScroll(false);
        scrollTo(clientWidth, 0);
        pageScrolled(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(f fVar) {
        this.mOnPageChangeListener = fVar;
    }

    public void addOnPageChangeListener(f fVar) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(fVar);
    }

    public void removeOnPageChangeListener(f fVar) {
        List<f> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(fVar);
        }
    }

    public void clearOnPageChangeListeners() {
        List<f> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void setPageTransformer(boolean z, g gVar) {
        setPageTransformer(z, gVar, 2);
    }

    public void setPageTransformer(boolean z, g gVar, int i2) {
        boolean z2 = gVar != null;
        boolean z3 = z2 != (this.mPageTransformer != null);
        this.mPageTransformer = gVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.mDrawingOrder = z ? 2 : 1;
            this.mPageTransformerLayerType = i2;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z3) {
            populate();
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.mDrawingOrder == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((c) this.mDrawingOrderedChildren.get(i3).getLayoutParams()).f;
    }

    f setInternalPageChangeListener(f fVar) {
        f fVar2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = fVar;
        return fVar2;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i2;
            populate();
        }
    }

    public void setPageMargin(int i2) {
        int i3 = this.mPageMargin;
        this.mPageMargin = i2;
        int width = getWidth();
        recomputeScrollPosition(width, width, i2, i3);
        requestLayout();
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(androidx.core.content.b.a(getContext(), i2));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    float distanceInfluenceForSnapDuration(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    void smoothScrollTo(int i2, int i3) {
        smoothScrollTo(i2, i3, 0);
    }

    void smoothScrollTo(int i2, int i3, int i4) {
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float distanceInfluenceForSnapDuration = f3 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int abs2 = Math.abs(i4);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i6) / ((f2 * this.mAdapter.d(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i5, scrollY, i6, i7, min);
        w.e(this);
    }

    b addNewItem(int i2, int i3) {
        b bVar = new b();
        bVar.f2734b = i2;
        bVar.f2733a = this.mAdapter.a((ViewGroup) this, i2);
        bVar.f2736d = this.mAdapter.d(i2);
        if (i3 < 0 || i3 >= this.mItems.size()) {
            this.mItems.add(bVar);
        } else {
            this.mItems.add(i3, bVar);
        }
        return bVar;
    }

    void dataSetChanged() {
        int b2 = this.mAdapter.b();
        this.mExpectedAdapterCount = b2;
        boolean z = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < b2;
        int i2 = this.mCurItem;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < this.mItems.size()) {
            b bVar = this.mItems.get(i3);
            int a2 = this.mAdapter.a(bVar.f2733a);
            if (a2 != -1) {
                if (a2 == -2) {
                    this.mItems.remove(i3);
                    i3--;
                    if (!z2) {
                        this.mAdapter.a((ViewGroup) this);
                        z2 = true;
                    }
                    this.mAdapter.a((ViewGroup) this, bVar.f2734b, bVar.f2733a);
                    if (this.mCurItem == bVar.f2734b) {
                        i2 = Math.max(0, Math.min(this.mCurItem, b2 - 1));
                    }
                } else if (bVar.f2734b != a2) {
                    if (bVar.f2734b == this.mCurItem) {
                        i2 = a2;
                    }
                    bVar.f2734b = a2;
                }
                z = true;
            }
            i3++;
        }
        if (z2) {
            this.mAdapter.b((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                c cVar = (c) getChildAt(i4).getLayoutParams();
                if (!cVar.f2738a) {
                    cVar.f2740c = 0.0f;
                }
            }
            setCurrentItemInternal(i2, false, true);
            requestLayout();
        }
    }

    void populate() {
        populate(this.mCurItem);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
        if (r8.f2734b == r17.mCurItem) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
        r8 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void populate(int i2) {
        b bVar;
        String hexString;
        b bVar2;
        b infoForChild;
        b bVar3;
        int i3 = this.mCurItem;
        if (i3 != i2) {
            bVar = infoForPosition(i3);
            this.mCurItem = i2;
        } else {
            bVar = null;
        }
        if (this.mAdapter == null) {
            sortChildDrawingOrder();
        } else if (this.mPopulatePending) {
            sortChildDrawingOrder();
        } else if (getWindowToken() != null) {
            this.mAdapter.a((ViewGroup) this);
            int i4 = this.mOffscreenPageLimit;
            int max = Math.max(0, this.mCurItem - i4);
            int b2 = this.mAdapter.b();
            int min = Math.min(b2 - 1, this.mCurItem + i4);
            if (b2 != this.mExpectedAdapterCount) {
                try {
                    hexString = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException unused) {
                    hexString = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + b2 + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
            }
            int i5 = 0;
            while (true) {
                if (i5 >= this.mItems.size()) {
                    break;
                }
                bVar2 = this.mItems.get(i5);
                if (bVar2.f2734b < this.mCurItem) {
                    i5++;
                }
            }
            if (bVar2 == null && b2 > 0) {
                bVar2 = addNewItem(this.mCurItem, i5);
            }
            if (bVar2 != null) {
                int i6 = i5 - 1;
                b bVar4 = i6 >= 0 ? this.mItems.get(i6) : null;
                int clientWidth = getClientWidth();
                float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - bVar2.f2736d) + (getPaddingLeft() / clientWidth);
                float f2 = 0.0f;
                for (int i7 = this.mCurItem - 1; i7 >= 0; i7--) {
                    if (f2 < paddingLeft || i7 >= max) {
                        if (bVar4 != null && i7 == bVar4.f2734b) {
                            f2 += bVar4.f2736d;
                            i6--;
                            if (i6 >= 0) {
                                bVar3 = this.mItems.get(i6);
                                bVar4 = bVar3;
                            }
                            bVar3 = null;
                            bVar4 = bVar3;
                        } else {
                            f2 += addNewItem(i7, i6 + 1).f2736d;
                            i5++;
                            if (i6 >= 0) {
                                bVar3 = this.mItems.get(i6);
                                bVar4 = bVar3;
                            }
                            bVar3 = null;
                            bVar4 = bVar3;
                        }
                    } else if (bVar4 == null) {
                        break;
                    } else {
                        if (i7 == bVar4.f2734b && !bVar4.f2735c) {
                            this.mItems.remove(i6);
                            this.mAdapter.a((ViewGroup) this, i7, bVar4.f2733a);
                            i6--;
                            i5--;
                            if (i6 >= 0) {
                                bVar3 = this.mItems.get(i6);
                                bVar4 = bVar3;
                            }
                            bVar3 = null;
                            bVar4 = bVar3;
                        }
                    }
                }
                float f3 = bVar2.f2736d;
                int i8 = i5 + 1;
                if (f3 < 2.0f) {
                    b bVar5 = i8 < this.mItems.size() ? this.mItems.get(i8) : null;
                    float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                    int i9 = this.mCurItem;
                    while (true) {
                        i9++;
                        if (i9 >= b2) {
                            break;
                        } else if (f3 < paddingRight || i9 <= min) {
                            if (bVar5 != null && i9 == bVar5.f2734b) {
                                f3 += bVar5.f2736d;
                                i8++;
                                if (i8 < this.mItems.size()) {
                                    bVar5 = this.mItems.get(i8);
                                }
                            } else {
                                b addNewItem = addNewItem(i9, i8);
                                i8++;
                                f3 += addNewItem.f2736d;
                                bVar5 = i8 < this.mItems.size() ? this.mItems.get(i8) : null;
                            }
                        } else if (bVar5 == null) {
                            break;
                        } else if (i9 == bVar5.f2734b && !bVar5.f2735c) {
                            this.mItems.remove(i8);
                            this.mAdapter.a((ViewGroup) this, i9, bVar5.f2733a);
                            if (i8 < this.mItems.size()) {
                                bVar5 = this.mItems.get(i8);
                            }
                        }
                    }
                }
                calculatePageOffsets(bVar2, i5, bVar);
                this.mAdapter.b((ViewGroup) this, this.mCurItem, bVar2.f2733a);
            }
            this.mAdapter.b((ViewGroup) this);
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                c cVar = (c) childAt.getLayoutParams();
                cVar.f = i10;
                if (!cVar.f2738a && cVar.f2740c == 0.0f && (infoForChild = infoForChild(childAt)) != null) {
                    cVar.f2740c = infoForChild.f2736d;
                    cVar.f2742e = infoForChild.f2734b;
                }
            }
            sortChildDrawingOrder();
            if (hasFocus()) {
                View findFocus = findFocus();
                b infoForAnyChild = findFocus != null ? infoForAnyChild(findFocus) : null;
                if (infoForAnyChild == null || infoForAnyChild.f2734b != this.mCurItem) {
                    for (int i11 = 0; i11 < getChildCount(); i11++) {
                        View childAt2 = getChildAt(i11);
                        b infoForChild2 = infoForChild(childAt2);
                        if (infoForChild2 != null && infoForChild2.f2734b == this.mCurItem && childAt2.requestFocus(2)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.mDrawingOrderedChildren.add(getChildAt(i2));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    private void calculatePageOffsets(b bVar, int i2, b bVar2) {
        b bVar3;
        b bVar4;
        int b2 = this.mAdapter.b();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.mPageMargin / clientWidth : 0.0f;
        if (bVar2 != null) {
            int i3 = bVar2.f2734b;
            if (i3 < bVar.f2734b) {
                float f3 = bVar2.f2737e + bVar2.f2736d + f2;
                int i4 = i3 + 1;
                int i5 = 0;
                while (i4 <= bVar.f2734b && i5 < this.mItems.size()) {
                    b bVar5 = this.mItems.get(i5);
                    while (true) {
                        bVar4 = bVar5;
                        if (i4 <= bVar4.f2734b || i5 >= this.mItems.size() - 1) {
                            break;
                        }
                        i5++;
                        bVar5 = this.mItems.get(i5);
                    }
                    while (i4 < bVar4.f2734b) {
                        f3 += this.mAdapter.d(i4) + f2;
                        i4++;
                    }
                    bVar4.f2737e = f3;
                    f3 += bVar4.f2736d + f2;
                    i4++;
                }
            } else if (i3 > bVar.f2734b) {
                int size = this.mItems.size() - 1;
                float f4 = bVar2.f2737e;
                while (true) {
                    i3--;
                    if (i3 < bVar.f2734b || size < 0) {
                        break;
                    }
                    b bVar6 = this.mItems.get(size);
                    while (true) {
                        bVar3 = bVar6;
                        if (i3 >= bVar3.f2734b || size <= 0) {
                            break;
                        }
                        size--;
                        bVar6 = this.mItems.get(size);
                    }
                    while (i3 > bVar3.f2734b) {
                        f4 -= this.mAdapter.d(i3) + f2;
                        i3--;
                    }
                    f4 -= bVar3.f2736d + f2;
                    bVar3.f2737e = f4;
                }
            }
        }
        int size2 = this.mItems.size();
        float f5 = bVar.f2737e;
        int i6 = bVar.f2734b - 1;
        this.mFirstOffset = bVar.f2734b == 0 ? bVar.f2737e : -3.4028235E38f;
        int i7 = b2 - 1;
        this.mLastOffset = bVar.f2734b == i7 ? (bVar.f2737e + bVar.f2736d) - 1.0f : Float.MAX_VALUE;
        int i8 = i2 - 1;
        while (i8 >= 0) {
            b bVar7 = this.mItems.get(i8);
            while (i6 > bVar7.f2734b) {
                f5 -= this.mAdapter.d(i6) + f2;
                i6--;
            }
            f5 -= bVar7.f2736d + f2;
            bVar7.f2737e = f5;
            if (bVar7.f2734b == 0) {
                this.mFirstOffset = f5;
            }
            i8--;
            i6--;
        }
        float f6 = bVar.f2737e + bVar.f2736d + f2;
        int i9 = bVar.f2734b + 1;
        int i10 = i2 + 1;
        while (i10 < size2) {
            b bVar8 = this.mItems.get(i10);
            while (i9 < bVar8.f2734b) {
                f6 += this.mAdapter.d(i9) + f2;
                i9++;
            }
            if (bVar8.f2734b == i7) {
                this.mLastOffset = (bVar8.f2736d + f6) - 1.0f;
            }
            bVar8.f2737e = f6;
            f6 += bVar8.f2736d + f2;
            i10++;
            i9++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    /* loaded from: classes.dex */
    public static class i extends androidx.customview.a.a {
        public static final Parcelable.Creator<i> CREATOR = new Parcelable.ClassLoaderCreator<i>() { // from class: androidx.viewpager.widget.ViewPager.i.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public i[] newArray(int i) {
                return new i[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f2745a;

        /* renamed from: b  reason: collision with root package name */
        Parcelable f2746b;

        /* renamed from: c  reason: collision with root package name */
        ClassLoader f2747c;

        public i(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2745a);
            parcel.writeParcelable(this.f2746b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f2745a + "}";
        }

        i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f2745a = parcel.readInt();
            this.f2746b = parcel.readParcelable(classLoader);
            this.f2747c = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        i iVar = new i(super.onSaveInstanceState());
        iVar.f2745a = this.mCurItem;
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar != null) {
            iVar.f2746b = aVar.a();
        }
        return iVar;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.getSuperState());
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.a(iVar.f2746b, iVar.f2747c);
            setCurrentItemInternal(iVar.f2745a, false, true);
            return;
        }
        this.mRestoredCurItem = iVar.f2745a;
        this.mRestoredAdapterState = iVar.f2746b;
        this.mRestoredClassLoader = iVar.f2747c;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        c cVar = (c) layoutParams;
        cVar.f2738a |= isDecorView(view);
        if (this.mInLayout) {
            if (cVar != null && cVar.f2738a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            cVar.f2741d = true;
            addViewInLayout(view, i2, layoutParams);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    private static boolean isDecorView(View view) {
        return view.getClass().getAnnotation(a.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    b infoForChild(View view) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            b bVar = this.mItems.get(i2);
            if (this.mAdapter.a(view, bVar.f2733a)) {
                return bVar;
            }
        }
        return null;
    }

    b infoForAnyChild(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return infoForChild(view);
            }
        }
    }

    b infoForPosition(int i2) {
        for (int i3 = 0; i3 < this.mItems.size(); i3++) {
            b bVar = this.mItems.get(i3);
            if (bVar.f2734b == i2) {
                return bVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b9  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i2, int i3) {
        c cVar;
        c cVar2;
        int i4;
        int i5;
        int i6;
        int i7;
        setMeasuredDimension(getDefaultSize(0, i2), getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i8 = 0;
        while (true) {
            boolean z = true;
            int i9 = 1073741824;
            if (i8 >= childCount) {
                break;
            }
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8 && (cVar2 = (c) childAt.getLayoutParams()) != null && cVar2.f2738a) {
                int i10 = cVar2.f2739b & 7;
                int i11 = cVar2.f2739b & 112;
                boolean z2 = i11 == 48 || i11 == 80;
                if (i10 != 3 && i10 != 5) {
                    z = false;
                }
                int i12 = Integer.MIN_VALUE;
                if (z2) {
                    i12 = 1073741824;
                } else if (z) {
                    i4 = 1073741824;
                    if (cVar2.width == -2) {
                        i6 = cVar2.width != -1 ? cVar2.width : paddingLeft;
                        i5 = 1073741824;
                    } else {
                        i5 = i12;
                        i6 = paddingLeft;
                    }
                    if (cVar2.height == -2) {
                        i7 = cVar2.height != -1 ? cVar2.height : measuredHeight;
                    } else {
                        i7 = measuredHeight;
                        i9 = i4;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i6, i5), View.MeasureSpec.makeMeasureSpec(i7, i9));
                    if (!z2) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (z) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
                i4 = Integer.MIN_VALUE;
                if (cVar2.width == -2) {
                }
                if (cVar2.height == -2) {
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i6, i5), View.MeasureSpec.makeMeasureSpec(i7, i9));
                if (!z2) {
                }
            }
            i8++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8 && ((cVar = (c) childAt2.getLayoutParams()) == null || !cVar.f2738a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * cVar.f2740c), 1073741824), this.mChildHeightMeasureSpec);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.mPageMargin;
            recomputeScrollPosition(i2, i4, i6, i6);
        }
    }

    private void recomputeScrollPosition(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.mItems.isEmpty()) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)), getScrollY());
                return;
            }
        }
        b infoForPosition = infoForPosition(this.mCurItem);
        int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.f2737e, this.mLastOffset) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            completeScroll(false);
            scrollTo(min, getScrollY());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        b infoForChild;
        int max;
        int i6;
        int max2;
        int i7;
        int childCount = getChildCount();
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f2738a) {
                    int i12 = cVar.f2739b & 7;
                    int i13 = cVar.f2739b & 112;
                    if (i12 == 1) {
                        max = Math.max((i8 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i12 == 3) {
                            i6 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i12 != 5) {
                            i6 = paddingLeft;
                        } else {
                            max = (i8 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i13 != 16) {
                            max2 = Math.max((i9 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        } else {
                            if (i13 == 48) {
                                i7 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i13 != 80) {
                                i7 = paddingTop;
                            } else {
                                max2 = (i9 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i14 = paddingLeft + scrollX;
                            childAt.layout(i14, paddingTop, childAt.getMeasuredWidth() + i14, paddingTop + childAt.getMeasuredHeight());
                            i10++;
                            paddingTop = i7;
                            paddingLeft = i6;
                        }
                        int i15 = max2;
                        i7 = paddingTop;
                        paddingTop = i15;
                        int i142 = paddingLeft + scrollX;
                        childAt.layout(i142, paddingTop, childAt.getMeasuredWidth() + i142, paddingTop + childAt.getMeasuredHeight());
                        i10++;
                        paddingTop = i7;
                        paddingLeft = i6;
                    }
                    int i16 = max;
                    i6 = paddingLeft;
                    paddingLeft = i16;
                    if (i13 != 16) {
                    }
                    int i152 = max2;
                    i7 = paddingTop;
                    paddingTop = i152;
                    int i1422 = paddingLeft + scrollX;
                    childAt.layout(i1422, paddingTop, childAt.getMeasuredWidth() + i1422, paddingTop + childAt.getMeasuredHeight());
                    i10++;
                    paddingTop = i7;
                    paddingLeft = i6;
                }
            }
        }
        int i17 = (i8 - paddingLeft) - paddingRight;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                c cVar2 = (c) childAt2.getLayoutParams();
                if (!cVar2.f2738a && (infoForChild = infoForChild(childAt2)) != null) {
                    float f2 = i17;
                    int i19 = ((int) (infoForChild.f2737e * f2)) + paddingLeft;
                    if (cVar2.f2741d) {
                        cVar2.f2741d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * cVar2.f2740c), 1073741824), View.MeasureSpec.makeMeasureSpec((i9 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i19, paddingTop, childAt2.getMeasuredWidth() + i19, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i9 - paddingBottom;
        this.mDecorChildCount = i10;
        if (this.mFirstLayout) {
            z2 = false;
            scrollToItem(this.mCurItem, false, 0, false);
        } else {
            z2 = false;
        }
        this.mFirstLayout = z2;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!pageScrolled(currX)) {
                    this.mScroller.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            w.e(this);
            return;
        }
        completeScroll(true);
    }

    private boolean pageScrolled(int i2) {
        if (this.mItems.size() == 0) {
            if (this.mFirstLayout) {
                return false;
            }
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        int clientWidth = getClientWidth();
        int i3 = this.mPageMargin;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = infoForCurrentScrollPosition.f2734b;
        float f3 = ((i2 / f2) - infoForCurrentScrollPosition.f2737e) / (infoForCurrentScrollPosition.f2736d + (i3 / f2));
        this.mCalledSuper = false;
        onPageScrolled(i5, f3, (int) (i4 * f3));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onPageScrolled(int i2, float f2, int i3) {
        int max;
        int i4;
        int left;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f2738a) {
                    int i6 = cVar.f2739b & 7;
                    if (i6 == 1) {
                        max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i6 == 3) {
                            i4 = childAt.getWidth() + paddingLeft;
                        } else if (i6 != 5) {
                            i4 = paddingLeft;
                        } else {
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = i4;
                    }
                    int i7 = max;
                    i4 = paddingLeft;
                    paddingLeft = i7;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = i4;
                }
            }
        }
        dispatchOnPageScrolled(i2, f2, i3);
        if (this.mPageTransformer != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i8 = 0; i8 < childCount2; i8++) {
                View childAt2 = getChildAt(i8);
                if (!((c) childAt2.getLayoutParams()).f2738a) {
                    this.mPageTransformer.a(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.mCalledSuper = true;
    }

    private void dispatchOnPageScrolled(int i2, float f2, int i3) {
        f fVar = this.mOnPageChangeListener;
        if (fVar != null) {
            fVar.onPageScrolled(i2, f2, i3);
        }
        List<f> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                f fVar2 = this.mOnPageChangeListeners.get(i4);
                if (fVar2 != null) {
                    fVar2.onPageScrolled(i2, f2, i3);
                }
            }
        }
        f fVar3 = this.mInternalPageChangeListener;
        if (fVar3 != null) {
            fVar3.onPageScrolled(i2, f2, i3);
        }
    }

    private void dispatchOnPageSelected(int i2) {
        f fVar = this.mOnPageChangeListener;
        if (fVar != null) {
            fVar.onPageSelected(i2);
        }
        List<f> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar2 = this.mOnPageChangeListeners.get(i3);
                if (fVar2 != null) {
                    fVar2.onPageSelected(i2);
                }
            }
        }
        f fVar3 = this.mInternalPageChangeListener;
        if (fVar3 != null) {
            fVar3.onPageSelected(i2);
        }
    }

    private void dispatchOnScrollStateChanged(int i2) {
        f fVar = this.mOnPageChangeListener;
        if (fVar != null) {
            fVar.onPageScrollStateChanged(i2);
        }
        List<f> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar2 = this.mOnPageChangeListeners.get(i3);
                if (fVar2 != null) {
                    fVar2.onPageScrollStateChanged(i2);
                }
            }
        }
        f fVar3 = this.mInternalPageChangeListener;
        if (fVar3 != null) {
            fVar3.onPageScrollStateChanged(i2);
        }
    }

    private void completeScroll(boolean z) {
        boolean z2 = this.mScrollState == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            b bVar = this.mItems.get(i2);
            if (bVar.f2735c) {
                bVar.f2735c = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                w.a(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private boolean isGutterDrag(float f2, float f3) {
        return (f2 < ((float) this.mGutterSize) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.mGutterSize)) && f3 < 0.0f);
    }

    private void enableLayers(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z ? this.mPageTransformerLayerType : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastMotionX = x;
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
            } else {
                completeScroll(false);
                this.mIsBeingDragged = false;
            }
        } else if (action == 2) {
            int i2 = this.mActivePointerId;
            if (i2 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(findPointerIndex);
                float f2 = x2 - this.mLastMotionX;
                float abs = Math.abs(f2);
                float y2 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.mInitialMotionY);
                if (f2 != 0.0f && !isGutterDrag(this.mLastMotionX, f2) && canScroll(this, false, (int) f2, (int) x2, (int) y2)) {
                    this.mLastMotionX = x2;
                    this.mLastMotionY = y2;
                    this.mIsUnableToDrag = true;
                    return false;
                }
                if (abs > this.mTouchSlop && abs * 0.5f > abs2) {
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    this.mLastMotionX = f2 > 0.0f ? this.mInitialMotionX + this.mTouchSlop : this.mInitialMotionX - this.mTouchSlop;
                    this.mLastMotionY = y2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > this.mTouchSlop) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && performDrag(x2)) {
                    w.e(this);
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        androidx.viewpager.widget.a aVar;
        if (this.mFakeDragging) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.mAdapter) == null || aVar.b() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastMotionX = x;
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.mIsBeingDragged) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        z = resetTouch();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.mLastMotionX);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.mLastMotionY);
                        if (abs > this.mTouchSlop && abs > abs2) {
                            this.mIsBeingDragged = true;
                            requestParentDisallowInterceptTouchEvent(true);
                            float f2 = this.mInitialMotionX;
                            this.mLastMotionX = x2 - f2 > 0.0f ? f2 + this.mTouchSlop : f2 - this.mTouchSlop;
                            this.mLastMotionY = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    z = false | performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.mLastMotionX = motionEvent.getX(actionIndex);
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                }
            } else if (this.mIsBeingDragged) {
                scrollToItem(this.mCurItem, true, 0, false);
                z = resetTouch();
            }
        } else if (this.mIsBeingDragged) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            float f3 = clientWidth;
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f2734b, ((scrollX / f3) - infoForCurrentScrollPosition.f2737e) / (infoForCurrentScrollPosition.f2736d + (this.mPageMargin / f3)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
            z = resetTouch();
        }
        if (z) {
            w.e(this);
        }
        return true;
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        return this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean performDrag(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.mLastMotionX - f2;
        this.mLastMotionX = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.mFirstOffset * clientWidth;
        float f5 = this.mLastOffset * clientWidth;
        boolean z3 = false;
        b bVar = this.mItems.get(0);
        ArrayList<b> arrayList = this.mItems;
        b bVar2 = arrayList.get(arrayList.size() - 1);
        if (bVar.f2734b != 0) {
            f4 = bVar.f2737e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.f2734b != this.mAdapter.b() - 1) {
            f5 = bVar2.f2737e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.mLeftEdge.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.mRightEdge.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.mLastMotionX += scrollX - i2;
        scrollTo(i2, getScrollY());
        pageScrolled(i2);
        return z3;
    }

    private b infoForCurrentScrollPosition() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f3 = clientWidth > 0 ? this.mPageMargin / clientWidth : 0.0f;
        b bVar = null;
        float f4 = 0.0f;
        int i3 = -1;
        int i4 = 0;
        boolean z = true;
        while (i4 < this.mItems.size()) {
            b bVar2 = this.mItems.get(i4);
            if (!z && bVar2.f2734b != (i2 = i3 + 1)) {
                bVar2 = this.mTempItem;
                bVar2.f2737e = f2 + f4 + f3;
                bVar2.f2734b = i2;
                bVar2.f2736d = this.mAdapter.d(bVar2.f2734b);
                i4--;
            }
            f2 = bVar2.f2737e;
            float f5 = bVar2.f2736d + f2 + f3;
            if (!z && scrollX < f2) {
                return bVar;
            }
            if (scrollX < f5 || i4 == this.mItems.size() - 1) {
                return bVar2;
            }
            i3 = bVar2.f2734b;
            f4 = bVar2.f2736d;
            i4++;
            bVar = bVar2;
            z = false;
        }
        return bVar;
    }

    private int determineTargetPage(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.mFlingDistance || Math.abs(i3) <= this.mMinimumVelocity) {
            i2 += (int) (f2 + (i2 >= this.mCurItem ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.mItems.size() > 0) {
            ArrayList<b> arrayList = this.mItems;
            return Math.max(this.mItems.get(0).f2734b, Math.min(i2, arrayList.get(arrayList.size() - 1).f2734b));
        }
        return i2;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.mAdapter) != null && aVar.b() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.mFirstOffset * width);
                this.mLeftEdge.setSize(height, width);
                z = false | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mRightEdge.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * width2);
                this.mRightEdge.setSize(height2, width2);
                z |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (z) {
            w.e(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        float f2;
        float f3;
        float f4;
        super.onDraw(canvas);
        if (this.mPageMargin <= 0 || this.mMarginDrawable == null || this.mItems.size() <= 0 || this.mAdapter == null) {
            return;
        }
        int scrollX = getScrollX();
        float width2 = getWidth();
        float f5 = this.mPageMargin / width2;
        int i2 = 0;
        b bVar = this.mItems.get(0);
        float f6 = bVar.f2737e;
        int size = this.mItems.size();
        int i3 = bVar.f2734b;
        int i4 = this.mItems.get(size - 1).f2734b;
        while (i3 < i4) {
            while (i3 > bVar.f2734b && i2 < size) {
                i2++;
                bVar = this.mItems.get(i2);
            }
            if (i3 == bVar.f2734b) {
                f3 = (bVar.f2737e + bVar.f2736d) * width2;
                f2 = bVar.f2737e + bVar.f2736d + f5;
            } else {
                float d2 = this.mAdapter.d(i3);
                f2 = f6 + d2 + f5;
                f3 = (f6 + d2) * width2;
            }
            if (this.mPageMargin + f3 > scrollX) {
                f4 = f5;
                this.mMarginDrawable.setBounds(Math.round(f3), this.mTopPageBounds, Math.round(this.mPageMargin + f3), this.mBottomPageBounds);
                this.mMarginDrawable.draw(canvas);
            } else {
                f4 = f5;
            }
            if (f3 > scrollX + width) {
                return;
            }
            i3++;
            f6 = f2;
            f5 = f4;
        }
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    public void endFakeDrag() {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter != null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f2734b, ((scrollX / clientWidth) - infoForCurrentScrollPosition.f2737e) / infoForCurrentScrollPosition.f2736d, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
        }
        endDrag();
        this.mFakeDragging = false;
    }

    public void fakeDragBy(float f2) {
        ArrayList<b> arrayList;
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter == null) {
            return;
        }
        this.mLastMotionX += f2;
        float scrollX = getScrollX() - f2;
        float clientWidth = getClientWidth();
        float f3 = this.mFirstOffset * clientWidth;
        float f4 = this.mLastOffset * clientWidth;
        b bVar = this.mItems.get(0);
        b bVar2 = this.mItems.get(arrayList.size() - 1);
        if (bVar.f2734b != 0) {
            f3 = bVar.f2737e * clientWidth;
        }
        if (bVar2.f2734b != this.mAdapter.b() - 1) {
            f4 = bVar2.f2737e * clientWidth;
        }
        if (scrollX < f3) {
            scrollX = f3;
        } else if (scrollX > f4) {
            scrollX = f4;
        }
        int i2 = (int) scrollX;
        this.mLastMotionX += scrollX - i2;
        scrollTo(i2, getScrollY());
        pageScrolled(i2);
        MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i2);
            this.mActivePointerId = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.mFirstOffset)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.mLastOffset));
    }

    protected boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && canScroll(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return pageLeft();
                }
                return arrowScroll(17);
            } else if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return pageRight();
                }
                return arrowScroll(66);
            } else if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean arrowScroll(int i2) {
        boolean z;
        View findNextFocus;
        boolean requestFocus;
        View findFocus = findFocus();
        boolean z2 = false;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i2 == 17) {
                    int i3 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
                    int i4 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
                    if (findFocus != null && i3 >= i4) {
                        requestFocus = pageLeft();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                } else if (i2 == 66) {
                    int i5 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left;
                    int i6 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
                    if (findFocus != null && i5 <= i6) {
                        requestFocus = pageRight();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                }
                z2 = requestFocus;
            } else if (i2 != 17 || i2 == 1) {
                z2 = pageLeft();
            } else if (i2 == 66 || i2 == 2) {
                z2 = pageRight();
            }
            if (z2) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
            }
            return z2;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        if (findNextFocus == null) {
        }
        if (i2 != 17) {
        }
        z2 = pageLeft();
        if (z2) {
        }
        return z2;
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    boolean pageLeft() {
        int i2 = this.mCurItem;
        if (i2 > 0) {
            setCurrentItem(i2 - 1, true);
            return true;
        }
        return false;
    }

    boolean pageRight() {
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar == null || this.mCurItem >= aVar.b() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        b infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f2734b == this.mCurItem) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        b infoForChild;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f2734b == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        b infoForChild;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f2734b == this.mCurItem && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f2734b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends androidx.core.h.a {
        d() {
        }

        @Override // androidx.core.h.a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(a());
            if (accessibilityEvent.getEventType() != 4096 || ViewPager.this.mAdapter == null) {
                return;
            }
            accessibilityEvent.setItemCount(ViewPager.this.mAdapter.b());
            accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
            accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
        }

        @Override // androidx.core.h.a
        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.h.a.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.b((CharSequence) ViewPager.class.getName());
            dVar.h(a());
            if (ViewPager.this.canScrollHorizontally(1)) {
                dVar.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                dVar.a(8192);
            }
        }

        @Override // androidx.core.h.a
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i == 4096) {
                if (ViewPager.this.canScrollHorizontally(1)) {
                    ViewPager viewPager = ViewPager.this;
                    viewPager.setCurrentItem(viewPager.mCurItem + 1);
                    return true;
                }
                return false;
            } else if (i == 8192 && ViewPager.this.canScrollHorizontally(-1)) {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.mCurItem - 1);
                return true;
            } else {
                return false;
            }
        }

        private boolean a() {
            return ViewPager.this.mAdapter != null && ViewPager.this.mAdapter.b() > 1;
        }
    }

    /* loaded from: classes.dex */
    private class h extends DataSetObserver {
        h() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2738a;

        /* renamed from: b  reason: collision with root package name */
        public int f2739b;

        /* renamed from: c  reason: collision with root package name */
        float f2740c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2741d;

        /* renamed from: e  reason: collision with root package name */
        int f2742e;
        int f;

        public c() {
            super(-1, -1);
            this.f2740c = 0.0f;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2740c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.f2739b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class k implements Comparator<View> {
        k() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            if (cVar.f2738a != cVar2.f2738a) {
                return cVar.f2738a ? 1 : -1;
            }
            return cVar.f2742e - cVar2.f2742e;
        }
    }
}
