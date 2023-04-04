package androidx.recyclerview.widget;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SnapHelper.java */
/* loaded from: classes.dex */
public abstract class x extends RecyclerView.l {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final RecyclerView.n mScrollListener = new RecyclerView.n() { // from class: androidx.recyclerview.widget.x.1

        /* renamed from: a  reason: collision with root package name */
        boolean f2368a = false;

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.f2368a) {
                this.f2368a = false;
                x.this.snapToTargetExistingView();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.f2368a = true;
        }
    };

    public abstract int[] calculateDistanceToFinalSnap(RecyclerView.i iVar, View view);

    public abstract View findSnapView(RecyclerView.i iVar);

    public abstract int findTargetSnapPosition(RecyclerView.i iVar, int i, int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean onFling(int i, int i2) {
        RecyclerView.i layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && snapFromFling(layoutManager, i, i2);
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            setupCallbacks();
            this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
            snapToTargetExistingView();
        }
    }

    private void setupCallbacks() {
        if (this.mRecyclerView.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.mRecyclerView.addOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(this);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    public int[] calculateScrollDistance(int i, int i2) {
        this.mGravityScroller.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    private boolean snapFromFling(RecyclerView.i iVar, int i, int i2) {
        RecyclerView.t createScroller;
        int findTargetSnapPosition;
        if (!(iVar instanceof RecyclerView.t.b) || (createScroller = createScroller(iVar)) == null || (findTargetSnapPosition = findTargetSnapPosition(iVar, i, i2)) == -1) {
            return false;
        }
        createScroller.setTargetPosition(findTargetSnapPosition);
        iVar.startSmoothScroll(createScroller);
        return true;
    }

    void snapToTargetExistingView() {
        RecyclerView.i layoutManager;
        View findSnapView;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (findSnapView = findSnapView(layoutManager)) == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
        if (calculateDistanceToFinalSnap[0] == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.mRecyclerView.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
    }

    protected RecyclerView.t createScroller(RecyclerView.i iVar) {
        return createSnapScroller(iVar);
    }

    @Deprecated
    protected p createSnapScroller(RecyclerView.i iVar) {
        if (iVar instanceof RecyclerView.t.b) {
            return new p(this.mRecyclerView.getContext()) { // from class: androidx.recyclerview.widget.x.2
                @Override // androidx.recyclerview.widget.p, androidx.recyclerview.widget.RecyclerView.t
                protected void onTargetFound(View view, RecyclerView.u uVar, RecyclerView.t.a aVar) {
                    if (x.this.mRecyclerView == null) {
                        return;
                    }
                    x xVar = x.this;
                    int[] calculateDistanceToFinalSnap = xVar.calculateDistanceToFinalSnap(xVar.mRecyclerView.getLayoutManager(), view);
                    int i = calculateDistanceToFinalSnap[0];
                    int i2 = calculateDistanceToFinalSnap[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        aVar.a(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }

                @Override // androidx.recyclerview.widget.p
                protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return x.MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }
}
