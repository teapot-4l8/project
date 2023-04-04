package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.a.d;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.i implements RecyclerView.t.b {

    /* renamed from: a  reason: collision with root package name */
    e[] f2174a;

    /* renamed from: b  reason: collision with root package name */
    s f2175b;

    /* renamed from: c  reason: collision with root package name */
    s f2176c;
    private int j;
    private int k;
    private final o l;
    private BitSet m;
    private boolean o;
    private boolean p;

    /* renamed from: q  reason: collision with root package name */
    private d f2179q;
    private int r;
    private int[] w;
    private int i = -1;

    /* renamed from: d  reason: collision with root package name */
    boolean f2177d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f2178e = false;
    int f = -1;
    int g = Integer.MIN_VALUE;
    c h = new c();
    private int n = 2;
    private final Rect s = new Rect();
    private final a t = new a();
    private boolean u = false;
    private boolean v = true;
    private final Runnable x = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.a();
        }
    };

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.i.b properties = getProperties(context, attributeSet, i, i2);
        b(properties.f2138a);
        a(properties.f2139b);
        a(properties.f2140c);
        this.l = new o();
        k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean isAutoMeasureEnabled() {
        return this.n != 0;
    }

    private void k() {
        this.f2175b = s.a(this, this.j);
        this.f2176c = s.a(this, 1 - this.j);
    }

    boolean a() {
        int j;
        int i;
        if (getChildCount() == 0 || this.n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f2178e) {
            j = i();
            i = j();
        } else {
            j = j();
            i = i();
        }
        if (j == 0 && b() != null) {
            this.h.a();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (this.u) {
            int i2 = this.f2178e ? -1 : 1;
            int i3 = i + 1;
            c.a a2 = this.h.a(j, i3, i2, true);
            if (a2 == null) {
                this.u = false;
                this.h.a(i3);
                return false;
            }
            c.a a3 = this.h.a(j, a2.f2190a, i2 * (-1), true);
            if (a3 == null) {
                this.h.a(a2.f2190a);
            } else {
                this.h.a(a3.f2190a + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.p pVar) {
        super.onDetachedFromWindow(recyclerView, pVar);
        removeCallbacks(this.x);
        for (int i = 0; i < this.i; i++) {
            this.f2174a[i].e();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    View b() {
        int i;
        int i2;
        boolean z;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.i);
        bitSet.set(0, this.i, true);
        char c2 = (this.j == 1 && e()) ? (char) 1 : (char) 65535;
        if (this.f2178e) {
            i = -1;
        } else {
            i = childCount + 1;
            childCount = 0;
        }
        int i3 = childCount < i ? 1 : -1;
        while (childCount != i) {
            View childAt = getChildAt(childCount);
            b bVar = (b) childAt.getLayoutParams();
            if (bitSet.get(bVar.f2186a.f2203e)) {
                if (a(bVar.f2186a)) {
                    return childAt;
                }
                bitSet.clear(bVar.f2186a.f2203e);
            }
            if (!bVar.f2187b && (i2 = childCount + i3) != i) {
                View childAt2 = getChildAt(i2);
                if (this.f2178e) {
                    int b2 = this.f2175b.b(childAt);
                    int b3 = this.f2175b.b(childAt2);
                    if (b2 < b3) {
                        return childAt;
                    }
                } else {
                    int a2 = this.f2175b.a(childAt);
                    int a3 = this.f2175b.a(childAt2);
                    if (a2 > a3) {
                        return childAt;
                    }
                }
                if (z) {
                    if ((bVar.f2186a.f2203e - ((b) childAt2.getLayoutParams()).f2186a.f2203e < 0) != (c2 < 0)) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            childCount += i3;
        }
        return null;
    }

    private boolean a(e eVar) {
        if (this.f2178e) {
            if (eVar.d() < this.f2175b.d()) {
                return !eVar.c(eVar.f2199a.get(eVar.f2199a.size() - 1)).f2187b;
            }
        } else if (eVar.b() > this.f2175b.c()) {
            return !eVar.c(eVar.f2199a.get(0)).f2187b;
        }
        return false;
    }

    public void a(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.i) {
            d();
            this.i = i;
            this.m = new BitSet(this.i);
            this.f2174a = new e[this.i];
            for (int i2 = 0; i2 < this.i; i2++) {
                this.f2174a[i2] = new e(i2);
            }
            requestLayout();
        }
    }

    public void b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i == this.j) {
            return;
        }
        this.j = i;
        s sVar = this.f2175b;
        this.f2175b = this.f2176c;
        this.f2176c = sVar;
        requestLayout();
    }

    public void a(boolean z) {
        assertNotInLayoutOrScroll(null);
        d dVar = this.f2179q;
        if (dVar != null && dVar.h != z) {
            this.f2179q.h = z;
        }
        this.f2177d = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void assertNotInLayoutOrScroll(String str) {
        if (this.f2179q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public int c() {
        return this.i;
    }

    public void d() {
        this.h.a();
        requestLayout();
    }

    private void l() {
        if (this.j == 1 || !e()) {
            this.f2178e = this.f2177d;
        } else {
            this.f2178e = !this.f2177d;
        }
    }

    boolean e() {
        return getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.j == 1) {
            chooseSize2 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            chooseSize = chooseSize(i, (this.k * this.i) + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            chooseSize2 = chooseSize(i2, (this.k * this.i) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onLayoutChildren(RecyclerView.p pVar, RecyclerView.u uVar) {
        a(pVar, uVar, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0161, code lost:
        if (a() != false) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(RecyclerView.p pVar, RecyclerView.u uVar, boolean z) {
        d dVar;
        a aVar = this.t;
        if ((this.f2179q != null || this.f != -1) && uVar.e() == 0) {
            removeAndRecycleAllViews(pVar);
            aVar.a();
            return;
        }
        boolean z2 = true;
        boolean z3 = (aVar.f2185e && this.f == -1 && this.f2179q == null) ? false : true;
        if (z3) {
            aVar.a();
            if (this.f2179q != null) {
                a(aVar);
            } else {
                l();
                aVar.f2183c = this.f2178e;
            }
            a(uVar, aVar);
            aVar.f2185e = true;
        }
        if (this.f2179q == null && this.f == -1 && (aVar.f2183c != this.o || e() != this.p)) {
            this.h.a();
            aVar.f2184d = true;
        }
        if (getChildCount() > 0 && ((dVar = this.f2179q) == null || dVar.f2196c < 1)) {
            if (aVar.f2184d) {
                for (int i = 0; i < this.i; i++) {
                    this.f2174a[i].e();
                    if (aVar.f2182b != Integer.MIN_VALUE) {
                        this.f2174a[i].c(aVar.f2182b);
                    }
                }
            } else if (z3 || this.t.f == null) {
                for (int i2 = 0; i2 < this.i; i2++) {
                    this.f2174a[i2].a(this.f2178e, aVar.f2182b);
                }
                this.t.a(this.f2174a);
            } else {
                for (int i3 = 0; i3 < this.i; i3++) {
                    e eVar = this.f2174a[i3];
                    eVar.e();
                    eVar.c(this.t.f[i3]);
                }
            }
        }
        detachAndScrapAttachedViews(pVar);
        this.l.f2354a = false;
        this.u = false;
        c(this.f2176c.f());
        b(aVar.f2181a, uVar);
        if (aVar.f2183c) {
            d(-1);
            a(pVar, this.l, uVar);
            d(1);
            this.l.f2356c = aVar.f2181a + this.l.f2357d;
            a(pVar, this.l, uVar);
        } else {
            d(1);
            a(pVar, this.l, uVar);
            d(-1);
            this.l.f2356c = aVar.f2181a + this.l.f2357d;
            a(pVar, this.l, uVar);
        }
        m();
        if (getChildCount() > 0) {
            if (this.f2178e) {
                b(pVar, uVar, true);
                c(pVar, uVar, false);
            } else {
                c(pVar, uVar, true);
                b(pVar, uVar, false);
            }
        }
        if (z && !uVar.a()) {
            if (this.n != 0 && getChildCount() > 0 && (this.u || b() != null)) {
                removeCallbacks(this.x);
            }
        }
        z2 = false;
        if (uVar.a()) {
            this.t.a();
        }
        this.o = aVar.f2183c;
        this.p = e();
        if (z2) {
            this.t.a();
            a(pVar, uVar, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onLayoutCompleted(RecyclerView.u uVar) {
        super.onLayoutCompleted(uVar);
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        this.f2179q = null;
        this.t.a();
    }

    private void m() {
        if (this.f2176c.h() == 1073741824) {
            return;
        }
        float f = 0.0f;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            float e2 = this.f2176c.e(childAt);
            if (e2 >= f) {
                if (((b) childAt.getLayoutParams()).a()) {
                    e2 = (e2 * 1.0f) / this.i;
                }
                f = Math.max(f, e2);
            }
        }
        int i2 = this.k;
        int round = Math.round(f * this.i);
        if (this.f2176c.h() == Integer.MIN_VALUE) {
            round = Math.min(round, this.f2176c.f());
        }
        c(round);
        if (this.k == i2) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            b bVar = (b) childAt2.getLayoutParams();
            if (!bVar.f2187b) {
                if (e() && this.j == 1) {
                    childAt2.offsetLeftAndRight(((-((this.i - 1) - bVar.f2186a.f2203e)) * this.k) - ((-((this.i - 1) - bVar.f2186a.f2203e)) * i2));
                } else {
                    int i4 = bVar.f2186a.f2203e * this.k;
                    int i5 = bVar.f2186a.f2203e * i2;
                    if (this.j == 1) {
                        childAt2.offsetLeftAndRight(i4 - i5);
                    } else {
                        childAt2.offsetTopAndBottom(i4 - i5);
                    }
                }
            }
        }
    }

    private void a(a aVar) {
        int c2;
        if (this.f2179q.f2196c > 0) {
            if (this.f2179q.f2196c == this.i) {
                for (int i = 0; i < this.i; i++) {
                    this.f2174a[i].e();
                    int i2 = this.f2179q.f2197d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.f2179q.i) {
                            c2 = this.f2175b.d();
                        } else {
                            c2 = this.f2175b.c();
                        }
                        i2 += c2;
                    }
                    this.f2174a[i].c(i2);
                }
            } else {
                this.f2179q.a();
                d dVar = this.f2179q;
                dVar.f2194a = dVar.f2195b;
            }
        }
        this.p = this.f2179q.j;
        a(this.f2179q.h);
        l();
        if (this.f2179q.f2194a != -1) {
            this.f = this.f2179q.f2194a;
            aVar.f2183c = this.f2179q.i;
        } else {
            aVar.f2183c = this.f2178e;
        }
        if (this.f2179q.f2198e > 1) {
            this.h.f2188a = this.f2179q.f;
            this.h.f2189b = this.f2179q.g;
        }
    }

    void a(RecyclerView.u uVar, a aVar) {
        if (b(uVar, aVar) || c(uVar, aVar)) {
            return;
        }
        aVar.b();
        aVar.f2181a = 0;
    }

    private boolean c(RecyclerView.u uVar, a aVar) {
        int m;
        if (this.o) {
            m = n(uVar.e());
        } else {
            m = m(uVar.e());
        }
        aVar.f2181a = m;
        aVar.f2182b = Integer.MIN_VALUE;
        return true;
    }

    boolean b(RecyclerView.u uVar, a aVar) {
        int i;
        int c2;
        if (!uVar.a() && (i = this.f) != -1) {
            if (i < 0 || i >= uVar.e()) {
                this.f = -1;
                this.g = Integer.MIN_VALUE;
            } else {
                d dVar = this.f2179q;
                if (dVar == null || dVar.f2194a == -1 || this.f2179q.f2196c < 1) {
                    View findViewByPosition = findViewByPosition(this.f);
                    if (findViewByPosition != null) {
                        aVar.f2181a = this.f2178e ? i() : j();
                        if (this.g != Integer.MIN_VALUE) {
                            if (aVar.f2183c) {
                                aVar.f2182b = (this.f2175b.d() - this.g) - this.f2175b.b(findViewByPosition);
                            } else {
                                aVar.f2182b = (this.f2175b.c() + this.g) - this.f2175b.a(findViewByPosition);
                            }
                            return true;
                        } else if (this.f2175b.e(findViewByPosition) > this.f2175b.f()) {
                            if (aVar.f2183c) {
                                c2 = this.f2175b.d();
                            } else {
                                c2 = this.f2175b.c();
                            }
                            aVar.f2182b = c2;
                            return true;
                        } else {
                            int a2 = this.f2175b.a(findViewByPosition) - this.f2175b.c();
                            if (a2 < 0) {
                                aVar.f2182b = -a2;
                                return true;
                            }
                            int d2 = this.f2175b.d() - this.f2175b.b(findViewByPosition);
                            if (d2 < 0) {
                                aVar.f2182b = d2;
                                return true;
                            }
                            aVar.f2182b = Integer.MIN_VALUE;
                        }
                    } else {
                        aVar.f2181a = this.f;
                        int i2 = this.g;
                        if (i2 == Integer.MIN_VALUE) {
                            aVar.f2183c = l(aVar.f2181a) == 1;
                            aVar.b();
                        } else {
                            aVar.a(i2);
                        }
                        aVar.f2184d = true;
                    }
                } else {
                    aVar.f2182b = Integer.MIN_VALUE;
                    aVar.f2181a = this.f;
                }
                return true;
            }
        }
        return false;
    }

    void c(int i) {
        this.k = i / this.i;
        this.r = View.MeasureSpec.makeMeasureSpec(i, this.f2176c.h());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean supportsPredictiveItemAnimations() {
        return this.f2179q == null;
    }

    public int[] a(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.i];
        } else if (iArr.length < this.i) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.i + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.i; i++) {
            iArr[i] = this.f2174a[i].l();
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeHorizontalScrollOffset(RecyclerView.u uVar) {
        return a(uVar);
    }

    private int a(RecyclerView.u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return v.a(uVar, this.f2175b, b(!this.v), c(!this.v), this, this.v, this.f2178e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeVerticalScrollOffset(RecyclerView.u uVar) {
        return a(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeHorizontalScrollExtent(RecyclerView.u uVar) {
        return b(uVar);
    }

    private int b(RecyclerView.u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return v.a(uVar, this.f2175b, b(!this.v), c(!this.v), this, this.v);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeVerticalScrollExtent(RecyclerView.u uVar) {
        return b(uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeHorizontalScrollRange(RecyclerView.u uVar) {
        return c(uVar);
    }

    private int c(RecyclerView.u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return v.b(uVar, this.f2175b, b(!this.v), c(!this.v), this, this.v);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int computeVerticalScrollRange(RecyclerView.u uVar) {
        return c(uVar);
    }

    private void a(View view, b bVar, boolean z) {
        if (bVar.f2187b) {
            if (this.j == 1) {
                a(view, this.r, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), bVar.height, true), z);
            } else {
                a(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), bVar.width, true), this.r, z);
            }
        } else if (this.j == 1) {
            a(view, getChildMeasureSpec(this.k, getWidthMode(), 0, bVar.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), bVar.height, true), z);
        } else {
            a(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), bVar.width, true), getChildMeasureSpec(this.k, getHeightMode(), 0, bVar.height, false), z);
        }
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean shouldMeasureChild;
        calculateItemDecorationsForChild(view, this.s);
        b bVar = (b) view.getLayoutParams();
        int a2 = a(i, bVar.leftMargin + this.s.left, bVar.rightMargin + this.s.right);
        int a3 = a(i2, bVar.topMargin + this.s.top, bVar.bottomMargin + this.s.bottom);
        if (z) {
            shouldMeasureChild = shouldReMeasureChild(view, a2, a3, bVar);
        } else {
            shouldMeasureChild = shouldMeasureChild(view, a2, a3, bVar);
        }
        if (shouldMeasureChild) {
            view.measure(a2, a3);
        }
    }

    private int a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.f2179q = (d) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public Parcelable onSaveInstanceState() {
        int a2;
        int c2;
        if (this.f2179q != null) {
            return new d(this.f2179q);
        }
        d dVar = new d();
        dVar.h = this.f2177d;
        dVar.i = this.o;
        dVar.j = this.p;
        c cVar = this.h;
        if (cVar != null && cVar.f2188a != null) {
            dVar.f = this.h.f2188a;
            dVar.f2198e = dVar.f.length;
            dVar.g = this.h.f2189b;
        } else {
            dVar.f2198e = 0;
        }
        if (getChildCount() > 0) {
            dVar.f2194a = this.o ? i() : j();
            dVar.f2195b = f();
            dVar.f2196c = this.i;
            dVar.f2197d = new int[this.i];
            for (int i = 0; i < this.i; i++) {
                if (this.o) {
                    a2 = this.f2174a[i].b(Integer.MIN_VALUE);
                    if (a2 != Integer.MIN_VALUE) {
                        c2 = this.f2175b.d();
                        a2 -= c2;
                        dVar.f2197d[i] = a2;
                    } else {
                        dVar.f2197d[i] = a2;
                    }
                } else {
                    a2 = this.f2174a[i].a(Integer.MIN_VALUE);
                    if (a2 != Integer.MIN_VALUE) {
                        c2 = this.f2175b.c();
                        a2 -= c2;
                        dVar.f2197d[i] = a2;
                    } else {
                        dVar.f2197d[i] = a2;
                    }
                }
            }
        } else {
            dVar.f2194a = -1;
            dVar.f2195b = -1;
            dVar.f2196c = 0;
        }
        return dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.p pVar, RecyclerView.u uVar, View view, androidx.core.h.a.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        if (this.j == 0) {
            dVar.b(d.c.a(bVar.b(), bVar.f2187b ? this.i : 1, -1, -1, false, false));
        } else {
            dVar.b(d.c.a(-1, -1, bVar.b(), bVar.f2187b ? this.i : 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View b2 = b(false);
            View c2 = c(false);
            if (b2 == null || c2 == null) {
                return;
            }
            int position = getPosition(b2);
            int position2 = getPosition(c2);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
                return;
            }
            accessibilityEvent.setFromIndex(position2);
            accessibilityEvent.setToIndex(position);
        }
    }

    int f() {
        View c2 = this.f2178e ? c(true) : b(true);
        if (c2 == null) {
            return -1;
        }
        return getPosition(c2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int getRowCountForAccessibility(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.j == 0) {
            return this.i;
        }
        return super.getRowCountForAccessibility(pVar, uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int getColumnCountForAccessibility(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.j == 1) {
            return this.i;
        }
        return super.getColumnCountForAccessibility(pVar, uVar);
    }

    View b(boolean z) {
        int c2 = this.f2175b.c();
        int d2 = this.f2175b.d();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int a2 = this.f2175b.a(childAt);
            if (this.f2175b.b(childAt) > c2 && a2 < d2) {
                if (a2 >= c2 || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    View c(boolean z) {
        int c2 = this.f2175b.c();
        int d2 = this.f2175b.d();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int a2 = this.f2175b.a(childAt);
            int b2 = this.f2175b.b(childAt);
            if (b2 > c2 && a2 < d2) {
                if (b2 <= d2 || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private void b(RecyclerView.p pVar, RecyclerView.u uVar, boolean z) {
        int d2;
        int i = i(Integer.MIN_VALUE);
        if (i != Integer.MIN_VALUE && (d2 = this.f2175b.d() - i) > 0) {
            int i2 = d2 - (-a(-d2, pVar, uVar));
            if (!z || i2 <= 0) {
                return;
            }
            this.f2175b.a(i2);
        }
    }

    private void c(RecyclerView.p pVar, RecyclerView.u uVar, boolean z) {
        int c2;
        int h = h(Integer.MAX_VALUE);
        if (h != Integer.MAX_VALUE && (c2 = h - this.f2175b.c()) > 0) {
            int a2 = c2 - a(c2, pVar, uVar);
            if (!z || a2 <= 0) {
                return;
            }
            this.f2175b.a(-a2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(int i, RecyclerView.u uVar) {
        int i2;
        int i3;
        int c2;
        boolean z = false;
        this.l.f2355b = 0;
        this.l.f2356c = i;
        if (!isSmoothScrolling() || (c2 = uVar.c()) == -1) {
            i2 = 0;
        } else {
            if (this.f2178e == (c2 < i)) {
                i2 = this.f2175b.f();
            } else {
                i3 = this.f2175b.f();
                i2 = 0;
                if (!getClipToPadding()) {
                    this.l.f = this.f2175b.c() - i3;
                    this.l.g = this.f2175b.d() + i2;
                } else {
                    this.l.g = this.f2175b.e() + i2;
                    this.l.f = -i3;
                }
                this.l.h = false;
                this.l.f2354a = true;
                o oVar = this.l;
                if (this.f2175b.h() == 0 && this.f2175b.e() == 0) {
                    z = true;
                }
                oVar.i = z;
            }
        }
        i3 = 0;
        if (!getClipToPadding()) {
        }
        this.l.h = false;
        this.l.f2354a = true;
        o oVar2 = this.l;
        if (this.f2175b.h() == 0) {
            z = true;
        }
        oVar2.i = z;
    }

    private void d(int i) {
        this.l.f2358e = i;
        this.l.f2357d = this.f2178e != (i == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.f2174a[i2].d(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.f2174a[i2].d(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        b(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        b(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsChanged(RecyclerView recyclerView) {
        this.h.a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        b(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        b(i, i2, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = this.f2178e ? i() : j();
        if (i3 != 8) {
            i4 = i + i2;
        } else if (i >= i2) {
            i4 = i + 1;
            i5 = i2;
            this.h.b(i5);
            if (i3 != 1) {
                this.h.b(i, i2);
            } else if (i3 == 2) {
                this.h.a(i, i2);
            } else if (i3 == 8) {
                this.h.a(i, 1);
                this.h.b(i2, 1);
            }
            if (i4 > i6) {
                return;
            }
            if (i5 <= (this.f2178e ? j() : i())) {
                requestLayout();
                return;
            }
            return;
        } else {
            i4 = i2 + 1;
        }
        i5 = i;
        this.h.b(i5);
        if (i3 != 1) {
        }
        if (i4 > i6) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int a(RecyclerView.p pVar, o oVar, RecyclerView.u uVar) {
        int i;
        int i2;
        int c2;
        int i3;
        e eVar;
        int e2;
        int i4;
        int i5;
        int e3;
        boolean h;
        ?? r9 = 0;
        this.m.set(0, this.i, true);
        if (this.l.i) {
            i2 = oVar.f2358e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (oVar.f2358e == 1) {
                i = oVar.g + oVar.f2355b;
            } else {
                i = oVar.f - oVar.f2355b;
            }
            i2 = i;
        }
        a(oVar.f2358e, i2);
        if (this.f2178e) {
            c2 = this.f2175b.d();
        } else {
            c2 = this.f2175b.c();
        }
        int i6 = c2;
        boolean z = false;
        while (oVar.a(uVar) && (this.l.i || !this.m.isEmpty())) {
            View a2 = oVar.a(pVar);
            b bVar = (b) a2.getLayoutParams();
            int f = bVar.f();
            int c3 = this.h.c(f);
            boolean z2 = c3 == -1;
            if (z2) {
                eVar = bVar.f2187b ? this.f2174a[r9] : a(oVar);
                this.h.a(f, eVar);
            } else {
                eVar = this.f2174a[c3];
            }
            e eVar2 = eVar;
            bVar.f2186a = eVar2;
            if (oVar.f2358e == 1) {
                addView(a2);
            } else {
                addView(a2, r9);
            }
            a(a2, bVar, (boolean) r9);
            if (oVar.f2358e == 1) {
                int i7 = bVar.f2187b ? i(i6) : eVar2.b(i6);
                int e4 = this.f2175b.e(a2) + i7;
                if (z2 && bVar.f2187b) {
                    c.a e5 = e(i7);
                    e5.f2191b = -1;
                    e5.f2190a = f;
                    this.h.a(e5);
                }
                i4 = e4;
                e2 = i7;
            } else {
                int h2 = bVar.f2187b ? h(i6) : eVar2.a(i6);
                e2 = h2 - this.f2175b.e(a2);
                if (z2 && bVar.f2187b) {
                    c.a f2 = f(h2);
                    f2.f2191b = 1;
                    f2.f2190a = f;
                    this.h.a(f2);
                }
                i4 = h2;
            }
            if (bVar.f2187b && oVar.f2357d == -1) {
                if (z2) {
                    this.u = true;
                } else {
                    if (oVar.f2358e == 1) {
                        h = g();
                    } else {
                        h = h();
                    }
                    if (!h) {
                        c.a f3 = this.h.f(f);
                        if (f3 != null) {
                            f3.f2193d = true;
                        }
                        this.u = true;
                    }
                }
            }
            a(a2, bVar, oVar);
            if (e() && this.j == 1) {
                int d2 = bVar.f2187b ? this.f2176c.d() : this.f2176c.d() - (((this.i - 1) - eVar2.f2203e) * this.k);
                e3 = d2;
                i5 = d2 - this.f2176c.e(a2);
            } else {
                int c4 = bVar.f2187b ? this.f2176c.c() : (eVar2.f2203e * this.k) + this.f2176c.c();
                i5 = c4;
                e3 = this.f2176c.e(a2) + c4;
            }
            if (this.j == 1) {
                layoutDecoratedWithMargins(a2, i5, e2, e3, i4);
            } else {
                layoutDecoratedWithMargins(a2, e2, i5, i4, e3);
            }
            if (bVar.f2187b) {
                a(this.l.f2358e, i2);
            } else {
                a(eVar2, this.l.f2358e, i2);
            }
            a(pVar, this.l);
            if (this.l.h && a2.hasFocusable()) {
                if (bVar.f2187b) {
                    this.m.clear();
                } else {
                    this.m.set(eVar2.f2203e, false);
                    z = true;
                    r9 = 0;
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            a(pVar, this.l);
        }
        if (this.l.f2358e == -1) {
            i3 = this.f2175b.c() - h(this.f2175b.c());
        } else {
            i3 = i(this.f2175b.d()) - this.f2175b.d();
        }
        if (i3 > 0) {
            return Math.min(oVar.f2355b, i3);
        }
        return 0;
    }

    private c.a e(int i) {
        c.a aVar = new c.a();
        aVar.f2192c = new int[this.i];
        for (int i2 = 0; i2 < this.i; i2++) {
            aVar.f2192c[i2] = i - this.f2174a[i2].b(i);
        }
        return aVar;
    }

    private c.a f(int i) {
        c.a aVar = new c.a();
        aVar.f2192c = new int[this.i];
        for (int i2 = 0; i2 < this.i; i2++) {
            aVar.f2192c[i2] = this.f2174a[i2].a(i) - i;
        }
        return aVar;
    }

    private void a(View view, b bVar, o oVar) {
        if (oVar.f2358e == 1) {
            if (bVar.f2187b) {
                a(view);
            } else {
                bVar.f2186a.b(view);
            }
        } else if (bVar.f2187b) {
            b(view);
        } else {
            bVar.f2186a.a(view);
        }
    }

    private void a(RecyclerView.p pVar, o oVar) {
        int min;
        int min2;
        if (!oVar.f2354a || oVar.i) {
            return;
        }
        if (oVar.f2355b == 0) {
            if (oVar.f2358e == -1) {
                b(pVar, oVar.g);
            } else {
                a(pVar, oVar.f);
            }
        } else if (oVar.f2358e == -1) {
            int g = oVar.f - g(oVar.f);
            if (g < 0) {
                min2 = oVar.g;
            } else {
                min2 = oVar.g - Math.min(g, oVar.f2355b);
            }
            b(pVar, min2);
        } else {
            int j = j(oVar.g) - oVar.g;
            if (j < 0) {
                min = oVar.f;
            } else {
                min = Math.min(j, oVar.f2355b) + oVar.f;
            }
            a(pVar, min);
        }
    }

    private void a(View view) {
        for (int i = this.i - 1; i >= 0; i--) {
            this.f2174a[i].b(view);
        }
    }

    private void b(View view) {
        for (int i = this.i - 1; i >= 0; i--) {
            this.f2174a[i].a(view);
        }
    }

    private void a(int i, int i2) {
        for (int i3 = 0; i3 < this.i; i3++) {
            if (!this.f2174a[i3].f2199a.isEmpty()) {
                a(this.f2174a[i3], i, i2);
            }
        }
    }

    private void a(e eVar, int i, int i2) {
        int i3 = eVar.i();
        if (i == -1) {
            if (eVar.b() + i3 <= i2) {
                this.m.set(eVar.f2203e, false);
            }
        } else if (eVar.d() - i3 >= i2) {
            this.m.set(eVar.f2203e, false);
        }
    }

    private int g(int i) {
        int a2 = this.f2174a[0].a(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int a3 = this.f2174a[i2].a(i);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int h(int i) {
        int a2 = this.f2174a[0].a(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int a3 = this.f2174a[i2].a(i);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    boolean g() {
        int b2 = this.f2174a[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.i; i++) {
            if (this.f2174a[i].b(Integer.MIN_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    boolean h() {
        int a2 = this.f2174a[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.i; i++) {
            if (this.f2174a[i].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    private int i(int i) {
        int b2 = this.f2174a[0].b(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int b3 = this.f2174a[i2].b(i);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private int j(int i) {
        int b2 = this.f2174a[0].b(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int b3 = this.f2174a[i2].b(i);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private void a(RecyclerView.p pVar, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f2175b.b(childAt) > i || this.f2175b.c(childAt) > i) {
                return;
            }
            b bVar = (b) childAt.getLayoutParams();
            if (bVar.f2187b) {
                for (int i2 = 0; i2 < this.i; i2++) {
                    if (this.f2174a[i2].f2199a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.i; i3++) {
                    this.f2174a[i3].h();
                }
            } else if (bVar.f2186a.f2199a.size() == 1) {
                return;
            } else {
                bVar.f2186a.h();
            }
            removeAndRecycleView(childAt, pVar);
        }
    }

    private void b(RecyclerView.p pVar, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f2175b.a(childAt) < i || this.f2175b.d(childAt) < i) {
                return;
            }
            b bVar = (b) childAt.getLayoutParams();
            if (bVar.f2187b) {
                for (int i2 = 0; i2 < this.i; i2++) {
                    if (this.f2174a[i2].f2199a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.i; i3++) {
                    this.f2174a[i3].g();
                }
            } else if (bVar.f2186a.f2199a.size() == 1) {
                return;
            } else {
                bVar.f2186a.g();
            }
            removeAndRecycleView(childAt, pVar);
        }
    }

    private boolean k(int i) {
        if (this.j == 0) {
            return (i == -1) != this.f2178e;
        }
        return ((i == -1) == this.f2178e) == e();
    }

    private e a(o oVar) {
        int i;
        int i2;
        int i3 = -1;
        if (k(oVar.f2358e)) {
            i = this.i - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.i;
            i2 = 1;
        }
        e eVar = null;
        if (oVar.f2358e == 1) {
            int i4 = Integer.MAX_VALUE;
            int c2 = this.f2175b.c();
            while (i != i3) {
                e eVar2 = this.f2174a[i];
                int b2 = eVar2.b(c2);
                if (b2 < i4) {
                    eVar = eVar2;
                    i4 = b2;
                }
                i += i2;
            }
            return eVar;
        }
        int i5 = Integer.MIN_VALUE;
        int d2 = this.f2175b.d();
        while (i != i3) {
            e eVar3 = this.f2174a[i];
            int a2 = eVar3.a(d2);
            if (a2 > i5) {
                eVar = eVar3;
                i5 = a2;
            }
            i += i2;
        }
        return eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean canScrollVertically() {
        return this.j == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean canScrollHorizontally() {
        return this.j == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int scrollHorizontallyBy(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        return a(i, pVar, uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int scrollVerticallyBy(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        return a(i, pVar, uVar);
    }

    private int l(int i) {
        if (getChildCount() == 0) {
            return this.f2178e ? 1 : -1;
        }
        return (i < j()) != this.f2178e ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t.b
    public PointF computeScrollVectorForPosition(int i) {
        int l = l(i);
        PointF pointF = new PointF();
        if (l == 0) {
            return null;
        }
        if (this.j == 0) {
            pointF.x = l;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = l;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.u uVar, int i) {
        p pVar = new p(recyclerView.getContext());
        pVar.setTargetPosition(i);
        startSmoothScroll(pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void scrollToPosition(int i) {
        d dVar = this.f2179q;
        if (dVar != null && dVar.f2194a != i) {
            this.f2179q.b();
        }
        this.f = i;
        this.g = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.u uVar, RecyclerView.i.a aVar) {
        int b2;
        int i3;
        if (this.j != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        a(i, uVar);
        int[] iArr = this.w;
        if (iArr == null || iArr.length < this.i) {
            this.w = new int[this.i];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.i; i5++) {
            if (this.l.f2357d == -1) {
                b2 = this.l.f;
                i3 = this.f2174a[i5].a(this.l.f);
            } else {
                b2 = this.f2174a[i5].b(this.l.g);
                i3 = this.l.g;
            }
            int i6 = b2 - i3;
            if (i6 >= 0) {
                this.w[i4] = i6;
                i4++;
            }
        }
        Arrays.sort(this.w, 0, i4);
        for (int i7 = 0; i7 < i4 && this.l.a(uVar); i7++) {
            aVar.b(this.l.f2356c, this.w[i7]);
            this.l.f2356c += this.l.f2357d;
        }
    }

    void a(int i, RecyclerView.u uVar) {
        int j;
        int i2;
        if (i > 0) {
            j = i();
            i2 = 1;
        } else {
            j = j();
            i2 = -1;
        }
        this.l.f2354a = true;
        b(j, uVar);
        d(i2);
        o oVar = this.l;
        oVar.f2356c = j + oVar.f2357d;
        this.l.f2355b = Math.abs(i);
    }

    int a(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        a(i, uVar);
        int a2 = a(pVar, this.l, uVar);
        if (this.l.f2355b >= a2) {
            i = i < 0 ? -a2 : a2;
        }
        this.f2175b.a(-i);
        this.o = this.f2178e;
        this.l.f2355b = 0;
        a(pVar, this.l);
        return i;
    }

    int i() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    int j() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    private int m(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private int n(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j generateDefaultLayoutParams() {
        if (this.j == 0) {
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

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View onFocusSearchFailed(View view, int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        View findContainingItemView;
        int j;
        int k;
        int k2;
        int k3;
        View a2;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        l();
        int o = o(i);
        if (o == Integer.MIN_VALUE) {
            return null;
        }
        b bVar = (b) findContainingItemView.getLayoutParams();
        boolean z = bVar.f2187b;
        e eVar = bVar.f2186a;
        if (o == 1) {
            j = i();
        } else {
            j = j();
        }
        b(j, uVar);
        d(o);
        o oVar = this.l;
        oVar.f2356c = oVar.f2357d + j;
        this.l.f2355b = (int) (this.f2175b.f() * 0.33333334f);
        this.l.h = true;
        this.l.f2354a = false;
        a(pVar, this.l, uVar);
        this.o = this.f2178e;
        if (z || (a2 = eVar.a(j, o)) == null || a2 == findContainingItemView) {
            if (k(o)) {
                for (int i2 = this.i - 1; i2 >= 0; i2--) {
                    View a3 = this.f2174a[i2].a(j, o);
                    if (a3 != null && a3 != findContainingItemView) {
                        return a3;
                    }
                }
            } else {
                for (int i3 = 0; i3 < this.i; i3++) {
                    View a4 = this.f2174a[i3].a(j, o);
                    if (a4 != null && a4 != findContainingItemView) {
                        return a4;
                    }
                }
            }
            boolean z2 = (this.f2177d ^ true) == (o == -1);
            if (!z) {
                if (z2) {
                    k3 = eVar.j();
                } else {
                    k3 = eVar.k();
                }
                View findViewByPosition = findViewByPosition(k3);
                if (findViewByPosition != null && findViewByPosition != findContainingItemView) {
                    return findViewByPosition;
                }
            }
            if (k(o)) {
                for (int i4 = this.i - 1; i4 >= 0; i4--) {
                    if (i4 != eVar.f2203e) {
                        if (z2) {
                            k2 = this.f2174a[i4].j();
                        } else {
                            k2 = this.f2174a[i4].k();
                        }
                        View findViewByPosition2 = findViewByPosition(k2);
                        if (findViewByPosition2 != null && findViewByPosition2 != findContainingItemView) {
                            return findViewByPosition2;
                        }
                    }
                }
            } else {
                for (int i5 = 0; i5 < this.i; i5++) {
                    if (z2) {
                        k = this.f2174a[i5].j();
                    } else {
                        k = this.f2174a[i5].k();
                    }
                    View findViewByPosition3 = findViewByPosition(k);
                    if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                        return findViewByPosition3;
                    }
                }
            }
            return null;
        }
        return a2;
    }

    private int o(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.j == 1) ? 1 : Integer.MIN_VALUE : this.j == 0 ? 1 : Integer.MIN_VALUE : this.j == 1 ? -1 : Integer.MIN_VALUE : this.j == 0 ? -1 : Integer.MIN_VALUE : (this.j != 1 && e()) ? -1 : 1 : (this.j != 1 && e()) ? 1 : -1;
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.j {

        /* renamed from: a  reason: collision with root package name */
        e f2186a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2187b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void a(boolean z) {
            this.f2187b = z;
        }

        public boolean a() {
            return this.f2187b;
        }

        public final int b() {
            e eVar = this.f2186a;
            if (eVar == null) {
                return -1;
            }
            return eVar.f2203e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f2199a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f2200b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f2201c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f2202d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f2203e;

        e(int i) {
            this.f2203e = i;
        }

        int a(int i) {
            int i2 = this.f2200b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f2199a.size() == 0) {
                return i;
            }
            a();
            return this.f2200b;
        }

        void a() {
            c.a f;
            View view = this.f2199a.get(0);
            b c2 = c(view);
            this.f2200b = StaggeredGridLayoutManager.this.f2175b.a(view);
            if (c2.f2187b && (f = StaggeredGridLayoutManager.this.h.f(c2.f())) != null && f.f2191b == -1) {
                this.f2200b -= f.a(this.f2203e);
            }
        }

        int b() {
            int i = this.f2200b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            a();
            return this.f2200b;
        }

        int b(int i) {
            int i2 = this.f2201c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f2199a.size() == 0) {
                return i;
            }
            c();
            return this.f2201c;
        }

        void c() {
            c.a f;
            ArrayList<View> arrayList = this.f2199a;
            View view = arrayList.get(arrayList.size() - 1);
            b c2 = c(view);
            this.f2201c = StaggeredGridLayoutManager.this.f2175b.b(view);
            if (c2.f2187b && (f = StaggeredGridLayoutManager.this.h.f(c2.f())) != null && f.f2191b == 1) {
                this.f2201c += f.a(this.f2203e);
            }
        }

        int d() {
            int i = this.f2201c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            c();
            return this.f2201c;
        }

        void a(View view) {
            b c2 = c(view);
            c2.f2186a = this;
            this.f2199a.add(0, view);
            this.f2200b = Integer.MIN_VALUE;
            if (this.f2199a.size() == 1) {
                this.f2201c = Integer.MIN_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.f2202d += StaggeredGridLayoutManager.this.f2175b.e(view);
            }
        }

        void b(View view) {
            b c2 = c(view);
            c2.f2186a = this;
            this.f2199a.add(view);
            this.f2201c = Integer.MIN_VALUE;
            if (this.f2199a.size() == 1) {
                this.f2200b = Integer.MIN_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.f2202d += StaggeredGridLayoutManager.this.f2175b.e(view);
            }
        }

        void a(boolean z, int i) {
            int a2;
            if (z) {
                a2 = b(Integer.MIN_VALUE);
            } else {
                a2 = a(Integer.MIN_VALUE);
            }
            e();
            if (a2 == Integer.MIN_VALUE) {
                return;
            }
            if (!z || a2 >= StaggeredGridLayoutManager.this.f2175b.d()) {
                if (z || a2 <= StaggeredGridLayoutManager.this.f2175b.c()) {
                    if (i != Integer.MIN_VALUE) {
                        a2 += i;
                    }
                    this.f2201c = a2;
                    this.f2200b = a2;
                }
            }
        }

        void e() {
            this.f2199a.clear();
            f();
            this.f2202d = 0;
        }

        void f() {
            this.f2200b = Integer.MIN_VALUE;
            this.f2201c = Integer.MIN_VALUE;
        }

        void c(int i) {
            this.f2200b = i;
            this.f2201c = i;
        }

        void g() {
            int size = this.f2199a.size();
            View remove = this.f2199a.remove(size - 1);
            b c2 = c(remove);
            c2.f2186a = null;
            if (c2.d() || c2.e()) {
                this.f2202d -= StaggeredGridLayoutManager.this.f2175b.e(remove);
            }
            if (size == 1) {
                this.f2200b = Integer.MIN_VALUE;
            }
            this.f2201c = Integer.MIN_VALUE;
        }

        void h() {
            View remove = this.f2199a.remove(0);
            b c2 = c(remove);
            c2.f2186a = null;
            if (this.f2199a.size() == 0) {
                this.f2201c = Integer.MIN_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.f2202d -= StaggeredGridLayoutManager.this.f2175b.e(remove);
            }
            this.f2200b = Integer.MIN_VALUE;
        }

        public int i() {
            return this.f2202d;
        }

        b c(View view) {
            return (b) view.getLayoutParams();
        }

        void d(int i) {
            int i2 = this.f2200b;
            if (i2 != Integer.MIN_VALUE) {
                this.f2200b = i2 + i;
            }
            int i3 = this.f2201c;
            if (i3 != Integer.MIN_VALUE) {
                this.f2201c = i3 + i;
            }
        }

        public int j() {
            if (StaggeredGridLayoutManager.this.f2177d) {
                return b(this.f2199a.size() - 1, -1, true);
            }
            return b(0, this.f2199a.size(), true);
        }

        public int k() {
            if (StaggeredGridLayoutManager.this.f2177d) {
                return b(0, this.f2199a.size(), true);
            }
            return b(this.f2199a.size() - 1, -1, true);
        }

        public int l() {
            if (StaggeredGridLayoutManager.this.f2177d) {
                return a(0, this.f2199a.size(), true);
            }
            return a(this.f2199a.size() - 1, -1, true);
        }

        int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int c2 = StaggeredGridLayoutManager.this.f2175b.c();
            int d2 = StaggeredGridLayoutManager.this.f2175b.d();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f2199a.get(i);
                int a2 = StaggeredGridLayoutManager.this.f2175b.a(view);
                int b2 = StaggeredGridLayoutManager.this.f2175b.b(view);
                boolean z4 = false;
                boolean z5 = !z3 ? a2 >= d2 : a2 > d2;
                if (!z3 ? b2 > c2 : b2 >= c2) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (a2 >= c2 && b2 <= d2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (z2) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    } else {
                        if (a2 < c2 || b2 > d2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        int a(int i, int i2, boolean z) {
            return a(i, i2, z, true, false);
        }

        int b(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.f2199a.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.f2199a.get(i3);
                    if ((StaggeredGridLayoutManager.this.f2177d && StaggeredGridLayoutManager.this.getPosition(view2) <= i) || ((!StaggeredGridLayoutManager.this.f2177d && StaggeredGridLayoutManager.this.getPosition(view2) >= i) || !view2.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.f2199a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.f2199a.get(size2);
                    if ((StaggeredGridLayoutManager.this.f2177d && StaggeredGridLayoutManager.this.getPosition(view3) >= i) || ((!StaggeredGridLayoutManager.this.f2177d && StaggeredGridLayoutManager.this.getPosition(view3) <= i) || !view3.hasFocusable())) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        int[] f2188a;

        /* renamed from: b  reason: collision with root package name */
        List<a> f2189b;

        c() {
        }

        int a(int i) {
            List<a> list = this.f2189b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f2189b.get(size).f2190a >= i) {
                        this.f2189b.remove(size);
                    }
                }
            }
            return b(i);
        }

        int b(int i) {
            int[] iArr = this.f2188a;
            if (iArr != null && i < iArr.length) {
                int g = g(i);
                if (g == -1) {
                    int[] iArr2 = this.f2188a;
                    Arrays.fill(iArr2, i, iArr2.length, -1);
                    return this.f2188a.length;
                }
                int i2 = g + 1;
                Arrays.fill(this.f2188a, i, i2, -1);
                return i2;
            }
            return -1;
        }

        int c(int i) {
            int[] iArr = this.f2188a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        void a(int i, e eVar) {
            e(i);
            this.f2188a[i] = eVar.f2203e;
        }

        int d(int i) {
            int length = this.f2188a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void e(int i) {
            int[] iArr = this.f2188a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.f2188a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[d(i)];
                this.f2188a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f2188a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        void a() {
            int[] iArr = this.f2188a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2189b = null;
        }

        void a(int i, int i2) {
            int[] iArr = this.f2188a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            e(i3);
            int[] iArr2 = this.f2188a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.f2188a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            c(i, i2);
        }

        private void c(int i, int i2) {
            List<a> list = this.f2189b;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f2189b.get(size);
                if (aVar.f2190a >= i) {
                    if (aVar.f2190a < i3) {
                        this.f2189b.remove(size);
                    } else {
                        aVar.f2190a -= i2;
                    }
                }
            }
        }

        void b(int i, int i2) {
            int[] iArr = this.f2188a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            e(i3);
            int[] iArr2 = this.f2188a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.f2188a, i, i3, -1);
            d(i, i2);
        }

        private void d(int i, int i2) {
            List<a> list = this.f2189b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f2189b.get(size);
                if (aVar.f2190a >= i) {
                    aVar.f2190a += i2;
                }
            }
        }

        private int g(int i) {
            if (this.f2189b == null) {
                return -1;
            }
            a f = f(i);
            if (f != null) {
                this.f2189b.remove(f);
            }
            int size = this.f2189b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f2189b.get(i2).f2190a >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                this.f2189b.remove(i2);
                return this.f2189b.get(i2).f2190a;
            }
            return -1;
        }

        public void a(a aVar) {
            if (this.f2189b == null) {
                this.f2189b = new ArrayList();
            }
            int size = this.f2189b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.f2189b.get(i);
                if (aVar2.f2190a == aVar.f2190a) {
                    this.f2189b.remove(i);
                }
                if (aVar2.f2190a >= aVar.f2190a) {
                    this.f2189b.add(i, aVar);
                    return;
                }
            }
            this.f2189b.add(aVar);
        }

        public a f(int i) {
            List<a> list = this.f2189b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f2189b.get(size);
                if (aVar.f2190a == i) {
                    return aVar;
                }
            }
            return null;
        }

        public a a(int i, int i2, int i3, boolean z) {
            List<a> list = this.f2189b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f2189b.get(i4);
                if (aVar.f2190a >= i2) {
                    return null;
                }
                if (aVar.f2190a >= i && (i3 == 0 || aVar.f2191b == i3 || (z && aVar.f2193d))) {
                    return aVar;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.c.a.1
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public a[] newArray(int i) {
                    return new a[i];
                }
            };

            /* renamed from: a  reason: collision with root package name */
            int f2190a;

            /* renamed from: b  reason: collision with root package name */
            int f2191b;

            /* renamed from: c  reason: collision with root package name */
            int[] f2192c;

            /* renamed from: d  reason: collision with root package name */
            boolean f2193d;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            a(Parcel parcel) {
                this.f2190a = parcel.readInt();
                this.f2191b = parcel.readInt();
                this.f2193d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f2192c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            a() {
            }

            int a(int i) {
                int[] iArr = this.f2192c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f2190a);
                parcel.writeInt(this.f2191b);
                parcel.writeInt(this.f2193d ? 1 : 0);
                int[] iArr = this.f2192c;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f2192c);
                    return;
                }
                parcel.writeInt(0);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f2190a + ", mGapDir=" + this.f2191b + ", mHasUnwantedGapAfter=" + this.f2193d + ", mGapPerSpan=" + Arrays.toString(this.f2192c) + '}';
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.d.1
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
        int f2194a;

        /* renamed from: b  reason: collision with root package name */
        int f2195b;

        /* renamed from: c  reason: collision with root package name */
        int f2196c;

        /* renamed from: d  reason: collision with root package name */
        int[] f2197d;

        /* renamed from: e  reason: collision with root package name */
        int f2198e;
        int[] f;
        List<c.a> g;
        boolean h;
        boolean i;
        boolean j;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public d() {
        }

        d(Parcel parcel) {
            this.f2194a = parcel.readInt();
            this.f2195b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f2196c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f2197d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f2198e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.g = parcel.readArrayList(c.a.class.getClassLoader());
        }

        public d(d dVar) {
            this.f2196c = dVar.f2196c;
            this.f2194a = dVar.f2194a;
            this.f2195b = dVar.f2195b;
            this.f2197d = dVar.f2197d;
            this.f2198e = dVar.f2198e;
            this.f = dVar.f;
            this.h = dVar.h;
            this.i = dVar.i;
            this.j = dVar.j;
            this.g = dVar.g;
        }

        void a() {
            this.f2197d = null;
            this.f2196c = 0;
            this.f2198e = 0;
            this.f = null;
            this.g = null;
        }

        void b() {
            this.f2197d = null;
            this.f2196c = 0;
            this.f2194a = -1;
            this.f2195b = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2194a);
            parcel.writeInt(this.f2195b);
            parcel.writeInt(this.f2196c);
            if (this.f2196c > 0) {
                parcel.writeIntArray(this.f2197d);
            }
            parcel.writeInt(this.f2198e);
            if (this.f2198e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        int f2181a;

        /* renamed from: b  reason: collision with root package name */
        int f2182b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2183c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2184d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2185e;
        int[] f;

        a() {
            a();
        }

        void a() {
            this.f2181a = -1;
            this.f2182b = Integer.MIN_VALUE;
            this.f2183c = false;
            this.f2184d = false;
            this.f2185e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void a(e[] eVarArr) {
            int length = eVarArr.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.f2174a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = eVarArr[i].a(Integer.MIN_VALUE);
            }
        }

        void b() {
            this.f2182b = this.f2183c ? StaggeredGridLayoutManager.this.f2175b.d() : StaggeredGridLayoutManager.this.f2175b.c();
        }

        void a(int i) {
            if (this.f2183c) {
                this.f2182b = StaggeredGridLayoutManager.this.f2175b.d() - i;
            } else {
                this.f2182b = StaggeredGridLayoutManager.this.f2175b.c() + i;
            }
        }
    }
}
