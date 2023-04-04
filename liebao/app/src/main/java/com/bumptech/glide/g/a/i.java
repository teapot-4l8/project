package com.bumptech.glide.g.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ViewTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class i<T extends View, Z> extends com.bumptech.glide.g.a.a<Z> {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5184b;

    /* renamed from: c  reason: collision with root package name */
    private static Integer f5185c;

    /* renamed from: a  reason: collision with root package name */
    protected final T f5186a;

    /* renamed from: d  reason: collision with root package name */
    private final a f5187d;

    /* renamed from: e  reason: collision with root package name */
    private View.OnAttachStateChangeListener f5188e;
    private boolean f;
    private boolean g;

    public i(T t) {
        this.f5186a = (T) com.bumptech.glide.i.i.a(t);
        this.f5187d = new a(t);
    }

    @Override // com.bumptech.glide.g.a.a, com.bumptech.glide.g.a.h
    public void b(Drawable drawable) {
        super.b(drawable);
        a();
    }

    private void a() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f5188e;
        if (onAttachStateChangeListener == null || this.g) {
            return;
        }
        this.f5186a.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.g = true;
    }

    private void f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f5188e;
        if (onAttachStateChangeListener == null || !this.g) {
            return;
        }
        this.f5186a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.g = false;
    }

    @Override // com.bumptech.glide.g.a.h
    public void a(g gVar) {
        this.f5187d.a(gVar);
    }

    @Override // com.bumptech.glide.g.a.h
    public void b(g gVar) {
        this.f5187d.b(gVar);
    }

    @Override // com.bumptech.glide.g.a.a, com.bumptech.glide.g.a.h
    public void a(Drawable drawable) {
        super.a(drawable);
        this.f5187d.b();
        if (this.f) {
            return;
        }
        f();
    }

    @Override // com.bumptech.glide.g.a.a, com.bumptech.glide.g.a.h
    public void a(com.bumptech.glide.g.b bVar) {
        a((Object) bVar);
    }

    @Override // com.bumptech.glide.g.a.a, com.bumptech.glide.g.a.h
    public com.bumptech.glide.g.b b() {
        Object g = g();
        if (g != null) {
            if (g instanceof com.bumptech.glide.g.b) {
                return (com.bumptech.glide.g.b) g;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    public String toString() {
        return "Target for: " + this.f5186a;
    }

    private void a(Object obj) {
        Integer num = f5185c;
        if (num == null) {
            f5184b = true;
            this.f5186a.setTag(obj);
            return;
        }
        this.f5186a.setTag(num.intValue(), obj);
    }

    private Object g() {
        Integer num = f5185c;
        if (num == null) {
            return this.f5186a.getTag();
        }
        return this.f5186a.getTag(num.intValue());
    }

    /* compiled from: ViewTarget.java */
    /* loaded from: classes.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        static Integer f5189a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5190b;

        /* renamed from: c  reason: collision with root package name */
        private final View f5191c;

        /* renamed from: d  reason: collision with root package name */
        private final List<g> f5192d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private ViewTreeObserver$OnPreDrawListenerC0096a f5193e;

        private boolean a(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        a(View view) {
            this.f5191c = view;
        }

        private static int a(Context context) {
            if (f5189a == null) {
                Display defaultDisplay = ((WindowManager) com.bumptech.glide.i.i.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f5189a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f5189a.intValue();
        }

        private void a(int i, int i2) {
            Iterator it = new ArrayList(this.f5192d).iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(i, i2);
            }
        }

        void a() {
            if (this.f5192d.isEmpty()) {
                return;
            }
            int d2 = d();
            int c2 = c();
            if (b(d2, c2)) {
                a(d2, c2);
                b();
            }
        }

        void a(g gVar) {
            int d2 = d();
            int c2 = c();
            if (b(d2, c2)) {
                gVar.a(d2, c2);
                return;
            }
            if (!this.f5192d.contains(gVar)) {
                this.f5192d.add(gVar);
            }
            if (this.f5193e == null) {
                ViewTreeObserver viewTreeObserver = this.f5191c.getViewTreeObserver();
                ViewTreeObserver$OnPreDrawListenerC0096a viewTreeObserver$OnPreDrawListenerC0096a = new ViewTreeObserver$OnPreDrawListenerC0096a(this);
                this.f5193e = viewTreeObserver$OnPreDrawListenerC0096a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserver$OnPreDrawListenerC0096a);
            }
        }

        void b(g gVar) {
            this.f5192d.remove(gVar);
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f5191c.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f5193e);
            }
            this.f5193e = null;
            this.f5192d.clear();
        }

        private boolean b(int i, int i2) {
            return a(i) && a(i2);
        }

        private int c() {
            int paddingTop = this.f5191c.getPaddingTop() + this.f5191c.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f5191c.getLayoutParams();
            return a(this.f5191c.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.f5191c.getPaddingLeft() + this.f5191c.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f5191c.getLayoutParams();
            return a(this.f5191c.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private int a(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f5190b && this.f5191c.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f5191c.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f5191c.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ViewTarget.java */
        /* renamed from: com.bumptech.glide.g.a.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC0096a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f5194a;

            ViewTreeObserver$OnPreDrawListenerC0096a(a aVar) {
                this.f5194a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f5194a.get();
                if (aVar != null) {
                    aVar.a();
                    return true;
                }
                return true;
            }
        }
    }
}
