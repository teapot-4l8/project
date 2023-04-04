package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: OrientationHelper.java */
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.i f2360a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f2361b;

    /* renamed from: c  reason: collision with root package name */
    private int f2362c;

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public abstract int h();

    public abstract int i();

    private s(RecyclerView.i iVar) {
        this.f2362c = Integer.MIN_VALUE;
        this.f2361b = new Rect();
        this.f2360a = iVar;
    }

    public void a() {
        this.f2362c = f();
    }

    public int b() {
        if (Integer.MIN_VALUE == this.f2362c) {
            return 0;
        }
        return f() - this.f2362c;
    }

    public static s a(RecyclerView.i iVar, int i) {
        if (i != 0) {
            if (i == 1) {
                return b(iVar);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return a(iVar);
    }

    public static s a(RecyclerView.i iVar) {
        return new s(iVar) { // from class: androidx.recyclerview.widget.s.1
            @Override // androidx.recyclerview.widget.s
            public int d() {
                return this.f2360a.getWidth() - this.f2360a.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.s
            public int e() {
                return this.f2360a.getWidth();
            }

            @Override // androidx.recyclerview.widget.s
            public void a(int i) {
                this.f2360a.offsetChildrenHorizontal(i);
            }

            @Override // androidx.recyclerview.widget.s
            public int c() {
                return this.f2360a.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.s
            public int e(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f2360a.getDecoratedMeasuredWidth(view) + jVar.leftMargin + jVar.rightMargin;
            }

            @Override // androidx.recyclerview.widget.s
            public int f(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f2360a.getDecoratedMeasuredHeight(view) + jVar.topMargin + jVar.bottomMargin;
            }

            @Override // androidx.recyclerview.widget.s
            public int b(View view) {
                return this.f2360a.getDecoratedRight(view) + ((RecyclerView.j) view.getLayoutParams()).rightMargin;
            }

            @Override // androidx.recyclerview.widget.s
            public int a(View view) {
                return this.f2360a.getDecoratedLeft(view) - ((RecyclerView.j) view.getLayoutParams()).leftMargin;
            }

            @Override // androidx.recyclerview.widget.s
            public int c(View view) {
                this.f2360a.getTransformedBoundingBox(view, true, this.f2361b);
                return this.f2361b.right;
            }

            @Override // androidx.recyclerview.widget.s
            public int d(View view) {
                this.f2360a.getTransformedBoundingBox(view, true, this.f2361b);
                return this.f2361b.left;
            }

            @Override // androidx.recyclerview.widget.s
            public int f() {
                return (this.f2360a.getWidth() - this.f2360a.getPaddingLeft()) - this.f2360a.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.s
            public int g() {
                return this.f2360a.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.s
            public int h() {
                return this.f2360a.getWidthMode();
            }

            @Override // androidx.recyclerview.widget.s
            public int i() {
                return this.f2360a.getHeightMode();
            }
        };
    }

    public static s b(RecyclerView.i iVar) {
        return new s(iVar) { // from class: androidx.recyclerview.widget.s.2
            @Override // androidx.recyclerview.widget.s
            public int d() {
                return this.f2360a.getHeight() - this.f2360a.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.s
            public int e() {
                return this.f2360a.getHeight();
            }

            @Override // androidx.recyclerview.widget.s
            public void a(int i) {
                this.f2360a.offsetChildrenVertical(i);
            }

            @Override // androidx.recyclerview.widget.s
            public int c() {
                return this.f2360a.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.s
            public int e(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f2360a.getDecoratedMeasuredHeight(view) + jVar.topMargin + jVar.bottomMargin;
            }

            @Override // androidx.recyclerview.widget.s
            public int f(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f2360a.getDecoratedMeasuredWidth(view) + jVar.leftMargin + jVar.rightMargin;
            }

            @Override // androidx.recyclerview.widget.s
            public int b(View view) {
                return this.f2360a.getDecoratedBottom(view) + ((RecyclerView.j) view.getLayoutParams()).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.s
            public int a(View view) {
                return this.f2360a.getDecoratedTop(view) - ((RecyclerView.j) view.getLayoutParams()).topMargin;
            }

            @Override // androidx.recyclerview.widget.s
            public int c(View view) {
                this.f2360a.getTransformedBoundingBox(view, true, this.f2361b);
                return this.f2361b.bottom;
            }

            @Override // androidx.recyclerview.widget.s
            public int d(View view) {
                this.f2360a.getTransformedBoundingBox(view, true, this.f2361b);
                return this.f2361b.top;
            }

            @Override // androidx.recyclerview.widget.s
            public int f() {
                return (this.f2360a.getHeight() - this.f2360a.getPaddingTop()) - this.f2360a.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.s
            public int g() {
                return this.f2360a.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.s
            public int h() {
                return this.f2360a.getHeightMode();
            }

            @Override // androidx.recyclerview.widget.s
            public int i() {
                return this.f2360a.getWidthMode();
            }
        };
    }
}
