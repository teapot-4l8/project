package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: DividerItemDecoration.java */
/* loaded from: classes.dex */
public class i extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2306a = {16843284};

    /* renamed from: b  reason: collision with root package name */
    private Drawable f2307b;

    /* renamed from: c  reason: collision with root package name */
    private int f2308c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f2309d = new Rect();

    public i(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f2306a);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.f2307b = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        a(i);
    }

    public void a(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.f2308c = i;
    }

    public void a(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.f2307b = drawable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.u uVar) {
        if (recyclerView.getLayoutManager() == null || this.f2307b == null) {
            return;
        }
        if (this.f2308c == 1) {
            a(canvas, recyclerView);
        } else {
            b(canvas, recyclerView);
        }
    }

    private void a(Canvas canvas, RecyclerView recyclerView) {
        int width;
        int i;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            i = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.f2309d);
            int round = this.f2309d.bottom + Math.round(childAt.getTranslationY());
            this.f2307b.setBounds(i, round - this.f2307b.getIntrinsicHeight(), width, round);
            this.f2307b.draw(canvas);
        }
        canvas.restore();
    }

    private void b(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int i;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            i = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.f2309d);
            int round = this.f2309d.right + Math.round(childAt.getTranslationX());
            this.f2307b.setBounds(round - this.f2307b.getIntrinsicWidth(), i, round, height);
            this.f2307b.draw(canvas);
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.u uVar) {
        Drawable drawable = this.f2307b;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f2308c == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }
}
