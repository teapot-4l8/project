package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.h.a.d;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.u;
import androidx.recyclerview.widget.y;
import androidx.recyclerview.widget.z;
import com.umeng.analytics.pro.o;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements androidx.core.h.l, androidx.core.h.m {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK;
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    androidx.recyclerview.widget.u mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    a mAdapter;
    androidx.recyclerview.widget.a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private d mChildDrawingOrderCallback;
    androidx.recyclerview.widget.f mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private e mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    androidx.recyclerview.widget.k mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private m mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    f mItemAnimator;
    private f.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<h> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    i mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final r mObserver;
    private List<k> mOnChildAttachStateListeners;
    private l mOnFlingListener;
    private final ArrayList<m> mOnItemTouchListeners;
    final List<x> mPendingAccessibilityImportanceChange;
    private s mPendingSavedState;
    boolean mPostedAnimatorRunner;
    k.a mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final p mRecycler;
    q mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private n mScrollListener;
    private List<n> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private androidx.core.h.n mScrollingChildHelper;
    final u mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final w mViewFlinger;
    private final z.b mViewInfoProcessCallback;
    final z mViewInfoStore;

    /* loaded from: classes.dex */
    public interface d {
        int a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface k {
        void onChildViewAttachedToWindow(View view);

        void onChildViewDetachedFromWindow(View view);
    }

    /* loaded from: classes.dex */
    public static abstract class l {
        public abstract boolean onFling(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class n {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* loaded from: classes.dex */
    public interface q {
        void a(x xVar);
    }

    /* loaded from: classes.dex */
    public static abstract class v {
        public abstract View a(p pVar, int i, int i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(int i2, int i3) {
    }

    static {
        FORCE_INVALIDATE_DISPLAY_LIST = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = Build.VERSION.SDK_INT >= 23;
        POST_UPDATES_ON_ANIMATION = Build.VERSION.SDK_INT >= 16;
        ALLOW_THREAD_GAP_WORK = Build.VERSION.SDK_INT >= 21;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = Build.VERSION.SDK_INT <= 15;
        IGNORE_DETACHED_FOCUSED_CHILD = Build.VERSION.SDK_INT <= 15;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        sQuinticInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mObserver = new r();
        this.mRecycler = new p();
        this.mViewInfoStore = new z();
        this.mUpdateChildViewsRunnable = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!RecyclerView.this.mFirstLayoutComplete || RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (!RecyclerView.this.mIsAttached) {
                    RecyclerView.this.requestLayout();
                } else if (RecyclerView.this.mLayoutSuppressed) {
                    RecyclerView.this.mLayoutWasDefered = true;
                } else {
                    RecyclerView.this.consumePendingUpdateOperations();
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new e();
        this.mItemAnimator = new androidx.recyclerview.widget.g();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new w();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new k.a() : null;
        this.mState = new u();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new g();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.mItemAnimator != null) {
                    RecyclerView.this.mItemAnimator.a();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mViewInfoProcessCallback = new z.b() { // from class: androidx.recyclerview.widget.RecyclerView.4
            @Override // androidx.recyclerview.widget.z.b
            public void a(x xVar, f.c cVar, f.c cVar2) {
                RecyclerView.this.mRecycler.c(xVar);
                RecyclerView.this.animateDisappearance(xVar, cVar, cVar2);
            }

            @Override // androidx.recyclerview.widget.z.b
            public void b(x xVar, f.c cVar, f.c cVar2) {
                RecyclerView.this.animateAppearance(xVar, cVar, cVar2);
            }

            @Override // androidx.recyclerview.widget.z.b
            public void c(x xVar, f.c cVar, f.c cVar2) {
                xVar.setIsRecyclable(false);
                if (RecyclerView.this.mDataSetHasChangedAfterLayout) {
                    if (RecyclerView.this.mItemAnimator.a(xVar, xVar, cVar, cVar2)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if (RecyclerView.this.mItemAnimator.c(xVar, cVar, cVar2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            }

            @Override // androidx.recyclerview.widget.z.b
            public void a(x xVar) {
                RecyclerView.this.mLayout.removeAndRecycleView(xVar.itemView, RecyclerView.this.mRecycler);
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = androidx.core.h.x.a(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = androidx.core.h.x.b(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.a(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (androidx.core.h.w.f(this) == 0) {
            androidx.core.h.w.b((View) this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.u(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R.styleable.RecyclerView, attributeSet, obtainStyledAttributes, i2, 0);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z2;
        if (z2) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i2, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i2, 0);
            if (Build.VERSION.SDK_INT >= 29) {
                saveAttributeDataForStyleable(context, NESTED_SCROLLING_ATTRS, attributeSet, obtainStyledAttributes2, i2, 0);
            }
            z = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z);
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    private void initAutofill() {
        if (androidx.core.h.w.a(this) == 0) {
            androidx.core.h.w.a((View) this, 8);
        }
    }

    public androidx.recyclerview.widget.u getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.u uVar) {
        this.mAccessibilityDelegate = uVar;
        androidx.core.h.w.a(this, uVar);
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, trim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(i.class);
                Object[] objArr = null;
                try {
                    constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((i) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e8);
            }
        }
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new androidx.recyclerview.widget.f(new f.b() { // from class: androidx.recyclerview.widget.RecyclerView.5
            @Override // androidx.recyclerview.widget.f.b
            public int a() {
                return RecyclerView.this.getChildCount();
            }

            @Override // androidx.recyclerview.widget.f.b
            public void a(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView.this.dispatchChildAttached(view);
            }

            @Override // androidx.recyclerview.widget.f.b
            public int a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // androidx.recyclerview.widget.f.b
            public void a(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i2);
            }

            @Override // androidx.recyclerview.widget.f.b
            public View b(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            @Override // androidx.recyclerview.widget.f.b
            public void b() {
                int a2 = a();
                for (int i2 = 0; i2 < a2; i2++) {
                    View b2 = b(i2);
                    RecyclerView.this.dispatchChildDetached(b2);
                    b2.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // androidx.recyclerview.widget.f.b
            public x b(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            @Override // androidx.recyclerview.widget.f.b
            public void a(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                    childViewHolderInt.clearTmpDetachFlag();
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }

            @Override // androidx.recyclerview.widget.f.b
            public void c(int i2) {
                x childViewHolderInt;
                View b2 = b(i2);
                if (b2 != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(b2)) != null) {
                    if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                    childViewHolderInt.addFlags(256);
                }
                RecyclerView.this.detachViewFromParent(i2);
            }

            @Override // androidx.recyclerview.widget.f.b
            public void c(View view) {
                x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.f.b
            public void d(View view) {
                x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
            }
        });
    }

    void initAdapterManager() {
        this.mAdapterHelper = new androidx.recyclerview.widget.a(new a.InterfaceC0052a() { // from class: androidx.recyclerview.widget.RecyclerView.6
            @Override // androidx.recyclerview.widget.a.InterfaceC0052a
            public x a(int i2) {
                x findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i2, true);
                if (findViewHolderForPosition == null || RecyclerView.this.mChildHelper.c(findViewHolderForPosition.itemView)) {
                    return null;
                }
                return findViewHolderForPosition;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0052a
            public void a(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForRemove(i2, i3, true);
                RecyclerView.this.mItemsAddedOrRemoved = true;
                RecyclerView.this.mState.f2165c += i3;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0052a
            public void b(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForRemove(i2, i3, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0052a
            public void a(int i2, int i3, Object obj) {
                RecyclerView.this.viewRangeUpdate(i2, i3, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0052a
            public void a(a.b bVar) {
                c(bVar);
            }

            void c(a.b bVar) {
                int i2 = bVar.f2209a;
                if (i2 == 1) {
                    RecyclerView.this.mLayout.onItemsAdded(RecyclerView.this, bVar.f2210b, bVar.f2212d);
                } else if (i2 == 2) {
                    RecyclerView.this.mLayout.onItemsRemoved(RecyclerView.this, bVar.f2210b, bVar.f2212d);
                } else if (i2 == 4) {
                    RecyclerView.this.mLayout.onItemsUpdated(RecyclerView.this, bVar.f2210b, bVar.f2212d, bVar.f2211c);
                } else if (i2 != 8) {
                } else {
                    RecyclerView.this.mLayout.onItemsMoved(RecyclerView.this, bVar.f2210b, bVar.f2212d, 1);
                }
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0052a
            public void b(a.b bVar) {
                c(bVar);
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0052a
            public void c(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForInsert(i2, i3);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.a.InterfaceC0052a
            public void d(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForMove(i2, i3);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void swapAdapter(a aVar, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeAndRecycleViews() {
        f fVar = this.mItemAnimator;
        if (fVar != null) {
            fVar.d();
        }
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.a();
    }

    private void setAdapterInternal(a aVar, boolean z, boolean z2) {
        a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.a();
        a aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        if (aVar != null) {
            aVar.registerAdapterDataObserver(this.mObserver);
            aVar.onAttachedToRecyclerView(this);
        }
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.onAdapterChanged(aVar3, this.mAdapter);
        }
        this.mRecycler.a(aVar3, this.mAdapter, z);
        this.mState.f = true;
    }

    public a getAdapter() {
        return this.mAdapter;
    }

    public void setRecyclerListener(q qVar) {
        this.mRecyclerListener = qVar;
    }

    @Override // android.view.View
    public int getBaseline() {
        i iVar = this.mLayout;
        if (iVar != null) {
            return iVar.getBaseline();
        }
        return super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(k kVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(kVar);
    }

    public void removeOnChildAttachStateChangeListener(k kVar) {
        List<k> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(kVar);
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void setLayoutManager(i iVar) {
        if (iVar == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            f fVar = this.mItemAnimator;
            if (fVar != null) {
                fVar.d();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.a();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            this.mRecycler.a();
        }
        this.mChildHelper.a();
        this.mLayout = iVar;
        if (iVar != null) {
            if (iVar.mRecyclerView != null) {
                throw new IllegalArgumentException("LayoutManager " + iVar + " is already attached to a RecyclerView:" + iVar.mRecyclerView.exceptionLabel());
            }
            this.mLayout.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.b();
        requestLayout();
    }

    public void setOnFlingListener(l lVar) {
        this.mOnFlingListener = lVar;
    }

    public l getOnFlingListener() {
        return this.mOnFlingListener;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        s sVar = new s(super.onSaveInstanceState());
        s sVar2 = this.mPendingSavedState;
        if (sVar2 != null) {
            sVar.a(sVar2);
        } else {
            i iVar = this.mLayout;
            if (iVar != null) {
                sVar.f2157a = iVar.onSaveInstanceState();
            } else {
                sVar.f2157a = null;
            }
        }
        return sVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof s)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        s sVar = (s) parcelable;
        this.mPendingSavedState = sVar;
        super.onRestoreInstanceState(sVar.getSuperState());
        if (this.mLayout == null || this.mPendingSavedState.f2157a == null) {
            return;
        }
        this.mLayout.onRestoreInstanceState(this.mPendingSavedState.f2157a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void addAnimatingView(x xVar) {
        View view = xVar.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.c(getChildViewHolder(view));
        if (xVar.isTmpDetached()) {
            this.mChildHelper.a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.a(view, true);
        } else {
            this.mChildHelper.d(view);
        }
    }

    boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean f2 = this.mChildHelper.f(view);
        if (f2) {
            x childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.c(childViewHolderInt);
            this.mRecycler.b(childViewHolderInt);
        }
        stopInterceptRequestLayout(!f2);
        return f2;
    }

    public i getLayoutManager() {
        return this.mLayout;
    }

    public o getRecycledViewPool() {
        return this.mRecycler.g();
    }

    public void setRecycledViewPool(o oVar) {
        this.mRecycler.a(oVar);
    }

    public void setViewCacheExtension(v vVar) {
        this.mRecycler.a(vVar);
    }

    public void setItemViewCacheSize(int i2) {
        this.mRecycler.a(i2);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    void setScrollState(int i2) {
        if (i2 == this.mScrollState) {
            return;
        }
        this.mScrollState = i2;
        if (i2 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i2);
    }

    public void addItemDecoration(h hVar, int i2) {
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.mItemDecorations.add(hVar);
        } else {
            this.mItemDecorations.add(i2, hVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(h hVar) {
        addItemDecoration(hVar, -1);
    }

    public h getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 < 0 || i2 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
        }
        return this.mItemDecorations.get(i2);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 < 0 || i2 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i2));
    }

    public void removeItemDecoration(h hVar) {
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(hVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = dVar;
        setChildrenDrawingOrderEnabled(dVar != null);
    }

    @Deprecated
    public void setOnScrollListener(n nVar) {
        this.mScrollListener = nVar;
    }

    public void addOnScrollListener(n nVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(nVar);
    }

    public void removeOnScrollListener(n nVar) {
        List<n> list = this.mScrollListeners;
        if (list != null) {
            list.remove(nVar);
        }
    }

    public void clearOnScrollListeners() {
        List<n> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void scrollToPosition(int i2) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        iVar.scrollToPosition(i2);
        awakenScrollBars();
    }

    void jumpToPositionForSmoothScroller(int i2) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i2);
        awakenScrollBars();
    }

    public void smoothScrollToPosition(int i2) {
        if (this.mLayoutSuppressed) {
            return;
        }
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            iVar.smoothScrollToPosition(this, this.mState, i2);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.mLayoutSuppressed) {
        } else {
            boolean canScrollHorizontally = iVar.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i2 = 0;
                }
                if (!canScrollVertically) {
                    i3 = 0;
                }
                scrollByInternal(i2, i3, null);
            }
        }
    }

    void scrollStep(int i2, int i3, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        androidx.core.d.d.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int scrollHorizontallyBy = i2 != 0 ? this.mLayout.scrollHorizontallyBy(i2, this.mRecycler, this.mState) : 0;
        int scrollVerticallyBy = i3 != 0 ? this.mLayout.scrollVerticallyBy(i3, this.mRecycler, this.mState) : 0;
        androidx.core.d.d.a();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            androidx.core.d.d.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            androidx.core.d.d.a();
        } else if (this.mAdapterHelper.d()) {
            if (this.mAdapterHelper.a(4) && !this.mAdapterHelper.a(11)) {
                androidx.core.d.d.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.b();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.c();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                androidx.core.d.d.a();
            } else if (this.mAdapterHelper.d()) {
                androidx.core.d.d.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                androidx.core.d.d.a();
            }
        }
    }

    private boolean hasUpdatedView() {
        int b2 = this.mChildHelper.b();
        for (int i2 = 0; i2 < b2; i2++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    boolean scrollByInternal(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i2, i3, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            i4 = i9;
            i5 = i8;
            i6 = i2 - i8;
            i7 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i5, i4, i6, i7, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i10 = i6 - iArr4[0];
        int i11 = i7 - iArr4[1];
        boolean z = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i12 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i12 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !androidx.core.h.j.a(motionEvent, o.a.f6601q)) {
                pullGlows(motionEvent.getX(), i10, motionEvent.getY(), i11);
            }
            considerReleasingGlowsOnScroll(i2, i3);
        }
        if (i5 != 0 || i4 != 0) {
            dispatchOnScrolled(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z && i5 == 0 && i4 == 0) ? false : true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    void startInterceptRequestLayout() {
        int i2 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i2;
        if (i2 != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.mLayoutSuppressed = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, null);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator) {
        smoothScrollBy(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4) {
        smoothScrollBy(i2, i3, interpolator, i4, false);
    }

    void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4, boolean z) {
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.mLayoutSuppressed) {
        } else {
            if (!iVar.canScrollHorizontally()) {
                i2 = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return;
            }
            if (i4 == Integer.MIN_VALUE || i4 > 0) {
                if (z) {
                    int i5 = i2 != 0 ? 1 : 0;
                    if (i3 != 0) {
                        i5 |= 2;
                    }
                    startNestedScroll(i5, 1);
                }
                this.mViewFlinger.a(i2, i3, i4, interpolator);
                return;
            }
            scrollBy(i2, i3);
        }
    }

    public boolean fling(int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.mLayoutSuppressed) {
            return false;
        } else {
            boolean canScrollHorizontally = iVar.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            i2 = (!canScrollHorizontally || Math.abs(i2) < this.mMinFlingVelocity) ? 0 : 0;
            i3 = (!canScrollVertically || Math.abs(i3) < this.mMinFlingVelocity) ? 0 : 0;
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            float f2 = i2;
            float f3 = i3;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z = canScrollHorizontally || canScrollVertically;
                dispatchNestedFling(f2, f3, z);
                l lVar = this.mOnFlingListener;
                if (lVar != null && lVar.onFling(i2, i3)) {
                    return true;
                }
                if (z) {
                    int i4 = canScrollHorizontally ? 1 : 0;
                    if (canScrollVertically) {
                        i4 |= 2;
                    }
                    startNestedScroll(i4, 1);
                    int i5 = this.mMaxFlingVelocity;
                    int max = Math.max(-i5, Math.min(i2, i5));
                    int i6 = this.mMaxFlingVelocity;
                    this.mViewFlinger.a(max, Math.max(-i6, Math.min(i3, i6)));
                    return true;
                }
            }
            return false;
        }
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.b();
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.stopSmoothScroller();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pullGlows(float f2, float f3, float f4, float f5) {
        boolean z;
        boolean z2 = true;
        if (f3 < 0.0f) {
            ensureLeftGlow();
            androidx.core.widget.d.a(this.mLeftGlow, (-f3) / getWidth(), 1.0f - (f4 / getHeight()));
        } else if (f3 <= 0.0f) {
            z = false;
            if (f5 >= 0.0f) {
                ensureTopGlow();
                androidx.core.widget.d.a(this.mTopGlow, (-f5) / getHeight(), f2 / getWidth());
            } else if (f5 > 0.0f) {
                ensureBottomGlow();
                androidx.core.widget.d.a(this.mBottomGlow, f5 / getHeight(), 1.0f - (f2 / getWidth()));
            } else {
                z2 = z;
            }
            if (z2 && f3 == 0.0f && f5 == 0.0f) {
                return;
            }
            androidx.core.h.w.e(this);
        } else {
            ensureRightGlow();
            androidx.core.widget.d.a(this.mRightGlow, f3 / getWidth(), f4 / getHeight());
        }
        z = true;
        if (f5 >= 0.0f) {
        }
        if (z2) {
        }
        androidx.core.h.w.e(this);
    }

    private void releaseGlows() {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            androidx.core.h.w.e(this);
        }
    }

    void considerReleasingGlowsOnScroll(int i2, int i3) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z = false;
        } else {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            androidx.core.h.w.e(this);
        }
    }

    void absorbGlows(int i2, int i3) {
        if (i2 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i3);
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        androidx.core.h.w.e(this);
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect a2 = this.mEdgeEffectFactory.a(this, 0);
        this.mLeftGlow = a2;
        if (this.mClipToPadding) {
            a2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            a2.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect a2 = this.mEdgeEffectFactory.a(this, 2);
        this.mRightGlow = a2;
        if (this.mClipToPadding) {
            a2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            a2.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect a2 = this.mEdgeEffectFactory.a(this, 1);
        this.mTopGlow = a2;
        if (this.mClipToPadding) {
            a2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            a2.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect a2 = this.mEdgeEffectFactory.a(this, 3);
        this.mBottomGlow = a2;
        if (this.mClipToPadding) {
            a2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            a2.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void setEdgeEffectFactory(e eVar) {
        androidx.core.g.f.a(eVar);
        this.mEdgeEffectFactory = eVar;
        invalidateGlows();
    }

    public e getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View view2;
        boolean z;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i2);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z2 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i2 == 2 || i2 == 1)) {
            if (this.mLayout.canScrollVertically()) {
                int i3 = i2 == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i3;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.canScrollHorizontally()) {
                int i4 = (this.mLayout.getLayoutDirection() == 1) ^ (i2 == 2) ? 66 : 17;
                boolean z3 = focusFinder.findNextFocus(this, view, i4) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i4;
                }
                z = z3;
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i2);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (findNextFocus == null && z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return isPreferredNextFocus(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        } else {
            requestChildOnScreen(view2, null);
            return view;
        }
    }

    private boolean isPreferredNextFocus(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c2 = 65535;
        int i4 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        if ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) {
            i3 = 1;
        } else {
            i3 = ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        }
        if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            c2 = 1;
        } else if ((this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom) || this.mTempRect.top <= this.mTempRect2.top) {
            c2 = 0;
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
        } else if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
        } else if (i2 == 17) {
            return i3 < 0;
        } else if (i2 == 33) {
            return c2 < 0;
        } else if (i2 == 66) {
            return i3 > 0;
        } else if (i2 == 130) {
            return c2 > 0;
        } else {
            throw new IllegalArgumentException("Invalid direction: " + i2 + exceptionLabel());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof j) {
            j jVar = (j) layoutParams;
            if (!jVar.f2144e) {
                Rect rect = jVar.f2143d;
                this.mTempRect.left -= rect.left;
                this.mTempRect.right += rect.right;
                this.mTempRect.top -= rect.top;
                this.mTempRect.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null || !iVar.onAddFocusables(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean z = true;
        this.mIsAttached = true;
        this.mFirstLayoutComplete = (!this.mFirstLayoutComplete || isLayoutRequested()) ? false : false;
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            androidx.recyclerview.widget.k kVar = androidx.recyclerview.widget.k.f2321a.get();
            this.mGapWorker = kVar;
            if (kVar == null) {
                this.mGapWorker = new androidx.recyclerview.widget.k();
                Display F = androidx.core.h.w.F(this);
                float f2 = 60.0f;
                if (!isInEditMode() && F != null) {
                    float refreshRate = F.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                this.mGapWorker.f2325d = 1.0E9f / f2;
                androidx.recyclerview.widget.k.f2321a.set(this.mGapWorker);
            }
            this.mGapWorker.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.k kVar;
        super.onDetachedFromWindow();
        f fVar = this.mItemAnimator;
        if (fVar != null) {
            fVar.d();
        }
        stopScroll();
        this.mIsAttached = false;
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.b();
        if (!ALLOW_THREAD_GAP_WORK || (kVar = this.mGapWorker) == null) {
            return;
        }
        kVar.b(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    public void addOnItemTouchListener(m mVar) {
        this.mOnItemTouchListeners.add(mVar);
    }

    public void removeOnItemTouchListener(m mVar) {
        this.mOnItemTouchListeners.remove(mVar);
        if (this.mInterceptingOnItemTouchListener == mVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        m mVar = this.mInterceptingOnItemTouchListener;
        if (mVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        mVar.onTouchEvent(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = this.mOnItemTouchListeners.get(i2);
            if (mVar.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = mVar;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        i iVar = this.mLayout;
        if (iVar == null) {
            return false;
        }
        boolean canScrollHorizontally = iVar.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = canScrollHorizontally ? 1 : 0;
            if (canScrollVertically) {
                i2 |= 2;
            }
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i3 = x3 - this.mInitialTouchX;
                int i4 = y2 - this.mInitialTouchY;
                if (!canScrollHorizontally || Math.abs(i3) <= this.mTouchSlop) {
                    z = false;
                } else {
                    this.mLastTouchX = x3;
                    z = true;
                }
                if (canScrollVertically && Math.abs(i4) > this.mTouchSlop) {
                    this.mLastTouchY = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mOnItemTouchListeners.get(i2).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        if (this.mLayoutSuppressed || this.mIgnoreMotionEventTillDown) {
            return false;
        }
        if (dispatchToOnItemTouchListeners(motionEvent)) {
            cancelScroll();
            return true;
        }
        i iVar = this.mLayout;
        if (iVar == null) {
            return false;
        }
        boolean canScrollHorizontally = iVar.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.mNestedOffsets;
        obtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            int i2 = canScrollHorizontally ? 1 : 0;
            if (canScrollVertically) {
                i2 |= 2;
            }
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.addMovement(obtain);
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
            float f2 = canScrollHorizontally ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
            float f3 = canScrollVertically ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
            if ((f2 == 0.0f && f3 == 0.0f) || !fling((int) f2, (int) f3)) {
                setScrollState(0);
            }
            resetScroll();
            z2 = true;
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            int i3 = this.mLastTouchX - x3;
            int i4 = this.mLastTouchY - y2;
            if (this.mScrollState != 1) {
                if (canScrollHorizontally) {
                    if (i3 > 0) {
                        i3 = Math.max(0, i3 - this.mTouchSlop);
                    } else {
                        i3 = Math.min(0, i3 + this.mTouchSlop);
                    }
                    if (i3 != 0) {
                        z = true;
                        if (canScrollVertically) {
                            if (i4 > 0) {
                                i4 = Math.max(0, i4 - this.mTouchSlop);
                            } else {
                                i4 = Math.min(0, i4 + this.mTouchSlop);
                            }
                            if (i4 != 0) {
                                z = true;
                            }
                        }
                        if (z) {
                            setScrollState(1);
                        }
                    }
                }
                z = false;
                if (canScrollVertically) {
                }
                if (z) {
                }
            }
            int i5 = i3;
            int i6 = i4;
            if (this.mScrollState == 1) {
                int[] iArr3 = this.mReusableIntPair;
                iArr3[0] = 0;
                iArr3[1] = 0;
                if (dispatchNestedPreScroll(canScrollHorizontally ? i5 : 0, canScrollVertically ? i6 : 0, this.mReusableIntPair, this.mScrollOffset, 0)) {
                    int[] iArr4 = this.mReusableIntPair;
                    i5 -= iArr4[0];
                    i6 -= iArr4[1];
                    int[] iArr5 = this.mNestedOffsets;
                    int i7 = iArr5[0];
                    int[] iArr6 = this.mScrollOffset;
                    iArr5[0] = i7 + iArr6[0];
                    iArr5[1] = iArr5[1] + iArr6[1];
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                int i8 = i6;
                int[] iArr7 = this.mScrollOffset;
                this.mLastTouchX = x3 - iArr7[0];
                this.mLastTouchY = y2 - iArr7[1];
                if (scrollByInternal(canScrollHorizontally ? i5 : 0, canScrollVertically ? i8 : 0, motionEvent)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (this.mGapWorker != null && (i5 != 0 || i8 != 0)) {
                    this.mGapWorker.a(this, i5, i8);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        if (!z2) {
            this.mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f2 = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.mLayout.canScrollHorizontally()) {
                    f3 = motionEvent.getAxisValue(10);
                    if (f2 == 0.0f || f3 != 0.0f) {
                        scrollByInternal((int) (f3 * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f3 = 0.0f;
                if (f2 == 0.0f) {
                }
                scrollByInternal((int) (f3 * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (!this.mLayout.canScrollVertically()) {
                        if (this.mLayout.canScrollHorizontally()) {
                            f3 = axisValue;
                            f2 = 0.0f;
                            if (f2 == 0.0f) {
                            }
                            scrollByInternal((int) (f3 * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                        }
                    } else {
                        f2 = -axisValue;
                        f3 = 0.0f;
                        if (f2 == 0.0f) {
                        }
                        scrollByInternal((int) (f3 * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f2 = 0.0f;
                f3 = 0.0f;
                if (f2 == 0.0f) {
                }
                scrollByInternal((int) (f3 * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
            }
        }
        return false;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null) {
            defaultOnMeasure(i2, i3);
            return;
        }
        boolean z = false;
        if (iVar.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.mAdapter == null) {
                return;
            }
            if (this.mState.f2166d == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(i2, i3);
            this.mState.i = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.i = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                if (this.mState.k) {
                    this.mState.g = true;
                } else {
                    this.mAdapterHelper.e();
                    this.mState.g = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            a aVar = this.mAdapter;
            if (aVar != null) {
                this.mState.f2167e = aVar.getItemCount();
            } else {
                this.mState.f2167e = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            stopInterceptRequestLayout(false);
            this.mState.g = false;
        }
    }

    void defaultOnMeasure(int i2, int i3) {
        setMeasuredDimension(i.chooseSize(i2, getPaddingLeft() + getPaddingRight(), androidx.core.h.w.k(this)), i.chooseSize(i3, getPaddingTop() + getPaddingBottom(), androidx.core.h.w.l(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        invalidateGlows();
    }

    public void setItemAnimator(f fVar) {
        f fVar2 = this.mItemAnimator;
        if (fVar2 != null) {
            fVar2.d();
            this.mItemAnimator.a((f.b) null);
        }
        this.mItemAnimator = fVar;
        if (fVar != null) {
            fVar.a(this.mItemAnimatorListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onExitLayoutOrScroll(boolean z) {
        int i2 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i2;
        if (i2 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    private void dispatchContentChangedIfNecessary() {
        int i2 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i2 == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        androidx.core.h.a.b.a(obtain, i2);
        sendAccessibilityEventUnchecked(obtain);
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (isComputingLayout()) {
            int a2 = accessibilityEvent != null ? androidx.core.h.a.b.a(accessibilityEvent) : 0;
            this.mEatenAccessibilityChangeFlags |= a2 != 0 ? a2 : 0;
            return true;
        }
        return false;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public f getItemAnimator() {
        return this.mItemAnimator;
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        androidx.core.h.w.a(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.a();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.b();
        } else {
            this.mAdapterHelper.e();
        }
        boolean z = false;
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.j = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        u uVar = this.mState;
        if (uVar.j && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z = true;
        }
        uVar.k = z;
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            this.mState.i = false;
            if (this.mState.f2166d == 1) {
                dispatchLayoutStep1();
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else if (this.mAdapterHelper.f() || this.mLayout.getWidth() != getWidth() || this.mLayout.getHeight() != getHeight()) {
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else {
                this.mLayout.setExactMeasureSpecsFrom(this);
            }
            dispatchLayoutStep3();
        }
    }

    private void saveFocusInfo() {
        int adapterPosition;
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        x findContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (findContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.m = this.mAdapter.hasStableIds() ? findContainingViewHolder.getItemId() : -1L;
        u uVar = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            adapterPosition = -1;
        } else {
            adapterPosition = findContainingViewHolder.isRemoved() ? findContainingViewHolder.mOldPosition : findContainingViewHolder.getAdapterPosition();
        }
        uVar.l = adapterPosition;
        this.mState.n = getDeepestFocusedViewWithId(findContainingViewHolder.itemView);
    }

    private void resetFocusInfo() {
        this.mState.m = -1L;
        this.mState.l = -1;
        this.mState.n = -1;
    }

    private View findNextViewToFocus() {
        x findViewHolderForAdapterPosition;
        int i2 = this.mState.l != -1 ? this.mState.l : 0;
        int e2 = this.mState.e();
        for (int i3 = i2; i3 < e2; i3++) {
            x findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(e2, i2);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    private void recoverFocusFromState() {
        View findViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (IGNORE_DETACHED_FOCUSED_CHILD && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.mChildHelper.b() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.mChildHelper.c(focusedChild)) {
                return;
            }
        }
        View view = null;
        x findViewHolderForItemId = (this.mState.m == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.m);
        if (findViewHolderForItemId == null || this.mChildHelper.c(findViewHolderForItemId.itemView) || !findViewHolderForItemId.itemView.hasFocusable()) {
            if (this.mChildHelper.b() > 0) {
                view = findNextViewToFocus();
            }
        } else {
            view = findViewHolderForItemId.itemView;
        }
        if (view != null) {
            if (this.mState.n != -1 && (findViewById = view.findViewById(this.mState.n)) != null && findViewById.isFocusable()) {
                view = findViewById;
            }
            view.requestFocus();
        }
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    final void fillRemainingScrollValues(u uVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.f2169a;
            uVar.o = overScroller.getFinalX() - overScroller.getCurrX();
            uVar.p = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        uVar.o = 0;
        uVar.p = 0;
    }

    private void dispatchLayoutStep1() {
        boolean z = true;
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.i = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        u uVar = this.mState;
        uVar.h = (uVar.j && this.mItemsChanged) ? false : false;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        u uVar2 = this.mState;
        uVar2.g = uVar2.k;
        this.mState.f2167e = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.j) {
            int b2 = this.mChildHelper.b();
            for (int i2 = 0; i2 < b2; i2++) {
                x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(i2));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.a(childViewHolderInt, this.mItemAnimator.a(this.mState, childViewHolderInt, f.e(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.h && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.a(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.k) {
            saveOldPositions();
            boolean z2 = this.mState.f;
            this.mState.f = false;
            this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
            this.mState.f = z2;
            for (int i3 = 0; i3 < this.mChildHelper.b(); i3++) {
                x childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.b(i3));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.d(childViewHolderInt2)) {
                    int e2 = f.e(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        e2 |= 4096;
                    }
                    f.c a2 = this.mItemAnimator.a(this.mState, childViewHolderInt2, e2, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, a2);
                    } else {
                        this.mViewInfoStore.b(childViewHolderInt2, a2);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f2166d = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.e();
        this.mState.f2167e = this.mAdapter.getItemCount();
        this.mState.f2165c = 0;
        this.mState.g = false;
        this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
        this.mState.f = false;
        this.mPendingSavedState = null;
        u uVar = this.mState;
        uVar.j = uVar.j && this.mItemAnimator != null;
        this.mState.f2166d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.f2166d = 1;
        if (this.mState.j) {
            for (int b2 = this.mChildHelper.b() - 1; b2 >= 0; b2--) {
                x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(b2));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    f.c a2 = this.mItemAnimator.a(this.mState, childViewHolderInt);
                    x a3 = this.mViewInfoStore.a(changedHolderKey);
                    if (a3 != null && !a3.shouldIgnore()) {
                        boolean a4 = this.mViewInfoStore.a(a3);
                        boolean a5 = this.mViewInfoStore.a(childViewHolderInt);
                        if (a4 && a3 == childViewHolderInt) {
                            this.mViewInfoStore.c(childViewHolderInt, a2);
                        } else {
                            f.c b3 = this.mViewInfoStore.b(a3);
                            this.mViewInfoStore.c(childViewHolderInt, a2);
                            f.c c2 = this.mViewInfoStore.c(childViewHolderInt);
                            if (b3 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, a3);
                            } else {
                                animateChange(a3, childViewHolderInt, b3, c2, a4, a5);
                            }
                        }
                    } else {
                        this.mViewInfoStore.c(childViewHolderInt, a2);
                    }
                }
            }
            this.mViewInfoStore.a(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        u uVar = this.mState;
        uVar.f2164b = uVar.f2167e;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mState.j = false;
        this.mState.k = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        if (this.mRecycler.f2152b != null) {
            this.mRecycler.f2152b.clear();
        }
        if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch) {
            this.mLayout.mPrefetchMaxCountObserved = 0;
            this.mLayout.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.b();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.a();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long j2, x xVar, x xVar2) {
        int b2 = this.mChildHelper.b();
        for (int i2 = 0; i2 < b2; i2++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(i2));
            if (childViewHolderInt != xVar && getChangedHolderKey(childViewHolderInt) == j2) {
                a aVar = this.mAdapter;
                if (aVar != null && aVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + xVar + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + xVar + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + xVar2 + " cannot be found but it is necessary for " + xVar + exceptionLabel());
    }

    void recordAnimationInfoIfBouncedHiddenView(x xVar, f.c cVar) {
        xVar.setFlags(0, 8192);
        if (this.mState.h && xVar.isUpdated() && !xVar.isRemoved() && !xVar.shouldIgnore()) {
            this.mViewInfoStore.a(getChangedHolderKey(xVar), xVar);
        }
        this.mViewInfoStore.a(xVar, cVar);
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int b2 = this.mChildHelper.b();
        if (b2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < b2; i4++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.b(i4));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    private boolean didChildRangeChange(int i2, int i3) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        x childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    long getChangedHolderKey(x xVar) {
        return this.mAdapter.hasStableIds() ? xVar.getItemId() : xVar.mPosition;
    }

    void animateAppearance(x xVar, f.c cVar, f.c cVar2) {
        xVar.setIsRecyclable(false);
        if (this.mItemAnimator.b(xVar, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(x xVar, f.c cVar, f.c cVar2) {
        addAnimatingView(xVar);
        xVar.setIsRecyclable(false);
        if (this.mItemAnimator.a(xVar, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void animateChange(x xVar, x xVar2, f.c cVar, f.c cVar2, boolean z, boolean z2) {
        xVar.setIsRecyclable(false);
        if (z) {
            addAnimatingView(xVar);
        }
        if (xVar != xVar2) {
            if (z2) {
                addAnimatingView(xVar2);
            }
            xVar.mShadowedHolder = xVar2;
            addAnimatingView(xVar);
            this.mRecycler.c(xVar);
            xVar2.setIsRecyclable(false);
            xVar2.mShadowingHolder = xVar;
        }
        if (this.mItemAnimator.a(xVar, xVar2, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        androidx.core.d.d.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.d.d.a();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutSuppressed) {
            super.requestLayout();
        } else {
            this.mLayoutWasDefered = true;
        }
    }

    void markItemDecorInsetsDirty() {
        int c2 = this.mChildHelper.c();
        for (int i2 = 0; i2 < c2; i2++) {
            ((j) this.mChildHelper.d(i2).getLayoutParams()).f2144e = true;
        }
        this.mRecycler.j();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z3 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(save4);
        }
        if (z || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.b()) {
            z3 = z;
        }
        if (z3) {
            androidx.core.h.w.e(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDraw(canvas, this, this.mState);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof j) && this.mLayout.checkLayoutParams((j) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        i iVar = this.mLayout;
        if (iVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return iVar.generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        i iVar = this.mLayout;
        if (iVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return iVar.generateLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        i iVar = this.mLayout;
        if (iVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return iVar.generateLayoutParams(layoutParams);
    }

    public boolean isAnimating() {
        f fVar = this.mItemAnimator;
        return fVar != null && fVar.b();
    }

    void saveOldPositions() {
        int c2 = this.mChildHelper.c();
        for (int i2 = 0; i2 < c2; i2++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    void clearOldPositions() {
        int c2 = this.mChildHelper.c();
        for (int i2 = 0; i2 < c2; i2++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.i();
    }

    void offsetPositionRecordsForMove(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int c2 = this.mChildHelper.c();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i7 = 0; i7 < c2; i7++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i7));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= i5 && childViewHolderInt.mPosition <= i4) {
                if (childViewHolderInt.mPosition == i2) {
                    childViewHolderInt.offsetPosition(i3 - i2, false);
                } else {
                    childViewHolderInt.offsetPosition(i6, false);
                }
                this.mState.f = true;
            }
        }
        this.mRecycler.a(i2, i3);
        requestLayout();
    }

    void offsetPositionRecordsForInsert(int i2, int i3) {
        int c2 = this.mChildHelper.c();
        for (int i4 = 0; i4 < c2; i4++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2) {
                childViewHolderInt.offsetPosition(i3, false);
                this.mState.f = true;
            }
        }
        this.mRecycler.b(i2, i3);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        int c2 = this.mChildHelper.c();
        for (int i5 = 0; i5 < c2; i5++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i5));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.mPosition >= i4) {
                    childViewHolderInt.offsetPosition(-i3, z);
                    this.mState.f = true;
                } else if (childViewHolderInt.mPosition >= i2) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i2 - 1, -i3, z);
                    this.mState.f = true;
                }
            }
        }
        this.mRecycler.a(i2, i3, z);
        requestLayout();
    }

    void viewRangeUpdate(int i2, int i3, Object obj) {
        int c2 = this.mChildHelper.c();
        int i4 = i2 + i3;
        for (int i5 = 0; i5 < c2; i5++) {
            View d2 = this.mChildHelper.d(i5);
            x childViewHolderInt = getChildViewHolderInt(d2);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2 && childViewHolderInt.mPosition < i4) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((j) d2.getLayoutParams()).f2144e = true;
            }
        }
        this.mRecycler.c(i2, i3);
    }

    boolean canReuseUpdatedViewHolder(x xVar) {
        f fVar = this.mItemAnimator;
        return fVar == null || fVar.a(xVar, xVar.getUnmodifiedPayloads());
    }

    void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void markKnownViewsInvalid() {
        int c2 = this.mChildHelper.c();
        for (int i2 = 0; i2 < c2; i2++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.h();
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public x getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return getChildViewHolderInt(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        return null;
    }

    public x findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((j) view.getLayoutParams()).f2142c;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public int getChildAdapterPosition(View view) {
        x childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    public int getChildLayoutPosition(View view) {
        x childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    public long getChildItemId(View view) {
        x childViewHolderInt;
        a aVar = this.mAdapter;
        if (aVar == null || !aVar.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    @Deprecated
    public x findViewHolderForPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    public x findViewHolderForLayoutPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    public x findViewHolderForAdapterPosition(int i2) {
        x xVar = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int c2 = this.mChildHelper.c();
        for (int i3 = 0; i3 < c2; i3++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i2) {
                if (!this.mChildHelper.c(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                xVar = childViewHolderInt;
            }
        }
        return xVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    x findViewHolderForPosition(int i2, boolean z) {
        int c2 = this.mChildHelper.c();
        x xVar = null;
        for (int i3 = 0; i3 < c2; i3++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z) {
                    if (childViewHolderInt.mPosition != i2) {
                        continue;
                    }
                    if (this.mChildHelper.c(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    xVar = childViewHolderInt;
                } else {
                    if (childViewHolderInt.getLayoutPosition() != i2) {
                        continue;
                    }
                    if (this.mChildHelper.c(childViewHolderInt.itemView)) {
                    }
                }
            }
        }
        return xVar;
    }

    public x findViewHolderForItemId(long j2) {
        a aVar = this.mAdapter;
        x xVar = null;
        if (aVar != null && aVar.hasStableIds()) {
            int c2 = this.mChildHelper.c();
            for (int i2 = 0; i2 < c2; i2++) {
                x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j2) {
                    if (!this.mChildHelper.c(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    xVar = childViewHolderInt;
                }
            }
        }
        return xVar;
    }

    public View findChildViewUnder(float f2, float f3) {
        for (int b2 = this.mChildHelper.b() - 1; b2 >= 0; b2--) {
            View b3 = this.mChildHelper.b(b2);
            float translationX = b3.getTranslationX();
            float translationY = b3.getTranslationY();
            if (f2 >= b3.getLeft() + translationX && f2 <= b3.getRight() + translationX && f3 >= b3.getTop() + translationY && f3 <= b3.getBottom() + translationY) {
                return b3;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void offsetChildrenVertical(int i2) {
        int b2 = this.mChildHelper.b();
        for (int i3 = 0; i3 < b2; i3++) {
            this.mChildHelper.b(i3).offsetTopAndBottom(i2);
        }
    }

    public void offsetChildrenHorizontal(int i2) {
        int b2 = this.mChildHelper.b();
        for (int i3 = 0; i3 < b2; i3++) {
            this.mChildHelper.b(i3).offsetLeftAndRight(i2);
        }
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        j jVar = (j) view.getLayoutParams();
        Rect rect2 = jVar.f2143d;
        rect.set((view.getLeft() - rect2.left) - jVar.leftMargin, (view.getTop() - rect2.top) - jVar.topMargin, view.getRight() + rect2.right + jVar.rightMargin, view.getBottom() + rect2.bottom + jVar.bottomMargin);
    }

    Rect getItemDecorInsetsForChild(View view) {
        j jVar = (j) view.getLayoutParams();
        if (!jVar.f2144e) {
            return jVar.f2143d;
        }
        if (this.mState.a() && (jVar.e() || jVar.c())) {
            return jVar.f2143d;
        }
        Rect rect = jVar.f2143d;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i2).getItemOffsets(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        jVar.f2144e = false;
        return rect;
    }

    void dispatchOnScrolled(int i2, int i3) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        onScrolled(i2, i3);
        n nVar = this.mScrollListener;
        if (nVar != null) {
            nVar.onScrolled(this, i2, i3);
        }
        List<n> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i2, i3);
            }
        }
        this.mDispatchScrollCounter--;
    }

    void dispatchOnScrollStateChanged(int i2) {
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.onScrollStateChanged(i2);
        }
        onScrollStateChanged(i2);
        n nVar = this.mScrollListener;
        if (nVar != null) {
            nVar.onScrollStateChanged(this, i2);
        }
        List<n> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i2);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class w implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        OverScroller f2169a;

        /* renamed from: d  reason: collision with root package name */
        private int f2172d;

        /* renamed from: e  reason: collision with root package name */
        private int f2173e;

        /* renamed from: b  reason: collision with root package name */
        Interpolator f2170b = RecyclerView.sQuinticInterpolator;
        private boolean f = false;
        private boolean g = false;

        w() {
            this.f2169a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            if (RecyclerView.this.mLayout == null) {
                b();
                return;
            }
            this.g = false;
            this.f = true;
            RecyclerView.this.consumePendingUpdateOperations();
            OverScroller overScroller = this.f2169a;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f2172d;
                int i4 = currY - this.f2173e;
                this.f2172d = currX;
                this.f2173e = currY;
                RecyclerView.this.mReusableIntPair[0] = 0;
                RecyclerView.this.mReusableIntPair[1] = 0;
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.dispatchNestedPreScroll(i3, i4, recyclerView.mReusableIntPair, null, 1)) {
                    i3 -= RecyclerView.this.mReusableIntPair[0];
                    i4 -= RecyclerView.this.mReusableIntPair[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i3, i4);
                }
                if (RecyclerView.this.mAdapter != null) {
                    RecyclerView.this.mReusableIntPair[0] = 0;
                    RecyclerView.this.mReusableIntPair[1] = 0;
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.scrollStep(i3, i4, recyclerView2.mReusableIntPair);
                    i = RecyclerView.this.mReusableIntPair[0];
                    i2 = RecyclerView.this.mReusableIntPair[1];
                    i3 -= i;
                    i4 -= i2;
                    t tVar = RecyclerView.this.mLayout.mSmoothScroller;
                    if (tVar != null && !tVar.isPendingInitialRun() && tVar.isRunning()) {
                        int e2 = RecyclerView.this.mState.e();
                        if (e2 == 0) {
                            tVar.stop();
                        } else if (tVar.getTargetPosition() >= e2) {
                            tVar.setTargetPosition(e2 - 1);
                            tVar.onAnimation(i, i2);
                        } else {
                            tVar.onAnimation(i, i2);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView.this.mReusableIntPair[0] = 0;
                RecyclerView.this.mReusableIntPair[1] = 0;
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.dispatchNestedScroll(i, i2, i3, i4, null, 1, recyclerView3.mReusableIntPair);
                int i5 = i3 - RecyclerView.this.mReusableIntPair[0];
                int i6 = i4 - RecyclerView.this.mReusableIntPair[1];
                if (i != 0 || i2 != 0) {
                    RecyclerView.this.dispatchOnScrolled(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                t tVar2 = RecyclerView.this.mLayout.mSmoothScroller;
                if (!(tVar2 != null && tVar2.isPendingInitialRun()) && z) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i7, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.a();
                    }
                } else {
                    a();
                    if (RecyclerView.this.mGapWorker != null) {
                        RecyclerView.this.mGapWorker.a(RecyclerView.this, i, i2);
                    }
                }
            }
            t tVar3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (tVar3 != null && tVar3.isPendingInitialRun()) {
                tVar3.onAnimation(0, 0);
            }
            this.f = false;
            if (this.g) {
                c();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }

        void a() {
            if (this.f) {
                this.g = true;
            } else {
                c();
            }
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            androidx.core.h.w.a(RecyclerView.this, this);
        }

        public void a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f2173e = 0;
            this.f2172d = 0;
            if (this.f2170b != RecyclerView.sQuinticInterpolator) {
                this.f2170b = RecyclerView.sQuinticInterpolator;
                this.f2169a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
            }
            this.f2169a.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = a(i, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f2170b != interpolator) {
                this.f2170b = interpolator;
                this.f2169a = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f2173e = 0;
            this.f2172d = 0;
            RecyclerView.this.setScrollState(2);
            this.f2169a.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.f2169a.computeScrollOffset();
            }
            a();
        }

        private float a(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int a(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int sqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i6 = width / 2;
            float f = width;
            float f2 = i6;
            float a2 = f2 + (a(Math.min(1.0f, (sqrt2 * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(a2 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((abs / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, (int) RecyclerView.MAX_SCROLL_DURATION);
        }

        public void b() {
            RecyclerView.this.removeCallbacks(this);
            this.f2169a.abortAnimation();
        }
    }

    void repositionShadowingViews() {
        int b2 = this.mChildHelper.b();
        for (int i2 = 0; i2 < b2; i2++) {
            View b3 = this.mChildHelper.b(i2);
            x childViewHolder = getChildViewHolder(b3);
            if (childViewHolder != null && childViewHolder.mShadowingHolder != null) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = b3.getLeft();
                int top = b3.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class r extends c {
        r() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView.this.mState.f = true;
            RecyclerView.this.processDataSetCompletelyChanged(true);
            if (RecyclerView.this.mAdapterHelper.d()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.a(i, i2, obj)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.b(i, i2)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.c(i, i2)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.a(i, i2, i3)) {
                a();
            }
        }

        void a() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION && RecyclerView.this.mHasFixedSize && RecyclerView.this.mIsAttached) {
                RecyclerView recyclerView = RecyclerView.this;
                androidx.core.h.w.a(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                return;
            }
            RecyclerView.this.mAdapterUpdateDuringMeasure = true;
            RecyclerView.this.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        protected EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static class o {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<a> f2145a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private int f2146b = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<x> f2147a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f2148b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f2149c = 0;

            /* renamed from: d  reason: collision with root package name */
            long f2150d = 0;

            a() {
            }
        }

        public void a() {
            for (int i = 0; i < this.f2145a.size(); i++) {
                this.f2145a.valueAt(i).f2147a.clear();
            }
        }

        public x a(int i) {
            a aVar = this.f2145a.get(i);
            if (aVar == null || aVar.f2147a.isEmpty()) {
                return null;
            }
            ArrayList<x> arrayList = aVar.f2147a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public void a(x xVar) {
            int itemViewType = xVar.getItemViewType();
            ArrayList<x> arrayList = b(itemViewType).f2147a;
            if (this.f2145a.get(itemViewType).f2148b <= arrayList.size()) {
                return;
            }
            xVar.resetInternal();
            arrayList.add(xVar);
        }

        long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        void a(int i, long j) {
            a b2 = b(i);
            b2.f2149c = a(b2.f2149c, j);
        }

        void b(int i, long j) {
            a b2 = b(i);
            b2.f2150d = a(b2.f2150d, j);
        }

        boolean a(int i, long j, long j2) {
            long j3 = b(i).f2149c;
            return j3 == 0 || j + j3 < j2;
        }

        boolean b(int i, long j, long j2) {
            long j3 = b(i).f2150d;
            return j3 == 0 || j + j3 < j2;
        }

        void b() {
            this.f2146b++;
        }

        void c() {
            this.f2146b--;
        }

        void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                c();
            }
            if (!z && this.f2146b == 0) {
                a();
            }
            if (aVar2 != null) {
                b();
            }
        }

        private a b(int i) {
            a aVar = this.f2145a.get(i);
            if (aVar == null) {
                a aVar2 = new a();
                this.f2145a.put(i, aVar2);
                return aVar2;
            }
            return aVar;
        }
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof RecyclerView) {
                return (RecyclerView) view;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i2));
                if (findNestedRecyclerView != null) {
                    return findNestedRecyclerView;
                }
            }
            return null;
        }
        return null;
    }

    static void clearNestedRecyclerViewIfNotNested(x xVar) {
        if (xVar.mNestedRecyclerView != null) {
            RecyclerView recyclerView = xVar.mNestedRecyclerView.get();
            while (recyclerView != null) {
                if (recyclerView == xVar.itemView) {
                    return;
                }
                ViewParent parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            xVar.mNestedRecyclerView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    /* loaded from: classes.dex */
    public final class p {

        /* renamed from: e  reason: collision with root package name */
        o f2155e;
        private v i;

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<x> f2151a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        ArrayList<x> f2152b = null;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<x> f2153c = new ArrayList<>();
        private final List<x> g = Collections.unmodifiableList(this.f2151a);
        private int h = 2;

        /* renamed from: d  reason: collision with root package name */
        int f2154d = 2;

        public p() {
        }

        public void a() {
            this.f2151a.clear();
            d();
        }

        public void a(int i) {
            this.h = i;
            b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            this.f2154d = this.h + (RecyclerView.this.mLayout != null ? RecyclerView.this.mLayout.mPrefetchMaxCountObserved : 0);
            for (int size = this.f2153c.size() - 1; size >= 0 && this.f2153c.size() > this.f2154d; size--) {
                d(size);
            }
        }

        public List<x> c() {
            return this.g;
        }

        boolean a(x xVar) {
            if (xVar.isRemoved()) {
                return RecyclerView.this.mState.a();
            }
            if (xVar.mPosition < 0 || xVar.mPosition >= RecyclerView.this.mAdapter.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + xVar + RecyclerView.this.exceptionLabel());
            } else if (RecyclerView.this.mState.a() || RecyclerView.this.mAdapter.getItemViewType(xVar.mPosition) == xVar.getItemViewType()) {
                return !RecyclerView.this.mAdapter.hasStableIds() || xVar.getItemId() == RecyclerView.this.mAdapter.getItemId(xVar.mPosition);
            } else {
                return false;
            }
        }

        private boolean a(x xVar, int i, int i2, long j) {
            xVar.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = xVar.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j == RecyclerView.FOREVER_NS || this.f2155e.b(itemViewType, nanoTime, j)) {
                RecyclerView.this.mAdapter.bindViewHolder(xVar, i);
                this.f2155e.b(xVar.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
                e(xVar);
                if (RecyclerView.this.mState.a()) {
                    xVar.mPreLayoutPosition = i2;
                    return true;
                }
                return true;
            }
            return false;
        }

        public int b(int i) {
            if (i >= 0 && i < RecyclerView.this.mState.e()) {
                return !RecyclerView.this.mState.a() ? i : RecyclerView.this.mAdapterHelper.b(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.mState.e() + RecyclerView.this.exceptionLabel());
        }

        public View c(int i) {
            return a(i, false);
        }

        View a(int i, boolean z) {
            return a(i, z, RecyclerView.FOREVER_NS).itemView;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:100:0x0210  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x022c A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0187  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01a4  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01c9  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x01d8  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0202  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public x a(int i, boolean z, long j) {
            x xVar;
            boolean z2;
            x xVar2;
            boolean z3;
            boolean a2;
            ViewGroup.LayoutParams layoutParams;
            j jVar;
            RecyclerView findNestedRecyclerView;
            v vVar;
            View a3;
            if (i < 0 || i >= RecyclerView.this.mState.e()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.mState.e() + RecyclerView.this.exceptionLabel());
            }
            boolean z4 = true;
            if (RecyclerView.this.mState.a()) {
                xVar = f(i);
                if (xVar != null) {
                    z2 = true;
                    if (xVar == null && (xVar = b(i, z)) != null) {
                        if (a(xVar)) {
                            if (!z) {
                                xVar.addFlags(4);
                                if (xVar.isScrap()) {
                                    RecyclerView.this.removeDetachedView(xVar.itemView, false);
                                    xVar.unScrap();
                                } else if (xVar.wasReturnedFromScrap()) {
                                    xVar.clearReturnedFromScrapFlag();
                                }
                                b(xVar);
                            }
                            xVar = null;
                        } else {
                            z2 = true;
                        }
                    }
                    if (xVar == null) {
                        int b2 = RecyclerView.this.mAdapterHelper.b(i);
                        if (b2 < 0 || b2 >= RecyclerView.this.mAdapter.getItemCount()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b2 + ").state:" + RecyclerView.this.mState.e() + RecyclerView.this.exceptionLabel());
                        }
                        int itemViewType = RecyclerView.this.mAdapter.getItemViewType(b2);
                        if (RecyclerView.this.mAdapter.hasStableIds() && (xVar = a(RecyclerView.this.mAdapter.getItemId(b2), itemViewType, z)) != null) {
                            xVar.mPosition = b2;
                            z2 = true;
                        }
                        if (xVar == null && (vVar = this.i) != null && (a3 = vVar.a(this, i, itemViewType)) != null) {
                            xVar = RecyclerView.this.getChildViewHolder(a3);
                            if (xVar == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.exceptionLabel());
                            } else if (xVar.shouldIgnore()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.exceptionLabel());
                            }
                        }
                        if (xVar == null) {
                            x a4 = g().a(itemViewType);
                            if (a4 != null) {
                                a4.resetInternal();
                                if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                    f(a4);
                                }
                            }
                            xVar = a4;
                        }
                        if (xVar == null) {
                            long nanoTime = RecyclerView.this.getNanoTime();
                            if (j == RecyclerView.FOREVER_NS || this.f2155e.a(itemViewType, nanoTime, j)) {
                                x createViewHolder = RecyclerView.this.mAdapter.createViewHolder(RecyclerView.this, itemViewType);
                                if (RecyclerView.ALLOW_THREAD_GAP_WORK && (findNestedRecyclerView = RecyclerView.findNestedRecyclerView(createViewHolder.itemView)) != null) {
                                    createViewHolder.mNestedRecyclerView = new WeakReference<>(findNestedRecyclerView);
                                }
                                this.f2155e.a(itemViewType, RecyclerView.this.getNanoTime() - nanoTime);
                                xVar2 = createViewHolder;
                                z3 = z2;
                                if (z3 && !RecyclerView.this.mState.a() && xVar2.hasAnyOfTheFlags(8192)) {
                                    xVar2.setFlags(0, 8192);
                                    if (RecyclerView.this.mState.j) {
                                        RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(xVar2, RecyclerView.this.mItemAnimator.a(RecyclerView.this.mState, xVar2, f.e(xVar2) | 4096, xVar2.getUnmodifiedPayloads()));
                                    }
                                }
                                if (!RecyclerView.this.mState.a() && xVar2.isBound()) {
                                    xVar2.mPreLayoutPosition = i;
                                } else if (xVar2.isBound() || xVar2.needsUpdate() || xVar2.isInvalid()) {
                                    a2 = a(xVar2, RecyclerView.this.mAdapterHelper.b(i), i, j);
                                    layoutParams = xVar2.itemView.getLayoutParams();
                                    if (layoutParams != null) {
                                        jVar = (j) RecyclerView.this.generateDefaultLayoutParams();
                                        xVar2.itemView.setLayoutParams(jVar);
                                    } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                                        jVar = (j) RecyclerView.this.generateLayoutParams(layoutParams);
                                        xVar2.itemView.setLayoutParams(jVar);
                                    } else {
                                        jVar = (j) layoutParams;
                                    }
                                    jVar.f2142c = xVar2;
                                    jVar.f = (z3 || !a2) ? false : false;
                                    return xVar2;
                                }
                                a2 = false;
                                layoutParams = xVar2.itemView.getLayoutParams();
                                if (layoutParams != null) {
                                }
                                jVar.f2142c = xVar2;
                                jVar.f = (z3 || !a2) ? false : false;
                                return xVar2;
                            }
                            return null;
                        }
                    }
                    xVar2 = xVar;
                    z3 = z2;
                    if (z3) {
                        xVar2.setFlags(0, 8192);
                        if (RecyclerView.this.mState.j) {
                        }
                    }
                    if (!RecyclerView.this.mState.a()) {
                    }
                    if (xVar2.isBound()) {
                    }
                    a2 = a(xVar2, RecyclerView.this.mAdapterHelper.b(i), i, j);
                    layoutParams = xVar2.itemView.getLayoutParams();
                    if (layoutParams != null) {
                    }
                    jVar.f2142c = xVar2;
                    jVar.f = (z3 || !a2) ? false : false;
                    return xVar2;
                }
            } else {
                xVar = null;
            }
            z2 = false;
            if (xVar == null) {
                if (a(xVar)) {
                }
            }
            if (xVar == null) {
            }
            xVar2 = xVar;
            z3 = z2;
            if (z3) {
            }
            if (!RecyclerView.this.mState.a()) {
            }
            if (xVar2.isBound()) {
            }
            a2 = a(xVar2, RecyclerView.this.mAdapterHelper.b(i), i, j);
            layoutParams = xVar2.itemView.getLayoutParams();
            if (layoutParams != null) {
            }
            jVar.f2142c = xVar2;
            jVar.f = (z3 || !a2) ? false : false;
            return xVar2;
        }

        private void e(x xVar) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = xVar.itemView;
                if (androidx.core.h.w.f(view) == 0) {
                    androidx.core.h.w.b(view, 1);
                }
                if (RecyclerView.this.mAccessibilityDelegate == null) {
                    return;
                }
                androidx.core.h.a b2 = RecyclerView.this.mAccessibilityDelegate.b();
                if (b2 instanceof u.a) {
                    ((u.a) b2).a(view);
                }
                androidx.core.h.w.a(view, b2);
            }
        }

        private void f(x xVar) {
            if (xVar.itemView instanceof ViewGroup) {
                a((ViewGroup) xVar.itemView, false);
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public void a(View view) {
            x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            b(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                return;
            }
            RecyclerView.this.mItemAnimator.d(childViewHolderInt);
        }

        void d() {
            for (int size = this.f2153c.size() - 1; size >= 0; size--) {
                d(size);
            }
            this.f2153c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.a();
            }
        }

        void d(int i) {
            a(this.f2153c.get(i), true);
            this.f2153c.remove(i);
        }

        void b(x xVar) {
            boolean z;
            boolean z2 = true;
            if (xVar.isScrap() || xVar.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(xVar.isScrap());
                sb.append(" isAttached:");
                sb.append(xVar.itemView.getParent() != null);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            } else if (xVar.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + xVar + RecyclerView.this.exceptionLabel());
            } else if (xVar.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            } else {
                boolean doesTransientStatePreventRecycling = xVar.doesTransientStatePreventRecycling();
                if ((RecyclerView.this.mAdapter != null && doesTransientStatePreventRecycling && RecyclerView.this.mAdapter.onFailedToRecycleView(xVar)) || xVar.isRecyclable()) {
                    if (this.f2154d <= 0 || xVar.hasAnyOfTheFlags(526)) {
                        z = false;
                    } else {
                        int size = this.f2153c.size();
                        if (size >= this.f2154d && size > 0) {
                            d(0);
                            size--;
                        }
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.a(xVar.mPosition)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.mPrefetchRegistry.a(this.f2153c.get(i).mPosition)) {
                                    break;
                                }
                                i--;
                            }
                            size = i + 1;
                        }
                        this.f2153c.add(size, xVar);
                        z = true;
                    }
                    if (!z) {
                        a(xVar, true);
                        r1 = z;
                        RecyclerView.this.mViewInfoStore.g(xVar);
                        if (r1 && !z2 && doesTransientStatePreventRecycling) {
                            xVar.mOwnerRecyclerView = null;
                            return;
                        }
                        return;
                    }
                    r1 = z;
                }
                z2 = false;
                RecyclerView.this.mViewInfoStore.g(xVar);
                if (r1) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(x xVar, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(xVar);
            View view = xVar.itemView;
            if (RecyclerView.this.mAccessibilityDelegate != null) {
                androidx.core.h.a b2 = RecyclerView.this.mAccessibilityDelegate.b();
                androidx.core.h.w.a(view, b2 instanceof u.a ? ((u.a) b2).b(view) : null);
            }
            if (z) {
                d(xVar);
            }
            xVar.mOwnerRecyclerView = null;
            g().a(xVar);
        }

        void b(View view) {
            x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            b(childViewHolderInt);
        }

        void c(View view) {
            x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.hasAnyOfTheFlags(12) || !childViewHolderInt.isUpdated() || RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !RecyclerView.this.mAdapter.hasStableIds()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.setScrapContainer(this, false);
                this.f2151a.add(childViewHolderInt);
                return;
            }
            if (this.f2152b == null) {
                this.f2152b = new ArrayList<>();
            }
            childViewHolderInt.setScrapContainer(this, true);
            this.f2152b.add(childViewHolderInt);
        }

        void c(x xVar) {
            if (xVar.mInChangeScrap) {
                this.f2152b.remove(xVar);
            } else {
                this.f2151a.remove(xVar);
            }
            xVar.mScrapContainer = null;
            xVar.mInChangeScrap = false;
            xVar.clearReturnedFromScrapFlag();
        }

        int e() {
            return this.f2151a.size();
        }

        View e(int i) {
            return this.f2151a.get(i).itemView;
        }

        void f() {
            this.f2151a.clear();
            ArrayList<x> arrayList = this.f2152b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        x f(int i) {
            int size;
            int b2;
            ArrayList<x> arrayList = this.f2152b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    x xVar = this.f2152b.get(i2);
                    if (!xVar.wasReturnedFromScrap() && xVar.getLayoutPosition() == i) {
                        xVar.addFlags(32);
                        return xVar;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (b2 = RecyclerView.this.mAdapterHelper.b(i)) > 0 && b2 < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(b2);
                    for (int i3 = 0; i3 < size; i3++) {
                        x xVar2 = this.f2152b.get(i3);
                        if (!xVar2.wasReturnedFromScrap() && xVar2.getItemId() == itemId) {
                            xVar2.addFlags(32);
                            return xVar2;
                        }
                    }
                }
            }
            return null;
        }

        x b(int i, boolean z) {
            View c2;
            int size = this.f2151a.size();
            for (int i2 = 0; i2 < size; i2++) {
                x xVar = this.f2151a.get(i2);
                if (!xVar.wasReturnedFromScrap() && xVar.getLayoutPosition() == i && !xVar.isInvalid() && (RecyclerView.this.mState.g || !xVar.isRemoved())) {
                    xVar.addFlags(32);
                    return xVar;
                }
            }
            if (!z && (c2 = RecyclerView.this.mChildHelper.c(i)) != null) {
                x childViewHolderInt = RecyclerView.getChildViewHolderInt(c2);
                RecyclerView.this.mChildHelper.e(c2);
                int b2 = RecyclerView.this.mChildHelper.b(c2);
                if (b2 == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                RecyclerView.this.mChildHelper.e(b2);
                c(c2);
                childViewHolderInt.addFlags(8224);
                return childViewHolderInt;
            }
            int size2 = this.f2153c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                x xVar2 = this.f2153c.get(i3);
                if (!xVar2.isInvalid() && xVar2.getLayoutPosition() == i && !xVar2.isAttachedToTransitionOverlay()) {
                    if (!z) {
                        this.f2153c.remove(i3);
                    }
                    return xVar2;
                }
            }
            return null;
        }

        x a(long j, int i, boolean z) {
            for (int size = this.f2151a.size() - 1; size >= 0; size--) {
                x xVar = this.f2151a.get(size);
                if (xVar.getItemId() == j && !xVar.wasReturnedFromScrap()) {
                    if (i == xVar.getItemViewType()) {
                        xVar.addFlags(32);
                        if (xVar.isRemoved() && !RecyclerView.this.mState.a()) {
                            xVar.setFlags(2, 14);
                        }
                        return xVar;
                    } else if (!z) {
                        this.f2151a.remove(size);
                        RecyclerView.this.removeDetachedView(xVar.itemView, false);
                        b(xVar.itemView);
                    }
                }
            }
            int size2 = this.f2153c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                x xVar2 = this.f2153c.get(size2);
                if (xVar2.getItemId() == j && !xVar2.isAttachedToTransitionOverlay()) {
                    if (i == xVar2.getItemViewType()) {
                        if (!z) {
                            this.f2153c.remove(size2);
                        }
                        return xVar2;
                    } else if (!z) {
                        d(size2);
                        return null;
                    }
                }
            }
        }

        void d(x xVar) {
            if (RecyclerView.this.mRecyclerListener != null) {
                RecyclerView.this.mRecyclerListener.a(xVar);
            }
            if (RecyclerView.this.mAdapter != null) {
                RecyclerView.this.mAdapter.onViewRecycled(xVar);
            }
            if (RecyclerView.this.mState != null) {
                RecyclerView.this.mViewInfoStore.g(xVar);
            }
        }

        void a(a aVar, a aVar2, boolean z) {
            a();
            g().a(aVar, aVar2, z);
        }

        void a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.f2153c.size();
            for (int i6 = 0; i6 < size; i6++) {
                x xVar = this.f2153c.get(i6);
                if (xVar != null && xVar.mPosition >= i5 && xVar.mPosition <= i4) {
                    if (xVar.mPosition == i) {
                        xVar.offsetPosition(i2 - i, false);
                    } else {
                        xVar.offsetPosition(i3, false);
                    }
                }
            }
        }

        void b(int i, int i2) {
            int size = this.f2153c.size();
            for (int i3 = 0; i3 < size; i3++) {
                x xVar = this.f2153c.get(i3);
                if (xVar != null && xVar.mPosition >= i) {
                    xVar.offsetPosition(i2, true);
                }
            }
        }

        void a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f2153c.size() - 1; size >= 0; size--) {
                x xVar = this.f2153c.get(size);
                if (xVar != null) {
                    if (xVar.mPosition >= i3) {
                        xVar.offsetPosition(-i2, z);
                    } else if (xVar.mPosition >= i) {
                        xVar.addFlags(8);
                        d(size);
                    }
                }
            }
        }

        void a(v vVar) {
            this.i = vVar;
        }

        void a(o oVar) {
            o oVar2 = this.f2155e;
            if (oVar2 != null) {
                oVar2.c();
            }
            this.f2155e = oVar;
            if (oVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f2155e.b();
        }

        o g() {
            if (this.f2155e == null) {
                this.f2155e = new o();
            }
            return this.f2155e;
        }

        void c(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.f2153c.size() - 1; size >= 0; size--) {
                x xVar = this.f2153c.get(size);
                if (xVar != null && (i3 = xVar.mPosition) >= i && i3 < i4) {
                    xVar.addFlags(2);
                    d(size);
                }
            }
        }

        void h() {
            int size = this.f2153c.size();
            for (int i = 0; i < size; i++) {
                x xVar = this.f2153c.get(i);
                if (xVar != null) {
                    xVar.addFlags(6);
                    xVar.addChangePayload(null);
                }
            }
            if (RecyclerView.this.mAdapter == null || !RecyclerView.this.mAdapter.hasStableIds()) {
                d();
            }
        }

        void i() {
            int size = this.f2153c.size();
            for (int i = 0; i < size; i++) {
                this.f2153c.get(i).clearOldPosition();
            }
            int size2 = this.f2151a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f2151a.get(i2).clearOldPosition();
            }
            ArrayList<x> arrayList = this.f2152b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f2152b.get(i3).clearOldPosition();
                }
            }
        }

        void j() {
            int size = this.f2153c.size();
            for (int i = 0; i < size; i++) {
                j jVar = (j) this.f2153c.get(i).itemView.getLayoutParams();
                if (jVar != null) {
                    jVar.f2144e = true;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a<VH extends x> {
        private final b mObservable = new b();
        private boolean mHasStableIds = false;

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                androidx.core.d.d.a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                onCreateViewHolder.mItemViewType = i;
                return onCreateViewHolder;
            } finally {
                androidx.core.d.d.a();
            }
        }

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            androidx.core.d.d.a(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof j) {
                ((j) layoutParams).f2144e = true;
            }
            androidx.core.d.d.a();
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public void registerAdapterDataObserver(c cVar) {
            this.mObservable.registerObserver(cVar);
        }

        public void unregisterAdapterDataObserver(c cVar) {
            this.mObservable.unregisterObserver(cVar);
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.a(i, 1);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.a(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.a(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.a(i, i2, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.b(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.d(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.b(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.c(i, 1);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.c(i, i2);
        }
    }

    void dispatchChildDetached(View view) {
        x childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        a aVar = this.mAdapter;
        if (aVar != null && childViewHolderInt != null) {
            aVar.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    void dispatchChildAttached(View view) {
        x childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        a aVar = this.mAdapter;
        if (aVar != null && childViewHolderInt != null) {
            aVar.onViewAttachedToWindow(childViewHolderInt);
        }
        List<k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
        androidx.recyclerview.widget.f mChildHelper;
        private int mHeight;
        private int mHeightMode;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        t mSmoothScroller;
        private int mWidth;
        private int mWidthMode;
        private final y.b mHorizontalBoundCheckCallback = new y.b() { // from class: androidx.recyclerview.widget.RecyclerView.i.1
            @Override // androidx.recyclerview.widget.y.b
            public View a(int i) {
                return i.this.getChildAt(i);
            }

            @Override // androidx.recyclerview.widget.y.b
            public int a() {
                return i.this.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.y.b
            public int b() {
                return i.this.getWidth() - i.this.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.y.b
            public int a(View view) {
                return i.this.getDecoratedLeft(view) - ((j) view.getLayoutParams()).leftMargin;
            }

            @Override // androidx.recyclerview.widget.y.b
            public int b(View view) {
                return i.this.getDecoratedRight(view) + ((j) view.getLayoutParams()).rightMargin;
            }
        };
        private final y.b mVerticalBoundCheckCallback = new y.b() { // from class: androidx.recyclerview.widget.RecyclerView.i.2
            @Override // androidx.recyclerview.widget.y.b
            public View a(int i) {
                return i.this.getChildAt(i);
            }

            @Override // androidx.recyclerview.widget.y.b
            public int a() {
                return i.this.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.y.b
            public int b() {
                return i.this.getHeight() - i.this.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.y.b
            public int a(View view) {
                return i.this.getDecoratedTop(view) - ((j) view.getLayoutParams()).topMargin;
            }

            @Override // androidx.recyclerview.widget.y.b
            public int b(View view) {
                return i.this.getDecoratedBottom(view) + ((j) view.getLayoutParams()).bottomMargin;
            }
        };
        y mHorizontalBoundCheck = new y(this.mHorizontalBoundCheckCallback);
        y mVerticalBoundCheck = new y(this.mVerticalBoundCheckCallback);
        boolean mRequestedSimpleAnimations = false;
        boolean mIsAttachedToWindow = false;
        boolean mAutoMeasure = false;
        private boolean mMeasurementCacheEnabled = true;
        private boolean mItemPrefetchEnabled = true;

        /* loaded from: classes.dex */
        public interface a {
            void b(int i, int i2);
        }

        /* loaded from: classes.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f2138a;

            /* renamed from: b  reason: collision with root package name */
            public int f2139b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f2140c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f2141d;
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(j jVar) {
            return jVar != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, u uVar, a aVar) {
        }

        public void collectInitialPrefetchPositions(int i, a aVar) {
        }

        public int computeHorizontalScrollExtent(u uVar) {
            return 0;
        }

        public int computeHorizontalScrollOffset(u uVar) {
            return 0;
        }

        public int computeHorizontalScrollRange(u uVar) {
            return 0;
        }

        public int computeVerticalScrollExtent(u uVar) {
            return 0;
        }

        public int computeVerticalScrollOffset(u uVar) {
            return 0;
        }

        public int computeVerticalScrollRange(u uVar) {
            return 0;
        }

        public abstract j generateDefaultLayoutParams();

        public int getBaseline() {
            return -1;
        }

        public int getSelectionModeForAccessibility(p pVar, u uVar) {
            return 0;
        }

        public boolean isLayoutHierarchical(p pVar, u uVar) {
            return false;
        }

        public void onAdapterChanged(a aVar, a aVar2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public View onFocusSearchFailed(View view, int i, p pVar, u uVar) {
            return null;
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onLayoutCompleted(u uVar) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public boolean performAccessibilityActionForItem(p pVar, u uVar, View view, int i, Bundle bundle) {
            return false;
        }

        public int scrollHorizontallyBy(int i, p pVar, u uVar) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, p pVar, u uVar) {
            return 0;
        }

        boolean shouldMeasureTwice() {
            return false;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mHeightMode = mode2;
            if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.mHeight = 0;
        }

        void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                if (rect.left < i5) {
                    i5 = rect.left;
                }
                if (rect.right > i3) {
                    i3 = rect.right;
                }
                if (rect.top < i6) {
                    i6 = rect.top;
                }
                if (rect.bottom > i4) {
                    i4 = rect.bottom;
                }
            }
            this.mRecyclerView.mTempRect.set(i5, i6, i3, i4);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.b();
                }
            }
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        void dispatchDetachedFromWindow(RecyclerView recyclerView, p pVar) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, pVar);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                androidx.core.h.w.a(recyclerView, runnable);
            }
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, p pVar) {
            onDetachedFromWindow(recyclerView);
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public void onLayoutChildren(p pVar, u uVar) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public j generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof j) {
                return new j((j) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new j((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new j(layoutParams);
        }

        public j generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new j(context, attributeSet);
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, u uVar, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(t tVar) {
            t tVar2 = this.mSmoothScroller;
            if (tVar2 != null && tVar != tVar2 && tVar2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = tVar;
            tVar.start(this.mRecyclerView, this);
        }

        public boolean isSmoothScrolling() {
            t tVar = this.mSmoothScroller;
            return tVar != null && tVar.isRunning();
        }

        public int getLayoutDirection() {
            return androidx.core.h.w.g(this.mRecyclerView);
        }

        public void endAnimation(View view) {
            if (this.mRecyclerView.mItemAnimator != null) {
                this.mRecyclerView.mItemAnimator.d(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        private void addViewInt(View view, int i, boolean z) {
            x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.e(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.f(childViewHolderInt);
            }
            j jVar = (j) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int b2 = this.mChildHelper.b(view);
                if (i == -1) {
                    i = this.mChildHelper.b();
                }
                if (b2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                } else if (b2 != i) {
                    this.mRecyclerView.mLayout.moveView(b2, i);
                }
            } else {
                this.mChildHelper.a(view, i, false);
                jVar.f2144e = true;
                t tVar = this.mSmoothScroller;
                if (tVar != null && tVar.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (jVar.f) {
                childViewHolderInt.itemView.invalidate();
                jVar.f = false;
            }
        }

        public void removeView(View view) {
            this.mChildHelper.a(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.a(i);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.a(childCount);
            }
        }

        public int getPosition(View view) {
            return ((j) view.getLayoutParams()).f();
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.c(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                x childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.a() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public void detachView(View view) {
            int b2 = this.mChildHelper.b(view);
            if (b2 >= 0) {
                detachViewInternal(b2, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        private void detachViewInternal(int i, View view) {
            this.mChildHelper.e(i);
        }

        public void attachView(View view, int i, j jVar) {
            x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.e(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.f(childViewHolderInt);
            }
            this.mChildHelper.a(view, i, jVar, childViewHolderInt.isRemoved());
        }

        public void attachView(View view, int i) {
            attachView(view, i, (j) view.getLayoutParams());
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
            }
            detachViewAt(i);
            attachView(childAt, i2);
        }

        public void detachAndScrapView(View view, p pVar) {
            scrapOrRecycleView(pVar, this.mChildHelper.b(view), view);
        }

        public void detachAndScrapViewAt(int i, p pVar) {
            scrapOrRecycleView(pVar, i, getChildAt(i));
        }

        public void removeAndRecycleView(View view, p pVar) {
            removeView(view);
            pVar.a(view);
        }

        public void removeAndRecycleViewAt(int i, p pVar) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            pVar.a(childAt);
        }

        public int getChildCount() {
            androidx.recyclerview.widget.f fVar = this.mChildHelper;
            if (fVar != null) {
                return fVar.b();
            }
            return 0;
        }

        public View getChildAt(int i) {
            androidx.recyclerview.widget.f fVar = this.mChildHelper;
            if (fVar != null) {
                return fVar.b(i);
            }
            return null;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return androidx.core.h.w.i(recyclerView);
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return androidx.core.h.w.j(recyclerView);
            }
            return 0;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            a adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.g(childViewHolderInt);
        }

        public void stopIgnoringView(View view) {
            x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void detachAndScrapAttachedViews(p pVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(pVar, childCount, getChildAt(childCount));
            }
        }

        private void scrapOrRecycleView(p pVar, int i, View view) {
            x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(i);
                pVar.b(childViewHolderInt);
                return;
            }
            detachViewAt(i);
            pVar.c(view);
            this.mRecyclerView.mViewInfoStore.h(childViewHolderInt);
        }

        void removeAndRecycleScrapInt(p pVar) {
            int e2 = pVar.e();
            for (int i = e2 - 1; i >= 0; i--) {
                View e3 = pVar.e(i);
                x childViewHolderInt = RecyclerView.getChildViewHolderInt(e3);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(e3, false);
                    }
                    if (this.mRecyclerView.mItemAnimator != null) {
                        this.mRecyclerView.mItemAnimator.d(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    pVar.b(e3);
                }
            }
            pVar.f();
            if (e2 > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void measureChild(View view, int i, int i2) {
            j jVar = (j) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i3, jVar.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i4, jVar.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, jVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldReMeasureChild(View view, int i, int i2, j jVar) {
            return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i, jVar.width) && isMeasurementUpToDate(view.getMeasuredHeight(), i2, jVar.height)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldMeasureChild(View view, int i, int i2, j jVar) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i, jVar.width) && isMeasurementUpToDate(view.getHeight(), i2, jVar.height)) ? false : true;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 <= 0 || i == i3) {
                if (mode == Integer.MIN_VALUE) {
                    return size >= i;
                } else if (mode != 0) {
                    return mode == 1073741824 && size == i;
                } else {
                    return true;
                }
            }
            return false;
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            j jVar = (j) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + jVar.leftMargin + jVar.rightMargin + i3, jVar.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + jVar.topMargin + jVar.bottomMargin + i4, jVar.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, jVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
            if (r3 >= 0) goto L8;
         */
        @Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int getChildMeasureSpec(int i, int i2, int i3, boolean z) {
            int i4 = i - i2;
            int i5 = 0;
            int max = Math.max(0, i4);
            if (!z) {
                if (i3 < 0) {
                    if (i3 == -1) {
                        i5 = 1073741824;
                    } else {
                        i5 = i3 == -2 ? Integer.MIN_VALUE : Integer.MIN_VALUE;
                        i3 = 0;
                    }
                    i3 = max;
                }
                i5 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i3, i5);
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r5 == 1073741824) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int getChildMeasureSpec(int i, int i2, int i3, int i4, boolean z) {
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 != Integer.MIN_VALUE) {
                            if (i2 != 0) {
                            }
                        }
                        i4 = max;
                    }
                    i2 = 0;
                    i4 = 0;
                }
                i2 = 1073741824;
            } else {
                if (i4 < 0) {
                    if (i4 != -1) {
                        if (i4 == -2) {
                            i2 = (i2 == Integer.MIN_VALUE || i2 == 1073741824) ? Integer.MIN_VALUE : 0;
                        }
                        i2 = 0;
                        i4 = 0;
                    }
                    i4 = max;
                }
                i2 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((j) view.getLayoutParams()).f2143d;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((j) view.getLayoutParams()).f2143d;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((j) view.getLayoutParams()).f2143d;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            j jVar = (j) view.getLayoutParams();
            Rect rect = jVar.f2143d;
            view.layout(i + rect.left + jVar.leftMargin, i2 + rect.top + jVar.topMargin, (i3 - rect.right) - jVar.rightMargin, (i4 - rect.bottom) - jVar.bottomMargin);
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((j) view.getLayoutParams()).f2143d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public int getTopDecorationHeight(View view) {
            return ((j) view.getLayoutParams()).f2143d.top;
        }

        public int getBottomDecorationHeight(View view) {
            return ((j) view.getLayoutParams()).f2143d.bottom;
        }

        public int getLeftDecorationWidth(View view) {
            return ((j) view.getLayoutParams()).f2143d.left;
        }

        public int getRightDecorationWidth(View view) {
            return ((j) view.getLayoutParams()).f2143d.right;
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i = left - paddingLeft;
            int min = Math.min(0, i);
            int i2 = top - paddingTop;
            int min2 = Math.min(0, i2);
            int i3 = width2 - width;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((!z2 || isFocusedChildVisibleAfterScrolling(recyclerView, i, i2)) && !(i == 0 && i2 == 0)) {
                if (z) {
                    recyclerView.scrollBy(i, i2);
                } else {
                    recyclerView.smoothScrollBy(i, i2);
                }
                return true;
            }
            return false;
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.a(view, 24579) && this.mVerticalBoundCheck.a(view, 24579);
            return z ? z3 : !z3;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - i < width && rect.right - i > paddingLeft && rect.top - i2 < height && rect.bottom - i2 > paddingTop;
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, u uVar, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onMeasure(p pVar, u uVar, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public int getMinimumWidth() {
            return androidx.core.h.w.k(this.mRecyclerView);
        }

        public int getMinimumHeight() {
            return androidx.core.h.w.l(this.mRecyclerView);
        }

        void stopSmoothScroller() {
            t tVar = this.mSmoothScroller;
            if (tVar != null) {
                tVar.stop();
            }
        }

        void onSmoothScrollerStopped(t tVar) {
            if (this.mSmoothScroller == tVar) {
                this.mSmoothScroller = null;
            }
        }

        public void removeAndRecycleAllViews(p pVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, pVar);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfo(androidx.core.h.a.d dVar) {
            onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, dVar);
        }

        public void onInitializeAccessibilityNodeInfo(p pVar, u uVar, androidx.core.h.a.d dVar) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                dVar.a(8192);
                dVar.h(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                dVar.a(4096);
                dVar.h(true);
            }
            dVar.a(d.b.a(getRowCountForAccessibility(pVar, uVar), getColumnCountForAccessibility(pVar, uVar), isLayoutHierarchical(pVar, uVar), getSelectionModeForAccessibility(pVar, uVar)));
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(p pVar, u uVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            if (this.mRecyclerView.mAdapter != null) {
                accessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfoForItem(View view, androidx.core.h.a.d dVar) {
            x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.c(childViewHolderInt.itemView)) {
                return;
            }
            onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, dVar);
        }

        public void onInitializeAccessibilityNodeInfoForItem(p pVar, u uVar, View view, androidx.core.h.a.d dVar) {
            dVar.b(d.c.a(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int getRowCountForAccessibility(p pVar, u uVar) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getColumnCountForAccessibility(p pVar, u uVar) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean performAccessibilityAction(int i, Bundle bundle) {
            return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i, bundle);
        }

        public boolean performAccessibilityAction(p pVar, u uVar, int i, Bundle bundle) {
            int height;
            int width;
            int i2;
            int i3;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    i2 = height;
                    i3 = width;
                }
                i2 = height;
                i3 = 0;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                height = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    i2 = height;
                    i3 = width;
                }
                i2 = height;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, i, bundle);
        }

        public static b getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            b bVar = new b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i, i2);
            bVar.f2138a = obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 1);
            bVar.f2139b = obtainStyledAttributes.getInt(R.styleable.RecyclerView_spanCount, 1);
            bVar.f2140c = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            bVar.f2141d = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }

        void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class h {
        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, u uVar) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, u uVar) {
            onDrawOver(canvas, recyclerView);
        }

        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, u uVar) {
            getItemOffsets(rect, ((j) view.getLayoutParams()).f(), recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class x {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        x mShadowedHolder = null;
        x mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        p mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public x(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((j) this.itemView.getLayoutParams()).f2144e = true;
            }
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & FLAG_IGNORE) != 0;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        void unScrap() {
            this.mScrapContainer.c(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        void setScrapContainer(p pVar, boolean z) {
            this.mScrapContainer = pVar;
            this.mInChangeScrap = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        boolean isTmpDetached() {
            return (this.mFlags & FLAG_TMP_DETACHED) != 0;
        }

        boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (i2 ^ (-1)));
        }

        void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(FLAG_ADAPTER_FULLUPDATE);
            } else if ((FLAG_ADAPTER_FULLUPDATE & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & FLAG_ADAPTER_FULLUPDATE) == 0) {
                List<Object> list = this.mPayloads;
                if (list == null || list.size() == 0) {
                    return FULLUPDATE_PAYLOADS;
                }
                return this.mUnmodifiedPayloads;
            }
            return FULLUPDATE_PAYLOADS;
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = androidx.core.h.w.f(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void setIsRecyclable(boolean z) {
            int i = this.mIsRecyclableCount;
            int i2 = z ? i - 1 : i + 1;
            this.mIsRecyclableCount = i2;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !androidx.core.h.w.d(this.itemView);
        }

        boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && androidx.core.h.w.d(this.itemView);
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    boolean setChildImportantForAccessibilityInternal(x xVar, int i2) {
        if (isComputingLayout()) {
            xVar.mPendingAccessibilityState = i2;
            this.mPendingAccessibilityImportanceChange.add(xVar);
            return false;
        }
        androidx.core.h.w.b(xVar.itemView, i2);
        return true;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int i2;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            x xVar = this.mPendingAccessibilityImportanceChange.get(size);
            if (xVar.itemView.getParent() == this && !xVar.shouldIgnore() && (i2 = xVar.mPendingAccessibilityState) != -1) {
                androidx.core.h.w.b(xVar.itemView, i2);
                xVar.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    int getAdapterPositionFor(x xVar) {
        if (xVar.hasAnyOfTheFlags(524) || !xVar.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.c(xVar.mPosition);
    }

    void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
        Resources resources = getContext().getResources();
        new androidx.recyclerview.widget.j(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().a(z);
    }

    @Override // android.view.View, androidx.core.h.k
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().b(i2);
    }

    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    @Override // android.view.View, androidx.core.h.k
    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    @Override // androidx.core.h.l
    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().c(i2);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b();
    }

    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().a(i2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6);
    }

    public final void dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    /* loaded from: classes.dex */
    public static class j extends ViewGroup.MarginLayoutParams {

        /* renamed from: c  reason: collision with root package name */
        x f2142c;

        /* renamed from: d  reason: collision with root package name */
        final Rect f2143d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2144e;
        boolean f;

        public j(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2143d = new Rect();
            this.f2144e = true;
            this.f = false;
        }

        public j(int i, int i2) {
            super(i, i2);
            this.f2143d = new Rect();
            this.f2144e = true;
            this.f = false;
        }

        public j(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2143d = new Rect();
            this.f2144e = true;
            this.f = false;
        }

        public j(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2143d = new Rect();
            this.f2144e = true;
            this.f = false;
        }

        public j(j jVar) {
            super((ViewGroup.LayoutParams) jVar);
            this.f2143d = new Rect();
            this.f2144e = true;
            this.f = false;
        }

        public boolean c() {
            return this.f2142c.isInvalid();
        }

        public boolean d() {
            return this.f2142c.isRemoved();
        }

        public boolean e() {
            return this.f2142c.isUpdated();
        }

        public int f() {
            return this.f2142c.getLayoutPosition();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class t {
        private i mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private boolean mRunning;
        private boolean mStarted;
        private View mTargetView;
        private int mTargetPosition = -1;
        private final a mRecyclingAction = new a(0, 0);

        /* loaded from: classes.dex */
        public interface b {
            PointF computeScrollVectorForPosition(int i);
        }

        protected abstract void onSeekTargetStep(int i, int i2, u uVar, a aVar);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View view, u uVar, a aVar);

        void start(RecyclerView recyclerView, i iVar) {
            recyclerView.mViewFlinger.b();
            if (this.mStarted) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = iVar;
            if (this.mTargetPosition == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.mState.f2163a = this.mTargetPosition;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.a();
            this.mStarted = true;
        }

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        public PointF computeScrollVectorForPosition(int i) {
            i layoutManager = getLayoutManager();
            if (layoutManager instanceof b) {
                return ((b) layoutManager).computeScrollVectorForPosition(i);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public i getLayoutManager() {
            return this.mLayoutManager;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.f2163a = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        void onAnimation(int i, int i2) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null && (computeScrollVectorForPosition.x != 0.0f || computeScrollVectorForPosition.y != 0.0f)) {
                recyclerView.scrollStep((int) Math.signum(computeScrollVectorForPosition.x), (int) Math.signum(computeScrollVectorForPosition.y), null);
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.a(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
                boolean a2 = this.mRecyclingAction.a();
                this.mRecyclingAction.a(recyclerView);
                if (a2 && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.a();
                }
            }
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        protected void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void normalize(PointF pointF) {
            float sqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private int f2158a;

            /* renamed from: b  reason: collision with root package name */
            private int f2159b;

            /* renamed from: c  reason: collision with root package name */
            private int f2160c;

            /* renamed from: d  reason: collision with root package name */
            private int f2161d;

            /* renamed from: e  reason: collision with root package name */
            private Interpolator f2162e;
            private boolean f;
            private int g;

            public a(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public a(int i, int i2, int i3, Interpolator interpolator) {
                this.f2161d = -1;
                this.f = false;
                this.g = 0;
                this.f2158a = i;
                this.f2159b = i2;
                this.f2160c = i3;
                this.f2162e = interpolator;
            }

            public void a(int i) {
                this.f2161d = i;
            }

            boolean a() {
                return this.f2161d >= 0;
            }

            void a(RecyclerView recyclerView) {
                int i = this.f2161d;
                if (i >= 0) {
                    this.f2161d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f = false;
                } else if (this.f) {
                    b();
                    recyclerView.mViewFlinger.a(this.f2158a, this.f2159b, this.f2160c, this.f2162e);
                    int i2 = this.g + 1;
                    this.g = i2;
                    if (i2 > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f = false;
                } else {
                    this.g = 0;
                }
            }

            private void b() {
                if (this.f2162e != null && this.f2160c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f2160c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void a(int i, int i2, int i3, Interpolator interpolator) {
                this.f2158a = i;
                this.f2159b = i2;
                this.f2160c = i3;
                this.f2162e = interpolator;
                this.f = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends Observable<c> {
        b() {
        }

        public boolean a() {
            return !this.mObservers.isEmpty();
        }

        public void b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onChanged();
            }
        }

        public void a(int i, int i2) {
            a(i, i2, null);
        }

        public void a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        public void b(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        public void c(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }

        public void d(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class s extends androidx.customview.a.a {
        public static final Parcelable.Creator<s> CREATOR = new Parcelable.ClassLoaderCreator<s>() { // from class: androidx.recyclerview.widget.RecyclerView.s.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public s createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new s(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public s createFromParcel(Parcel parcel) {
                return new s(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public s[] newArray(int i) {
                return new s[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        Parcelable f2157a;

        s(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2157a = parcel.readParcelable(classLoader == null ? i.class.getClassLoader() : classLoader);
        }

        s(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f2157a, 0);
        }

        void a(s sVar) {
            this.f2157a = sVar.f2157a;
        }
    }

    /* loaded from: classes.dex */
    public static class u {

        /* renamed from: a  reason: collision with root package name */
        int f2163a = -1;

        /* renamed from: b  reason: collision with root package name */
        int f2164b = 0;

        /* renamed from: c  reason: collision with root package name */
        int f2165c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f2166d = 1;

        /* renamed from: e  reason: collision with root package name */
        int f2167e = 0;
        boolean f = false;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        int l;
        long m;
        int n;
        int o;
        int p;

        /* renamed from: q  reason: collision with root package name */
        private SparseArray<Object> f2168q;

        void a(int i) {
            if ((this.f2166d & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f2166d));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(a aVar) {
            this.f2166d = 1;
            this.f2167e = aVar.getItemCount();
            this.g = false;
            this.h = false;
            this.i = false;
        }

        public boolean a() {
            return this.g;
        }

        public boolean b() {
            return this.k;
        }

        public int c() {
            return this.f2163a;
        }

        public boolean d() {
            return this.f2163a != -1;
        }

        public int e() {
            return this.g ? this.f2164b - this.f2165c : this.f2167e;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f2163a + ", mData=" + this.f2168q + ", mItemCount=" + this.f2167e + ", mIsMeasuring=" + this.i + ", mPreviousLayoutItemCount=" + this.f2164b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2165c + ", mStructureChanged=" + this.f + ", mInPreLayout=" + this.g + ", mRunSimpleAnimations=" + this.j + ", mRunPredictiveAnimations=" + this.k + '}';
        }
    }

    /* loaded from: classes.dex */
    private class g implements f.b {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f.b
        public void a(x xVar) {
            xVar.setIsRecyclable(true);
            if (xVar.mShadowedHolder != null && xVar.mShadowingHolder == null) {
                xVar.mShadowedHolder = null;
            }
            xVar.mShadowingHolder = null;
            if (xVar.shouldBeKeptAsChild() || RecyclerView.this.removeAnimatingView(xVar.itemView) || !xVar.isTmpDetached()) {
                return;
            }
            RecyclerView.this.removeDetachedView(xVar.itemView, false);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        private b f2126a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<a> f2127b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private long f2128c = 120;

        /* renamed from: d  reason: collision with root package name */
        private long f2129d = 120;

        /* renamed from: e  reason: collision with root package name */
        private long f2130e = 250;
        private long f = 250;

        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface b {
            void a(x xVar);
        }

        public abstract void a();

        public abstract boolean a(x xVar, c cVar, c cVar2);

        public abstract boolean a(x xVar, x xVar2, c cVar, c cVar2);

        public abstract boolean b();

        public abstract boolean b(x xVar, c cVar, c cVar2);

        public abstract boolean c(x xVar, c cVar, c cVar2);

        public abstract void d();

        public abstract void d(x xVar);

        public void g(x xVar) {
        }

        public boolean h(x xVar) {
            return true;
        }

        public long e() {
            return this.f2130e;
        }

        public long f() {
            return this.f2128c;
        }

        public long g() {
            return this.f2129d;
        }

        public long h() {
            return this.f;
        }

        void a(b bVar) {
            this.f2126a = bVar;
        }

        public c a(u uVar, x xVar, int i, List<Object> list) {
            return j().a(xVar);
        }

        public c a(u uVar, x xVar) {
            return j().a(xVar);
        }

        static int e(x xVar) {
            int i = xVar.mFlags & 14;
            if (xVar.isInvalid()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int oldPosition = xVar.getOldPosition();
                int adapterPosition = xVar.getAdapterPosition();
                return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
            }
            return i;
        }

        public final void f(x xVar) {
            g(xVar);
            b bVar = this.f2126a;
            if (bVar != null) {
                bVar.a(xVar);
            }
        }

        public final boolean a(a aVar) {
            boolean b2 = b();
            if (aVar != null) {
                if (!b2) {
                    aVar.a();
                } else {
                    this.f2127b.add(aVar);
                }
            }
            return b2;
        }

        public boolean a(x xVar, List<Object> list) {
            return h(xVar);
        }

        public final void i() {
            int size = this.f2127b.size();
            for (int i = 0; i < size; i++) {
                this.f2127b.get(i).a();
            }
            this.f2127b.clear();
        }

        public c j() {
            return new c();
        }

        /* loaded from: classes.dex */
        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f2131a;

            /* renamed from: b  reason: collision with root package name */
            public int f2132b;

            /* renamed from: c  reason: collision with root package name */
            public int f2133c;

            /* renamed from: d  reason: collision with root package name */
            public int f2134d;

            public c a(x xVar) {
                return a(xVar, 0);
            }

            public c a(x xVar, int i) {
                View view = xVar.itemView;
                this.f2131a = view.getLeft();
                this.f2132b = view.getTop();
                this.f2133c = view.getRight();
                this.f2134d = view.getBottom();
                return this;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        d dVar = this.mChildDrawingOrderCallback;
        if (dVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return dVar.a(i2, i3);
    }

    private androidx.core.h.n getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new androidx.core.h.n(this);
        }
        return this.mScrollingChildHelper;
    }
}
