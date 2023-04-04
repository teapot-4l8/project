package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* compiled from: ItemTouchHelper.java */
/* loaded from: classes.dex */
public class l extends RecyclerView.h implements RecyclerView.k {

    /* renamed from: a  reason: collision with root package name */
    final List<View> f2335a;

    /* renamed from: b  reason: collision with root package name */
    RecyclerView.x f2336b;

    /* renamed from: c  reason: collision with root package name */
    float f2337c;

    /* renamed from: d  reason: collision with root package name */
    float f2338d;

    /* renamed from: e  reason: collision with root package name */
    int f2339e;
    a f;
    int g;
    List<b> h;
    RecyclerView i;
    VelocityTracker j;
    View k;
    int l;
    private final float[] m;
    private float n;
    private float o;
    private float p;

    /* renamed from: q  reason: collision with root package name */
    private float f2340q;
    private int r;
    private RecyclerView.d s;
    private long t;

    /* compiled from: ItemTouchHelper.java */
    /* loaded from: classes.dex */
    public interface c {
        void prepareForDrop(View view, View view2, int i, int i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void onChildViewAttachedToWindow(View view) {
    }

    private void a(float[] fArr) {
        if ((this.g & 12) != 0) {
            fArr[0] = (this.p + this.f2337c) - this.f2336b.itemView.getLeft();
        } else {
            fArr[0] = this.f2336b.itemView.getTranslationX();
        }
        if ((this.g & 3) != 0) {
            fArr[1] = (this.f2340q + this.f2338d) - this.f2336b.itemView.getTop();
        } else {
            fArr[1] = this.f2336b.itemView.getTranslationY();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.u uVar) {
        float f;
        float f2;
        if (this.f2336b != null) {
            a(this.m);
            float[] fArr = this.m;
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.f.onDrawOver(canvas, recyclerView, this.f2336b, this.h, this.r, f, f2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.u uVar) {
        float f;
        float f2;
        this.l = -1;
        if (this.f2336b != null) {
            a(this.m);
            float[] fArr = this.m;
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.f.onDraw(canvas, recyclerView, this.f2336b, this.h, this.r, f, f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(RecyclerView.x xVar, int i) {
        boolean z;
        ViewParent parent;
        float signum;
        float f;
        if (xVar == this.f2336b && i == this.r) {
            return;
        }
        this.t = Long.MIN_VALUE;
        int i2 = this.r;
        a(xVar, true);
        this.r = i;
        if (i == 2) {
            if (xVar == null) {
                throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
            }
            this.k = xVar.itemView;
            d();
        }
        int i3 = (1 << ((i * 8) + 8)) - 1;
        final RecyclerView.x xVar2 = this.f2336b;
        if (xVar2 != null) {
            if (xVar2.itemView.getParent() != null) {
                int b2 = i2 == 2 ? 0 : b(xVar2);
                c();
                if (b2 != 1 && b2 != 2) {
                    f = (b2 == 4 || b2 == 8 || b2 == 16 || b2 == 32) ? Math.signum(this.f2337c) * this.i.getWidth() : 0.0f;
                    signum = 0.0f;
                } else {
                    signum = Math.signum(this.f2338d) * this.i.getHeight();
                    f = 0.0f;
                }
                int i4 = i2 == 2 ? 8 : b2 > 0 ? 2 : 4;
                a(this.m);
                float[] fArr = this.m;
                float f2 = fArr[0];
                float f3 = fArr[1];
                final int i5 = b2;
                b bVar = new b(xVar2, i4, i2, f2, f3, f, signum) { // from class: androidx.recyclerview.widget.l.1
                    @Override // androidx.recyclerview.widget.l.b, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (this.n) {
                            return;
                        }
                        if (i5 <= 0) {
                            l.this.f.clearView(l.this.i, xVar2);
                        } else {
                            l.this.f2335a.add(xVar2.itemView);
                            this.k = true;
                            int i6 = i5;
                            if (i6 > 0) {
                                l.this.a(this, i6);
                            }
                        }
                        if (l.this.k == xVar2.itemView) {
                            l.this.a(xVar2.itemView);
                        }
                    }
                };
                bVar.a(this.f.getAnimationDuration(this.i, i4, f - f2, signum - f3));
                this.h.add(bVar);
                bVar.a();
                z = true;
            } else {
                a(xVar2.itemView);
                this.f.clearView(this.i, xVar2);
                z = false;
            }
            this.f2336b = null;
        } else {
            z = false;
        }
        if (xVar != null) {
            this.g = (this.f.getAbsoluteMovementFlags(this.i, xVar) & i3) >> (this.r * 8);
            this.p = xVar.itemView.getLeft();
            this.f2340q = xVar.itemView.getTop();
            this.f2336b = xVar;
            if (i == 2) {
                xVar.itemView.performHapticFeedback(0);
                parent = this.i.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(this.f2336b != null);
                }
                if (!z) {
                    this.i.getLayoutManager().requestSimpleAnimationsInNextLayout();
                }
                this.f.onSelectedChanged(this.f2336b, this.r);
                this.i.invalidate();
            }
        }
        parent = this.i.getParent();
        if (parent != null) {
        }
        if (!z) {
        }
        this.f.onSelectedChanged(this.f2336b, this.r);
        this.i.invalidate();
    }

    void a(final b bVar, final int i) {
        this.i.post(new Runnable() { // from class: androidx.recyclerview.widget.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.i == null || !l.this.i.isAttachedToWindow() || bVar.n || bVar.h.getAdapterPosition() == -1) {
                    return;
                }
                RecyclerView.f itemAnimator = l.this.i.getItemAnimator();
                if ((itemAnimator == null || !itemAnimator.a((RecyclerView.f.a) null)) && !l.this.a()) {
                    l.this.f.onSwiped(bVar.h, i);
                } else {
                    l.this.i.post(this);
                }
            }
        });
    }

    boolean a() {
        int size = this.h.size();
        for (int i = 0; i < size; i++) {
            if (!this.h.get(i).o) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void onChildViewDetachedFromWindow(View view) {
        a(view);
        RecyclerView.x childViewHolder = this.i.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.x xVar = this.f2336b;
        if (xVar != null && childViewHolder == xVar) {
            a((RecyclerView.x) null, 0);
            return;
        }
        a(childViewHolder, false);
        if (this.f2335a.remove(childViewHolder.itemView)) {
            this.f.clearView(this.i, childViewHolder);
        }
    }

    void a(RecyclerView.x xVar, boolean z) {
        for (int size = this.h.size() - 1; size >= 0; size--) {
            b bVar = this.h.get(size);
            if (bVar.h == xVar) {
                bVar.n |= z;
                if (!bVar.o) {
                    bVar.b();
                }
                this.h.remove(size);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.u uVar) {
        rect.setEmpty();
    }

    void b() {
        VelocityTracker velocityTracker = this.j;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.j = VelocityTracker.obtain();
    }

    private void c() {
        VelocityTracker velocityTracker = this.j;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.j = null;
        }
    }

    public void a(RecyclerView.x xVar) {
        if (!this.f.hasDragFlag(this.i, xVar)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
        } else if (xVar.itemView.getParent() != this.i) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            b();
            this.f2338d = 0.0f;
            this.f2337c = 0.0f;
            a(xVar, 2);
        }
    }

    private int b(RecyclerView.x xVar) {
        if (this.r == 2) {
            return 0;
        }
        int movementFlags = this.f.getMovementFlags(this.i, xVar);
        int convertToAbsoluteDirection = (this.f.convertToAbsoluteDirection(movementFlags, androidx.core.h.w.g(this.i)) & 65280) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i = (movementFlags & 65280) >> 8;
        if (Math.abs(this.f2337c) > Math.abs(this.f2338d)) {
            int b2 = b(xVar, convertToAbsoluteDirection);
            if (b2 > 0) {
                return (i & b2) == 0 ? a.convertToRelativeDirection(b2, androidx.core.h.w.g(this.i)) : b2;
            }
            int c2 = c(xVar, convertToAbsoluteDirection);
            if (c2 > 0) {
                return c2;
            }
        } else {
            int c3 = c(xVar, convertToAbsoluteDirection);
            if (c3 > 0) {
                return c3;
            }
            int b3 = b(xVar, convertToAbsoluteDirection);
            if (b3 > 0) {
                return (i & b3) == 0 ? a.convertToRelativeDirection(b3, androidx.core.h.w.g(this.i)) : b3;
            }
        }
        return 0;
    }

    private int b(RecyclerView.x xVar, int i) {
        if ((i & 12) != 0) {
            int i2 = this.f2337c > 0.0f ? 8 : 4;
            VelocityTracker velocityTracker = this.j;
            if (velocityTracker != null && this.f2339e > -1) {
                velocityTracker.computeCurrentVelocity(1000, this.f.getSwipeVelocityThreshold(this.o));
                float xVelocity = this.j.getXVelocity(this.f2339e);
                float yVelocity = this.j.getYVelocity(this.f2339e);
                int i3 = xVelocity <= 0.0f ? 4 : 8;
                float abs = Math.abs(xVelocity);
                if ((i3 & i) != 0 && i2 == i3 && abs >= this.f.getSwipeEscapeVelocity(this.n) && abs > Math.abs(yVelocity)) {
                    return i3;
                }
            }
            float width = this.i.getWidth() * this.f.getSwipeThreshold(xVar);
            if ((i & i2) == 0 || Math.abs(this.f2337c) <= width) {
                return 0;
            }
            return i2;
        }
        return 0;
    }

    private int c(RecyclerView.x xVar, int i) {
        if ((i & 3) != 0) {
            int i2 = this.f2338d > 0.0f ? 2 : 1;
            VelocityTracker velocityTracker = this.j;
            if (velocityTracker != null && this.f2339e > -1) {
                velocityTracker.computeCurrentVelocity(1000, this.f.getSwipeVelocityThreshold(this.o));
                float xVelocity = this.j.getXVelocity(this.f2339e);
                float yVelocity = this.j.getYVelocity(this.f2339e);
                int i3 = yVelocity <= 0.0f ? 1 : 2;
                float abs = Math.abs(yVelocity);
                if ((i3 & i) != 0 && i3 == i2 && abs >= this.f.getSwipeEscapeVelocity(this.n) && abs > Math.abs(xVelocity)) {
                    return i3;
                }
            }
            float height = this.i.getHeight() * this.f.getSwipeThreshold(xVar);
            if ((i & i2) == 0 || Math.abs(this.f2338d) <= height) {
                return 0;
            }
            return i2;
        }
        return 0;
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (this.s == null) {
            this.s = new RecyclerView.d() { // from class: androidx.recyclerview.widget.l.3
                @Override // androidx.recyclerview.widget.RecyclerView.d
                public int a(int i, int i2) {
                    if (l.this.k == null) {
                        return i2;
                    }
                    int i3 = l.this.l;
                    if (i3 == -1) {
                        i3 = l.this.i.indexOfChild(l.this.k);
                        l.this.l = i3;
                    }
                    return i2 == i + (-1) ? i3 : i2 < i3 ? i2 : i2 + 1;
                }
            };
        }
        this.i.setChildDrawingOrderCallback(this.s);
    }

    void a(View view) {
        if (view == this.k) {
            this.k = null;
            if (this.s != null) {
                this.i.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* compiled from: ItemTouchHelper.java */
    /* loaded from: classes.dex */
    public static abstract class a {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.l.a.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        };
        private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.l.a.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
        private int mCachedMaxScrollSpeed = -1;

        public static int convertToRelativeDirection(int i, int i2) {
            int i3;
            int i4 = i & ABS_HORIZONTAL_DIR_FLAGS;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ (-1));
            if (i2 == 0) {
                i3 = i4 << 2;
            } else {
                int i6 = i4 << 1;
                i5 |= (-789517) & i6;
                i3 = (i6 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            }
            return i5 | i3;
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i * 8);
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.x xVar, RecyclerView.x xVar2) {
            return true;
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i3;
            int i4 = i & RELATIVE_DIR_FLAGS;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ (-1));
            if (i2 == 0) {
                i3 = i4 >> 2;
            } else {
                int i6 = i4 >> 1;
                i5 |= (-3158065) & i6;
                i3 = (i6 & RELATIVE_DIR_FLAGS) >> 2;
            }
            return i5 | i3;
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(RecyclerView.x xVar) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.x xVar);

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeThreshold(RecyclerView.x xVar) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.x xVar, RecyclerView.x xVar2);

        public abstract void onSwiped(RecyclerView.x xVar, int i);

        public static m getDefaultUIUtil() {
            return n.f2353a;
        }

        public static int makeMovementFlags(int i, int i2) {
            int makeFlag = makeFlag(0, i2 | i);
            return makeFlag(2, i) | makeFlag(1, i2) | makeFlag;
        }

        final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.x xVar) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, xVar), androidx.core.h.w.g(recyclerView));
        }

        boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.x xVar) {
            return (getAbsoluteMovementFlags(recyclerView, xVar) & 16711680) != 0;
        }

        boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.x xVar) {
            return (getAbsoluteMovementFlags(recyclerView, xVar) & 65280) != 0;
        }

        public RecyclerView.x chooseDropTarget(RecyclerView.x xVar, List<RecyclerView.x> list, int i, int i2) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = i + xVar.itemView.getWidth();
            int height = i2 + xVar.itemView.getHeight();
            int left2 = i - xVar.itemView.getLeft();
            int top2 = i2 - xVar.itemView.getTop();
            int size = list.size();
            RecyclerView.x xVar2 = null;
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                RecyclerView.x xVar3 = list.get(i4);
                if (left2 > 0 && (right = xVar3.itemView.getRight() - width) < 0 && xVar3.itemView.getRight() > xVar.itemView.getRight() && (abs4 = Math.abs(right)) > i3) {
                    xVar2 = xVar3;
                    i3 = abs4;
                }
                if (left2 < 0 && (left = xVar3.itemView.getLeft() - i) > 0 && xVar3.itemView.getLeft() < xVar.itemView.getLeft() && (abs3 = Math.abs(left)) > i3) {
                    xVar2 = xVar3;
                    i3 = abs3;
                }
                if (top2 < 0 && (top = xVar3.itemView.getTop() - i2) > 0 && xVar3.itemView.getTop() < xVar.itemView.getTop() && (abs2 = Math.abs(top)) > i3) {
                    xVar2 = xVar3;
                    i3 = abs2;
                }
                if (top2 > 0 && (bottom = xVar3.itemView.getBottom() - height) < 0 && xVar3.itemView.getBottom() > xVar.itemView.getBottom() && (abs = Math.abs(bottom)) > i3) {
                    xVar2 = xVar3;
                    i3 = abs;
                }
            }
            return xVar2;
        }

        public void onSelectedChanged(RecyclerView.x xVar, int i) {
            if (xVar != null) {
                n.f2353a.b(xVar.itemView);
            }
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public void onMoved(RecyclerView recyclerView, RecyclerView.x xVar, int i, RecyclerView.x xVar2, int i2, int i3, int i4) {
            RecyclerView.i layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof c) {
                ((c) layoutManager).prepareForDrop(xVar.itemView, xVar2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(xVar2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(xVar2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(xVar2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(xVar2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar, List<b> list, int i, float f, float f2) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = list.get(i2);
                bVar.c();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, bVar.h, bVar.l, bVar.m, bVar.i, false);
                canvas.restoreToCount(save);
            }
            if (xVar != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, xVar, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
        }

        void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar, List<b> list, int i, float f, float f2) {
            int size = list.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = list.get(i2);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, bVar.h, bVar.l, bVar.m, bVar.i, false);
                canvas.restoreToCount(save);
            }
            if (xVar != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, xVar, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
            for (int i3 = size - 1; i3 >= 0; i3--) {
                b bVar2 = list.get(i3);
                if (bVar2.o && !bVar2.k) {
                    list.remove(i3);
                } else if (!bVar2.o) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.x xVar) {
            n.f2353a.a(xVar.itemView);
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar, float f, float f2, int i, boolean z) {
            n.f2353a.a(canvas, recyclerView, xVar.itemView, f, f2, i, z);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar, float f, float f2, int i, boolean z) {
            n.f2353a.b(canvas, recyclerView, xVar.itemView, f, f2, i, z);
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.f itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i == 8 ? 200L : 250L;
            } else if (i == 8) {
                return itemAnimator.e();
            } else {
                return itemAnimator.g();
            }
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            int signum = (int) (((int) (((int) Math.signum(i2)) * getMaxDragScroll(recyclerView) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)))) * sDragScrollInterpolator.getInterpolation(j <= DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS ? ((float) j) / 2000.0f : 1.0f));
            return signum == 0 ? i2 > 0 ? 1 : -1 : signum;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ItemTouchHelper.java */
    /* loaded from: classes.dex */
    public static class b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private final ValueAnimator f2348a;

        /* renamed from: b  reason: collision with root package name */
        private float f2349b;

        /* renamed from: d  reason: collision with root package name */
        final float f2350d;

        /* renamed from: e  reason: collision with root package name */
        final float f2351e;
        final float f;
        final float g;
        final RecyclerView.x h;
        final int i;
        final int j;
        boolean k;
        float l;
        float m;
        boolean n = false;
        boolean o = false;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        b(RecyclerView.x xVar, int i, int i2, float f, float f2, float f3, float f4) {
            this.i = i2;
            this.j = i;
            this.h = xVar;
            this.f2350d = f;
            this.f2351e = f2;
            this.f = f3;
            this.g = f4;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f2348a = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.recyclerview.widget.l.b.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    b.this.a(valueAnimator.getAnimatedFraction());
                }
            });
            this.f2348a.setTarget(xVar.itemView);
            this.f2348a.addListener(this);
            a(0.0f);
        }

        public void a(long j) {
            this.f2348a.setDuration(j);
        }

        public void a() {
            this.h.setIsRecyclable(false);
            this.f2348a.start();
        }

        public void b() {
            this.f2348a.cancel();
        }

        public void a(float f) {
            this.f2349b = f;
        }

        public void c() {
            float f = this.f2350d;
            float f2 = this.f;
            if (f == f2) {
                this.l = this.h.itemView.getTranslationX();
            } else {
                this.l = f + (this.f2349b * (f2 - f));
            }
            float f3 = this.f2351e;
            float f4 = this.g;
            if (f3 == f4) {
                this.m = this.h.itemView.getTranslationY();
            } else {
                this.m = f3 + (this.f2349b * (f4 - f3));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.o) {
                this.h.setIsRecyclable(true);
            }
            this.o = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            a(1.0f);
        }
    }
}
