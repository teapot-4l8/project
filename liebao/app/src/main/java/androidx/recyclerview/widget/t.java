package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PagerSnapHelper.java */
/* loaded from: classes.dex */
public class t extends x {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
    private s mHorizontalHelper;
    private s mVerticalHelper;

    @Override // androidx.recyclerview.widget.x
    public int[] calculateDistanceToFinalSnap(RecyclerView.i iVar, View view) {
        int[] iArr = new int[2];
        if (iVar.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(iVar, view, getHorizontalHelper(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.canScrollVertically()) {
            iArr[1] = distanceToCenter(iVar, view, getVerticalHelper(iVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.x
    public View findSnapView(RecyclerView.i iVar) {
        if (iVar.canScrollVertically()) {
            return findCenterView(iVar, getVerticalHelper(iVar));
        }
        if (iVar.canScrollHorizontally()) {
            return findCenterView(iVar, getHorizontalHelper(iVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.x
    public int findTargetSnapPosition(RecyclerView.i iVar, int i, int i2) {
        s orientationHelper;
        int itemCount = iVar.getItemCount();
        if (itemCount == 0 || (orientationHelper = getOrientationHelper(iVar)) == null) {
            return -1;
        }
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        int childCount = iVar.getChildCount();
        View view = null;
        View view2 = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = iVar.getChildAt(i5);
            if (childAt != null) {
                int distanceToCenter = distanceToCenter(iVar, childAt, orientationHelper);
                if (distanceToCenter <= 0 && distanceToCenter > i3) {
                    view2 = childAt;
                    i3 = distanceToCenter;
                }
                if (distanceToCenter >= 0 && distanceToCenter < i4) {
                    view = childAt;
                    i4 = distanceToCenter;
                }
            }
        }
        boolean isForwardFling = isForwardFling(iVar, i, i2);
        if (!isForwardFling || view == null) {
            if (isForwardFling || view2 == null) {
                if (isForwardFling) {
                    view = view2;
                }
                if (view == null) {
                    return -1;
                }
                int position = iVar.getPosition(view) + (isReverseLayout(iVar) == isForwardFling ? -1 : 1);
                if (position < 0 || position >= itemCount) {
                    return -1;
                }
                return position;
            }
            return iVar.getPosition(view2);
        }
        return iVar.getPosition(view);
    }

    private boolean isForwardFling(RecyclerView.i iVar, int i, int i2) {
        return iVar.canScrollHorizontally() ? i > 0 : i2 > 0;
    }

    private boolean isReverseLayout(RecyclerView.i iVar) {
        PointF computeScrollVectorForPosition;
        int itemCount = iVar.getItemCount();
        if (!(iVar instanceof RecyclerView.t.b) || (computeScrollVectorForPosition = ((RecyclerView.t.b) iVar).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.x
    protected p createSnapScroller(RecyclerView.i iVar) {
        if (iVar instanceof RecyclerView.t.b) {
            return new p(this.mRecyclerView.getContext()) { // from class: androidx.recyclerview.widget.t.1
                @Override // androidx.recyclerview.widget.p, androidx.recyclerview.widget.RecyclerView.t
                protected void onTargetFound(View view, RecyclerView.u uVar, RecyclerView.t.a aVar) {
                    t tVar = t.this;
                    int[] calculateDistanceToFinalSnap = tVar.calculateDistanceToFinalSnap(tVar.mRecyclerView.getLayoutManager(), view);
                    int i = calculateDistanceToFinalSnap[0];
                    int i2 = calculateDistanceToFinalSnap[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        aVar.a(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }

                @Override // androidx.recyclerview.widget.p
                protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }

                @Override // androidx.recyclerview.widget.p
                protected int calculateTimeForScrolling(int i) {
                    return Math.min(100, super.calculateTimeForScrolling(i));
                }
            };
        }
        return null;
    }

    private int distanceToCenter(RecyclerView.i iVar, View view, s sVar) {
        return (sVar.a(view) + (sVar.e(view) / 2)) - (sVar.c() + (sVar.f() / 2));
    }

    private View findCenterView(RecyclerView.i iVar, s sVar) {
        int childCount = iVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int c2 = sVar.c() + (sVar.f() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = iVar.getChildAt(i2);
            int abs = Math.abs((sVar.a(childAt) + (sVar.e(childAt) / 2)) - c2);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    private s getOrientationHelper(RecyclerView.i iVar) {
        if (iVar.canScrollVertically()) {
            return getVerticalHelper(iVar);
        }
        if (iVar.canScrollHorizontally()) {
            return getHorizontalHelper(iVar);
        }
        return null;
    }

    private s getVerticalHelper(RecyclerView.i iVar) {
        s sVar = this.mVerticalHelper;
        if (sVar == null || sVar.f2360a != iVar) {
            this.mVerticalHelper = s.b(iVar);
        }
        return this.mVerticalHelper;
    }

    private s getHorizontalHelper(RecyclerView.i iVar) {
        s sVar = this.mHorizontalHelper;
        if (sVar == null || sVar.f2360a != iVar) {
            this.mHorizontalHelper = s.a(iVar);
        }
        return this.mHorizontalHelper;
    }
}
