package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: ChangeBounds.java */
/* loaded from: classes.dex */
public class c extends w {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f2565a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: b  reason: collision with root package name */
    private static final Property<Drawable, PointF> f2566b = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") { // from class: androidx.transition.c.1

        /* renamed from: a  reason: collision with root package name */
        private Rect f2570a = new Rect();

        @Override // android.util.Property
        /* renamed from: a */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f2570a);
            this.f2570a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f2570a);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f2570a);
            return new PointF(this.f2570a.left, this.f2570a.top);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final Property<a, PointF> f2567c = new Property<a, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.c.3
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(a aVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(a aVar, PointF pointF) {
            aVar.a(pointF);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final Property<a, PointF> f2568d = new Property<a, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.c.4
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(a aVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(a aVar, PointF pointF) {
            aVar.b(pointF);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final Property<View, PointF> f2569e = new Property<View, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.c.5
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, PointF pointF) {
            an.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> f = new Property<View, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.c.6
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, PointF pointF) {
            an.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> g = new Property<View, PointF>(PointF.class, "position") { // from class: androidx.transition.c.7
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            an.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    private static t k = new t();
    private int[] h = new int[2];
    private boolean i = false;
    private boolean j = false;

    @Override // androidx.transition.w
    public String[] getTransitionProperties() {
        return f2565a;
    }

    private void a(ac acVar) {
        View view = acVar.f2510b;
        if (!androidx.core.h.w.A(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        acVar.f2509a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        acVar.f2509a.put("android:changeBounds:parent", acVar.f2510b.getParent());
        if (this.j) {
            acVar.f2510b.getLocationInWindow(this.h);
            acVar.f2509a.put("android:changeBounds:windowX", Integer.valueOf(this.h[0]));
            acVar.f2509a.put("android:changeBounds:windowY", Integer.valueOf(this.h[1]));
        }
        if (this.i) {
            acVar.f2509a.put("android:changeBounds:clip", androidx.core.h.w.C(view));
        }
    }

    @Override // androidx.transition.w
    public void captureStartValues(ac acVar) {
        a(acVar);
    }

    @Override // androidx.transition.w
    public void captureEndValues(ac acVar) {
        a(acVar);
    }

    private boolean a(View view, View view2) {
        if (this.j) {
            ac matchedTransitionValues = getMatchedTransitionValues(view, true);
            if (matchedTransitionValues == null) {
                if (view == view2) {
                    return true;
                }
            } else if (view2 == matchedTransitionValues.f2510b) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // androidx.transition.w
    public Animator createAnimator(final ViewGroup viewGroup, ac acVar, ac acVar2) {
        int i;
        final View view;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator a2;
        if (acVar == null || acVar2 == null) {
            return null;
        }
        Map<String, Object> map = acVar.f2509a;
        Map<String, Object> map2 = acVar2.f2509a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view2 = acVar2.f2510b;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) acVar.f2509a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) acVar2.f2509a.get("android:changeBounds:bounds");
            int i3 = rect2.left;
            final int i4 = rect3.left;
            int i5 = rect2.top;
            final int i6 = rect3.top;
            int i7 = rect2.right;
            final int i8 = rect3.right;
            int i9 = rect2.bottom;
            final int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            Rect rect4 = (Rect) acVar.f2509a.get("android:changeBounds:clip");
            final Rect rect5 = (Rect) acVar2.f2509a.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (i7 != i8 || i9 != i10) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i > 0) {
                if (!this.i) {
                    view = view2;
                    an.a(view, i3, i5, i7, i9);
                    if (i == 2) {
                        if (i11 == i13 && i12 == i14) {
                            a2 = o.a(view, g, getPathMotion().a(i3, i5, i4, i6));
                        } else {
                            final a aVar = new a(view);
                            ObjectAnimator a3 = o.a(aVar, f2567c, getPathMotion().a(i3, i5, i4, i6));
                            ObjectAnimator a4 = o.a(aVar, f2568d, getPathMotion().a(i7, i9, i8, i10));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(a3, a4);
                            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.c.8
                                private a mViewBounds;

                                {
                                    this.mViewBounds = aVar;
                                }
                            });
                            a2 = animatorSet;
                        }
                    } else if (i3 != i4 || i5 != i6) {
                        a2 = o.a(view, f, getPathMotion().a(i3, i5, i4, i6));
                    } else {
                        a2 = o.a(view, f2569e, getPathMotion().a(i7, i9, i8, i10));
                    }
                } else {
                    view = view2;
                    an.a(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                    ObjectAnimator a5 = (i3 == i4 && i5 == i6) ? null : o.a(view, g, getPathMotion().a(i3, i5, i4, i6));
                    if (rect4 == null) {
                        i2 = 0;
                        rect = new Rect(0, 0, i11, i12);
                    } else {
                        i2 = 0;
                        rect = rect4;
                    }
                    Rect rect6 = rect5 == null ? new Rect(i2, i2, i13, i14) : rect5;
                    if (rect.equals(rect6)) {
                        objectAnimator = null;
                    } else {
                        androidx.core.h.w.a(view, rect);
                        t tVar = k;
                        Object[] objArr = new Object[2];
                        objArr[i2] = rect;
                        objArr[1] = rect6;
                        ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", tVar, objArr);
                        ofObject.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.c.9
                            private boolean h;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                                this.h = true;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (this.h) {
                                    return;
                                }
                                androidx.core.h.w.a(view, rect5);
                                an.a(view, i4, i6, i8, i10);
                            }
                        });
                        objectAnimator = ofObject;
                    }
                    a2 = ab.a(a5, objectAnimator);
                }
                if (view.getParent() instanceof ViewGroup) {
                    final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    ah.a(viewGroup4, true);
                    addListener(new x() { // from class: androidx.transition.c.10

                        /* renamed from: a  reason: collision with root package name */
                        boolean f2571a = false;

                        @Override // androidx.transition.x, androidx.transition.w.d
                        public void a(w wVar) {
                            ah.a(viewGroup4, false);
                            this.f2571a = true;
                        }

                        @Override // androidx.transition.x, androidx.transition.w.d
                        public void b(w wVar) {
                            if (!this.f2571a) {
                                ah.a(viewGroup4, false);
                            }
                            wVar.removeListener(this);
                        }

                        @Override // androidx.transition.x, androidx.transition.w.d
                        public void c(w wVar) {
                            ah.a(viewGroup4, false);
                        }

                        @Override // androidx.transition.x, androidx.transition.w.d
                        public void d(w wVar) {
                            ah.a(viewGroup4, true);
                        }
                    });
                }
                return a2;
            }
            return null;
        }
        int intValue = ((Integer) acVar.f2509a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) acVar.f2509a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) acVar2.f2509a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) acVar2.f2509a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.h);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        final BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        final float c2 = an.c(view2);
        an.a(view2, 0.0f);
        an.a(viewGroup).a(bitmapDrawable);
        p pathMotion = getPathMotion();
        int[] iArr = this.h;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, s.a(f2566b, pathMotion.a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.c.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                an.a(viewGroup).b(bitmapDrawable);
                an.a(view2, c2);
            }
        });
        return ofPropertyValuesHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f2586a;

        /* renamed from: b  reason: collision with root package name */
        private int f2587b;

        /* renamed from: c  reason: collision with root package name */
        private int f2588c;

        /* renamed from: d  reason: collision with root package name */
        private int f2589d;

        /* renamed from: e  reason: collision with root package name */
        private View f2590e;
        private int f;
        private int g;

        a(View view) {
            this.f2590e = view;
        }

        void a(PointF pointF) {
            this.f2586a = Math.round(pointF.x);
            this.f2587b = Math.round(pointF.y);
            int i = this.f + 1;
            this.f = i;
            if (i == this.g) {
                a();
            }
        }

        void b(PointF pointF) {
            this.f2588c = Math.round(pointF.x);
            this.f2589d = Math.round(pointF.y);
            int i = this.g + 1;
            this.g = i;
            if (this.f == i) {
                a();
            }
        }

        private void a() {
            an.a(this.f2590e, this.f2586a, this.f2587b, this.f2588c, this.f2589d);
            this.f = 0;
            this.g = 0;
        }
    }
}
