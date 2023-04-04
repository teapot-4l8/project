package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import com.umeng.analytics.pro.o;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.i implements RecyclerView.t.b, l.c {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final b mLayoutChunkResult;
    private c mLayoutState;
    int mOrientation;
    s mOrientationHelper;
    d mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.p pVar, RecyclerView.u uVar, a aVar, int i) {
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        setReverseLayout(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.i.b properties = getProperties(context, attributeSet, i, i2);
        setOrientation(properties.f2138a);
        setReverseLayout(properties.f2140c);
        setStackFromEnd(properties.f2141d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j generateDefaultLayoutParams() {
        return new RecyclerView.j(-2, -2);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.p pVar) {
        super.onDetachedFromWindow(recyclerView, pVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(pVar);
            pVar.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new d(this.mPendingSavedState);
        }
        d dVar = new d();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            dVar.f2120c = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                dVar.f2119b = this.mOrientationHelper.d() - this.mOrientationHelper.b(childClosestToEnd);
                dVar.f2118a = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                dVar.f2118a = getPosition(childClosestToStart);
                dVar.f2119b = this.mOrientationHelper.a(childClosestToStart) - this.mOrientationHelper.c();
            }
        } else {
            dVar.b();
        }
        return dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.mPendingSavedState = (d) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.mOrientation || this.mOrientationHelper == null) {
            s a2 = s.a(this, i);
            this.mOrientationHelper = a2;
            this.mAnchorInfo.f2104a = a2;
            this.mOrientation = i;
            requestLayout();
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    @Deprecated
    protected int getExtraLayoutSpace(RecyclerView.u uVar) {
        if (uVar.d()) {
            return this.mOrientationHelper.f();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calculateExtraLayoutSpace(RecyclerView.u uVar, int[] iArr) {
        int i;
        int extraLayoutSpace = getExtraLayoutSpace(uVar);
        if (this.mLayoutState.f == -1) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.u uVar, int i) {
        p pVar = new p(recyclerView.getContext());
        pVar.setTargetPosition(i);
        startSmoothScroll(pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t.b
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = (i < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        if (this.mOrientation == 0) {
            return new PointF(i2, 0.0f);
        }
        return new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onLayoutChildren(RecyclerView.p pVar, RecyclerView.u uVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int fixLayoutEndGap;
        int i5;
        View findViewByPosition;
        int a2;
        int i6;
        int i7 = -1;
        if ((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && uVar.e() == 0) {
            removeAndRecycleAllViews(pVar);
            return;
        }
        d dVar = this.mPendingSavedState;
        if (dVar != null && dVar.a()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f2118a;
        }
        ensureLayoutState();
        this.mLayoutState.f2113a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        if (!this.mAnchorInfo.f2108e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            this.mAnchorInfo.a();
            this.mAnchorInfo.f2107d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(pVar, uVar, this.mAnchorInfo);
            this.mAnchorInfo.f2108e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.a(focusedChild) >= this.mOrientationHelper.d() || this.mOrientationHelper.b(focusedChild) <= this.mOrientationHelper.c())) {
            this.mAnchorInfo.a(focusedChild, getPosition(focusedChild));
        }
        c cVar = this.mLayoutState;
        cVar.f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(uVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.c();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.g();
        if (uVar.a() && (i5 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i5)) != null) {
            if (this.mShouldReverseLayout) {
                i6 = this.mOrientationHelper.d() - this.mOrientationHelper.b(findViewByPosition);
                a2 = this.mPendingScrollPositionOffset;
            } else {
                a2 = this.mOrientationHelper.a(findViewByPosition) - this.mOrientationHelper.c();
                i6 = this.mPendingScrollPositionOffset;
            }
            int i8 = i6 - a2;
            if (i8 > 0) {
                max += i8;
            } else {
                max2 -= i8;
            }
        }
        if (!this.mAnchorInfo.f2107d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i7 = 1;
        }
        onAnchorReady(pVar, uVar, this.mAnchorInfo, i7);
        detachAndScrapAttachedViews(pVar);
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.j = uVar.a();
        this.mLayoutState.i = 0;
        if (this.mAnchorInfo.f2107d) {
            updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.h = max;
            fill(pVar, this.mLayoutState, uVar, false);
            i2 = this.mLayoutState.f2114b;
            int i9 = this.mLayoutState.f2116d;
            if (this.mLayoutState.f2115c > 0) {
                max2 += this.mLayoutState.f2115c;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.h = max2;
            this.mLayoutState.f2116d += this.mLayoutState.f2117e;
            fill(pVar, this.mLayoutState, uVar, false);
            i = this.mLayoutState.f2114b;
            if (this.mLayoutState.f2115c > 0) {
                int i10 = this.mLayoutState.f2115c;
                updateLayoutStateToFillStart(i9, i2);
                this.mLayoutState.h = i10;
                fill(pVar, this.mLayoutState, uVar, false);
                i2 = this.mLayoutState.f2114b;
            }
        } else {
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.h = max2;
            fill(pVar, this.mLayoutState, uVar, false);
            i = this.mLayoutState.f2114b;
            int i11 = this.mLayoutState.f2116d;
            if (this.mLayoutState.f2115c > 0) {
                max += this.mLayoutState.f2115c;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.h = max;
            this.mLayoutState.f2116d += this.mLayoutState.f2117e;
            fill(pVar, this.mLayoutState, uVar, false);
            i2 = this.mLayoutState.f2114b;
            if (this.mLayoutState.f2115c > 0) {
                int i12 = this.mLayoutState.f2115c;
                updateLayoutStateToFillEnd(i11, i);
                this.mLayoutState.h = i12;
                fill(pVar, this.mLayoutState, uVar, false);
                i = this.mLayoutState.f2114b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap2 = fixLayoutEndGap(i, pVar, uVar, true);
                i3 = i2 + fixLayoutEndGap2;
                i4 = i + fixLayoutEndGap2;
                fixLayoutEndGap = fixLayoutStartGap(i3, pVar, uVar, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i2, pVar, uVar, true);
                i3 = i2 + fixLayoutStartGap;
                i4 = i + fixLayoutStartGap;
                fixLayoutEndGap = fixLayoutEndGap(i4, pVar, uVar, false);
            }
            i2 = i3 + fixLayoutEndGap;
            i = i4 + fixLayoutEndGap;
        }
        layoutForPredictiveAnimations(pVar, uVar, i2, i);
        if (!uVar.a()) {
            this.mOrientationHelper.a();
        } else {
            this.mAnchorInfo.a();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onLayoutCompleted(RecyclerView.u uVar) {
        super.onLayoutCompleted(uVar);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.a();
    }

    private void layoutForPredictiveAnimations(RecyclerView.p pVar, RecyclerView.u uVar, int i, int i2) {
        if (!uVar.b() || getChildCount() == 0 || uVar.a() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.x> c2 = pVar.c();
        int size = c2.size();
        int position = getPosition(getChildAt(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.x xVar = c2.get(i5);
            if (!xVar.isRemoved()) {
                if (((xVar.getLayoutPosition() < position) != this.mShouldReverseLayout ? (char) 65535 : (char) 1) == 65535) {
                    i3 += this.mOrientationHelper.e(xVar.itemView);
                } else {
                    i4 += this.mOrientationHelper.e(xVar.itemView);
                }
            }
        }
        this.mLayoutState.l = c2;
        if (i3 > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
            this.mLayoutState.h = i3;
            this.mLayoutState.f2115c = 0;
            this.mLayoutState.a();
            fill(pVar, this.mLayoutState, uVar, false);
        }
        if (i4 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
            this.mLayoutState.h = i4;
            this.mLayoutState.f2115c = 0;
            this.mLayoutState.a();
            fill(pVar, this.mLayoutState, uVar, false);
        }
        this.mLayoutState.l = null;
    }

    private void updateAnchorInfoForLayout(RecyclerView.p pVar, RecyclerView.u uVar, a aVar) {
        if (updateAnchorFromPendingData(uVar, aVar) || updateAnchorFromChildren(pVar, uVar, aVar)) {
            return;
        }
        aVar.b();
        aVar.f2105b = this.mStackFromEnd ? uVar.e() - 1 : 0;
    }

    private boolean updateAnchorFromChildren(RecyclerView.p pVar, RecyclerView.u uVar, a aVar) {
        View findReferenceChildClosestToStart;
        int c2;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.a(focusedChild, uVar)) {
            aVar.a(focusedChild, getPosition(focusedChild));
            return true;
        } else if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        } else {
            if (aVar.f2107d) {
                findReferenceChildClosestToStart = findReferenceChildClosestToEnd(pVar, uVar);
            } else {
                findReferenceChildClosestToStart = findReferenceChildClosestToStart(pVar, uVar);
            }
            if (findReferenceChildClosestToStart != null) {
                aVar.b(findReferenceChildClosestToStart, getPosition(findReferenceChildClosestToStart));
                if (!uVar.a() && supportsPredictiveItemAnimations()) {
                    if ((this.mOrientationHelper.a(findReferenceChildClosestToStart) >= this.mOrientationHelper.d() || this.mOrientationHelper.b(findReferenceChildClosestToStart) < this.mOrientationHelper.c()) ? true : true) {
                        if (aVar.f2107d) {
                            c2 = this.mOrientationHelper.d();
                        } else {
                            c2 = this.mOrientationHelper.c();
                        }
                        aVar.f2106c = c2;
                    }
                }
                return true;
            }
            return false;
        }
    }

    private boolean updateAnchorFromPendingData(RecyclerView.u uVar, a aVar) {
        int i;
        int a2;
        if (!uVar.a() && (i = this.mPendingScrollPosition) != -1) {
            if (i < 0 || i >= uVar.e()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                aVar.f2105b = this.mPendingScrollPosition;
                d dVar = this.mPendingSavedState;
                if (dVar != null && dVar.a()) {
                    aVar.f2107d = this.mPendingSavedState.f2120c;
                    if (aVar.f2107d) {
                        aVar.f2106c = this.mOrientationHelper.d() - this.mPendingSavedState.f2119b;
                    } else {
                        aVar.f2106c = this.mOrientationHelper.c() + this.mPendingSavedState.f2119b;
                    }
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition != null) {
                        if (this.mOrientationHelper.e(findViewByPosition) > this.mOrientationHelper.f()) {
                            aVar.b();
                            return true;
                        } else if (this.mOrientationHelper.a(findViewByPosition) - this.mOrientationHelper.c() < 0) {
                            aVar.f2106c = this.mOrientationHelper.c();
                            aVar.f2107d = false;
                            return true;
                        } else if (this.mOrientationHelper.d() - this.mOrientationHelper.b(findViewByPosition) < 0) {
                            aVar.f2106c = this.mOrientationHelper.d();
                            aVar.f2107d = true;
                            return true;
                        } else {
                            if (aVar.f2107d) {
                                a2 = this.mOrientationHelper.b(findViewByPosition) + this.mOrientationHelper.b();
                            } else {
                                a2 = this.mOrientationHelper.a(findViewByPosition);
                            }
                            aVar.f2106c = a2;
                        }
                    } else {
                        if (getChildCount() > 0) {
                            aVar.f2107d = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                        }
                        aVar.b();
                    }
                    return true;
                } else {
                    aVar.f2107d = this.mShouldReverseLayout;
                    if (this.mShouldReverseLayout) {
                        aVar.f2106c = this.mOrientationHelper.d() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.f2106c = this.mOrientationHelper.c() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private int fixLayoutEndGap(int i, RecyclerView.p pVar, RecyclerView.u uVar, boolean z) {
        int d2;
        int d3 = this.mOrientationHelper.d() - i;
        if (d3 > 0) {
            int i2 = -scrollBy(-d3, pVar, uVar);
            int i3 = i + i2;
            if (!z || (d2 = this.mOrientationHelper.d() - i3) <= 0) {
                return i2;
            }
            this.mOrientationHelper.a(d2);
            return d2 + i2;
        }
        return 0;
    }

    private int fixLayoutStartGap(int i, RecyclerView.p pVar, RecyclerView.u uVar, boolean z) {
        int c2;
        int c3 = i - this.mOrientationHelper.c();
        if (c3 > 0) {
            int i2 = -scrollBy(c3, pVar, uVar);
            int i3 = i + i2;
            if (!z || (c2 = i3 - this.mOrientationHelper.c()) <= 0) {
                return i2;
            }
            this.mOrientationHelper.a(-c2);
            return i2 - c2;
        }
        return 0;
    }

    private void updateLayoutStateToFillEnd(a aVar) {
        updateLayoutStateToFillEnd(aVar.f2105b, aVar.f2106c);
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.f2115c = this.mOrientationHelper.d() - i2;
        this.mLayoutState.f2117e = this.mShouldReverseLayout ? -1 : 1;
        this.mLayoutState.f2116d = i;
        this.mLayoutState.f = 1;
        this.mLayoutState.f2114b = i2;
        this.mLayoutState.g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(a aVar) {
        updateLayoutStateToFillStart(aVar.f2105b, aVar.f2106c);
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.f2115c = i2 - this.mOrientationHelper.c();
        this.mLayoutState.f2116d = i;
        this.mLayoutState.f2117e = this.mShouldReverseLayout ? 1 : -1;
        this.mLayoutState.f = -1;
        this.mLayoutState.f2114b = i2;
        this.mLayoutState.g = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    c createLayoutState() {
        return new c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        d dVar = this.mPendingSavedState;
        if (dVar != null) {
            dVar.b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        d dVar = this.mPendingSavedState;
        if (dVar != null) {
            dVar.b();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int scrollHorizontallyBy(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, pVar, uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int scrollVerticallyBy(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, pVar, uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeHorizontalScrollOffset(RecyclerView.u uVar) {
        return computeScrollOffset(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeVerticalScrollOffset(RecyclerView.u uVar) {
        return computeScrollOffset(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeHorizontalScrollExtent(RecyclerView.u uVar) {
        return computeScrollExtent(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeVerticalScrollExtent(RecyclerView.u uVar) {
        return computeScrollExtent(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeHorizontalScrollRange(RecyclerView.u uVar) {
        return computeScrollRange(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeVerticalScrollRange(RecyclerView.u uVar) {
        return computeScrollRange(uVar);
    }

    private int computeScrollOffset(RecyclerView.u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return v.a(uVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollExtent(RecyclerView.u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return v.a(uVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollRange(RecyclerView.u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return v.b(uVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void updateLayoutState(int i, int i2, boolean z, RecyclerView.u uVar) {
        int c2;
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.f = i;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(uVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z2 = i == 1;
        this.mLayoutState.h = z2 ? max2 : max;
        c cVar = this.mLayoutState;
        if (!z2) {
            max = max2;
        }
        cVar.i = max;
        if (z2) {
            this.mLayoutState.h += this.mOrientationHelper.g();
            View childClosestToEnd = getChildClosestToEnd();
            this.mLayoutState.f2117e = this.mShouldReverseLayout ? -1 : 1;
            this.mLayoutState.f2116d = getPosition(childClosestToEnd) + this.mLayoutState.f2117e;
            this.mLayoutState.f2114b = this.mOrientationHelper.b(childClosestToEnd);
            c2 = this.mOrientationHelper.b(childClosestToEnd) - this.mOrientationHelper.d();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.h += this.mOrientationHelper.c();
            this.mLayoutState.f2117e = this.mShouldReverseLayout ? 1 : -1;
            this.mLayoutState.f2116d = getPosition(childClosestToStart) + this.mLayoutState.f2117e;
            this.mLayoutState.f2114b = this.mOrientationHelper.a(childClosestToStart);
            c2 = (-this.mOrientationHelper.a(childClosestToStart)) + this.mOrientationHelper.c();
        }
        this.mLayoutState.f2115c = i2;
        if (z) {
            this.mLayoutState.f2115c -= c2;
        }
        this.mLayoutState.g = c2;
    }

    boolean resolveIsInfinite() {
        return this.mOrientationHelper.h() == 0 && this.mOrientationHelper.e() == 0;
    }

    void collectPrefetchPositionsForLayoutState(RecyclerView.u uVar, c cVar, RecyclerView.i.a aVar) {
        int i = cVar.f2116d;
        if (i < 0 || i >= uVar.e()) {
            return;
        }
        aVar.b(i, Math.max(0, cVar.g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void collectInitialPrefetchPositions(int i, RecyclerView.i.a aVar) {
        boolean z;
        int i2;
        d dVar = this.mPendingSavedState;
        if (dVar != null && dVar.a()) {
            z = this.mPendingSavedState.f2120c;
            i2 = this.mPendingSavedState.f2118a;
        } else {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
            aVar.b(i2, 0);
            i2 += i3;
        }
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.u uVar, RecyclerView.i.a aVar) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(i > 0 ? 1 : -1, Math.abs(i), true, uVar);
        collectPrefetchPositionsForLayoutState(uVar, this.mLayoutState, aVar);
    }

    int scrollBy(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f2113a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        updateLayoutState(i2, abs, true, uVar);
        int fill = this.mLayoutState.g + fill(pVar, this.mLayoutState, uVar, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i = i2 * fill;
        }
        this.mOrientationHelper.a(-i);
        this.mLayoutState.k = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void recycleChildren(RecyclerView.p pVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                removeAndRecycleViewAt(i, pVar);
                i--;
            }
            return;
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            removeAndRecycleViewAt(i3, pVar);
        }
    }

    private void recycleViewsFromStart(RecyclerView.p pVar, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (this.mOrientationHelper.b(childAt) > i3 || this.mOrientationHelper.c(childAt) > i3) {
                    recycleChildren(pVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = childCount - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            if (this.mOrientationHelper.b(childAt2) > i3 || this.mOrientationHelper.c(childAt2) > i3) {
                recycleChildren(pVar, i5, i6);
                return;
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.p pVar, int i, int i2) {
        int childCount = getChildCount();
        if (i < 0) {
            return;
        }
        int e2 = (this.mOrientationHelper.e() - i) + i2;
        if (this.mShouldReverseLayout) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (this.mOrientationHelper.a(childAt) < e2 || this.mOrientationHelper.d(childAt) < e2) {
                    recycleChildren(pVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = childCount - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View childAt2 = getChildAt(i5);
            if (this.mOrientationHelper.a(childAt2) < e2 || this.mOrientationHelper.d(childAt2) < e2) {
                recycleChildren(pVar, i4, i5);
                return;
            }
        }
    }

    private void recycleByLayoutState(RecyclerView.p pVar, c cVar) {
        if (!cVar.f2113a || cVar.m) {
            return;
        }
        int i = cVar.g;
        int i2 = cVar.i;
        if (cVar.f == -1) {
            recycleViewsFromEnd(pVar, i, i2);
        } else {
            recycleViewsFromStart(pVar, i, i2);
        }
    }

    int fill(RecyclerView.p pVar, c cVar, RecyclerView.u uVar, boolean z) {
        int i = cVar.f2115c;
        if (cVar.g != Integer.MIN_VALUE) {
            if (cVar.f2115c < 0) {
                cVar.g += cVar.f2115c;
            }
            recycleByLayoutState(pVar, cVar);
        }
        int i2 = cVar.f2115c + cVar.h;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.m && i2 <= 0) || !cVar.a(uVar)) {
                break;
            }
            bVar.a();
            layoutChunk(pVar, uVar, cVar, bVar);
            if (!bVar.f2110b) {
                cVar.f2114b += bVar.f2109a * cVar.f;
                if (!bVar.f2111c || cVar.l != null || !uVar.a()) {
                    cVar.f2115c -= bVar.f2109a;
                    i2 -= bVar.f2109a;
                }
                if (cVar.g != Integer.MIN_VALUE) {
                    cVar.g += bVar.f2109a;
                    if (cVar.f2115c < 0) {
                        cVar.g += cVar.f2115c;
                    }
                    recycleByLayoutState(pVar, cVar);
                }
                if (z && bVar.f2112d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f2115c;
    }

    void layoutChunk(RecyclerView.p pVar, RecyclerView.u uVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int f;
        View a2 = cVar.a(pVar);
        if (a2 == null) {
            bVar.f2110b = true;
            return;
        }
        RecyclerView.j jVar = (RecyclerView.j) a2.getLayoutParams();
        if (cVar.l == null) {
            if (this.mShouldReverseLayout == (cVar.f == -1)) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f == -1)) {
                addDisappearingView(a2);
            } else {
                addDisappearingView(a2, 0);
            }
        }
        measureChildWithMargins(a2, 0, 0);
        bVar.f2109a = this.mOrientationHelper.e(a2);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                f = getWidth() - getPaddingRight();
                i4 = f - this.mOrientationHelper.f(a2);
            } else {
                i4 = getPaddingLeft();
                f = this.mOrientationHelper.f(a2) + i4;
            }
            if (cVar.f == -1) {
                int i5 = cVar.f2114b;
                i2 = cVar.f2114b - bVar.f2109a;
                i = f;
                i3 = i5;
            } else {
                int i6 = cVar.f2114b;
                i3 = cVar.f2114b + bVar.f2109a;
                i = f;
                i2 = i6;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f2 = this.mOrientationHelper.f(a2) + paddingTop;
            if (cVar.f == -1) {
                i2 = paddingTop;
                i = cVar.f2114b;
                i3 = f2;
                i4 = cVar.f2114b - bVar.f2109a;
            } else {
                int i7 = cVar.f2114b;
                i = cVar.f2114b + bVar.f2109a;
                i2 = paddingTop;
                i3 = f2;
                i4 = i7;
            }
        }
        layoutDecoratedWithMargins(a2, i4, i2, i, i3);
        if (jVar.d() || jVar.e()) {
            bVar.f2111c = true;
        }
        bVar.f2112d = a2.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int convertFocusDirectionToLayoutDirection(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return findOneVisibleChild(0, getChildCount(), z, z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    private View findReferenceChildClosestToEnd(RecyclerView.p pVar, RecyclerView.u uVar) {
        return this.mShouldReverseLayout ? findFirstReferenceChild(pVar, uVar) : findLastReferenceChild(pVar, uVar);
    }

    private View findReferenceChildClosestToStart(RecyclerView.p pVar, RecyclerView.u uVar) {
        return this.mShouldReverseLayout ? findLastReferenceChild(pVar, uVar) : findFirstReferenceChild(pVar, uVar);
    }

    private View findFirstReferenceChild(RecyclerView.p pVar, RecyclerView.u uVar) {
        return findReferenceChild(pVar, uVar, 0, getChildCount(), uVar.e());
    }

    private View findLastReferenceChild(RecyclerView.p pVar, RecyclerView.u uVar) {
        return findReferenceChild(pVar, uVar, getChildCount() - 1, -1, uVar.e());
    }

    View findReferenceChild(RecyclerView.p pVar, RecyclerView.u uVar, int i, int i2, int i3) {
        ensureLayoutState();
        int c2 = this.mOrientationHelper.c();
        int d2 = this.mOrientationHelper.d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.j) childAt.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.a(childAt) < d2 && this.mOrientationHelper.b(childAt) >= c2) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.a(i, i2, i3, i4);
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        int i3;
        int i4;
        ensureLayoutState();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return getChildAt(i);
        }
        if (this.mOrientationHelper.a(getChildAt(i)) < this.mOrientationHelper.c()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = o.a.f6596a;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.a(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View onFocusSearchFailed(View view, int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        int convertFocusDirectionToLayoutDirection;
        View findPartiallyOrCompletelyInvisibleChildClosestToEnd;
        View childClosestToEnd;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.f() * MAX_SCROLL_FACTOR), false, uVar);
        this.mLayoutState.g = Integer.MIN_VALUE;
        this.mLayoutState.f2113a = false;
        fill(pVar, this.mLayoutState, uVar, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            childClosestToEnd = getChildClosestToStart();
        } else {
            childClosestToEnd = getChildClosestToEnd();
        }
        if (childClosestToEnd.hasFocusable()) {
            if (findPartiallyOrCompletelyInvisibleChildClosestToEnd == null) {
                return null;
            }
            return childClosestToEnd;
        }
        return findPartiallyOrCompletelyInvisibleChildClosestToEnd;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.a(childAt));
        }
        Log.d(TAG, "==============");
    }

    void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int a2 = this.mOrientationHelper.a(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i = 1; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                int position2 = getPosition(childAt);
                int a3 = this.mOrientationHelper.a(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb = new StringBuilder();
                    sb.append("detected invalid position. loc invalid? ");
                    sb.append(a3 < a2);
                    throw new RuntimeException(sb.toString());
                } else if (a3 > a2) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i2 = 1; i2 < getChildCount(); i2++) {
            View childAt2 = getChildAt(i2);
            int position3 = getPosition(childAt2);
            int a4 = this.mOrientationHelper.a(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("detected invalid position. loc invalid? ");
                sb2.append(a4 < a2);
                throw new RuntimeException(sb2.toString());
            } else if (a4 < a2) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.l.c
    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c2 = position < position2 ? (char) 1 : (char) 65535;
        if (this.mShouldReverseLayout) {
            if (c2 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.d() - (this.mOrientationHelper.a(view2) + this.mOrientationHelper.e(view)));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.d() - this.mOrientationHelper.b(view2));
            }
        } else if (c2 == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.a(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.b(view2) - this.mOrientationHelper.e(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b  reason: collision with root package name */
        int f2114b;

        /* renamed from: c  reason: collision with root package name */
        int f2115c;

        /* renamed from: d  reason: collision with root package name */
        int f2116d;

        /* renamed from: e  reason: collision with root package name */
        int f2117e;
        int f;
        int g;
        int k;
        boolean m;

        /* renamed from: a  reason: collision with root package name */
        boolean f2113a = true;
        int h = 0;
        int i = 0;
        boolean j = false;
        List<RecyclerView.x> l = null;

        c() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(RecyclerView.u uVar) {
            int i = this.f2116d;
            return i >= 0 && i < uVar.e();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View a(RecyclerView.p pVar) {
            if (this.l != null) {
                return b();
            }
            View c2 = pVar.c(this.f2116d);
            this.f2116d += this.f2117e;
            return c2;
        }

        private View b() {
            int size = this.l.size();
            for (int i = 0; i < size; i++) {
                View view = this.l.get(i).itemView;
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                if (!jVar.d() && this.f2116d == jVar.f()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View b2 = b(view);
            if (b2 == null) {
                this.f2116d = -1;
            } else {
                this.f2116d = ((RecyclerView.j) b2.getLayoutParams()).f();
            }
        }

        public View b(View view) {
            int f;
            int size = this.l.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.l.get(i2).itemView;
                RecyclerView.j jVar = (RecyclerView.j) view3.getLayoutParams();
                if (view3 != view && !jVar.d() && (f = (jVar.f() - this.f2116d) * this.f2117e) >= 0 && f < i) {
                    view2 = view3;
                    if (f == 0) {
                        break;
                    }
                    i = f;
                }
            }
            return view2;
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: androidx.recyclerview.widget.LinearLayoutManager.d.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d[] newArray(int i) {
                return new d[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f2118a;

        /* renamed from: b  reason: collision with root package name */
        int f2119b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2120c;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public d() {
        }

        d(Parcel parcel) {
            this.f2118a = parcel.readInt();
            this.f2119b = parcel.readInt();
            this.f2120c = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f2118a = dVar.f2118a;
            this.f2119b = dVar.f2119b;
            this.f2120c = dVar.f2120c;
        }

        boolean a() {
            return this.f2118a >= 0;
        }

        void b() {
            this.f2118a = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2118a);
            parcel.writeInt(this.f2119b);
            parcel.writeInt(this.f2120c ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        s f2104a;

        /* renamed from: b  reason: collision with root package name */
        int f2105b;

        /* renamed from: c  reason: collision with root package name */
        int f2106c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2107d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2108e;

        a() {
            a();
        }

        void a() {
            this.f2105b = -1;
            this.f2106c = Integer.MIN_VALUE;
            this.f2107d = false;
            this.f2108e = false;
        }

        void b() {
            int c2;
            if (this.f2107d) {
                c2 = this.f2104a.d();
            } else {
                c2 = this.f2104a.c();
            }
            this.f2106c = c2;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2105b + ", mCoordinate=" + this.f2106c + ", mLayoutFromEnd=" + this.f2107d + ", mValid=" + this.f2108e + '}';
        }

        boolean a(View view, RecyclerView.u uVar) {
            RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
            return !jVar.d() && jVar.f() >= 0 && jVar.f() < uVar.e();
        }

        public void a(View view, int i) {
            int b2 = this.f2104a.b();
            if (b2 >= 0) {
                b(view, i);
                return;
            }
            this.f2105b = i;
            if (this.f2107d) {
                int d2 = (this.f2104a.d() - b2) - this.f2104a.b(view);
                this.f2106c = this.f2104a.d() - d2;
                if (d2 > 0) {
                    int e2 = this.f2106c - this.f2104a.e(view);
                    int c2 = this.f2104a.c();
                    int min = e2 - (c2 + Math.min(this.f2104a.a(view) - c2, 0));
                    if (min < 0) {
                        this.f2106c += Math.min(d2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int a2 = this.f2104a.a(view);
            int c3 = a2 - this.f2104a.c();
            this.f2106c = a2;
            if (c3 > 0) {
                int d3 = (this.f2104a.d() - Math.min(0, (this.f2104a.d() - b2) - this.f2104a.b(view))) - (a2 + this.f2104a.e(view));
                if (d3 < 0) {
                    this.f2106c -= Math.min(c3, -d3);
                }
            }
        }

        public void b(View view, int i) {
            if (this.f2107d) {
                this.f2106c = this.f2104a.b(view) + this.f2104a.b();
            } else {
                this.f2106c = this.f2104a.a(view);
            }
            this.f2105b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2109a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2110b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2111c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2112d;

        protected b() {
        }

        void a() {
            this.f2109a = 0;
            this.f2110b = false;
            this.f2111c = false;
            this.f2112d = false;
        }
    }
}
