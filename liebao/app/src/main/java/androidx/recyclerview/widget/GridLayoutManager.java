package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.a.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    boolean f2097a;

    /* renamed from: b  reason: collision with root package name */
    int f2098b;

    /* renamed from: c  reason: collision with root package name */
    int[] f2099c;

    /* renamed from: d  reason: collision with root package name */
    View[] f2100d;

    /* renamed from: e  reason: collision with root package name */
    final SparseIntArray f2101e;
    final SparseIntArray f;
    c g;
    final Rect h;
    private boolean i;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f2097a = false;
        this.f2098b = -1;
        this.f2101e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        a(getProperties(context, attributeSet, i, i2).f2139b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int getRowCountForAccessibility(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.mOrientation == 0) {
            return this.f2098b;
        }
        if (uVar.e() < 1) {
            return 0;
        }
        return a(pVar, uVar, uVar.e() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int getColumnCountForAccessibility(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.mOrientation == 1) {
            return this.f2098b;
        }
        if (uVar.e() < 1) {
            return 0;
        }
        return a(pVar, uVar, uVar.e() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.p pVar, RecyclerView.u uVar, View view, androidx.core.h.a.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        int a2 = a(pVar, uVar, bVar.f());
        if (this.mOrientation == 0) {
            dVar.b(d.c.a(bVar.a(), bVar.b(), a2, 1, false, false));
        } else {
            dVar.b(d.c.a(a2, 1, bVar.a(), bVar.b(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void onLayoutChildren(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (uVar.a()) {
            c();
        }
        super.onLayoutChildren(pVar, uVar);
        b();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void onLayoutCompleted(RecyclerView.u uVar) {
        super.onLayoutCompleted(uVar);
        this.f2097a = false;
    }

    private void b() {
        this.f2101e.clear();
        this.f.clear();
    }

    private void c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            b bVar = (b) getChildAt(i).getLayoutParams();
            int f = bVar.f();
            this.f2101e.put(f, bVar.b());
            this.f.put(f, bVar.a());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsChanged(RecyclerView recyclerView) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.g.invalidateSpanIndexCache();
        this.g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean checkLayoutParams(RecyclerView.j jVar) {
        return jVar instanceof b;
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    private void d() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        b(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        if (this.f2099c == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.f2099c;
            chooseSize = chooseSize(i, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.f2099c;
            chooseSize2 = chooseSize(i2, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    private void b(int i) {
        this.f2099c = a(this.f2099c, this.f2098b, i);
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    int a(int i, int i2) {
        if (this.mOrientation == 1 && isLayoutRTL()) {
            int[] iArr = this.f2099c;
            int i3 = this.f2098b;
            return iArr[i3 - i] - iArr[(i3 - i) - i2];
        }
        int[] iArr2 = this.f2099c;
        return iArr2[i2 + i] - iArr2[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.p pVar, RecyclerView.u uVar, LinearLayoutManager.a aVar, int i) {
        super.onAnchorReady(pVar, uVar, aVar, i);
        d();
        if (uVar.e() > 0 && !uVar.a()) {
            a(pVar, uVar, aVar, i);
        }
        e();
    }

    private void e() {
        View[] viewArr = this.f2100d;
        if (viewArr == null || viewArr.length != this.f2098b) {
            this.f2100d = new View[this.f2098b];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int scrollHorizontallyBy(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        d();
        e();
        return super.scrollHorizontallyBy(i, pVar, uVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int scrollVerticallyBy(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        d();
        e();
        return super.scrollVerticallyBy(i, pVar, uVar);
    }

    private void a(RecyclerView.p pVar, RecyclerView.u uVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int b2 = b(pVar, uVar, aVar.f2105b);
        if (z) {
            while (b2 > 0 && aVar.f2105b > 0) {
                aVar.f2105b--;
                b2 = b(pVar, uVar, aVar.f2105b);
            }
            return;
        }
        int e2 = uVar.e() - 1;
        int i2 = aVar.f2105b;
        while (i2 < e2) {
            int i3 = i2 + 1;
            int b3 = b(pVar, uVar, i3);
            if (b3 <= b2) {
                break;
            }
            i2 = i3;
            b2 = b3;
        }
        aVar.f2105b = i2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (position >= 0 && position < i3 && b(pVar, uVar, position) == 0) {
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

    private int a(RecyclerView.p pVar, RecyclerView.u uVar, int i) {
        if (!uVar.a()) {
            return this.g.getCachedSpanGroupIndex(i, this.f2098b);
        }
        int b2 = pVar.b(i);
        if (b2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        return this.g.getCachedSpanGroupIndex(b2, this.f2098b);
    }

    private int b(RecyclerView.p pVar, RecyclerView.u uVar, int i) {
        if (!uVar.a()) {
            return this.g.getCachedSpanIndex(i, this.f2098b);
        }
        int i2 = this.f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b2 = pVar.b(i);
        if (b2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 0;
        }
        return this.g.getCachedSpanIndex(b2, this.f2098b);
    }

    private int c(RecyclerView.p pVar, RecyclerView.u uVar, int i) {
        if (!uVar.a()) {
            return this.g.getSpanSize(i);
        }
        int i2 = this.f2101e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int b2 = pVar.b(i);
        if (b2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 1;
        }
        return this.g.getSpanSize(b2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.u uVar, LinearLayoutManager.c cVar, RecyclerView.i.a aVar) {
        int i = this.f2098b;
        for (int i2 = 0; i2 < this.f2098b && cVar.a(uVar) && i > 0; i2++) {
            int i3 = cVar.f2116d;
            aVar.b(i3, Math.max(0, cVar.g));
            i -= this.g.getSpanSize(i3);
            cVar.f2116d += cVar.f2117e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x009f, code lost:
        r21.f2110b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a1, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutChunk(RecyclerView.p pVar, RecyclerView.u uVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int f;
        int i7;
        int childMeasureSpec;
        int i8;
        View a2;
        int i9 = this.mOrientationHelper.i();
        ?? r5 = 0;
        boolean z = i9 != 1073741824;
        int i10 = getChildCount() > 0 ? this.f2099c[this.f2098b] : 0;
        if (z) {
            d();
        }
        boolean z2 = cVar.f2117e == 1;
        int i11 = this.f2098b;
        if (!z2) {
            i11 = b(pVar, uVar, cVar.f2116d) + c(pVar, uVar, cVar.f2116d);
        }
        int i12 = 0;
        while (i12 < this.f2098b && cVar.a(uVar) && i11 > 0) {
            int i13 = cVar.f2116d;
            int c2 = c(pVar, uVar, i13);
            if (c2 > this.f2098b) {
                throw new IllegalArgumentException("Item at position " + i13 + " requires " + c2 + " spans but GridLayoutManager has only " + this.f2098b + " spans.");
            }
            i11 -= c2;
            if (i11 < 0 || (a2 = cVar.a(pVar)) == null) {
                break;
            }
            this.f2100d[i12] = a2;
            i12++;
        }
        float f2 = 0.0f;
        a(pVar, uVar, i12, z2);
        int i14 = 0;
        int i15 = 0;
        while (i14 < i12) {
            View view = this.f2100d[i14];
            if (cVar.l == null) {
                if (z2) {
                    addView(view);
                } else {
                    addView(view, r5);
                }
            } else if (z2) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, r5);
            }
            calculateItemDecorationsForChild(view, this.h);
            a(view, i9, (boolean) r5);
            int e2 = this.mOrientationHelper.e(view);
            if (e2 > i15) {
                i15 = e2;
            }
            float f3 = (this.mOrientationHelper.f(view) * 1.0f) / ((b) view.getLayoutParams()).f2103b;
            if (f3 > f2) {
                f2 = f3;
            }
            i14++;
            r5 = 0;
        }
        if (z) {
            a(f2, i10);
            i15 = 0;
            for (int i16 = 0; i16 < i12; i16++) {
                View view2 = this.f2100d[i16];
                a(view2, 1073741824, true);
                int e3 = this.mOrientationHelper.e(view2);
                if (e3 > i15) {
                    i15 = e3;
                }
            }
        }
        for (int i17 = 0; i17 < i12; i17++) {
            View view3 = this.f2100d[i17];
            if (this.mOrientationHelper.e(view3) != i15) {
                b bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.f2143d;
                int i18 = rect.top + rect.bottom + bVar2.topMargin + bVar2.bottomMargin;
                int i19 = rect.left + rect.right + bVar2.leftMargin + bVar2.rightMargin;
                int a3 = a(bVar2.f2102a, bVar2.f2103b);
                if (this.mOrientation == 1) {
                    i8 = getChildMeasureSpec(a3, 1073741824, i19, bVar2.width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15 - i18, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15 - i19, 1073741824);
                    childMeasureSpec = getChildMeasureSpec(a3, 1073741824, i18, bVar2.height, false);
                    i8 = makeMeasureSpec;
                }
                a(view3, i8, childMeasureSpec, true);
            }
        }
        int i20 = 0;
        bVar.f2109a = i15;
        if (this.mOrientation == 1) {
            if (cVar.f == -1) {
                i3 = cVar.f2114b;
                i4 = i3 - i15;
            } else {
                int i21 = cVar.f2114b;
                i4 = i21;
                i3 = i15 + i21;
            }
            i = 0;
            i2 = 0;
        } else if (cVar.f == -1) {
            int i22 = cVar.f2114b;
            i2 = i22 - i15;
            i4 = 0;
            i = i22;
            i3 = 0;
        } else {
            int i23 = cVar.f2114b;
            i = i15 + i23;
            i2 = i23;
            i3 = 0;
            i4 = 0;
        }
        while (i20 < i12) {
            View view4 = this.f2100d[i20];
            b bVar3 = (b) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.f2099c[this.f2098b - bVar3.f2102a];
                    i2 = paddingLeft - this.mOrientationHelper.f(view4);
                    f = i3;
                    i6 = paddingLeft;
                    i5 = i4;
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.f2099c[bVar3.f2102a];
                    f = i3;
                    i7 = paddingLeft2;
                    i5 = i4;
                    i6 = this.mOrientationHelper.f(view4) + paddingLeft2;
                    layoutDecoratedWithMargins(view4, i7, i5, i6, f);
                    if (!bVar3.d() || bVar3.e()) {
                        bVar.f2111c = true;
                    }
                    bVar.f2112d |= view4.hasFocusable();
                    i20++;
                    i3 = f;
                    i = i6;
                    i4 = i5;
                    i2 = i7;
                }
            } else {
                int paddingTop = getPaddingTop() + this.f2099c[bVar3.f2102a];
                i5 = paddingTop;
                i6 = i;
                f = this.mOrientationHelper.f(view4) + paddingTop;
            }
            i7 = i2;
            layoutDecoratedWithMargins(view4, i7, i5, i6, f);
            if (!bVar3.d()) {
            }
            bVar.f2111c = true;
            bVar.f2112d |= view4.hasFocusable();
            i20++;
            i3 = f;
            i = i6;
            i4 = i5;
            i2 = i7;
        }
        Arrays.fill(this.f2100d, (Object) null);
    }

    private void a(View view, int i, boolean z) {
        int i2;
        int i3;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f2143d;
        int i4 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i5 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int a2 = a(bVar.f2102a, bVar.f2103b);
        if (this.mOrientation == 1) {
            i3 = getChildMeasureSpec(a2, i, i5, bVar.width, false);
            i2 = getChildMeasureSpec(this.mOrientationHelper.f(), getHeightMode(), i4, bVar.height, true);
        } else {
            int childMeasureSpec = getChildMeasureSpec(a2, i, i4, bVar.height, false);
            int childMeasureSpec2 = getChildMeasureSpec(this.mOrientationHelper.f(), getWidthMode(), i5, bVar.width, true);
            i2 = childMeasureSpec;
            i3 = childMeasureSpec2;
        }
        a(view, i3, i2, z);
    }

    private void a(float f, int i) {
        b(Math.max(Math.round(f * this.f2098b), i));
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean shouldMeasureChild;
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        if (z) {
            shouldMeasureChild = shouldReMeasureChild(view, i, i2, jVar);
        } else {
            shouldMeasureChild = shouldMeasureChild(view, i, i2, jVar);
        }
        if (shouldMeasureChild) {
            view.measure(i, i2);
        }
    }

    private void a(RecyclerView.p pVar, RecyclerView.u uVar, int i, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z) {
            i5 = i;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = i - 1;
            i3 = -1;
        }
        while (i2 != i5) {
            View view = this.f2100d[i2];
            b bVar = (b) view.getLayoutParams();
            bVar.f2103b = c(pVar, uVar, getPosition(view));
            bVar.f2102a = i4;
            i4 += bVar.f2103b;
            i2 += i3;
        }
    }

    public int a() {
        return this.f2098b;
    }

    public void a(int i) {
        if (i == this.f2098b) {
            return;
        }
        this.f2097a = true;
        if (i < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
        this.f2098b = i;
        this.g.invalidateSpanIndexCache();
        requestLayout();
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;
        private boolean mCacheSpanGroupIndices = false;

        public abstract int getSpanSize(int i);

        public void setSpanIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z;
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        int getCachedSpanIndex(int i, int i2) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i, i2);
            }
            int i3 = this.mSpanIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanIndex = getSpanIndex(i, i2);
            this.mSpanIndexCache.put(i, spanIndex);
            return spanIndex;
        }

        int getCachedSpanGroupIndex(int i, int i2) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i, i2);
            }
            int i3 = this.mSpanGroupIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanGroupIndex = getSpanGroupIndex(i, i2);
            this.mSpanGroupIndexCache.put(i, spanGroupIndex);
            return spanGroupIndex;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSpanIndex(int i, int i2) {
            int i3;
            int i4;
            int spanSize = getSpanSize(i);
            if (spanSize == i2) {
                return 0;
            }
            if (!this.mCacheSpanIndices || (i3 = findFirstKeyLessThan(this.mSpanIndexCache, i)) < 0) {
                i3 = 0;
                i4 = 0;
                if (i3 >= i) {
                    int spanSize2 = getSpanSize(i3);
                    i4 += spanSize2;
                    if (i4 == i2) {
                        i4 = 0;
                    } else if (i4 > i2) {
                        i4 = spanSize2;
                    }
                    i3++;
                    if (i3 >= i) {
                        if (spanSize + i4 <= i2) {
                            return i4;
                        }
                        return 0;
                    }
                }
            } else {
                i4 = this.mSpanIndexCache.get(i3) + getSpanSize(i3);
                i3++;
                if (i3 >= i) {
                }
            }
        }

        static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSpanGroupIndex(int i, int i2) {
            int i3;
            int i4;
            int findFirstKeyLessThan;
            if (this.mCacheSpanGroupIndices && (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i)) != -1) {
                int i5 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i3 = findFirstKeyLessThan + 1;
                i4 = getCachedSpanIndex(findFirstKeyLessThan, i2) + getSpanSize(findFirstKeyLessThan);
                i5 = i4 == i2 ? i5 + 1 : 0;
                int spanSize = getSpanSize(i);
                while (i3 < i) {
                    int spanSize2 = getSpanSize(i3);
                    i4 += spanSize2;
                    if (i4 == i2) {
                        i5++;
                        i4 = 0;
                    } else if (i4 > i2) {
                        i5++;
                        i4 = spanSize2;
                    }
                    i3++;
                }
                return i4 + spanSize <= i2 ? i5 + 1 : i5;
            }
            i3 = 0;
            i4 = 0;
            int spanSize3 = getSpanSize(i);
            while (i3 < i) {
            }
            if (i4 + spanSize3 <= i2) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d8, code lost:
        if (r13 == (r2 > r15)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f8, code lost:
        if (r13 == (r2 > r11)) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0109  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFocusSearchFailed(View view, int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        int childCount;
        int i2;
        int i3;
        View view2;
        int i4;
        View view3;
        int i5;
        boolean z;
        int i6;
        int i7;
        RecyclerView.p pVar2 = pVar;
        RecyclerView.u uVar2 = uVar;
        View findContainingItemView = findContainingItemView(view);
        View view4 = null;
        if (findContainingItemView == null) {
            return null;
        }
        b bVar = (b) findContainingItemView.getLayoutParams();
        int i8 = bVar.f2102a;
        int i9 = bVar.f2102a + bVar.f2103b;
        if (super.onFocusSearchFailed(view, i, pVar, uVar) == null) {
            return null;
        }
        if ((convertFocusDirectionToLayoutDirection(i) == 1) != this.mShouldReverseLayout) {
            i2 = getChildCount() - 1;
            childCount = -1;
            i3 = -1;
        } else {
            childCount = getChildCount();
            i2 = 0;
            i3 = 1;
        }
        boolean z2 = this.mOrientation == 1 && isLayoutRTL();
        int a2 = a(pVar2, uVar2, i2);
        int i10 = i2;
        int i11 = 0;
        int i12 = -1;
        int i13 = -1;
        int i14 = 0;
        View view5 = null;
        while (i10 != childCount) {
            int a3 = a(pVar2, uVar2, i10);
            View childAt = getChildAt(i10);
            if (childAt == findContainingItemView) {
                break;
            }
            if (!childAt.hasFocusable() || a3 == a2) {
                b bVar2 = (b) childAt.getLayoutParams();
                int i15 = bVar2.f2102a;
                view2 = findContainingItemView;
                i4 = childCount;
                int i16 = bVar2.f2102a + bVar2.f2103b;
                if (childAt.hasFocusable() && i15 == i8 && i16 == i9) {
                    return childAt;
                }
                if ((!childAt.hasFocusable() || view4 != null) && (childAt.hasFocusable() || view5 != null)) {
                    int min = Math.min(i16, i9) - Math.max(i15, i8);
                    if (childAt.hasFocusable()) {
                        if (min <= i11) {
                            if (min == i11) {
                            }
                        }
                    } else if (view4 == null) {
                        view3 = view5;
                        i5 = i11;
                        if (isViewPartiallyVisible(childAt, false, true)) {
                            i6 = i14;
                            if (min > i6) {
                                i7 = i13;
                                if (z) {
                                    if (childAt.hasFocusable()) {
                                        int i17 = bVar2.f2102a;
                                        i11 = Math.min(i16, i9) - Math.max(i15, i8);
                                        i12 = i17;
                                        i14 = i6;
                                        i13 = i7;
                                        view5 = view3;
                                        view4 = childAt;
                                    } else {
                                        int i18 = bVar2.f2102a;
                                        i14 = Math.min(i16, i9) - Math.max(i15, i8);
                                        i11 = i5;
                                        i13 = i18;
                                        view5 = childAt;
                                    }
                                    i10 += i3;
                                    pVar2 = pVar;
                                    uVar2 = uVar;
                                    findContainingItemView = view2;
                                    childCount = i4;
                                }
                            } else {
                                if (min == i6) {
                                    i7 = i13;
                                } else {
                                    i7 = i13;
                                }
                                z = false;
                                if (z) {
                                }
                            }
                        }
                        i7 = i13;
                        i6 = i14;
                        z = false;
                        if (z) {
                        }
                    }
                    view3 = view5;
                    i5 = i11;
                    i7 = i13;
                    i6 = i14;
                    z = false;
                    if (z) {
                    }
                }
                view3 = view5;
                i5 = i11;
                i7 = i13;
                i6 = i14;
                z = true;
                if (z) {
                }
            } else if (view4 != null) {
                break;
            } else {
                view2 = findContainingItemView;
                view3 = view5;
                i5 = i11;
                i4 = childCount;
                i7 = i13;
                i6 = i14;
            }
            i11 = i5;
            i14 = i6;
            i13 = i7;
            view5 = view3;
            i10 += i3;
            pVar2 = pVar;
            uVar2 = uVar;
            findContainingItemView = view2;
            childCount = i4;
        }
        return view4 != null ? view4 : view5;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f2097a;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int computeHorizontalScrollRange(RecyclerView.u uVar) {
        if (this.i) {
            return a(uVar);
        }
        return super.computeHorizontalScrollRange(uVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int computeVerticalScrollRange(RecyclerView.u uVar) {
        if (this.i) {
            return a(uVar);
        }
        return super.computeVerticalScrollRange(uVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int computeHorizontalScrollOffset(RecyclerView.u uVar) {
        if (this.i) {
            return b(uVar);
        }
        return super.computeHorizontalScrollOffset(uVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int computeVerticalScrollOffset(RecyclerView.u uVar) {
        if (this.i) {
            return b(uVar);
        }
        return super.computeVerticalScrollOffset(uVar);
    }

    private int a(RecyclerView.u uVar) {
        if (getChildCount() != 0 && uVar.e() != 0) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.g.getCachedSpanGroupIndex(uVar.e() - 1, this.f2098b) + 1;
                }
                int b2 = this.mOrientationHelper.b(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.a(findFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.f2098b);
                return (int) ((b2 / ((this.g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.f2098b) - cachedSpanGroupIndex) + 1)) * (this.g.getCachedSpanGroupIndex(uVar.e() - 1, this.f2098b) + 1));
            }
        }
        return 0;
    }

    private int b(RecyclerView.u uVar) {
        int max;
        if (getChildCount() != 0 && uVar.e() != 0) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                int cachedSpanGroupIndex = this.g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.f2098b);
                int cachedSpanGroupIndex2 = this.g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.f2098b);
                int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int max2 = Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int cachedSpanGroupIndex3 = this.g.getCachedSpanGroupIndex(uVar.e() - 1, this.f2098b) + 1;
                if (this.mShouldReverseLayout) {
                    max = Math.max(0, (cachedSpanGroupIndex3 - max2) - 1);
                } else {
                    max = Math.max(0, min);
                }
                if (isSmoothScrollbarEnabled) {
                    return Math.round((max * (Math.abs(this.mOrientationHelper.b(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.a(findFirstVisibleChildClosestToStart)) / ((this.g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.f2098b) - this.g.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.f2098b)) + 1))) + (this.mOrientationHelper.c() - this.mOrientationHelper.a(findFirstVisibleChildClosestToStart)));
                }
                return max;
            }
        }
        return 0;
    }

    /* loaded from: classes.dex */
    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanIndex(int i, int i2) {
            return i % i2;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.j {

        /* renamed from: a  reason: collision with root package name */
        int f2102a;

        /* renamed from: b  reason: collision with root package name */
        int f2103b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2102a = -1;
            this.f2103b = 0;
        }

        public b(int i, int i2) {
            super(i, i2);
            this.f2102a = -1;
            this.f2103b = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2102a = -1;
            this.f2103b = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2102a = -1;
            this.f2103b = 0;
        }

        public int a() {
            return this.f2102a;
        }

        public int b() {
            return this.f2103b;
        }
    }
}
