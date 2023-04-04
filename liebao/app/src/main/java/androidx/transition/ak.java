package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewOverlayApi14.java */
/* loaded from: classes.dex */
public class ak implements am {

    /* renamed from: a  reason: collision with root package name */
    protected a f2524a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(Context context, ViewGroup viewGroup, View view) {
        this.f2524a = new a(context, viewGroup, view, this);
    }

    static ViewGroup c(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ak d(View view) {
        ViewGroup c2 = c(view);
        if (c2 != null) {
            int childCount = c2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = c2.getChildAt(i);
                if (childAt instanceof a) {
                    return ((a) childAt).f2529e;
                }
            }
            return new ae(c2.getContext(), c2, view);
        }
        return null;
    }

    @Override // androidx.transition.am
    public void a(Drawable drawable) {
        this.f2524a.a(drawable);
    }

    @Override // androidx.transition.am
    public void b(Drawable drawable) {
        this.f2524a.b(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewOverlayApi14.java */
    /* loaded from: classes.dex */
    public static class a extends ViewGroup {

        /* renamed from: a  reason: collision with root package name */
        static Method f2525a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f2526b;

        /* renamed from: c  reason: collision with root package name */
        View f2527c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Drawable> f2528d;

        /* renamed from: e  reason: collision with root package name */
        ak f2529e;

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        static {
            try {
                f2525a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, ak akVar) {
            super(context);
            this.f2528d = null;
            this.f2526b = viewGroup;
            this.f2527c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f2529e = akVar;
        }

        public void a(Drawable drawable) {
            if (this.f2528d == null) {
                this.f2528d = new ArrayList<>();
            }
            if (this.f2528d.contains(drawable)) {
                return;
            }
            this.f2528d.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f2528d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
            }
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f2528d) != null && arrayList.contains(drawable));
        }

        public void a(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f2526b && viewGroup.getParent() != null && androidx.core.h.w.D(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f2526b.getLocationOnScreen(iArr2);
                    androidx.core.h.w.g(view, iArr[0] - iArr2[0]);
                    androidx.core.h.w.f(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        public void b(View view) {
            super.removeView(view);
            if (a()) {
                this.f2526b.removeView(this);
            }
        }

        boolean a() {
            ArrayList<Drawable> arrayList;
            return getChildCount() == 0 && ((arrayList = this.f2528d) == null || arrayList.size() == 0);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f2526b.getLocationOnScreen(iArr);
            this.f2527c.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.f2527c.getWidth(), this.f2527c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f2528d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f2528d.get(i).draw(canvas);
            }
        }

        private void a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f2526b.getLocationOnScreen(iArr2);
            this.f2527c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f2526b != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.f2526b instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    a(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
                return null;
            }
            return null;
        }
    }
}
