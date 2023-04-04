package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* compiled from: GhostViewApi14.java */
/* loaded from: classes.dex */
class i extends View implements k {

    /* renamed from: a  reason: collision with root package name */
    final View f2634a;

    /* renamed from: b  reason: collision with root package name */
    ViewGroup f2635b;

    /* renamed from: c  reason: collision with root package name */
    View f2636c;

    /* renamed from: d  reason: collision with root package name */
    int f2637d;

    /* renamed from: e  reason: collision with root package name */
    Matrix f2638e;
    private int f;
    private int g;
    private final Matrix h;
    private final ViewTreeObserver.OnPreDrawListener i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k a(View view, ViewGroup viewGroup) {
        i b2 = b(view);
        if (b2 == null) {
            FrameLayout a2 = a(viewGroup);
            if (a2 == null) {
                return null;
            }
            b2 = new i(view);
            a2.addView(b2);
        }
        b2.f2637d++;
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        i b2 = b(view);
        if (b2 != null) {
            int i = b2.f2637d - 1;
            b2.f2637d = i;
            if (i <= 0) {
                ViewParent parent = b2.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    viewGroup.endViewTransition(b2);
                    viewGroup.removeView(b2);
                }
            }
        }
    }

    private static FrameLayout a(ViewGroup viewGroup) {
        while (!(viewGroup instanceof FrameLayout)) {
            ViewParent parent = viewGroup.getParent();
            if (!(parent instanceof ViewGroup)) {
                return null;
            }
            viewGroup = (ViewGroup) parent;
        }
        return (FrameLayout) viewGroup;
    }

    i(View view) {
        super(view.getContext());
        this.h = new Matrix();
        this.i = new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.transition.i.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                i iVar = i.this;
                iVar.f2638e = iVar.f2634a.getMatrix();
                androidx.core.h.w.e(i.this);
                if (i.this.f2635b == null || i.this.f2636c == null) {
                    return true;
                }
                i.this.f2635b.endViewTransition(i.this.f2636c);
                androidx.core.h.w.e(i.this.f2635b);
                i.this.f2635b = null;
                i.this.f2636c = null;
                return true;
            }
        };
        this.f2634a = view;
        setLayerType(2, null);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(this.f2634a, this);
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.f2634a.getLocationOnScreen(r0);
        int[] iArr2 = {(int) (iArr2[0] - this.f2634a.getTranslationX()), (int) (iArr2[1] - this.f2634a.getTranslationY())};
        this.f = iArr2[0] - iArr[0];
        this.g = iArr2[1] - iArr[1];
        this.f2634a.getViewTreeObserver().addOnPreDrawListener(this.i);
        this.f2634a.setVisibility(4);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f2634a.getViewTreeObserver().removeOnPreDrawListener(this.i);
        this.f2634a.setVisibility(0);
        a(this.f2634a, (i) null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.h.set(this.f2638e);
        this.h.postTranslate(this.f, this.g);
        canvas.setMatrix(this.h);
        this.f2634a.draw(canvas);
    }

    @Override // android.view.View, androidx.transition.k
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.f2634a.setVisibility(i == 0 ? 4 : 0);
    }

    @Override // androidx.transition.k
    public void a(ViewGroup viewGroup, View view) {
        this.f2635b = viewGroup;
        this.f2636c = view;
    }

    private static void a(View view, i iVar) {
        view.setTag(R.id.ghost_view, iVar);
    }

    static i b(View view) {
        return (i) view.getTag(R.id.ghost_view);
    }
}
